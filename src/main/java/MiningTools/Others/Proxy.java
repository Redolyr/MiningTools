package MiningTools.Others;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.lwjgl.opengl.GL11;

import MiningTools.Data.BlocksData;
import MiningTools.Data.ConfigData;
import MiningTools.Data.ItemsData;
import MiningTools.Data.intData;
import MiningTools.Data.stringData;
import MiningTools.Items.ItemPacks;

/**
 *
 * This Class [#link ProxyClient]<br>
 * is Proxy data server link
 *
 * @author Redolyr75724
 *
 */
public abstract class Proxy {
    @SidedProxy(modId = "MiningTools", clientSide = "MiningTools.Others.ProxyClient", serverSide = "MiningTools.Others.Proxy")
    public static Proxy proxy;
    protected Minecraft mc;
    private String loadedLanguage = getCurrentLanguage();
    private static Properties defaultMappings = new Properties();
    private static Properties mappings = new Properties();
    private static LinkedList<modInfo> mods = new LinkedList<modInfo>();
    boolean on_off = true;
    protected ItemStack itemStacks;
    private stringData stringData;
    private intData intData;
    private ConfigData config;
    private BlocksData blocks;
    private ItemsData items;

    public final String getMinecraftVersion() {
        return Loader.instance().getMinecraftModContainer().getVersion();
    }

    public Object getClient() {
        return null;
    }

    public World getClientWorld() {
        return null;
    }

    public boolean isSimulating(World world) {
        return !world.isRemote;
    }

    public boolean isRenderWorld(World world) {
        return world.isRemote;
    }

    public String getCurrentLanguage() {
        return FMLClientHandler.instance().getCurrentLanguage();
    }

    @SuppressWarnings("unchecked")
    public void addCraftingRecipe(ItemStack result, Object... recipe) {
//        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, recipe));
        //GameRegistry.addRecipe(result, recipe);
    }

    public void addShapelessRecipe(ItemStack result, Object... recipe) {
//        CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(result, recipe));
        //GameRegistry.addShapelessRecipe(result, recipe);
    }

    public Random createNewRandom(World world) {
        return new Random(world.getSeed());
    }

//    public void registerBlock(Block block) {
//        registerBlock(block, ItemBlock.class);
//    }

//    public void registerBlock(Block block, Class<? extends ItemBlock> item) {
//        GameRegistry.registerBlock(block, item, block.getUnlocalizedName().replace("tile.", ""));
//    }

//    public void registerItem(Item item) {
//        GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
//    }

    public void registerGui(Object obj, IGuiHandler handler) {
        NetworkRegistry.INSTANCE.registerGuiHandler(obj, handler);
    }

    public void registerTileAndGui(Class clas, String ident, Object obj, IGuiHandler handler) {
        this.registerTileEntity(clas, ident);
        this.registerGui(obj, handler);
    }

//    public void addCraftingRecipe(IRecipe recipe) {
//        CraftingManager.getInstance().getRecipeList().add(recipe);
//    }

    public void registerDimension(int id, DimensionType dimensionType, Class<? extends WorldProvider> provider, boolean keepLoaded) {
        DimensionManager.registerDimension(id, dimensionType);
    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
        TileEntity.register(id, tileEntityClass);
    }

    public ResourceLocation MiningToolsLocation(String domain) {
        return new ResourceLocation(getMiningToolsLocation().replace(":", ""), domain);
    }

    public String getMiningToolsLocation() {
        return replacePlusSmalling(String().ResourceCode).replace("Tool", "tool").replace(":", "") + ":";
//    	return String().ResourceCode.replace(":", "") + ":";
    }

    public ModelBiped getArmorModel(int id) {
        return null;
    }

    public void registerArmorItem(ItemArmor Head, ItemArmor Body, ItemArmor Leggins, ItemArmor Boots) {
//        GameRegistry.registerItem(Head, Head.getUnlocalizedName().replace("item.", ""));
//        GameRegistry.registerItem(Body, Body.getUnlocalizedName().replace("item.", ""));
//        GameRegistry.registerItem(Leggins, Leggins.getUnlocalizedName().replace("item.", ""));
//        GameRegistry.registerItem(Boots, Boots.getUnlocalizedName().replace("item.", ""));
    }

//    public void addCraftingRecipe(boolean on_off, ItemStack stacks, Object... obj) {
//        if (on_off) {
//            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(stacks, obj));
//        }
//    }

//    public String addEnumChatFormatingColorText(boolean on_off, ChatFormatting enumChatFormating, String formatingText) {
//        if (on_off) {
//            addName(ChatFormatting.AQUA + localize(formatingText));
//        }
//
//        return formatingText;
//    }

//    public String addName(String string) {
//        return string;
//    }
//
//    public String addName(Object obj, String string) {
//        LanguageRegistry.addName(obj, string);
//        return string;
//    }

