package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

import java.util.Arrays;

public class NearbyRaw {
	@Json(name = "next_page_token")
	public String nextPageToken;
	public RoughPlace[] results;

	@Override
	public String toString() {
		return "NearbyRaw{" +
				"nextPageToken='" + nextPageToken + '\'' +
				", results=" + Arrays.toString(results) +
				'}';
	}
}
