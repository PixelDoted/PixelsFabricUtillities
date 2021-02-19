package me.pixeldots.pixelsfabricutillites.GUI.Handlers;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class GuiHandler extends Screen {
	
	public List<ButtonWidget> buttonWidgets = Lists.newArrayList();
	
	public GuiHandler(String title) {
		super(Text.of(title));
	}
	
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		for (int i = 0; i < buttonWidgets.size(); i++) {
			buttonWidgets.get(i).renderButton(matrices, mouseX, mouseY, delta);
		}
		super.render(matrices, mouseX, mouseY, delta);
	}
	
	/*@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		for (int i = 0; i < buttonWidgets.size(); i++) {
			buttonWidgets.get(i).mouseClicked(mouseX, mouseY, button);
		}
		return super.mouseClicked(mouseX, mouseY, button);
	}*/
	
	public ButtonWidget addButtonWidget(ButtonWidget button) {	
		this.buttonWidgets.add(button);
		return button;
	}

}
