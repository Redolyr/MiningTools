package MiningTools.Items;

import MiningTools.Interface.IInformation;
import MiningTools.MiningTools;
import MiningTools.Others.Proxy;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

/**
 * This Class [#link BlockPacks] This Mod Contianer Link Master Class
 * is BlockPacks Link Block Data Container Link is Others Class This Mod Block Class Extendsments
 *
 * @author redolyr
 */
public abstract class ItemPacks extends Item implements IInformation {
    protected ItemStack itemStacks = new ItemStack(this);
    public Item items;
    protected boolean isLShiftRotations, isRShiftRotations;

    protected Block blocks;

    protected Boolean informaiton_Boolean = true;

    private static String domain, names;

    public ItemPacks(String domain, String itemName) {
        super();
        if (Proxy.proxy.Config().GameRegistItem1 == true) this.setCreativeTab(MiningTools.tabsMiningTools);
        else this.setCreativeTab(CreativeTabs.COMBAT);
        this.setData(domain, itemName);
    }

    public Item setData(String par1Str, String par2Str) {
        items = setUnlocalizedName(par2Str);
        domain = par1Str;
        names = par2Str;
        return this;
    }

    public Item setData(String par1Str, String par2Str, boolean isItem3D) {
        items = setUnlocalizedName(par2Str);
        bFull3D = isItem3D;
        domain = par1Str;
        names = par2Str;
        return this;
    }

    public ItemPacks getData() {
        items = this;
        isFull3D();
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (informaiton_Boolean == true) ;
        this.setInformation(worldIn, tooltip);
    }

    public void setInformation(World par2EntityPlayer, List par3List) {
        par3List.add("ID: " + this);
        par3List.add("Damage: " + this.itemStacks.getItemDamage() + "/" + this.itemStacks.getMaxDamage());
    }

    protected void isLShiftMessage(List par3List) {
        isLShiftRotations = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
        if (isLShiftRotations == false) {
            Proxy.proxy.addInfomationText(par3List, "press.LShift.infomation");
        }
    }

    protected void isRShiftMessage(List par3List) {
        isRShiftRotations = Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        if (isRShiftRotations == false) {
            Proxy.proxy.addInfomationText(par3List, "press.RShift.infomation");
        }
    }

    public final String replace(ItemPacks itemPacks) {
        return itemPacks.getUnlocalizedName().replace("item.", "").replace(".name", "");
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityLivingBase par3EntityPlayer, int par4) {
        if (!(par3EntityPlayer instanceof EntityPlayer)) return;
        EntityPlayer entityPlayer = (EntityPlayer) par3EntityPlayer;
        boolean flag = entityPlayer.isCreative() || EnchantmentHelper.getEnchantmentLevel(Enchantment.REGISTRY.getObject(new ResourceLocation("INFINITY")), par1ItemStack) > 0;

        if (entityPlayer.inventory.hasItemStack(new ItemStack(Proxy.proxy.Items().OfflineInTheInformation))) {
            if (flag) {
                informaiton_Boolean = true;
            } else {
//                entityPlayer.inventory.consumeInventoryItem(Proxy.proxy.Items().OfflineInTheInformation);
            }

            if (!par2World.isRemote) {
                informaiton_Boolean = true;
            }
            informaiton_Boolean = false;
        }
    }

    public CreativeTabs[] getCreativeTabs() {
        return new CreativeTabs[]{MiningTools.tabsMiningTools};
    }
}
