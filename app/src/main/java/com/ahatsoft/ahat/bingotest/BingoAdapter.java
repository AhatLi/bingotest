package com.ahatsoft.ahat.bingotest;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015-12-06.
 */
public class BingoAdapter extends BaseAdapter {

    ArrayList<Bingo_list> data;
    private LayoutInflater inflater;
    private int layout;
    Context context;
    float width;
    float v;

    public BingoAdapter(Context context, int layout, float width, float v)
    {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.layout = layout;
        this.width = width;
        this.v = v;
        data = new ArrayList<Bingo_list>();
    }
    @Override
    public int getCount()
    {
            return data.size();
    }

    @Override
    public Bingo_list getItem(int i)
    {
            return data.get(i);
    }

    @Override
    public long getItemId(int i) {  return i;    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        final int pos = i;

        if(convertView==null){
            convertView=inflater.inflate(layout, viewGroup, false);
        }

        TextView bname = (TextView)convertView.findViewById(R.id.list_bingo_name);
        TextView uname = (TextView)convertView.findViewById(R.id.list_user_name);
        ImageView iv = (ImageView)convertView.findViewById(R.id.listimg);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)width/7, (int)width/7);
        iv.setLayoutParams(params);
        if(data.get(pos).getBingo_len() == 3)
        {
            iv.setImageResource(R.drawable.list3);
        }
        else if(data.get(pos).getBingo_len() == 4)
        {
            iv.setImageResource(R.drawable.list4);
        }
        else if(data.get(pos).getBingo_len() == 5)
        {
            iv.setImageResource(R.drawable.list5);
        }
        bname.setText(data.get(pos).bingo_name);
        bname.setTextSize(50 * v);
     //   bname.setTextSize((int)width/7 /10 * 7);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)width/7 /10 * 7);
        bname.setLayoutParams(params);

        uname.setText("제작자 " + data.get(pos).user_name);
        uname.setTextSize(20 * v);
    //    uname.setTextSize((int)width/7 /10 * 3);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)width/7 /10 * 3);
        params.gravity = Gravity.TOP;
        uname.setLayoutParams(params);

        return convertView;
    }

    public void addJSON(String json)
    {
        try
        {
            JSONObject root = new JSONObject(json);
            JSONArray ja = root.getJSONArray("results");

            for(int i=0; i<ja.length(); i++)
            {
                Bingo_list o = new Bingo_list();
                JSONObject jo = ja.getJSONObject(i);
                o.setBingo_name(jo.getString("bingo_name"));
                o.setUser_name(jo.getString("user_name"));
                o.setBingo_no(jo.getInt("bingo_no"));
                o.setBingo_len(jo.getInt("bingo_len"));
                data.add(o);
            }
        }
        catch(Exception e)
        {
            Log.e("aaa", e.toString());
        }
    }

    public class Bingo_list
    {
        public String bingo_name;
        String user_name;
        int bingo_len;
        int bingo_no;

        void setBingo_name(String s) {bingo_name = s;}
        void setUser_name(String s) {user_name = s;}
        void setBingo_len(int s) {bingo_len = s;}
        void setBingo_no(int s) {bingo_no = s;}
        public String getBingo_name() {return bingo_name;}
        int getBingo_no() {return bingo_no;}
        int getBingo_len() {return bingo_len;}

        Bingo_list()
        {
            bingo_len = 0;
            bingo_no = 0;
            bingo_name = "";
            user_name = "";
        }
    }
}
