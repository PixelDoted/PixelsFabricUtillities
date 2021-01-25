package me.pixeldots.pixelsfabricutillites.events.living;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;

public interface RenderLivingCallback {
	
	Event<RenderLivingCallback> EVENT = EventFactory.createArrayBacked(RenderLivingCallback.class,
		(listeners) -> (livingEntity, f, g, matrixStack, vertexConsumerProvider, i) -> {
		for (RenderLivingCallback listener : listeners) {
			ActionResult result = listener.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
	 
			if(result != ActionResult.PASS) {
					return result;
			}
		}
	 
		return ActionResult.PASS;
	});
	 
	ActionResult render(LivingEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i);
	
}
