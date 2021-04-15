package nc.tile.machine;
 
import nc.Config;
import nc.block.machine.BlockElectricCrusher;
import nc.crafting.machine.CrusherRecipes;

public class TileElectricCrusher extends TileMachineBase {
	
	public TileElectricCrusher() {
		super("electricCrusher", 250000, 1, 1, true, true, 200, 8000, Config.electricCrusherCrushSpeed, Config.electricCrusherCrushEfficiency, CrusherRecipes.instance());
	}
	
	public void updateEntity() {
		super.updateEntity();
		if (flag != flag1) {
			flag1 = flag;
			BlockElectricCrusher.updateBlockState(flag, worldObj, xCoord, yCoord, zCoord);
		}
		markDirty();
	}
}