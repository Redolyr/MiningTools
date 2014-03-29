package MiningTools.Others;

import MiningTools.AchievementMiningTools;
import MiningTools.Configration.BlockIO;
import MiningTools.Configration.ItemIO;
import MiningTools.Configration.ModelIO;
import MiningTools.Configration.Recipe;
import MiningTools.Data.ItemsData;
import MiningTools.Data.stringData;
import MiningTools.Items.ItemEnderStick;
import MiningTools.Items.ItemMiningStick;
import MiningTools.Items.ItemMiningTools;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ProxyClient extends Proxy
{
    @Override
    public Object getClient()
    {
        return FMLClientHandler.instance().getClient();
    }
    @Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
    @Override
    public String getCurrentLanguage()
    {
    	return null;
//        return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
    }
    @Override
    public void SoundRegistry()
    {
    	//SoundHandler.class
    	//SoundHandler.loadSoundResource(MiningToolsLocation(sound), 
    }
	@Override
	public void ConfigurationInitializationEvent(Boolean enable, Boolean ItemsIO, Boolean BlocksIO, Boolean ModelIO, Boolean RecipeIO)
	{
		if (enable != false && enable != null && enable == true)
		{
			Config().ItemsIO = ItemsIO;
			{
				System.out.println("Items: " + System.err.checkError());
			}
			
			Config().BlocksIO = BlocksIO;
			{
				System.out.println("Block: " + System.err.checkError());
			}
			
			Config().ModelIO = ModelIO;
			{
				System.out.println("Model: " + System.err.checkError());
			}
			
			Config().RecipeIO = RecipeIO;
			{
				System.out.println("Recipe: " + System.err.checkError());
			}
		}
	}
	@Override
	public void PreInitializationEventHandlers(FMLPreInitializationEvent event)
	{
		if (true)
		{
        	new ItemIO(event);
        	new BlockIO(event);
        	new ModelIO(event);
        	new Recipe(event);
        	new AchievementMiningTools();
        	Proxy.proxy.BusRegister(true);
		}
	}
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event)
	{
		if (event.crafting.getItem() instanceof ItemMiningTools)
			event.player.addStat(AchievementMiningTools.MiningTools, 1);
		else
			if (event.crafting.getItem() instanceof ItemMiningStick)
				event.player.addStat(AchievementMiningTools.MiningStick, 1);
		else
			if (event.crafting.getItem() instanceof ItemEnderStick)
				event.player.addStat(AchievementMiningTools.EnderStick, 1);
	}
//	@SubscribeEvent
//	public void onSmelting(PlayerEvent.ItemSmeltedEvent event)
//	{
//		if (event.smelting.getItem() == Core.ingotPlastic)
//			event.player.addStat(Core.getPlasticIngot, 1);
//	}
}