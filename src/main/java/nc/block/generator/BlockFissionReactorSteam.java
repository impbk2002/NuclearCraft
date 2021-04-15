package nc.block.generator;

import java.util.Random;

import nc.Config;
import nc.NuclearCraft;
import nc.block.NCBlocks;
import nc.tile.generator.TileFissionReactorSteam;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFissionReactorSteam extends BlockContainer {
	private Random rand = new Random();
	
	private final boolean isActive;
	public static int MBNumber;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;
	
	private static boolean keepInventory;

	public BlockFissionReactorSteam(boolean isActive) {
		super(Material.iron);
		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("nc:generator/fissionReactorSteam/" + "side");
		this.iconFront = iconRegister.registerIcon("nc:generator/fissionReactorSteam/" + "front" + (this.isActive ? "Active" : "Idle"));
		this.iconTop = iconRegister.registerIcon("nc:generator/fissionReactorSteam/" + "top");
		this.iconBottom = iconRegister.registerIcon("nc:generator/fissionReactorSteam/" + "bottom");
	}

	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(NCBlocks.fissionReactorSteamIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j()) {
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j()) {
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j()) {
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j()) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : (side == 0 ? this.iconBottom : (side == 1 ? this.iconTop : this.blockIcon)));
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) {
			return true; 
		} else {
			FMLNetworkHandler.openGui(player, NuclearCraft.instance, NuclearCraft.guiIdFissionReactorSteam, world, x, y, z);
		}
		return true;
	}
	
	public TileEntity createNewTileEntity(World world, int par1) {
		return new TileFissionReactorSteam();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		 
		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if (itemstack.hasDisplayName()) {
			((TileFissionReactorSteam)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}

	public static void updateBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if(active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, NCBlocks.fissionReactorSteamActive);
		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, NCBlocks.fissionReactorSteamIdle);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if(tileentity != null) {
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldBlockID, int oldMetadata) {
		if(!keepInventory) {
			TileFissionReactorSteam tileentity = (TileFissionReactorSteam) world.getTileEntity(x, y, z);
			
			if(tileentity != null) {
				for(int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);
					
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= 	j;
							EntityItem item = new EntityItem(world, (double) ((float) x + f), ((float) y + f1), ((float) z + f2),
							new ItemStack (itemstack.getItem(), j, itemstack.getItemDamage()));
							
							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							item.motionX = (double)((float) this.rand.nextGaussian() * f3);
							item.motionY = (double)((float) this.rand.nextGaussian() * f3 + 0.2F);
							item.motionZ = (double)((float) this.rand.nextGaussian() * f3);
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				
				world.func_147453_f(x, y, z, oldBlockID);
			}
		}
		
		super.breakBlock(world, x, y, z, oldBlockID, oldMetadata);
	}
	
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		TileFissionReactorSteam tileentity = (TileFissionReactorSteam) world.getTileEntity(x, y, z);
		return tileentity.heat <= Config.fissionComparatorHeat ? (int) (15D*tileentity.heat/Config.fissionComparatorHeat) : 15;
	}
	
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
		return new ItemStack(NCBlocks.fissionReactorSteamIdle);
	}
}