package io.impaul.harna100.roundrobinpicker.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;
import io.impaul.harna100.roundrobinpicker.models.CardPlaceTouchHelper;


public class PlaceSelectionActivity extends AppCompatActivity {
	private RecyclerView rv_placeList;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_selection);

		getReferences();
		rv_placeList.setLayoutManager(new LinearLayoutManager(this));
		PlaceListAdapter adapter = new PlaceListAdapter();
		rv_placeList.setAdapter(adapter);
		ItemTouchHelper.SimpleCallback callback = new CardPlaceTouchHelper(adapter);
		ItemTouchHelper helper = new ItemTouchHelper(callback);
		helper.attachToRecyclerView(rv_placeList);

	}

	private void getReferences() {
		rv_placeList = findViewById(R.id.rv_placeList);
	}


}
