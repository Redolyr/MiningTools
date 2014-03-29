package MiningTools.Interface;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface IMetaInformation extends IInformation
{
	public abstract void setMetaInformation(int par1MetaDamage, EntityPlayer par2EntityPlayer, List par3List);
}
