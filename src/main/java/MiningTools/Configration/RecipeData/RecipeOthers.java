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
                                    'S', Items.STICK);
        }

        if (Proxy.proxy.Items().EnderStick != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().EnderStick),
                                    "XSX",
                                    "XSX",
                                    "XSX",
                                    'X', Items.STICK,
                                    'S', Items.ENDER_PEARL);
        }

        if (Proxy.proxy.Items().HarvesterIngots != null)
        {
            Proxy.proxy.addCraftingRecipe(new ItemStack(Proxy.proxy.Items().HarvesterIngots),
                                    "DAD",
                                    "BSC",
                                    "DXD",
                                    'X', Proxy.proxy.Items().MiningStick,
                                    'S', Items.ENDER_EYE,
                                    'A', Items.DIAMOND_AXE,
                                    'B', Items.DIAMOND_SHOVEL,
                                    'C', Items.DIAMOND_PICKAXE,
                                    'D', Items.IRON_INGOT);
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
                                    'X', Items.STICK,
                                    'S', Blocks.STONE,
                                    'A', Items.IRON_AXE,
                                    'B', Items.IRON_SHOVEL,
                                    'C', Items.IRON_PICKAXE);
        }
    }
}
