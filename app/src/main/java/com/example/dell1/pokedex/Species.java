package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Species implements Parcelable{


    String name;

    public Species(String name) {
        this.name = name;
    }

    protected Species(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Species> CREATOR = new Creator<Species>() {
        @Override
        public Species createFromParcel(Parcel in) {
            return new Species(in);
        }

        @Override
        public Species[] newArray(int size) {
            return new Species[size];
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
