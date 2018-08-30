package MiningTools.Configration.RecipeData;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import MiningTools.Others.Proxy;

/**
 *
 * @author Redolyr75724
 *
 */
public class RecipeStoneUpgrade
{
    public RecipeStoneUpgrade()
    {
        if (Items.STONE_PICKAXE != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.STONE_PICKAXE),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.WOODEN_PICKAXE,
                                          'X', Blocks.COBBLESTONE);
        }

        if (Items.STONE_SHOVEL != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.STONE_SHOVEL),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.WOODEN_SHOVEL,
                                          'X', Blocks.COBBLESTONE);
        }

        if (Items.STONE_AXE != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.STONE_AXE),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.WOODEN_AXE,
                                          'X', Blocks.COBBLESTONE);
        }
    }
}
