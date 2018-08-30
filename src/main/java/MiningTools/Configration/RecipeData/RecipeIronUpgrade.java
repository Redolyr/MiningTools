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
        if (Items.IRON_PICKAXE != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.IRON_PICKAXE),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.STONE_PICKAXE,
                                          'X', Items.IRON_INGOT);
        }

        if (Items.IRON_SHOVEL != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.IRON_SHOVEL),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.STONE_SHOVEL,
                                          'X', Items.IRON_INGOT);
        }

        if (Items.IRON_AXE != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Items.IRON_AXE),
                                          "   ",
                                          "XAX",
                                          "   ",
                                          'A', Items.STONE_AXE,
                                          'X', Items.IRON_INGOT);
        }
    }
}
