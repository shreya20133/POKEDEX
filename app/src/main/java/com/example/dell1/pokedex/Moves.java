package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Moves implements Parcelable{
    Move move;

    public Moves(Move move) {
        this.move = move;
    }

    protected Moves(Parcel in) {
        move = in.readParcelable(Move.class.getClassLoader());
    }

    public static final Creator<Moves> CREATOR = new Creator<Moves>() {
        @Override
        public Moves createFromParcel(Parcel in) {
            return new Moves(in);
        }

        @Override
        public Moves[] newArray(int size) {
            return new Moves[size];
        }
    };

    public Move getMove() {
        return move;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(move, i);
    }
}
