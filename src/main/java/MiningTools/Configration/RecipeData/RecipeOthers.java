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
public class RecipeOthers
{
    public RecipeOthers()
    {
        if (Proxy.proxy.Items().MiningStick != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().MiningStick),
                                    "SXS",
                                    "SXS",
                                    "SXS",
                                    'X', new ItemStack(Proxy.proxy.Items().EnderStick),
                                    'S', Items.stick);
        }

        if (Proxy.proxy.Items().EnderStick != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().EnderStick),
                                    "XSX",
                                    "XSX",
                                    "XSX",
                                    'X', Items.stick,
                                    'S', Items.ender_pearl);
        }

        if (Proxy.proxy.Items().HarvesterIngots != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().HarvesterIngots),
                                    "DAD",
                                    "BSC",
                                    "DXD",
                                    'X', Proxy.proxy.Items().MiningStick,
                                    'S', Items.ender_eye,
                                    'A', Items.diamond_axe,
                                    'B', Items.diamond_shovel,
                                    'C', Items.diamond_pickaxe,
                                    'D', Items.iron_ingot);
        }

//        if (Proxy.proxy.Blocks().SuperGlowStone != null)
//        {
//            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Blocks().SuperGlowStone),
//                                    "XBX",
//                                    "ASA",
//                                    "XBX",
//                                    'X', Proxy.proxy.Items().HarvesterIngots,
//                                    'S', Items.ender_eye,
//                                    'A', Blocks.glowstone,
//                                    'B', Blocks.glass);
//        }
//
//        if (Proxy.proxy.Blocks().SuperGlowStone != null)
//        {
//            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Blocks().SuperGlowStone),
//                                    "XAX",
//                                    "BSB",
//                                    "XAX",
//                                    'X', Proxy.proxy.Items().HarvesterIngots,
//                                    'S', Items.ender_eye,
//                                    'A', Blocks.glowstone,
//                                    'B', Blocks.glass);
//        }
//
//        if (Proxy.proxy.Blocks().HarvesterBlock != null)
//        {
//            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Blocks().HarvesterBlock),
//                                    "XAX",
//                                    "ASA",
//                                    "XAX",
//                                    'X', Proxy.proxy.Items().HarvesterIngots,
//                                    'A', Items.iron_ingot,
//                                    'S', Blocks.iron_block);
//        }

        if (Proxy.proxy.Items().IronTools != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().IronTools),
                                    " A ",
                                    "BSC",
                                    " X ",
                                    'X', Items.stick,
                                    'S', Blocks.stone,
                                    'A', Items.iron_axe,
                                    'B', Items.iron_shovel,
                                    'C', Items.iron_pickaxe);
        }
    }
}
