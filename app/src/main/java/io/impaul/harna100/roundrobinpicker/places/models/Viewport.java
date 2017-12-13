package io.impaul.harna100.roundrobinpicker.places.models;

public class Viewport {
	public Location northeast;
	public Location southwest;

	@Override
	public String toString() {
		return "Viewport{" +
				"northeast=" + northeast +
				", southwest=" + southwest +
				'}';
	}
}
