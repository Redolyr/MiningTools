package MiningTools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBowOfNuclearFusion extends ItemBow {
    public ItemBowOfNuclearFusion() {
        super();
        this.setNoRepair();
        this.setMaxStackSize(0);
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
//        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
//
//        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
//        MinecraftForge.EVENT_BUS.post(event);
//        if (event.isCanceled()) {
//            return;
//        }
//        j = event.charge;
//
//        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
//
//        if (flag || par3EntityPlayer.inventory.hasItem(MiningTools.Deuterium) && par3EntityPlayer.inventory.hasItem(MiningTools.Tritium) && par3EntityPlayer.inventory.hasItem(MiningTools.EmptyBucketCell)) {
//            float f = (float) j / 20.0F;
//            f = (f * f + f * 2.0F) / 3.0F;
//
//            if ((double) f < 0.1D) {
//                return;
//            }
//
//            if (f > 1.0F) {
//                f = 1.0F;
//            }
//
//            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer) {
//                @Override
//                protected ItemStack getArrowStack() {
//                    return null;
//                }
//            };
//
//            if (f == 1.0F) {
//                entityarrow.setIsCritical(true);
//            }
//
//            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
//
//            if (k > 0) {
//                entityarrow.setDamage(entityarrow.getDamage() + (double) k * 0.5D + 0.5D);
//            }
//
//            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
//
//            if (l > 0) {
//                entityarrow.setKnockbackStrength(l);
//            }
//
//            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
//                entityarrow.setFire(100);
//            }
//
//            par1ItemStack.damageItem(1, par3EntityPlayer);
//            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
//
//            if (flag) {
//                entityarrow.canBePickedUp = 2;
//            } else {
//                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.Deuterium);
//                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.Tritium);
//                par3EntityPlayer.inventory.consumeInventoryItem(MiningTools.EmptyBucketCell);
//            }
//
//            if (!par2World.isRemote) {
//                Minecraft.getMinecraft().player.sendChatMessage(("====================================================================="));
//                Minecraft.getMinecraft().player.sendChatMessage(("Caution!! Caution!! Caution!! Caution!! Caution!! Caution!! Caution!!"));
//                Minecraft.getMinecraft().player.sendChatMessage(("====================================================================="));
//                Minecraft.getMinecraft().player.sendChatMessage(("||         The Sun " + '"' + "Nuclear Fusion Reaction" + '"' + "         ||"));
//                Minecraft.getMinecraft().player.sendChatMessage(("====================================================================="));
//                Minecraft.getMinecraft().player.sendChatMessage(("Caution!! Caution!! Caution!! Caution!! Caution!! Caution!! Caution!!"));
//                Minecraft.getMinecraft().player.sendChatMessage(("====================================================================="));
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//                par2World.spawnEntity(entityarrow);
//                Minecraft.getMinecraft().world.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
//                Minecraft.getMinecraft().world.setWorldTime(16000L);
//                try {
////                	Thread.sleep(1048576);// (day) 11 : (time) 16 : 34 : 56
//                    Thread.sleep(60000);//0:1:0
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//                Minecraft.getMinecraft().world.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
//                par3EntityPlayer.dropItem(MiningTools.EmptyBucketCell, 1);
//                par3EntityPlayer.dropItem(MiningTools.EmptyBucketCell, 1);
//                par3EntityPlayer.dropItem(MiningTools.Plasma, 1);
//            }
//        }
    }

//    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
//        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
//        MinecraftForge.EVENT_BUS.post(event);
//        if (event.isCanceled()) {
//            return event.result;
//        }
//
//        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(MiningTools.Deuterium) && par3EntityPlayer.inventory.hasItem(MiningTools.Tritium) && par3EntityPlayer.inventory.hasItem(MiningTools.EmptyBucketCell)) {
//            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
//        }
//
//        return par1ItemStack;
//    }
}
