package nc.tile.machine;
 
import nc.Config;
import nc.block.fluid.NCFluids;
import nc.block.machine.BlockHeliumExtractor;
import nc.crafting.machine.HeliumExtractorRecipes;

public class TileHeliumExtractor extends TileMachineFluidOut {
	
	public TileHeliumExtractor() {
		super("heliumExtractor", 250000, 16000, 1, 1, false, true, 400, 16000, NCFluids.liquidHelium, 1000, Config.heliumExtractorSpeed, Config.heliumExtractorEfficiency, HeliumExtractorRecipes.instance());
	}
	
	public void updateEntity() {
		super.updateEntity();
		if (flag != flag1) {
			flag1 = flag;
			BlockHeliumExtractor.updateBlockState(flag, worldObj, xCoord, yCoord, zCoord);
		}
		markDirty();
	}
}