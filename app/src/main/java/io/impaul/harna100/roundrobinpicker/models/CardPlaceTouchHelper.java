package io.impaul.harna100.roundrobinpicker.models;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import io.impaul.harna100.roundrobinpicker.SharedPrefSingleton;
import io.impaul.harna100.roundrobinpicker.adapters.PlaceListAdapter;
import io.impaul.harna100.roundrobinpicker.room.RoomSingleton;
import io.impaul.harna100.roundrobinpicker.room.models.Place;
import io.impaul.harna100.roundrobinpicker.room.models.UserPlaces;


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
		PlaceModel viewPlace = placeAdapter.getItemAt(viewHolder.getAdapterPosition());
		Place roomPlace = new Place(viewPlace);
		UserPlaces toInsert = new UserPlaces();
		toInsert.setPlaceId(roomPlace.getId());
		toInsert.setUserId(SharedPrefSingleton.GetUserId(viewHolder.itemView.getContext()));
		if(direction == ItemTouchHelper.LEFT){
			toInsert.setDidChoose(false);
		}
		else if (direction == ItemTouchHelper.RIGHT){
			toInsert.setDidChoose(true);
		}
		new AddToUserPlacesTasks(viewHolder.itemView.getContext()).execute(toInsert);
		placeAdapter.remove(viewHolder.getAdapterPosition());
	}

	private class AddToUserPlacesTasks extends AsyncTask<UserPlaces, Void, Void> {

		private Context context;

		public AddToUserPlacesTasks(Context context) {
			this.context = context;
		}

		@Override
		protected Void doInBackground(UserPlaces... places) {
			if(places.length != 1){
				return null;
			}
			RoomSingleton.GetDb(this.context).userPlacesDao().insertPlaces(places);
			return null;
		}
	}
}
