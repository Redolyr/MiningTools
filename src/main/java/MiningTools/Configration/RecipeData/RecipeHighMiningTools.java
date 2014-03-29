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
public class RecipeHighMiningTools
{
    public RecipeHighMiningTools()
    {
        if (Proxy.proxy.Items().MiningTools != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().MiningTools),
                                          "DDD",
                                          "SAS",
                                          "BXC",
                                          'X', Proxy.proxy.Items().MiningStick,
                                          'S', Items.ender_eye,
                                          'A', Items.diamond_axe,
                                          'B', Items.diamond_shovel,
                                          'C', Items.diamond_pickaxe,
                                          'D', Blocks.lapis_block);
            Proxy.proxy.removeRecipe(true, Items.diamond_pickaxe);
            Proxy.proxy.removeRecipe(true, Items.diamond_shovel);
            Proxy.proxy.removeRecipe(true, Items.diamond_axe);
        }
    }
}
