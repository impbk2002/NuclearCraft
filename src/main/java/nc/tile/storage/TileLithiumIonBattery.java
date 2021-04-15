package nc.tile.storage;

import nc.Config;

public class TileLithiumIonBattery extends TileStorage {

	public TileLithiumIonBattery() {
		super(Config.lithiumIonRF*10);
	}
}