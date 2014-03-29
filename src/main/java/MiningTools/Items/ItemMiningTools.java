package MiningTools.Items;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDropper;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fluids.FluidStack;
import MiningTools.Interface.IBreakingTouch;
import MiningTools.Interface.IMode;
import MiningTools.Others.Proxy;
import appeng.api.config.AccessRestriction;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMiningTools extends ItemToolTwo implements IMode
{
    private float weaponDamage;
    protected static Item.ToolMaterial toolMaterial;
    private static final Set field_150915_c = Sets.newHashSet();// = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    private final Set < Class <? extends Block >> shiftRotations = new HashSet < Class <? extends Block >> ();
    public NBTTagCompound folder;
    public NBTTagList file;
    Block block;
    Random random;
    public static Block portalBleaking;
    public static Map map;
    public static Entity entity;
//EntityBoat
	public static Boolean canHarvestBlock_Boolean = true,
						  canWrench_Boolean = true,
						  canPipette_Boolean = true,
						  hitEntity_Boolean = true,
						  breakingTouchUsing_Boolean = true,
						  onItemUse_Unload_Boolean = false,
						  onItemUse_Load_Boolean = true,
						  onItemUse_FarmLand = true,
						  onItemUse_TNT = true,
						  onItemUse_NetherRacks = true,
						  onItemUse_Obsidian = true,
						  onItemUse_Ice = true,
						  onItemUse_FlowingWater = true,
						  onItemUse_Glass = true,
						  onItemUse_Sand = true,
						  onItemUse_Stone = true,
						  onItemUse_CobbleStone = true,
						  onItemUse_FlowingLava = true,
						  onItemUse_SpeedBooster = true,
						  isShiftRotation_Load = true,
						  isShiftRotation_Unload = false,
						  isShiftRotation_Load_Links = true,
						  isShiftRotation_Unload_Links = false,
						  itemInteractionForEntity_Boolean = true,
						  itemInteractionForEntity_IShearanle = true,
						  itemInteractionForEntity_IBreakingTouch = true,
						  itemInteractionForEntity_Unload = false;
	public static Integer  getMaxItemUseDuration_Integer = 72000,
//						   getItemEnchantability_Integer = toolMaterial.getEnchantability(),
						   getCapacity_Integer = 100,
						   fill_Integer = 100,
						   injectAEPower_Integer = 0,
						   extractAEPower_Integer = 0,
						   getAEMaxPower_Integer = 0,
						   getAECurrentPower_Integer = 0;
	public static Float getStrVsBlock_Float = 0F,
						onItemUse_Float_SpeedBooster = 10.0F,
						func_82803_g_Float = 0F;
    
    public ItemMiningTools(String par2Str, String par3Str, Item.ToolMaterial par3EnumToolMaterial)
    {
        super(par2Str, par3Str, 2.0F, par3EnumToolMaterial, field_150915_c);
//    	ItemPickaxe
//    	ItemSpade
//    	ItemAxe
//      ItemTool
        this.toolMaterial = par3EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par3EnumToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par3EnumToolMaterial.getEfficiencyOnProperMaterial();
        this.weaponDamage = 4.0F + par3EnumToolMaterial.getDamageVsEntity();
        this.damageVsEntity = this.getDamageVsEntity(null);
        this.shiftRotations.add(BlockLever.class);
        this.shiftRotations.add(BlockButton.class);
        this.shiftRotations.add(BlockChest.class);
        this.shiftRotations.add(BlockPistonBase.class);
        this.shiftRotations.add(BlockRail.class);
        this.shiftRotations.add(BlockRedstoneRepeater.class);
        this.shiftRotations.add(BlockPumpkin.class);
        this.shiftRotations.add(BlockTrapDoor.class);
        this.shiftRotations.add(BlockFenceGate.class);
        this.shiftRotations.add(BlockEnderChest.class);
        this.shiftRotations.add(BlockDispenser.class);
        this.shiftRotations.add(BlockDropper.class);
        this.shiftRotations.add(BlockRail.class);
        this.shiftRotations.add(BlockRedstoneComparator.class);
        this.shiftRotations.add(BlockBed.class);
        this.shiftRotations.add(BlockAnvil.class);
        this.shiftRotations.add(BlockFurnace.class);
        this.shiftRotations.add(BlockStairs.class);

        if (true)
        {
            portalBleaking = Blocks.portal.setHardness(Blocks.obsidian.getBlockHardness(null, 0, 0, 0) * 2);
        }

//        this.setFull3D();
        this.getContainerItem(new ItemStack(this));
    }
    @Override
    public float func_150893_a(ItemStack stack, Block block)
    {
//    	for (float f = 0; f < 10000F; f++)
//    	return f;
    	return getStrVsBlock_Float;
    }
//    @Override
//    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
//    {
//    	for (float f = 0; f < 10000F; f++)
//    	return f;
//    	return getStrVsBlock_Float;
//    }
    @Override
    public boolean canHarvestBlock(Block par1Block)
    {
    	return canHarvestBlock_Boolean;
    }
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return hitEntity_Boolean;
    }
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
//        return 72000;
    	return getMaxItemUseDuration_Integer;
    }
    @Override
    public int getItemEnchantability()
    {
    	return toolMaterial.getEnchantability();
//        return getItemEnchantability_Integer;
    }
    @Override
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }
    @Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
