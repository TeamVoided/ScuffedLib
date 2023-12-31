package org.teamvoided.scuffedlib.mixin;

import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.resource.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.teamvoided.scuffedlib.sign.MaterialRegistry;

import java.util.function.Consumer;

@Mixin(TexturedRenderLayers.class)
public class MixinTexturedRenderLayers {
	@Inject(method = "addDefaultTextures", at = @At("RETURN"))
	private static void addCustomSigns(Consumer<Material> consumer, CallbackInfo info) {
		MaterialRegistry.INSTANCE.getIds().forEach(consumer);
	}
}
