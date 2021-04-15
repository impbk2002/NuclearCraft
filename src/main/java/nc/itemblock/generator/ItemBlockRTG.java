package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockRTG extends ItemBlockNC {

	public ItemBlockRTG(Block block) {
		super(block, "Generates a constant stream of " + Config.RTGRF + " RF/t");
	}
}