package com.bizcub.hideHUD.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.CameraType;
import net.minecraft.client.Options;

@Mixin(Options.class)
public class HideHUDMixin {

    @Shadow private CameraType cameraType;

    @Shadow public boolean hideGui;

    @Inject(method = "setCameraType", at = @At(value = "TAIL"))
    public void hideHUD(CameraType perspective, CallbackInfo ci) {
        this.hideGui = !this.cameraType.isFirstPerson();
    }
}
