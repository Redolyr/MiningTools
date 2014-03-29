package MiningTools.Configration;

import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import MiningTools.Blocks.BlockPacks;
import MiningTools.Blocks.BlockSuperGlowStone;
import MiningTools.Others.Proxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class BlockIO
{
    public BlockIO(FMLPreInitializationEvent event)
    {
        if (Proxy.proxy.Config().BlocksIO == true)
        {
	    	Proxy.proxy.ConfigFile(event, "BlocksI.O");
	
	        try
	        {
	        	Proxy.proxy.Config().configSet.load();
	            Property GameRegistBlock1 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_32654, "Super Glow Stone GameRegist", Proxy.proxy.Config().GameRegistBlock1);
	            GameRegistBlock1.comment = "Super Glow Stone GameRegist";
	
	            if (Proxy.proxy.Config().GameRegistBlock1 = GameRegistBlock1.getBoolean(Proxy.proxy.Config().GameRegistBlock1))
	            {
            		Proxy.proxy.Blocks().SuperGlowStone = (BlockPacks) new BlockSuperGlowStone(Material.rock, Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_56300, 1.5F, 1.0F, 100.0F, 0);
	            }
	
	            MinecraftForge.EVENT_BUS.register(this);
	        }
	        finally
	        {
	            if (Proxy.proxy.Config().configSet.hasChanged())
	            {
	            	Proxy.proxy.Config().configSet.save();
	            }
	        }
        }
    }
}
