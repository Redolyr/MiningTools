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
                                          'S', Items.ender_eye,
                                          'A', Items.diamond_axe,
                                          'B', Items.diamond_shovel,
                                          'C', Items.diamond_pickaxe);
        }
    }
}
