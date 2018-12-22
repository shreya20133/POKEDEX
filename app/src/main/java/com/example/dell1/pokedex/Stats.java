package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Stats implements Parcelable{

   private String effort,base_stat;
    private Stat stat;




    public Stats(String effort) {
        this.effort = effort;
    }

    public Stats(String effort, String base_stat, Stat stat) {
        this.effort = effort;
        this.base_stat = base_stat;
        this.stat = stat;
    }

    protected Stats(Parcel in) {
        effort = in.readString();
        base_stat = in.readString();
        stat = in.readParcelable(Stat.class.getClassLoader());
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public String getEffort() {
        return effort;
    }

    public String getBase_stat() {
        return base_stat;
    }

    public Stat getStat() {
        return stat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(effort);
        parcel.writeString(base_stat);
        parcel.writeParcelable(stat, i);
    }
}
