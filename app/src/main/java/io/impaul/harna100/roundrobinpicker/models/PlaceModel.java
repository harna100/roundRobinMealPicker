package io.impaul.harna100.roundrobinpicker.models;

import android.location.Location;

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
	private String photoPathOnDevice;
	private String hours;


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
		this.photoPathOnDevice = place.getPhotoPathOnDevice();
		this.phoneNumber = place.getPhoneNumber();
		this.hours = place.getHours();
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

	public int getPlaceId() {
		return placeId;
	}

	public String getDistance(){
		float[] results = new float[3];
		Location.distanceBetween(33.793339,-117.852069, getLatLng().latitude, getLatLng().longitude, results);
		double miles = results[0] * 0.00062137d;
		return Double.toString(miles).substring(0,4) + " mi";
	}

	public String getPhotoPathOnDevice() {
		return photoPathOnDevice;
	}

	public static List<PlaceModel> ConvertFromRoom(List<Place> places){
		ArrayList<PlaceModel> toReturn = new ArrayList<>();
		for (Place place : places) {
			toReturn.add(new PlaceModel(place));
		}
		return toReturn;
	}

	public String getHours() {
		return hours;
	}
}
