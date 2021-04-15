package nc.itemblock.accelerator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockSuperElectromagnet extends ItemBlockNC {

	public ItemBlockSuperElectromagnet(Block block) {
		super(block, "Used to control the beams in particle accelerators.", "Requires " + Config.superElectromagnetRF + " RF/t to run continuously.");
	}
}
