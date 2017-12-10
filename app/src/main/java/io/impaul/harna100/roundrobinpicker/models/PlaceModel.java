package io.impaul.harna100.roundrobinpicker.models;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Paul on 12/9/2017.
 */

public class PlaceModel {
	private String name;
	private String description;
	private String photoUrl;
	private LatLng latLng;
	private String address;

	public PlaceModel(String name, String description, String photoUrl, LatLng latLng, String address) {
		this.name = name;
		this.description = description;
		this.photoUrl = photoUrl;
		this.latLng = latLng;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public LatLng getLatLng() {
		return latLng;
	}

	public String getAddress() {
		return address;
	}
}
