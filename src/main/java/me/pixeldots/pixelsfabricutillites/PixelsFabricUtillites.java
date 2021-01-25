package me.pixeldots.pixelsfabricutillites;

import me.pixeldots.pixelsfabricutillites.events.living.RenderLivingCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class PixelsFabricUtillites implements ModInitializer {

	@Override
	public void onInitialize() {
		System.out.println("(Pixel's Fabric Utillites) Initializing");
		
		/*RenderLivingCallback.EVENT.register((livingEntity, f, g, matrixStack, vertexConsumerProvider, i) -> {
			livingEntity.addVelocity(0, 10, 0);
		 
		    return ActionResult.PASS;
		});*/
	}
	
	public class RenderLiving implements RenderLivingCallback {

		@Override
		public ActionResult render(LivingEntity livingEntity, float f, float g, MatrixStack matrixStack,
				VertexConsumerProvider vertexConsumerProvider, int i) {
			livingEntity.addVelocity(0, 10, 0);
			return ActionResult.PASS;
		}
		
	}

}
