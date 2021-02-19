package me.pixeldots.pixelsfabricutillites.Handlers;

import org.lwjgl.glfw.GLFW;

import me.pixeldots.pixelsfabricutillites.GUI.TestingGui;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

public class KeyBindings {
	
	private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		"key.pfu.testKey", // The translation key of the keybinding's name
		InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
		GLFW.GLFW_KEY_R, // The keycode of the key
		"category.pfu.testCat" // The translation key of the keybinding's category.
	));
	
	public static void registerKeyBindings() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
		    while (keyBinding.wasPressed()) {
		    	client.player.sendMessage(new LiteralText("Gui Opened! =D"), false);
		    	client.openScreen(new TestingGui());
		    }
		});
	}
}
