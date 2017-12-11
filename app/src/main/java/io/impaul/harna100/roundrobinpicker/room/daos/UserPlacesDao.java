package io.impaul.harna100.roundrobinpicker.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import io.impaul.harna100.roundrobinpicker.room.models.Place;
import io.impaul.harna100.roundrobinpicker.room.models.User;

@Dao
public interface UserPlacesDao {
	@Query("SELECT * FROM (SELECT * FROM user_places WHERE user_id = :userId) AS user_places_trimmed " +
			"JOIN places ON places.id = user_places_trimmed.place_id")
	List<Place> getPlacesFromUser(int userId);

	@Query("SELECT * FROM (SELECT * FROM user_places WHERE place_id = :placeId) AS user_places_trimmed " +
			"JOIN users ON users.id = user_places_trimmed.user_id ")
	List<User> getUsersFromPlace(int placeId);

}
