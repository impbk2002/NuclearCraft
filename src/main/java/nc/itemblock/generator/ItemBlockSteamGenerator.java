package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockSteamGenerator extends ItemBlockNC {

	public ItemBlockSteamGenerator(Block block) {
		super(block, "Generates RF from steam at a maximum", "rate of " + Config.steamRFUsageRate + " mB/t to " + Config.steamRFUsageRate*2 + " RF/t", "(2 RF per 1 mB of Steam)");
	}
}