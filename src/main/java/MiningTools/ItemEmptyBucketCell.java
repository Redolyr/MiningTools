package MiningTools;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEmptyBucketCell extends Item
{
	public ItemEmptyBucketCell()
	{
		super();
		this.setContainerItem(MiningTools.EmptyBucketCell);
	}
}
