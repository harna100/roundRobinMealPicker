package io.impaul.harna100.roundrobinpicker.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import io.impaul.harna100.roundrobinpicker.room.models.Place;


public class PlaceModel {
	private String name;
	private String description;
	private String photoUrl;
	private LatLng latLng;
	private String address;
	private String phoneNumber;
	private int placeId;

	public PlaceModel(String name, String description, String photoUrl, LatLng latLng, String address) {
		this.name = name;
		this.description = description;
		this.photoUrl = photoUrl;
		this.latLng = latLng;
		this.address = address;
		this.placeId = -1;
	}

	public PlaceModel(Place place) {
		this.placeId = place.getId();
		this.name = place.getName();
		this.address = place.getAddress();
		this.photoUrl = place.getPhotoUrl();
		this.latLng = place.getLatLng();
		this.description = place.getDescription();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Place convertToRoom(){
		return Place.NewPlace(this);
	}

	public static List<PlaceModel> ConvertFromRoom(List<Place> places){
		ArrayList<PlaceModel> toReturn = new ArrayList<>();
		for (Place place : places) {
			toReturn.add(new PlaceModel(place));
		}
		return toReturn;
	}

	public int getPlaceId() {
		return placeId;
	}
}
