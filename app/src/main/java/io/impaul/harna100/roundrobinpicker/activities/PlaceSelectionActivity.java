package io.impaul.harna100.roundrobinpicker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;
import io.impaul.harna100.roundrobinpicker.models.CardPlaceTouchHelper;


public class PlaceSelectionActivity extends AppCompatActivity {
	private RecyclerView rv_placeList;
	private FloatingActionButton fab_placeFinish;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_selection);

		getReferences();
		setupRecyclerView();
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

	private void setupRecyclerView() {
		rv_placeList.setLayoutManager(new LinearLayoutManager(this));
		PlaceListAdapter adapter = new PlaceListAdapter();
		rv_placeList.setAdapter(adapter);
		ItemTouchHelper.SimpleCallback callback = new CardPlaceTouchHelper(adapter);
		ItemTouchHelper helper = new ItemTouchHelper(callback);
		helper.attachToRecyclerView(rv_placeList);
	}

	private void getReferences() {
		rv_placeList = findViewById(R.id.rv_placeList);
		fab_placeFinish = findViewById(R.id.fab_placeFinish);
	}


}
