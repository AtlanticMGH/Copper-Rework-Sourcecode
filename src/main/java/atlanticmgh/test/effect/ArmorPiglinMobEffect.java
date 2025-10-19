package atlanticmgh.test.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ArmorPiglinMobEffect extends StatusEffect {
    protected ArmorPiglinMobEffect() {
        super(StatusEffectCategory.HARMFUL, 9212166);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity instanceof ServerPlayerEntity player){
            setHealth(player, 10);
        }
        StatusEffectInstance armorEffectInstance = entity.getStatusEffect(ModEffects.ARMOR_PIGLIN_MOB_DEBUFF);
        if(armorEffectInstance.getDuration() <= 1){
            setHealth((ServerPlayerEntity) entity, 20);
        }
        return true;
    }

    private static void setHealth(ServerPlayerEntity player, double value){
        EntityAttributeInstance maxHealth = player.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (maxHealth != null) {
            maxHealth.setBaseValue(value);
            if(value == 20){
                player.setHealth(20);
            }
        }
    }
}
