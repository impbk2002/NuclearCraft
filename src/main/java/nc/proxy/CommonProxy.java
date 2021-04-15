package nc.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import nc.Config;
import nc.NuclearCraft;
import nc.block.NCBlocks;
import nc.container.accelerator.ContainerSynchrotron;
import nc.container.crafting.ContainerNuclearWorkspace;
import nc.container.generator.ContainerFissionReactor;
import nc.container.generator.ContainerFissionReactorSteam;
import nc.container.generator.ContainerFusionReactor;
import nc.container.generator.ContainerFusionReactorSteam;
import nc.container.generator.ContainerReactionGenerator;
import nc.container.machine.ContainerAssembler;
import nc.container.machine.ContainerCollector;
import nc.container.machine.ContainerCooler;
import nc.container.machine.ContainerCrusher;
import nc.container.machine.ContainerElectricCrusher;
import nc.container.machine.ContainerElectricFurnace;
import nc.container.machine.ContainerElectrolyser;
import nc.container.machine.ContainerFactory;
import nc.container.machine.ContainerFurnace;
import nc.container.machine.ContainerHastener;
import nc.container.machine.ContainerHeliumExtractor;
import nc.container.machine.ContainerIoniser;
import nc.container.machine.ContainerIrradiator;
import nc.container.machine.ContainerNuclearFurnace;
import nc.container.machine.ContainerOxidiser;
import nc.container.machine.ContainerRecycler;
import nc.container.machine.ContainerSeparator;
import nc.item.NCItems;
import nc.tile.accelerator.TileSynchrotron;
import nc.tile.crafting.TileNuclearWorkspace;
import nc.tile.generator.TileFissionReactor;
import nc.tile.generator.TileFissionReactorSteam;
import nc.tile.generator.TileFusionReactor;
import nc.tile.generator.TileFusionReactorSteam;
import nc.tile.generator.TileReactionGenerator;
import nc.tile.machine.TileAssembler;
import nc.tile.machine.TileCollector;
import nc.tile.machine.TileCooler;
import nc.tile.machine.TileCrusher;
import nc.tile.machine.TileElectricCrusher;
import nc.tile.machine.TileElectricFurnace;
import nc.tile.machine.TileElectrolyser;
import nc.tile.machine.TileFactory;
import nc.tile.machine.TileFurnace;
import nc.tile.machine.TileHastener;
import nc.tile.machine.TileHeliumExtractor;
import nc.tile.machine.TileIoniser;
import nc.tile.machine.TileIrradiator;
import nc.tile.machine.TileNuclearFurnace;
import nc.tile.machine.TileOxidiser;
import nc.tile.machine.TileRecycler;
import nc.tile.machine.TileSeparator;

public class CommonProxy implements IGuiHandler {

	public void onConstruct() {}
	
	public void preInitalize() {
		// Random Chest Loot
		addLoot(Config.enableLoot);
	}
	
	public void initialize() {
		NetworkRegistry.INSTANCE.registerGuiHandler(NuclearCraft.instance, this);
	}
	
