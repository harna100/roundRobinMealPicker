package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

import java.util.Arrays;

public class DetailPlace {
	@Json(name = "formatted_address")
	public String formattedAdress;
	@Json(name = "formatted_phone_number")
	public String formmatedPhoneNumber;
	public Geometry geometry;
	public String icon;
	public String id;
	@Json(name = "international_phone_number")
	public String internationalPhoneNumber;
	public String name;
	@Json(name = "place_id")
	public String placeId;
	public double rating;
	public String reference;
	public String[] types;
	public String url;
	public String vicinity;
	public Review[] reviews;
	public Photo[] photos;
	@Json(name = "opening_hours")
	public Hours openingHours;

	@Override
	public String toString() {
		return "DetailPlace{" +
				"formattedAdress='" + formattedAdress + '\'' +
				", formmatedPhoneNumber='" + formmatedPhoneNumber + '\'' +
				", geometry=" + geometry +
				", icon='" + icon + '\'' +
				", id='" + id + '\'' +
				", internationalPhoneNumber='" + internationalPhoneNumber + '\'' +
				", name='" + name + '\'' +
				", placeId='" + placeId + '\'' +
				", rating=" + rating +
				", reference='" + reference + '\'' +
				", types=" + Arrays.toString(types) +
				", url='" + url + '\'' +
				", vicinity='" + vicinity + '\'' +
				", reviews=" + Arrays.toString(reviews) +
				", photos=" + Arrays.toString(photos) +
				", openingHours=" + openingHours +
				'}';
	}
}
