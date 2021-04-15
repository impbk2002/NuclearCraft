package nc.block;

import cpw.mods.fml.common.registry.GameRegistry;
import nc.block.accelerator.BlockSuperElectromagnet;
import nc.block.accelerator.BlockSupercooler;
import nc.block.accelerator.BlockSynchrotron;
import nc.block.basic.BlockBlock;
import nc.block.basic.BlockMachineBlock;
import nc.block.basic.BlockOre;
import nc.block.crafting.BlockNuclearWorkspace;
import nc.block.fluid.BlockDenseSteam;
import nc.block.fluid.BlockHelium;
import nc.block.fluid.BlockPlasma;
import nc.block.fluid.BlockSteam;
import nc.block.fluid.BlockSuperdenseSteam;
import nc.block.fluid.NCFluids;
import nc.block.generator.BlockAmRTG;
import nc.block.generator.BlockCfRTG;
import nc.block.generator.BlockDenseSteamDecompressor;
import nc.block.generator.BlockElectromagnet;
import nc.block.generator.BlockFissionReactor;
import nc.block.generator.BlockFissionReactorSteam;
import nc.block.generator.BlockFusionReactor;
import nc.block.generator.BlockFusionReactorBlock;
import nc.block.generator.BlockFusionReactorBlockTop;
import nc.block.generator.BlockFusionReactorSteam;
import nc.block.generator.BlockFusionReactorSteamBlock;
import nc.block.generator.BlockFusionReactorSteamBlockTop;
import nc.block.generator.BlockRTG;
import nc.block.generator.BlockReactionGenerator;
import nc.block.generator.BlockSolarPanel;
import nc.block.generator.BlockSteamDecompressor;
import nc.block.generator.BlockSteamGenerator;
import nc.block.generator.BlockWRTG;
import nc.block.machine.BlockAssembler;
import nc.block.machine.BlockCollector;
import nc.block.machine.BlockCooler;
import nc.block.machine.BlockCrusher;
import nc.block.machine.BlockElectricCrusher;
import nc.block.machine.BlockElectricFurnace;
import nc.block.machine.BlockElectrolyser;
import nc.block.machine.BlockFactory;
import nc.block.machine.BlockFurnace;
import nc.block.machine.BlockHastener;
import nc.block.machine.BlockHeliumExtractor;
import nc.block.machine.BlockIoniser;
import nc.block.machine.BlockIrradiator;
import nc.block.machine.BlockNuclearFurnace;
import nc.block.machine.BlockOxidiser;
import nc.block.machine.BlockRecycler;
import nc.block.machine.BlockSeparator;
import nc.block.nuke.BlockAntimatterBomb;
import nc.block.nuke.BlockAntimatterBombExploding;
import nc.block.nuke.BlockEMP;
import nc.block.nuke.BlockEMPExploding;
import nc.block.nuke.BlockNuke;
import nc.block.nuke.BlockNukeExploding;
import nc.block.quantum.BlockSimpleQuantum;
import nc.block.reactor.BlockBlastBlock;
import nc.block.reactor.BlockCellBlock;
import nc.block.reactor.BlockCoolerBlock;
import nc.block.reactor.BlockFusionConnector;
import nc.block.reactor.BlockGraphiteBlock;
import nc.block.reactor.BlockReactorBlock;
import nc.block.reactor.BlockSpeedBlock;
import nc.block.reactor.BlockTubing1;
import nc.block.reactor.BlockTubing2;
import nc.block.storage.BlockLithiumIonBattery;
import nc.block.storage.BlockVoltaicPile;
import nc.itemblock.accelerator.ItemBlockSuperElectromagnet;
import nc.itemblock.accelerator.ItemBlockSupercooler;
import nc.itemblock.accelerator.ItemBlockSynchrotron;
import nc.itemblock.basic.ItemBlockBlock;
import nc.itemblock.basic.ItemBlockOre;
import nc.itemblock.crafting.ItemBlockNuclearWorkspace;
import nc.itemblock.generator.ItemBlockAmRTG;
import nc.itemblock.generator.ItemBlockCfRTG;
import nc.itemblock.generator.ItemBlockDenseSteamDecompressor;
import nc.itemblock.generator.ItemBlockElectromagnet;
import nc.itemblock.generator.ItemBlockFissionReactor;
import nc.itemblock.generator.ItemBlockFissionReactorSteam;
import nc.itemblock.generator.ItemBlockFusionReactor;
import nc.itemblock.generator.ItemBlockFusionReactorSteam;
import nc.itemblock.generator.ItemBlockRTG;
import nc.itemblock.generator.ItemBlockReactionGenerator;
import nc.itemblock.generator.ItemBlockSolarPanel;
import nc.itemblock.generator.ItemBlockSteamDecompressor;
import nc.itemblock.generator.ItemBlockSteamGenerator;
import nc.itemblock.generator.ItemBlockWRTG;
import nc.itemblock.machine.ItemBlockAssembler;
import nc.itemblock.machine.ItemBlockCollector;
import nc.itemblock.machine.ItemBlockCooler;
import nc.itemblock.machine.ItemBlockCrusher;
import nc.itemblock.machine.ItemBlockElectricCrusher;
import nc.itemblock.machine.ItemBlockElectricFurnace;
import nc.itemblock.machine.ItemBlockElectrolyser;
import nc.itemblock.machine.ItemBlockFactory;
import nc.itemblock.machine.ItemBlockFurnace;
import nc.itemblock.machine.ItemBlockHastener;
import nc.itemblock.machine.ItemBlockHeliumExtractor;
import nc.itemblock.machine.ItemBlockIoniser;
import nc.itemblock.machine.ItemBlockIrradiator;
import nc.itemblock.machine.ItemBlockNuclearFurnace;
import nc.itemblock.machine.ItemBlockOxidiser;
import nc.itemblock.machine.ItemBlockRecycler;
import nc.itemblock.machine.ItemBlockSeparator;
import nc.itemblock.nuke.ItemBlockAntimatterBomb;
import nc.itemblock.nuke.ItemBlockEMP;
import nc.itemblock.nuke.ItemBlockNuke;
import nc.itemblock.quantum.ItemBlockSimpleQuantum;
import nc.itemblock.reactor.ItemBlockBlastBlock;
import nc.itemblock.reactor.ItemBlockCellBlock;
import nc.itemblock.reactor.ItemBlockCoolerBlock;
import nc.itemblock.reactor.ItemBlockFusionConnector;
import nc.itemblock.reactor.ItemBlockGraphiteBlock;
import nc.itemblock.reactor.ItemBlockReactorBlock;
import nc.itemblock.reactor.ItemBlockSpeedBlock;
import nc.itemblock.storage.ItemBlockLithiumIonBattery;
import nc.itemblock.storage.ItemBlockVoltaicPile;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.DamageSource;
import static nc.NuclearCraft.tabNC;

