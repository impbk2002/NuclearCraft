package nc;

import nc.block.NCBlocks;
import nc.block.fluid.NCFluids;
import nc.entity.*;
import nc.handler.*;
import nc.item.NCItems;
import nc.packet.PacketHandler;
import nc.proxy.CommonProxy;
import nc.tile.accelerator.*;
import nc.tile.crafting.TileNuclearWorkspace;
import nc.tile.generator.*;
import nc.tile.machine.*;
import nc.tile.other.*;
import nc.tile.quantum.TileSimpleQuantum;
import nc.tile.storage.*;
import nc.util.Achievements;
import nc.worldgen.OreGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import nc.common.compat.NCHelper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, acceptedMinecraftVersions = Reference.MINECRAFT_VERSION, version = Reference.VERSION)

public class NuclearCraft {
	
	public static final CreativeTabs tabNC = new CreativeTabs("tabNC") {
		// Creative Tab Shown Item
		public Item getTabIconItem() {
			return Item.getItemFromBlock(NCBlocks.fusionReactor);
		}
	};
	
	// Mod Checker
	public static boolean isIC2Loaded;
	public static boolean isTELoaded;
	
	// Mod Hooks
	public static IC2Recipes IC2Hook;
	public static TERecipes TEHook;
	
	@Instance(Reference.MOD_ID)
	public static NuclearCraft instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy NCProxy;
	
	public static final int guiIdNuclearFurnace = 0;
	public static final int guiIdFurnace = 1;
	public static final int guiIdCrusher = 2;
	public static final int guiIdElectricCrusher = 3;
	public static final int guiIdElectricFurnace = 4;
	public static final int guiIdReactionGenerator = 5;
	public static final int guiIdSeparator = 6;
	public static final int guiIdHastener = 7;
	public static final int guiIdFissionReactorGraphite = 8;
	public static final int guiIdNuclearWorkspace = 9;
	public static final int guiIdCollector = 10;
	public static final int guiIdFusionReactor = 11;
	public static final int guiIdElectrolyser = 12;
	public static final int guiIdOxidiser = 13;
	public static final int guiIdIoniser = 14;
	public static final int guiIdIrradiator = 15;
	public static final int guiIdCooler = 16;
	public static final int guiIdFactory = 17;
	public static final int guiIdHeliumExtractor = 18;
	public static final int guiIdSynchrotron = 19;
	public static final int guiIdAssembler = 20;
	public static final int guiIdFissionReactorSteam = 21;
	public static final int guiIdFusionReactorSteam = 22;
	public static final int guiIdRecycler = 23;
	

	
	//Armor
	public static int toughHelmID;
	public static int toughChestID;
	public static int toughLegsID;
	public static int toughBootsID;
	
	public static int boronHelmID;
	public static int boronChestID;
	public static int boronLegsID;
	public static int boronBootsID;
	
	public static int bronzeHelmID;
	public static int bronzeChestID;
	public static int bronzeLegsID;
	public static int bronzeBootsID;
	
	public static int dUHelmID;
	public static int dUChestID;
	public static int dULegsID;
	public static int dUBootsID;
	
	public static Achievements achievements;
	
	public static Achievement nuclearFurnaceAchievement;
	public static Achievement dominosAchievement;
	public static Achievement fishAndRicecakeAchievement;
	public static Achievement heavyDutyWorkspaceAchievement;
	public static Achievement nukeAchievement;
	public static Achievement toolAchievement;
	public static Achievement reactionGeneratorAchievement;
	public static Achievement fissionControllerAchievement;
	public static Achievement RTGAchievement;
	public static Achievement fusionReactorAchievement;
	public static Achievement factoryAchievement;
	public static Achievement separatorAchievement;
	public static Achievement pistolAchievement;
	public static Achievement solarAchievement;
	public static Achievement oxidiserAchievement;
	public static Achievement synchrotronAchievement;
	public static Achievement antimatterBombAchievement;
	
	public static SimpleNetworkWrapper network;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		//config
		Config.loadConfig();
		
		// Recipes
		/*RecipeSorter.register("nuclearcraft:workspaceshaped", NuclearWorkspaceShapedOreRecipe.class, Category.SHAPED, "after:minecraft:shaped");
		RecipeSorter.register("nuclearcraft:workspaceshapeless", NuclearWorkspaceShapelessOreRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");*/

		// Fluid Registry
		NCFluids.preInitalize();
		NCBlocks.preInitalize();
		
			// Tile Entity
		GameRegistry.registerTileEntity(TileNuclearFurnace.class, "nuclearFurnaceNC");
		GameRegistry.registerTileEntity(TileFurnace.class, "furnaceNC");
		GameRegistry.registerTileEntity(TileCrusher.class, "crusherNC");
		GameRegistry.registerTileEntity(TileElectricCrusher.class, "electricCrusherNC");
		GameRegistry.registerTileEntity(TileElectricFurnace.class, "electricFurnaceNC");
		GameRegistry.registerTileEntity(TileReactionGenerator.class, "reactionGeneratorNC");
		GameRegistry.registerTileEntity(TileSeparator.class, "separatorNC");
		GameRegistry.registerTileEntity(TileHastener.class, "hastenerNC");
		GameRegistry.registerTileEntity(TileCollector.class, "collectorNC");
		GameRegistry.registerTileEntity(TileElectrolyser.class, "electrolyserNC");
		GameRegistry.registerTileEntity(TileFissionReactor.class, "fissionReactorGraphiteNC");
		GameRegistry.registerTileEntity(TileFissionReactorSteam.class, "fissionReactorSteamNC");
		GameRegistry.registerTileEntity(TileNuclearWorkspace.class, "nuclearWorkspaceNC");
		GameRegistry.registerTileEntity(TileFusionReactor.class, "fusionReactorNC");
		GameRegistry.registerTileEntity(TileFusionReactorSteam.class, "fusionReactorSteamNC");
		GameRegistry.registerTileEntity(TileTubing1.class, "TEtubing1NC");
		GameRegistry.registerTileEntity(TileTubing2.class, "TEtubing2NC");
		GameRegistry.registerTileEntity(TileRTG.class, "RTGNC");
		GameRegistry.registerTileEntity(TileAmRTG.class, "AmRTGNC");
		GameRegistry.registerTileEntity(TileCfRTG.class, "CfRTGNC");
		GameRegistry.registerTileEntity(TileWRTG.class, "WRTGNC");
		GameRegistry.registerTileEntity(TileSteamGenerator.class, "steamGeneratorNC");
		GameRegistry.registerTileEntity(TileSteamDecompressor.class, "steamDecompressorNC");
		GameRegistry.registerTileEntity(TileDenseSteamDecompressor.class, "denseSteamDecompressorNC");
		GameRegistry.registerTileEntity(TileFusionReactorBlock.class, "fusionReactorBlockNC");
		GameRegistry.registerTileEntity(TileFusionReactorBlockTop.class, "fusionReactorBlockTopNC");
		GameRegistry.registerTileEntity(TileFusionReactorSteamBlock.class, "fusionReactorSteamBlockNC");
		GameRegistry.registerTileEntity(TileFusionReactorSteamBlockTop.class, "fusionReactorSteamBlockTopNC");
		GameRegistry.registerTileEntity(TileOxidiser.class, "oxidiserNC");
		GameRegistry.registerTileEntity(TileIoniser.class, "ioniserNC");
		GameRegistry.registerTileEntity(TileIrradiator.class, "irradiatorNC");
		GameRegistry.registerTileEntity(TileCooler.class, "coolerNC");
		GameRegistry.registerTileEntity(TileAssembler.class, "assemblerNC");
		GameRegistry.registerTileEntity(TileFactory.class, "factoryNC");
		GameRegistry.registerTileEntity(TileHeliumExtractor.class, "heliumExtractorNC");
		GameRegistry.registerTileEntity(TileRecycler.class, "recyclerNC");
		GameRegistry.registerTileEntity(TileSolarPanel.class, "solarPanelNC");
		
		GameRegistry.registerTileEntity(TileElectromagnet.class, "electromagnetNC");
		GameRegistry.registerTileEntity(TileSuperElectromagnet.class, "superElectromagnetNC");
		GameRegistry.registerTileEntity(TileSupercooler.class, "supercoolerNC");
		GameRegistry.registerTileEntity(TileSynchrotron.class, "synchrotronNC");
		
		GameRegistry.registerTileEntity(TileLithiumIonBattery.class, "lithiumIonBatteryBlockNC");
		GameRegistry.registerTileEntity(TileVoltaicPile.class, "voltaicPileNC");
		
		GameRegistry.registerTileEntity(TileSimpleQuantum.class, "simpleQuantumNC");
	
		// Item Registry
		NCItems.preInitalize();
		
		// Proxy
		NCProxy.preInitalize();
		
		registerOreDict();
		//registerRecipe();
		
		// Packets
		PacketHandler.init();
		
		// Entities
		EntityHandler.registerMonsters(EntityNuclearMonster.class, "NuclearMonster");
		EntityHandler.registerPaul(EntityPaul.class, "Paul");
		EntityHandler.registerBrian(EntityBrian.class, "Brian");
		EntityHandler.registerNuke(EntityNukePrimed.class, "NukePrimed");
		EntityHandler.registerEMP(EntityEMPPrimed.class, "EMPPrimed");
		EntityHandler.registerAntimatterBomb(EntityAntimatterBombPrimed.class, "AntimatterBombPrimed");
		EntityHandler.registerNuclearGrenade(EntityNuclearGrenade.class, "NuclearGrenade");
		EntityHandler.registerEntityBullet(EntityBullet.class, "EntityBullet");
				
