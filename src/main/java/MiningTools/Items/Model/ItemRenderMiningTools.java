package MiningTools.Items.Model;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import MiningTools.Others.Proxy;

/**
 *
 * @author Redolyr75724
 *
 */
public class ItemRenderMiningTools implements IItemRenderer
{
    protected ModelItemMiningTools modeling;
    public ItemRenderMiningTools()
    {
        modeling = new ModelItemMiningTools();
    }
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
//        switch (type)
//        {
//        case EQUIPPED:
//        	return true;
//            
//        default:
//            break;
//        }
//        return false;
        return Proxy.proxy.handleRenderType_Rendering(Proxy.proxy.Config().GameRegistModel1, type);
    }
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return false;
    }
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
//    	Proxy.proxy.INVENTORY_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    	
        Proxy.proxy.ENTITY_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        Proxy.proxy.EQUIPPED_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        Proxy.proxy.EQUIPPED_FIRST_PERSON_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
//        Proxy.proxy.INVENTORY_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
//        Proxy.proxy.FIRST_PERSON_MAP_Rendering(Proxy.proxy.Config().GameRegistModel1, type, 2.5F, 0F, 8F, 125F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -10.0F, -0.304800F, -0.500F, -0.09F, "ModelItemMiningTools", modeling, (Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    }
}
