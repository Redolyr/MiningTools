package MiningTools.Configration;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import MiningTools.Items.ItemEnderStick;
import MiningTools.Items.ItemHarvesterIngots;
import MiningTools.Items.ItemIronTools;
import MiningTools.Items.ItemMiningStick;
import MiningTools.Items.ItemMiningTools;
import MiningTools.Items.ItemOffline_in_the_Information_Texts;
import MiningTools.Items.ItemPacks;
import MiningTools.Items.ItemToolTwo;
import MiningTools.Others.Proxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ItemIO
{
    public ItemIO(FMLPreInitializationEvent event)
    {
        if (Proxy.proxy.Config().ItemsIO == true)
        {
	        Proxy.proxy.ConfigFile(event, "ItemsI.O");
	
	        try
	        {
	            Proxy.proxy.Config().configSet.load();
	            Property GameRegistItem1 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Mining Tools GameRegist", Proxy.proxy.Config().GameRegistItem1);
	            Property GameRegistItem2 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Mining Stick GameRegist", Proxy.proxy.Config().GameRegistItem2);;
	            Property GameRegistItem3 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Ender Stick GameRegist", Proxy.proxy.Config().GameRegistItem3);
	            Property GameRegistItem4 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Harvester Ingots GameRegist", Proxy.proxy.Config().GameRegistItem4);
	            Property GameRegistItem5 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Iron Tools GameRegist", Proxy.proxy.Config().GameRegistItem5);
	            Property GameRegistItem6 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_86574, "Offline in the Information Texts GameRegist", Proxy.proxy.Config().GameRegistItem6);
	            GameRegistItem1.comment = "Mining Tools GameRegist";
	            GameRegistItem2.comment = "Mining Stick GameRegist";
	            GameRegistItem3.comment = "Ender Stick GameRegist";
	            GameRegistItem4.comment = "Harvester Ingots GameRegist";
	            GameRegistItem5.comment = "Iron Tools GameRegist";
	            GameRegistItem6.comment = "Offline in the Information Texts GameRegist";
	
	            if (Proxy.proxy.Config().GameRegistItem1 = GameRegistItem1.getBoolean(Proxy.proxy.Config().GameRegistItem1))
	            {
	            	Proxy.proxy.Items().MiningTools = (ItemToolTwo) new ItemMiningTools(Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_28362, ToolMaterial.EMERALD);
	            }
	            if (Proxy.proxy.Config().GameRegistItem2 = GameRegistItem2.getBoolean(Proxy.proxy.Config().GameRegistItem2))
	            {
                    Proxy.proxy.Items().MiningStick = (ItemPacks) new ItemMiningStick(Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_29298);
	            }
	            if (Proxy.proxy.Config().GameRegistItem3 = GameRegistItem3.getBoolean(Proxy.proxy.Config().GameRegistItem3))
	            {
                    Proxy.proxy.Items().EnderStick = (ItemPacks) new ItemEnderStick(Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_39652);
	            }
	            if (Proxy.proxy.Config().GameRegistItem4 = GameRegistItem4.getBoolean(Proxy.proxy.Config().GameRegistItem4))
	            {
                    Proxy.proxy.Items().HarvesterIngots = (ItemPacks) new ItemHarvesterIngots(Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_13952);
	            }
	            if (Proxy.proxy.Config().GameRegistItem5 = GameRegistItem5.getBoolean(Proxy.proxy.Config().GameRegistItem5))
	            {
                	Proxy.proxy.Items().IronTools = (ItemToolTwo) new ItemIronTools(Proxy.proxy.getMiningToolsLocation(), Proxy.proxy.String().Name_Tag_99985, ToolMaterial.IRON);
	            }
	            if (Proxy.proxy.Config().GameRegistItem6 = GameRegistItem2.getBoolean(Proxy.proxy.Config().GameRegistItem6))
	            {
                    Proxy.proxy.Items().OfflineInTheInformation = (ItemPacks) new ItemOffline_in_the_Information_Texts(Proxy.proxy.getMiningToolsLocation(), "Offline in the Information Texts");
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
