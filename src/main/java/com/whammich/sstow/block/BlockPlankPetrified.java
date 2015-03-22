package com.whammich.sstow.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlankPetrified extends Block {
	@SideOnly(Side.CLIENT)
	protected IIcon[] sideIcon;

	public BlockPlankPetrified() {
		super(Material.rock);
		setCreativeTab(Register.CREATIVE_TAB);
		setLightOpacity(255);
		useNeighborBrightness = true;
		blockHardness = 3.0F;
		blockResistance = 3.0F;
		setBlockName("petrified.plank");
	}

	public static final String[] names = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "big_oak" };

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
		list.add(new ItemStack(item, 1, 4));
		list.add(new ItemStack(item, 1, 5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.sideIcon = new IIcon[names.length];

		for (int i = 0; i < this.sideIcon.length; ++i) {
			this.sideIcon[i] = iconRegister.registerIcon(Reference.MOD_ID + ":petrified_planks/petrified_planks_" + names[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta > 6)
			meta = 0;
		return blockIcon;
		
	}
}