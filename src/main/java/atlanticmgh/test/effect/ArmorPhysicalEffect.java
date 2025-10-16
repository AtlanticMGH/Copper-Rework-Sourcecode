package atlanticmgh.test.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ArmorPhysicalEffect extends StatusEffect {
    protected ArmorPhysicalEffect() {
        super(StatusEffectCategory.HARMFUL, 9212166);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 5 == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity instanceof ServerPlayerEntity player){
            if (entity.getHealth() > 5.0f) {
                entity.damage(world, entity.getDamageSources().generic(), entity.getHealth() - 5);
            }
        }
        return true;
    }



}