public class NCBlocks {
	public static final Material liquidhelium = (new MaterialLiquid(MapColor.redColor));
	public static final Material fusionplasma = (new MaterialLiquid(MapColor.purpleColor));
	public static final Material steamMaterial = (new MaterialLiquid(MapColor.grayColor));

	public static void preInitalize() {
		
		// Ore Registry
		GameRegistry.registerBlock(NCBlocks.blockOre = new BlockOre("blockOre", Material.rock), ItemBlockOre.class,
				"blockOre");

		// Block Registry
		GameRegistry.registerBlock(NCBlocks.blockBlock = new BlockBlock("blockBlock", Material.iron),
				ItemBlockBlock.class, "blockBlock");
		
		// Fluid
		NCBlocks.blockHelium = new BlockHelium(NCFluids.liquidHelium, liquidhelium.setReplaceable(), heliumfreeze)
				.setCreativeTab(tabNC).setBlockName("liquidHeliumBlock");
		NCBlocks.blockFusionPlasma = new BlockPlasma(NCFluids.fusionPlasma, fusionplasma.setReplaceable(), plasmaburn)
				.setCreativeTab(tabNC).setBlockName("fusionPlasmaBlock");
		NCBlocks.blockSteam = new BlockSteam(NCFluids.steam, steamMaterial.setReplaceable(), steamburn)
				.setCreativeTab(tabNC).setBlockName("steamBlock");
		NCBlocks.blockDenseSteam = new BlockDenseSteam(NCFluids.denseSteam, steamMaterial.setReplaceable(), steamburn)
				.setCreativeTab(tabNC).setBlockName("denseSteamBlock");
		NCBlocks.blockSuperdenseSteam = new BlockSuperdenseSteam(NCFluids.superdenseSteam,
				steamMaterial.setReplaceable(), steamburn).setCreativeTab(tabNC).setBlockName("superdenseSteamBlock");

		GameRegistry.registerBlock(NCBlocks.blockHelium, "liquidHeliumBlock");
		GameRegistry.registerBlock(NCBlocks.blockFusionPlasma, "fusionPlasmaBlock");
		GameRegistry.registerBlock(NCBlocks.blockSteam, "steamBlock");
		GameRegistry.registerBlock(NCBlocks.blockDenseSteam, "denseSteamBlock");
		GameRegistry.registerBlock(NCBlocks.blockSuperdenseSteam, "superdenseSteamBlock");

		normal();
		machine();
	}

