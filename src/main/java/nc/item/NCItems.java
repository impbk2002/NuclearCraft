package nc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import nc.Config;
import nc.NuclearCraft;
import nc.item.armour.BoronArmour;
import nc.item.armour.BronzeArmour;
import nc.item.armour.DUArmour;
import nc.item.armour.ToughArmour;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class NCItems {

	public static void preInitalize() {
		// Tool Materials
		ToolMaterial Bronze = EnumHelper.addToolMaterial("Bronze", Config.bronzeHarvestLevel, Config.bronzeDurability, Config.bronzeSpeed, Config.bronzeDamage, 10).setRepairItem(new ItemStack(NCItems.material, 1, 6));
		ToolMaterial ToughAlloy = EnumHelper.addToolMaterial("ToughAlloy", Config.toughHarvestLevel, Config.toughDurability, Config.toughSpeed, Config.toughDamage, 10).setRepairItem(new ItemStack(NCItems.material, 1, 7));
		ToolMaterial ToughPaxel = EnumHelper.addToolMaterial("ToughPaxel", Config.tPHarvestLevel, Config.tPDurability, Config.tPSpeed, Config.tPDamage, 10).setRepairItem(new ItemStack(NCItems.material, 1, 7));
		ToolMaterial dU = EnumHelper.addToolMaterial("dU", Config.dUHarvestLevel, Config.dUDurability, Config.dUSpeed, Config.dUDamage, 50).setRepairItem(new ItemStack(NCItems.parts, 1, 8));
		ToolMaterial dUPaxel = EnumHelper.addToolMaterial("dUPaxel", Config.dUPHarvestLevel, Config.dUPDurability, Config.dUPSpeed, Config.dUPDamage, 50).setRepairItem(new ItemStack(NCItems.parts, 1, 8));
		ToolMaterial Boron = EnumHelper.addToolMaterial("Boron", Config.boronHarvestLevel, Config.boronDurability, Config.boronSpeed, Config.boronDamage, 5).setRepairItem(new ItemStack(NCItems.material, 1, 43));
		
		// Armour Materials - 12, 17, 12, 8 - 5, 8, 7, 4
		ArmorMaterial ToughArmorMaterial = EnumHelper.addArmorMaterial("ToughArmorMaterial", 40, (Config.workspace ? new int [] {4, 8, 5, 3} : new int [] {3, 8, 6, 3}), 10);
		ArmorMaterial BoronArmorMaterial = EnumHelper.addArmorMaterial("BoronArmorMaterial", 30, new int [] {3, 7, 5, 2}, 5);
		ArmorMaterial BronzeArmorMaterial = EnumHelper.addArmorMaterial("BronzeArmorMaterial", 20, new int [] {2, 6, 5, 2}, 10);
		ArmorMaterial dUArmorMaterial = EnumHelper.addArmorMaterial("dUArmorMaterial", 80, (Config.workspace ? new int [] {5, 8, 5, 3} : new int [] {4, 8, 6, 3}), 50);
		
		GameRegistry.registerItem(NCItems.fuel = new ItemFuel(), "fuel");
		GameRegistry.registerItem(NCItems.material = new ItemMaterial(), "material");
		GameRegistry.registerItem(NCItems.parts = new ItemPart(), "parts");
		
		NCItems.dominoes = new ItemDominos(16, 1.4F, false, "dominoes", "Paul's favourite - he'll follow anyone", "he sees carrying this in their hand...", "Restores 16 hunger.");
		GameRegistry.registerItem(NCItems.dominoes, "dominoes");
		NCItems.boiledEgg = new ItemFoodNC(5, 0.6F, false, "boiledEgg", "A tasty snack that restores 5 hunger.");
		GameRegistry.registerItem(NCItems.boiledEgg, "boiledEgg");
		
		NCItems.ricecake = new ItemFoodNC(4, 0.4F, false, "ricecake", "A healthy meal, especially with fish. Restores 4 hunger.");
		GameRegistry.registerItem(NCItems.ricecake, "ricecake");
		NCItems.fishAndRicecake = new ItemFoodNC(9, 1.0F, false, "fishAndRicecake", "At 8 in the morning he'll have fish and a ricecake, at 10 he'll have fish,", "at 12 he'll have fish and a ricecake, at 2 he'll have fish, at 4, just", "before he trains, he'll have fish and a ricecake, he'll train, he'll have", "his fish, he'll come home and have some more fish with a ricecake and then", "have some fish before he goes to bed.");
		GameRegistry.registerItem(NCItems.fishAndRicecake, "fishAndRicecake");
		
		NCItems.upgradeSpeed = new ItemUpgrade("upgradeSpeed", "Used to increase the speed of machines.", "Stacked upgrades increase the speed exponentially.").setMaxStackSize(8);
		GameRegistry.registerItem(NCItems.upgradeSpeed, "upgradeSpeed");
		NCItems.upgradeEnergy = new ItemUpgrade("upgradeEnergy", "Used to increase the energy efficiency of machines.", "Stacked upgrades increase the efficiency exponentially.").setMaxStackSize(8);
		GameRegistry.registerItem(NCItems.upgradeEnergy, "upgradeEnergy");
		
		NCItems.nuclearGrenade = new ItemNuclearGrenade("nuclearGrenade", "A VERY deadly bomb. It is highly recommended", "that this is kept off your hotbar while not", "about to be used.");
		GameRegistry.registerItem(NCItems.nuclearGrenade, "nuclearGrenade");
		NCItems.nuclearGrenadeThrown = new ItemNC("weapons", "nuclearGrenadeThrown", false);
		GameRegistry.registerItem(NCItems.nuclearGrenadeThrown, "nuclearGrenadeThrown");
		
		NCItems.portableEnderChest = new ItemEnderChest("portableEnderChest", "Portable access to your Ender Chest.").setMaxStackSize(1);
		GameRegistry.registerItem(NCItems.portableEnderChest, "portableEnderChest");
		
		// Tool Registry
		NCItems.bronzePickaxe = new NCPickaxe(Bronze, "bronzePickaxe", "Can be repaired in an Anvil using Bronze.");
		GameRegistry.registerItem(NCItems.bronzePickaxe, "bronzePickaxe");
		NCItems.bronzeShovel = new NCShovel(Bronze, "bronzeShovel", "Can be repaired in an Anvil using Bronze.");
		GameRegistry.registerItem(NCItems.bronzeShovel, "bronzeShovel");
		NCItems.bronzeAxe = new NCAxe(Bronze, "bronzeAxe", "Can be repaired in an Anvil using Bronze.");
		GameRegistry.registerItem(NCItems.bronzeAxe, "bronzeAxe");
		NCItems.bronzeHoe = new NCHoe(Bronze, "bronzeHoe", "Can be repaired in an Anvil using Bronze.");
		GameRegistry.registerItem(NCItems.bronzeHoe, "bronzeHoe");
		NCItems.bronzeSword = new NCSword(Bronze, "bronzeSword", "Can be repaired in an Anvil using Bronze.");
		GameRegistry.registerItem(NCItems.bronzeSword, "bronzeSword");
		
		NCItems.boronPickaxe = new NCPickaxe(Boron, "boronPickaxe", "Can be repaired in an Anvil using Boron.");
		GameRegistry.registerItem(NCItems.boronPickaxe, "boronPickaxe");
		NCItems.boronShovel = new NCShovel(Boron, "boronShovel", "Can be repaired in an Anvil using Boron.");
		GameRegistry.registerItem(NCItems.boronShovel, "boronShovel");
		NCItems.boronAxe = new NCAxe(Boron, "boronAxe", "Can be repaired in an Anvil using Boron.");
		GameRegistry.registerItem(NCItems.boronAxe, "boronAxe");
		NCItems.boronHoe = new NCHoe(Boron, "boronHoe", "Can be repaired in an Anvil using Boron.");
		GameRegistry.registerItem(NCItems.boronHoe, "boronHoe");
		NCItems.boronSword = new NCSword(Boron, "boronSword", "Can be repaired in an Anvil using Boron.");
		GameRegistry.registerItem(NCItems.boronSword, "boronSword");
		
		NCItems.toughAlloyPickaxe = new NCPickaxe(ToughAlloy, "toughAlloyPickaxe", "Can be repaired in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloyPickaxe, "toughAlloyPickaxe");
		NCItems.toughAlloyShovel = new NCShovel(ToughAlloy, "toughAlloyShovel", "Can be repaired in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloyShovel, "toughAlloyShovel");
		NCItems.toughAlloyAxe = new NCAxe(ToughAlloy, "toughAlloyAxe", "Can be repaired in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloyAxe, "toughAlloyAxe");
		NCItems.toughAlloyHoe = new NCHoe(ToughAlloy, "toughAlloyHoe", "Can be repaired in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloyHoe, "toughAlloyHoe");
		NCItems.toughAlloySword = new NCSword(ToughAlloy, "toughAlloySword", "Can be repaired in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloySword, "toughAlloySword");
		NCItems.toughAlloyPaxel = new NCPaxel(ToughPaxel, "toughAlloyPaxel", "A multitool that can be repaired", "in an Anvil using Tough Alloy.");
		GameRegistry.registerItem(NCItems.toughAlloyPaxel, "toughAlloyPaxel");
		
		NCItems.dUPickaxe = new NCPickaxe(dU, "dUPickaxe", "Can be repaired in an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUPickaxe, "dUPickaxe");
		NCItems.dUShovel = new NCShovel(dU, "dUShovel", "Can be repaired in an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUShovel, "dUShovel");
		NCItems.dUAxe = new NCAxe(dU, "dUAxe", "Can be repaired in an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUAxe, "dUAxe");
		NCItems.dUHoe = new NCHoe(dU, "dUHoe", "Can be repaired in an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUHoe, "dUHoe");
		NCItems.dUSword = new NCSword(dU, "dUSword", "Can be repaired in an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUSword, "dUSword");
		NCItems.dUPaxel = new NCPaxel(dUPaxel, "dUPaxel", "A multitool that can be repaired in", "an Anvil using Depleted Uranium Plating.");
		GameRegistry.registerItem(NCItems.dUPaxel, "dUPaxel");
		
		NCItems.toughBow = new ItemToughBow("toughBow", "A better version of the vanilla bow - it does", "more damage and has a higher durability.", "Can be repaired in an Anvil using Tough Alloy.").setMaxStackSize(1);
		GameRegistry.registerItem(NCItems.toughBow, "toughBow");
		NCItems.pistol = new ItemPistol("pistol", "Uses DU bullets as ammunition.", "Deals a large amount of damage.");
		GameRegistry.registerItem(NCItems.pistol, "pistol");
		NCItems.dUBullet = new ItemNC("tools", "dUBullet", "Ammo for the Pistol.");
		GameRegistry.registerItem(NCItems.dUBullet, "dUBullet");
		
		//Armor Registry
		NCItems.toughHelm = new ToughArmour(ToughArmorMaterial, NuclearCraft.toughHelmID, 0, "toughHelm");
		GameRegistry.registerItem(NCItems.toughHelm, "toughHelm");
		NCItems.toughChest = new ToughArmour(ToughArmorMaterial, NuclearCraft.toughChestID, 1, "toughChest");
		GameRegistry.registerItem(NCItems.toughChest, "toughChest");
		NCItems.toughLegs = new ToughArmour(ToughArmorMaterial, NuclearCraft.toughLegsID, 2, "toughLegs");
		GameRegistry.registerItem(NCItems.toughLegs, "toughLegs");
		NCItems.toughBoots = new ToughArmour(ToughArmorMaterial, NuclearCraft.toughBootsID, 3, "toughBoots");
		GameRegistry.registerItem(NCItems.toughBoots, "toughBoots");
		
		NCItems.boronHelm = new BoronArmour(BoronArmorMaterial, NuclearCraft.boronHelmID, 0, "boronHelm");
		GameRegistry.registerItem(NCItems.boronHelm, "boronHelm");
		NCItems.boronChest = new BoronArmour(BoronArmorMaterial, NuclearCraft.boronChestID, 1, "boronChest");
		GameRegistry.registerItem(NCItems.boronChest, "boronChest");
		NCItems.boronLegs = new BoronArmour(BoronArmorMaterial, NuclearCraft.boronLegsID, 2, "boronLegs");
		GameRegistry.registerItem(NCItems.boronLegs, "boronLegs");
		NCItems.boronBoots = new BoronArmour(BoronArmorMaterial, NuclearCraft.boronBootsID, 3, "boronBoots");
		GameRegistry.registerItem(NCItems.boronBoots, "boronBoots");
		
		NCItems.bronzeHelm = new BronzeArmour(BronzeArmorMaterial, NuclearCraft.bronzeHelmID, 0, "bronzeHelm");
		GameRegistry.registerItem(NCItems.bronzeHelm, "bronzeHelm");
		NCItems.bronzeChest = new BronzeArmour(BronzeArmorMaterial, NuclearCraft.bronzeChestID, 1, "bronzeChest");
		GameRegistry.registerItem(NCItems.bronzeChest, "bronzeChest");
		NCItems.bronzeLegs = new BronzeArmour(BronzeArmorMaterial, NuclearCraft.bronzeLegsID, 2, "bronzeLegs");
		GameRegistry.registerItem(NCItems.bronzeLegs, "bronzeLegs");
		NCItems.bronzeBoots = new BronzeArmour(BronzeArmorMaterial, NuclearCraft.bronzeBootsID, 3, "bronzeBoots");
		GameRegistry.registerItem(NCItems.bronzeBoots, "bronzeBoots");
		
		NCItems.dUHelm = new DUArmour(dUArmorMaterial, NuclearCraft.dUHelmID, 0, "dUHelm");
		GameRegistry.registerItem(NCItems.dUHelm, "dUHelm");
		NCItems.dUChest = new DUArmour(dUArmorMaterial, NuclearCraft.dUChestID, 1, "dUChest");
		GameRegistry.registerItem(NCItems.dUChest, "dUChest");
		NCItems.dULegs = new DUArmour(dUArmorMaterial, NuclearCraft.dULegsID, 2, "dULegs");
		GameRegistry.registerItem(NCItems.dULegs, "dULegs");
		NCItems.dUBoots = new DUArmour(dUArmorMaterial, NuclearCraft.dUBootsID, 3, "dUBoots");
		GameRegistry.registerItem(NCItems.dUBoots, "dUBoots");
		
		//Records
		NCItems.recordPractice = new NCRecord(0, "Practice", "recordPractice", "Whenever Jimmy has some new discoveries", "to test out, his virtual practice labs are", "the best places to see what's possible...");
		GameRegistry.registerItem(NCItems.recordPractice, "recordPractice");
		NCItems.recordArea51 = new NCRecord(0, "Area51", "recordArea51", "Jimmy, with his newly aquired map, must", "make his way to the mines of Area 51", "to recover his invisibility technology...");
		GameRegistry.registerItem(NCItems.recordArea51, "recordArea51");
		NCItems.recordNeighborhood = new NCRecord(0, "Neighborhood", "recordNeighborhood", "Jimmy's hometown - a quiet and green place", "with roads to many great places such as", "Retroland and Downtown...");
		GameRegistry.registerItem(NCItems.recordNeighborhood, "recordNeighborhood");
		
		//NCItems.recordJoe = new NCRecord(0, "Joe", "recordJoe");
		//GameRegistry.registerItem(NCItems.recordJoe, "recordJoe");
		
		//Blank
		NCItems.blank = new ItemNC("", "blank", false);
		GameRegistry.registerItem(NCItems.blank, "blank");
		
		//Antimatter
		NCItems.antimatter = new ItemAntimatter("antimatter", "This is a temporary product of the Synchrotron.", "DO NOT drop this on the floor, or your base...", "...may go sadface...");
		GameRegistry.registerItem(NCItems.antimatter, "antimatter");
		
		//Batteries
		NCItems.lithiumIonBattery = new ItemBattery(Config.lithiumIonRF, (int) Math.ceil(Config.lithiumIonRF/20), "lithiumIonBattery", "A battery capable of storing " + (Config.lithiumIonRF >= 1000000 ? Config.lithiumIonRF/1000000 + " M" : (Config.lithiumIonRF >= 1000 ? Config.lithiumIonRF/1000 + " k" : Config.lithiumIonRF + " ")) + "RF.");
		GameRegistry.registerItem(NCItems.lithiumIonBattery, "lithiumIonBattery");
	}
	
	public static void initialize() {
		
	}
	
	public static void postInitalize() {
		
	}
	
	public static Item bronzePickaxe;
	public static Item bronzeShovel;
	public static Item bronzeAxe;
	public static Item bronzeHoe;
	public static Item bronzeSword;
	
	public static Item boronPickaxe;
	public static Item boronShovel;
	public static Item boronAxe;
	public static Item boronHoe;
	public static Item boronSword;
	
	public static Item toughAlloyPickaxe;
	public static Item toughAlloyShovel;
	public static Item toughAlloyAxe;
	public static Item toughAlloyHoe;
	public static Item toughAlloySword;
	public static Item toughAlloyPaxel;
	public static Item toughBow;
	public static Item pistol;
	public static Item dUBullet;
	
	public static Item dUPickaxe;
	public static Item dUShovel;
	public static Item dUAxe;
	public static Item dUHoe;
	public static Item dUSword;
	public static Item dUPaxel;
	
	public static Item toughHelm;
	public static Item toughChest;
	public static Item toughLegs;
	public static Item toughBoots;
	
	public static Item dUHelm;
	public static Item dUChest;
	public static Item dULegs;
	public static Item dUBoots;
	
	public static Item boronHelm;
	public static Item boronChest;
	public static Item boronLegs;
	public static Item boronBoots;
	
	public static Item bronzeHelm;
	public static Item bronzeChest;
	public static Item bronzeLegs;
	public static Item bronzeBoots;

	public static Item fuel;
	public static Item material;
	public static Item parts;
	
	public static Item dominoes;
	public static Item upgradeSpeed;
	public static Item upgradeEnergy;
	
	public static Item nuclearGrenade;
	public static Item nuclearGrenadeThrown;
	public static Item portableEnderChest;
	public static Item boiledEgg;
	public static Item ricecake;
	public static Item fishAndRicecake;
	
	public static Item recordPractice;
	public static Item recordArea51;
	public static Item recordNeighborhood;
	//public static Item recordJoe;
	public static Item blank;
	
	public static Item antimatter;
	
	public static Item lithiumIonBattery;
}
