package atlanticmgh.test.Items.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WaterCharmItem extends Item {
    public WaterCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1800, 1, false, false));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1800, 1, false, false));

        if(!user.getAbilities().creativeMode){
            itemStack.damage(1, user, hand.getEquipmentSlot());
        }

        return ActionResult.SUCCESS;
    }

}
