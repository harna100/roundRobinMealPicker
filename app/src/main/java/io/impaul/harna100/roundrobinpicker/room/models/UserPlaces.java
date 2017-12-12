package io.impaul.harna100.roundrobinpicker.room.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_places",
	foreignKeys = {
		@ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id"),
		@ForeignKey(entity = Place.class, parentColumns = "id", childColumns = "place_id")
	},
	indices = {
		@Index("user_id"),
		@Index("place_id")
	}
)
public class UserPlaces {
	@PrimaryKey(autoGenerate = true)
	private int id;

	@ColumnInfo(name = "user_id")
	private int userId;


	@ColumnInfo(name = "place_id")
	private int placeId;

	@ColumnInfo(name = "did_choose")
	private boolean didChoose;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public boolean isDidChoose() {
		return didChoose;
	}

	public void setDidChoose(boolean didChoose) {
		this.didChoose = didChoose;
	}

	@Override
	public String toString() {
		return "UserPlaces{" +
				"id=" + id +
				", userId=" + userId +
				", placeId=" + placeId +
				", didChoose=" + didChoose +
				'}';
	}
}
