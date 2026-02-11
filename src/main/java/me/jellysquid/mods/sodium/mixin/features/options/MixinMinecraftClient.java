package me.jellysquid.mods.sodium.mixin.features.options;

import me.jellysquid.mods.sodium.client.SodiumClientMod;
import me.jellysquid.mods.sodium.client.gui.SodiumGameOptions;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MixinMinecraftClient {
    @Inject(method = "isAmbientOcclusionEnabled", at = @At("HEAD"), cancellable = true, require = 0)
    private static void sodium$overrideAmbientOcclusion(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(SodiumClientMod.options().quality.smoothLighting != SodiumGameOptions.LightingQuality.OFF);
    }
}
