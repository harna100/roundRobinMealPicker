package io.impaul.harna100.roundrobinpicker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.models.PlaceModel;


public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.PlaceViewHolder> {
	private List<PlaceModel> places;

	public PlaceListAdapter(List<PlaceModel> places){
//		places = new ArrayList<>();
//		places.add(new PlaceModel("Place 5", "This is a description of place 5", "https://www.nationalgeographic.com/content/dam/animals/thumbs/rights-exempt/mammals/d/domestic-dog_thumb.jpg", new LatLng(42.306190, -83.714033), "Address 123 St. Orange CA 29866"));
//		places.add(new PlaceModel("Place 1", "This is a description of place 1", "https://b.zmtcdn.com/data/reviews_photos/e64/738e59a141f1a89a732e791d12546e64_1446414326.jpg", new LatLng(42.306190, -83.714033), "Address 123 St. Orange CA 29866"));
//		places.add(new PlaceModel("Place 2", "This is a description of place 2", "https://b.zmtcdn.com/data/reviews_photos/e64/738e59a141f1a89a732e791d12546e64_1446414326.jpg", new LatLng(42.306190, -83.714033), "Address 123 St. Orange CA 29866"));
//		places.add(new PlaceModel("Place 3", "This is a description of place 3", "https://b.zmtcdn.com/data/reviews_photos/e64/738e59a141f1a89a732e791d12546e64_1446414326.jpg", new LatLng(42.306190, -83.714033), "Address 123 St. Orange CA 29866"));
//		places.add(new PlaceModel("Place 4", "This is a description of place 4", "https://b.zmtcdn.com/data/reviews_photos/e64/738e59a141f1a89a732e791d12546e64_1446414326.jpg", new LatLng(42.306190, -83.714033), "Address 123 St. Orange CA 29866"));
		this.places = places;
	}


	@Override
	public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(R.layout.card_place,parent, false);

		return new PlaceViewHolder(v);
	}

	@Override
	public void onBindViewHolder(PlaceViewHolder holder, int position) {
		PlaceModel placeModel = places.get(position);

		holder.updateValues(placeModel);
	}

	@Override
	public int getItemCount() {
		return places.size();
	}

	public void remove(int adapterPosition) {
		places.remove(adapterPosition);
		notifyItemRemoved(adapterPosition);
	}

	public PlaceModel getItemAt(int idx){
		return places.get(idx);
	}

	class PlaceViewHolder extends RecyclerView.ViewHolder {
		private TextView tv_cardPlaceName;
		private TextView tv_cardPlaceAddress;
		private ImageView iv_cardPlacePhoto;

		public PlaceViewHolder(View itemView) {
			super(itemView);
			getReferences(itemView);
		}

		private void getReferences(View view) {
			tv_cardPlaceName = view.findViewById(R.id.tv_cardPlaceName);
			tv_cardPlaceAddress = view.findViewById(R.id.tv_cardPlaceAddress);
			iv_cardPlacePhoto = view.findViewById(R.id.iv_cardPlacePhoto);
		}

		public void updateValues(PlaceModel placeModel) {
			tv_cardPlaceName.setText(placeModel.getName());
			tv_cardPlaceAddress.setText(placeModel.getAddress());
			Picasso.with(iv_cardPlacePhoto.getContext())
					.load("file:" + placeModel.getPhotoPathOnDevice())
					.fit()
					.centerCrop()
					.into(iv_cardPlacePhoto);
		}
	}
}
