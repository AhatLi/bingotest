package com.ahatsoft.ahat.bingotest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PrepareActivity extends AppCompatActivity {


    EditText t1, t2;
    RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);
        t1 = (EditText) findViewById(R.id.editText);
        t2 = (EditText) findViewById(R.id.editText2);
        radio = (RadioGroup)findViewById(R.id.radiog);

        TextView t1, t2, t3, t4;
        t1 = (TextView)findViewById(R.id.makeText1);
        t2 = (TextView)findViewById(R.id.makeText2);
        t3 = (TextView)findViewById(R.id.makeText3);
        t4 = (TextView)findViewById(R.id.makeText4);

        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        float width = dm.widthPixels;
        float height = dm.heightPixels;
        float v = (width / height) / 0.5625f;

        t1.setTextSize(50.0f * v);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)width/3, (int)height / 15);
        params.gravity = Gravity.CENTER_VERTICAL;
        t2.setLayoutParams(params);
        t2.setTextSize(30.0f * v);
        t3.setLayoutParams(params);
        t3.setTextSize(30.0f * v);
        params = new LinearLayout.LayoutParams((int)width, (int)height / 15);
        params.gravity = Gravity.CENTER_VERTICAL;
        t4.setLayoutParams(params);
        t4.setTextSize(30.0f * v);

        EditText et1, et2;
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)height / 20);
        et1.setLayoutParams(params);
        et1.setTextSize(25.0f * v);
        et2.setLayoutParams(params);
        et2.setTextSize(25.0f * v);

        RadioButton b1, b2, b3;
        b1 = (RadioButton)findViewById(R.id.radioButton1);
        b2 = (RadioButton)findViewById(R.id.radioButton2);
        b3 = (RadioButton)findViewById(R.id.radioButton3);

        b1.setTextSize(30.0f * v);
        b2.setTextSize(30.0f * v);
        b3.setTextSize(30.0f * v);

        Button btn = (Button) findViewById(R.id.next);
        btn.setTextSize(40.0f * v);

    }
    public void next(View v)
    {
        int selRadio = 0;
        if(t1.getText().toString().equals("") || t2.getText().toString().equals(""))
        {
            Toast.makeText(this, "빙고의 제목과 작성자를 제대로 입력해 주세요", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(radio.getCheckedRadioButtonId() == R.id.radioButton1)
                selRadio = 3;
            else if(radio.getCheckedRadioButtonId() == R.id.radioButton2)
                selRadio = 4;
            else if(radio.getCheckedRadioButtonId() == R.id.radioButton3)
                selRadio = 5;
            Intent intent = new Intent(PrepareActivity.this, MakeActivity.class);
            intent.putExtra("bingname", t2.getText().toString());
            intent.putExtra("username", t1.getText().toString());
            intent.putExtra("binglen", selRadio);
            startActivity(intent);
        }
    }
}
