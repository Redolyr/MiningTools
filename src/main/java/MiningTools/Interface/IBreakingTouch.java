package MiningTools.Interface;

import java.util.ArrayList;

import MiningTools.Blocks.BlockPacks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author redolyr
 */
public interface IBreakingTouch {
    boolean breakingTouchUsing(ItemStack item, World world, int x, int y, int z);

    ArrayList<ItemStack> breaking(ItemStack item, World world, int x, int y, int z, int fortune);
}
