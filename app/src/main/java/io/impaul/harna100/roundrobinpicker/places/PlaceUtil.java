package io.impaul.harna100.roundrobinpicker.places;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.impaul.harna100.roundrobinpicker.places.models.DetailPlace;
import io.impaul.harna100.roundrobinpicker.places.models.DetailRaw;
import io.impaul.harna100.roundrobinpicker.places.models.NearbyRaw;
import io.impaul.harna100.roundrobinpicker.places.models.RoughPlace;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlaceUtil {

	public static final String TAG = "PlaceUtil";

	private String key;

	public PlaceUtil(String key){
		this.key = key;
	}

	public List<DetailPlace> getNearByDetailPlaces(){
		return null;
	}

	public List<RoughPlace> getNearyByRoughPlaces(){
		return null;
	}

	public NearbyRawTask getNearbyRaw(String distance, String locationInLatLng){
		return new NearbyRawTask(distance, locationInLatLng);
	}

	protected String GetNearbyUrl(String distance, String locationInLatLng){
		String baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
//		String key = "AIzaSyCcEY0R4SXHcTwT7Y76pO2T8XbB7m1o10U";
//		String location = "33.793339,-117.852069";
		String[] location = {"location", locationInLatLng};
		String[] radius = {"radius", distance};
		String[] keyword = {"keyword", "restaurant"};
		String[] key = {"key", this.key};

		return GetUrl(baseUrl, key, location, radius, keyword);
	}

	private String GetUrl(String baseUrl , String[]... queryPairs){
		HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
		urlBuilder.addQueryParameter("key", key);
		for (String[] queryPair : queryPairs) {
			urlBuilder.addQueryParameter(queryPair[0], queryPair[1]);
		}
		return urlBuilder.build().toString();
	}

	protected String GetDetailUrl(String placeId){
		String baseUrl = "https://maps.googleapis.com/maps/api/place/details/json";

		String[] place = {"placeid", placeId};
		return GetUrl(baseUrl, place);
	}

	public static Response GetResponse(Request request){
		try {
			return new OkHttpClient().newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JsonAdapter GetJsonAdapter(Class classToGet){
		Moshi moshi = new Moshi.Builder().build();
		return moshi.adapter(classToGet);
	}

	public class NearbyRawTask extends AsyncTask<Void, Void, List<NearbyRaw>>{

		private String distance;
		private String locationInLatLng;

		public NearbyRawTask(String distance, String locationInLatLng) {
			this.distance = distance;
			this.locationInLatLng = locationInLatLng;
		}

		@Override
		protected List<NearbyRaw> doInBackground(Void... voids) {
			Request request = new Request.Builder()
//					.url(GetNearbyUrl("1000", "33.793339,-117.852069"))
					.url(GetNearbyUrl(distance, locationInLatLng))
					.get()
					.build();
			Response response = GetResponse(request);

			if(response == null){
				Log.e(TAG, "doInBackground: ", new Exception("Response was null"));
				return null;
			}

			JsonAdapter<NearbyRaw> jsonAdapter = GetJsonAdapter(NearbyRaw.class);

			try {
				ArrayList<NearbyRaw> toReturn = new ArrayList<>();
				toReturn.add(jsonAdapter.fromJson(response.body().source()));
				return toReturn;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<NearbyRaw> nearbyRaw) {
			if(nearbyRaw == null){
				Log.e(TAG, "onPostExecute: ", new Exception("NearbyRaw was null"));
				return;
			}
			new NearbyDetailTask().execute(nearbyRaw.toArray(new NearbyRaw[nearbyRaw.size()]));
		}
	}
	public class NearbyDetailTask extends AsyncTask<NearbyRaw, Void, List<DetailPlace>>{

		@Override
		protected List<DetailPlace> doInBackground(NearbyRaw... nearbyRaws) {
			List<DetailPlace> toReturn = new ArrayList<>();
			for (NearbyRaw nearbyRaw : nearbyRaws) {
				for (RoughPlace result : nearbyRaw.results) {
					Request request = new Request.Builder()
							.url(GetDetailUrl(result.placeId))
							.get()
							.build();
					Response response = GetResponse(request);

					JsonAdapter<DetailRaw> jsonAdapter = GetJsonAdapter(DetailRaw.class);
					try {
						toReturn.add(jsonAdapter.fromJson(response.body().source()).result);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			return toReturn;
		}

		@Override
		protected void onPostExecute(List<DetailPlace> detailPlaces) {
			for (DetailPlace detailPlace : detailPlaces) {
				Log.d(TAG, "onPostExecute: Detail Place: " + detailPlace);
			}
		}
	}

}
