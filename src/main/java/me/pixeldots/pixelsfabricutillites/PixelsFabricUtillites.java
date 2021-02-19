package me.pixeldots.pixelsfabricutillites;

import me.pixeldots.pixelsfabricutillites.Handlers.KeyBindings;
import me.pixeldots.pixelsfabricutillites.events.living.RenderLivingCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.ActionResult;

public class PixelsFabricUtillites implements ModInitializer {

	@Override
	public void onInitialize() {
		System.out.println("(Pixel's Fabric Utillites) Initializing");
		
		RenderLivingCallback.EVENT.register((ClientPlayerEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light) -> {
			matrixStack.scale(2, 2, 2);
		    return ActionResult.PASS;
		});
		KeyBindings.registerKeyBindings();
	}

}
