package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Ability2 implements Parcelable {

    String name;

    public Ability2(String name) {
        this.name = name;
    }

    protected Ability2(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Ability2> CREATOR = new Creator<Ability2>() {
        @Override
        public Ability2 createFromParcel(Parcel in) {
            return new Ability2(in);
        }

        @Override
        public Ability2[] newArray(int size) {
            return new Ability2[size];
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
