package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

public class Hours {
	@Json(name = "open_now")
	public boolean openNow;

	public Period[] periods;
	@Json(name = "weekday_text")
	public String[] weekdayText;
}
