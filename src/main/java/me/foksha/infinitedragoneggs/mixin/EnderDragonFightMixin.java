package me.foksha.infinitedragoneggs.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class EnderDragonFightMixin {

	@Shadow private boolean previouslyKilled;

	@Inject(at = @At("HEAD"), method = "dragonKilled")
	private void setDragonKilled(EnderDragonEntity dragon, CallbackInfo ci) {
		if (this.previouslyKilled) {
			this.previouslyKilled = false;
		}
	}
}