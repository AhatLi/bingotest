package com.ahatsoft.ahat.bingotest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BingoActivity extends AppCompatActivity {

    LinearLayout[] laylayout = new LinearLayout[5];
    LinearLayout[] layout = new LinearLayout[25];
    TextView[] txt = new TextView[25];
    boolean[] click = new boolean[25];
    TextView tv;
    int len;
    int no;
    TextView bing;

    float width;
    float height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);
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
        setinit();
        getPhp();
    }

    void setinit()
    {
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
    //    float v = (width / height) / 0.5625f;
        float v = (420 / width);
        laylayout[0] = (LinearLayout)findViewById(R.id.bll1);
        laylayout[1] = (LinearLayout)findViewById(R.id.bll2);
        laylayout[2] = (LinearLayout)findViewById(R.id.bll3);
        laylayout[3] = (LinearLayout)findViewById(R.id.bll4);
        laylayout[4] = (LinearLayout)findViewById(R.id.bll5);

        Intent intent = getIntent();
        len = intent.getExtras().getInt("bingo_len");
        no = intent.getExtras().getInt("bingo_no");

        for(int i = 0; i<5; i++)
        {
            if(i<len)
                laylayout[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)width/len));
            else
                laylayout[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0));
        }

        if(len == 3)
        {
            layout[0] = (LinearLayout) findViewById(R.id.bl1);
            layout[1] = (LinearLayout) findViewById(R.id.bl2);
            layout[2] = (LinearLayout) findViewById(R.id.bl3);
            layout[3] = (LinearLayout) findViewById(R.id.bl6);
            layout[4] = (LinearLayout) findViewById(R.id.bl7);
            layout[5] = (LinearLayout) findViewById(R.id.bl8);
            layout[6] = (LinearLayout) findViewById(R.id.bl11);
            layout[7] = (LinearLayout) findViewById(R.id.bl12);
            layout[8] = (LinearLayout) findViewById(R.id.bl13);

            txt[0] = (TextView)findViewById(R.id.btxt1);
            txt[1] = (TextView)findViewById(R.id.btxt2);
            txt[2] = (TextView)findViewById(R.id.btxt3);
            txt[3] = (TextView)findViewById(R.id.btxt6);
            txt[4] = (TextView)findViewById(R.id.btxt7);
            txt[5] = (TextView)findViewById(R.id.btxt8);
            txt[6] = (TextView)findViewById(R.id.btxt11);
            txt[7] = (TextView)findViewById(R.id.btxt12);
            txt[8] = (TextView)findViewById(R.id.btxt13);

            layout[9] = (LinearLayout) findViewById(R.id.bl4);
            layout[10] = (LinearLayout) findViewById(R.id.bl5);
            layout[11] = (LinearLayout) findViewById(R.id.bl9);
            layout[12] = (LinearLayout) findViewById(R.id.bl10);
            layout[13] = (LinearLayout) findViewById(R.id.bl14);
            layout[14] = (LinearLayout) findViewById(R.id.bl15);
            layout[15] = (LinearLayout) findViewById(R.id.bl16);
            layout[16] = (LinearLayout) findViewById(R.id.bl17);
            layout[17] = (LinearLayout) findViewById(R.id.bl18);
            layout[18] = (LinearLayout) findViewById(R.id.bl19);
            layout[19] = (LinearLayout) findViewById(R.id.bl20);
            layout[20] = (LinearLayout) findViewById(R.id.bl21);
            layout[21] = (LinearLayout) findViewById(R.id.bl22);
            layout[22] = (LinearLayout) findViewById(R.id.bl23);
            layout[23] = (LinearLayout) findViewById(R.id.bl24);
            layout[24] = (LinearLayout) findViewById(R.id.bl25);

            txt[9] = (TextView)findViewById(R.id.btxt4);
            txt[10] = (TextView)findViewById(R.id.btxt5);
            txt[11] = (TextView)findViewById(R.id.btxt9);
            txt[12] = (TextView)findViewById(R.id.btxt10);
            txt[13] = (TextView)findViewById(R.id.btxt14);
            txt[14] = (TextView)findViewById(R.id.btxt15);
            txt[15] = (TextView)findViewById(R.id.btxt16);
            txt[16] = (TextView)findViewById(R.id.btxt17);
            txt[17] = (TextView)findViewById(R.id.btxt18);
            txt[18] = (TextView)findViewById(R.id.btxt19);
            txt[19] = (TextView)findViewById(R.id.btxt20);
            txt[20] = (TextView)findViewById(R.id.btxt21);
            txt[21] = (TextView)findViewById(R.id.btxt22);
            txt[22] = (TextView)findViewById(R.id.btxt23);
            txt[23] = (TextView)findViewById(R.id.btxt24);
            txt[24] = (TextView)findViewById(R.id.btxt25);
        }
        else if(len == 4)
        {
            layout[0] = (LinearLayout) findViewById(R.id.bl1);
            layout[1] = (LinearLayout) findViewById(R.id.bl2);
            layout[2] = (LinearLayout) findViewById(R.id.bl3);
            layout[3] = (LinearLayout) findViewById(R.id.bl4);
            layout[4] = (LinearLayout) findViewById(R.id.bl6);
            layout[5] = (LinearLayout) findViewById(R.id.bl7);
            layout[6] = (LinearLayout) findViewById(R.id.bl8);
            layout[7] = (LinearLayout) findViewById(R.id.bl9);
            layout[8] = (LinearLayout) findViewById(R.id.bl11);
            layout[9] = (LinearLayout) findViewById(R.id.bl12);
            layout[10] = (LinearLayout) findViewById(R.id.bl13);
            layout[11] = (LinearLayout) findViewById(R.id.bl14);
            layout[12] = (LinearLayout) findViewById(R.id.bl16);
            layout[13] = (LinearLayout) findViewById(R.id.bl17);
            layout[14] = (LinearLayout) findViewById(R.id.bl18);
            layout[15] = (LinearLayout) findViewById(R.id.bl19);

            txt[0] = (TextView)findViewById(R.id.btxt1);
            txt[1] = (TextView)findViewById(R.id.btxt2);
            txt[2] = (TextView)findViewById(R.id.btxt3);
            txt[3] = (TextView)findViewById(R.id.btxt4);
            txt[4] = (TextView)findViewById(R.id.btxt6);
            txt[5] = (TextView)findViewById(R.id.btxt7);
            txt[6] = (TextView)findViewById(R.id.btxt8);
            txt[7] = (TextView)findViewById(R.id.btxt9);
            txt[8] = (TextView)findViewById(R.id.btxt11);
            txt[9] = (TextView)findViewById(R.id.btxt12);
            txt[10] = (TextView)findViewById(R.id.btxt13);
            txt[11] = (TextView)findViewById(R.id.btxt14);
            txt[12] = (TextView)findViewById(R.id.btxt16);
            txt[13] = (TextView)findViewById(R.id.btxt17);
            txt[14] = (TextView)findViewById(R.id.btxt18);
            txt[15] = (TextView)findViewById(R.id.btxt19);

            layout[16] = (LinearLayout) findViewById(R.id.bl5);
            layout[17] = (LinearLayout) findViewById(R.id.bl10);
            layout[18] = (LinearLayout) findViewById(R.id.bl15);
            layout[19] = (LinearLayout) findViewById(R.id.bl20);
            layout[20] = (LinearLayout) findViewById(R.id.bl21);
            layout[21] = (LinearLayout) findViewById(R.id.bl22);
            layout[22] = (LinearLayout) findViewById(R.id.bl23);
            layout[23] = (LinearLayout) findViewById(R.id.bl24);
            layout[24] = (LinearLayout) findViewById(R.id.bl25);

            txt[16] = (TextView)findViewById(R.id.btxt5);
            txt[17] = (TextView)findViewById(R.id.btxt10);
            txt[18] = (TextView)findViewById(R.id.btxt15);
            txt[19] = (TextView)findViewById(R.id.btxt20);
            txt[20] = (TextView)findViewById(R.id.btxt21);
            txt[21] = (TextView)findViewById(R.id.btxt22);
            txt[22] = (TextView)findViewById(R.id.btxt23);
            txt[23] = (TextView)findViewById(R.id.btxt24);
            txt[24] = (TextView)findViewById(R.id.btxt25);
        }
        else if(len == 5)
        {
            layout[0] = (LinearLayout) findViewById(R.id.bl1);
            layout[1] = (LinearLayout) findViewById(R.id.bl2);
            layout[2] = (LinearLayout) findViewById(R.id.bl3);
            layout[3] = (LinearLayout) findViewById(R.id.bl4);
            layout[4] = (LinearLayout) findViewById(R.id.bl5);
            layout[5] = (LinearLayout) findViewById(R.id.bl6);
            layout[6] = (LinearLayout) findViewById(R.id.bl7);
            layout[7] = (LinearLayout) findViewById(R.id.bl8);
            layout[8] = (LinearLayout) findViewById(R.id.bl9);
            layout[9] = (LinearLayout) findViewById(R.id.bl10);
            layout[10] = (LinearLayout) findViewById(R.id.bl11);
            layout[11] = (LinearLayout) findViewById(R.id.bl12);
            layout[12] = (LinearLayout) findViewById(R.id.bl13);
            layout[13] = (LinearLayout) findViewById(R.id.bl14);
            layout[14] = (LinearLayout) findViewById(R.id.bl15);
            layout[15] = (LinearLayout) findViewById(R.id.bl16);
            layout[16] = (LinearLayout) findViewById(R.id.bl17);
            layout[17] = (LinearLayout) findViewById(R.id.bl18);
            layout[18] = (LinearLayout) findViewById(R.id.bl19);
            layout[19] = (LinearLayout) findViewById(R.id.bl20);
            layout[20] = (LinearLayout) findViewById(R.id.bl21);
            layout[21] = (LinearLayout) findViewById(R.id.bl22);
            layout[22] = (LinearLayout) findViewById(R.id.bl23);
            layout[23] = (LinearLayout) findViewById(R.id.bl24);
            layout[24] = (LinearLayout) findViewById(R.id.bl25);

            txt[0] = (TextView)findViewById(R.id.btxt1);
            txt[1] = (TextView)findViewById(R.id.btxt2);
            txt[2] = (TextView)findViewById(R.id.btxt3);
            txt[3] = (TextView)findViewById(R.id.btxt4);
            txt[4] = (TextView)findViewById(R.id.btxt5);
            txt[5] = (TextView)findViewById(R.id.btxt6);
            txt[6] = (TextView)findViewById(R.id.btxt7);
            txt[7] = (TextView)findViewById(R.id.btxt8);
            txt[8] = (TextView)findViewById(R.id.btxt9);
            txt[9] = (TextView)findViewById(R.id.btxt10);
            txt[10] = (TextView)findViewById(R.id.btxt11);
            txt[11] = (TextView)findViewById(R.id.btxt12);
            txt[12] = (TextView)findViewById(R.id.btxt13);
            txt[13] = (TextView)findViewById(R.id.btxt14);
            txt[14] = (TextView)findViewById(R.id.btxt15);
            txt[15] = (TextView)findViewById(R.id.btxt16);
            txt[16] = (TextView)findViewById(R.id.btxt17);
            txt[17] = (TextView)findViewById(R.id.btxt18);
            txt[18] = (TextView)findViewById(R.id.btxt19);
            txt[19] = (TextView)findViewById(R.id.btxt20);
            txt[20] = (TextView)findViewById(R.id.btxt21);
            txt[21] = (TextView)findViewById(R.id.btxt22);
            txt[22] = (TextView)findViewById(R.id.btxt23);
            txt[23] = (TextView)findViewById(R.id.btxt24);
            txt[24] = (TextView)findViewById(R.id.btxt25);

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
            txt[i].setLayoutParams(params);
        }
        for(int i = 0; i<25; i++)
        {
            click[i] = false;
            txt[i].setTextColor(Color.BLACK);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<25; i++)
                {
                    if(view == layout[i])
                    {
                        if(click[i])
                        {
                            click[i] = false;
                            txt[i].setTextColor(Color.BLACK);
                            layout[i].setBackgroundColor(Color.WHITE);
                            int k = 0;
                            if(i % 2 == 0 && len != 4)
                            {
                                layout[i].setBackgroundColor(Color.GRAY);
                            }
                            else if(len == 4 && (i == 0 ||i == 2 ||i == 5 ||i == 7 ||i == 8 ||i == 10 ||i == 13 ||i == 15))
                            {
                                layout[i].setBackgroundColor(Color.GRAY);
                            }
                        }
                        else
                        {
                            click[i] = true;
                            txt[i].setTextColor(Color.WHITE);
                            view.setBackgroundColor(Color.BLACK);
                        }
                        break;
                    }
                }
                bing_test();
            }
        };

        for(int i = 0; i<25; i++)
        {
            layout[i].setOnClickListener(onClickListener);
            txt[i].setTextSize((float)(40.0f * v) * (3.0f / (float)len));
        }

        params = new LinearLayout.LayoutParams((int)width/len * 4, (int)height/10);
        params.gravity = Gravity.CENTER_VERTICAL;

        tv = (TextView) findViewById(R.id.bing_title);
        tv.setTextSize(60 * v);
        tv.setLayoutParams(params);
        tv.setTextColor(Color.BLACK);

        Log.e("a1", "이거" + v);
        Log.e("a1", "이거" + v * 60.f);
        params = new LinearLayout.LayoutParams((int)width/len, (int)height/15);
        params.gravity = Gravity.CENTER;


        bing = (TextView)findViewById(R.id.bing);

        bing.setTextSize((40.0f * v));
    }

    void getPhp()
    {
        StringBuilder jsonHtml = new StringBuilder();
        try {
            URL url = new URL("http://222.100.242.218:14145/select.php?bingo_no=" + no);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    for (; ; ) {
                        String line = br.readLine();
                        if (line == null) break;
                        jsonHtml.append(line + "\n");
                    }
                    br.close();
                }
                conn.disconnect();
            }
        }
        catch (Exception e)
        {
            Log.e("aa", e.toString());
        }

        try
        {
            JSONObject root = new JSONObject(jsonHtml.toString());
            JSONArray ja = root.getJSONArray("results");

            JSONObject jo = ja.getJSONObject(0);
            tv.setText(jo.getString("bingo_name"));
            for(int i=0; i<25; i++)
            {
                txt[i].setText(jo.getString("bing" + (i + 1)));
            }
        }
        catch(Exception e)
        {
            Log.e("aaa", e.toString());
        }

    }

    public void back(View v)
    {
        finish();
    }

    public void bing_test()
    {
        if(len == 5)
        {

        }
        int k = 0;
        int c = 0;

        for(int i = 0; i<len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (click[i + (j * len)])
                    k++;
            }
            if(k == len)
                c++;
            k = 0;
        }
        k = 0;
        for(int i = 0; i<len; i++)
        {
            for(int j = 0; j<len; j++)
            {
                if(click[(i*len)+j])
                    k++;
            }
            if(k==len)
                c++;
            k = 0;
        }

        k = 0;
        for(int i = 0; i<len ;i++)
        {
            if(click[(len+1) * i])
                k++;
        }
        if(k==len)
            c++;

        k = 0;
        for(int i = 1; i<len+1 ;i++)
        {
            if(click[(len-1) * i])
                k++;
        }
        if(k==len)
            c++;

        if(c == 0)
            bing.setText("");
        else
            bing.setText("" + c + "빙고입니다!!");
    }

}
