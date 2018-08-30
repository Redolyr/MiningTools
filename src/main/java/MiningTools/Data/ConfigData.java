package MiningTools.Data;

/**
 *
 * @author Redolyr75724
 *
 */
public class ConfigData
{
    public static net.minecraftforge.common.config.Configuration configSet;
    public static Boolean MiningToolsLowRecipe = true;
    public static Boolean MiningToolsHighRecipe = false;
    public static Boolean StoneUpgradeRecipe = true;
    public static Boolean IronUpgradeRecipe = true;

    public static Boolean GameRegistItem1 = true;
    public static Boolean GameRegistItem2 = true;
    public static Boolean GameRegistItem3 = true;
    public static Boolean GameRegistItem4 = true;
    public static Boolean GameRegistItem5 = true;
    public static Boolean GameRegistItem6 = true;

    public static Boolean GameRegistBlock1 = true;

    public static Boolean NetworkRegistClient = true;
    public static Boolean NetworkRegistServer = true;
    public static final Boolean settingClient = NetworkRegistClient;
    public static final Boolean settingServer = NetworkRegistServer;
    
    public static Boolean GameRegistModel1 = true;
    
    public static Boolean BlocksIO = false;
    public static Boolean ItemsIO = false;
    public static Boolean ModelIO = false;
    public static Boolean RecipeIO = false;
}
