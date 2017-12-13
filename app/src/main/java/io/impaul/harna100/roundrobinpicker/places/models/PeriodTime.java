package io.impaul.harna100.roundrobinpicker.places.models;

public class PeriodTime {
	public int day;
	public String time;

	@Override
	public String toString() {
		return "PeriodTime{" +
				"day=" + day +
				", time='" + time + '\'' +
				'}';
	}
}
