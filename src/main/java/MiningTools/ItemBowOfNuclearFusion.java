package MiningTools;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBowOfNuclearFusion extends ItemBow
{
	@SideOnly(Side.CLIENT)
	private IIcon[] CAUION;
	
	public ItemBowOfNuclearFusion()
	{
		super();
		this.setNoRepair();
		this.setMaxStackSize(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister caution)
	{
		this.itemIcon = caution.registerIcon("tool:Test");
	}
	
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (flag || par3EntityPlayer.inventory.hasItem(MiningTools.Deuterium) && par3EntityPlayer.inventory.hasItem(MiningTools.Tritium) && par3EntityPlayer.inventory.hasItem(MiningTools.EmptyBucketCell))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.Deuterium);
                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.Tritium);
                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.EmptyBucketCell);
            }

            if (!par2World.isRemote)
            {
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("====================================================================="));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("Caution!! Caution!! Caution!! Caution!! Caution!! Caution!! Caution!!"));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("====================================================================="));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("||         The Sun " + '"' + "Nuclear Fusion Reaction" + '"' + "         ||"));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("====================================================================="));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("Caution!! Caution!! Caution!! Caution!! Caution!! Caution!! Caution!!"));
            	Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("====================================================================="));
                try
                {
					Thread.sleep(100);
				}
                catch (InterruptedException e)
				{
                	Thread.currentThread().interrupt();
				}
                par2World.spawnEntityInWorld(entityarrow);
                Minecraft.getMinecraft().theWorld.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
                Minecraft.getMinecraft().theWorld.setWorldTime(16000L);
                try
                {
//                	Thread.sleep(1048576);// (day) 11 : (time) 16 : 34 : 56
                	Thread.sleep(60000);//0:1:0
                }
                catch (InterruptedException e)
                {
                	Thread.currentThread().interrupt();
                }
                Minecraft.getMinecraft().theWorld.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
                par3EntityPlayer.dropItem(MiningTools.EmptyBucketCell, 1);
                par3EntityPlayer.dropItem(MiningTools.EmptyBucketCell, 1);
                par3EntityPlayer.dropItem(MiningTools.Plasma, 1);
            }
        }
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(MiningTools.Deuterium) && par3EntityPlayer.inventory.hasItem(MiningTools.Tritium) && par3EntityPlayer.inventory.hasItem(MiningTools.EmptyBucketCell))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
}
//1048576 = 280:34:56 = 11:16:34:56
//6 = 0:0:6
//70 = 0:1:10
//500 = 0:8
//8000 = 0:133 = 2:13
//40000 = 1:6:40
//1000000 = 277:6
//280 = (day) = 11:16:0:0

//600 = 10
//6000 = 100
//40000 = 4000
//3000 = 50
//3600 = 60
//4000 = 1:0:400 = 1:6:40

//1000000 = 0:16666 = 277:6

//1048576 = 0:0:6 + 0:1:10 + 0:8 + 2:13 + 1:6:40 + 277:6 = 0:1:16 + 2:21 + 278:12:40 = 2:22:16 + 278:12:40 = 280:34:56

//1 = 24:0:0
//10 = 240
//11 = 264
//12 = 288
//11:16:0:0

//