package nc.crafting.machine;

import nc.Config;
import nc.block.NCBlocks;
import nc.crafting.NCRecipeHelper;
import nc.item.NCItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AssemblerRecipes extends NCRecipeHelper {

	private static final AssemblerRecipes recipes = new AssemblerRecipes();

	public AssemblerRecipes(){
		super(4, 1);
	}
	public static final NCRecipeHelper instance() {
		return recipes;
	}
	
	public void addRecipes() {
		addRecipe(oreStack("plateBasic", Config.workspace ? 2 : 1), oreStack("plateLead", Config.workspace ? 4 : 2), new ItemStack(NCItems.parts, 1, 12), oreStack("dustRedstone", 1), new ItemStack(NCItems.parts, 2, 18));
		addRecipe(new ItemStack(NCItems.parts, 1, 10), new ItemStack(NCItems.parts, Config.workspace ? 2 : 1, 11), new ItemStack(NCItems.parts, Config.workspace ? 2 : 1, 13), new ItemStack(NCItems.parts, Config.workspace ? 4 : 1, 16), new ItemStack(NCItems.parts, 2, 19));
		addRecipe(new ItemStack(NCItems.parts, Config.workspace ? 4 : 2, 18), new ItemStack(NCItems.parts, 2, 19), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.machineBlock, 1));
		addRecipe(oreStack("plateBasic", Config.workspace ? 3 : 1), oreStack("ingotTough", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.reactorBlock, Config.workspace ? 4 : 2));
		addRecipe(oreStack("plateBasic", Config.workspace ? 8 : 2), oreStack("plateLead", Config.workspace ? 4 : 1), oreStack("ingotTough", Config.workspace ? 4 : 2), oreStack("blockGlass", 4), new ItemStack(NCBlocks.cellBlock, 1));
		addRecipe(oreStack("plateBasic", Config.workspace ? 3 : 1), oreStack("universalReactant", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.emptyCoolerBlock, Config.workspace ? 4 : 2));
		addRecipe(oreStack("plateBasic", Config.workspace ? 6 : 4), oreStack("dustRedstone", Config.workspace ? 2 : 1), new ItemStack(Items.blaze_powder, Config.workspace ? 2 : 4), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.speedBlock, Config.workspace ? 3 : 4));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), Config.workspace ? oreStack("plateBasic", 8) : oreStack("plateDU", 4), oreStack("plateReinforced", Config.workspace ? 12 : 4), Config.workspace ? oreStack("ingotTough", 4) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.fissionReactorGraphiteIdle, 1));
		addRecipe(new ItemStack(NCBlocks.fissionReactorGraphiteIdle, 1), Config.workspace ? oreStack("plateAdvanced", 8) : oreStack("plateAdvanced", 4), new ItemStack(NCItems.parts, Config.workspace ? 12 : 4, 7), Config.workspace ? oreStack("ingotTough", 4) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.fissionReactorSteamIdle, 1));
		addRecipe(new ItemStack(NCBlocks.reactorBlock, Config.workspace ? 3 : 1), oreStack("oreObsidian", Config.workspace ? 2 : 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.blastBlock, Config.workspace ? 4 : 1));
		addRecipe(oreStack("plateDU", Config.workspace ? 8 : 2), Config.workspace ? oreStack("universalReactant", 4) : new ItemStack(NCItems.material, 6, 48), Config.workspace ? new ItemStack(NCItems.material, 12, 48) : oreStack("dustDiamond", 1), Config.workspace ? oreStack("dustDiamond", 1) : new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, Config.workspace ? 4 : 1, 9));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateLead", Config.workspace ? 12 : 4), oreStack("ingotTough", Config.workspace ? 8 : 2), oreStack("dustRedstone", Config.workspace ? 4 : 2), new ItemStack(NCBlocks.separatorIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateLead", Config.workspace ? 12 : 4), oreStack("universalReactant", Config.workspace ? 8 : 2), oreStack("ingotTough", Config.workspace ? 4 : 2), new ItemStack(NCBlocks.hastenerIdle, 1));
		addRecipe(oreStack("plateBasic", Config.workspace ? 12 : 4), new ItemStack(NCItems.material, Config.workspace ? 9 : 5, 40), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.collectorIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateBasic", Config.workspace ? 4 : 2), Config.workspace ? new ItemStack(NCItems.parts, 4, 5) : oreStack("plateLead", 4), Config.workspace ? oreStack("dustRedstone", 12) : new ItemStack(NCItems.parts, 2, 5), new ItemStack(NCBlocks.reactionGeneratorIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateReinforced", Config.workspace ? 12 : 4), Config.workspace ? oreStack("plateLead", 6) : oreStack("universalReactant", 2), new ItemStack(NCItems.parts, 2, 7), new ItemStack(NCBlocks.electrolyserIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateDU", 4), oreStack("plateLead", Config.workspace ? 12 : 2), oreStack("universalReactant", Config.workspace ? 8 : 2), new ItemStack(NCBlocks.oxidiserIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateDU", 4), oreStack("plateLead", Config.workspace ? 12 : 2), oreStack("dustRedstone", Config.workspace ? 8 : 2), new ItemStack(NCBlocks.ioniserIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateDU", 4), oreStack("ingotTough", Config.workspace ? 12 : 2), oreStack("universalReactant", Config.workspace ? 8 : 2), new ItemStack(NCBlocks.irradiatorIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateDU", 4), oreStack("plateBasic", Config.workspace ? 12 : 2), oreStack("universalReactant", Config.workspace ? 8 : 2), new ItemStack(NCBlocks.coolerIdle, 1));
		addRecipe(new ItemStack(Blocks.piston, 1), oreStack("plateIron", Config.workspace ? 8 : 2), oreStack("plateBasic", Config.workspace ? 12 : 2), oreStack("ingotTough", 4), new ItemStack(NCBlocks.assemblerIdle, 1));
		addRecipe(new ItemStack(Blocks.piston, 1), oreStack("plateBasic", Config.workspace ? 12 : 2), oreStack("plateIron", Config.workspace ? 8 : 2), oreStack("ingotTough", 4), new ItemStack(NCBlocks.factoryIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateReinforced", Config.workspace ? 12 : 4), new ItemStack(NCItems.parts, Config.workspace ? 4 : 2, 5), oreStack("plateTin", Config.workspace ? 8 : 2), new ItemStack(NCBlocks.heliumExtractorIdle, 1));
		addRecipe(Config.workspace ? oreStack("plateBasic", 10) : oreStack("plateReinforced", 6), new ItemStack(NCItems.parts, Config.workspace ? 10 : 2, 12), oreStack("ingotIron", Config.workspace ? 5 : 1), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.electromagnetIdle, Config.workspace ? 1 : 2));
		addRecipe(oreStack("plateAdvanced", Config.workspace ? 16 : 4), new ItemStack(NCBlocks.reactionGeneratorIdle, Config.workspace ? 8 : 4), new ItemStack(NCBlocks.electromagnetIdle, 1), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.fusionReactor, 1));
		addRecipe(new ItemStack(NCBlocks.fusionReactor, 1), Config.workspace ? oreStack("plateAdvanced", 8) : oreStack("plateAdvanced", 4), new ItemStack(NCItems.parts, Config.workspace ? 12 : 4, 7), Config.workspace ? oreStack("ingotTough", 4) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.fusionReactorSteam, 1));
		addRecipe(oreStack("plateAdvanced", Config.workspace ? 4 : 6), Config.workspace ? oreStack("plateReinforced", 6) : new ItemStack(NCItems.parts, 2, 17), Config.workspace ? new ItemStack(NCItems.parts, 10, 17) : oreStack("ingotTough", 1), Config.workspace ? oreStack("ingotTough", 5) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.superElectromagnetIdle, 1));
		addRecipe(oreStack("plateAdvanced", Config.workspace ? 4 : 6), Config.workspace ? oreStack("plateReinforced", 6) : oreStack("universalReactant", 1), Config.workspace ? oreStack("universalReactant", 4) : new ItemStack(NCItems.parts, 2, 13), Config.workspace ? new ItemStack(NCItems.parts, 5, 13) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.supercoolerIdle, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateAdvanced", Config.workspace ? 12 : 2), Config.workspace ? oreStack("plateDU", 8) : new ItemStack(NCBlocks.superElectromagnetIdle, 6), Config.workspace ? new ItemStack(NCBlocks.superElectromagnetIdle, 4) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.synchrotronIdle, 1));
		addRecipe(oreStack("ingotTough", 25), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.blockBlock, 1, 7));
		addRecipe(new ItemStack(NCItems.fuel, 1, 46), Config.workspace ? oreStack("plateLead", 12) : new ItemStack(NCItems.parts, 4, 11), Config.workspace ? new ItemStack(NCItems.parts, 4, 11) : new ItemStack(NCItems.parts, 4, 15), Config.workspace ? new ItemStack(NCItems.parts, 8, 15) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.RTG, 1));
		addRecipe(new ItemStack(NCItems.fuel, 1, 139), Config.workspace ? oreStack("plateLead", 12) : new ItemStack(NCItems.parts, 4, 11), Config.workspace ? new ItemStack(NCItems.parts, 4, 11) : new ItemStack(NCItems.parts, 4, 15), Config.workspace ? new ItemStack(NCItems.parts, 8, 15) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.AmRTG, 1));
		addRecipe(new ItemStack(NCItems.fuel, 1, 140), Config.workspace ? oreStack("plateLead", 12) : new ItemStack(NCItems.parts, 4, 11), Config.workspace ? new ItemStack(NCItems.parts, 4, 11) : new ItemStack(NCItems.parts, 4, 15), Config.workspace ? new ItemStack(NCItems.parts, 8, 15) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.CfRTG, 1));
		addRecipe(oreStack("plateLead", Config.workspace ? 12 : 4), oreStack("U238", Config.workspace ? 9 : 5), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.WRTG, 1));
		if (Config.enableNukes) addRecipe(oreStack("plateReinforced", 4), Config.workspace ? oreStack("plateBasic", 12) : oreStack("Pu241", 5), Config.workspace ? oreStack("Pu241", 5) : new ItemStack(Items.stick, 0), Config.workspace ? new ItemStack(Items.gunpowder, 4) : new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.nuke, 1));
		if (Config.enableNukes) addRecipe(new ItemStack(NCBlocks.nuke, 1), Config.workspace ? oreStack("ingotTough", 4) : new ItemStack(Items.string, 2), Config.workspace ? new ItemStack(Items.gunpowder, 4) : new ItemStack(Items.stick, 0), Config.workspace ? new ItemStack(Items.string, 2) : new ItemStack(Items.stick, 0), new ItemStack(NCItems.nuclearGrenade, 3));
		addRecipe(Config.workspace ? oreStack("plateIron", 13) : oreStack("blockIron", 1), oreStack("universalReactant", Config.workspace ? 3 : 2), new ItemStack(NCItems.parts, Config.workspace ? 3 : 2, 12), new ItemStack(NCItems.parts, 3, 15), new ItemStack(NCBlocks.solarPanel, 1));
		addRecipe(oreStack("universalReactant", Config.workspace ? 2 : 1), oreStack("plateBasic", Config.workspace ? 5 : 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, Config.workspace ? 2 : 1, 5));
		addRecipe(oreStack("plateTin", Config.workspace ? 10 : 4), new ItemStack(NCItems.fuel, Config.workspace ? 6 : 4, 34), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, 1, 7));
		addRecipe(oreStack("ingotTough", Config.workspace ? 2 : 4), oreStack("plateBasic", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, 1, 3));
		addRecipe(oreStack("plateReinforced", Config.workspace ? 2 : 3), oreStack("U238", Config.workspace ? 4 : 6), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, 1, 8));
		addRecipe(oreStack("plateLead", Config.workspace ? 8 : 6), oreStack("plateIron", 3), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.tubing1, 8));
		addRecipe(oreStack("plateIron", 3), oreStack("plateLead", Config.workspace ? 8 : 6), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.tubing2, 8));
		addRecipe(oreStack("ingotTough", 1), oreStack("dustTough", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.parts, 4, 0));
		addRecipe(oreStack("plateIron", 1), oreStack("dustLapis", 8), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.upgradeSpeed, 1));
		addRecipe(oreStack("plateIron", 1), oreStack("universalReactant", 8), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.upgradeEnergy, 1));
		addRecipe(oreStack("plateReinforced", 4), oreStack("ingotTough", 1), new ItemStack(NCItems.parts, 4, 15), new ItemStack(Items.stick, 0), new ItemStack(NCItems.fuel, 8, 48));
		addRecipe(oreStack("ingotTough", 1), oreStack("U238", Config.workspace ? 2 : 1), new ItemStack(Items.gunpowder, 1), new ItemStack(Items.stick, 0), new ItemStack(NCItems.dUBullet, 4));
		addRecipe(new ItemStack(NCItems.fuel, 1, 48), oreStack("Pu238", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.fuel, 1, 46));
		addRecipe(new ItemStack(NCItems.fuel, 1, 48), oreStack("Am241", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.fuel, 1, 139));
		addRecipe(new ItemStack(NCItems.fuel, 1, 48), oreStack("Cf250", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.fuel, 1, 140));
		addRecipe(oreStack("blockTough", 1), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCItems.material, 25, 7));
		if (Config.enableNukes) addRecipe(new ItemStack(NCBlocks.superElectromagnetIdle, 1), new ItemStack(NCItems.antimatter, 8), Config.workspace ? oreStack("plateAdvanced", 16) : new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.antimatterBomb, 1));
		addRecipe(oreStack("plateIron", Config.workspace ? 14 : 4), new ItemStack(NCItems.parts, Config.workspace ? 6 : 2, 12), new ItemStack(NCItems.parts, Config.workspace ? 5 : 3, 19), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.steamGenerator, Config.workspace ? 2 : 1));
		addRecipe(oreStack("plateIron", Config.workspace ? 14 : 4), new ItemStack(Blocks.piston, Config.workspace ? 6 : 2), new ItemStack(NCItems.parts, 2, 10), new ItemStack(NCItems.parts, Config.workspace ? 3 : 1, 19), new ItemStack(NCBlocks.steamDecompressor, Config.workspace ? 2 : 1));
		addRecipe(oreStack("plateAdvanced", Config.workspace ? 10 : 6), new ItemStack(NCBlocks.steamDecompressor, Config.workspace ? 5 : 3), new ItemStack(Items.stick, 0), new ItemStack(Items.stick, 0), new ItemStack(NCBlocks.denseSteamDecompressor, 1));
		addRecipe(oreStack("ingotLithiumManganeseDioxide", Config.workspace ? 4 : 3), oreStack("dustLithium", Config.workspace ? 4 : 1), oreStack("ingotHardCarbon", Config.workspace ? 4 : 3), oreStack("plateAdvanced", Config.workspace ? 4 : 2), new ItemStack(NCItems.lithiumIonBattery, 1));
		addRecipe(new ItemStack(NCBlocks.machineBlock, 1), oreStack("plateLead", Config.workspace ? 12 : 4), oreStack("ingotTough", Config.workspace ? 8 : 2), oreStack("ingotHardCarbon", Config.workspace ? 4 : 2), new ItemStack(NCBlocks.recyclerIdle, 1));
	}
}