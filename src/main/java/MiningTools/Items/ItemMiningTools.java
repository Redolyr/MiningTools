package MiningTools.Items;

import MiningTools.Interface.IBreakingTouch;
import MiningTools.Interface.IMode;
import MiningTools.Others.Proxy;
import appeng.api.config.AccessRestriction;
import appeng.api.config.Actionable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
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
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class ItemMiningTools extends ItemToolTwo implements IMode {
    private float weaponDamage;
    protected static Item.ToolMaterial toolMaterial;
    private static final Set field_150915_c = Sets.newHashSet();// = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    private final Set<Class<? extends Block>> shiftRotations = new HashSet<Class<? extends Block>>();
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
    public static Integer getMaxItemUseDuration_Integer = 72000,
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

    public ItemMiningTools(String par2Str, String par3Str, Item.ToolMaterial par3EnumToolMaterial) {
        super(par2Str, par3Str, 2.0F, par3EnumToolMaterial, field_150915_c);
//    	ItemPickaxe
//    	ItemSpade
//    	ItemAxe
//      ItemTool
        toolMaterial = par3EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par3EnumToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par3EnumToolMaterial.getEfficiency();
        this.weaponDamage = 4.0F + par3EnumToolMaterial.getAttackDamage();
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

        if (true) {
            portalBleaking = Blocks.PORTAL.setHardness(Blocks.OBSIDIAN.getBlockHardness(null, null, null) * 2);
        }

//        this.setFull3D();
        this.getContainerItem(new ItemStack(this));
    }

    @Override
    public float func_150893_a(ItemStack stack, Block block) {
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
    public boolean canHarvestBlock(Block par1Block) {
        return canHarvestBlock_Boolean;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return hitEntity_Boolean;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.BLOCK;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
//        return 72000;
        return getMaxItemUseDuration_Integer;
    }

    @Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
//        return getItemEnchantability_Integer;
    }

    @Override
    public String getToolMaterialName() {
        return toolMaterial.toString();
    }

    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double) this.damageVsEntity, 0));
        return multimap;
    }

    //ItemHoe
