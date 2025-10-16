package atlanticmgh.test.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class FlyEffect extends StatusEffect {
    protected FlyEffect() {
        super(StatusEffectCategory.NEUTRAL, 9212166);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int pAmplifier){
        if(entity instanceof PlayerEntity){
            flyAbility((PlayerEntity) entity, true);
        }
        StatusEffectInstance flightEffectInstance = entity.getStatusEffect(ModEffects.FLY);
        if(flightEffectInstance.getDuration() <= 1){
            flyAbility((PlayerEntity) entity, false);
        }
        super.applyUpdateEffect(world, entity, pAmplifier);
        return true;
    }

    private void flyAbility(PlayerEntity user, boolean allowed){
        if(!user.isCreative()) {
            if (!allowed) {
                user.getAbilities().flying = false;
            }
        }

        user.getAbilities().allowFlying = allowed;
        user.sendAbilitiesUpdate();
    }
}
