package MiningTools.Interface;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *
 * @author Redolyr75724
 *
 */
public interface ISword
{
    public float func_82803_g();
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block);
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase);
    @SideOnly(Side.CLIENT)
    public boolean isFull3D();
    public EnumAction getItemUseAction(ItemStack par1ItemStack);
    public int getMaxItemUseDuration(ItemStack par1ItemStack);
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);
    public boolean canHarvestBlock(Block par1Block);
    public int getItemEnchantability();
    public String getToolMaterialName();
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack);
    public Multimap getItemAttributeModifiers();
}