    public void addInfomationText(List par1par3List, String Text, String Text2) {
        if (on_off == true) {
            par1par3List.add(ChatFormatting.YELLOW + localize(Text) + ": " + ChatFormatting.AQUA + localize(Text2));
        }

        if (on_off == false) {
            par1par3List.add((Text) + ": " + Text2);
        }
    }

    public void addInfomationText(List par1par3List, String Text) {
        if (on_off == true) {
            par1par3List.add(ChatFormatting.YELLOW + localize(Text));
        }

        if (on_off == false) {
            par1par3List.add(Text);
        }
    }

    public void addInfomationText(List par1par3List, String Text, String Text2, String Text3) {
        if (on_off == true) {
            par1par3List.add(ChatFormatting.RED + localize(Text) + ChatFormatting.YELLOW + localize(Text2) + ChatFormatting.AQUA + localize(Text3));
        }

        if (on_off == false) {
            par1par3List.add((Text) + ": " + Text2 + ": " + Text3);
        }
    }

    public void addInfomationText(List par1par3List, String Text, String Text2, String Text3, String Text4) {
        if (on_off == true) {
            par1par3List.add(ChatFormatting.YELLOW + localize(Text) + ": " + ChatFormatting.AQUA + localize(Text2) + ", " + ChatFormatting.YELLOW + localize(Text3) + ": " + ChatFormatting.AQUA + localize(Text4));
        }

        if (on_off == false) {
            par1par3List.add((Text) + ": " + Text2 + ", " + Text3 + ": " + Text4);
        }
    }

    public String localize(String key) {
        return get(key);
    }

    public synchronized String get(String key) {
        if (getCurrentLanguage() == null) {
            return key;
        }

        if (!getCurrentLanguage().equals(loadedLanguage)) {
            defaultMappings.clear();
            mappings.clear();

            for (modInfo mInfo : mods) {
                load(mInfo.modName, mInfo.defaultLanguage);
            }

            loadedLanguage = getCurrentLanguage();
        }

        return mappings.getProperty(key, defaultMappings.getProperty(key, key));
    }

    public synchronized boolean hasKey(String key) {
        if (getCurrentLanguage() == null) {
            return false;
        }

        if (!getCurrentLanguage().equals(loadedLanguage)) {
            defaultMappings.clear();
            mappings.clear();

            for (modInfo mInfo : mods) {
                load(mInfo.modName, mInfo.defaultLanguage);
            }

            loadedLanguage = getCurrentLanguage();
        }

        return mappings.getProperty(key, defaultMappings.getProperty(key)) != null;
    }

