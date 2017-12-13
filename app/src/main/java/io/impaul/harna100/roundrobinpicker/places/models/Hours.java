package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

import java.util.Arrays;

public class Hours {
	@Json(name = "open_now")
	public boolean openNow;

	public Period[] periods;
	@Json(name = "weekday_text")
	public String[] weekdayText;

	@Override
	public String toString() {
		return "Hours{" +
				"openNow=" + openNow +
				", periods=" + Arrays.toString(periods) +
				", weekdayText=" + Arrays.toString(weekdayText) +
				'}';
	}
}
