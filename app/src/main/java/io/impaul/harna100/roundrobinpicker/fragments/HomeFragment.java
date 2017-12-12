package io.impaul.harna100.roundrobinpicker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.SharedPrefSingleton;
import io.impaul.harna100.roundrobinpicker.room.RoomSingleton;
import io.impaul.harna100.roundrobinpicker.room.models.Place;


public class HomeFragment extends MyFragment {
	private static final String TAG = "HomeFragment";

	public static HomeFragment NewInstance(){
		HomeFragment toReturn = new HomeFragment();



		return toReturn;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		List<Place> places = RoomSingleton.GetDb(getContext()).userPlacesDao().getPlacesFromUser(SharedPrefSingleton.GetUserId(getContext()));
		Log.d(TAG, "onCreateView: Logging places");
		for (Place place : places) {
			Log.d(TAG, "onCreateView: " + place);
		}
		Log.d(TAG, "onCreateView: Finished logging places");
		return v;
	}

	@Override
	public String getName() {
		return TAG;
	}
}
