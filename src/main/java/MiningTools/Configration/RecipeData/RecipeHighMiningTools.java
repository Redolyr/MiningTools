package MiningTools.Configration.RecipeData;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import MiningTools.Others.Proxy;

/**
 * @author redolyr
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
                                          'S', Items.ENDER_EYE,
                                          'A', Items.DIAMOND_AXE,
                                          'B', Items.DIAMOND_SHOVEL,
                                          'C', Items.DIAMOND_PICKAXE,
                                          'D', Blocks.LAPIS_BLOCK);
            Proxy.proxy.removeRecipe(true, Items.DIAMOND_PICKAXE);
            Proxy.proxy.removeRecipe(true, Items.DIAMOND_SHOVEL);
            Proxy.proxy.removeRecipe(true, Items.DIAMOND_AXE);
        }
    }
}
