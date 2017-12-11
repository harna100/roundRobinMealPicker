package io.impaul.harna100.roundrobinpicker.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import io.impaul.harna100.roundrobinpicker.room.daos.PlaceDao;
import io.impaul.harna100.roundrobinpicker.room.daos.UserDao;
import io.impaul.harna100.roundrobinpicker.room.daos.UserPlacesDao;
import io.impaul.harna100.roundrobinpicker.room.models.Place;
import io.impaul.harna100.roundrobinpicker.room.models.User;
import io.impaul.harna100.roundrobinpicker.room.models.UserPlaces;


@Database(entities = {User.class, Place.class, UserPlaces.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
	public abstract UserDao userDao();
	public abstract PlaceDao placeDao();
	public abstract UserPlacesDao userPlacesDao();
}
