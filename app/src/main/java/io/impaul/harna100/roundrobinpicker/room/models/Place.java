package io.impaul.harna100.roundrobinpicker.room.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import io.impaul.harna100.roundrobinpicker.models.PlaceModel;

@Entity(tableName = "places")
public class Place {
	@PrimaryKey(autoGenerate = true)
	private int id;

	private String name;

	@ColumnInfo(name = "photo_url")
	private String photoUrl;

	@ColumnInfo(name = "phone_number")
	private String phoneNumber;

	private String address;

	@ColumnInfo(name = "description")
	private String description;

	private double lat;

	private double lng;

	@ColumnInfo(name = "did_choose")
	private boolean didChose;

	public Place(){

	}

	public Place(PlaceModel placeModel) {
		this.id = placeModel.getPlaceId();
		this.address = placeModel.getAddress();
		this.description = placeModel.getDescription();
		this.phoneNumber = placeModel.getPhoneNumber();
		this.photoUrl = placeModel.getPhotoUrl();
		this.lat = placeModel.getLatLng().latitude;
		this.lng = placeModel.getLatLng().longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public LatLng getLatLng(){
		return new LatLng(getLat(), getLng());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDidChose() {
		return didChose;
	}

	public void setDidChose(boolean didChose) {
		this.didChose = didChose;
	}
}
