package io.github.qpcrummer.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.qpcrummer.block.FabricatorScreenHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FabricatorScreen extends AbstractContainerScreen<FabricatorScreenHandler> {
    public FabricatorScreen(FabricatorScreenHandler menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/fabricator.png");

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleLabelX = (imageWidth - font.width(title)) / 2;
    }
}
