package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

import java.util.Arrays;

public class Photo {
	public double height;
	public double width;
	@Json(name = "photo_reference")
	public String photoReference;
	@Json(name = "html_attributions")
	public String[] htmlAttributions;

	@Override
	public String toString() {
		return "Photo{" +
				"height=" + height +
				", width=" + width +
				", photoReference='" + photoReference + '\'' +
				", htmlAttributions=" + Arrays.toString(htmlAttributions) +
				'}';
	}
}
