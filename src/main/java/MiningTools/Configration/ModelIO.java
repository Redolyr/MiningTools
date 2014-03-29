package MiningTools.Configration;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import MiningTools.Items.Model.ItemRenderMiningTools;
import MiningTools.Others.Proxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ModelIO
{
    public ModelIO(FMLPreInitializationEvent event)
    {
        if (Proxy.proxy.Config().ModelIO == true)
        {
	        Proxy.proxy.ConfigFile(event, "ModelI.O");
	
	        try
	        {
	        	Property registModelMiningTools = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_39276, "MiningTools Model Regist", Proxy.proxy.Config().GameRegistModel1);
	        	registModelMiningTools.comment = "MiningTools Model Regist";
	        	
	        	if (Proxy.proxy.Config().GameRegistModel1 = registModelMiningTools.getBoolean(Proxy.proxy.Config().GameRegistModel1))
	        	{
	        		MinecraftForgeClient.registerItemRenderer(Proxy.proxy.Items().MiningTools, new ItemRenderMiningTools());
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
