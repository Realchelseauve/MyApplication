package com.example.saransh.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import android.view.LayoutInflater;
import android.widget.TextView;

public class Custom_Adapter extends ArrayAdapter<String> {
    private Context mContext;
    private int id;
    private List<String> items;

    public Custom_Adapter(Context context, int textViewResourceId, List<String> list) {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list;
    }

@Override
    public View getView( int position, View v, ViewGroup parent) {
        View mView = v;
        if (mView == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }
    TextView text = (TextView) mView.findViewById(R.id.shadylegend);

   if(items.get(position) != null )
    {
        text.setTextColor(Color.WHITE);
        text.setText(items.get(position));


    }
return mView;

}
}
