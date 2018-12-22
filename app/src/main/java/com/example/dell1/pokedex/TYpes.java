package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class TYpes implements Parcelable{

    Integer slot;
    Typename type;

    public TYpes(Integer slot, Typename type) {
        this.slot = slot;
        this.type = type;
    }

    protected TYpes(Parcel in) {
        if (in.readByte() == 0) {
            slot = null;
        } else {
            slot = in.readInt();
        }
        type = in.readParcelable(Typename.class.getClassLoader());
    }

    public static final Creator<TYpes> CREATOR = new Creator<TYpes>() {
        @Override
        public TYpes createFromParcel(Parcel in) {
            return new TYpes(in);
        }

        @Override
        public TYpes[] newArray(int size) {
            return new TYpes[size];
        }
    };

    public Integer getSlot() {
        return slot;
    }

    public Typename getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (slot == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(slot);
        }
        parcel.writeParcelable(type, i);
    }
}
