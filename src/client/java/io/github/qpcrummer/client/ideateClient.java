package io.github.qpcrummer.client;

import io.github.qpcrummer.Ideate;
import io.github.qpcrummer.client.screen.FabricatorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class ideateClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MenuScreens.register(Ideate.FABRICATOR_SCREEN_HANDLER, FabricatorScreen::new);
    }
}
