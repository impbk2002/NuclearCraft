package nc.proxy;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import nc.*;
import nc.block.*;
import nc.container.accelerator.*;
import nc.tile.accelerator.*;
import nc.container.crafting.*;
import nc.container.generator.*;
import nc.container.machine.*;
import nc.item.*;
import nc.tile.crafting.*;
import nc.tile.generator.*;
import nc.tile.machine.*;
import static nc.NuclearCraft.logger;

public class CommonProxy implements IGuiHandler {

	public void preInitalize() {
		// Random Chest Loot
		addLoot(Config.enableLoot);
	}

	public void initialize() {
	}

	public void postInitalize() {
	}

	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			logger.info("successfuly invoked Server Container Method");
			switch (ID) {
				case NuclearCraft.guiIdNuclearFurnace:
					return new ContainerNuclearFurnace(player.inventory, (TileNuclearFurnace) entity);
				case NuclearCraft.guiIdFurnace:
					return new ContainerFurnace(player.inventory, (TileFurnace) entity);
				case NuclearCraft.guiIdCrusher:
					return new ContainerCrusher(player.inventory, (TileCrusher) entity);
				case NuclearCraft.guiIdElectricCrusher:
					return new ContainerElectricCrusher(player.inventory, (TileElectricCrusher) entity);
				case NuclearCraft.guiIdElectricFurnace:
					return new ContainerElectricFurnace(player.inventory, (TileElectricFurnace) entity);
				case NuclearCraft.guiIdReactionGenerator:
					return new ContainerReactionGenerator(player.inventory, (TileReactionGenerator) entity);
				case NuclearCraft.guiIdSeparator:
					return new ContainerSeparator(player.inventory, (TileSeparator) entity);
				case NuclearCraft.guiIdHastener:
					return new ContainerHastener(player.inventory, (TileHastener) entity);
				case NuclearCraft.guiIdFissionReactorGraphite:
					return new ContainerFissionReactor(player.inventory, (TileFissionReactor) entity);
				case NuclearCraft.guiIdNuclearWorkspace:
					return new ContainerNuclearWorkspace(player.inventory, world, x, y, z, (TileNuclearWorkspace) entity);
				case NuclearCraft.guiIdCollector:
					return new ContainerCollector(player.inventory, (TileCollector) entity);
				case NuclearCraft.guiIdFusionReactor:
					return new ContainerFusionReactor(player.inventory, (TileFusionReactor) entity);
				case NuclearCraft.guiIdElectrolyser:
					return new ContainerElectrolyser(player.inventory, (TileElectrolyser) entity);
				case NuclearCraft.guiIdOxidiser:
					return new ContainerOxidiser(player.inventory, (TileOxidiser) entity);
				case NuclearCraft.guiIdIoniser:
					return new ContainerIoniser(player.inventory, (TileIoniser) entity);
				case NuclearCraft.guiIdIrradiator:
					return new ContainerIrradiator(player.inventory, (TileIrradiator) entity);
				case NuclearCraft.guiIdCooler:
					return new ContainerCooler(player.inventory, (TileCooler) entity);
				case NuclearCraft.guiIdFactory:
					return new ContainerFactory(player.inventory, (TileFactory) entity);
				case NuclearCraft.guiIdHeliumExtractor:
					return new ContainerHeliumExtractor(player.inventory, (TileHeliumExtractor) entity);
				case NuclearCraft.guiIdSynchrotron:
					return new ContainerSynchrotron(player.inventory, (TileSynchrotron) entity);
				case NuclearCraft.guiIdAssembler:
					return new ContainerAssembler(player.inventory, (TileAssembler) entity);
				case NuclearCraft.guiIdFissionReactorSteam:
					return new ContainerFissionReactorSteam(player.inventory, (TileFissionReactorSteam) entity);
				case NuclearCraft.guiIdFusionReactorSteam:
					return new ContainerFusionReactorSteam(player.inventory, (TileFusionReactorSteam) entity);
				case NuclearCraft.guiIdRecycler:
					return new ContainerRecycler(player.inventory, (TileRecycler) entity);
			}
		}
		logger.warn("failed to open server container");
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		logger.error("why this Client method invoke from Server side?");
		return null;
	}

	private void addLoot(boolean flag) {
		if (!flag)
			return;
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 2, 4, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 2, 4, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordPractice, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 4 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 3, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 1, 3, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.pistol, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 4 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 2, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 1, 2, 2 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.pistol, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dUBullet, 1), 6, 8, 5 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 1, 5, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.fishAndRicecake, 1), 1, 5, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughHelm, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughLegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughBoots, 1), 1, 1, Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughHelm, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughLegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughBoots, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.toughBow, 1), 1, 1, Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.fishAndRicecake, 1), 4, 5, 5 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughAlloyPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.AmRTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 9), 4, 6, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 16), 7, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 17), 7, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 0), 7, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 4), 7, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 14), 6, 8, 4 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.fishAndRicecake, 1), 4, 5, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.toughAlloyPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUPaxel, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.AmRTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 9), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordPractice, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, 2 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 16), 4, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 17), 4, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 0), 4, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 4), 4, 8, 4 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.parts, 1, 14), 6, 8, 4 * Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.dominoes, 1), 4, 5, 3 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 4, 5, 3 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 46), 1, 1, 3 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 75), 4, 5, 7 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCBlocks.RTG, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 49), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 50), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.fuel, 1, 47), 2, 4, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordPractice, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.recordArea51, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(
				new ItemStack(NCItems.recordNeighborhood, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(
				new WeightedRandomChestContent(new ItemStack(NCBlocks.simpleQuantumUp, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUHelm, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUChest, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dULegs, 1), 1, 1, Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(NCItems.dUBoots, 1), 1, 1, Config.lootModifier));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.ricecake, 1), 2, 3, 3 * Config.lootModifier));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(NCItems.boiledEgg, 1), 2, 3, 3 * Config.lootModifier));
	}

}
