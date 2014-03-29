package MiningTools.Interface;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Redolyr75724
 *
 */
public interface IRegistendIconPath
{
    @SideOnly(Side.CLIENT)
    void registerIcons(IIconRegister par1IconRegister);
    @SideOnly(Side.CLIENT)
    IIcon getIcon(int par1, int par2);
}
