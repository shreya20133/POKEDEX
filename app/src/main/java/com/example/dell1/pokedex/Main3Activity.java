package com.example.dell1.pokedex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Types;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {

    ProgressBar progressBar;
    Button Go;
    ImageView pokeImage;
    Button left;
    Button right;
    TextView name;
    ScrollView scrollView;
    TextView types;
    Integer rank;
    TextView pokerank;
    Button searchbtn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Go=findViewById(R.id.gobtn);
        pokeImage=findViewById(R.id.pokemon_img);
        left=findViewById(R.id.left_move);
        right=findViewById(R.id.right_move);
        name=findViewById(R.id.pokemon_name);
        scrollView=findViewById(R.id.sv);
        types=findViewById(R.id.type_items);
        scrollView.setEnabled(true);
        pokerank=findViewById(R.id.pokemon_rank);
        progressBar=findViewById(R.id.pb);
        editText=findViewById(R.id.search);
        searchbtn=findViewById(R.id.searchbtn);
        Bundle b=new Bundle();
        rank=1;
         String url=("http://pokeapi.co/api/v2/pokemon/"+rank);
        makeNetworkCall(url);
        if(rank>=1 && rank<=949)
        {right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank++;
                name.setText("");
                pokerank.setText("");
                types.setText("");
                makeNetworkCall("http://pokeapi.co/api/v2/pokemon/"+rank);
            }
        });
        }
        {left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank--;
                name.setText("");
                pokerank.setText("");
                types.setText("");
                makeNetworkCall("http://pokeapi.co/api/v2/pokemon/"+rank);
            }
        });
        }
    }
    private void makeNetworkCall(String url){
        progressBar.setVisibility(View.VISIBLE);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Toast toast=Toast.makeText(Main3Activity.this,"Loading....",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL_HORIZONTAL,0,-267);
        toast.show();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Gson gson=new Gson();
                final APIResult apiResult=gson.fromJson(result,APIResult.class);
                (Main3Activity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setVisibility(View.GONE);
                        name.setText(apiResult.getName());
                        ArrayList<TYpes> tYpesArrayList=apiResult.getTypes();

                        for(int i=0;i<tYpesArrayList.size();i++){
                            TYpes currentTypeItem=tYpesArrayList.get(i);
                            Typename typename=currentTypeItem.getType();
                            types.append("* "+typename.getName()+"\n");
                        }
                        Glide.with(Main3Activity.this).load(apiResult.getSprites().getFront_shiny()).into(pokeImage);
                        pokerank.setText("\t"+String.valueOf(apiResult.getId()));
                        Go.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(Main3Activity.this,DetailActivity.class);
                                i.putExtra("APIRESULT",apiResult);
                                Log.e("tag","go");
                                startActivity(i);
                            }
                        });
                        searchbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                rank=Integer.valueOf(editText.getText().toString());
                                makeNetworkCall("http://pokeapi.co/api/v2/pokemon/"+rank);
                            }
                        });
                    }
                });
            }
        });
    }
}
