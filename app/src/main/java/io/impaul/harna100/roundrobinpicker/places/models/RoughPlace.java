package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

import java.util.Arrays;

public class RoughPlace {
	public Geometry geometry;
	public String icon;
	public String id;
	public String name;
	@Json(name = "place_id")
	public String placeId;
	public String reference;
	public String scope;
	public String[] types;
	public String vicinity;

	@Override
	public String toString() {
		return "RoughPlace{" +
				"geometry=" + geometry +
				", icon='" + icon + '\'' +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", placeId='" + placeId + '\'' +
				", reference='" + reference + '\'' +
				", scope='" + scope + '\'' +
				", types=" + Arrays.toString(types) +
				", vicinity='" + vicinity + '\'' +
				'}';
	}
}
