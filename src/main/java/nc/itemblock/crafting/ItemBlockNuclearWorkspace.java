package nc.itemblock.crafting;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockNuclearWorkspace extends ItemBlockNC {

	public ItemBlockNuclearWorkspace(Block block) {
		super(block, "An advanced 5x5 crafting table used", "to make many things in Config.", (Config.workspace ? "Currently enabled." : "Currently disabled."));
	}
}
