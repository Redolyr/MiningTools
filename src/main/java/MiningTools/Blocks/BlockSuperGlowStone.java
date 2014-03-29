package MiningTools.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * This Class [#link BlockSuperGlowStone]
 * is Block unlinked texture Block
 *
 * @author Redolyr75724
 *
 */
public class BlockSuperGlowStone extends BlockPacks
{
	public BlockSuperGlowStone(Material par2Material, String par1Str, String par2Str, float par3Flo, float par4Flo, float par5Flo, int par6Int)
	{
		super(par2Material, par1Str, par2Str, par3Flo, par4Flo, par5Flo, par6Int);
		damageDropped(0);
	}
	@Override
	public void getSubBlocks(Item par1Blocks, CreativeTabs par2CrativeTabs, List par3List)
	{
		for (Integer setBlocks = 0; setBlocks < 2; setBlocks++)
			par3List.add(new ItemStack(this, 1, setBlocks));
	}
}
