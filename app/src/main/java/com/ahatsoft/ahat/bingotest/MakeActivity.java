package com.ahatsoft.ahat.bingotest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MakeActivity extends AppCompatActivity {

    float width;
    float height;
    String uname;
    String bname;
    int len;
    EditText[] txt = new EditText[25];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        }
        catch (Exception e)
        {
            Log.e("error", e.toString());
        }
        setInit();
    }

    void setInit()
    {
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
     //   float v = (width / height) / 0.5625f;
        float v = (420 / width);

        Intent intent = getIntent();
        uname = intent.getStringExtra("username");
        bname = intent.getStringExtra("bingname");
        len = intent.getExtras().getInt("binglen");
        TextView tv = (TextView) findViewById(R.id.makename);
        tv.setText(bname);
        tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)height / 10));
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(50 * v);

        LinearLayout[] laylayout = new LinearLayout[5];
        laylayout[0] = (LinearLayout)findViewById(R.id.ll1);
        laylayout[1] = (LinearLayout)findViewById(R.id.ll2);
        laylayout[2] = (LinearLayout)findViewById(R.id.ll3);
        laylayout[3] = (LinearLayout)findViewById(R.id.ll4);
        laylayout[4] = (LinearLayout)findViewById(R.id.ll5);

        for(int i = 0; i<5; i++)
        {
            if(i<len)
                laylayout[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)width/len));
            else
                laylayout[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0));
        }
        LinearLayout[] layout = new LinearLayout[25];

        if(len == 3)
        {
            layout[0] = (LinearLayout) findViewById(R.id.l1);
            layout[1] = (LinearLayout) findViewById(R.id.l2);
            layout[2] = (LinearLayout) findViewById(R.id.l3);
            layout[3] = (LinearLayout) findViewById(R.id.l6);
            layout[4] = (LinearLayout) findViewById(R.id.l7);
            layout[5] = (LinearLayout) findViewById(R.id.l8);
            layout[6] = (LinearLayout) findViewById(R.id.l11);
            layout[7] = (LinearLayout) findViewById(R.id.l12);
            layout[8] = (LinearLayout) findViewById(R.id.l13);

            txt[0] = (EditText)findViewById(R.id.t1);
            txt[1] = (EditText)findViewById(R.id.t2);
            txt[2] = (EditText)findViewById(R.id.t3);
            txt[3] = (EditText)findViewById(R.id.t6);
            txt[4] = (EditText)findViewById(R.id.t7);
            txt[5] = (EditText)findViewById(R.id.t8);
            txt[6] = (EditText)findViewById(R.id.t11);
            txt[7] = (EditText)findViewById(R.id.t12);
            txt[8] = (EditText)findViewById(R.id.t13);

            layout[9] = (LinearLayout) findViewById(R.id.l4);
            layout[10] = (LinearLayout) findViewById(R.id.l5);
            layout[11] = (LinearLayout) findViewById(R.id.l9);
            layout[12] = (LinearLayout) findViewById(R.id.l10);
            layout[13] = (LinearLayout) findViewById(R.id.l14);
            layout[14] = (LinearLayout) findViewById(R.id.l15);
            layout[15] = (LinearLayout) findViewById(R.id.l16);
            layout[16] = (LinearLayout) findViewById(R.id.l17);
            layout[17] = (LinearLayout) findViewById(R.id.l18);
            layout[18] = (LinearLayout) findViewById(R.id.l19);
            layout[19] = (LinearLayout) findViewById(R.id.l20);
            layout[20] = (LinearLayout) findViewById(R.id.l21);
            layout[21] = (LinearLayout) findViewById(R.id.l22);
            layout[22] = (LinearLayout) findViewById(R.id.l23);
            layout[23] = (LinearLayout) findViewById(R.id.l24);
            layout[24] = (LinearLayout) findViewById(R.id.l25);

            txt[9] = (EditText)findViewById(R.id.t4);
            txt[10] = (EditText)findViewById(R.id.t5);
            txt[11] = (EditText)findViewById(R.id.t9);
            txt[12] = (EditText)findViewById(R.id.t10);
            txt[13] = (EditText)findViewById(R.id.t14);
            txt[14] = (EditText)findViewById(R.id.t15);
            txt[15] = (EditText)findViewById(R.id.t16);
            txt[16] = (EditText)findViewById(R.id.t17);
            txt[17] = (EditText)findViewById(R.id.t18);
            txt[18] = (EditText)findViewById(R.id.t19);
            txt[19] = (EditText)findViewById(R.id.t20);
            txt[20] = (EditText)findViewById(R.id.t21);
            txt[21] = (EditText)findViewById(R.id.t22);
            txt[22] = (EditText)findViewById(R.id.t23);
            txt[23] = (EditText)findViewById(R.id.t24);
            txt[24] = (EditText)findViewById(R.id.t25);
        }
        else if(len == 4)
        {
            layout[0] = (LinearLayout) findViewById(R.id.l1);
            layout[1] = (LinearLayout) findViewById(R.id.l2);
            layout[2] = (LinearLayout) findViewById(R.id.l3);
            layout[3] = (LinearLayout) findViewById(R.id.l4);
            layout[4] = (LinearLayout) findViewById(R.id.l6);
            layout[5] = (LinearLayout) findViewById(R.id.l7);
            layout[6] = (LinearLayout) findViewById(R.id.l8);
            layout[7] = (LinearLayout) findViewById(R.id.l9);
            layout[8] = (LinearLayout) findViewById(R.id.l11);
            layout[9] = (LinearLayout) findViewById(R.id.l12);
            layout[10] = (LinearLayout) findViewById(R.id.l13);
            layout[11] = (LinearLayout) findViewById(R.id.l14);
            layout[12] = (LinearLayout) findViewById(R.id.l16);
            layout[13] = (LinearLayout) findViewById(R.id.l17);
            layout[14] = (LinearLayout) findViewById(R.id.l18);
            layout[15] = (LinearLayout) findViewById(R.id.l19);

            txt[0] = (EditText)findViewById(R.id.t1);
            txt[1] = (EditText)findViewById(R.id.t2);
            txt[2] = (EditText)findViewById(R.id.t3);
            txt[3] = (EditText)findViewById(R.id.t4);
            txt[4] = (EditText)findViewById(R.id.t6);
            txt[5] = (EditText)findViewById(R.id.t7);
            txt[6] = (EditText)findViewById(R.id.t8);
            txt[7] = (EditText)findViewById(R.id.t9);
            txt[8] = (EditText)findViewById(R.id.t11);
            txt[9] = (EditText)findViewById(R.id.t12);
            txt[10] = (EditText)findViewById(R.id.t13);
            txt[11] = (EditText)findViewById(R.id.t14);
            txt[12] = (EditText)findViewById(R.id.t16);
            txt[13] = (EditText)findViewById(R.id.t17);
            txt[14] = (EditText)findViewById(R.id.t18);
            txt[15] = (EditText)findViewById(R.id.t19);

            layout[16] = (LinearLayout) findViewById(R.id.l5);
            layout[17] = (LinearLayout) findViewById(R.id.l10);
            layout[18] = (LinearLayout) findViewById(R.id.l15);
            layout[19] = (LinearLayout) findViewById(R.id.l20);
            layout[20] = (LinearLayout) findViewById(R.id.l21);
            layout[21] = (LinearLayout) findViewById(R.id.l22);
            layout[22] = (LinearLayout) findViewById(R.id.l23);
            layout[23] = (LinearLayout) findViewById(R.id.l24);
            layout[24] = (LinearLayout) findViewById(R.id.l25);

            txt[16] = (EditText)findViewById(R.id.t5);
            txt[17] = (EditText)findViewById(R.id.t10);
            txt[18] = (EditText)findViewById(R.id.t15);
            txt[19] = (EditText)findViewById(R.id.t20);
            txt[20] = (EditText)findViewById(R.id.t21);
            txt[21] = (EditText)findViewById(R.id.t22);
            txt[22] = (EditText)findViewById(R.id.t23);
            txt[23] = (EditText)findViewById(R.id.t24);
            txt[24] = (EditText)findViewById(R.id.t25);
        }
        else if(len == 5)
        {
            layout[0] = (LinearLayout) findViewById(R.id.l1);
            layout[1] = (LinearLayout) findViewById(R.id.l2);
            layout[2] = (LinearLayout) findViewById(R.id.l3);
            layout[3] = (LinearLayout) findViewById(R.id.l4);
            layout[4] = (LinearLayout) findViewById(R.id.l5);
            layout[5] = (LinearLayout) findViewById(R.id.l6);
            layout[6] = (LinearLayout) findViewById(R.id.l7);
            layout[7] = (LinearLayout) findViewById(R.id.l8);
            layout[8] = (LinearLayout) findViewById(R.id.l9);
            layout[9] = (LinearLayout) findViewById(R.id.l10);
            layout[10] = (LinearLayout) findViewById(R.id.l11);
            layout[11] = (LinearLayout) findViewById(R.id.l12);
            layout[12] = (LinearLayout) findViewById(R.id.l13);
            layout[13] = (LinearLayout) findViewById(R.id.l14);
            layout[14] = (LinearLayout) findViewById(R.id.l15);
            layout[15] = (LinearLayout) findViewById(R.id.l16);
            layout[16] = (LinearLayout) findViewById(R.id.l17);
            layout[17] = (LinearLayout) findViewById(R.id.l18);
            layout[18] = (LinearLayout) findViewById(R.id.l19);
            layout[19] = (LinearLayout) findViewById(R.id.l20);
            layout[20] = (LinearLayout) findViewById(R.id.l21);
            layout[21] = (LinearLayout) findViewById(R.id.l22);
            layout[22] = (LinearLayout) findViewById(R.id.l23);
            layout[23] = (LinearLayout) findViewById(R.id.l24);
            layout[24] = (LinearLayout) findViewById(R.id.l25);

            txt[0] = (EditText)findViewById(R.id.t1);
            txt[1] = (EditText)findViewById(R.id.t2);
            txt[2] = (EditText)findViewById(R.id.t3);
            txt[3] = (EditText)findViewById(R.id.t4);
            txt[4] = (EditText)findViewById(R.id.t5);
            txt[5] = (EditText)findViewById(R.id.t6);
            txt[6] = (EditText)findViewById(R.id.t7);
            txt[7] = (EditText)findViewById(R.id.t8);
            txt[8] = (EditText)findViewById(R.id.t9);
            txt[9] = (EditText)findViewById(R.id.t10);
            txt[10] = (EditText)findViewById(R.id.t11);
            txt[11] = (EditText)findViewById(R.id.t12);
            txt[12] = (EditText)findViewById(R.id.t13);
            txt[13] = (EditText)findViewById(R.id.t14);
            txt[14] = (EditText)findViewById(R.id.t15);
            txt[15] = (EditText)findViewById(R.id.t16);
            txt[16] = (EditText)findViewById(R.id.t17);
            txt[17] = (EditText)findViewById(R.id.t18);
            txt[18] = (EditText)findViewById(R.id.t19);
            txt[19] = (EditText)findViewById(R.id.t20);
            txt[20] = (EditText)findViewById(R.id.t21);
            txt[21] = (EditText)findViewById(R.id.t22);
            txt[22] = (EditText)findViewById(R.id.t23);
            txt[23] = (EditText)findViewById(R.id.t24);
            txt[24] = (EditText)findViewById(R.id.t25);
        }

        for(int i = 0; i<5; i++)
        {
            layout[i].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        int k = 0;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)width/len, (int)width/len);
        params.gravity = Gravity.CENTER;
        for(int i = 0; i<len * len; i++)
        {
            if(i % 2 == 0 && len != 4) {
                layout[i].setBackgroundColor(Color.GRAY);
            }
            else if(len == 4)
            {
                if(i == k)
                {
                    layout[i].setBackgroundColor(Color.GRAY);
                    k += 2;
                }
                if(k == 4 || k == 9 || k == 12)
                {
                    k += k % 4 == 0 ? +1 : -1;
                }
            }
            layout[i].setLayoutParams(params);
        }

        for(int i = 0; i<25; i++)
        {
            txt[i].setTextColor(Color.BLACK);
        //    txt[i].setTextSize(30 * v);
            txt[i].setTextSize((float)(40.0f * v) * (3.0f / (float)len));
        }

        Button btn = (Button)findViewById(R.id.ok);
        btn.setTextSize(40 * v);
    }

    public void ok(View v)
    {
        int c = 0;
        for(int i=0; i<len*len; i++)
            if(txt[i].getText().toString().equals(""))
                c = 1;

        try
        {
            if(c == 1)
                Toast.makeText(this, "모든 내용을 입력해 주세요", Toast.LENGTH_SHORT).show();
            else
            {
                URL text = new URL("http://222.100.242.218:14145/in.php?b_name=" +
                        URLEncoder.encode(bname) + "&u_name=" +
                        URLEncoder.encode(uname) + "&b_len=" + len +
                        "&b_val01=" + URLEncoder.encode(txt[0].getText().toString()) +
                        "&b_val02=" + URLEncoder.encode(txt[1].getText().toString()) +
                        "&b_val03=" + URLEncoder.encode(txt[2].getText().toString()) +
                        "&b_val04=" + URLEncoder.encode(txt[3].getText().toString()) +
                        "&b_val05=" + URLEncoder.encode(txt[4].getText().toString()) +
                        "&b_val06=" + URLEncoder.encode(txt[5].getText().toString()) +
                        "&b_val07=" + URLEncoder.encode(txt[6].getText().toString()) +
                        "&b_val08=" + URLEncoder.encode(txt[7].getText().toString()) +
                        "&b_val09=" + URLEncoder.encode(txt[8].getText().toString()) +
                        "&b_val10=" + URLEncoder.encode(txt[9].getText().toString()) +
                        "&b_val11=" + URLEncoder.encode(txt[10].getText().toString()) +
                        "&b_val12=" + URLEncoder.encode(txt[11].getText().toString()) +
                        "&b_val13=" + URLEncoder.encode(txt[12].getText().toString()) +
                        "&b_val14=" + URLEncoder.encode(txt[13].getText().toString()) +
                        "&b_val15=" + URLEncoder.encode(txt[14].getText().toString()) +
                        "&b_val16=" + URLEncoder.encode(txt[15].getText().toString()) +
                        "&b_val17=" + URLEncoder.encode(txt[16].getText().toString()) +
                        "&b_val18=" + URLEncoder.encode(txt[17].getText().toString()) +
                        "&b_val19=" + URLEncoder.encode(txt[18].getText().toString()) +
                        "&b_val20=" + URLEncoder.encode(txt[19].getText().toString()) +
                        "&b_val21=" + URLEncoder.encode(txt[20].getText().toString()) +
                        "&b_val22=" + URLEncoder.encode(txt[21].getText().toString()) +
                        "&b_val23=" + URLEncoder.encode(txt[22].getText().toString()) +
                        "&b_val24=" + URLEncoder.encode(txt[23].getText().toString()) +
                        "&b_val25=" + URLEncoder.encode(txt[24].getText().toString())
                );

            //    text.openStream();
                      HttpURLConnection conn = (HttpURLConnection)text.openConnection();
            //          conn.connect();

                StringBuilder jsonHtml = new StringBuilder();
                if(conn != null)
                {
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)
                    {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for(;;)
                        {
                            String line = br.readLine();
                            if(line == null) break;
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
                Toast.makeText(this, "입력이 완료되었습니다", Toast.LENGTH_SHORT).show();

                Intent intentHome = new Intent(this, MainActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentHome);
                finish();
            }
        }
        catch (Exception e)
        {
            Log.e("aaaa", e.toString());
        }
    }
}
