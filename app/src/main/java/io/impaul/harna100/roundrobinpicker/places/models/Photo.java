package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

public class Photo {
	public double height;
	public double width;
	@Json(name = "photo_reference")
	public String photoReference;
	@Json(name = "html_attributions")
	public String[] htmlAttributions;
}
