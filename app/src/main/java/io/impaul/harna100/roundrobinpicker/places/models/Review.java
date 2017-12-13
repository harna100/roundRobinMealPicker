package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

public class Review {
	@Json(name = "author_name")
	public String authorName;
	@Json(name = "author_url")
	public String authorUrl;
	public String language;
	@Json(name = "profile_photo_url")
	public String profilePhotoUrl;
	public double rating;
	@Json(name = "relative_time_description")
	public String relativeTimeDescription;
	public String text;
	public double time;
}
