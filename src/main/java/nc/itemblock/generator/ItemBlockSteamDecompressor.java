package nc.itemblock.generator;

import nc.Config;
import nc.itemblock.ItemBlockNC;
import net.minecraft.block.Block;

public class ItemBlockSteamDecompressor extends ItemBlockNC {

	public ItemBlockSteamDecompressor(Block block) {
		super(block, "Takes in dense steam and decompresses it to", "form steam at a maximum rate of " + Config.steamDecompressRate + " mB/t of", "dense steam to " + Config.steamDecompressRate*1000 + " mB/t of steam.");
	}
}