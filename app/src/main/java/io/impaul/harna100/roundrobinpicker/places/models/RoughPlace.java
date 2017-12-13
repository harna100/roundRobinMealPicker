package io.impaul.harna100.roundrobinpicker.places.models;

import com.squareup.moshi.Json;

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
}
