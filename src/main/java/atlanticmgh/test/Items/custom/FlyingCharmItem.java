package atlanticmgh.test.Items.custom;


import atlanticmgh.test.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FlyingCharmItem extends Item {
    public FlyingCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.addStatusEffect(new StatusEffectInstance(ModEffects.FLY, 1800, 0, false, false));

        if(!user.getAbilities().creativeMode){
            itemStack.damage(1, user, hand.getEquipmentSlot());
        }

        return ActionResult.SUCCESS;
    }
}
