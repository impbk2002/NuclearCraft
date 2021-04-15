package nc.itemblock.nuke;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockEMP extends ItemBlockNC {

	public ItemBlockEMP(Block block) {
		super(block, "A devastating weapon which removes all RF from", "every block in a " + (int) (0.5D*Config.explosionRadius) + " block radius.");
	}
}