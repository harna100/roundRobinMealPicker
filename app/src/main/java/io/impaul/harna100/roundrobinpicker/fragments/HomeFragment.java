package io.impaul.harna100.roundrobinpicker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.impaul.harna100.roundrobinpicker.R;


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

		return v;
	}

	@Override
	public String getName() {
		return TAG;
	}
}
