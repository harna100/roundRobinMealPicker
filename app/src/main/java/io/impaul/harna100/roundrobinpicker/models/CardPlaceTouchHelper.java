package io.impaul.harna100.roundrobinpicker.models;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;


public class CardPlaceTouchHelper extends ItemTouchHelper.SimpleCallback {
	private static final String TAG = "CardPlaceTouchHelper";

	private PlaceListAdapter placeAdapter;

	public CardPlaceTouchHelper(PlaceListAdapter placeAdapter){
		super(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
		this.placeAdapter = placeAdapter;
	}

	@Override
	public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
		return false;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
		if(direction == ItemTouchHelper.LEFT){
			Log.d(TAG, "onSwiped: Swiped left");
		}
		else if (direction == ItemTouchHelper.RIGHT){
			Log.d(TAG, "onSwiped: Swiped Right");
		}
		placeAdapter.remove(viewHolder.getAdapterPosition());
	}
}