	public void postInitalize() {}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.getServerHandler().playerEntity;
    }
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch(ID) {
				case 0:
					if(entity instanceof TileNuclearFurnace) return new ContainerNuclearFurnace(player.inventory, (TileNuclearFurnace) entity);
					return null;
				case 1:
					if(entity instanceof TileFurnace) return new ContainerFurnace(player.inventory, (TileFurnace) entity);
					return null;
				case 2:
					if(entity instanceof TileCrusher) return new ContainerCrusher(player.inventory, (TileCrusher) entity);
					return null;
				case 3:
					if(entity instanceof TileElectricCrusher) return new ContainerElectricCrusher(player.inventory, (TileElectricCrusher) entity);
					return null;
				case 4:
					if(entity instanceof TileElectricFurnace) return new ContainerElectricFurnace(player.inventory, (TileElectricFurnace) entity);
					return null;
				case 5:
					if(entity instanceof TileReactionGenerator) return new ContainerReactionGenerator(player.inventory, (TileReactionGenerator) entity);
					return null;
				case 6:
					if(entity instanceof TileSeparator) return new ContainerSeparator(player.inventory, (TileSeparator) entity);
					return null;
				case 7:
					if(entity instanceof TileHastener) return new ContainerHastener(player.inventory, (TileHastener) entity);
					return null;
				case 8:
					if(entity instanceof TileFissionReactor) return new ContainerFissionReactor(player.inventory, (TileFissionReactor) entity);
					return null;
				case 9:
					if(entity instanceof TileNuclearWorkspace) return new ContainerNuclearWorkspace(player.inventory, world, x, y, z, (TileNuclearWorkspace) entity);
					return null;
				case 10:
					if(entity instanceof TileCollector) return new ContainerCollector(player.inventory, (TileCollector) entity);
					return null;
				case 11:
					if(entity instanceof TileFusionReactor) return new ContainerFusionReactor(player.inventory, (TileFusionReactor) entity);
					return null;
				case 12:
					if(entity instanceof TileElectrolyser) return new ContainerElectrolyser(player.inventory, (TileElectrolyser) entity);
					return null;
				case 13:
					if(entity instanceof TileOxidiser) return new ContainerOxidiser(player.inventory, (TileOxidiser) entity);
					return null;
				case 14:
					if(entity instanceof TileIoniser) return new ContainerIoniser(player.inventory, (TileIoniser) entity);
					return null;
				case 15:
					if(entity instanceof TileIrradiator) return new ContainerIrradiator(player.inventory, (TileIrradiator) entity);
					return null;
				case 16:
					if(entity instanceof TileCooler) return new ContainerCooler(player.inventory, (TileCooler) entity);
					return null;
				case 17:
					if(entity instanceof TileFactory) return new ContainerFactory(player.inventory, (TileFactory) entity);
					return null;
				case 18:
					if(entity instanceof TileHeliumExtractor) return new ContainerHeliumExtractor(player.inventory, (TileHeliumExtractor) entity);
					return null;
				case 19:
					if(entity instanceof TileSynchrotron) return new ContainerSynchrotron(player.inventory, (TileSynchrotron) entity);
					return null;
				case 20:
					if(entity instanceof TileAssembler) return new ContainerAssembler(player.inventory, (TileAssembler) entity);
					return null;
				case 21:
					if(entity instanceof TileFissionReactorSteam) return new ContainerFissionReactorSteam(player.inventory, (TileFissionReactorSteam) entity);
					return null;
				case 22:
					if(entity instanceof TileFusionReactorSteam) return new ContainerFusionReactorSteam(player.inventory, (TileFusionReactorSteam) entity);
					return null;
				case 23:
					if(entity instanceof TileRecycler) return new ContainerRecycler(player.inventory, (TileRecycler) entity);
					return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	private void addLoot(boolean flag) {
		if(!flag)
			return;
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 2, 4, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 2, 4, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 4*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 3, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 1, 3, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.pistol, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 4*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 2, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 1, 2, 2*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.pistol, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 5*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 5, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fishAndRicecake, 1), 1, 5, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughHelm, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughLegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBoots, 1), 1, 1, Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughHelm, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughLegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBoots, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fishAndRicecake, 1), 4, 5, 5*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughAlloyPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.AmRTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 9), 4, 6, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 16), 7, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 17), 7, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 0), 7, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 4), 7, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 14), 6, 8, 4*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fishAndRicecake, 1), 4, 5, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughAlloyPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.AmRTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 9), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, 2*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 16), 4, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 17), 4, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 0), 4, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 4), 4, 8, 4*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 14), 6, 8, 4*Config.lootModifier));
		
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 4, 5, 3*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 4, 5, 3*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 46), 1, 1, 3*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 75), 4, 5, 7*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.RTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 49), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 50), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 47), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.simpleQuantumUp, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUHelm, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dULegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUBoots, 1), 1, 1, Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 2, 3, 3*Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(NCItems.boiledEgg, 1), 2, 3, 3*Config.lootModifier));
	}
	
}
