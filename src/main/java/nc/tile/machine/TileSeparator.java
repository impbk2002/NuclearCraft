package nc.tile.machine;
 
import nc.Config;
import nc.block.machine.BlockSeparator;
import nc.crafting.machine.SeparatorRecipes;

public class TileSeparator extends TileMachineBase {
	
	public TileSeparator() {
		super("isotopeSeparator", 250000, 1, 2, true, true, 200, 8000, Config.separatorSpeed, Config.separatorEfficiency, SeparatorRecipes.instance());
	}
	
	public void updateEntity() {
		super.updateEntity();
		if (flag != flag1) {
			flag1 = flag;
			BlockSeparator.updateBlockState(flag, worldObj, xCoord, yCoord, zCoord);
		}
		markDirty();
	}
}