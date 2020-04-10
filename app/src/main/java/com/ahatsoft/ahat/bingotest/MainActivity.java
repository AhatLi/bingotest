package com.ahatsoft.ahat.bingotest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int width = 0;
        int height = 0;

        try {
            Display defaultDisplay = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            width = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();

            ImageButton btn_play = (ImageButton) findViewById(R.id.btn1);
            ImageButton btn_make = (ImageButton) findViewById(R.id.btn2);
            ImageButton btn_info = (ImageButton) findViewById(R.id.btn3);
            LinearLayout blink = (LinearLayout) findViewById(R.id.blink);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height / 2);
            params.gravity = Gravity.CENTER;
            blink.setLayoutParams(params);

            params = new LinearLayout.LayoutParams(width / 3 * 2, height / 10);
            params.gravity = Gravity.CENTER;
            params.setMargins(0, 0, 0, 20);

            btn_play.setLayoutParams(params);
            btn_make.setLayoutParams(params);
            btn_info.setLayoutParams(params);
        }
        catch (Exception e)
        {
        }
    }

    public void gobingo(View v)
    {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void makebingo(View v)
    {
        Intent intent = new Intent(MainActivity.this, PrepareActivity.class);
        startActivity(intent);
    }
    public void infobingo(View v)
    {
        Intent intent = new Intent(MainActivity.this, ManualActivity.class);
        startActivity(intent);
    }
}
