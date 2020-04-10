package com.ahatsoft.ahat.bingotest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListActivity extends AppCompatActivity {

    ListView list;
    BingoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        float width = dm.widthPixels;
        float height = dm.heightPixels;
    //    float v = (width / height) / 0.5625f;
        float v = (480 / width);

        adapter = new BingoAdapter(this, R.layout.bingo_list, width, v);
        list = (ListView)findViewById(R.id.list);

        list.setAdapter(adapter);
        adapter.addJSON(getphp());
        list.setOnItemClickListener(onClickListItem);

        TextView tv = (TextView)findViewById(R.id.list_title);
        tv.setTextColor(Color.BLACK);
    //    tv.setTextSize((float) (45.0f * v));
        float scale = getResources().getDisplayMetrics().density;
    //    tv.setTextSize(50.0f * v);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60 * v);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)width, (int)height/10 * 9);
        params.gravity = Gravity.CENTER;
        list.setLayoutParams(params);

    }

    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        {
            Intent intent = new Intent(ListActivity.this, BingoActivity.class);
            intent.putExtra("bingo_no", adapter.getItem(arg2).getBingo_no());
            intent.putExtra("bingo_len", adapter.getItem(arg2).getBingo_len());
            startActivity(intent);
        }
    };

    public String getphp()
    {
        StringBuilder jsonHtml = new StringBuilder();
        try{
            URL url = new URL("http://222.100.242.218:14145/out.php");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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
        }
        catch(Exception ex)
        {
            Log.e("한글 안나옴?", ex.toString());
        }
        return jsonHtml.toString();
    }
}
