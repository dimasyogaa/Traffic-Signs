package com.yogadimas.trafficsigns.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Signs implements Parcelable {

    public static final Creator<Signs> CREATOR = new Creator<Signs>() {
        @Override
        public Signs createFromParcel(Parcel in) {
            return new Signs(in);
        }

        @Override
        public Signs[] newArray(int size) {
            return new Signs[size];
        }
    };

    private Integer photo;
    private String description;

    public Signs(Parcel in) {
        if (in.readByte() == 0) {
            photo = null;
        } else {
            photo = in.readInt();
        }
        description = in.readString();
    }

    public Signs() {

    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (photo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(photo);
        }
        parcel.writeString(description);
    }
}
