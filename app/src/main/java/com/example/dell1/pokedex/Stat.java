package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Stat implements Parcelable{
    String name;

    public Stat(String name) {
        this.name = name;
    }

    protected Stat(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Stat> CREATOR = new Creator<Stat>() {
        @Override
        public Stat createFromParcel(Parcel in) {
            return new Stat(in);
        }

        @Override
        public Stat[] newArray(int size) {
            return new Stat[size];
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
