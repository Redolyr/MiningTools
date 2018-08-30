package MiningTools.Items;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Redolyr75724
 *
 */
public class ItemToolTwo extends ItemPacks {
    private static Set field_150914_c = Sets.newHashSet();
    protected float efficiencyOnProperMaterial = 4.0F;
    protected float damageVsEntity;
    protected Item.ToolMaterial toolMaterial;
    private static final String __OBFID = "CL_00000019";
    protected static String owner;
    protected static Integer frequency;

    protected ItemToolTwo(String par2Str, String par3Str, float p_i45333_1_, Item.ToolMaterial p_i45333_2_, Set p_i45333_3_) {
        super(par2Str, par3Str);
        this.toolMaterial = p_i45333_2_;
        this.field_150914_c = p_i45333_3_;
        this.maxStackSize = 1;
        this.setMaxDamage(p_i45333_2_.getMaxUses());
        this.efficiencyOnProperMaterial = p_i45333_2_.getEfficiency();
        this.damageVsEntity = p_i45333_1_ + p_i45333_2_.getAttackDamage();
        this.setCreativeTab(CreativeTabs.TOOLS);
        if (this instanceof ItemMiningTools) {
            toolClass = "MiningTools";
        }
        if (this instanceof ItemIronTools) {
            toolClass = "IronTools";
        }
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
        Iterator iterator = field_150914_c.iterator();
        while (iterator.hasNext())
            if (iterator.next() == p_150893_2_) {
                return efficiencyOnProperMaterial;
            }
        return 1.0F;
//        while (iterator.hasNext())
//        {
//            if (iterator.next() == p_150893_2_)
//            {
//                return efficiencyOnProperMaterial;
//            }
//            return 1.0F;
//        }
//        return this.field_150914_c.contains(p_150893_2_) ? this.efficiencyOnProperMaterial : 1.0F;
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        par1ItemStack.damageItem(2, par3EntityLivingBase);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (state.getBlockHardness(worldIn, pos)) {
            stack.damageItem(1, entityLiving);
        }
        return true;
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        if ((double) p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D) {
            p_150894_1_.damageItem(1, p_150894_7_);
        }


    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public Item.ToolMaterial func_150913_i() {
        return this.toolMaterial;
    }

    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }

    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return this.toolMaterial.func_150995_f() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap multimap = super.getItemAttributeModifiers(equipmentSlot);
//        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(field_111210_e, "Tool modifier", (double) this.damageVsEntity, 0));
        return multimap;
    }

    private String toolClass;

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && toolClass.equals(this.toolClass)) {
            return this.toolMaterial.getHarvestLevel();
        } else {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return toolClass != null ? ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (ForgeHooks.isToolEffective(stack, block, meta)) {
            return efficiencyOnProperMaterial;
        }
//        return super.getDigSpeed(stack, block, meta);
        return 1.0F;
    }

    public Item.ToolMaterial setEnumToolMaterial(Item.ToolMaterial toolMaterials) {
        return toolMaterial = toolMaterials;
    }
}