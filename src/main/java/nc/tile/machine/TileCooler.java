package nc.tile.machine;

import nc.Config;
import nc.block.machine.BlockCooler;
import nc.crafting.machine.CoolerRecipes;

public class TileCooler extends TileMachineBase {
	
	public TileCooler() {
		super("cooler", 250000, 1, 1, true, true, 20000, 2000000, Config.coolerSpeed, Config.coolerEfficiency, CoolerRecipes.instance());
	}
	
	public void updateEntity() {
		super.updateEntity();
		if (flag != flag1) {
			flag1 = flag;
			BlockCooler.updateBlockState(flag, worldObj, xCoord, yCoord, zCoord);
		}
		markDirty();
	}
}