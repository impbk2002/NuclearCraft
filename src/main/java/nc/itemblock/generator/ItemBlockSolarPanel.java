package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockSolarPanel extends ItemBlockNC {

	public ItemBlockSolarPanel(Block block) {
		super(block, "Generates a constant stream", "of " + Config.solarRF + " RF/t during the day,", "and generates less during dawn, dusk and night.");
	}
}