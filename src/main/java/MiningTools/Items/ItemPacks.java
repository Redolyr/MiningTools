package MiningTools.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import MiningTools.MiningTools;
import MiningTools.Interface.IInformation;
import MiningTools.Others.Proxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * This Class [#link BlockPacks] This Mod Contianer Link Master Class
 * is BlockPacks Link Block Data Container Link is Others Class This Mod Block Class Extendsments
 *
 * @author Redolyr75724
 *
 */
public abstract class ItemPacks extends Item implements IInformation
{
    protected ItemStack itemStacks = new ItemStack(this);
    public Item items;
    protected boolean isLShiftRotations, isRShiftRotations;
    
    protected Block blocks;
    
    protected Boolean informaiton_Boolean = true;
    
    private static String domain, names;

    public ItemPacks(String domain, String itemName)
    {
        super();
        if (Proxy.proxy.Config().GameRegistItem1 == true)
        	this.setCreativeTab(MiningTools.tabsMiningTools);
        else
        	this.setCreativeTab(CreativeTabs.tabCombat);
        this.setData(domain, itemName);
        Proxy.proxy.registerItem(this, replace(this));
    }
    public Item setData(String par1Str, String par2Str)
    {
        items = setUnlocalizedName(par2Str);
        iconString = par1Str + par2Str;
        domain = par1Str;
        names = par2Str;
        return this;
    }
    public Item setData(String par1Str, String par2Str, boolean isItem3D)
    {
        items = setUnlocalizedName(par2Str);
        iconString = par1Str + par2Str;
        bFull3D = isItem3D;
        domain = par1Str;
        names = par2Str;
        return this;
    }
    public ItemPacks getData()
    {
    	items = this;
    	iconString = domain + names;
    	isFull3D();
    	return this;
    }
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if (informaiton_Boolean == true);
    	this.setInformation(par2EntityPlayer, par3List);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void setInformation(EntityPlayer par2EntityPlayer, List par3List)
    {
        par3List.add((String) "ID: " + this);
        par3List.add((String) "Damage: " + this.getDisplayDamage(itemStacks) + "/" + this.getMaxDamage());
    }
    protected void isLShiftMessage(List par3List)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            isLShiftRotations = true;
        }
        else
        {
            isLShiftRotations = false;
        }
        if (isLShiftRotations == false)
        {
            Proxy.proxy.addInfomationText(par3List, "press.LShift.infomation");
        }
    }
    protected void isRShiftMessage(List par3List)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
        {
            isRShiftRotations = true;
        }
        else
        {
            isRShiftRotations = false;
        }
        if (isRShiftRotations == false)
        {
            Proxy.proxy.addInfomationText(par3List, "press.RShift.infomation");
        }
    }
//    public CreativeTabs[] getCreativeTabs()
//    {
//    	return new CreativeTabs[] { MiningTools.tabsMiningTools };
//    }
    public final String replace(ItemPacks itemPacks)
    {
    	return itemPacks.getUnlocalizedName().replace("item.", "").replace(".name", "");
    }
    @Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (par3EntityPlayer.inventory.hasItem(Proxy.proxy.Items().OfflineInTheInformation))
        {
            if (flag)
            {
                informaiton_Boolean = true;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Proxy.proxy.Items().OfflineInTheInformation);
            }

            if (!par2World.isRemote)
            {
            	informaiton_Boolean = true;
            }
        	informaiton_Boolean = false;
        }
    }
    @Override
    public CreativeTabs[] getCreativeTabs()
    {
    	return new CreativeTabs[] { MiningTools.tabsMiningTools };
    }
}
