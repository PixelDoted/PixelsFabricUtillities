package me.pixeldots.pixelsfabricutillites.mixins.living;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import me.pixeldots.pixelsfabricutillites.events.living.*;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;

@Mixin(LivingEntityRenderer.class)
public class RenderLivingMixin {
	
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRendererV"), cancellable = true, method = "render")
    private void render(final LivingEntity livingEntity, final float f, final float g, final MatrixStack matrixStack, final VertexConsumerProvider vertexConsumerProvider, final int i, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = RenderLivingCallback.EVENT.invoker().render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        
        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}