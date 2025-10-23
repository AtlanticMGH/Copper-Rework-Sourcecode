package atlanticmgh.test;

import atlanticmgh.test.Items.ModItems;
import atlanticmgh.test.effect.ModEffects;
import atlanticmgh.test.network.ArmorCharmNetworking;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperRework implements ModInitializer {
	public static final String MOD_ID = "test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
        ArmorCharmNetworking.registerCommon();
        ArmorCharmNetworking.registerServer();
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {

            if (entity instanceof PlayerEntity player && player.hasStatusEffect(ModEffects.ARMOR_PHYSICAL_DEBUFF)) {
                if (isPhysical(source, player)) {
                    return ActionResult.FAIL.isAccepted();
                }
            }

            if(entity instanceof PlayerEntity player && player.hasStatusEffect(ModEffects.ARMOR_UNDEAD_MOB_DEBUFF)){
                LivingEntity attacker = null;
                if (source.getAttacker() instanceof LivingEntity living) {
                    attacker = living;
                }

                if (attacker instanceof ZombieEntity || attacker instanceof SkeletonEntity) {
                    return ActionResult.FAIL.isAccepted();
                }
            }

            if(entity instanceof PlayerEntity player && player.hasStatusEffect(ModEffects.ARMOR_NETHER_MOB_DEBUFF)){
                LivingEntity attacker = null;
                if (source.getAttacker() instanceof LivingEntity living) {
                    attacker = living;
                }
                if (attacker instanceof BlazeEntity
                        || attacker instanceof MagmaCubeEntity
                        || attacker instanceof GhastEntity) {
                    return ActionResult.FAIL.isAccepted();
                }
            }

            if(entity instanceof PlayerEntity player && player.hasStatusEffect(ModEffects.ARMOR_PIGLIN_MOB_DEBUFF)) {
                LivingEntity attacker = null;
                if (source.getAttacker() instanceof LivingEntity living) {
                    attacker = living;
                }
                if (attacker instanceof PiglinEntity
                        || attacker instanceof PiglinBruteEntity
                        || attacker instanceof HoglinEntity) {
                    return ActionResult.FAIL.isAccepted();
                }
            }
            return true;
        });

        LOGGER.info("uwu :3");

        ModItems.initialize();
        ModEffects.initialize();
	}

    private boolean isPhysical(DamageSource source, LivingEntity user) {
        return source.isIn(DamageTypeTags.IS_PROJECTILE)
                || source.isIn(DamageTypeTags.IS_PLAYER_ATTACK)
                || source.isIn(DamageTypeTags.IS_EXPLOSION)
                || source == user.getDamageSources().fall()
                || source == user.getDamageSources().cactus();
    }
}