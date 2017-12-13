package io.impaul.harna100.roundrobinpicker.places.models;

public class Period {
	public PeriodTime close;
	public PeriodTime open;

	@Override
	public String toString() {
		return "Period{" +
				"close=" + close +
				", open=" + open +
				'}';
	}
}
