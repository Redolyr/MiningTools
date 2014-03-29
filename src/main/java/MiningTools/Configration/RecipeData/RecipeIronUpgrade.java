package MiningTools.Configration.RecipeData;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import MiningTools.Others.Proxy;

/**
 *
 * @author Redolyr75724
 *
 */
public class RecipeIronUpgrade
{
    public RecipeIronUpgrade()
    {
        if (Items.iron_pickaxe != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.iron_pickaxe),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.stone_pickaxe,
                                          'X', Items.iron_ingot);
        }

        if (Items.iron_shovel != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.iron_shovel),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.stone_shovel,
                                          'X', Items.iron_ingot);
        }

        if (Items.iron_axe != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.iron_axe),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.stone_axe,
                                          'X', Items.iron_ingot);
        }
    }
}
