package com.mitchej123.hodgepodge.mixins.early.minecraft;

import net.minecraft.client.entity.EntityPlayerSP;

import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Redirect(
            method = "onLivingUpdate()V",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/entity/EntityPlayerSP;motionY:D",
                    opcode = Opcodes.PUTFIELD),
            remap = false)
    private void flyMotionY(EntityPlayerSP playerSP, double x) {
        playerSP.motionY = x * 1.5;
    }
}
