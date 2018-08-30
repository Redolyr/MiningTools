package MiningTools.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 *
 * This Class [#link BlockSuperGlowStone]
 * is Block unlinked texture Block
 *
 * @author redolyr
 *
 */
public class BlockSuperGlowStone extends BlockPacks {

    public BlockSuperGlowStone(Material par2Material, String par1Str, String par2Str, float par3Flo, float par4Flo, float par5Flo, int par6Int) {
        super(par2Material, par1Str, par2Str, par3Flo, par4Flo, par5Flo, par6Int);
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (int blocks = 0; blocks < 2; blocks++)
            items.add(new ItemStack(this, 1, blocks));
    }
}

