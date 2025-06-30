package com.bizcub.hideHUD.mixin;

import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class HideHUDMixin {

    @Shadow
    private Perspective perspective;

    @Shadow
    public boolean hudHidden;

    @Inject(method = "setPerspective", at = @At(value = "TAIL"))
    public void hideHUD(Perspective perspective, CallbackInfo ci) {
        this.hudHidden = !this.perspective.isFirstPerson();
    }
}
