package io.impaul.harna100.roundrobinpicker.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import java.util.List;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.SharedPrefSingleton;
import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;
import io.impaul.harna100.roundrobinpicker.models.CardPlaceTouchHelper;
import io.impaul.harna100.roundrobinpicker.models.PlaceModel;
import io.impaul.harna100.roundrobinpicker.room.RoomSingleton;
import io.impaul.harna100.roundrobinpicker.room.models.Place;
import io.impaul.harna100.roundrobinpicker.room.models.User;


public class PlaceSelectionActivity extends AppCompatActivity {
	private static final String TAG = "PlaceSelectionActivity ";

	private RecyclerView rv_placeList;
	private FloatingActionButton fab_placeFinish;
	private PlaceListAdapter adapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_selection);

		getReferences();
		new GetPlacesTask().execute();
		setupFAB();
	}

	private void setupFAB() {
		fab_placeFinish.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(view.getContext(), MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	private void setupRecyclerView(List<Place> places) {
		rv_placeList.setLayoutManager(new LinearLayoutManager(this));
		adapter = new PlaceListAdapter(PlaceModel.ConvertFromRoom(places));
		rv_placeList.setAdapter(adapter);
		ItemTouchHelper.SimpleCallback callback = new CardPlaceTouchHelper(adapter);
		ItemTouchHelper helper = new ItemTouchHelper(callback);
		helper.attachToRecyclerView(rv_placeList);
	}

	private void getReferences() {
		rv_placeList = findViewById(R.id.rv_placeList);
		fab_placeFinish = findViewById(R.id.fab_placeFinish);
	}

	private class GetPlacesTask extends AsyncTask<Void, Void, List<Place>>{

		@Override
		protected void onPreExecute() {

		}

		@Override
		protected List<Place> doInBackground(Void... voids) {
			return RoomSingleton.GetDb(getBaseContext()).placeDao().getPlaces();
		}

		@Override
		protected void onPostExecute(List<Place> places) {
			setupRecyclerView(places);
		}
	}


}
