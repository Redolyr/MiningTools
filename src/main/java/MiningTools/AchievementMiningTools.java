package MiningTools;

import java.util.ArrayList;
import java.util.List;

import MiningTools.Others.Proxy;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public final class AchievementMiningTools
{
	public static Achievement MiningTools;
	public static Achievement MiningStick;
	public static Achievement EnderStick;
	
	public AchievementMiningTools()
	{
		EnderStick = new Achievement("MiningTools-3", "Ender Stick", 5, 5, Proxy.proxy.Items().EnderStick, (Achievement) null).initIndependentStat().registerStat();
		MiningStick = new Achievement("MiningTools-2", "Mining Stick", 0, 5, Proxy.proxy.Items().MiningStick, EnderStick).initIndependentStat().registerStat();
		MiningTools = new Achievement("MiningTools-1", "Mining Tools", 0, 0, Proxy.proxy.Items().MiningTools, MiningStick).initIndependentStat().registerStat();
		
		Achievement[] achievements = new Achievement[] {MiningTools, MiningStick, EnderStick};
		AchievementPage.registerAchievementPage(new AchievementPage(Proxy.proxy.String().Name_Tag_28362, achievements));
	}
}