	public static void initialize() {
	}

	public static void postInitalize() {
	}

	private static void machine() {
		// Machine Registry
		// Block
		NCBlocks.electromagnetIdle = new BlockElectromagnet(false).setBlockName("electromagnetIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.electromagnetIdle, ItemBlockElectromagnet.class, "electromagnetIdle");
		NCBlocks.electromagnetActive = new BlockElectromagnet(true).setBlockName("electromagnetActive")
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.electromagnetActive, ItemBlockElectromagnet.class, "electromagnetActive");
		NCBlocks.superElectromagnetIdle = new BlockSuperElectromagnet(false).setBlockName("superElectromagnetIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.superElectromagnetIdle, ItemBlockSuperElectromagnet.class,
				"superElectromagnetIdle");
		NCBlocks.superElectromagnetActive = new BlockSuperElectromagnet(true).setBlockName("superElectromagnetActive")
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.superElectromagnetActive, ItemBlockSuperElectromagnet.class,
				"superElectromagnetActive");
		NCBlocks.supercoolerIdle = new BlockSupercooler(false).setBlockName("supercoolerIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.supercoolerIdle, ItemBlockSupercooler.class, "supercoolerIdle");
		NCBlocks.supercoolerActive = new BlockSupercooler(true).setBlockName("supercoolerActive")
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.supercoolerActive, ItemBlockSupercooler.class, "supercoolerActive");
		NCBlocks.synchrotronIdle = new BlockSynchrotron(false).setBlockName("synchrotronIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.synchrotronIdle, ItemBlockSynchrotron.class, "synchrotronIdle");
		NCBlocks.synchrotronActive = new BlockSynchrotron(true).setBlockName("synchrotronActive")
				.setStepSound(Block.soundTypeMetal).setResistance(8.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.synchrotronActive, ItemBlockSynchrotron.class, "synchrotronActive");

		NCBlocks.nuclearWorkspace = new BlockNuclearWorkspace(Material.iron).setBlockName("nuclearWorkspace")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.nuclearWorkspace, ItemBlockNuclearWorkspace.class, "nuclearWorkspace");

