package MiningTools.Interface;

import java.util.List;

import net.minecraft.world.World;

public interface IMetaInformation extends IInformation {
	void setMetaInformation(int par1MetaDamage, World par2World, List par3List);
}
