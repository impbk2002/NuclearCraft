package nc.block.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NCFluids {

	public static void preInitalize() {
		
		steam = new FluidSteam("steam");
		liquidHelium = new FluidHelium("liquidHelium");
		fusionPlasma = new FluidPlasma("fusionPlasma");
		denseSteam = new FluidDenseSteam("denseSteam");
		superdenseSteam = new FluidSuperdenseSteam("superdenseSteam");
		
		NCFluids.registerFluid(liquidHelium);
		NCFluids.registerFluid(fusionPlasma);
		NCFluids.registerFluid(steam);
		NCFluids.registerFluid(denseSteam);
		NCFluids.registerFluid(superdenseSteam);

	}
	
	public static void initialize() {}
	
	public static void postInitalize() {}
	
	public static void registerFluid(Fluid fluid, String fluidName) {

		if (!FluidRegistry.isFluidRegistered(fluidName)) {
			FluidRegistry.registerFluid(fluid);
		}
		fluid = FluidRegistry.getFluid(fluidName);
	}
	
	public static void registerFluid(Fluid fluid) {
		registerFluid(fluid, fluid.getName());
	}
	
	public static Fluid liquidHelium;
	public static Fluid fusionPlasma;
	public static Fluid steam;
	public static Fluid denseSteam;
	public static Fluid superdenseSteam;
}
