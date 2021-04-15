package nc.itemblock.storage;

import nc.Config;
import net.minecraft.block.Block;

public class ItemBlockVoltaicPile extends ItemBlockEnergyStorage {

	public ItemBlockVoltaicPile(Block block) {
		super(block, Config.voltaicPileRF);
	}
}
