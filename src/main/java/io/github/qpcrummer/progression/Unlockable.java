package io.github.qpcrummer.progression;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.qpcrummer.Ideate;
import io.github.qpcrummer.utils.Utils;
import net.minecraft.world.item.ItemStack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Unlockable {
    private final String name;
    private final List<ItemStack> criteria;
    private boolean completed = false;
    public Unlockable(String name, List<ItemStack> criteria, boolean completed) {
        this.name = name;
        this.criteria = criteria;
        this.completed = completed;
    }

    public boolean checkCompletion() {
        if (completed) {
            return true;
        } else {

        }
    }

    public void serialize() {
        GsonBuilder builder = new Gson()
                .newBuilder()
                .setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(toSerializable());

        try (FileWriter writer = new FileWriter(Utils.UNLOCKABLE_PATH.resolve(this.name + ".json").toString())) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    public UnlockableSerialized toSerializable() {
        List<ItemStackSerializable> serializableList = new ArrayList<>();
        for (ItemStack stack : criteria) {
            serializableList.add(new ItemStackSerializable(stack.getItem().toString(), stack.getCount()));
        }
        return new UnlockableSerialized(name, serializableList, completed);
    }
}
