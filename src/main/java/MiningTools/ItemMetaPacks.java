package MiningTools;

import MiningTools.Interface.IMetaInformation;
import MiningTools.Items.ItemPacks;
import MiningTools.Others.Proxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

public class ItemMetaPacks extends ItemPacks implements IMetaInformation {
	private static String domain = Proxy.proxy.getMiningToolsLocation();
	private static String itemName;

	public ItemMetaPacks() {
		super(domain, itemName);
		this.setDamage(new ItemStack(this), 0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stacks) {
		switch (stacks.getItemDamage()) {
			case 0:
				return itemName = "Mining Stick";
			case 1:
				return itemName = "Ender Stick";
			case 2:
				return itemName = "Ghost Ingot";
		}
		return itemName;
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
		}
	}

	public void setInformation(World par2EntityPlayer, List par3List) {
		ItemStack metaDamageStacks = new ItemStack(this);
		this.setMetaInformation(metaDamageStacks.getItemDamage(), par2EntityPlayer, par3List);
	}

	public void setMetaInformation(int par1MetaDamage, World par2World, List par3List) {
		switch (par1MetaDamage) {
			case 0:
				par3List.add("Mining Stick");
			case 1:
				par3List.add("Ender Stick");
			case 2:
				par3List.add("Ghost Ingot");
		}
	}
}
