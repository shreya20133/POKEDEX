package com.example.dell1.pokedex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        APIResult result=getIntent().getParcelableExtra("APIRESULT");
        textView=findViewById(R.id.info_tv);
        Context ctx=getApplicationContext();
        textView.append(ctx.getString(R.string.pokemonname)+"  "+result.getName()+"\n");
        textView.append(ctx.getString(R.string.pokemonweight)+"  "+result.getWeight()+"\n");
        textView.append(ctx.getString(R.string.pokemonHeight)+"  "+result.getHeight()+"\n");
        textView.append(ctx.getString(R.string.pokemonid)+"  "+result.getId()+"\n");
        textView.append(ctx.getString(R.string.pokemonOrder)+"  "+result.getOrder()+"\n");
         textView.append(ctx.getString(R.string.pokemonBaseexp)+"  "+result.getBase_experience()+"\n\n");
          textView.setTextColor(Color.parseColor("#00ff00"));
          textView.append("ABILITIES:: "+"\n\n");
          textView.setTextColor(Color.parseColor("#000000"));
         for(int i=0;i<result.getAbilities().size();i++){
                       textView.append("SLOT:  "+result.getAbilities().get(i).getSlot()+"\n");
                       textView.append("Name:  "+result.getAbilities().get(i).getAbility().getName()+"\n\n");
         }
         textView.append("STATS:: "+"\n\n");
        for(int i=0;i<result.getStats().size();i++){
            textView.append("Effort:  "+result.getStats().get(i).getEffort()+"\n");
            textView.append("Base:  "+result.getStats().get(i).getBase_stat()+"\n");
            textView.append("Name:  "+result.getStats().get(i).getStat().getName()+"\n\n");
        }
         textView.append("Moves::  "+"\n\n");
        for(int i=0;i<result.getMoves().size();i++){

            textView.append("Name:  "+result.getMoves().get(i).getMove().getName()+"\n\n");
        }

        textView.append("Species:  "+"  "+result.getSpecies().getName()+"\n\n");
        textView.append("Game Indices:  "+"\n\n");
        for(int i=0;i<result.getGame_indices().size();i++){

            textView.append("Index:  "+result.getGame_indices().get(i).getGame_index()+"\n");
            textView.append("Verson:  "+result.getGame_indices().get(i).getVersion().getName()+"\n");
        }

    }
}
