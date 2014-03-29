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
        if (Items.stone_pickaxe != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.stone_pickaxe),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.wooden_pickaxe,
                                          'X', Blocks.cobblestone);
        }

        if (Items.stone_shovel != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.stone_shovel),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.wooden_shovel,
                                          'X', Blocks.cobblestone);
        }

        if (Items.stone_axe != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.stone_axe),
                                          " X ",
                                          "XAX",
                                          " X ",
                                          'A', Items.wooden_axe,
                                          'X', Blocks.cobblestone);
        }
    }
}
