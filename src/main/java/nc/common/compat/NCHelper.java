package nc.common.compat;

import cpw.mods.fml.common.event.FMLInterModComms;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class NCHelper {
	
	public static void preInitalize() {
	}
	
	public static void initialize() {}
	
	public static void postInitalize() {}

	

    /**
     * Copy of the original Helper Class of Thermal Expansion, just to make sure it works even when other Mods include TE-APIs
     */
    public static class ThermalExpansion {
        public static void addFurnaceRecipe(int energy, ItemStack input, ItemStack output) {
        	if (input == null || output == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            FMLInterModComms.sendMessage("ThermalExpansion", "FurnaceRecipe", toSend);
        }

        public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput) {
            addPulverizerRecipe(energy, input, primaryOutput, null, 0);
        }

        public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput) {
            addPulverizerRecipe(energy, input, primaryOutput, secondaryOutput, 100);
        }

        public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
            if (input == null || primaryOutput == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("primaryOutput", new NBTTagCompound());
            toSend.setTag("secondaryOutput", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
            if (secondaryOutput != null) secondaryOutput.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
            toSend.setInteger("secondaryChance", secondaryChance);
            FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", toSend);
        }

        public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput) {
            addSawmillRecipe(energy, input, primaryOutput, null, 0);
        }

        public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput) {
            addSawmillRecipe(energy, input, primaryOutput, secondaryOutput, 100);
        }

        public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
            if (input == null || primaryOutput == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("primaryOutput", new NBTTagCompound());
            toSend.setTag("secondaryOutput", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
            if (secondaryOutput != null) secondaryOutput.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
            toSend.setInteger("secondaryChance", secondaryChance);
            FMLInterModComms.sendMessage("ThermalExpansion", "SawmillRecipe", toSend);
        }

        public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput) {
            addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput, null, 0);
        }

        public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput) {
            addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, 100);
        }

        public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
            if (primaryInput == null || secondaryInput == null || primaryOutput == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("primaryInput", new NBTTagCompound());
            toSend.setTag("secondaryInput", new NBTTagCompound());
            toSend.setTag("primaryOutput", new NBTTagCompound());
            toSend.setTag("secondaryOutput", new NBTTagCompound());
            primaryInput.writeToNBT(toSend.getCompoundTag("primaryInput"));
            secondaryInput.writeToNBT(toSend.getCompoundTag("secondaryInput"));
            primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
            if (secondaryOutput != null) secondaryOutput.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
            toSend.setInteger("secondaryChance", secondaryChance);
            FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", toSend);
        }

        public static void addSmelterBlastOre(String OreDict) {
        	if(!OreDictionary.doesOreNameExist(OreDict)) {
        		return;
        	}
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setString("oreType", OreDict);
            FMLInterModComms.sendMessage("ThermalExpansion", "SmelterBlastOreType", toSend);
        }

        public static void addCrucibleRecipe(int energy, ItemStack input, FluidStack output) {
            if (input == null || output == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            FMLInterModComms.sendMessage("ThermalExpansion", "CrucibleRecipe", toSend);
        }

        public static void addTransposerFill(int energy, ItemStack input, ItemStack output, FluidStack fluid, boolean reversible) {
            if (input == null || output == null || fluid == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            toSend.setTag("fluid", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            toSend.setBoolean("reversible", reversible);
            fluid.writeToNBT(toSend.getCompoundTag("fluid"));
            FMLInterModComms.sendMessage("ThermalExpansion", "TransposerFillRecipe", toSend);
        }

        public static void addTransposerExtract(int energy, ItemStack input, ItemStack output, FluidStack fluid, int chance, boolean reversible) {
            if (input == null || output == null || fluid == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setInteger("energy", energy);
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            toSend.setTag("fluid", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            toSend.setBoolean("reversible", reversible);
            toSend.setInteger("chance", chance);
            fluid.writeToNBT(toSend.getCompoundTag("fluid"));
            FMLInterModComms.sendMessage("ThermalExpansion", "TransposerExtractRecipe", toSend);
        }

        public static void addMagmaticFuel(String fluidName, int energy) {
        	if(!FluidRegistry.isFluidRegistered(fluidName)) {
        		return;
        	}
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setString("fluidName", fluidName);
            toSend.setInteger("energy", energy);
            FMLInterModComms.sendMessage("ThermalExpansion", "MagmaticFuel", toSend);
        }

        public static void addCompressionFuel(String fluidName, int energy) {
        	if(!FluidRegistry.isFluidRegistered(fluidName)) {
        		return;
        	}
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setString("fluidName", fluidName);
            toSend.setInteger("energy", energy);
            FMLInterModComms.sendMessage("ThermalExpansion", "CompressionFuel", toSend);
        }

        public static void addCoolant(String fluidName, int energy) {
        	if(!FluidRegistry.isFluidRegistered(fluidName)) {
        		return;
        	}
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setString("fluidName", fluidName);
            toSend.setInteger("energy", energy);
            FMLInterModComms.sendMessage("ThermalExpansion", "Coolant", toSend);
        }
    }
 
    public static class Mekanism {
        public static void addCrusherRecipe(ItemStack input, ItemStack output) {
            if (input == null || output == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            FMLInterModComms.sendMessage("Mekanism", "CrusherRecipe", toSend);
        }
        
        public static void addEnrichmentRecipe(ItemStack input, ItemStack output) {
            if (input == null || output == null) return;
            NBTTagCompound toSend = new NBTTagCompound();
            toSend.setTag("input", new NBTTagCompound());
            toSend.setTag("output", new NBTTagCompound());
            input.writeToNBT(toSend.getCompoundTag("input"));
            output.writeToNBT(toSend.getCompoundTag("output"));
            FMLInterModComms.sendMessage("Mekanism", "EnrichmentChamberRecipe", toSend);
        }
    }

    public static class IndustrialCraft2 {
    	public static void addCentrifugeRecipe(ItemStack input, int amount, int minHeat, ItemStack... output) {
    		addCentrifugeRecipe(new RecipeInputItemStack(input, amount), minHeat, output);
    	}

    	public static void addCentrifugeRecipe(String input, int amount, int minHeat, ItemStack... output) {
    		addCentrifugeRecipe(new RecipeInputOreDict(input, amount), minHeat, output);
    	}

    	public static void addCentrifugeRecipe(IRecipeInput input, int minHeat, ItemStack... output) {
    		NBTTagCompound metadata = new NBTTagCompound();
    		metadata.setInteger("minHeat", minHeat);
    		Recipes.centrifuge.addRecipe(input, metadata, output);
    	}
    	
    	public static void addBottleRecipe(ItemStack container, int conamount, ItemStack fill, int fillamount, ItemStack output) {
    		addBottleRecipe(new RecipeInputItemStack(container, conamount), new RecipeInputItemStack(fill, fillamount), output);
    	}
    	
    	public static void addBottleRecipe(ItemStack container, ItemStack fill, int fillamount, ItemStack output) {
    		addBottleRecipe(new RecipeInputItemStack(container, 1), new RecipeInputItemStack(fill, fillamount), output);
    	}
    	
    	public static void addBottleRecipe(ItemStack container, int conamount, ItemStack fill, ItemStack output) {
    		addBottleRecipe(new RecipeInputItemStack(container, conamount), new RecipeInputItemStack(fill, 1), output);
    	}
    	
    	public static void addBottleRecipe(ItemStack container, ItemStack fill, ItemStack output) {
    		addBottleRecipe(new RecipeInputItemStack(container, 1), new RecipeInputItemStack(fill, 1), output);
    	}
    	
    	public static void addBottleRecipe(IRecipeInput container, IRecipeInput fill, ItemStack output) {
    		Recipes.cannerBottle.addRecipe(container, fill, output);
    	}
    	
    	public static void addCompressorRecipe(ItemStack input, int amount, ItemStack output) {
    		addCompressorRecipe(new RecipeInputItemStack(input, amount), output);
    	}

    	public static void addCompressorRecipe(String input, int amount, ItemStack output) {
    		addCompressorRecipe(new RecipeInputOreDict(input, amount), output);
    	}

    	public static void addCompressorRecipe(IRecipeInput input, ItemStack output) {
    		Recipes.compressor.addRecipe(input, null, new ItemStack[] { output });
    	}
    	
    	public static void addMFAmplifier(ItemStack input, int amount, int amplification) {
    		addMFAmplifier(new ic2.api.recipe.RecipeInputItemStack(input, amount), amplification);
    	}

    	public static void addMFAmplifier(String input, int amount, int amplification) {
    		addMFAmplifier(new RecipeInputOreDict(input, amount), amplification);
    	}

    	public static void addMFAmplifier(IRecipeInput input, int amplification) {
    		NBTTagCompound metadata = new NBTTagCompound();
    		metadata.setInteger("amplification", amplification);
    		Recipes.matterAmplifier.addRecipe(input, metadata, new ItemStack[0]);
    	}
    	
    	public static void addMaceratorRecipe(ItemStack input, int amount, ItemStack output) {
    		addMaceratorRecipe(new RecipeInputItemStack(input, amount), output);
    	}

    	public static void addMaceratorRecipe(String input, int amount, ItemStack output) {
    		addMaceratorRecipe(new RecipeInputOreDict(input, amount), output);
    	}

    	public static void addMaceratorRecipe(IRecipeInput input, ItemStack output) {
    		Recipes.macerator.addRecipe(input, null, new ItemStack[] { output });
    	}
    }
}
