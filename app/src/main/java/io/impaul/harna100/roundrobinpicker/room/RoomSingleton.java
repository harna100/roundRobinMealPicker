package io.impaul.harna100.roundrobinpicker.room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class RoomSingleton {
	private static RoomSingleton singleton;
	private AppDatabase db;

	private RoomSingleton(Context context){
		db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();

	}

	private static RoomSingleton GetInstance(Context context){
		if(singleton == null){
			singleton = new RoomSingleton(context);
		}
		return singleton;
	}

	public static AppDatabase GetDb(Context context){
		return GetInstance(context).db;
	}
}
