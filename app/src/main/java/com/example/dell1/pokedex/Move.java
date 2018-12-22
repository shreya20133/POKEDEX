package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Move implements Parcelable{
    String name;

    public Move(String name) {
        this.name = name;
    }

    protected Move(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Move> CREATOR = new Creator<Move>() {
        @Override
        public Move createFromParcel(Parcel in) {
            return new Move(in);
        }

        @Override
        public Move[] newArray(int size) {
            return new Move[size];
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