    public void load(String path, String default_language) {
        InputStream langStream = null;
        Properties modMappings = new Properties();

        try {
            // Load the default language mappings
            langStream = Proxy.class.getResourceAsStream(path + default_language + ".properties");
            modMappings.load(langStream);
            defaultMappings.putAll(modMappings);
            langStream.close();
            // Try to load the current language mappings.
            // If the file doesn't exist use the default mappings.
            langStream = Proxy.class.getResourceAsStream(path + getCurrentLanguage() + ".properties");

            if (langStream != null) {
                modMappings.clear();
                modMappings.load(langStream);
            }

            // If the selected language inherits mappings from another language
            // we use those first and then we overwrite the common ones with
            // those in the selected language
            if (modMappings.containsKey("language.parent")) {
                langStream = Proxy.class.getResourceAsStream(path + modMappings.get("language.parent") + ".properties");

                if (langStream != null) {
                    Properties parentModMappings = new Properties();
                    parentModMappings.load(langStream);
                    mappings.putAll(parentModMappings);
                }
            }

            mappings.putAll(modMappings);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (langStream != null) {
                    langStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public class modInfo {
        final String modName, defaultLanguage;

        public modInfo(String modName, String defaultLanguage) {
            this.modName = modName;
            this.defaultLanguage = defaultLanguage;
        }
    }

//    ToolMaterial toolMaterial;
//
//    public void ToolMaterialers(String Name, int harvestLevel, int maxUses, Float efficiency, Float damage, int enchantability, ItemPacks items) {
//        toolMaterial = EnumHelper.addToolMaterial(Name, harvestLevel, maxUses, efficiency, damage, enchantability);
//        toolMaterial.customCraftingMaterial = items;
//    }
//
//    public void ToolMaterialers(String Name, int harvestLevel, int maxUses, Float efficiency, Float damage, int enchantability, ItemStack items) {
//        toolMaterial = EnumHelper.addToolMaterial(Name, harvestLevel, maxUses, efficiency, damage, enchantability);
//        toolMaterial.customCraftingMaterial = items.getItem();
//    }
//
//    public void ToolMaterialers(String Name, int harvestLevel, int maxUses, Float efficiency, Float damage, int enchantability, Block blocks) {
//        toolMaterial = EnumHelper.addToolMaterial(Name, harvestLevel, maxUses, efficiency, damage, enchantability);
//        toolMaterial.customCraftingMaterial = Item.getItemFromBlock(blocks);
//    }

    public void bindTexture(String path) {
//        Minecraft.getMinecraft().renderEngine.bindTexture(MiningToolsLocation("textures/models/" + path + ".png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(MiningToolsLocation(String.format("tool/textures/%s/%s.png", "models", path)));
    }

    public static PlayerCapabilities playerControllingMainData() {
        return new PlayerCapabilities();
    }

    public void EnderDyeInformation(List par1par3List, String Text) {
        if (on_off == true || Text == "black") {
            par1par3List.add(ChatFormatting.BLACK + localize(Text));
        }
        if (on_off == true || Text == "red") {
            par1par3List.add(ChatFormatting.RED + localize(Text));
        }
        if (on_off == true || Text == "green") {
            par1par3List.add(ChatFormatting.GREEN + localize(Text));
        }
        if (on_off == true || Text == "blue") {
            par1par3List.add(ChatFormatting.BLUE + localize(Text));
        }
        if (on_off == true || Text == "purple") {
            par1par3List.add(ChatFormatting.LIGHT_PURPLE + localize(Text));
        }
        if (on_off == true || Text == "gray") {
            par1par3List.add(ChatFormatting.GRAY + localize(Text));
        }
        if (on_off == true || Text == "yellow") {
            par1par3List.add(ChatFormatting.YELLOW + localize(Text));
        }
        if (on_off == true || Text == "white") {
            par1par3List.add(ChatFormatting.WHITE + localize(Text));
        }
        if (on_off == false) {
            par1par3List.add(Text);
        }
    }

//    public void registerItem(ItemPacks items, String unlocalizedName, int craft, int meta, Object... obj) {
//        items.setData(getMiningToolsLocation(), unlocalizedName);
//        registerItem(items);
//        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(items, craft, meta), obj));
//    }
//
//    public void addRecipe(boolean on_off, boolean mode, Item items, int craftMath, int meta, Object... obj) {
//        if (on_off) {
//            if (mode == false) {
//                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(items, craftMath, meta), obj));
//            }
//
//            if (mode == true) {
//                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(items, craftMath, meta), obj));
//            }
//        }
//    }
//
//    public void addRecipe(boolean on_off, boolean mode, Block blocks, int craftMath, int meta, Object... obj) {
//        if (on_off) {
//            if (mode == true) {
//                CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blocks, craftMath, meta), obj));
//            }
//
//            if (mode == false) {
//                CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks, craftMath, meta), obj));
//            }
//        }
//    }
//
//    public void addFurnaceRecipe(boolean on_off, Item item, int metaData, Item items, int craftMath, int meta, Float droppedEXP) {
//        FurnaceRecipes.smelting().func_151394_a(new ItemStack(item, metaData), new ItemStack(items, craftMath, meta), droppedEXP);
//    }
//
//    public void addFurnaceRecipe(boolean on_off, Block block, int metaData, Item items, int craftMath, int meta, Float droppedEXP) {
//        FurnaceRecipes.smelting().func_151394_a(new ItemStack(block, metaData), new ItemStack(items, craftMath, meta), droppedEXP);
//    }
//
//    public void addFurnaceRecipe(boolean on_off, Item item, int metaData, Block blocks, int craftMath, int meta, Float droppedEXP) {
//        FurnaceRecipes.smelting().func_151394_a(new ItemStack(item, metaData), new ItemStack(blocks, craftMath, meta), droppedEXP);
//    }
//
//    public void addFurnaceRecipe(boolean on_off, Block block, int metaData, Block blocks, int craftMath, int meta, Float droppedEXP) {
//        FurnaceRecipes.smelting().func_151394_a(new ItemStack(block, metaData), new ItemStack(blocks, craftMath, meta), droppedEXP);
//    }
//
//    public void addDamageName(Item item, int meta, String name) {
//        Object obj = new ItemStack(item, 1, meta);
//        LanguageRegistry.instance().addName(obj, name);
//    }
//
//    public void addDamageName(Block block, int meta, String name) {
//        Object obj = new ItemStack(block, 1, meta);
//        LanguageRegistry.instance().addName(obj, name);
//    }

    public Object[] addObjectRecipe(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return new Object[]{"ABC", "DEF", "GHI", 'A', obj1, 'B', obj2, 'C', obj3, 'D', obj4, 'E', obj5, 'F', obj6, 'G', obj7, 'H', obj8, 'I', obj9};
    }

    public ItemStack addItemRecipe(Item item, int craftMath, int meta) {
        return new ItemStack(item, craftMath, meta);
    }

    public ItemStack addBlockRecipe(Block block, int craftMath, int meta) {
        return new ItemStack(block, craftMath, meta);
    }

//    public void addRecipe(Item item, int craftMath, int meta, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
//        CraftingManager.getInstance().addRecipe(addItemRecipe(item, craftMath, meta), addObjectRecipe(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
//    }
//
//    public void addRecipe(Block block, int craftMath, int meta, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
//        CraftingManager.getInstance().addRecipe(addBlockRecipe(block, craftMath, meta), addObjectRecipe(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
//    }

    public GL11 glScalef(Float x, Float y, Float z) {
        GL11.glScalef(x, y, z);
        return null;
    }

    public GL11 glRotatef(Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3) {
        GL11.glRotatef(R1, G1, B1, WB1);
        GL11.glRotatef(R2, G2, B2, WB2);
        GL11.glRotatef(R3, G3, B3, WB3);
        return null;
    }

    public GL11 glTranslatef(Float x, Float y, Float z) {
        GL11.glTranslatef(x, y, z);
        return null;
    }

    public void renderingModel(ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
        modeling.render(entity, f, f1, f2, f3, f4, f5);
    }

//    public void MASTER_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case ENTITY:
//                case EQUIPPED:
//                case EQUIPPED_FIRST_PERSON:
//                case INVENTORY:
//                case FIRST_PERSON_MAP: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public void ENTITY_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case ENTITY: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public void EQUIPPED_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case EQUIPPED: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public void EQUIPPED_FIRST_PERSON_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case EQUIPPED_FIRST_PERSON: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public void INVENTORY_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case INVENTORY: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public void FIRST_PERSON_MAP_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5) {
//        if (on_off) {
//            switch (type) {
//                case FIRST_PERSON_MAP: {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(texture);
//                    renderingModel(modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public boolean handleRenderType_Rendering(Boolean on_off, ItemRenderType type) {
//        if (on_off) {
//            switch (type) {
//                case ENTITY:
//                    return FancyFastLink();
//                case EQUIPPED:
//                    return FancyFastLink();
//                case EQUIPPED_FIRST_PERSON:
//                    return FancyFastLink();
////            case INVENTORY:
////            	return FancyFastLink();
////            case FIRST_PERSON_MAP:
////            	return FancyFastLink();
//
//                default:
//                    break;
//            }
//            return false;
//        }
//
//        return false;
//    }

//    public EntityRegistry registerEntity() {
//        return null;
//    }

//    public void renderingEntity(Class<? extends Entity> entity, String entityName_Unlocalizedname, int entityID, Render render) {
//        EntityRegistry.registerGlobalEntityID(entity, entityName_Unlocalizedname, entityID);
//        RenderManager.instance.entityRenderMap.put(entity, render);
//    }

    public void removeRecipe(Boolean on_off, ItemStack par1ItemStack) {
//        List recipes = CraftingManager.getInstance().getRecipeList();
//
//        for (Iterator i = recipes.listIterator(); i.hasNext(); ) {
//            IRecipe recipe = (IRecipe) i.next();
//            ItemStack is = recipe.getRecipeOutput();
//
//            if (is != null) {
//                if (is == par1ItemStack) {
//                    i.remove();
//                }
//            }
//        }
    }

    public void removeRecipe(Boolean on_off, Item items, Integer removeMath, Integer meta) {
        removeRecipe(on_off, new ItemStack(items, removeMath, meta));
    }

    public void removeRecipe(Boolean on_off, Block blocks, Integer removeMath, Integer meta) {
        removeRecipe(on_off, new ItemStack(blocks, removeMath, meta));
    }

    public void removeRecipe(Boolean on_off, Item items, Integer removeMath) {
        removeRecipe(on_off, new ItemStack(items, removeMath, 0));
    }

    public void removeRecipe(Boolean on_off, Block blocks, Integer removeMath) {
        removeRecipe(on_off, new ItemStack(blocks, removeMath, 0));
    }

    public void removeRecipe(Boolean on_off, Item items) {
        removeRecipe(on_off, new ItemStack(items, 1));
    }

    public void removeRecipe(Boolean on_off, Block blocks) {
        removeRecipe(on_off, new ItemStack(blocks, 1));
    }

    public void ItemStack(Block par1, Integer par2, Integer par3) {
        new ItemStack(par1, par2, par3);
    }

    public void ItemStack(Block par1, Integer par2) {
        ItemStack(par1, par2, 0);
    }

    public void ItemStack(Block par1) {
        ItemStack(par1, 1);
    }

    public void ItemStack(Item par1, Integer par2, Integer par3) {
        new ItemStack(par1, par2, par3);
    }

    public void ItemStack(Item par1, Integer par2) {
        ItemStack(par1, par2, 0);
    }

    public void ItemStack(Item par1) {
        ItemStack(par1, 1);
    }

    public ItemStack ItemStack(ItemStack par1) {
        return par1;
    }

    public GameSettings GameSettingInstance() {
        return new GameSettings();
    }

    public Boolean GameSettingsFancyGraphics(Boolean on_off, Boolean fancy) {
        if (GameSettingInstance().fancyGraphics == true) {
            fancy = true;
        } else if (GameSettingInstance().fancyGraphics == false) {
            fancy = false;
        }

        return on_off;
    }

    public Boolean FancyFastLink() {
        return Minecraft.isFancyGraphicsEnabled();
    }

    public void ConfigFile(FMLPreInitializationEvent event, String fileName) {
        ConfigData.configSet = new Configuration(new File(event.getModConfigurationDirectory(), "MiningTools/" + fileName + ".dat"));
    }

//    public void addNameForObject(boolean on_off, Object obj, String en_US, String de_DE, String ja_JP) {
//        if (on_off) {
//            LanguageRegistry.instance().addNameForObject(obj, "en_US", en_US);
//            LanguageRegistry.instance().addNameForObject(obj, "de_DE", de_DE);
//            LanguageRegistry.instance().addNameForObject(obj, "ja_JP", ja_JP);
//        }
//    }
//
//    public void addNameForObject(boolean on_off, ChatFormatting enumChatFormatteing, Object obj, String en_US, String de_DE, String ja_JP) {
//        if (on_off) {
//            LanguageRegistry.instance().addNameForObject(obj, "en_US", enumChatFormatteing + localize(en_US));
//            LanguageRegistry.instance().addNameForObject(obj, "de_DE", enumChatFormatteing + localize(de_DE));
//            LanguageRegistry.instance().addNameForObject(obj, "ja_JP", enumChatFormatteing + localize(ja_JP));
//        }
//    }
//
//    public void addStringLocalization(String text, String en_US, String de_DE, String ja_JP) {
//        LanguageRegistry.instance().addStringLocalization(text, "en_US", en_US);
//        LanguageRegistry.instance().addStringLocalization(text, "de_DE", de_DE);
//        LanguageRegistry.instance().addStringLocalization(text, "ja_JP", ja_JP);
//    }

//    public void registerItem(Item items, String registerUnlocalizedName) {
//        registerItem(items);
//        addName(items, registerUnlocalizedName);
//    }
//
//    public void registerBlock(Block blocks, String registerUnlocalizedName) {
//        registerBlock(blocks);
//        addName(blocks, registerUnlocalizedName);
//    }

    private ItemStack itemStack = null;
    private Integer damage = null;

    public ItemStack getColorFromItemStack(ItemStack itemStack) {
        return this.itemStack = itemStack;
    }

    public Integer getColorFromDamage(Integer damage) {
        return this.damage = damage;
    }

    public Integer getColorFromItem(Integer R, Integer G, Integer B) {
        if (itemStack.getItemDamage() == damage) {
            return getSubColorChart(R, G, B);
        }
        return null;
    }

    public Integer getSubColorChart(Integer R, Integer G, Integer B) {
        return Integer.parseInt(getSubColorChartString(R, G, B));
    }

    public String getSubColorChartString(Integer R, Integer G, Integer B) {
        return "0x" + SixTeenBytes(R) + SixTeenBytes(G) + SixTeenBytes(B);
    }

    public String SixTeenBytes(Integer colors) {
        String colours = null;
        switch (colors) {
            // 0 Byte of Colours
            case 0:
                colours = "00";
                break;
            case 1:
                colours = "01";
                break;
            case 2:
                colours = "02";
                break;
            case 3:
                colours = "03";
                break;
            case 4:
                colours = "04";
                break;
            case 5:
                colours = "05";
                break;
            case 6:
                colours = "06";
                break;
            case 7:
                colours = "07";
                break;
            case 8:
                colours = "08";
                break;
            case 9:
                colours = "09";
                break;
            case 10:
                colours = "0A";
                break;
            case 11:
                colours = "0B";
                break;
            case 12:
                colours = "0C";
                break;
            case 13:
                colours = "0D";
                break;
            case 14:
                colours = "0E";
                break;
            case 15:
                colours = "0F";
                break;
            // 1 Byte of Colours
            case 16:
                colours = "10";
                break;
            case 17:
                colours = "11";
                break;
            case 18:
                colours = "12";
                break;
            case 19:
                colours = "13";
                break;
            case 20:
                colours = "14";
                break;
            case 21:
                colours = "15";
                break;
            case 22:
                colours = "16";
                break;
            case 23:
                colours = "17";
                break;
            case 24:
                colours = "18";
                break;
            case 25:
                colours = "19";
                break;
            case 26:
                colours = "1A";
                break;
            case 27:
                colours = "1B";
                break;
            case 28:
                colours = "1C";
                break;
            case 29:
                colours = "1D";
                break;
            case 30:
                colours = "1E";
                break;
            case 31:
                colours = "1F";
                break;
            // 2 Byte of Colours
            case 32:
                colours = "20";
                break;
            case 33:
                colours = "21";
                break;
            case 34:
                colours = "22";
                break;
            case 35:
                colours = "23";
                break;
            case 36:
                colours = "24";
                break;
            case 37:
                colours = "25";
                break;
            case 38:
                colours = "26";
                break;
            case 39:
                colours = "27";
                break;
            case 40:
                colours = "28";
                break;
            case 41:
                colours = "29";
                break;
            case 42:
                colours = "2A";
                break;
            case 43:
                colours = "2B";
                break;
            case 44:
                colours = "2C";
                break;
            case 45:
                colours = "2D";
                break;
            case 46:
                colours = "2E";
                break;
            case 47:
                colours = "2F";
                break;
            // 3 Byte of Colours
            case 48:
                colours = "30";
                break;
            case 49:
                colours = "31";
                break;
            case 50:
                colours = "32";
                break;
            case 51:
                colours = "33";
                break;
            case 52:
                colours = "34";
                break;
            case 53:
                colours = "35";
                break;
            case 54:
                colours = "36";
                break;
            case 55:
                colours = "37";
                break;
            case 56:
                colours = "38";
                break;
            case 57:
                colours = "39";
                break;
            case 58:
                colours = "3A";
                break;
            case 59:
                colours = "3B";
                break;
            case 60:
                colours = "3C";
                break;
            case 61:
                colours = "3D";
                break;
            case 62:
                colours = "3E";
                break;
            case 63:
                colours = "3F";
                break;
            // 4 Byte of Colours
            case 64:
                colours = "40";
                break;
            case 65:
                colours = "41";
                break;
            case 66:
                colours = "42";
                break;
            case 67:
                colours = "43";
                break;
            case 68:
                colours = "44";
                break;
            case 69:
                colours = "45";
                break;
            case 70:
                colours = "46";
            case 71:
                colours = "47";
                break;
            case 72:
                colours = "48";
                break;
            case 73:
                colours = "49";
                break;
            case 74:
                colours = "4A";
                break;
            case 75:
                colours = "4B";
                break;
            case 76:
                colours = "4C";
                break;
            case 77:
                colours = "4D";
                break;
            case 78:
                colours = "4E";
                break;
            case 79:
                colours = "4F";
                break;
            // 5 Byte of Colours
            case 80:
                colours = "50";//
                break;
            case 81:
                colours = "51";
                break;
            case 82:
                colours = "52";
                break;
            case 83:
                colours = "53";
                break;
            case 84:
                colours = "54";
                break;
            case 85:
                colours = "55";
                break;
            case 86:
                colours = "56";
                break;
            case 87:
                colours = "57";
                break;
            case 88:
                colours = "58";
                break;
            case 89:
                colours = "59";
                break;
            case 90:
                colours = "5A";
                break;
            case 91:
                colours = "5B";
                break;
            case 92:
                colours = "5C";
                break;
            case 93:
                colours = "5D";
                break;
            case 94:
                colours = "5E";
                break;
            case 95:
                colours = "5F";
                break;
            // 6 Byte of Colours
            case 96:
                colours = "60";
                break;
            case 97:
                colours = "61";
                break;
            case 98:
                colours = "62";
                break;
            case 99:
                colours = "63";
                break;
            case 100:
                colours = "64";
                break;
            case 101:
                colours = "65";
                break;
            case 102:
                colours = "66";
                break;
            case 103:
                colours = "67";
                break;
            case 104:
                colours = "68";
                break;
            case 105:
                colours = "69";
                break;
            case 106:
                colours = "6A";
                break;
            case 107:
                colours = "6B";
                break;
            case 108:
                colours = "6C";
                break;
            case 109:
                colours = "6D";
                break;
            case 110:
                colours = "6E";
                break;
            case 111:
                colours = "6F";
                break;
            // 7 Byte of Colours
            case 112:
                colours = "70";
                break;
            case 113:
                colours = "71";
                break;
            case 114:
                colours = "72";
                break;
            case 115:
                colours = "73";
                break;
            case 116:
                colours = "74";
                break;
            case 117:
                colours = "75";
                break;
            case 118:
                colours = "76";
                break;
            case 119:
                colours = "77";
                break;
            case 120:
                colours = "78";
                break;
            case 121:
                colours = "79";
                break;
            case 122:
                colours = "7A";
                break;
            case 123:
                colours = "7B";
                break;
            case 124:
                colours = "7C";
                break;
            case 125:
                colours = "7D";
                break;
            case 126:
                colours = "7E";
                break;
            case 127:
                colours = "7F";
                break;
            // 8 Byte of Colours
            case 128:
                colours = "80";
                break;
            case 129:
                colours = "81";
                break;
            case 130:
                colours = "82";
                break;
            case 131:
                colours = "83";
                break;
            case 132:
                colours = "84";
                break;
            case 133:
                colours = "85";
                break;
            case 134:
                colours = "86";
                break;
            case 135:
                colours = "87";
                break;
            case 136:
                colours = "88";
                break;
            case 137:
                colours = "89";
                break;
            case 138:
                colours = "8A";
                break;
            case 139:
                colours = "8B";
                break;
            case 140:
                colours = "8C";
                break;
            case 141:
                colours = "8D";
                break;
            case 142:
                colours = "8E";
                break;
            case 143:
                colours = "8F";
                break;
            // 9 Byte of Colours
            case 144:
                colours = "90";
                break;
            case 145:
                colours = "91";
                break;
            case 146:
                colours = "92";
                break;
            case 147:
                colours = "93";
                break;
            case 148:
                colours = "94";
                break;
            case 149:
                colours = "95";
                break;
            case 150:
                colours = "96";
                break;
            case 151:
                colours = "97";
                break;
            case 152:
                colours = "98";
                break;
            case 153:
                colours = "99";
                break;
            case 154:
                colours = "9A";
                break;
            case 155:
                colours = "9B";
                break;
            case 156:
                colours = "9C";
                break;
            case 157:
                colours = "9D";
                break;
            case 158:
                colours = "9E";
                break;
            case 159:
                colours = "9F";
                break;
            // A Byte of Colours
            case 160:
                colours = "A0";
                break;
            case 161:
                colours = "A1";
                break;
            case 162:
                colours = "A2";
                break;
            case 163:
                colours = "A3";
                break;
            case 164:
                colours = "A4";
                break;
            case 165:
                colours = "A5";
                break;
            case 166:
                colours = "A6";
                break;
            case 167:
                colours = "A7";
                break;
            case 168:
                colours = "A8";
                break;
            case 169:
                colours = "A9";
                break;
            case 170:
                colours = "AA";
                break;
            case 171:
                colours = "AB";
                break;
            case 172:
                colours = "AC";
                break;
            case 173:
                colours = "AD";
                break;
            case 174:
                colours = "AE";
                break;
            case 175:
                colours = "AF";
                break;
            // B Byte of Colours
            case 176:
                colours = "B0";
                break;
            case 177:
                colours = "B1";
                break;
            case 178:
                colours = "B2";
                break;
            case 179:
                colours = "B3";
                break;
            case 180:
                colours = "B4";
                break;
            case 181:
                colours = "B5";
                break;
            case 182:
                colours = "B6";
                break;
            case 183:
                colours = "B7";
                break;
            case 184:
                colours = "B8";
                break;
            case 185:
                colours = "B9";
                break;
            case 186:
                colours = "BA";
                break;
            case 187:
                colours = "BB";
                break;
            case 188:
                colours = "BC";
                break;
            case 189:
                colours = "BD";
                break;
            case 190:
                colours = "BE";
                break;
            case 191:
                colours = "BF";
                break;
            // C Byte of Colours
            case 192:
                colours = "C0";
                break;
            case 193:
                colours = "C1";
                break;
            case 194:
                colours = "C2";
                break;
            case 195:
                colours = "C3";
                break;
            case 196:
                colours = "C4";
                break;
            case 197:
                colours = "C5";
                break;
            case 198:
                colours = "C6";
                break;
            case 199:
                colours = "C7";
                break;
            case 200:
                colours = "C8";
                break;
            case 201:
                colours = "C9";
                break;
            case 202:
                colours = "CA";
                break;
            case 203:
                colours = "CB";
                break;
            case 204:
                colours = "CC";
                break;
            case 205:
                colours = "CD";
                break;
            case 206:
                colours = "CE";
                break;
            case 207:
                colours = "CF";
                break;
            // D Byte of Colours
            case 208:
                colours = "D0";
                break;
            case 209:
                colours = "D1";
                break;
            case 210:
                colours = "D2";
                break;
            case 211:
                colours = "D3";
                break;
            case 212:
                colours = "D4";
                break;
            case 213:
                colours = "D5";
                break;
            case 214:
                colours = "D6";
                break;
            case 215:
                colours = "D7";
                break;
            case 216:
                colours = "D8";
                break;
            case 217:
                colours = "D9";
                break;
            case 218:
                colours = "DA";
                break;
            case 219:
                colours = "DB";
                break;
            case 220:
                colours = "DC";
                break;
            case 221:
                colours = "DD";
                break;
            case 222:
                colours = "DE";
                break;
            case 223:
                colours = "DF";
                break;
            // E Byte of Colours
            case 224:
                colours = "E0";
                break;
            case 225:
                colours = "E1";
                break;
            case 226:
                colours = "E2";
                break;
            case 227:
                colours = "E3";
                break;
            case 228:
                colours = "E4";
                break;
            case 229:
                colours = "E5";
                break;
            case 230:
                colours = "E6";
                break;
            case 231:
                colours = "E7";
                break;
            case 232:
                colours = "E8";
                break;
            case 233:
                colours = "E9";
                break;
            case 234:
                colours = "EA";
                break;
            case 235:
                colours = "EB";
                break;
            case 236:
                colours = "EC";
                break;
            case 237:
                colours = "ED";
                break;
            case 238:
                colours = "EE";
                break;
            case 239:
                colours = "EF";
                break;
            // E Byte of Colours
            case 240:
                colours = "F0";
                break;
            case 241:
                colours = "F1";
                break;
            case 242:
                colours = "F2";
                break;
            case 243:
                colours = "F3";
                break;
            case 244:
                colours = "F4";
                break;
            case 245:
                colours = "F5";
                break;
            case 246:
                colours = "F6";
                break;
            case 247:
                colours = "F7";
                break;
            case 248:
                colours = "F8";
                break;
            case 249:
                colours = "F9";
                break;
            case 250:
                colours = "FA";
                break;
            case 251:
                colours = "FB";
                break;
            case 252:
                colours = "FC";
                break;
            case 253:
                colours = "FD";
                break;
            case 254:
                colours = "FE";
                break;
            case 255:
                colours = "FF";
                break;
        }
        return colours;
    }

    public abstract void SoundRegistry();

    public stringData String() {
        return stringData;
    }

    public intData Integer() {
        return intData;
    }

    public ConfigData Config() {
        return config;
    }

    public BlocksData Blocks() {
        return blocks;
    }

    public ItemsData Items() {
        return items;
    }

    public String replacePlus(String replacement, String[] after, String[] before) {
        String aftered = null, befored = null;
        for (Integer aftering = 0; aftering < after.length; ++aftering)
            aftered = after[aftering];
        for (Integer beforeing = 0; beforeing < before.length; ++beforeing)
            befored = before[beforeing];
        return replacement.replace(aftered, befored);
    }

    public String replacePlusSmalling(String replacement) {
        String[] KeyBinding_Large = new String[]{String().Key_A,
                String().Key_B,
                String().Key_C,
                String().Key_D,
                String().Key_E,
                String().Key_F,
                String().Key_G,
                String().Key_H,
                String().Key_I,
                String().Key_J,
                String().Key_K,
                String().Key_L,
                String().Key_M,
                String().Key_N,
                String().Key_O,
                String().Key_P,
                String().Key_Q,
                String().Key_R,
                String().Key_S,
                String().Key_T,
                String().Key_U,
                String().Key_V,
                String().Key_W,
                String().Key_X,
                String().Key_Y,
                String().Key_Z};
        String[] KeyBinding_Small = new String[]{String().Key_a,
                String().Key_b,
                String().Key_c,
                String().Key_d,
                String().Key_e,
                String().Key_f,
                String().Key_g,
                String().Key_h,
                String().Key_i,
                String().Key_j,
                String().Key_k,
                String().Key_l,
                String().Key_m,
                String().Key_n,
                String().Key_o,
                String().Key_p,
                String().Key_q,
                String().Key_r,
                String().Key_s,
                String().Key_t,
                String().Key_y,
                String().Key_v,
                String().Key_w,
                String().Key_x,
                String().Key_y,
                String().Key_z};
        return replacePlus(replacement, KeyBinding_Large, KeyBinding_Small);
    }

//    public String addName(Boolean enable, Object obj, String name) {
//        if (enable == true)
//            return addName(obj, name);
//        return addName(obj, name);
//    }

    public abstract void ConfigurationInitializationEvent(Boolean enable, Boolean ItemsIO, Boolean BlocksIO, Boolean ModelIO, Boolean RecipeIO);

    public void BusRegister(Boolean enable) {
        if (enable == true) {
            FMLCommonHandler.instance().bus().register(new ProxyClient());
        }
    }

    public abstract void PreInitializationEventHandlers(FMLPreInitializationEvent event);

    public File getMinecraftDirectory() {
        return Minecraft.getMinecraft().mcDataDir;
    }
}
