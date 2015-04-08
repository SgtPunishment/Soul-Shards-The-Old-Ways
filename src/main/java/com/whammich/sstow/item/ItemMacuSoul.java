package com.whammich.sstow.item;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMacuSoul extends ItemSword {

	public ItemMacuSoul(ToolMaterial Material) {
		super(Material);
		this.setCreativeTab(Register.CREATIVE_TAB);
		this.setMaxStackSize(1);
	}

	public String getUnlocalizedName(ItemStack stack) {
		return "item.sstow.macu.soulium";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":souliummacu");
	}
	/*vv to be moved to own class vv*/
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
        hitEntity.addPotionEffect(new PotionEffect(Potion.wither.id, 500, 4));
		return true;
    }
    
    public void setClub(ItemStack stack)
    {
        int damage;
		damage = stack.getItemDamage();

        if (damage == 0)
        {
            stack = new ItemStack(Register.ItemClubSoul);
        }
    }
    
    public boolean getIsRepairable()
    {
        return false;
    }
    public int getItemEnchantability()
    {
        return 0;
    }
    /* ^^to be moved to ItemMacu/club^^ */
//    to be used to remove obsidian shards as it is damaged
//    @SideOnly(Side.CLIENT)
//    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_)
//    {
//        return this.getIconFromDamage(p_77618_1_);
//    }
}
