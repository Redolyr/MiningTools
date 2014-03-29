package MiningTools.Interface;

import java.util.ArrayList;

import MiningTools.Blocks.BlockPacks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *
 * @author Redolyr75724
 *
 */
public interface IBreakingTouch
{
    public boolean breakingTouchUseing(ItemStack item, World world, int x, int y, int z);
    public ArrayList<ItemStack> breaking(ItemStack item, World world, int x, int y, int z, int fortune);
}
