package io.impaul.harna100.roundrobinpicker.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.impaul.harna100.roundrobinpicker.room.models.Place;

@Dao
public interface PlaceDao {
	@Query("SELECT * FROM places")
	List<Place> getPlaces();

	@Query("SELECT * FROM places WHERE id=:placeId")
	Place getPlaceById(int placeId);

	@Query("SELECT * FROM places WHERE name LIKE :placeName")
	List<Place> getPlaceByName(String placeName);


	@Insert
	void insertPlaces(Place... places);

	@Delete
	void deletePlaces(Place... places);

	@Update
	void updatePlaces(Place... places);

	@Query("DELETE FROM places")
	void nukeTable();
}
