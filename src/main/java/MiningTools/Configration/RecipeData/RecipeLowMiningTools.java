package MiningTools.Configration.RecipeData;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import MiningTools.Others.Proxy;

/**
 *
 * @author Redolyr75724
 *
 */
public class RecipeLowMiningTools
{
    public RecipeLowMiningTools()
    {
        if (Proxy.proxy.Items().MiningTools != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().MiningTools),
                                          " A ",
                                          "BSC",
                                          " X ",
                                          'X', Proxy.proxy.Items().MiningStick,
                                          'S', Items.ENDER_EYE,
                                          'A', Items.DIAMOND_AXE,
                                          'B', Items.DIAMOND_SHOVEL,
                                          'C', Items.DIAMOND_PICKAXE);
        }
    }
}
