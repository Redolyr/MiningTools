package MiningTools.Interface;

import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author redolyr
 */
public interface ISword
{
    float func_82803_g();
    float func_150893_a(ItemStack par1ItemStack, Block par2Block);
    boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase);
    @SideOnly(Side.CLIENT)
    boolean isFull3D();
    EnumAction getItemUseAction(ItemStack par1ItemStack);
    int getMaxItemUseDuration(ItemStack par1ItemStack);
//    ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);
    boolean canHarvestBlock(Block par1Block);
    int getItemEnchantability();
    String getToolMaterialName();
    boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack);
//    Multimap getItemAttributeModifiers();
}
