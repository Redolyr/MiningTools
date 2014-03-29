package MiningTools.Interface;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 *
 * @author Redolyr75724
 *
 */
public interface ITileEntityProviderTwo extends ITileEntityProvider
{
    TileEntity createNewTileEntity(World world, int meta);
}
