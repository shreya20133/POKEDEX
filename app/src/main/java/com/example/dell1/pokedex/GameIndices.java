package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class GameIndices implements Parcelable{

    String game_index;
    Versions version;

    public GameIndices(String game_index, Versions version) {
        this.game_index = game_index;
        this.version = version;
    }

    protected GameIndices(Parcel in) {
        game_index = in.readString();
        version = in.readParcelable(Versions.class.getClassLoader());
    }

    public static final Creator<GameIndices> CREATOR = new Creator<GameIndices>() {
        @Override
        public GameIndices createFromParcel(Parcel in) {
            return new GameIndices(in);
        }

        @Override
        public GameIndices[] newArray(int size) {
            return new GameIndices[size];
        }
    };

    public String getGame_index() {
        return game_index;
    }

    public Versions getVersion() {
        return version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(game_index);
        parcel.writeParcelable(version, i);
    }
}
