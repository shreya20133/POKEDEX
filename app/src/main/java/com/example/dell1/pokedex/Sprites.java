package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Sprites implements Parcelable{
    private String front_shiny;

    public Sprites(String front_shiny) {
        this.front_shiny = front_shiny;
    }

    protected Sprites(Parcel in) {
        front_shiny = in.readString();
    }

    public static final Creator<Sprites> CREATOR = new Creator<Sprites>() {
        @Override
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        @Override
        public Sprites[] newArray(int size) {
            return new Sprites[size];
        }
    };

    public String getFront_shiny() {
        return front_shiny;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(front_shiny);
    }
}
