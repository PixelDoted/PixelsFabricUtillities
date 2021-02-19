package me.pixeldots.pixelsfabricutillites.events.living.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.pixeldots.pixelsfabricutillites.events.living.RenderLivingCallback;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.ActionResult;

@Mixin(PlayerEntityRenderer.class)
public class RenderLivingMixin {
	
	@Inject(method = "render", at = @At("HEAD"), cancellable = true)//@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/PlayerEntityRenderer;render()V"), cancellable = true, method = "render")
    private void render(final AbstractClientPlayerEntity abstractClientPlayerEntity, final float f, final float g, final MatrixStack matrixStack, final VertexConsumerProvider vertexConsumerProvider, final int i, final CallbackInfo info) {
        ActionResult result = RenderLivingCallback.EVENT.invoker().render(abstractClientPlayerEntity, f, g, matrixStack, vertexConsumerProvider, i);
        
        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}