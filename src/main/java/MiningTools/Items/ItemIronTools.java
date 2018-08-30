package MiningTools.Items;

import MiningTools.Interface.IAxe;
import MiningTools.Interface.IShovel;
import MiningTools.Interface.ISword;
import MiningTools.Others.Proxy;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Redolyr75724
 *
 */
public class ItemIronTools extends ItemToolTwo implements IShovel, IAxe, ISword {
    private static Set field_150914_c;
    private float weaponDamage;
    protected Item.ToolMaterial toolMaterial;

    public ItemIronTools(String par2Str, String par3Str, Item.ToolMaterial par3EnumToolMaterial) {
        super(par2Str, par3Str, 2.0F, par3EnumToolMaterial, field_150914_c);
        this.toolMaterial = par3EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par3EnumToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par3EnumToolMaterial.getEfficiency();
        this.weaponDamage = 4.0F + par3EnumToolMaterial.getAttackDamage();
        this.damageVsEntity = this.getDamageVsEntity(null);
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.BLOCK;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }

    @Override
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap multimap = super.getItemAttributeModifiers(equipmentSlot);
//        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(field_111210_e, "Tool modifier", (double) this.damageVsEntity, 0));
        return multimap;
    }

//    @Override
//    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
//        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
//        return par1ItemStack;
//    }

    public int getDamageVsEntity(Entity par1Entity) {
        if (par1Entity instanceof EntityCreeper) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Creeper);
        } else if (par1Entity instanceof EntityZombie) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Zombie);
        } else if (par1Entity instanceof EntityEnderman) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Enderman);
        } else if (par1Entity instanceof EntitySpider) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Spider);
        } else if (par1Entity instanceof EntityCaveSpider) {
            return (int) (weaponDamage = Proxy.proxy.Integer().CaveSpider);
        } else if (par1Entity instanceof EntitySkeleton) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Skeleton);
        } else if (par1Entity instanceof EntityWitch) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Witch);
        } else if (par1Entity instanceof EntitySnowman) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Snowman);
        } else if (par1Entity instanceof EntitySlime) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Slime);
        } else if (par1Entity instanceof EntitySilverfish) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Silverfish);
        } else if (par1Entity instanceof EntityIronGolem) {
            return (int) (weaponDamage = Proxy.proxy.Integer().IronGolem);
        } else if (par1Entity instanceof EntityGhast) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Ghast);
        } else if (par1Entity instanceof EntityBlaze) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Blaze);
        } else if (par1Entity instanceof EntityDragon) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Dragon);
        } else if (par1Entity instanceof EntityWither) {
            return (int) (weaponDamage = Proxy.proxy.Integer().Wither);
        }

        return (int) weaponDamage;
    }

    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
        if (entity.world.isRemote) {
            return false;
        }

        if (entity instanceof IShearable) {
            IShearable target = (IShearable) entity;

            if (target.isShearable(itemstack, entity.world, new BlockPos(entity.posX, entity.posY, entity.posZ))) {
                Random rand = new Random();
                for (ItemStack stack : target.onSheared(itemstack, entity.world, new BlockPos(entity.posX, entity.posY, entity.posZ), EnchantmentHelper.getEnchantmentLevel(Enchantment.REGISTRY.getObject(new ResourceLocation("FORTUNE")), itemstack))) {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }

                itemstack.damageItem(1, entity);
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        if (player.world.isRemote) {
            return false;
        }

        IBlockState id = player.world.getBlockState(pos);

        if (blocks instanceof IShearable) {
            IShearable target = (IShearable) blocks;

            if (target.isShearable(itemstack, player.world, pos)) {
                Random rand = new Random();

                for (ItemStack stack : target.onSheared(itemstack, player.world, pos, EnchantmentHelper.getEnchantmentLevel(Enchantment.REGISTRY.getObject(new ResourceLocation("FORTUNE")), itemstack))) {
                    float f = 0.7F;
                    double d = (double) (rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                    double d1 = (double) (rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                    double d2 = (double) (rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(player.world, (double) pos.getX() + d, (double) pos.getY() + d1, (double) pos.getZ() + d2, stack);
                    entityitem.setPickupDelay(10);
                    player.world.spawnEntity(entityitem);
                }

                itemstack.damageItem(1, player);
            }
        }

        return false;
    }

    @Override
    public float func_82803_g() {
        return 0;
    }

    @Override
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
        return weaponDamage;
    }

    @Override
    public boolean canHarvestBlock(Block par1Block) {
        return true;
    }

    public void setInformation(World par2World, List par3List) {
        if (true) {
            par3List.add("Item Tools Mode");
            par3List.add("");
            par3List.add("Pickaxe");
            par3List.add("Shovel");
            par3List.add("Axe");
            par3List.add("Sword");
            par3List.add("");
        }

        if (true) {
            par3List.add("Added Mode, Versions");
            par3List.add("");
            par3List.add("Pickaxe: added in Versions in 3.1");
            par3List.add("Shovel: added in Versions in 3.1");
            par3List.add("Axe: added in Versions in 3.1");
            par3List.add("Sword: added in Versions in 3.1");
            par3List.add("");
        }

        par3List.add("ID: " + this);
        par3List.add("Damage: " + this.itemStacks.getItemDamage());
    }
}