//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
//    {
//        ItemStack itemstack = player.getHeldItem(hand);
//
//        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
//        {
//            return EnumActionResult.FAIL;
//        }
//        else
//        {
//            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(itemstack, player, worldIn, pos);
//            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
//
//            IBlockState iblockstate = worldIn.getBlockState(pos);
//            Block block = iblockstate.getBlock();
//
//            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
//            {
//                if (block == Blocks.GRASS || block == Blocks.GRASS_PATH)
//                {
//                    this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
//                    return EnumActionResult.SUCCESS;
//                }
//
//                if (block == Blocks.DIRT)
//                {
//                    switch ((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT))
//                    {
//                        case DIRT:
//                            this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
//                            return EnumActionResult.SUCCESS;
//                        case COARSE_DIRT:
//                            this.setBlock(itemstack, player, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
//                            return EnumActionResult.SUCCESS;
//                    }
//                }
//            }
//
//            return EnumActionResult.PASS;
//        }
//    }
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && isRShiftRotations) {
            return onItemUse_Unload_Boolean;
        } else {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);

            if (MinecraftForge.EVENT_BUS.post(event)) {
                return onItemUse_Unload_Boolean;
            }

            if (event.getResult() == Event.Result.ALLOW) {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return onItemUse_Load_Boolean;
            }

            int i1 = par3World.getBlockMetadata(par4, par5, par6);
            boolean air = par3World.isAirBlock(par4, par5 + 1, par6);

            Block block = par3World.getBlock(par4, par5, par6);

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt)) {
                Block block1 = Blocks.farmland;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return true;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FarmLand;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.tnt)) {
                Block block1 = Blocks.tnt;
                Block block2 = Blocks.fire;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);

                    if (par7 == 0) --par5;
                    if (par7 == 1) ++par5;
                    if (par7 == 2) --par6;
                    if (par7 == 3) ++par6;
                    if (par7 == 4) --par4;
                    if (par7 == 5) ++par4;

                    if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
                        return false;
                    } else {
                        if (par3World.isAirBlock(par4, par5, par6)) {
                            par3World.playSoundEffect((double) par4 + 0.5D, (double) par5 + 0.5D, (double) par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                            par3World.setBlock(par4, par5, par6, block2);
                        }

                        par1ItemStack.damageItem(1, par2EntityPlayer);
                        return onItemUse_TNT;
                    }
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.netherrack)) {
                Block block1 = Blocks.netherrack;
                Block block2 = Blocks.fire;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);

                    if (par7 == 0) --par5;
                    if (par7 == 1) ++par5;
                    if (par7 == 2) --par6;
                    if (par7 == 3) ++par6;
                    if (par7 == 4) --par4;
                    if (par7 == 5) ++par4;

                    if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
                        return false;
                    } else {
                        if (par3World.isAirBlock(par4, par5, par6)) {
                            par3World.playSoundEffect((double) par4 + 0.5D, (double) par5 + 0.5D, (double) par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                            par3World.setBlock(par4, par5, par6, block2);
                        }

                        par1ItemStack.damageItem(1, par2EntityPlayer);
                        return onItemUse_NetherRacks;
                    }
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.lava || block == Blocks.flowing_lava)) {
                Block block1 = Blocks.obsidian;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Obsidian;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.water || block == Blocks.flowing_water)) {
                Block block1 = Blocks.ice;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Ice;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.ice)) {
                Block block1 = Blocks.flowing_water;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FlowingWater;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.sand)) {
                Block block1 = Blocks.glass;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Glass;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.glass)) {
                Block block1 = Blocks.sand;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Sand;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.cobblestone)) {
                Block block1 = Blocks.stone;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_Stone;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.stone)) {
                Block block1 = Blocks.cobblestone;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_CobbleStone;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.obsidian)) {
                Block block1 = Blocks.flowing_lava;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return false;
                } else {
                    par3World.setBlock(par4, par5, par6, block1);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return onItemUse_FlowingLava;
                }
            }

            if (par7 != 0 && air && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.air)) {
//                Float speed = 10.0F;//0.22F;
                Float speed = onItemUse_Float_SpeedBooster;

                if (speed > 0.0F) {
                    par2EntityPlayer.moveFlying(0.0F, 1.0F, speed);
                }

                return onItemUse_SpeedBooster;
            } else {
                return onItemUse_Unload_Boolean;
            }
        }
    }

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

    public boolean isShiftRotation(Class<? extends Block> cls) {
        for (Class<? extends Block> shift : shiftRotations) {
            if (shift.isAssignableFrom(cls)) {
                return isShiftRotation_Load;
            }
        }

        return isShiftRotation_Unload;
    }

    public boolean isShiftRotation() {
        if (shiftRotations != null) {
            return isShiftRotation_Load_Links;
        }

        return isShiftRotation_Unload_Links;
    }

    @Override
    public boolean canWrench(EntityPlayer player, int x, int y, int z) {
        return canWrench_Boolean;
    }

    @Override
    public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
        player.swingItem();
    }

    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
        if (entity.worldObj.isRemote) {
            return itemInteractionForEntity_Boolean;
        }

        if (entity instanceof IShearable) {
            IShearable target = (IShearable) entity;

            if (target.isShearable(itemstack, entity.world, (int) entity.posX, (int) entity.posY, (int) entity.posZ)) {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.woworldrldObj, (int) entity.posX, (int) entity.posY, (int) entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for (ItemStack stack : drops) {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }

                itemstack.damageItem(1, entity);
            }

            return itemInteractionForEntity_IShearanle;
        }

        if (entity instanceof IBreakingTouch) {
            IBreakingTouch target = (IBreakingTouch) entity;

            if (target.breakingTouchUsing(itemstack, entity.world, (int) entity.posX, (int) entity.posY, (int) entity.posZ)) {
                ArrayList<ItemStack> drops = target.breaking(itemstack, entity.world, (int) entity.posX, (int) entity.posY, (int) entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for (ItemStack stack : drops) {
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
    public int getCapacity(ItemStack pipette) {
        return getCapacity_Integer;
    }

    @Override
    public boolean canPipette(ItemStack pipette) {
        return canPipette_Boolean;
    }

    @Override
    public int fill(ItemStack pipette, FluidStack liquid, boolean doFill) {
        return fill_Integer;
    }

    @Override
    public FluidStack drain(ItemStack pipette, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public float func_82803_g() {
        return func_82803_g_Float;
    }

    @Override
    public String getMaterialName() {
        return null;
    }

    public boolean breakingTouchUsing(ItemStack item, World world, int x, int y, int z) {
        return breakingTouchUsing_Boolean;
    }

    @Override
    public ArrayList<ItemStack> breaking(ItemStack item, World world, int x, int y, int z, int fortune) {
        return new ArrayList<ItemStack>();
    }

    public static final Enchantment EFFICIENCY = Enchantment.REGISTRY.getObject(new ResourceLocation("efficiency"));
    public static final Enchantment SILK_TOUCH = Enchantment.REGISTRY.getObject(new ResourceLocation("silk_touch"));
    public static final Enchantment UNBREAKING = Enchantment.REGISTRY.getObject(new ResourceLocation("unbreaking"));
    public static final Enchantment FORTUNE = Enchantment.REGISTRY.getObject(new ResourceLocation("fortune"));
    public static final Enchantment SHARPNESS = Enchantment.REGISTRY.getObject(new ResourceLocation("sharpness"));
    public static final Enchantment SMITE = Enchantment.REGISTRY.getObject(new ResourceLocation("smite"));
    public static final Enchantment BANE_OF_ARTHROPODS = Enchantment.REGISTRY.getObject(new ResourceLocation("bane_of_arthpods"));
    public static final Enchantment KNOCKBACK = Enchantment.REGISTRY.getObject(new ResourceLocation("knockback"));
    public static final Enchantment FIRE_ASPECT = Enchantment.REGISTRY.getObject(new ResourceLocation("fire_aspect"));
    public static final Enchantment LOOTING = Enchantment.REGISTRY.getObject(new ResourceLocation("looting"));

    public static final Enchantment[] ENCHANTMENTS = new Enchantment[] {EFFICIENCY, SILK_TOUCH, UNBREAKING, FORTUNE, SHARPNESS, SMITE, BANE_OF_ARTHROPODS, KNOCKBACK, FIRE_ASPECT, LOOTING};

    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
        ItemStack stacks = new ItemStack(this);
        par3List.add(stacks);
        for (Enchantment enchantment : ENCHANTMENTS) stacks.addEnchantment(enchantment, enchantment.getMaxLevel());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        for (Enchantment enchantment : ENCHANTMENTS) par1ItemStack.addEnchantment(enchantment, enchantment.getMaxLevel());
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
    public double injectAEPower(ItemStack is, double amt) {
        return injectAEPower_Integer;
    }

    @Override
    public double extractAEPower(ItemStack is, double amt) {
        return extractAEPower_Integer;
    }

    @Override
    public double injectAEPower(ItemStack stack, double amount, Actionable mode) {
        return 0;
    }

    @Override
    public double extractAEPower(ItemStack stack, double amount, Actionable mode) {
        return 0;
    }

    @Override
    public double getAEMaxPower(ItemStack is) {
        return getAEMaxPower_Integer;
    }

    @Override
    public double getAECurrentPower(ItemStack is) {
        return getAECurrentPower_Integer;
    }

    @Override
    public AccessRestriction getPowerFlow(ItemStack stack) {
        return null;
    }

    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        IBlockState block = world.getBlockState(pos);

        if (block == null || player.isSneaking() != isShiftRotation(block.getClass()))
            return EnumActionResult.FAIL;

        if (block.withRotation(Rotation.)) {
            player.swingItem();
            return world.isRemote ? EnumActionResult.PASS : EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    @Override
    public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player) {
        return true;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
        super.onPlayerStoppedUsing(par1ItemStack, par2World, par3EntityPlayer, par4);
    }

    @SideOnly(Side.CLIENT)
    public void setInformation(World par2EntityPlayer, List par3List) {
        Date data = new Date();

        if (isLShiftRotations == true) {
            Proxy.proxy.addInfomationText(par3List, "item.tool.mode");
            par3List.add("");
            Proxy.proxy.addInfomationText(par3List, "item.Pickaxe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Shovel.name");
            Proxy.proxy.addInfomationText(par3List, "item.Axe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Sword.name");
            Proxy.proxy.addInfomationText(par3List, "item.Hoe.name");
            Proxy.proxy.addInfomationText(par3List, "item.Shears.name");
            Proxy.proxy.addInfomationText(par3List, "item.Wrench.name");
            par3List.add("");
        }

        if (isRShiftRotations == true) {
            Proxy.proxy.addInfomationText(par3List, "added.version");
            par3List.add("");
            Proxy.proxy.addInfomationText(par3List, "item.Pickaxe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Shovel.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Axe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Sword.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Hoe.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Shears.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.Wrench.name", "added.version.alpha.1.0.1");
            Proxy.proxy.addInfomationText(par3List, "item.WrenchAE.name", "added.version.alpha.1.0.1");
            par3List.add("");
        }

        this.isLShiftMessage(par3List);
        this.isRShiftMessage(par3List);

        if (isLShiftRotations == false || isRShiftRotations == false) {
            par3List.add("");
            Proxy.proxy.addInfomationText(par3List, "text./.name", "text./.name", "text./.name");
        }

        Proxy.proxy.addInfomationText(par3List, "item.damage.name", this.itemStacks.getItemDamage()+ "/" + this.itemStacks.getMaxDamage());
        Proxy.proxy.addInfomationText(par3List, "minecraft.id.get", par2EntityPlayer + "");
        Proxy.proxy.addInfomationText(par3List, "minecraft.current.data", "" + Minecraft.getSystemTime());
        Proxy.proxy.addInfomationText(par3List, "time.the.currents.data", "" + data);
        Proxy.proxy.addInfomationText(par3List, "text.custom.name", getUnlocalizedName(), " entity.mode.renderer", Proxy.proxy.FancyFastLink() + "");
    }

    public boolean canWrench(ItemStack wrench, EntityPlayer player, BlockPos pos) {
        return true;
    }

    public boolean canWrench(EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack, RayTraceResult rayTraceResult) {
        return true;
    }

    public void wrenchUsed(EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack, RayTraceResult rayTraceResult) {
    }
}

