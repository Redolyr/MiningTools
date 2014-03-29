package MiningTools.Configration;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import MiningTools.Configration.RecipeData.RecipeHighMiningTools;
import MiningTools.Configration.RecipeData.RecipeIronUpgrade;
import MiningTools.Configration.RecipeData.RecipeLowMiningTools;
import MiningTools.Configration.RecipeData.RecipeOthers;
import MiningTools.Configration.RecipeData.RecipeStoneUpgrade;
import MiningTools.Others.Proxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Recipe
{
    public Recipe(FMLPreInitializationEvent event)
    {
        if (Proxy.proxy.Config().RecipeIO == true)
        {
	        //Proxy.proxy.Config().configSet = new CustomConfigrations(new File(event.getModConfigurationDirectory(), "MiningTools/Recipe.dat"));
	        Proxy.proxy.ConfigFile(event, "Recipe");
	
	        try
	        {
	            Proxy.proxy.Config().configSet.load();
	            Property data1 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_99897, "MiningTools Low Recipe", Proxy.proxy.Config().MiningToolsLowRecipe);
	            Property data2 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_99897, "MiningTools High Recipe", Proxy.proxy.Config().MiningToolsHighRecipe);
	            Property data3 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_99897, "Stone Tools Upgrade mode recipe", Proxy.proxy.Config().StoneUpgradeRecipe);
	            Property data4 = Proxy.proxy.Config().configSet.get(Proxy.proxy.String().Config_Data_99897, "Iron Tools Upgrade mode recipe", Proxy.proxy.Config().IronUpgradeRecipe);
	            data1.comment = "Mining Tools: Low Recipe";
	            data2.comment = "Mining Tools: High Recipe";
	            data3.comment = "Stone Tools Upgrade mode recipe";
	            data4.comment = "Iron Tools Upgrade mode recipe";
	
	            if (Proxy.proxy.Config().MiningToolsLowRecipe = data1.getBoolean(Proxy.proxy.Config().MiningToolsLowRecipe))
	            {
	                new RecipeLowMiningTools();
	            }
	
	            if (Proxy.proxy.Config().MiningToolsHighRecipe = data2.getBoolean(Proxy.proxy.Config().MiningToolsHighRecipe))
	            {
	                new RecipeHighMiningTools();
	            }
	
	            if (Proxy.proxy.Config().StoneUpgradeRecipe = data3.getBoolean(Proxy.proxy.Config().StoneUpgradeRecipe))
	            {
	                new RecipeStoneUpgrade();
	            }
	
	            if (Proxy.proxy.Config().IronUpgradeRecipe = data4.getBoolean(Proxy.proxy.Config().IronUpgradeRecipe))
	            {
	                new RecipeIronUpgrade();
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
	        new RecipeOthers();
        }
    }
}
