package io.github.qpcrummer.utils;

import com.google.gson.Gson;
import io.github.qpcrummer.Ideate;
import io.github.qpcrummer.progression.Unlockable;
import io.github.qpcrummer.progression.UnlockableSerialized;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static final Path UNLOCKABLE_PATH = FabricLoader.getInstance().getConfigDir().resolve("ideate-unlockables/");
    public static final Path PATENTS_PATH = FabricLoader.getInstance().getConfigDir().resolve("ideate-patents.txt");
    public static Unlockable[] deserializeUnlockables() {
        Gson gson = new Gson();
        Unlockable[] unlockables = new Unlockable[getNumberOfFilesInPath()];

        int index = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(UNLOCKABLE_PATH)) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    try (Reader reader = Files.newBufferedReader(path)) {
                        UnlockableSerialized unlockable = gson.fromJson(reader, UnlockableSerialized.class);
                        unlockables[index++] = unlockable.deserialize();
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception as needed
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unlockables;
    }

    public static int getNumberOfFilesInPath() {
        try (var stream = Files.list(UNLOCKABLE_PATH)) {
            return (int) stream
                    .filter(Files::isRegularFile)
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isInPatentFile(ResourceLocation id) {
        return Ideate.patents.contains(id);
    }

    public static void createPatentFile() {
        if (Files.notExists(PATENTS_PATH)) {
            try {
                Files.createFile(PATENTS_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static List<ResourceLocation> readPatentFile() {
        try (var lines = Files.lines(PATENTS_PATH)) {
            return lines
                    .map(ResourceLocation::tryParse)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
            return List.of();
        }
    }
}
