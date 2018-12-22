package com.example.dell1.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Types;
import java.util.ArrayList;

class APIResult implements Parcelable{

    String name;
    private Integer weight,height,id,order,base_experience;
    private ArrayList<Ability> abilities;
    private ArrayList<Stats> stats;
    private ArrayList<Moves> moves;
    private Sprites sprites;
    private Species species;
    private ArrayList<GameIndices> game_indices;
    private ArrayList<TYpes> types;


    public APIResult(String name, Integer weight, Integer height, Integer id, Integer order, Integer base_experience, ArrayList<Ability> abilities, ArrayList<Stats> stats, ArrayList<Moves> moves,Sprites sprites, Species species, ArrayList<GameIndices> game_indices, ArrayList<TYpes> types) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.id = id;
        this.order = order;
        this.base_experience = base_experience;
        this.abilities = abilities;
        this.stats = stats;
        this.moves = moves;
        this.sprites=sprites;
        this.species = species;
        this.game_indices = game_indices;
        this.types = types;
    }

    protected APIResult(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            weight = null;
        } else {
            weight = in.readInt();
        }
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            order = null;
        } else {
            order = in.readInt();
        }
        if (in.readByte() == 0) {
            base_experience = null;
        } else {
            base_experience = in.readInt();
        }
        abilities = in.createTypedArrayList(Ability.CREATOR);
        stats = in.createTypedArrayList(Stats.CREATOR);
        moves = in.createTypedArrayList(Moves.CREATOR);
        sprites = in.readParcelable(Sprites.class.getClassLoader());
        species = in.readParcelable(Species.class.getClassLoader());
        game_indices = in.createTypedArrayList(GameIndices.CREATOR);
        types = in.createTypedArrayList(TYpes.CREATOR);
    }

    public static final Creator<APIResult> CREATOR = new Creator<APIResult>() {
        @Override
        public APIResult createFromParcel(Parcel in) {
            return new APIResult(in);
        }

        @Override
        public APIResult[] newArray(int size) {
            return new APIResult[size];
        }
    };

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder() {
        return order;
    }

    public Integer getBase_experience() {
        return base_experience;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public Species getSpecies() {
        return species;
    }

    public ArrayList<GameIndices> getGame_indices() {
        return game_indices;
    }

    public ArrayList<TYpes> getTypes() {
        return types;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        if (weight == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(weight);
        }
        if (height == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(height);
        }
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        if (order == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(order);
        }
        if (base_experience == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(base_experience);
        }
        parcel.writeTypedList(abilities);
        parcel.writeTypedList(stats);
        parcel.writeTypedList(moves);
        parcel.writeParcelable(sprites, i);
        parcel.writeParcelable(species, i);
        parcel.writeTypedList(game_indices);
        parcel.writeTypedList(types);
    }
}
