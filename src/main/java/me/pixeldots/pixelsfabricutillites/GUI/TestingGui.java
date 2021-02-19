package me.pixeldots.pixelsfabricutillites.GUI;

import me.pixeldots.pixelsfabricutillites.GUI.Handlers.GuiHandler;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class TestingGui extends GuiHandler {
	
	public ButtonWidget button;
	
	public TestingGui() {
		super("not jimmy just testing");
	}
	
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		button = addButtonWidget(new ButtonWidget(100, 100, 100, 50, Text.of("click me!"), (button) -> {
			client.player.sendMessage(new LiteralText("Button Clicked =D!!!!!!!!!!!!!!!!"), false);
		}));
		super.render(matrices, mouseX, mouseY, delta);
	}
	
}
