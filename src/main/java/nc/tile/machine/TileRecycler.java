package nc.tile.machine;
 
import nc.Config;
import nc.block.machine.BlockRecycler;
import nc.crafting.machine.RecyclerRecipes;

public class TileRecycler extends TileMachineBase {
	
	public TileRecycler() {
		super("fuelRecycler", 250000, 1, 4, true, true, 200, 8000, Config.recyclerSpeed, Config.recyclerEfficiency, RecyclerRecipes.instance());
	}
	
	public void updateEntity() {
		super.updateEntity();
		if (flag != flag1) {
			flag1 = flag;
			BlockRecycler.updateBlockState(flag, worldObj, xCoord, yCoord, zCoord);
		}
		markDirty();
	}
}