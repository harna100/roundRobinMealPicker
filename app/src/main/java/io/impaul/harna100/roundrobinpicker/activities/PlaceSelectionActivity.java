package io.impaul.harna100.roundrobinpicker.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;


public class PlaceSelectionActivity extends AppCompatActivity {
	private RecyclerView rv_placeList;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_selection);

		getReferences();
		rv_placeList.setLayoutManager(new LinearLayoutManager(this));
		rv_placeList.setAdapter(new PlaceListAdapter());
	}

	private void getReferences() {
		rv_placeList = findViewById(R.id.rv_placeList);
	}


}
