package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Versions implements Parcelable{

    String name;

    public Versions(String name) {
        this.name = name;
    }

    protected Versions(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Versions> CREATOR = new Creator<Versions>() {
        @Override
        public Versions createFromParcel(Parcel in) {
            return new Versions(in);
        }

        @Override
        public Versions[] newArray(int size) {
            return new Versions[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
