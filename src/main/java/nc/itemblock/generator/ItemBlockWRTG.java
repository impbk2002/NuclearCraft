package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockWRTG extends ItemBlockNC {

	public ItemBlockWRTG(Block block) {
		super(block, "Generates a constant stream of " + Config.WRTGRF + " RF/t");
	}
}