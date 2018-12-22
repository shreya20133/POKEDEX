package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Ability implements Parcelable{

    private String slot;
    private Ability2 ability;

    public Ability(String slot, Ability2 ability) {
        this.slot = slot;
        this.ability = ability;
    }

    protected Ability(Parcel in) {
        slot = in.readString();
        ability = in.readParcelable(Ability2.class.getClassLoader());
    }

    public static final Creator<Ability> CREATOR = new Creator<Ability>() {
        @Override
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };

    public String getSlot() {
        return slot;
    }

    public Ability2 getAbility() {
        return ability;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(slot);
        parcel.writeParcelable(ability, i);
    }
}
