package nc.block.reactor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockReactorGlass extends Block {

	public BlockReactorGlass() {
		super(Material.iron);
	}
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		blockIcon = p_149651_1_.registerIcon("nc:reactor/" + this.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return blockIcon;
	}
	
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
		return false;
    }
    
	public boolean renderAsNormalBlock() {
		return false;
	}
	   
	public boolean isOpaqueCube() {
		return false;
	}
}
