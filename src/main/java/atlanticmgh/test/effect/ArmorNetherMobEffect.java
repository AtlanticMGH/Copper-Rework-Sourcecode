package atlanticmgh.test.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ArmorNetherMobEffect extends StatusEffect {
    protected ArmorNetherMobEffect() {
        super(StatusEffectCategory.HARMFUL, 9212166);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 5 == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity instanceof ServerPlayerEntity player){
            if (entity.getHealth() > 8.0f) {
                entity.damage(world, entity.getDamageSources().magic(), entity.getHealth() - 8);
            }
        }
        return true;
    }
}
