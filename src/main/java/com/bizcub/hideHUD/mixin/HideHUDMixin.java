package com.bizcub.hideHUD.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? >=1.21.11 {
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

//?} <=1.21.10 {
/*import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;

@Mixin(GameOptions.class)
public class HideHUDMixin {

    @Shadow private Perspective perspective;

    @Shadow public boolean hudHidden;

    @Inject(method = "setPerspective", at = @At(value = "TAIL"))
    public void hideHUD(Perspective perspective, CallbackInfo ci) {
        this.hudHidden = !this.perspective.isFirstPerson();
    }
}*///?}