		NCBlocks.fusionReactor = new BlockFusionReactor(Material.iron).setBlockName("fusionReactor")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactor, ItemBlockFusionReactor.class, "fusionReactor");
		NCBlocks.fusionReactorBlock = new BlockFusionReactorBlock().setBlockName("fusionReactorBlock")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactorBlock, "fusionReactorBlock");
		NCBlocks.fusionReactorBlockTop = new BlockFusionReactorBlockTop().setBlockName("fusionReactorBlockTop")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactorBlockTop, "fusionReactorBlockTop");

		NCBlocks.fusionReactorSteam = new BlockFusionReactorSteam(Material.iron).setBlockName("fusionReactorSteam")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactorSteam, ItemBlockFusionReactorSteam.class,
				"fusionReactorSteam");
		NCBlocks.fusionReactorSteamBlock = new BlockFusionReactorSteamBlock().setBlockName("fusionReactorSteamBlock")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactorSteamBlock, "fusionReactorSteamBlock");
		NCBlocks.fusionReactorSteamBlockTop = new BlockFusionReactorSteamBlockTop()
				.setBlockName("fusionReactorSteamBlockTop").setStepSound(Block.soundTypeMetal).setResistance(20.0F)
				.setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fusionReactorSteamBlockTop, "fusionReactorSteamBlockTop");

		NCBlocks.nuclearFurnaceIdle = new BlockNuclearFurnace(false).setBlockName("nuclearFurnaceIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.nuclearFurnaceIdle, ItemBlockNuclearFurnace.class, "nuclearFurnaceIdle");
		NCBlocks.nuclearFurnaceActive = new BlockNuclearFurnace(true).setBlockName("nuclearFurnaceActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.nuclearFurnaceActive, ItemBlockNuclearFurnace.class,
				"nuclearFurnaceActive");
		NCBlocks.furnaceIdle = new BlockFurnace(false).setBlockName("furnaceIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.furnaceIdle, ItemBlockFurnace.class, "furnaceIdle");
		NCBlocks.furnaceActive = new BlockFurnace(true).setBlockName("furnaceActive").setStepSound(Block.soundTypeMetal)
				.setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.furnaceActive, ItemBlockFurnace.class, "furnaceActive");
		NCBlocks.crusherIdle = new BlockCrusher(false).setBlockName("crusherIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.crusherIdle, ItemBlockCrusher.class, "crusherIdle");
		NCBlocks.crusherActive = new BlockCrusher(true).setBlockName("crusherActive").setStepSound(Block.soundTypeMetal)
				.setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.crusherActive, ItemBlockCrusher.class, "crusherActive");
		NCBlocks.electricCrusherIdle = new BlockElectricCrusher(false).setBlockName("electricCrusherIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electricCrusherIdle, ItemBlockElectricCrusher.class, "electricCrusherIdle");
		NCBlocks.electricCrusherActive = new BlockElectricCrusher(true).setBlockName("electricCrusherActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electricCrusherActive, ItemBlockElectricCrusher.class,
				"electricCrusherActive");
		NCBlocks.electricFurnaceIdle = new BlockElectricFurnace(false).setBlockName("electricFurnaceIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electricFurnaceIdle, ItemBlockElectricFurnace.class, "electricFurnaceIdle");
		NCBlocks.electricFurnaceActive = new BlockElectricFurnace(true).setBlockName("electricFurnaceActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electricFurnaceActive, ItemBlockElectricFurnace.class,
				"electricFurnaceActive");

		NCBlocks.reactionGeneratorIdle = new BlockReactionGenerator(false).setBlockName("reactionGeneratorIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.reactionGeneratorIdle, ItemBlockReactionGenerator.class,
				"reactionGeneratorIdle");
		NCBlocks.reactionGeneratorActive = new BlockReactionGenerator(true).setBlockName("reactionGeneratorActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.reactionGeneratorActive, ItemBlockReactionGenerator.class,
				"reactionGeneratorActive");

		NCBlocks.fissionReactorGraphiteIdle = new BlockFissionReactor(false).setBlockName("fissionReactorGraphiteIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fissionReactorGraphiteIdle, ItemBlockFissionReactor.class,
				"fissionReactorGraphiteIdle");
		NCBlocks.fissionReactorGraphiteActive = new BlockFissionReactor(true)
				.setBlockName("fissionReactorGraphiteActive").setStepSound(Block.soundTypeMetal).setResistance(5.0F)
				.setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fissionReactorGraphiteActive, ItemBlockFissionReactor.class,
				"fissionReactorGraphiteActive");

		NCBlocks.fissionReactorSteamIdle = new BlockFissionReactorSteam(false).setBlockName("fissionReactorSteamIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fissionReactorSteamIdle, ItemBlockFissionReactorSteam.class,
				"fissionReactorSteamIdle");
		NCBlocks.fissionReactorSteamActive = new BlockFissionReactorSteam(true)
				.setBlockName("fissionReactorSteamActive").setStepSound(Block.soundTypeMetal).setResistance(5.0F)
				.setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.fissionReactorSteamActive, ItemBlockFissionReactorSteam.class,
				"fissionReactorSteamActive");

		NCBlocks.RTG = new BlockRTG().setBlockName("RTG").setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal)
				.setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.RTG, ItemBlockRTG.class, "RTG");
		NCBlocks.AmRTG = new BlockAmRTG().setBlockName("AmRTG").setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal)
				.setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.AmRTG, ItemBlockAmRTG.class, "AmRTG");
		NCBlocks.CfRTG = new BlockCfRTG().setBlockName("CfRTG").setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal)
				.setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.CfRTG, ItemBlockCfRTG.class, "CfRTG");
		NCBlocks.WRTG = new BlockWRTG().setBlockName("WRTG").setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal)
				.setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.WRTG, ItemBlockWRTG.class, "WRTG");
		NCBlocks.solarPanel = new BlockSolarPanel().setBlockName("solarPanel").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.solarPanel, ItemBlockSolarPanel.class, "solarPanel");

		NCBlocks.lithiumIonBatteryBlock = new BlockLithiumIonBattery().setBlockName("lithiumIonBatteryBlock")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.lithiumIonBatteryBlock, ItemBlockLithiumIonBattery.class,
				"lithiumIonBatteryBlock");
		NCBlocks.voltaicPile = new BlockVoltaicPile().setBlockName("voltaicPile").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.voltaicPile, ItemBlockVoltaicPile.class, "voltaicPile");

		NCBlocks.separatorIdle = new BlockSeparator(false).setBlockName("separatorIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.separatorIdle, ItemBlockSeparator.class, "separatorIdle");
		NCBlocks.separatorActive = new BlockSeparator(true).setBlockName("separatorActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.separatorActive, ItemBlockSeparator.class, "separatorActive");
		NCBlocks.hastenerIdle = new BlockHastener(false).setBlockName("hastenerIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.hastenerIdle, ItemBlockHastener.class, "hastenerIdle");
		NCBlocks.hastenerActive = new BlockHastener(true).setBlockName("hastenerActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.hastenerActive, ItemBlockHastener.class, "hastenerActive");
		NCBlocks.electrolyserIdle = new BlockElectrolyser(false).setBlockName("electrolyserIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electrolyserIdle, ItemBlockElectrolyser.class, "electrolyserIdle");
		NCBlocks.electrolyserActive = new BlockElectrolyser(true).setBlockName("electrolyserActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.electrolyserActive, ItemBlockElectrolyser.class, "electrolyserActive");

		NCBlocks.collectorIdle = new BlockCollector(false).setBlockName("collectorIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.collectorIdle, ItemBlockCollector.class, "collectorIdle");
		NCBlocks.collectorActive = new BlockCollector(true).setBlockName("collectorActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.collectorActive, ItemBlockCollector.class, "collectorActive");
		NCBlocks.oxidiserIdle = new BlockOxidiser(false).setBlockName("oxidiserIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.oxidiserIdle, ItemBlockOxidiser.class, "oxidiserIdle");
		NCBlocks.oxidiserActive = new BlockOxidiser(true).setBlockName("oxidiserActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.oxidiserActive, ItemBlockOxidiser.class, "oxidiserActive");
		NCBlocks.ioniserIdle = new BlockIoniser(false).setBlockName("ioniserIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.ioniserIdle, ItemBlockIoniser.class, "ioniserIdle");
		NCBlocks.ioniserActive = new BlockIoniser(true).setBlockName("ioniserActive").setStepSound(Block.soundTypeMetal)
				.setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.ioniserActive, ItemBlockIoniser.class, "ioniserActive");
		NCBlocks.irradiatorIdle = new BlockIrradiator(false).setBlockName("irradiatorIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.irradiatorIdle, ItemBlockIrradiator.class, "irradiatorIdle");
		NCBlocks.irradiatorActive = new BlockIrradiator(true).setBlockName("irradiatorActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.irradiatorActive, ItemBlockIrradiator.class, "irradiatorActive");
		NCBlocks.coolerIdle = new BlockCooler(false).setBlockName("coolerIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.coolerIdle, ItemBlockCooler.class, "coolerIdle");
		NCBlocks.coolerActive = new BlockCooler(true).setBlockName("coolerActive").setStepSound(Block.soundTypeMetal)
				.setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.coolerActive, ItemBlockCooler.class, "coolerActive");
		NCBlocks.factoryIdle = new BlockFactory(false).setBlockName("factoryIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.factoryIdle, ItemBlockFactory.class, "factoryIdle");
		NCBlocks.factoryActive = new BlockFactory(true).setBlockName("factoryActive").setStepSound(Block.soundTypeMetal)
				.setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.factoryActive, ItemBlockFactory.class, "factoryActive");
		NCBlocks.heliumExtractorIdle = new BlockHeliumExtractor(false).setBlockName("heliumExtractorIdle")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.heliumExtractorIdle, ItemBlockHeliumExtractor.class, "heliumExtractorIdle");
		NCBlocks.heliumExtractorActive = new BlockHeliumExtractor(true).setBlockName("heliumExtractorActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.heliumExtractorActive, ItemBlockHeliumExtractor.class,
				"heliumExtractorActive");
		NCBlocks.assemblerIdle = new BlockAssembler(false).setBlockName("assemblerIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.assemblerIdle, ItemBlockAssembler.class, "assemblerIdle");
		NCBlocks.assemblerActive = new BlockAssembler(true).setBlockName("assemblerActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.assemblerActive, ItemBlockAssembler.class, "assemblerActive");
		NCBlocks.recyclerIdle = new BlockRecycler(false).setBlockName("recyclerIdle").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.recyclerIdle, ItemBlockRecycler.class, "recyclerIdle");
		NCBlocks.recyclerActive = new BlockRecycler(true).setBlockName("recyclerActive")
				.setStepSound(Block.soundTypeMetal).setResistance(20.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.recyclerActive, ItemBlockRecycler.class, "recyclerActive");

		NCBlocks.steamGenerator = new BlockSteamGenerator().setBlockName("steamGenerator").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.steamGenerator, ItemBlockSteamGenerator.class, "steamGenerator");
		NCBlocks.steamDecompressor = new BlockSteamDecompressor().setBlockName("steamDecompressor")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.steamDecompressor, ItemBlockSteamDecompressor.class, "steamDecompressor");
		NCBlocks.denseSteamDecompressor = new BlockDenseSteamDecompressor().setBlockName("denseSteamDecompressor")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(5.0F);
		GameRegistry.registerBlock(NCBlocks.denseSteamDecompressor, ItemBlockDenseSteamDecompressor.class,
				"denseSteamDecompressor");

		NCBlocks.nuke = new BlockNuke().setBlockName("nuke").setCreativeTab(tabNC).setStepSound(Block.soundTypeCloth)
				.setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.nuke, ItemBlockNuke.class, "nuke");
		NCBlocks.nukeE = new BlockNukeExploding().setBlockName("nukeE").setStepSound(Block.soundTypeCloth)
				.setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.nukeE, ItemBlockNuke.class, "nukeE");

		NCBlocks.antimatterBomb = new BlockAntimatterBomb().setBlockName("antimatterBomb").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeCloth).setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.antimatterBomb, ItemBlockAntimatterBomb.class, "antimatterBomb");
		NCBlocks.antimatterBombE = new BlockAntimatterBombExploding().setBlockName("antimatterBombE")
				.setStepSound(Block.soundTypeCloth).setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.antimatterBombE, ItemBlockAntimatterBomb.class, "antimatterBombE");

		NCBlocks.EMP = new BlockEMP().setBlockName("EMP").setCreativeTab(tabNC).setStepSound(Block.soundTypeCloth)
				.setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.EMP, ItemBlockEMP.class, "EMP");
		NCBlocks.EMPE = new BlockEMPExploding().setBlockName("EMPE").setStepSound(Block.soundTypeCloth)
				.setHardness(0.0F);
		GameRegistry.registerBlock(NCBlocks.EMPE, ItemBlockEMP.class, "EMPE");
	}

	private static void normal() {
		NCBlocks.simpleQuantumUp = new BlockSimpleQuantum(true).setBlockName("simpleQuantumUp").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.simpleQuantumUp, ItemBlockSimpleQuantum.class, "simpleQuantumUp");
		NCBlocks.simpleQuantumDown = new BlockSimpleQuantum(false).setBlockName("simpleQuantumDown")
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.simpleQuantumDown, ItemBlockSimpleQuantum.class, "simpleQuantumDown");

		NCBlocks.graphiteBlock = new BlockGraphiteBlock().setBlockName("graphiteBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeStone).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.graphiteBlock, ItemBlockGraphiteBlock.class, "graphiteBlock");
		NCBlocks.cellBlock = new BlockCellBlock().setBlockName("cellBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.cellBlock, ItemBlockCellBlock.class, "cellBlock");
		NCBlocks.reactorBlock = new BlockReactorBlock().setBlockName("reactorBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.reactorBlock, ItemBlockReactorBlock.class, "reactorBlock");
		NCBlocks.fusionConnector = new BlockFusionConnector().setBlockName("fusionConnector").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(3.0F);
		GameRegistry.registerBlock(NCBlocks.fusionConnector, ItemBlockFusionConnector.class, "fusionConnector");

		NCBlocks.coolerBlock = new BlockCoolerBlock().setBlockName("coolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.coolerBlock, ItemBlockCoolerBlock.class, "coolerBlock");
		NCBlocks.emptyCoolerBlock = new BlockCoolerBlock().setBlockName("emptyCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.emptyCoolerBlock, "emptyCoolerBlock");
		NCBlocks.waterCoolerBlock = new BlockCoolerBlock().setBlockName("waterCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.waterCoolerBlock, ItemBlockCoolerBlock.class, "waterCoolerBlock");
		NCBlocks.cryotheumCoolerBlock = new BlockCoolerBlock().setBlockName("cryotheumCoolerBlock")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F)
				.setLightLevel(0.25F);
		GameRegistry.registerBlock(NCBlocks.cryotheumCoolerBlock, ItemBlockCoolerBlock.class, "cryotheumCoolerBlock");
		NCBlocks.redstoneCoolerBlock = new BlockCoolerBlock().setBlockName("redstoneCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F).setLightLevel(0.25F);
		GameRegistry.registerBlock(NCBlocks.redstoneCoolerBlock, ItemBlockCoolerBlock.class, "redstoneCoolerBlock");
		NCBlocks.enderiumCoolerBlock = new BlockCoolerBlock().setBlockName("enderiumCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F).setLightLevel(0.25F);
		GameRegistry.registerBlock(NCBlocks.enderiumCoolerBlock, ItemBlockCoolerBlock.class, "enderiumCoolerBlock");
		NCBlocks.glowstoneCoolerBlock = new BlockCoolerBlock().setBlockName("glowstoneCoolerBlock")
				.setCreativeTab(tabNC).setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F)
				.setLightLevel(1F);
		GameRegistry.registerBlock(NCBlocks.glowstoneCoolerBlock, ItemBlockCoolerBlock.class, "glowstoneCoolerBlock");
		NCBlocks.coolantCoolerBlock = new BlockCoolerBlock().setBlockName("coolantCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.coolantCoolerBlock, ItemBlockCoolerBlock.class, "coolantCoolerBlock");
		NCBlocks.heliumCoolerBlock = new BlockCoolerBlock().setBlockName("heliumCoolerBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.heliumCoolerBlock, ItemBlockCoolerBlock.class, "heliumCoolerBlock");

		NCBlocks.speedBlock = new BlockSpeedBlock().setBlockName("speedBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.speedBlock, ItemBlockSpeedBlock.class, "speedBlock");
		NCBlocks.blastBlock = new BlockBlastBlock().setBlockName("blastBlock").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(6000.0F).setHardness(10.0F);
		GameRegistry.registerBlock(NCBlocks.blastBlock, ItemBlockBlastBlock.class, "blastBlock");
		NCBlocks.machineBlock = new BlockMachineBlock().setBlockName("machineBlockNC").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.machineBlock, "machineBlockNC");

		NCBlocks.tubing1 = new BlockTubing1().setBlockName("tubing1").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.tubing1, "tubing1");
		NCBlocks.tubing2 = new BlockTubing2().setBlockName("tubing2").setCreativeTab(tabNC)
				.setStepSound(Block.soundTypeMetal).setResistance(5.0F).setHardness(2.0F);
		GameRegistry.registerBlock(NCBlocks.tubing2, "tubing2");
	}
	
	public static DamageSource heliumfreeze = (new DamageSource("heliumfreeze")).setDamageBypassesArmor();
	public static DamageSource plasmaburn = (new DamageSource("plasmaburn")).setDamageBypassesArmor();
	public static DamageSource steamburn = (new DamageSource("steamburn")).setDamageBypassesArmor();

	public static Block blockOre;
	public static Block blockBlock;
	public static Block nuclearFurnaceIdle;
	public static Block nuclearFurnaceActive;
	public static Block furnaceIdle;
	public static Block furnaceActive;
	public static Block crusherIdle;
	public static Block crusherActive;
	public static Block electricCrusherIdle;
	public static Block electricCrusherActive;
	public static Block electricFurnaceIdle;
	public static Block electricFurnaceActive;
	public static Block reactionGeneratorIdle;
	public static Block reactionGeneratorActive;
	public static Block separatorIdle;
	public static Block separatorActive;
	public static Block hastenerIdle;
	public static Block hastenerActive;
	public static Block graphiteBlock;
	public static Block cellBlock;
	public static Block reactorBlock;
	public static Block machineBlock;
	public static Block coolerBlock;
	public static Block emptyCoolerBlock;
	public static Block waterCoolerBlock;
	public static Block cryotheumCoolerBlock;
	public static Block redstoneCoolerBlock;
	public static Block enderiumCoolerBlock;
	public static Block glowstoneCoolerBlock;
	public static Block coolantCoolerBlock;
	public static Block heliumCoolerBlock;
	public static Block speedBlock;
	public static Block blastBlock;
	public static Block fissionReactorGraphiteIdle;
	public static Block fissionReactorGraphiteActive;
	public static Block fissionReactorSteamIdle;
	public static Block fissionReactorSteamActive;
	public static Block nuclearWorkspace;
	public static Block fusionReactor;
	public static Block fusionReactorBlock;
	public static Block fusionReactorBlockTop;
	public static Block fusionReactorSteam;
	public static Block fusionReactorSteamBlock;
	public static Block fusionReactorSteamBlockTop;
	public static Block tubing1;
	public static Block tubing2;
	public static Block RTG;
	public static Block AmRTG;
	public static Block CfRTG;
	public static Block WRTG;
	public static Block solarPanel;
	public static Block collectorIdle;
	public static Block collectorActive;
	public static Block nuke;
	public static Block nukeE;
	public static Block antimatterBomb;
	public static Block antimatterBombE;
	public static Block EMP;
	public static Block EMPE;
	public static Block electrolyserIdle;
	public static Block electrolyserActive;
	public static Block oxidiserIdle;
	public static Block oxidiserActive;
	public static Block ioniserIdle;
	public static Block ioniserActive;
	public static Block irradiatorIdle;
	public static Block irradiatorActive;
	public static Block coolerIdle;
	public static Block coolerActive;
	public static Block factoryIdle;
	public static Block factoryActive;
	public static Block assemblerIdle;
	public static Block assemblerActive;
	public static Block heliumExtractorIdle;
	public static Block heliumExtractorActive;
	public static Block recyclerIdle;
	public static Block recyclerActive;

	public static Block fusionConnector;
	public static Block electromagnetIdle;
	public static Block electromagnetActive;
	public static Block superElectromagnetIdle;
	public static Block superElectromagnetActive;
	public static Block supercoolerIdle;
	public static Block supercoolerActive;
	public static Block synchrotronIdle;
	public static Block synchrotronActive;

	public static Block lithiumIonBatteryBlock;
	public static Block voltaicPile;

	public static Block simpleQuantumUp;
	public static Block simpleQuantumDown;

	public static Block blockHelium;
	public static Block blockFusionPlasma;
	public static Block blockSteam;
	public static Block blockDenseSteam;
	public static Block blockSuperdenseSteam;

	public static Block steamGenerator;
	public static Block steamDecompressor;
	public static Block denseSteamDecompressor;
}
