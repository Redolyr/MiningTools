package MiningTools.api;

import MiningTools.Blocks.BlockPacks;
import MiningTools.Data.stringData;
import MiningTools.Items.ItemPacks;
import MiningTools.Items.ItemToolTwo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class MainAPI
{
    public Configuration config;
    public static List<Block> blockList = new ArrayList<Block>();
    public static List<Item> itemList = new ArrayList<Item>();

    public static MainAPI Instance()
    {
        return new MainAPI();
    }
    public Boolean registerItem(Boolean on_off, ItemPacks items, ItemPacks classes, String unlocalizedName)
    {
        items = classes;
        items.setData(stringData.ResourceCode, unlocalizedName);
        itemList.add(items);
        return on_off;
    }
    public Boolean registerBlock(Boolean on_off, BlockPacks blocks, BlockPacks classes, String unlocalizedName, Float hardness, Float lightValue, Float resistance, Integer lightOpacity, Boolean registeredEnable)
    {
        blocks = classes;
        blocks.setData(stringData.ResourceCode, unlocalizedName, hardness, lightValue, resistance, lightOpacity, registeredEnable);
        blockList.add(blocks);
        return on_off;
    }
    public Boolean registerTool(Boolean on_off, ItemToolTwo items, ItemToolTwo classes, String unlocalizedName)
    {
        items = classes;
        items.setData(stringData.ResourceCode, unlocalizedName);
        return on_off;
    }
//    public Boolean registerItemModel(Boolean on_off, ItemPacks items, IItemRenderer itemRenderer)
//    {
//        MinecraftForgeClient.registerItemRenderer(items, itemRenderer);
//        return on_off;
//    }
//    public Boolean bindTexture(Boolean on_off, String path)
//    {
//        ForgeHooksClient.onTextureLoadPre(stringData.ResourceCode.replace(":", "/") + path);
//        return on_off;
//    }
    public GL11 glScalef(Float x, Float y, Float z)
    {
        GL11.glScalef(x, y, z);
        return null;
    }
    public GL11 glRotatef(Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3)
    {
        GL11.glRotatef(R1, G1, B1, WB1);
        GL11.glRotatef(R2, G2, B2, WB2);
        GL11.glRotatef(R3, G3, B3, WB3);
        return null;
    }
    public GL11 glTranslatef(Float x, Float y, Float z)
    {
        GL11.glTranslatef(x, y, z);
        return null;
    }
    public Boolean renderingModel(Boolean on_off, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5)
    {
        modeling.render(entity, f, f1, f2, f3, f4, f5);
        return on_off;
    }
//    public Boolean Model_Rendering(ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5)
//    {
//    	ENTITY_Rendering(this != null, type, scala, R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3, translatefx, translatefy, translatefz, texture, modeling, entity, f, f1, f2, f3, f4, f5);
//    	return this != null;
//    }
//    public void ENTITY_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5)
//    {
//        if (on_off)
//        {
//            switch (type)
//            {
//                case ENTITY:
//                {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(on_off, texture);
//                    renderingModel(on_off, modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//    public Boolean EQUIPPED_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5)
//    {
//        switch (type)
//        {
//            case EQUIPPED:
//            {
//                GL11.glPushMatrix();
//                glScalef(scala, scala, scala);
//                glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                glTranslatef(translatefx, translatefy, translatefz);
//                bindTexture(on_off, texture);
//                renderingModel(on_off, modeling, entity, f, f1, f2, f3, f4, f5);
//                GL11.glPopMatrix();
//            }
//
//            default:
//                break;
//        }
//
//        return on_off;
//    }
//    public void EQUIPPED_FIRST_PERSON_Rendering(Boolean on_off, ItemRenderType type, Float scala, Float R1, Float R2, Float R3, Float G1, Float G2, Float G3, Float B1, Float B2, Float B3, Float WB1, Float WB2, Float WB3, Float translatefx, Float translatefy, Float translatefz, String texture, ModelBase modeling, Entity entity, Float f, Float f1, Float f2, Float f3, Float f4, Float f5)
//    {
//        if (on_off)
//        {
//            switch (type)
//            {
//                case EQUIPPED_FIRST_PERSON:
//                {
//                    GL11.glPushMatrix();
//                    glScalef(scala, scala, scala);
//                    glRotatef(R1, R2, R3, G1, G2, G3, B1, B2, B3, WB1, WB2, WB3);
//                    glTranslatef(translatefx, translatefy, translatefz);
//                    bindTexture(on_off, texture);
//                    renderingModel(on_off, modeling, entity, f, f1, f2, f3, f4, f5);
//                    GL11.glPopMatrix();
//                }
//
//                default:
//                    break;
//            }
//        }
//    }
//    public Boolean handleRenderType_Rendering(Boolean on_off, Boolean models, ItemRenderType type)
//    {
//        if (on_off)
//        {
//            switch (type)
//            {
//            case ENTITY:
//            	return FancyFastLink() || models;
//            case EQUIPPED:
//            	return FancyFastLink() || models;
//            case EQUIPPED_FIRST_PERSON:
//            	return FancyFastLink() || models;
//            default:
//                break;
//            }
//            return false;
//        }
//        return false;
//    }
    public Boolean FancyFastLink()
    {
        return Minecraft.isFancyGraphicsEnabled();
    }
}
