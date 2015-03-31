package com.whammich.sstow.block;

import com.whammich.sstow.utils.Reference;
import com.whammich.sstow.utils.Register;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockGlassObsidian  extends Block {

	public BlockGlassObsidian() {
		super(Material.glass);
		this.setBlockName("sstow.glassobsidian");
		this.setCreativeTab(Register.CREATIVE_TAB);
		this.blockHardness = 1.0F;
		this.blockResistance = 4.0F;
	}
	
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderBlockPass()
{
            return 1;
}
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int m, int x, int y, int z)
    {
        Block block = world.getBlock(m, x, y);
        {
            if (world.getBlockMetadata(m, x, y) != world.getBlockMetadata(m - Facing.offsetsXForSide[z], x - Facing.offsetsYForSide[z], y - Facing.offsetsZForSide[z]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }
        return super.shouldSideBeRendered(world, m, x, y, z);
    }


	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ObsidianGlass");
	}
}