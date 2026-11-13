package io.github.bizcub.hideHUD.mixin;

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

    @Inject(method = "setCameraType", at = @At("TAIL"))
    public void hideHUD(CallbackInfo ci) {
        var hud = Minecraft.getInstance().gui.hud;
        if ((hud.isHidden() && cameraType.isFirstPerson()) || (!hud.isHidden() && !cameraType.isFirstPerson())) {
            hud.toggle();
        }
    }
}
