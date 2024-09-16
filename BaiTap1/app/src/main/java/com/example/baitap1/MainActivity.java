package com.example.baitap1;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] imgID = {R.drawable.cat, R.drawable.dog, R.drawable.penguin};
    int[] colorID = {R.color.black, R.color.teal, R.color.purple,  R.color.red,  R.color.blue};
    LinearLayout layout;
    View loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingLayout = findViewById(R.id.loading_layout);
        layout = findViewById(R.id.layout);

        showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoading();
                change();
            }
        }, 2000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void change() {
        ImageView img = findViewById(R.id.img);
        Random random = new Random();

        img.setImageResource(imgID[random.nextInt(imgID.length)]);
        layout.setBackgroundResource(colorID[random.nextInt(colorID.length)]);
    }

    private void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