//    ItemHoe
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        EntityLiving entityLiving = null;
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        par1ItemStack.damageItem(-1, par3EntityPlayer);
        return par1ItemStack;
    }
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && isRShiftRotations)
        {
            return onItemUse_Unload_Boolean;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);

            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return onItemUse_Unload_Boolean;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return onItemUse_Load_Boolean;
            }

            int i1 = par3World.getBlockMetadata(par4, par5, par6);
            boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
            
            Block block = par3World.getBlock(par4, par5, par6);

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt))
            {
                Block block1 = Blocks.farmland;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FarmLand;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.tnt))
            {
                Block block1 = Blocks.tnt;
                Block block2 = Blocks.fire;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);

                    if (par7 == 0)
                    {
                        --par5;
                    }

                    if (par7 == 1)
                    {
                        ++par5;
                    }

                    if (par7 == 2)
                    {
                        --par6;
                    }

                    if (par7 == 3)
                    {
                        ++par6;
                    }

                    if (par7 == 4)
                    {
                        --par4;
                    }

                    if (par7 == 5)
                    {
                        ++par4;
                    }

                    if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
                    {
                        return false;
                    }
                    else
                    {
                        if (par3World.isAirBlock(par4, par5, par6))
                        {
                            par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                            par3World.setBlock(par4, par5, par6, block2);
                        }

                        par1ItemStack.damageItem(1, par2EntityPlayer);
                        return onItemUse_TNT;
                    }
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.netherrack))
            {
                Block block1 = Blocks.netherrack;
                Block block2 = Blocks.fire;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);

                    if (par7 == 0)
                    {
                        --par5;
                    }

                    if (par7 == 1)
                    {
                        ++par5;
                    }

                    if (par7 == 2)
                    {
                        --par6;
                    }

                    if (par7 == 3)
                    {
                        ++par6;
                    }

                    if (par7 == 4)
                    {
                        --par4;
                    }

                    if (par7 == 5)
                    {
                        ++par4;
                    }

                    if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
                    {
                        return false;
                    }
                    else
                    {
                        if (par3World.isAirBlock(par4, par5, par6))
                        {
                            par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                            par3World.setBlock(par4, par5, par6, block2);
                        }

                        par1ItemStack.damageItem(1, par2EntityPlayer);
                        return onItemUse_NetherRacks;
                    }
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.lava || block == Blocks.flowing_lava))
            {
                Block block1 = Blocks.obsidian;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Obsidian;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.water || block == Blocks.flowing_water))
            {
                Block block1 = Blocks.ice;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Ice;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.ice))
            {
                Block block1 = Blocks.flowing_water;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FlowingWater;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.sand))
            {
                Block block1 = Blocks.glass;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Glass;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.glass))
            {
                Block block1 = Blocks.sand;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Sand;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.cobblestone))
            {
                Block block1 = Blocks.stone;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Stone;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.stone))
            {
                Block block1 = Blocks.cobblestone;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_CobbleStone;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.obsidian))
            {
                Block block1 = Blocks.flowing_lava;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return false;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FlowingLava;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.air))
            {
//                Float speed = 10.0F;//0.22F;
            	Float speed = onItemUse_Float_SpeedBooster;

                if (speed > 0.0F)
                {
                    par2EntityPlayer.moveFlying(0.0F, 1.0F, speed);
                }

                return onItemUse_SpeedBooster;
            }
            else
            {
                return onItemUse_Unload_Boolean;
            }
        }
    }
    public int getDamageVsEntity(Entity par1Entity)
    {
        if (par1Entity instanceof EntityCreeper)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Creeper);
        }
        else if (par1Entity instanceof EntityZombie)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Zombie);
        }
        else if (par1Entity instanceof EntityEnderman)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Enderman);
        }
        else if (par1Entity instanceof EntitySpider)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Spider);
        }
        else if (par1Entity instanceof EntityCaveSpider)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().CaveSpider);
        }
        else if (par1Entity instanceof EntitySkeleton)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Skeleton);
        }
        else if (par1Entity instanceof EntityWitch)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Witch);
        }
        else if (par1Entity instanceof EntitySnowman)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Snowman);
        }
        else if (par1Entity instanceof EntitySlime)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Slime);
        }
        else if (par1Entity instanceof EntitySilverfish)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Silverfish);
        }
        else if (par1Entity instanceof EntityIronGolem)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().IronGolem);
        }
        else if (par1Entity instanceof EntityGhast)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Ghast);
        }
        else if (par1Entity instanceof EntityBlaze)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Blaze);
        }
        else if (par1Entity instanceof EntityDragon)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer(). Dragon);
        }
        else if (par1Entity instanceof EntityWither)
        {
            return (int)(weaponDamage = Proxy.proxy.Integer().Wither);
        }

        return (int) weaponDamage;
    }
    public boolean isShiftRotation(Class <? extends Block > cls)
    {
        for (Class <? extends Block > shift : shiftRotations)
        {
            if (shift.isAssignableFrom(cls))
            {
                return isShiftRotation_Load;
            }
        }

        return isShiftRotation_Unload;
    }
    public boolean isShiftRotation()
    {
        if (shiftRotations != null)
        {
            return isShiftRotation_Load_Links;
        }

        return isShiftRotation_Unload_Links;
    }
    @Override
    public boolean canWrench(EntityPlayer player, int x, int y, int z)
    {
        return canWrench_Boolean;
    }
    @Override
    public void wrenchUsed(EntityPlayer player, int x, int y, int z)
    {
        player.swingItem();
    }
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
        if (entity.worldObj.isRemote)
        {
            return itemInteractionForEntity_Boolean;
        }

        if (entity instanceof IShearable)
        {
            IShearable target = (IShearable)entity;

            if (target.isShearable(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                                             EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for (ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }

                itemstack.damageItem(1, entity);
            }

            return itemInteractionForEntity_IShearanle;
        }

        if (entity instanceof IBreakingTouch)
        {
        	IBreakingTouch target = (IBreakingTouch)entity;

            if (target.breakingTouchUseing(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.breaking(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                                             EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for (ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }

                itemstack.damageItem(1, entity);
            }

            return itemInteractionForEntity_IBreakingTouch;
        }

        return itemInteractionForEntity_Unload;
    }
    @Override
    public int getCapacity(ItemStack pipette)
    {
        return getCapacity_Integer;
    }
    @Override
    public boolean canPipette(ItemStack pipette)
    {
        return canPipette_Boolean;
    }
    @Override
    public int fill(ItemStack pipette, FluidStack liquid, boolean doFill)
    {
        return fill_Integer;
    }
    @Override
    public FluidStack drain(ItemStack pipette, int maxDrain, boolean doDrain)
    {
        return null;
    }
    @Override
    public float func_82803_g()
    {
        return func_82803_g_Float;
    }
    @Override
    public String getMaterialName()
    {
        return null;
    }
    public boolean breakingTouchUseing(ItemStack item, World world, int x, int y, int z)
    {
        return breakingTouchUsing_Boolean;
    }
    @Override
    public ArrayList<ItemStack> breaking(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        return new ArrayList<ItemStack>();
    }
    public NBTTagList func_92110_g(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.hasKey("StoredEnchantments") ? (NBTTagList)par1ItemStack.stackTagCompound.getTag("StoredEnchantments") : new NBTTagList();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        ItemStack stacks = new ItemStack(this);
        par3List.add(stacks);
        stacks.addEnchantment(Enchantment.efficiency, Enchantment.efficiency.getMaxLevel());
        stacks.addEnchantment(Enchantment.silkTouch, Enchantment.silkTouch.getMaxLevel());
        stacks.addEnchantment(Enchantment.unbreaking, Enchantment.unbreaking.getMaxLevel());
        stacks.addEnchantment(Enchantment.fortune, Enchantment.fortune.getMaxLevel());
        stacks.addEnchantment(Enchantment.sharpness, Enchantment.sharpness.getMaxLevel());
        stacks.addEnchantment(Enchantment.smite, Enchantment.smite.getMaxLevel());
        stacks.addEnchantment(Enchantment.baneOfArthropods, Enchantment.baneOfArthropods.getMaxLevel());
        stacks.addEnchantment(Enchantment.knockback, Enchantment.knockback.getMaxLevel());
        stacks.addEnchantment(Enchantment.fireAspect, Enchantment.fireAspect.getMaxLevel());
        stacks.addEnchantment(Enchantment.looting, Enchantment.looting.getMaxLevel());
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par1ItemStack.addEnchantment(Enchantment.efficiency, Enchantment.efficiency.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.silkTouch, Enchantment.silkTouch.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.unbreaking, Enchantment.unbreaking.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.fortune, Enchantment.fortune.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.sharpness, Enchantment.sharpness.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.smite, Enchantment.smite.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, Enchantment.baneOfArthropods.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.knockback, Enchantment.knockback.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.fireAspect, Enchantment.fireAspect.getMaxLevel());
        par1ItemStack.addEnchantment(Enchantment.looting, Enchantment.looting.getMaxLevel());
    }
	@Override
	public boolean canWrench(ItemStack wrench, EntityPlayer player, int x, int y, int z)
	{
		return true;
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public int getColorFromItemStack(ItemStack itemStack, int damage)
//	{
//		Integer colours = null;
//		
//		Proxy.proxy.getColorFromItemStack(itemStack);
//		if (Proxy.proxy.getColorFromDamage(0) != null)
//		return Proxy.proxy.getColorFromItem(1, 1, 1);
//		else if (Proxy.proxy.getColorFromDamage(1) != null)
//		return Proxy.proxy.getColorFromItem(255, 255, 255);
		
//		switch (itemStack.getItemDamage())
//		{
//		case 1:
//			return Proxy.proxy.getSubColorChart(0, 255, 0);
//		}
////		return Proxy.proxy.getSubColorChart(0, 0, 0);
//		return colours;
//	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public int getColorFromItemStack(ItemStack itemStack, int damage)
//	{
//		switch (itemStack.getItemDamage())
//		{
//		case 1:
//			return 0x00FF00;
//		case 10:
//			return 0x00FF11;
//		case 20:
//			return 0x00FF22;
//		case 30:
//			return 0x00FF33;
//		case 40:
//			return 0x00FF44;
//		case 50:
//			return 0x00FF55;
//		case 60:
//			return 0x00FF66;
//			
//		case 70:
//			return 0x11FF00;
//		case 80:
//			return 0x11FF11;
//		case 90:
//			return 0x11FF22;
//		case 100:
//			return 0x11FF33;
//		case 120:
//			return 0x11FF44;
//		case 130:
//			return 0x11FF55;
//		case 140:
//			return 0x11FF66;
//			
//		case 150:
//			return 0x22FF00;
//		case 160:
//			return 0x22FF11;
//		case 170:
//			return 0x22FF22;
//		case 180:
//			return 0x22FF33;
//		case 190:
//			return 0x22FF44;
//		case 200:
//			return 0x22FF55;
//		case 210:
//			return 0x00FF66;
//			
//		case 220:
//			return 0x33FF00;
//		case 230:
//			return 0x33FF11;
//		case 240:
//			return 0x33FF22;
//		case 250:
//			return 0x33FF33;
//		case 260:
//			return 0x33FF44;
//		case 270:
//			return 0x33FF55;
//		case 280:
//			return 0x33FF66;
//			
//		case 290:
//			return 0x44FF00;
//		case 300:
//			return 0x44FF11;
//		case 310:
//			return 0x44FF22;
//		case 320:
//			return 0x44FF33;
//		case 330:
//			return 0x44FF44;
//		case 340:
//			return 0x44FF55;
//		case 350:
//			return 0x00FF66;
//			
//		case 360:
//			return 0x55FF00;
//		case 370:
//			return 0x55FF11;
//		case 380:
//			return 0x55FF22;
//		case 390:
//			return 0x55FF33;
//		case 400:
//			return 0x55FF44;
//		case 410:
//			return 0x55FF55;
//		case 420:
//			return 0x55FF66;
//			
//		}
//		return -0x000000;
//	}
	@Override
	public double injectAEPower(ItemStack is, double amt)
	{
		return injectAEPower_Integer;
	}
	@Override
	public double extractAEPower(ItemStack is, double amt)
	{
		return extractAEPower_Integer;
	}
	@Override
	public double getAEMaxPower(ItemStack is)
	{
		return getAEMaxPower_Integer;
	}
	@Override
	public double getAECurrentPower(ItemStack is)
	{
		return getAECurrentPower_Integer;
	}
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		Block block = world.getBlock(x, y, z);

		if(block == null)
			return false;

		if (player.isSneaking() != isShiftRotation(block.getClass()))
			return false;

		if (block.rotateBlock(world, x, y, z, ForgeDirection.getOrientation(side)))
		{
			player.swingItem();
			return !world.isRemote;
		}
		return false;
	}
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	{
		return true;
	}
    @Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
    	super.onPlayerStoppedUsing(par1ItemStack, par2World, par3EntityPlayer, par4);
    }
	@Override
	public AccessRestriction getPowerFlow(ItemStack is)
	{
		return null;
	}
    @SideOnly(Side.CLIENT)
    public void setInformation(EntityPlayer par2EntityPlayer, List par3List)
    {
        Date data = new Date();
        Date time = new Date(data.getTime());
        
        if (isLShiftRotations == true)
        {
            Proxy.proxy.addInfomationText(par3List, "item.tool.mode");
            par3List.add((String) "");
            Proxy.proxy.addInfomationText(par3List, "item.Pickaxe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Shovel.name");
            Proxy.proxy.addInfomationText(par3List, "item.Axe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Sword.name");
            Proxy.proxy.addInfomationText(par3List, "item.Hoe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Shears.name");
            Proxy.proxy.addInfomationText(par3List, "item.Wrench.name");
            par3List.add((String) "");
        }

        if (isRShiftRotations == true)
        {
            Proxy.proxy.addInfomationText(par3List, "added.version");
            par3List.add((String) "");
            Proxy.proxy.addInfomationText(par3List, "item.Pickaxe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Shovel.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Axe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Sword.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Hoe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Shears.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Wrench.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.WrenchAE.name", "added.version.alpha.1.0.1");
            par3List.add((String) "");
        }
        
        this.isLShiftMessage(par3List);
        this.isRShiftMessage(par3List);

        if (isLShiftRotations == false || isRShiftRotations == false)
        {
            par3List.add((String) "");
            Proxy.proxy.addInfomationText(par3List, "text./.name", "text./.name", "text./.name");
        }

        Proxy.proxy.addInfomationText(par3List, "item.damage.name", this.getDisplayDamage(itemStacks) + "/" + this.getMaxDamage());
        Proxy.proxy.addInfomationText(par3List, "minecraft.id.get", par2EntityPlayer + "");
        Proxy.proxy.addInfomationText(par3List, "minecraft.current.data", "" + Minecraft.getSystemTime());
        Proxy.proxy.addInfomationText(par3List, "time.the.currents.data", "" + data);
        Proxy.proxy.addInfomationText(par3List, "text.custom.name", getUnlocalizedName(), " entity.mode.renderer", Proxy.proxy.FancyFastLink() + "");
    }
}
