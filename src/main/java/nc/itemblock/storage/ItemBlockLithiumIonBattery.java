package nc.itemblock.storage;

import nc.Config;
import net.minecraft.block.Block;

public class ItemBlockLithiumIonBattery extends ItemBlockEnergyStorage {

	public ItemBlockLithiumIonBattery(Block block) {
		super(block, Config.lithiumIonRF*10);
	}
}
