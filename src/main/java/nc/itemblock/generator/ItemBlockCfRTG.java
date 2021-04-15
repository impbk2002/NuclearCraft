package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockCfRTG extends ItemBlockNC {

	public ItemBlockCfRTG(Block block) {
		super(block, "Generates a constant stream of " + Config.CfRTGRF + " RF/t");
	}
}