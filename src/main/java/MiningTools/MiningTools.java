package MiningTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import MiningTools.Configration.BlockIO;
import MiningTools.Configration.ItemIO;
import MiningTools.Configration.ModelIO;
import MiningTools.Configration.Recipe;
import MiningTools.Data.stringData;
import MiningTools.Items.ItemPacks;
import MiningTools.Others.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * This Class [#link MiningTools],
 * Forge Mod Loader is Main Class.
 *
 * @author Redolyr75724
 *
 */

@Mod(
    modid = "MiningTools",
    name = "MiningTools Modifications (Alpha)",
    version = stringData.Mod_Version
)
public class MiningTools
{
    public static final CreativeTabs tabsMiningTools = new CreativeTabs("MiningTools")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Proxy.proxy.Items().MiningTools;
        }
    };
    
    public static Item EmptyBucketCell;
    public static Item Hydrogen;
    public static Item Deuterium;
    public static Item Tritium;
    public static Item Plasma;
    public static ItemBow BowOfNuclearFusion;
    
    public static ItemPacks MetaTest;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Proxy.proxy.ConfigurationInitializationEvent(true, true, true, true, true);
//    	Proxy.proxy.PreInitializationEventHandlers(event);
        if (true)
        {
//        	new ItemID(event);
//        	new BlockID(event);
        	new ItemIO(event);
        	new BlockIO(event);
        	new ModelIO(event);
        	new Recipe(event);
        	new AchievementMiningTools();
        	Proxy.proxy.BusRegister(true);
        }
        
        if (true)
        {
        	EmptyBucketCell = new ItemEmptyBucketCell().setUnlocalizedName("EmptyBucketCell").setCreativeTab(tabsMiningTools);
        	Hydrogen = new ItemEmptyBucketCell().setUnlocalizedName("HydrogenCell").setCreativeTab(tabsMiningTools);
        	Deuterium = new ItemEmptyBucketCell().setUnlocalizedName("DeuteriumCell").setCreativeTab(tabsMiningTools);
        	Tritium = new ItemEmptyBucketCell().setUnlocalizedName("TritiumCell").setCreativeTab(tabsMiningTools);
        	Plasma = new ItemEmptyBucketCell().setUnlocalizedName("PlasmaCell").setCreativeTab(tabsMiningTools);
        	BowOfNuclearFusion = (ItemBow) new ItemBowOfNuclearFusion().setUnlocalizedName("BowOfNuclearFusion").setCreativeTab(tabsMiningTools);
        	Proxy.proxy.registerItem(EmptyBucketCell);
        	Proxy.proxy.registerItem(Hydrogen);
        	Proxy.proxy.registerItem(Deuterium);
        	Proxy.proxy.registerItem(Tritium);
        	Proxy.proxy.registerItem(Plasma);
        	Proxy.proxy.registerItem(BowOfNuclearFusion);
        }
        
        if (true)
        {
        	MetaTest = new ItemMetaPacks();
        	Proxy.proxy.registerItem(MetaTest);
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
//NBTBase