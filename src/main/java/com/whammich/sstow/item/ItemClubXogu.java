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

public class ItemClubXogu extends ItemSword {

	private IIcon[] icon;

	public ItemClubXogu(ToolMaterial Material) {
		super(Material);
		this.setCreativeTab(Register.CREATIVE_TAB);
		this.setMaxStackSize(1);
	}

	public String getUnlocalizedName(ItemStack stack) {
		return "item.sstow.xogu.club";
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon onItemRightclick() {
        return this.icon[1];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon(Reference.MOD_ID + ":xogueclub");
        this.icon[1] = iconRegister.registerIcon(Reference.MOD_ID + ":xogueclub1");
    }
}
