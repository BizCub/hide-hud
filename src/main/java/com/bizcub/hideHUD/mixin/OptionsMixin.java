package com.bizcub.hideHUD.mixin;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
public class OptionsMixin {

    @Shadow private CameraType cameraType;
    /*? <26.2*/ //@Shadow public boolean hideGui;

    @Inject(method = "setCameraType", at = @At("TAIL"))
    public void hideHUD(CallbackInfo ci) {
        //? >=26.2 {
        var hud = Minecraft.getInstance().gui.hud;
        if ((hud.isHidden() && cameraType.isFirstPerson()) || (!hud.isHidden() && !cameraType.isFirstPerson())) {
            hud.toggle();
        }

        //?} else {
        /*this.hideGui = !this.cameraType.isFirstPerson();*///?}
    }
}
