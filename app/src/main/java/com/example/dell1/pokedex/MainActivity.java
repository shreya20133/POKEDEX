package com.example.dell1.pokedex;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView pokeLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=findViewById(R.id.img2);
        Glide.with(this).load("https://cdn.dribbble.com/users/1663937/screenshots/3598052/pokeball.gif").into(imageView);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.up_to_down);

        pokeLogo=findViewById(R.id.pokelogo);

        pokeLogo.setAnimation(animation);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                finish();
            }
        },5500);

    }
}
