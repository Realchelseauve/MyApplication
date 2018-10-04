package com.example.saransh.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class GridAdapter2 extends BaseAdapter {
    Context context;

    private final String[] values2;
    private final int[] images2;
    View v;
    LayoutInflater layoutInflater, layoutInflater1;

    public GridAdapter2(String[] values2, int[] images2, Context context) {
        this.values2 = values2;
        this.context = context;
        this.images2 = images2;
    }

    @Override
    public int getCount() {
        return values2.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    DataHelper db;
    int j = 0;
    pop p1 = new pop();
    Register register = new Register();

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        db = new DataHelper(this.context);


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            v = new View(context);
            v = layoutInflater.inflate(R.layout.single_item, null);
            final ImageView imageView = (ImageView) v.findViewById(R.id.imgeview);
            TextView textView = (TextView) v.findViewById(R.id.textview);
            imageView.setImageResource(images2[i]);
            textView.setText(values2[i]);
            final String s1 = textView.getText().toString();
            //  String str=(String)register.IPPhoneslist1.get(0);
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(100); //You can manage the blinking time with this parameter
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            List<Fun> registrationList1 = db.setAllRegistrations();
            for (Iterator<Fun> iter = registrationList1.iterator(); iter.hasNext(); ) {
                Fun registration = iter.next();
                String ip1 = registration.getIp();
                String d1 = registration.getDs();
                if (s1.equals(ip1) || s1.equals(d1)) {
                    textView.startAnimation(anim);
                    imageView.startAnimation(anim);
                }
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
               //  p1.getTex(s1);
                   // context.startActivity(new Intent(context,pop.class));
                    Intent i=new Intent(context,pop.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("stuff",s1);
                    i.putExtras(bundle);
                    context.startActivity(i);
                }
                // @Override
                // public void onClick(View view1){
                //      layoutInflater1=(LayoutInflater)
                //    }
                //     }
                //     );

            });
        }
        return v;
    }
}
