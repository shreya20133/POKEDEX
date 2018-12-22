package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Typename implements Parcelable{
    String name;

    public Typename(String name) {
        this.name = name;
    }

    protected Typename(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Typename> CREATOR = new Creator<Typename>() {
        @Override
        public Typename createFromParcel(Parcel in) {
            return new Typename(in);
        }

        @Override
        public Typename[] newArray(int size) {
            return new Typename[size];
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
