package MiningTools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import MiningTools.Interface.IMetaInformation;
import MiningTools.Items.ItemPacks;
import MiningTools.Others.Proxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMetaPacks extends ItemPacks implements IMetaInformation
{
	private static String domain = Proxy.proxy.getMiningToolsLocation();
	private static String itemName;
	@SideOnly(Side.CLIENT)
	private IIcon icon1;
	@SideOnly(Side.CLIENT)
	private IIcon icon2;
	@SideOnly(Side.CLIENT)
	private IIcon icon3;
	public ItemMetaPacks()
	{
		super(domain, itemName);
		this.setDamage(new ItemStack(this), 0);
	}
	@Override
	public String getUnlocalizedName(ItemStack stacks)
	{
		switch (stacks.getItemDamage())
		{
			case 0:
				return itemName = "Mining Stick";
			case 1:
				return itemName = "Ender Stick";
			case 2:
				return itemName = "Ghost Ingot";
		}
		return itemName;
	}
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
		switch (par1)
		{
			case 0:
				return icon1;
			case 1:
				return icon2;
			case 2:
				return icon3;
		}
		return super.getIconFromDamage(par1);
    }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		icon1 = iconRegister.registerIcon(domain + "MiningStick");
		icon2 = iconRegister.registerIcon(domain + "EnderStick");
		icon3 = iconRegister.registerIcon(domain + "GhostIngot");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1Item, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1Item, 1, 0));
		par3List.add(new ItemStack(par1Item, 1, 1));
		par3List.add(new ItemStack(par1Item ,1 ,2));
	}
	public void setInformation(EntityPlayer par2EntityPlayer, List par3List)
	{
		ItemStack metaDamageStacks = new ItemStack(this);
		this.setMetaInformation(metaDamageStacks.getItemDamage(), par2EntityPlayer, par3List);
	}
	@Override
	public void setMetaInformation(int par1MetaDamage, EntityPlayer par2EntityPlayer, List par3List)
	{
		switch (par1MetaDamage)
		{
			case 0:
				par3List.add((String) "Mining Stick");
			case 1:
				par3List.add((String) "Ender Stick");
			case 2:
				par3List.add((String) "Ghost Ingot");
		}
	}
}
