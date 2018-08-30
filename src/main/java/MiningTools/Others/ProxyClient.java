package MiningTools.Others;

import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends Proxy {
    public Object getClient() {
        return FMLClientHandler.instance().getClient();
    }

    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().world;
    }

    public String getCurrentLanguage() {
        return null;
//        return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
    }

    public void SoundRegistry() {
        //SoundHandler.class
        //SoundHandler.loadSoundResource(MiningToolsLocation(sound),
    }

    public void ConfigurationInitializationEvent(Boolean enable, Boolean ItemsIO, Boolean BlocksIO, Boolean ModelIO, Boolean RecipeIO) {
        if (enable != false && enable != null && enable == true) {
            Config().ItemsIO = ItemsIO;
            System.out.println("Items: " + System.err.checkError());

            Config().BlocksIO = BlocksIO;
            System.out.println("Block: " + System.err.checkError());

            Config().ModelIO = ModelIO;
            System.out.println("Model: " + System.err.checkError());

            Config().RecipeIO = RecipeIO;
            System.out.println("Recipe: " + System.err.checkError());
        }
    }

    public void PreInitializationEventHandlers(FMLPreInitializationEvent event) {
//        if (true) {
//            new ItemIO(event);
//            new BlockIO(event);
//            new ModelIO(event);
//            new Recipe(event);
//            new AchievementMiningTools();
//            Proxy.proxy.BusRegister(true);
//        }
    }

//    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
//        if (event.crafting.getItem() instanceof ItemMiningTools)
//            event.player.addStat(AchievementMiningTools.MiningTools, 1);
//        else if (event.crafting.getItem() instanceof ItemMiningStick)
//            event.player.addStat(AchievementMiningTools.MiningStick, 1);
//        else if (event.crafting.getItem() instanceof ItemEnderStick)
//            event.player.addStat(AchievementMiningTools.EnderStick, 1);
//    }
//	@SubscribeEvent
//	public void onSmelting(PlayerEvent.ItemSmeltedEvent event)
//	{
//		if (event.smelting.getItem() == Core.ingotPlastic)
//			event.player.addStat(Core.getPlasticIngot, 1);
//	}
}