		// Fuel Handler	
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		// World Generation Registry
		GameRegistry.registerWorldGenerator(new OreGen(), 1);
		
	}
		
	@EventHandler
	public void init(FMLInitializationEvent event) {
		modCompat();
		NCProxy.initialize();
		NCFluids.initialize();
		NCBlocks.initialize();
		NCItems.initialize();
		// Seeds
		MinecraftForge.addGrassSeed(Config.extraDrops ? new ItemStack(Items.pumpkin_seeds) : new ItemStack(Items.wheat_seeds), 1);
			
		// Extra Block Drops
		MinecraftForge.EVENT_BUS.register(new BlockDropHandler());
		
		// Extra Mob Drops
		MinecraftForge.EVENT_BUS.register(new EntityDropHandler());
		
		// Anvil Recipes
		MinecraftForge.EVENT_BUS.register(new AnvilRepairHandler());
		
		// Achievements
		achievements = new Achievements("NuclearCraft");
		FMLCommonHandler.instance().bus().register(achievements);
		
		nuclearFurnaceAchievement = a("nuclearFurnace", 4, -2, NCBlocks.nuclearFurnaceIdle, null);
		dominosAchievement = a("dominos", -4, -2, NCItems.dominoes, null);
		fishAndRicecakeAchievement = a("fishAndRicecake", -6, -2, NCItems.fishAndRicecake, null);
		if (Config.workspace) heavyDutyWorkspaceAchievement = a("heavyDutyWorkspace", 0, 0, NCBlocks.nuclearWorkspace, null);
		nukeAchievement = a("nuke", -2, -2, NCBlocks.nukeE, Config.workspace ? heavyDutyWorkspaceAchievement : null);
		toolAchievement = a("tool", 2, -2, NCItems.dUPaxel, Config.workspace ? heavyDutyWorkspaceAchievement : null);
		reactionGeneratorAchievement = a("reactionGenerator", -2, 0, NCBlocks.reactionGeneratorIdle, Config.workspace ? heavyDutyWorkspaceAchievement : null);
		factoryAchievement = a("factory", 0, 2, NCBlocks.factoryIdle, Config.workspace ? heavyDutyWorkspaceAchievement : null);
		fissionControllerAchievement = a("fissionController", 2, 2, NCBlocks.fissionReactorGraphiteIdle, factoryAchievement);
		RTGAchievement = a("RTG", 2, 0, NCBlocks.RTG, fissionControllerAchievement);
		fusionReactorAchievement = a("fusionReactor", 4, 2, NCBlocks.fusionReactor, fissionControllerAchievement);
		separatorAchievement = a("separator", -2, 2, NCBlocks.separatorIdle, factoryAchievement);
		oxidiserAchievement = a("oxidiser", -4, 4, NCBlocks.oxidiserIdle, separatorAchievement);
		pistolAchievement = a("pistol", -4, 2, NCItems.pistol, separatorAchievement);
		solarAchievement = a("solar", 2, 4, NCBlocks.solarPanel, factoryAchievement);
		synchrotronAchievement = a("synchrotron", 4, 6, NCBlocks.synchrotronIdle, factoryAchievement);
		synchrotronAchievement = a("antimatterBomb", 4, 8, NCBlocks.antimatterBombE, synchrotronAchievement);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		NCProxy.postInitalize();
		NCFluids.postInitalize();
		NCBlocks.postInitalize();
		NCItems.postInitalize();
		registerRecipe();
		// Mod Recipes
		IC2Hook = new IC2Recipes();
		IC2Hook.hook();
		
		TEHook = new TERecipes();
		TEHook.hook();
	}
	

	private void modCompat() {
		// Inter Mod Comms - Mekanism
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 0), new ItemStack(NCItems.material, 2, 15));	//copperOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 1), new ItemStack(NCItems.material, 2, 16));	//tinOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 2), new ItemStack(NCItems.material, 2, 17));	//leadOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 3), new ItemStack(NCItems.material, 2, 18));	//silverOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 4), new ItemStack(NCItems.material, 2, 19));	//uraniumOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 5), new ItemStack(NCItems.material, 2, 20));	//thoriumOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 6), new ItemStack(NCItems.material, 2, 33));	//plutoniumOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 7), new ItemStack(NCItems.material, 2, 44));	//lithiumOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 8), new ItemStack(NCItems.material, 2, 45));	//boronOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCBlocks.blockOre, 1, 9), new ItemStack(NCItems.material, 2, 51));	//magnesiumOreEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCItems.parts, Config.workspace ? 4 : 8, 0), new ItemStack(NCItems.parts, 1, 3));	//basicPlatingEnrichment
		NCHelper.Mekanism.addEnrichmentRecipe(new ItemStack(NCItems.material, 1, 7), new ItemStack(NCItems.parts, 2, 0));	//ingotToPlatingEnrichment
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 4), new ItemStack(NCItems.material, 1, 19));	//uraniumIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 5), new ItemStack(NCItems.material, 1, 20));	//thoriumIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 53), new ItemStack(NCItems.material, 1, 54));	//uraniumIngotOxideCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 126), new ItemStack(NCItems.material, 1, 127));	//thoriumIngotOxideCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 6), new ItemStack(NCItems.material, 1, 21));	//bronzeIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 7), new ItemStack(NCItems.material, 1, 22));	//toughIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 42), new ItemStack(NCItems.material, 1, 44));	//lithiumIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 43), new ItemStack(NCItems.material, 1, 45));	//boronIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 50), new ItemStack(NCItems.material, 1, 51));	//magnesiumIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 71), new ItemStack(NCItems.material, 1, 72));	//mgbIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 73), new ItemStack(NCItems.material, 1, 74));	//rCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 76), new ItemStack(NCItems.material, 1, 77));	//graphiteIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 78), new ItemStack(NCItems.material, 1, 79));	//hardCarbonIngotCrushing
		NCHelper.Mekanism.addCrusherRecipe(new ItemStack(NCItems.material, 1, 80), new ItemStack(NCItems.material, 1, 81));	//LiMnO2IngotCrushing


		
		/*NBTTagCompound oxygenFilling = new NBTTagCompound();
		oxygenFilling.setTag("input", new ItemStack(NCItems.fuel, 1, 45).writeToNBT(new NBTTagCompound()));
		oxygenFilling.setTag("gasType", GasRegistry.getGas("oxygen").write(new NBTTagCompound()));
		oxygenFilling.setTag("output", new ItemStack(NCItems.fuel, 1, 35).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "ChemicalInjectionChamberRecipe", oxygenFilling);
		
		NBTTagCompound hydrogenFilling = new NBTTagCompound();
		hydrogenFilling.setTag("input", new ItemStack(NCItems.fuel, 1, 45).writeToNBT(new NBTTagCompound()));
		hydrogenFilling.setTag("gasType", GasRegistry.getGas("hydrogen").write(new NBTTagCompound()));
		hydrogenFilling.setTag("output", new ItemStack(NCItems.fuel, 1, 36).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "ChemicalInjectionChamberRecipe", hydrogenFilling);
		
		NBTTagCompound deuteriumFilling = new NBTTagCompound();
		deuteriumFilling.setTag("input", new ItemStack(NCItems.fuel, 1, 45).writeToNBT(new NBTTagCompound()));
		deuteriumFilling.setTag("gasType", GasRegistry.getGas("deuterium").write(new NBTTagCompound()));
		deuteriumFilling.setTag("output", new ItemStack(NCItems.fuel, 1, 37).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "ChemicalInjectionChamberRecipe", deuteriumFilling);
		
		NBTTagCompound tritiumFilling = new NBTTagCompound();
		tritiumFilling.setTag("input", new ItemStack(NCItems.fuel, 1, 45).writeToNBT(new NBTTagCompound()));
		tritiumFilling.setTag("gasType", GasRegistry.getGas("tritium").write(new NBTTagCompound()));
		tritiumFilling.setTag("output", new ItemStack(NCItems.fuel, 1, 38).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "ChemicalInjectionChamberRecipe", tritiumFilling);*/
		
		// Inter Mod Comms - AE2
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileNuclearFurnace.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFurnace.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileCrusher.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileElectricCrusher.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileElectricFurnace.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileReactionGenerator.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSeparator.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileHastener.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileCollector.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFissionReactor.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFissionReactorSteam.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileNuclearWorkspace.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactor.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactorSteam.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileTubing1.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileTubing2.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileRTG.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileAmRTG.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileCfRTG.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileWRTG.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSteamGenerator.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSteamDecompressor.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileDenseSteamDecompressor.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactorBlock.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactorBlockTop.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactorSteamBlock.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFusionReactorSteamBlockTop.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileElectrolyser.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileOxidiser.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileIoniser.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileIrradiator.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileCooler.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileFactory.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileAssembler.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileHeliumExtractor.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileRecycler.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSolarPanel.class.getCanonicalName());
		
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileElectromagnet.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSuperElectromagnet.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSupercooler.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSynchrotron.class.getCanonicalName());
		
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileLithiumIonBattery.class.getCanonicalName());
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileVoltaicPile.class.getCanonicalName());
		
		FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", TileSimpleQuantum.class.getCanonicalName());
	}
	
	private void registerOreDict() {
		// Ores Ore Dictionary
		OreDictionary.registerOre("oreUranium", new ItemStack(NCBlocks.blockOre, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(NCBlocks.blockOre, 1, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(NCBlocks.blockOre, 1, 1));
		OreDictionary.registerOre("oreLead", new ItemStack(NCBlocks.blockOre, 1, 2));
		OreDictionary.registerOre("oreSilver", new ItemStack(NCBlocks.blockOre, 1, 3));
		OreDictionary.registerOre("oreThorium", new ItemStack(NCBlocks.blockOre, 1, 5));
		OreDictionary.registerOre("orePlutonium", new ItemStack(NCBlocks.blockOre, 1, 6));
		OreDictionary.registerOre("oreLithium", new ItemStack(NCBlocks.blockOre, 1, 7));
		OreDictionary.registerOre("oreBoron", new ItemStack(NCBlocks.blockOre, 1, 8));
		OreDictionary.registerOre("oreMagnesium", new ItemStack(NCBlocks.blockOre, 1, 9));
		
		// Items Ore Dictionary
		OreDictionary.registerOre("ingotUranium", new ItemStack(NCItems.material, 1, 4));
		OreDictionary.registerOre("ingotCopper", new ItemStack(NCItems.material, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(NCItems.material, 1, 1));
		OreDictionary.registerOre("ingotLead", new ItemStack(NCItems.material, 1, 2));
		OreDictionary.registerOre("ingotSilver", new ItemStack(NCItems.material, 1, 3));
		OreDictionary.registerOre("ingotBronze", new ItemStack(NCItems.material, 1, 6));
		OreDictionary.registerOre("ingotThorium", new ItemStack(NCItems.material, 1, 5));
		OreDictionary.registerOre("ingotLithium", new ItemStack(NCItems.material, 1, 42));
		OreDictionary.registerOre("ingotBoron", new ItemStack(NCItems.material, 1, 43));
		OreDictionary.registerOre("ingotTough", new ItemStack(NCItems.material, 1, 7));
		OreDictionary.registerOre("ingotMagnesium", new ItemStack(NCItems.material, 1, 50));
		OreDictionary.registerOre("ingotUraniumOxide", new ItemStack(NCItems.material, 1, 53));
		OreDictionary.registerOre("ingotThoriumOxide", new ItemStack(NCItems.material, 1, 126));
		OreDictionary.registerOre("ingotMagnesiumDiboride", new ItemStack(NCItems.material, 1, 71));
		OreDictionary.registerOre("gemRhodochrosite", new ItemStack(NCItems.material, 1, 73));
		OreDictionary.registerOre("ingotGraphite", new ItemStack(NCItems.material, 1, 76));
		OreDictionary.registerOre("ingotHardCarbon", new ItemStack(NCItems.material, 1, 78));
		OreDictionary.registerOre("ingotLithiumManganeseDioxide", new ItemStack(NCItems.material, 1, 80));
		
		// Dusts Ore Dictionary
		OreDictionary.registerOre("dustIron", new ItemStack(NCItems.material, 1, 8));
		OreDictionary.registerOre("dustGold", new ItemStack(NCItems.material, 1, 9));
		OreDictionary.registerOre("dustLapis", new ItemStack(NCItems.material, 1, 10));
		OreDictionary.registerOre("dustDiamond", new ItemStack(NCItems.material, 1, 11));
		OreDictionary.registerOre("dustEmerald", new ItemStack(NCItems.material, 1, 12));
		OreDictionary.registerOre("dustQuartz", new ItemStack(NCItems.material, 1, 13));
		OreDictionary.registerOre("dustCoal", new ItemStack(NCItems.material, 1, 14));
		OreDictionary.registerOre("dustCopper", new ItemStack(NCItems.material, 1, 15));
		OreDictionary.registerOre("dustLead", new ItemStack(NCItems.material, 1, 17));
		OreDictionary.registerOre("dustTinyLead", new ItemStack(NCItems.material, 1, 23));
		OreDictionary.registerOre("dustTin", new ItemStack(NCItems.material, 1, 16));
		OreDictionary.registerOre("dustSilver", new ItemStack(NCItems.material, 1, 18));
		OreDictionary.registerOre("dustUranium", new ItemStack(NCItems.material, 1, 19));
		OreDictionary.registerOre("dustThorium", new ItemStack(NCItems.material, 1, 20));
		OreDictionary.registerOre("dustBronze", new ItemStack(NCItems.material, 1, 21));
		OreDictionary.registerOre("dustLithium", new ItemStack(NCItems.material, 1, 44));
		OreDictionary.registerOre("dustBoron", new ItemStack(NCItems.material, 1, 45));
		OreDictionary.registerOre("dustTough", new ItemStack(NCItems.material, 1, 22));
		OreDictionary.registerOre("dustMagnesium", new ItemStack(NCItems.material, 1, 51));
		OreDictionary.registerOre("dustObsidian", new ItemStack(NCItems.material, 1, 52));
		OreDictionary.registerOre("dustUraniumOxide", new ItemStack(NCItems.material, 1, 54));
		OreDictionary.registerOre("dustThoriumOxide", new ItemStack(NCItems.material, 1, 127));
		OreDictionary.registerOre("dustMagnesiumDiboride", new ItemStack(NCItems.material, 1, 72));
		OreDictionary.registerOre("dustManganeseOxide", new ItemStack(NCItems.material, 1, 74));
		OreDictionary.registerOre("dustManganeseDioxide", new ItemStack(NCItems.material, 1, 75));
		OreDictionary.registerOre("dustGraphite", new ItemStack(NCItems.material, 1, 77));
		OreDictionary.registerOre("dustHardCarbon", new ItemStack(NCItems.material, 1, 79));
		OreDictionary.registerOre("dustLithiumManganeseDioxide", new ItemStack(NCItems.material, 1, 81));
		
		// Blocks Ore Dictionary
		OreDictionary.registerOre("blockUranium", new ItemStack(NCBlocks.blockBlock, 1, 4));
		OreDictionary.registerOre("blockCopper", new ItemStack(NCBlocks.blockBlock, 1, 0));
		OreDictionary.registerOre("blockTin", new ItemStack(NCBlocks.blockBlock, 1, 1));
		OreDictionary.registerOre("blockLead", new ItemStack(NCBlocks.blockBlock, 1, 2));
		OreDictionary.registerOre("blockSilver", new ItemStack(NCBlocks.blockBlock, 1, 3));
		OreDictionary.registerOre("blockBronze", new ItemStack(NCBlocks.blockBlock, 1, 6));
		OreDictionary.registerOre("blockThorium", new ItemStack(NCBlocks.blockBlock, 1, 5));
		OreDictionary.registerOre("blockTough", new ItemStack(NCBlocks.blockBlock, 1, 7));
		OreDictionary.registerOre("blockLithium", new ItemStack(NCBlocks.blockBlock, 1, 8));
		OreDictionary.registerOre("blockBoron", new ItemStack(NCBlocks.blockBlock, 1, 9));
		OreDictionary.registerOre("blockMagnesium", new ItemStack(NCBlocks.blockBlock, 1, 10));
		OreDictionary.registerOre("blockGraphite", new ItemStack(NCBlocks.graphiteBlock));
		
		// Parts Ore Dictionary
		OreDictionary.registerOre("plateBasic", new ItemStack(NCItems.parts, 1, 0));
		OreDictionary.registerOre("plateIron", new ItemStack(NCItems.parts, 1, 1));
		OreDictionary.registerOre("plateReinforced", new ItemStack(NCItems.parts, 1, 3));
		OreDictionary.registerOre("universalReactant", new ItemStack(NCItems.parts, 1, 4));
		OreDictionary.registerOre("plateTin", new ItemStack(NCItems.parts, 1, 6));
		OreDictionary.registerOre("plateDU", new ItemStack(NCItems.parts, 1, 8));
		OreDictionary.registerOre("plateAdvanced", new ItemStack(NCItems.parts, 1, 9));
		OreDictionary.registerOre("plateLead", new ItemStack(NCItems.parts, 1, 14));
		
		// Fission Fuel Materials Ore Dictionary
		OreDictionary.registerOre("U238", new ItemStack(NCItems.material, 1, 24));
		OreDictionary.registerOre("U238Base", new ItemStack(NCItems.material, 1, 24));
		OreDictionary.registerOre("U238", new ItemStack(NCItems.material, 1, 55));
		OreDictionary.registerOre("U238Oxide", new ItemStack(NCItems.material, 1, 55));
		OreDictionary.registerOre("tinyU238", new ItemStack(NCItems.material, 1, 25));
		OreDictionary.registerOre("tinyU238Base", new ItemStack(NCItems.material, 1, 25));
		OreDictionary.registerOre("tinyU238", new ItemStack(NCItems.material, 1, 56));
		OreDictionary.registerOre("tinyU238Oxide", new ItemStack(NCItems.material, 1, 56));
		
		OreDictionary.registerOre("U235", new ItemStack(NCItems.material, 1, 26));
		OreDictionary.registerOre("U235Base", new ItemStack(NCItems.material, 1, 26));
		OreDictionary.registerOre("U235", new ItemStack(NCItems.material, 1, 57));
		OreDictionary.registerOre("U235Oxide", new ItemStack(NCItems.material, 1, 57));
		OreDictionary.registerOre("tinyU235", new ItemStack(NCItems.material, 1, 27));
		OreDictionary.registerOre("tinyU235Base", new ItemStack(NCItems.material, 1, 27));
		OreDictionary.registerOre("tinyU235", new ItemStack(NCItems.material, 1, 58));
		OreDictionary.registerOre("tinyU235Oxide", new ItemStack(NCItems.material, 1, 58));
		
		OreDictionary.registerOre("U233", new ItemStack(NCItems.material, 1, 28));
		OreDictionary.registerOre("U233Base", new ItemStack(NCItems.material, 1, 28));
		OreDictionary.registerOre("U233", new ItemStack(NCItems.material, 1, 59));
		OreDictionary.registerOre("U233Oxide", new ItemStack(NCItems.material, 1, 59));
		OreDictionary.registerOre("tinyU233", new ItemStack(NCItems.material, 1, 29));
		OreDictionary.registerOre("tinyU233Base", new ItemStack(NCItems.material, 1, 29));
		OreDictionary.registerOre("tinyU233", new ItemStack(NCItems.material, 1, 60));
		OreDictionary.registerOre("tinyU233Oxide", new ItemStack(NCItems.material, 1, 60));
		
		OreDictionary.registerOre("Pu238", new ItemStack(NCItems.material, 1, 30));
		OreDictionary.registerOre("Pu238Base", new ItemStack(NCItems.material, 1, 30));
		OreDictionary.registerOre("Pu238", new ItemStack(NCItems.material, 1, 61));
		OreDictionary.registerOre("Pu238Oxide", new ItemStack(NCItems.material, 1, 61));
		OreDictionary.registerOre("tinyPu238", new ItemStack(NCItems.material, 1, 31));
		OreDictionary.registerOre("tinyPu238Base", new ItemStack(NCItems.material, 1, 31));
		OreDictionary.registerOre("tinyPu238", new ItemStack(NCItems.material, 1, 62));
		OreDictionary.registerOre("tinyPu238Oxide", new ItemStack(NCItems.material, 1, 62));
		
		OreDictionary.registerOre("Pu239", new ItemStack(NCItems.material, 1, 32));
		OreDictionary.registerOre("Pu239Base", new ItemStack(NCItems.material, 1, 32));
		OreDictionary.registerOre("Pu239", new ItemStack(NCItems.material, 1, 63));
		OreDictionary.registerOre("Pu239Oxide", new ItemStack(NCItems.material, 1, 63));
		OreDictionary.registerOre("tinyPu239", new ItemStack(NCItems.material, 1, 33));
		OreDictionary.registerOre("tinyPu239Base", new ItemStack(NCItems.material, 1, 33));
		OreDictionary.registerOre("tinyPu239", new ItemStack(NCItems.material, 1, 64));
		OreDictionary.registerOre("tinyPu239Oxide", new ItemStack(NCItems.material, 1, 64));
		
		OreDictionary.registerOre("Pu242", new ItemStack(NCItems.material, 1, 34));
		OreDictionary.registerOre("Pu242Base", new ItemStack(NCItems.material, 1, 34));
		OreDictionary.registerOre("Pu242", new ItemStack(NCItems.material, 1, 65));
		OreDictionary.registerOre("Pu242Oxide", new ItemStack(NCItems.material, 1, 65));
		OreDictionary.registerOre("tinyPu242", new ItemStack(NCItems.material, 1, 35));
		OreDictionary.registerOre("tinyPu242Base", new ItemStack(NCItems.material, 1, 35));
		OreDictionary.registerOre("tinyPu242", new ItemStack(NCItems.material, 1, 66));
		OreDictionary.registerOre("tinyPu242Oxide", new ItemStack(NCItems.material, 1, 66));
		
		OreDictionary.registerOre("Pu241", new ItemStack(NCItems.material, 1, 36));
		OreDictionary.registerOre("Pu241Base", new ItemStack(NCItems.material, 1, 36));
		OreDictionary.registerOre("Pu241", new ItemStack(NCItems.material, 1, 67));
		OreDictionary.registerOre("Pu241Oxide", new ItemStack(NCItems.material, 1, 67));
		OreDictionary.registerOre("tinyPu241", new ItemStack(NCItems.material, 1, 37));
		OreDictionary.registerOre("tinyPu241Base", new ItemStack(NCItems.material, 1, 37));
		OreDictionary.registerOre("tinyPu241", new ItemStack(NCItems.material, 1, 68));
		OreDictionary.registerOre("tinyPu241Oxide", new ItemStack(NCItems.material, 1, 68));
		
		OreDictionary.registerOre("Th232", new ItemStack(NCItems.material, 1, 38));
		OreDictionary.registerOre("Th232Base", new ItemStack(NCItems.material, 1, 38));
		OreDictionary.registerOre("Th232", new ItemStack(NCItems.material, 1, 82));
		OreDictionary.registerOre("Th232Oxide", new ItemStack(NCItems.material, 1, 82));
		OreDictionary.registerOre("tinyTh232", new ItemStack(NCItems.material, 1, 39));
		OreDictionary.registerOre("tinyTh232Base", new ItemStack(NCItems.material, 1, 39));
		OreDictionary.registerOre("tinyTh232", new ItemStack(NCItems.material, 1, 83));
		OreDictionary.registerOre("tinyTh232Oxide", new ItemStack(NCItems.material, 1, 83));
		
		OreDictionary.registerOre("Th230", new ItemStack(NCItems.material, 1, 40));
		OreDictionary.registerOre("Th230Base", new ItemStack(NCItems.material, 1, 40));
		OreDictionary.registerOre("Th230", new ItemStack(NCItems.material, 1, 84));
		OreDictionary.registerOre("Th230Oxide", new ItemStack(NCItems.material, 1, 84));
		OreDictionary.registerOre("tinyTh230", new ItemStack(NCItems.material, 1, 41));
		OreDictionary.registerOre("tinyTh230Base", new ItemStack(NCItems.material, 1, 41));
		OreDictionary.registerOre("tinyTh230", new ItemStack(NCItems.material, 1, 85));
		OreDictionary.registerOre("tinyTh230Oxide", new ItemStack(NCItems.material, 1, 85));
		
		OreDictionary.registerOre("Np236", new ItemStack(NCItems.material, 1, 86));
		OreDictionary.registerOre("Np236Base", new ItemStack(NCItems.material, 1, 86));
		OreDictionary.registerOre("Np236", new ItemStack(NCItems.material, 1, 104));
		OreDictionary.registerOre("Np236Oxide", new ItemStack(NCItems.material, 1, 104));
		OreDictionary.registerOre("tinyNp236", new ItemStack(NCItems.material, 1, 87));
		OreDictionary.registerOre("tinyNp236Base", new ItemStack(NCItems.material, 1, 87));
		OreDictionary.registerOre("tinyNp236", new ItemStack(NCItems.material, 1, 105));
		OreDictionary.registerOre("tinyNp236Oxide", new ItemStack(NCItems.material, 1, 105));
		
		OreDictionary.registerOre("Np237", new ItemStack(NCItems.material, 1, 88));
		OreDictionary.registerOre("Np237Base", new ItemStack(NCItems.material, 1, 88));
		OreDictionary.registerOre("Np237", new ItemStack(NCItems.material, 1, 106));
		OreDictionary.registerOre("Np237Oxide", new ItemStack(NCItems.material, 1, 106));
		OreDictionary.registerOre("tinyNp237", new ItemStack(NCItems.material, 1, 89));
		OreDictionary.registerOre("tinyNp237Base", new ItemStack(NCItems.material, 1, 89));
		OreDictionary.registerOre("tinyNp237", new ItemStack(NCItems.material, 1, 107));
		OreDictionary.registerOre("tinyNp237Oxide", new ItemStack(NCItems.material, 1, 107));
		
		OreDictionary.registerOre("Am241", new ItemStack(NCItems.material, 1, 90));
		OreDictionary.registerOre("Am241Base", new ItemStack(NCItems.material, 1, 90));
		OreDictionary.registerOre("Am241", new ItemStack(NCItems.material, 1, 108));
		OreDictionary.registerOre("Am241Oxide", new ItemStack(NCItems.material, 1, 108));
		OreDictionary.registerOre("tinyAm241", new ItemStack(NCItems.material, 1, 91));
		OreDictionary.registerOre("tinyAm241Base", new ItemStack(NCItems.material, 1, 91));
		OreDictionary.registerOre("tinyAm241", new ItemStack(NCItems.material, 1, 109));
		OreDictionary.registerOre("tinyAm241Oxide", new ItemStack(NCItems.material, 1, 109));
		
		OreDictionary.registerOre("Am242", new ItemStack(NCItems.material, 1, 92));
		OreDictionary.registerOre("Am242Base", new ItemStack(NCItems.material, 1, 92));
		OreDictionary.registerOre("Am242", new ItemStack(NCItems.material, 1, 110));
		OreDictionary.registerOre("Am242Oxide", new ItemStack(NCItems.material, 1, 110));
		OreDictionary.registerOre("tinyAm242", new ItemStack(NCItems.material, 1, 93));
		OreDictionary.registerOre("tinyAm242Base", new ItemStack(NCItems.material, 1, 93));
		OreDictionary.registerOre("tinyAm242", new ItemStack(NCItems.material, 1, 111));
		OreDictionary.registerOre("tinyAm242Oxide", new ItemStack(NCItems.material, 1, 111));
		
		OreDictionary.registerOre("Am243", new ItemStack(NCItems.material, 1, 94));
		OreDictionary.registerOre("Am243Base", new ItemStack(NCItems.material, 1, 94));
		OreDictionary.registerOre("Am243", new ItemStack(NCItems.material, 1, 112));
		OreDictionary.registerOre("Am243Oxide", new ItemStack(NCItems.material, 1, 112));
		OreDictionary.registerOre("tinyAm243", new ItemStack(NCItems.material, 1, 95));
		OreDictionary.registerOre("tinyAm243Base", new ItemStack(NCItems.material, 1, 95));
		OreDictionary.registerOre("tinyAm243", new ItemStack(NCItems.material, 1, 113));
		OreDictionary.registerOre("tinyAm243Oxide", new ItemStack(NCItems.material, 1, 113));
		
		OreDictionary.registerOre("Cm243", new ItemStack(NCItems.material, 1, 96));
		OreDictionary.registerOre("Cm243Base", new ItemStack(NCItems.material, 1, 96));
		OreDictionary.registerOre("Cm243", new ItemStack(NCItems.material, 1, 114));
		OreDictionary.registerOre("Cm243Oxide", new ItemStack(NCItems.material, 1, 114));
		OreDictionary.registerOre("tinyCm243", new ItemStack(NCItems.material, 1, 97));
		OreDictionary.registerOre("tinyCm243Base", new ItemStack(NCItems.material, 1, 97));
		OreDictionary.registerOre("tinyCm243", new ItemStack(NCItems.material, 1, 115));
		OreDictionary.registerOre("tinyCm243Oxide", new ItemStack(NCItems.material, 1, 115));
		
		OreDictionary.registerOre("Cm245", new ItemStack(NCItems.material, 1, 98));
		OreDictionary.registerOre("Cm245Base", new ItemStack(NCItems.material, 1, 98));
		OreDictionary.registerOre("Cm245", new ItemStack(NCItems.material, 1, 116));
		OreDictionary.registerOre("Cm245Oxide", new ItemStack(NCItems.material, 1, 116));
		OreDictionary.registerOre("tinyCm245", new ItemStack(NCItems.material, 1, 99));
		OreDictionary.registerOre("tinyCm245Base", new ItemStack(NCItems.material, 1, 99));
		OreDictionary.registerOre("tinyCm245", new ItemStack(NCItems.material, 1, 117));
		OreDictionary.registerOre("tinyCm245Oxide", new ItemStack(NCItems.material, 1, 117));
		
		OreDictionary.registerOre("Cm246", new ItemStack(NCItems.material, 1, 100));
		OreDictionary.registerOre("Cm246Base", new ItemStack(NCItems.material, 1, 100));
		OreDictionary.registerOre("Cm246", new ItemStack(NCItems.material, 1, 118));
		OreDictionary.registerOre("Cm246Oxide", new ItemStack(NCItems.material, 1, 118));
		OreDictionary.registerOre("tinyCm246", new ItemStack(NCItems.material, 1, 101));
		OreDictionary.registerOre("tinyCm246Base", new ItemStack(NCItems.material, 1, 101));
		OreDictionary.registerOre("tinyCm246", new ItemStack(NCItems.material, 1, 119));
		OreDictionary.registerOre("tinyCm246Oxide", new ItemStack(NCItems.material, 1, 119));
		
		OreDictionary.registerOre("Cm247", new ItemStack(NCItems.material, 1, 102));
		OreDictionary.registerOre("Cm247Base", new ItemStack(NCItems.material, 1, 102));
		OreDictionary.registerOre("Cm247", new ItemStack(NCItems.material, 1, 120));
		OreDictionary.registerOre("Cm247Oxide", new ItemStack(NCItems.material, 1, 120));
		OreDictionary.registerOre("tinyCm247", new ItemStack(NCItems.material, 1, 103));
		OreDictionary.registerOre("tinyCm247Base", new ItemStack(NCItems.material, 1, 103));
		OreDictionary.registerOre("tinyCm247", new ItemStack(NCItems.material, 1, 121));
		OreDictionary.registerOre("tinyCm247Oxide", new ItemStack(NCItems.material, 1, 121));
		
		OreDictionary.registerOre("Cf250", new ItemStack(NCItems.material, 1, 122));
		OreDictionary.registerOre("Cf250Base", new ItemStack(NCItems.material, 1, 122));
		OreDictionary.registerOre("Cf250", new ItemStack(NCItems.material, 1, 124));
		OreDictionary.registerOre("Cf250Oxide", new ItemStack(NCItems.material, 1, 124));
		OreDictionary.registerOre("tinyCf250", new ItemStack(NCItems.material, 1, 123));
		OreDictionary.registerOre("tinyCf250Base", new ItemStack(NCItems.material, 1, 123));
		OreDictionary.registerOre("tinyCf250", new ItemStack(NCItems.material, 1, 125));
		OreDictionary.registerOre("tinyCf250Oxide", new ItemStack(NCItems.material, 1, 125));
		
		// Lithium and Boron Isotopes
		OreDictionary.registerOre("Li6", new ItemStack(NCItems.material, 1, 46));
		OreDictionary.registerOre("tinyLi6", new ItemStack(NCItems.material, 1, 69));
		OreDictionary.registerOre("Li7", new ItemStack(NCItems.material, 1, 47));
		OreDictionary.registerOre("B10", new ItemStack(NCItems.material, 1, 48));
		OreDictionary.registerOre("tinyB10", new ItemStack(NCItems.material, 1, 70));
		OreDictionary.registerOre("B11", new ItemStack(NCItems.material, 1, 49));
		
		// Fission Fuels Ore Dictionary
		OreDictionary.registerOre("LEU235", new ItemStack(NCItems.fuel, 1, 0));
		OreDictionary.registerOre("LEU235Oxide", new ItemStack(NCItems.fuel, 1, 51));
		OreDictionary.registerOre("LEU235Cell", new ItemStack(NCItems.fuel, 1, 11));
		OreDictionary.registerOre("LEU235CellOxide", new ItemStack(NCItems.fuel, 1, 59));
		OreDictionary.registerOre("dLEU235Cell", new ItemStack(NCItems.fuel, 1, 22));
		OreDictionary.registerOre("dLEU235CellOxide", new ItemStack(NCItems.fuel, 1, 67));
		
		OreDictionary.registerOre("HEU235", new ItemStack(NCItems.fuel, 1, 1));
		OreDictionary.registerOre("HEU235Oxide", new ItemStack(NCItems.fuel, 1, 52));
		OreDictionary.registerOre("HEU235Cell", new ItemStack(NCItems.fuel, 1, 12));
		OreDictionary.registerOre("HEU235CellOxide", new ItemStack(NCItems.fuel, 1, 60));
		OreDictionary.registerOre("dHEU235Cell", new ItemStack(NCItems.fuel, 1, 23));
		OreDictionary.registerOre("dHEU235CellOxide", new ItemStack(NCItems.fuel, 1, 68));
		
		OreDictionary.registerOre("LEP239", new ItemStack(NCItems.fuel, 1, 2));
		OreDictionary.registerOre("LEP239Oxide", new ItemStack(NCItems.fuel, 1, 53));
		OreDictionary.registerOre("LEP239Cell", new ItemStack(NCItems.fuel, 1, 13));
		OreDictionary.registerOre("LEP239CellOxide", new ItemStack(NCItems.fuel, 1, 61));
		OreDictionary.registerOre("dLEP239Cell", new ItemStack(NCItems.fuel, 1, 24));
		OreDictionary.registerOre("dLEP239CellOxide", new ItemStack(NCItems.fuel, 1, 69));
		
		OreDictionary.registerOre("HEP239", new ItemStack(NCItems.fuel, 1, 3));
		OreDictionary.registerOre("HEP239Oxide", new ItemStack(NCItems.fuel, 1, 54));
		OreDictionary.registerOre("HEP239Cell", new ItemStack(NCItems.fuel, 1, 14));
		OreDictionary.registerOre("HEP239CellOxide", new ItemStack(NCItems.fuel, 1, 62));
		OreDictionary.registerOre("dHEP239Cell", new ItemStack(NCItems.fuel, 1, 25));
		OreDictionary.registerOre("dHEP239CellOxide", new ItemStack(NCItems.fuel, 1, 70));
		
		OreDictionary.registerOre("MOX239", new ItemStack(NCItems.fuel, 1, 4));
		OreDictionary.registerOre("MOX239Cell", new ItemStack(NCItems.fuel, 1, 15));
		OreDictionary.registerOre("dMOX239Cell", new ItemStack(NCItems.fuel, 1, 26));
		
		OreDictionary.registerOre("TBU", new ItemStack(NCItems.fuel, 1, 5));
		OreDictionary.registerOre("TBUOxide", new ItemStack(NCItems.fuel, 1, 76));
		OreDictionary.registerOre("TBUCell", new ItemStack(NCItems.fuel, 1, 16));
		OreDictionary.registerOre("TBUCellOxide", new ItemStack(NCItems.fuel, 1, 77));
		OreDictionary.registerOre("dTBUCell", new ItemStack(NCItems.fuel, 1, 27));
		OreDictionary.registerOre("dTBUCellOxide", new ItemStack(NCItems.fuel, 1, 78));
		
		OreDictionary.registerOre("LEU233", new ItemStack(NCItems.fuel, 1, 6));
		OreDictionary.registerOre("LEU233Oxide", new ItemStack(NCItems.fuel, 1, 55));
		OreDictionary.registerOre("LEU233Cell", new ItemStack(NCItems.fuel, 1, 17));
		OreDictionary.registerOre("LEU233CellOxide", new ItemStack(NCItems.fuel, 1, 63));
		OreDictionary.registerOre("dLEU233Cell", new ItemStack(NCItems.fuel, 1, 28));
		OreDictionary.registerOre("dLEU233CellOxide", new ItemStack(NCItems.fuel, 1, 71));
		
		OreDictionary.registerOre("HEU233", new ItemStack(NCItems.fuel, 1, 7));
		OreDictionary.registerOre("HEU233Oxide", new ItemStack(NCItems.fuel, 1, 56));
		OreDictionary.registerOre("HEU233Cell", new ItemStack(NCItems.fuel, 1, 18));
		OreDictionary.registerOre("HEU233CellOxide", new ItemStack(NCItems.fuel, 1, 64));
		OreDictionary.registerOre("dHEU233Cell", new ItemStack(NCItems.fuel, 1, 29));
		OreDictionary.registerOre("dHEU233CellOxide", new ItemStack(NCItems.fuel, 1, 72));
		
		OreDictionary.registerOre("LEP241", new ItemStack(NCItems.fuel, 1, 8));
		OreDictionary.registerOre("LEP241Oxide", new ItemStack(NCItems.fuel, 1, 57));
		OreDictionary.registerOre("LEP241Cell", new ItemStack(NCItems.fuel, 1, 19));
		OreDictionary.registerOre("LEP241CellOxide", new ItemStack(NCItems.fuel, 1, 65));
		OreDictionary.registerOre("dLEP241Cell", new ItemStack(NCItems.fuel, 1, 30));
		OreDictionary.registerOre("dLEP241CellOxide", new ItemStack(NCItems.fuel, 1, 73));
		
		OreDictionary.registerOre("HEP241", new ItemStack(NCItems.fuel, 1, 9));
		OreDictionary.registerOre("HEP241Oxide", new ItemStack(NCItems.fuel, 1, 58));
		OreDictionary.registerOre("HEP241Cell", new ItemStack(NCItems.fuel, 1, 20));
		OreDictionary.registerOre("HEP241CellOxide", new ItemStack(NCItems.fuel, 1, 66));
		OreDictionary.registerOre("dHEP241Cell", new ItemStack(NCItems.fuel, 1, 31));
		OreDictionary.registerOre("dHEP241CellOxide", new ItemStack(NCItems.fuel, 1, 74));
		
		OreDictionary.registerOre("MOX241", new ItemStack(NCItems.fuel, 1, 10));
		OreDictionary.registerOre("MOX241Cell", new ItemStack(NCItems.fuel, 1, 21));
		OreDictionary.registerOre("dMOX241Cell", new ItemStack(NCItems.fuel, 1, 32));
		
		OreDictionary.registerOre("LEN236", new ItemStack(NCItems.fuel, 1, 79));
		OreDictionary.registerOre("LEN236Oxide", new ItemStack(NCItems.fuel, 1, 89));
		OreDictionary.registerOre("LEN236Cell", new ItemStack(NCItems.fuel, 1, 99));
		OreDictionary.registerOre("LEN236CellOxide", new ItemStack(NCItems.fuel, 1, 109));
		OreDictionary.registerOre("dLEN236Cell", new ItemStack(NCItems.fuel, 1, 119));
		OreDictionary.registerOre("dLEN236CellOxide", new ItemStack(NCItems.fuel, 1, 129));
		
		OreDictionary.registerOre("HEN236", new ItemStack(NCItems.fuel, 1, 80));
		OreDictionary.registerOre("HEN236Oxide", new ItemStack(NCItems.fuel, 1, 90));
		OreDictionary.registerOre("HEN236Cell", new ItemStack(NCItems.fuel, 1, 100));
		OreDictionary.registerOre("HEN236CellOxide", new ItemStack(NCItems.fuel, 1, 110));
		OreDictionary.registerOre("dHEN236Cell", new ItemStack(NCItems.fuel, 1, 120));
		OreDictionary.registerOre("dHEN236CellOxide", new ItemStack(NCItems.fuel, 1, 130));
		
		OreDictionary.registerOre("LEA242", new ItemStack(NCItems.fuel, 1, 81));
		OreDictionary.registerOre("LEA242Oxide", new ItemStack(NCItems.fuel, 1, 91));
		OreDictionary.registerOre("LEA242Cell", new ItemStack(NCItems.fuel, 1, 101));
		OreDictionary.registerOre("LEA242CellOxide", new ItemStack(NCItems.fuel, 1, 111));
		OreDictionary.registerOre("dLEA242Cell", new ItemStack(NCItems.fuel, 1, 121));
		OreDictionary.registerOre("dLEA242CellOxide", new ItemStack(NCItems.fuel, 1, 131));
		
		OreDictionary.registerOre("HEA242", new ItemStack(NCItems.fuel, 1, 82));
		OreDictionary.registerOre("HEA242Oxide", new ItemStack(NCItems.fuel, 1, 92));
		OreDictionary.registerOre("HEA242Cell", new ItemStack(NCItems.fuel, 1, 102));
		OreDictionary.registerOre("HEA242CellOxide", new ItemStack(NCItems.fuel, 1, 112));
		OreDictionary.registerOre("dHEA242Cell", new ItemStack(NCItems.fuel, 1, 122));
		OreDictionary.registerOre("dHEA242CellOxide", new ItemStack(NCItems.fuel, 1, 132));
		
		OreDictionary.registerOre("LEC243", new ItemStack(NCItems.fuel, 1, 83));
		OreDictionary.registerOre("LEC243Oxide", new ItemStack(NCItems.fuel, 1, 93));
		OreDictionary.registerOre("LEC243Cell", new ItemStack(NCItems.fuel, 1, 103));
		OreDictionary.registerOre("LEC243CellOxide", new ItemStack(NCItems.fuel, 1, 113));
		OreDictionary.registerOre("dLEC243Cell", new ItemStack(NCItems.fuel, 1, 123));
		OreDictionary.registerOre("dLEC243CellOxide", new ItemStack(NCItems.fuel, 1, 133));
		
		OreDictionary.registerOre("HEC243", new ItemStack(NCItems.fuel, 1, 84));
		OreDictionary.registerOre("HEC243Oxide", new ItemStack(NCItems.fuel, 1, 94));
		OreDictionary.registerOre("HEC243Cell", new ItemStack(NCItems.fuel, 1, 104));
		OreDictionary.registerOre("HEC243CellOxide", new ItemStack(NCItems.fuel, 1, 114));
		OreDictionary.registerOre("dHEC243Cell", new ItemStack(NCItems.fuel, 1, 124));
		OreDictionary.registerOre("dHEC243CellOxide", new ItemStack(NCItems.fuel, 1, 134));
		
		OreDictionary.registerOre("LEC245", new ItemStack(NCItems.fuel, 1, 85));
		OreDictionary.registerOre("LEC245Oxide", new ItemStack(NCItems.fuel, 1, 95));
		OreDictionary.registerOre("LEC245Cell", new ItemStack(NCItems.fuel, 1, 105));
		OreDictionary.registerOre("LEC245CellOxide", new ItemStack(NCItems.fuel, 1, 115));
		OreDictionary.registerOre("dLEC245Cell", new ItemStack(NCItems.fuel, 1, 125));
		OreDictionary.registerOre("dLEC245CellOxide", new ItemStack(NCItems.fuel, 1, 135));
		
		OreDictionary.registerOre("HEC245", new ItemStack(NCItems.fuel, 1, 86));
		OreDictionary.registerOre("HEC245Oxide", new ItemStack(NCItems.fuel, 1, 96));
		OreDictionary.registerOre("HEC245Cell", new ItemStack(NCItems.fuel, 1, 106));
		OreDictionary.registerOre("HEC245CellOxide", new ItemStack(NCItems.fuel, 1, 116));
		OreDictionary.registerOre("dHEC245Cell", new ItemStack(NCItems.fuel, 1, 126));
		OreDictionary.registerOre("dHEC245CellOxide", new ItemStack(NCItems.fuel, 1, 136));
		
		OreDictionary.registerOre("LEC247", new ItemStack(NCItems.fuel, 1, 87));
		OreDictionary.registerOre("LEC247Oxide", new ItemStack(NCItems.fuel, 1, 97));
		OreDictionary.registerOre("LEC247Cell", new ItemStack(NCItems.fuel, 1, 107));
		OreDictionary.registerOre("LEC247CellOxide", new ItemStack(NCItems.fuel, 1, 117));
		OreDictionary.registerOre("dLEC247Cell", new ItemStack(NCItems.fuel, 1, 127));
		OreDictionary.registerOre("dLEC247CellOxide", new ItemStack(NCItems.fuel, 1, 137));
		
		OreDictionary.registerOre("HEC247", new ItemStack(NCItems.fuel, 1, 88));
		OreDictionary.registerOre("HEC247Oxide", new ItemStack(NCItems.fuel, 1, 98));
		OreDictionary.registerOre("HEC247Cell", new ItemStack(NCItems.fuel, 1, 108));
		OreDictionary.registerOre("HEC247CellOxide", new ItemStack(NCItems.fuel, 1, 118));
		OreDictionary.registerOre("dHEC247Cell", new ItemStack(NCItems.fuel, 1, 128));
		OreDictionary.registerOre("dHEC247CellOxide", new ItemStack(NCItems.fuel, 1, 138));
		
		// Vanilla Ore Dictionary
		OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1));
		OreDictionary.registerOre("oreObsidian", new ItemStack(Blocks.obsidian, 1));
		
		// Filled Fluid Cell Dictionary
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 34));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 35));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 36));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 37));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 38));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 39));
		OreDictionary.registerOre("filledNCGasCell", new ItemStack(NCItems.fuel, 1, 40));
		
		// Record Ore Dictionary
		OreDictionary.registerOre("record", new ItemStack(NCItems.recordPractice, 1));
		OreDictionary.registerOre("record", new ItemStack(NCItems.recordArea51, 1));
		OreDictionary.registerOre("record", new ItemStack(NCItems.recordNeighborhood, 1));
	}
		
	private void registerRecipe() {
		// Block Crafting Recipes
		b(0, "ingotCopper");
		b(1, "ingotTin");
		b(2, "ingotLead");
		b(3, "ingotSilver");
		b(4, "ingotUranium");
		b(5, "ingotThorium");
		b(6, "ingotBronze");
		b(8, "ingotLithium");
		b(9, "ingotBoron");
		b(10, "ingotMagnesium");
		b(NCBlocks.graphiteBlock, "ingotGraphite");
		
		// Tiny Dust to Full Dust
		m(17, "dustTinyLead");
		
		// Isotope Lump Recipes
		m(24, "tinyU238Base");
		m(26, "tinyU235Base");
		m(28, "tinyU233Base");
		m(30, "tinyPu238Base");
		m(32, "tinyPu239Base");
		m(34, "tinyPu242Base");
		m(36, "tinyPu241Base");
		m(38, "tinyTh232Base");
		m(40, "tinyTh230Base");
		
		m(55, "tinyU238Oxide");
		m(57, "tinyU235Oxide");
		m(59, "tinyU233Oxide");
		m(61, "tinyPu238Oxide");
		m(63, "tinyPu239Oxide");
		m(65, "tinyPu242Oxide");
		m(67, "tinyPu241Oxide");
		m(82, "tinyTh232Oxide");
		m(84, "tinyTh230Oxide");
		
		m(46, "tinyLi6");
		m(48, "tinyB10");
		
		m(86, "tinyNp236Base");
		m(88, "tinyNp237Base");
		m(90, "tinyAm241Base");
		m(92, "tinyAm242Base");
		m(94, "tinyAm243Base");
		m(96, "tinyCm243Base");
		m(98, "tinyCm245Base");
		m(100, "tinyCm246Base");
		m(102, "tinyCm247Base");
		m(122, "tinyCf250Base");
		
		m(104, "tinyNp236Oxide");
		m(106, "tinyNp237Oxide");
		m(108, "tinyAm241Oxide");
		m(110, "tinyAm242Oxide");
		m(112, "tinyAm243Oxide");
		m(114, "tinyCm243Oxide");
		m(116, "tinyCm245Oxide");
		m(118, "tinyCm246Oxide");
		m(120, "tinyCm247Oxide");
		m(124, "tinyCf250Oxide");
		
		// Shaped Crafting Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.fuel, 16, 33), true, new Object[] {" I ", "I I", " I ", 'I', "plateIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.fuel, 16, 45), true, new Object[] {" I ", "I I", " I ", 'I', "plateTin"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 2, 0), true, new Object[] {"LLL", "CCC", 'L', "ingotLead", 'C', "dustCoal"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 1, 2), true, new Object[] {"FFF", "CCC", "SSS", 'F', Items.flint, 'C', "cobblestone", 'S', Items.stick}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 16, 1), true, new Object[] {"III", "IBI", "III", 'I', "ingotIron", 'B', "blockIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 16, 6), true, new Object[] {"III", "IBI", "III", 'I', "ingotTin", 'B', "blockTin"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.nuclearFurnaceIdle, true, new Object[] {"XPX", "PFP", "XPX", 'P', "plateBasic", 'X', "dustObsidian", 'F', Blocks.furnace}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.furnaceIdle, true, new Object[] {"PPP", "PXP", "PPP", 'P', "plateIron", 'X', Blocks.furnace}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.crusherIdle, true, new Object[] {"PPP", "PCP", "PPP", 'P', "plateIron", 'C', new ItemStack(NCItems.parts, 1, 2)}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.electricFurnaceIdle, true, new Object[] {"PRP", "RCR", "PRP", 'P', "plateIron", 'R', new ItemStack(NCItems.parts, 1, 12), 'C', NCBlocks.furnaceIdle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.electricCrusherIdle, true, new Object[] {"PRP", "RCR", "PRP", 'P', "plateIron", 'R', new ItemStack(NCItems.parts, 1, 12), 'C', NCBlocks.crusherIdle}));
		
		if (Config.workspace) GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.nuclearWorkspace, true, new Object[] {"NNN", " T ", "TTT", 'N', "plateBasic", 'T', "ingotTough"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.graphiteBlock, true, new Object[] {"CDC", "DCD", "CDC", 'D', "dustCoal", 'C', Items.coal}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.fusionConnector, 4), true, new Object[] {"CC", 'C', NCBlocks.electromagnetIdle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.upgradeSpeed, true, new Object[] {"PPP", "PCP", "PPP", 'P', "dustLapis", 'C', "plateIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.upgradeEnergy, true, new Object[] {"PPP", "PCP", "PPP", 'P', "universalReactant", 'C', "plateIron"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.voltaicPile, true, new Object[] {"PCP", "PMP", 'P', "plateBasic", 'C', "blockCopper", 'M', "blockMagnesium"}));
	
		// Tool Crafting Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzePickaxe, true, new Object[] {"XXX", " S ", " S ", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeShovel, true, new Object[] {"X", "S", "S", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeAxe, true, new Object[] {"XX", "XS", " S", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeAxe, true, new Object[] {"XX", "SX", "S ", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeHoe, true, new Object[] {"XX", "S ", "S ", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeHoe, true, new Object[] {"XX", " S", " S", 'X', "ingotBronze", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.bronzeSword, true, new Object[] {"X", "X", "S", 'X', "ingotBronze", 'S', Items.stick}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronPickaxe, true, new Object[] {"XXX", " S ", " S ", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronShovel, true, new Object[] {"X", "S", "S", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronAxe, true, new Object[] {"XX", "XS", " S", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronAxe, true, new Object[] {"XX", "SX", "S ", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronHoe, true, new Object[] {"XX", "S ", "S ", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronHoe, true, new Object[] {"XX", " S", " S", 'X', "ingotBoron", 'S', Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.boronSword, true, new Object[] {"X", "X", "S", 'X', "ingotBoron", 'S', Items.stick}));
		
		// Armour Crafting Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.boronHelm, 1), true, new Object[] {"XXX", "X X", 'X', "ingotBoron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.boronChest, 1), true, new Object[] {"X X", "XXX", "XXX", 'X', "ingotBoron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.boronLegs, 1), true, new Object[] {"XXX", "X X", "X X", 'X', "ingotBoron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.boronBoots, 1), true, new Object[] {"X X", "X X", 'X', "ingotBoron"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.bronzeHelm, 1), true, new Object[] {"XXX", "X X", 'X', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.bronzeChest, 1), true, new Object[] {"X X", "XXX", "XXX", 'X', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.bronzeLegs, 1), true, new Object[] {"XXX", "X X", "X X", 'X', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.bronzeBoots, 1), true, new Object[] {"X X", "X X", 'X', "ingotBronze"}));
	
		// Simple Shapeless Crafting Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 4), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 0), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 1), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 2), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 3), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 6), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 6)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 5), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 5)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 42), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 8)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 43), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 9)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 25, 7), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 7)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 50), new Object[] {new ItemStack(NCBlocks.blockBlock, 1, 10)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.material, 9, 76), new Object[] {new ItemStack(NCBlocks.graphiteBlock, 1)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.tubing1, 1), new Object[] {new ItemStack(NCBlocks.tubing2)});
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.tubing2, 1), new Object[] {new ItemStack(NCBlocks.tubing1)});
		
		// Complex Shapeless Crafting Recipes
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.dominoes, 4), new Object[] {Items.cooked_beef, Items.cooked_porkchop, Items.cooked_chicken, Blocks.brown_mushroom, Blocks.brown_mushroom, Items.bread, Items.bread}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 4, 6), new Object[] {"ingotCopper", "ingotCopper", "ingotCopper", "ingotTin"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 4, 21), new Object[] {"dustCopper", "dustCopper", "dustCopper", "dustTin"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 3, 71), new Object[] {"ingotMagnesium", "ingotBoron", "ingotBoron"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 3, 72), new Object[] {"dustMagnesium", "dustBoron", "dustBoron"}));
		
		// Fission Fuel Shapeless Recipes
		l(0, "U238", "U235Base");
		h(1, "U238", "U235Base");
		l(2, "Pu242", "Pu239Base");
		h(3, "Pu242", "Pu239Base");
		l(4, "U238", "Pu239Oxide");
		f(5, "Th232Base");
		l(6, "U238", "U233Base");
		h(7, "U238", "U233Base");
		l(8, "Pu242", "Pu241Base");
		h(9, "Pu242", "Pu241Base");
		l(10, "U238", "Pu241Oxide");
		f(76, "Th232Oxide");
		
		l(51, "U238", "U235Oxide");
		h(52, "U238", "U235Oxide");
		l(53, "Pu242", "Pu239Oxide");
		h(54, "Pu242", "Pu239Oxide");
		l(55, "U238", "U233Oxide");
		h(56, "U238", "U233Oxide");
		l(57, "Pu242", "Pu241Oxide");
		h(58, "Pu242", "Pu241Oxide");
		
		l(79, "Np237", "Np236Base");
		h(80, "Np237", "Np236Base");
		l(81, "Am243", "Am242Base");
		h(82, "Am243", "Am242Base");
		l(83, "Cm246", "Cm243Base");
		h(84, "Cm246", "Cm243Base");
		l(85, "Cm246", "Cm245Base");
		h(86, "Cm246", "Cm245Base");
		l(87, "Cm246", "Cm247Base");
		h(88, "Cm246", "Cm247Base");
		
		l(89, "Np237", "Np236Oxide");
		h(90, "Np237", "Np236Oxide");
		l(91, "Am243", "Am242Oxide");
		h(92, "Am243", "Am242Oxide");
		l(93, "Cm246", "Cm243Oxide");
		h(94, "Cm246", "Cm243Oxide");
		l(95, "Cm246", "Cm245Oxide");
		h(96, "Cm246", "Cm245Oxide");
		l(97, "Cm246", "Cm247Oxide");
		h(98, "Cm246", "Cm247Oxide");
		
		// Fuel Cell Shapeless Recipes
		c(11, "LEU235");
		c(12, "HEU235");
		c(13, "LEP239");
		c(14, "HEP239");
		c(15, "MOX239");
		c(16, "TBU");
		c(17, "LEU233");
		c(18, "HEU233");
		c(19, "LEP241");
		c(20, "HEP241");
		c(21, "MOX241");
		c(77, "TBUOxide");
		
		c(59, "LEU235Oxide");
		c(60, "HEU235Oxide");
		c(61, "LEP239Oxide");
		c(62, "HEP239Oxide");
		c(63, "LEU233Oxide");
		c(64, "HEU233Oxide");
		c(65, "LEP241Oxide");
		c(66, "HEP241Oxide");
		
		c(99, "LEN236");
		c(100, "HEN236");
		c(101, "LEA242");
		c(102, "HEA242");
		c(103, "LEC243");
		c(104, "HEC243");
		c(105, "LEC245");
		c(106, "HEC245");
		c(107, "LEC247");
		c(108, "HEC247");
		
		c(109, "LEN236Oxide");
		c(110, "HEN236Oxide");
		c(111, "LEA242Oxide");
		c(112, "HEA242Oxide");
		c(113, "LEC243Oxide");
		c(114, "HEC243Oxide");
		c(115, "LEC245Oxide");
		c(116, "HEC245Oxide");
		c(117, "LEC247Oxide");
		c(118, "HEC247Oxide");
		
		c(41, "Li6");
		c(42, "Li7");
		c(43, "B10");
		c(44, "B11");
		
		// Other Shapeless Recipes
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.parts, 3, 4), new Object[] {Items.sugar, "dustLapis", Items.redstone}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fishAndRicecake, 1), new Object[] {Items.cooked_fished, NCItems.ricecake}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.recordPractice, 1), new Object[] {"record", "ingotBoron"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.recordArea51, 1), new Object[] {"record", "ingotTough"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.recordNeighborhood, 1), new Object[] {"record", "universalReactant"}));
		//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.recordJoe, 1), new Object[] {"record", "record"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 4, 22), new Object[] {new ItemStack(NCItems.parts, 1, 4), "dustCoal", "dustCoal", "dustLead", "dustLead", "dustSilver", "dustSilver", "dustIron", "dustIron"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 4, 7), new Object[] {new ItemStack(NCItems.parts, 1, 4), "dustCoal", "dustCoal", "ingotLead", "ingotLead", "ingotSilver", "ingotSilver", "ingotIron", "ingotIron"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, 45), new Object[] {"filledNCGasCell"}));
		
		GameRegistry.addShapelessRecipe(new ItemStack(NCItems.fuel, 1, 34), (new ItemStack (Items.water_bucket, 1)), (new ItemStack (NCItems.fuel, 1, 45)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.coolerBlock, 1), (new ItemStack (Items.redstone, 1)), (new ItemStack(NCItems.parts, 1, 4)), (new ItemStack (NCBlocks.emptyCoolerBlock, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.waterCoolerBlock, 1), (new ItemStack (NCItems.fuel, 1, 34)), (new ItemStack (NCBlocks.emptyCoolerBlock, 1)));
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.waterCoolerBlock, 1), (new ItemStack (Items.water_bucket, 1)), (new ItemStack (NCBlocks.emptyCoolerBlock, 1)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(NCBlocks.heliumCoolerBlock, 1), (new ItemStack (NCBlocks.emptyCoolerBlock, 1)), (new ItemStack (NCItems.fuel, 1, 75)), (new ItemStack (NCItems.fuel, 1, 75)), (new ItemStack (NCItems.fuel, 1, 75)), (new ItemStack (NCItems.fuel, 1, 75)));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 2, 79), new Object[] {"dustGraphite", "dustDiamond"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 2, 80), new Object[] {"ingotLithium", "ingotManganeseDioxide"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.material, 2, 81), new Object[] {"dustLithium", "dustManganeseDioxide"}));
		
		// Workspace Recipes
		if (!Config.workspace) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.machineBlock, new Object[] {"plateBasic", "plateLead", "plateLead", new ItemStack(NCItems.parts, 1, 10), new ItemStack(NCItems.parts, 1, 11), new ItemStack(NCItems.parts, 1, 12), new ItemStack(NCItems.parts, 1, 13), new ItemStack(NCItems.parts, 1, 16), "dustRedstone"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.reactorBlock, 8), true, new Object[] {"ABA", "B B", "ABA", 'A', "ingotTough", 'B', "plateBasic"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cellBlock, 1), true, new Object[] {"ABA", "CDC", "ABA", 'A', "blockGlass", 'B', "plateBasic", 'C', "ingotTough", 'D', "plateLead"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.emptyCoolerBlock, 8), true, new Object[] {"ABA", "B B", "ABA", 'A', "universalReactant", 'B', "plateBasic"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.speedBlock, 4), true, new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_powder, 'B', "plateBasic", 'C', "dustRedstone"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fissionReactorGraphiteIdle, true, new Object[] {"BAB", "ACA", "BAB", 'A', "plateReinforced", 'B', "plateDU", 'C', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fissionReactorSteamIdle, true, new Object[] {"BAB", "ACA", "BAB", 'A', new ItemStack(NCItems.parts, 1, 7), 'B', "plateAdvanced", 'C', NCBlocks.fissionReactorGraphiteIdle}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.blastBlock, new Object[] {NCBlocks.reactorBlock, "oreObsidian"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 1, 9), true, new Object[] {"AAA", "BCB", "AAA", 'A', new ItemStack(NCItems.material, 1, 48), 'B', "plateDU", 'C', "dustDiamond"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.separatorIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateLead", 'B', "ingotTough", 'C', "dustRedstone", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.recyclerIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateLead", 'B', "ingotTough", 'C', "ingotHardCarbon", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.hastenerIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateLead", 'B', "universalReactant", 'C', "ingotTough", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.collectorIdle, true, new Object[] {"ABA", "BBB", "ABA", 'A', "plateBasic", 'B', new ItemStack(NCItems.material, 1, 40)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.reactionGeneratorIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateLead", 'B', new ItemStack(NCItems.parts, 1, 5), 'C', "plateBasic", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.electrolyserIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateReinforced", 'B', new ItemStack(NCItems.parts, 1, 7), 'C', "universalReactant", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.oxidiserIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateDU", 'B', "universalReactant", 'C', "plateLead", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.ioniserIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateDU", 'B', "dustRedstone", 'C', "plateLead", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.irradiatorIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateDU", 'B', "universalReactant", 'C', "ingotTough", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.coolerIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateDU", 'B', "universalReactant", 'C', "plateBasic", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.factoryIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "ingotTough", 'B', "plateBasic", 'C', "plateIron", 'D', Blocks.piston}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.assemblerIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "ingotTough", 'B', "plateIron", 'C', "plateBasic", 'D', Blocks.piston}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.heliumExtractorIdle, true, new Object[] {"ABA", "CDC", "ABA", 'A', "plateReinforced", 'B', new ItemStack(NCItems.parts, 1, 5), 'C', "plateTin", 'D', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.electromagnetIdle, 2), true, new Object[] {"AAA", "BCB", "AAA", 'A', "plateReinforced", 'B', new ItemStack(NCItems.parts, 1, 12), 'C', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fusionReactor, true, new Object[] {"ABA", "BCB", "ABA", 'A', NCBlocks.reactionGeneratorIdle, 'B', "plateAdvanced", 'C', NCBlocks.electromagnetIdle}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fusionReactorSteam, true, new Object[] {"BAB", "ACA", "BAB", 'A', new ItemStack(NCItems.parts, 1, 7), 'B', "plateAdvanced", 'C', NCBlocks.fusionReactor}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.superElectromagnetIdle, true, new Object[] {"AAA", "BCB", "AAA", 'A', "plateAdvanced", 'B', new ItemStack(NCItems.parts, 1, 17), 'C', "ingotTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.synchrotronIdle, true, new Object[] {"AAA", "BCB", "AAA", 'A', NCBlocks.superElectromagnetIdle, 'B', "plateAdvanced", 'C', NCBlocks.machineBlock}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.supercoolerIdle, true, new Object[] {"AAA", "BCB", "AAA", 'A', "plateAdvanced", 'B', new ItemStack(NCItems.parts, 1, 13), 'C', "universalReactant"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyPickaxe, true, new Object[] {"XXX", " S ", " S ", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyShovel, true, new Object[] {"X", "S", "S", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyAxe, true, new Object[] {"XX", "XS", " S", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyAxe, true, new Object[] {"XX", "SX", "S ", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyHoe, true, new Object[] {"XX", "S ", "S ", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyHoe, true, new Object[] {"XX", " S", " S", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloySword, true, new Object[] {"X", "X", "S", 'X', "ingotTough", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughAlloyPaxel, true, new Object[] {"ASP", "HIW", " I ", 'I', "ingotIron", 'A', NCItems.toughAlloyAxe, 'S', NCItems.toughAlloyShovel, 'P', NCItems.toughAlloyPickaxe, 'H', NCItems.toughAlloyHoe, 'W', NCItems.toughAlloySword}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUPickaxe, true, new Object[] {"XXX", " S ", " S ", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUShovel, true, new Object[] {"X", "S", "S", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUAxe, true, new Object[] {"XX", "XS", " S", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUAxe, true, new Object[] {"XX", "SX", "S ", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUHoe, true, new Object[] {"XX", "S ", "S ", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUHoe, true, new Object[] {"XX", " S", " S", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUSword, true, new Object[] {"X", "X", "S", 'X', "plateDU", 'S', "ingotIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.dUPaxel, true, new Object[] {"ASP", "HIW", " I ", 'I', "ingotIron", 'A', NCItems.dUAxe, 'S', NCItems.dUShovel, 'P', NCItems.dUPickaxe, 'H', NCItems.dUHoe, 'W', NCItems.dUSword}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.toughHelm, 1), true, new Object[] {"XXX", "X X", 'X', "ingotTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.toughChest, 1), true, new Object[] {"X X", "XXX", "XXX", 'X', "ingotTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.toughLegs, 1), true, new Object[] {"XXX", "X X", "X X", 'X', "ingotTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.toughBoots, 1), true, new Object[] {"X X", "X X", 'X', "ingotTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.dUHelm, 1), true, new Object[] {"XXX", "X X", 'X', "plateDU"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.dUChest, 1), true, new Object[] {"X X", "XXX", "XXX", 'X', "plateDU"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.dULegs, 1), true, new Object[] {"XXX", "X X", "X X", 'X', "plateDU"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.dUBoots, 1), true, new Object[] {"X X", "X X", 'X', "plateDU"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.RTG, true, new Object[] {"ABA", "BCB", "ABA", 'A', new ItemStack(NCItems.parts, 1, 11), 'B', new ItemStack(NCItems.parts, 1, 15), 'C', new ItemStack(NCItems.fuel, 1, 46)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.AmRTG, true, new Object[] {"ABA", "BCB", "ABA", 'A', new ItemStack(NCItems.parts, 1, 11), 'B', new ItemStack(NCItems.parts, 1, 15), 'C', new ItemStack(NCItems.fuel, 1, 139)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.CfRTG, true, new Object[] {"ABA", "BCB", "ABA", 'A', new ItemStack(NCItems.parts, 1, 11), 'B', new ItemStack(NCItems.parts, 1, 15), 'C', new ItemStack(NCItems.fuel, 1, 140)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.WRTG, true, new Object[] {"ABA", "BBB", "ABA", 'A', "plateLead", 'B', "U238"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.steamGenerator, true, new Object[] {"PCP", "MMM", "PCP", 'P', "plateIron", 'C', new ItemStack(NCItems.parts, 1, 12), 'M', new ItemStack(NCItems.parts, 1, 19)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.steamDecompressor, true, new Object[] {"PCP", "GMG", "PCP", 'P', "plateIron", 'C', Blocks.piston, 'G', new ItemStack(NCItems.parts, 1, 10), 'M', new ItemStack(NCItems.parts, 1, 19)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.denseSteamDecompressor, true, new Object[] {"PPP", "CCC", "PPP", 'P', "plateAdvanced", 'C', NCBlocks.steamDecompressor}));
			if (Config.enableNukes) {
				GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.nuke, true, new Object[] {"ABA", "BBB", "ABA", 'A', "plateReinforced", 'B', new ItemStack(NCItems.material, 1, 67)}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.nuclearGrenade, 3), true, new Object[] {"  S", " S ", "N  ", 'S', Items.string, 'N', NCBlocks.nuke}));
				GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.antimatterBomb, true, new Object[] {"AAA", "ABA", "AAA", 'A', NCItems.antimatter, 'B', NCBlocks.superElectromagnetIdle}));
			}
			GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.solarPanel, true, new Object[] {"DDD", "ECE", "ABA", 'A', new ItemStack(NCItems.parts, 1, 12), 'B', Blocks.iron_block, 'C', "dustCoal", 'D', new ItemStack(NCItems.parts, 1, 15), 'E', "universalReactant"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.portableEnderChest, true, new Object[] {"ABA", "CDC", "AAA", 'A', Blocks.wool, 'B', Items.string, 'C', "plateLead", 'D', Items.ender_eye}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.pistol, true, new Object[] {"AAA", "BBA", "CBA", 'A', "plateReinforced", 'B', "ingotTough", 'C', "plateAdvanced"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 2, 5), true, new Object[] {"ABA", "B B", "ABA", 'A', "universalReactant", 'B', "plateBasic"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 1, 7), true, new Object[] {"ABA", "B B", "ABA", 'A', "plateTin", 'B', new ItemStack(NCItems.fuel, 1, 34)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 1, 3), true, new Object[] {" A ", "ABA", " A ", 'A', "ingotTough", 'B', "plateBasic"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 1, 8), true, new Object[] {"AAA", "BBB", "AAA", 'A', "U238", 'B', "plateReinforced"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.tubing1, 8), true, new Object[] {"AAA", "BBB", "AAA", 'A', "plateLead", 'B', "plateIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.tubing2, 8), true, new Object[] {"ABA", "ABA", "ABA", 'A', "plateLead", 'B', "plateIron"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughBow, true, new Object[] {"BA ", "B A", "BA ", 'A', "ingotTough", 'B', Items.string}));
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.toughBow, true, new Object[] {" AB", "A B", " AB", 'A', "ingotTough", 'B', Items.string}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.parts, 12, 0), true, new Object[] {"AAA", "BBB", 'A', "ingotTough", 'B', "dustTough"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.fuel, 8, 48), true, new Object[] {"ABA", "BCB", "ABA", 'B', new ItemStack(NCItems.parts, 1, 15), 'C', "ingotTough", 'A', new ItemStack (NCItems.parts, 1, 3)}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.dUBullet, 4), true, new Object[] {"ABC", 'A', "U238", 'B', Items.gunpowder, 'C', "ingotTough"}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, 46), new Object[] {new ItemStack(NCItems.fuel, 1, 48), "Pu238"}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, 139), new Object[] {new ItemStack(NCItems.fuel, 1, 48), "Am241"}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, 140), new Object[] {new ItemStack(NCItems.fuel, 1, 48), "Cf250"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.lithiumIonBattery, true, new Object[] {"AAA", "BCB", "DDD", 'A', "ingotLithiumManganeseDioxide", 'B', "plateAdvanced", 'C', "dustLithium", 'D', "ingotHardCarbon"}));
		}
		
		// Smelting Recipes
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 4), new ItemStack (NCItems.material, 1, 4), 1.2F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 0), new ItemStack(NCItems.material, 1, 0), 0.6F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 1), new ItemStack(NCItems.material, 1, 1), 0.6F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 2), new ItemStack(NCItems.material, 1, 2), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 3), new ItemStack(NCItems.material, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 5), new ItemStack(NCItems.material, 1, 5), 1.2F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 6), new ItemStack(NCItems.material, 1, 33), 1.2F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 7), new ItemStack(NCItems.material, 1, 42), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 8), new ItemStack(NCItems.material, 1, 43), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NCBlocks.blockOre, 1, 9), new ItemStack(NCItems.material, 1, 50), 0.8F);
		
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 8), new ItemStack(Items.iron_ingot), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 9), new ItemStack(Items.gold_ingot), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 15), new ItemStack(NCItems.material, 1, 0), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 17), new ItemStack(NCItems.material, 1, 2), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 16), new ItemStack(NCItems.material, 1, 1), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 18), new ItemStack(NCItems.material, 1, 3), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 19), new ItemStack(NCItems.material, 1, 4), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 20), new ItemStack(NCItems.material, 1, 5), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 21), new ItemStack(NCItems.material, 1, 6), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 22), new ItemStack(NCItems.material, 1, 7), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 44), new ItemStack(NCItems.material, 1, 42), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 45), new ItemStack(NCItems.material, 1, 43), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 51), new ItemStack(NCItems.material, 1, 50), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 54), new ItemStack(NCItems.material, 1, 53), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 127), new ItemStack(NCItems.material, 1, 126), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 72), new ItemStack(NCItems.material, 1, 71), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 77), new ItemStack(NCItems.material, 1, 76), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 79), new ItemStack(NCItems.material, 1, 78), 0.0F);
		GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, 81), new ItemStack(NCItems.material, 1, 80), 0.0F);
		
		GameRegistry.addSmelting(new ItemStack(Items.egg, 1), new ItemStack(NCItems.boiledEgg, 1), 0.1F);
		/*
		int out = 4;
		for(int i = 53; i<128; i++) {
			i = ((i==69) ? 75: i);
			i = ((i==76) ? 82: i);
			i = ((i==86) ? 104: i);
			i = ((i==122) ? 124: i);
			GameRegistry.addSmelting(new ItemStack(NCItems.material, 1, i), new ItemStack(NCItems.material, 1, out), 0F);
			out += 1;
			out = ( i == 53 )? 19 : ((i==54)? 24 : out);
			out = ( i == 68 )? 74 : ((i==75)? 38 : out);
		}
		*/
		s(NCItems.fuel, 51, 0);
		s(NCItems.fuel, 52, 1);
		s(NCItems.fuel, 53, 2);
		s(NCItems.fuel, 54, 3);
		s(NCItems.fuel, 55, 6);
		s(NCItems.fuel, 56, 7);
		s(NCItems.fuel, 57, 8);
		s(NCItems.fuel, 58, 9);
		
		s(NCItems.fuel, 59, 11);
		s(NCItems.fuel, 60, 12);
		s(NCItems.fuel, 61, 13);
		s(NCItems.fuel, 62, 14);
		s(NCItems.fuel, 63, 17);
		s(NCItems.fuel, 64, 18);
		s(NCItems.fuel, 65, 19);
		s(NCItems.fuel, 66, 20);
		
		s(NCItems.fuel, 67, 22);
		s(NCItems.fuel, 68, 23);
		s(NCItems.fuel, 69, 24);
		s(NCItems.fuel, 70, 25);
		s(NCItems.fuel, 71, 28);
		s(NCItems.fuel, 72, 29);
		s(NCItems.fuel, 73, 30);
		s(NCItems.fuel, 74, 31);
		
		s(NCItems.fuel, 76, 5);
		s(NCItems.fuel, 77, 16);
		s(NCItems.fuel, 78, 27);
		
		s(NCItems.fuel, 89, 79);
		s(NCItems.fuel, 90, 80);
		s(NCItems.fuel, 91, 81);
		s(NCItems.fuel, 92, 82);
		s(NCItems.fuel, 93, 83);
		s(NCItems.fuel, 94, 84);
		s(NCItems.fuel, 95, 85);
		s(NCItems.fuel, 96, 86);
		s(NCItems.fuel, 97, 87);
		s(NCItems.fuel, 98, 88);
		
		s(NCItems.fuel, 109, 99);
		s(NCItems.fuel, 110, 100);
		s(NCItems.fuel, 111, 101);
		s(NCItems.fuel, 112, 102);
		s(NCItems.fuel, 113, 103);
		s(NCItems.fuel, 114, 104);
		s(NCItems.fuel, 115, 105);
		s(NCItems.fuel, 116, 106);
		s(NCItems.fuel, 117, 107);
		s(NCItems.fuel, 118, 108);
		
		s(NCItems.fuel, 129, 119);
		s(NCItems.fuel, 130, 120);
		s(NCItems.fuel, 131, 121);
		s(NCItems.fuel, 132, 122);
		s(NCItems.fuel, 133, 123);
		s(NCItems.fuel, 134, 124);
		s(NCItems.fuel, 135, 125);
		s(NCItems.fuel, 136, 126);
		s(NCItems.fuel, 137, 127);
		s(NCItems.fuel, 138, 128);
		
		s(NCItems.material, 53, 4);

		s(NCItems.material, 54, 19);

		
		s(NCItems.material, 55, 24);
		s(NCItems.material, 56, 25);
		s(NCItems.material, 57, 26);
		s(NCItems.material, 58, 27);
		s(NCItems.material, 59, 28);
		s(NCItems.material, 60, 29);
		s(NCItems.material, 61, 30);
		s(NCItems.material, 62, 31);
		s(NCItems.material, 63, 32);
		s(NCItems.material, 64, 33);
		s(NCItems.material, 65, 34);
		s(NCItems.material, 66, 35);
		s(NCItems.material, 67, 36);
		s(NCItems.material, 68, 37);
		
		s(NCItems.material, 75, 74);
		
		s(NCItems.material, 82, 38);
		s(NCItems.material, 83, 39);
		s(NCItems.material, 84, 40);
		s(NCItems.material, 85, 41);
		

		
		s(NCItems.material, 104, 86);
		s(NCItems.material, 105, 87);
		s(NCItems.material, 106, 88);
		s(NCItems.material, 107, 89);
		s(NCItems.material, 108, 90);
		s(NCItems.material, 109, 91);
		s(NCItems.material, 110, 92);
		s(NCItems.material, 111, 93);
		s(NCItems.material, 112, 94);
		s(NCItems.material, 113, 95);
		s(NCItems.material, 114, 96);
		s(NCItems.material, 115, 97);
		s(NCItems.material, 116, 98);
		s(NCItems.material, 117, 99);
		s(NCItems.material, 118, 100);
		s(NCItems.material, 119, 101);
		s(NCItems.material, 120, 102);
		s(NCItems.material, 121, 103);
		
		s(NCItems.material, 124, 122);
		s(NCItems.material, 125, 123);
		s(NCItems.material, 126, 5);
		s(NCItems.material, 127, 20);
	}
	
	public void s(Item item, int metaIn, int metaOut) {
		GameRegistry.addSmelting(new ItemStack(item, 1, metaIn), new ItemStack(item, 1, metaOut), 0F);
	}
	
	public void b(int meta, String item) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.blockBlock, 1, meta), true, new Object[] {"XXX", "XXX", "XXX", 'X', item}));
	}
	
	public void b(Block block, String item) {
		GameRegistry.addRecipe(new ShapedOreRecipe(block, true, new Object[] {"XXX", "XXX", "XXX", 'X', item}));
	}
	
	public void l(int meta, String fertile, String fissile) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, meta), new Object[] {fertile, fertile, fertile, fertile, fertile, fertile, fertile, fertile, fissile}));
	}
	
	public void h(int meta, String fertile, String fissile) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, meta), new Object[] {fertile, fertile, fertile, fertile, fertile, fissile, fissile, fissile, fissile}));
	}
	
	public void f(int meta, String fertile) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, meta), new Object[] {fertile, fertile, fertile, fertile, fertile, fertile, fertile, fertile, fertile}));
	}
	
	public void m(int meta, String item) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.material, 1, meta), true, new Object[] {"XXX", "XXX", "XXX", 'X', item}));
	}
	
	public void c(int meta, String fuel) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel, 1, meta), new Object[] {fuel, new ItemStack (NCItems.fuel, 1, 33)}));
	}
	
	public Achievement a(String name, int x, int y, Block req, Achievement pre) {
		return achievements.registerAchievement(new Achievement("achievement." + name, name, x, y, req, pre));
	}
	
	public Achievement a(String name, int x, int y, Item req, Achievement pre) {
		return achievements.registerAchievement(new Achievement("achievement." + name, name, x, y, req, pre));
	}
	
	public Achievement a(String name, int x, int y, ItemStack req, Achievement pre) {
		return achievements.registerAchievement(new Achievement("achievement." + name, name, x, y, req, pre));
	}
}