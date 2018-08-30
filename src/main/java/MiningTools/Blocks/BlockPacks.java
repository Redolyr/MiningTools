package MiningTools.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import MiningTools.MiningTools;
import MiningTools.Others.Proxy;

/**
 *
 * This Class [#link BlockPacks] This Mod Contianer Link Master Class
 * is BlockPacks Link Block Data Container Link is Others Class This Mod Block Class Extendsments
 *
 * @author Redolyr75724
 *
 */
public class BlockPacks extends Block {
    protected static Material material;

    public BlockPacks(Material par2Material, String par1Str, String par2Str, float par3Flo, float par4Flo, float par5Flo, int par6Int) {
        super(par2Material);
        if (Proxy.proxy.Config().GameRegistItem1 == true)
            this.setCreativeTab(MiningTools.tabsMiningTools);
        else
            this.setCreativeTab(CreativeTabs.COMBAT);
        this.setData(par1Str, par1Str, par3Flo, par4Flo, par5Flo, par6Int);
    }

    public Block setData(String par1Str, String par2Str, float par3Flo, float par4Flo, float par5Flo, int par6Int) {
        //textureName = par1Str + ":" + par2Str;
        blockHardness = par3Flo;
        lightValue = (int) (15.0F * par4Flo);
        blockResistance = par5Flo;
        lightOpacity = par6Int;
        return this;
    }

    public Block setData(String par1Str, String par2Str, float par3Flo, float par4Flo, float par5Flo, int par6Int, boolean par7EnableDisableStates) {
        blockHardness = par3Flo;
        lightValue = (int) (15.0F * par4Flo);
        blockResistance = par5Flo;
        lightOpacity = par6Int;
        enableStats = par7EnableDisableStates;
        return this;
    }

    public Block setData(float par3Flo, float par4Flo, float par5Flo, int par6Int) {
        blockHardness = par3Flo;
        lightValue = (int) (15.0F * par4Flo);
        blockResistance = par5Flo;
        lightOpacity = par6Int;
        return this;
    }

    public Material setMaterial(Material material) {
        return this.material = material;
    }

    public final String replace(BlockPacks blockPacks) {
        return blockPacks.getUnlocalizedName().replace("tile.", "").replace(".name", "");
    }
}
