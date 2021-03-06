package me.BL19.HomeLink.HAP.Devices;

import java.util.concurrent.CompletableFuture;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Lightbulb;

public class Light implements Lightbulb {

	
	private boolean powerState = false;
	private HomekitCharacteristicChangeCallback subscribeCallback = null;
	
	public int id;
	public String name;
	public String SRNumber;
	public String model;
	public String manufacturer;
	
	public Light(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public CompletableFuture<Boolean> getLightbulbPowerState() {
		return CompletableFuture.completedFuture(powerState);
	}

	public CompletableFuture<Void> setLightbulbPowerState(boolean powerState)
			throws Exception {
		this.powerState = powerState;
		if (subscribeCallback != null) {
			subscribeCallback.changed();
		}
		System.out.println(name + " is now "+(powerState ? "on" : "off"));
		return CompletableFuture.completedFuture(null);
	}

	public void subscribeLightbulbPowerState(
			HomekitCharacteristicChangeCallback callback) {
		this.subscribeCallback = callback;
	}

	public void unsubscribeLightbulbPowerState() {
		this.subscribeCallback = null;
	}

	public int getId() {
		return id;
	}
	public String getLabel() {
		return name;
	}
	public void identify() {
		
	}
	public String getSerialNumber() {
		return SRNumber;
	}
	public String getModel() {
		return model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	
}
