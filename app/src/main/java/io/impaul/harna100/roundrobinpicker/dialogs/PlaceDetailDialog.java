package io.impaul.harna100.roundrobinpicker.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.models.PlaceModel;


public class PlaceDetailDialog extends Dialog {
	private PlaceModel place;
	private TextView tv_dialogPlaceName;
	private TextView tv_dialogPlaceAddress;
	private TextView tv_dialogHours;
	private TextView tv_dialogDistance;
	private TextView tv_dialogPhoneNumber;
	private Button btn_dialogDismiss;
	private ImageView iv_dialogPlacePhoto;

	public PlaceDetailDialog(@NonNull Context context, PlaceModel place) {
		super(context);
		this.place = place;

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_card_details);
		getReferences();
		setupViews();
		setListeners();
	}

	private void getReferences() {
		tv_dialogPlaceName = findViewById(R.id.tv_dialogPlaceName);
		tv_dialogPlaceAddress = findViewById(R.id.tv_dialogPlaceAddress);
		tv_dialogHours = findViewById(R.id.tv_dialogHours);
		tv_dialogDistance = findViewById(R.id.tv_dialogDistance);
		tv_dialogPhoneNumber = findViewById(R.id.tv_dialogPhoneNumber);
		iv_dialogPlacePhoto = findViewById(R.id.iv_dialogPlacePhoto);
		btn_dialogDismiss = findViewById(R.id.btn_dialogDismiss);
	}

	private void setupViews(){
		tv_dialogDistance.setText(place.getDistance());
		tv_dialogHours.setText(place.getHours());
		tv_dialogPhoneNumber.setText(place.getPhoneNumber());
		tv_dialogPlaceName.setText(place.getName());
		tv_dialogPlaceAddress.setText(place.getAddress());
		Picasso.with(getContext())
				.load("file:" + place.getPhotoPathOnDevice())
				.fit()
				.centerCrop()
				.into(iv_dialogPlacePhoto);


	}

	private void setListeners(){
		setListenerDismissButton();
	}

	private void setListenerDismissButton(){
		btn_dialogDismiss.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				PlaceDetailDialog.this.dismiss();
			}
		});
	}


}
