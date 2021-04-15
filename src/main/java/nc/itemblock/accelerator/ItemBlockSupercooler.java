package nc.itemblock.accelerator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockSupercooler extends ItemBlockNC {

	public ItemBlockSupercooler(Block block) {
		super(block, "Used in the construction of particle accelerators to", "cool the superconducting electromagnets. Requires", Config.electromagnetHe + " mB of Liquid Helium per second to run continuously.");
	}
}
