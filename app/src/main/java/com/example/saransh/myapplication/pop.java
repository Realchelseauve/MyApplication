package com.example.saransh.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pop extends Activity {
     DataHelper1 db1;
    // String s1;
     ListView l1,l2;

 /*   public Void getTex(String s1)
    {
        this.s1=s1;
        return null;
    }*/


    private List<String> severitylist = new ArrayList<>();
    private List<String> failurelist = new ArrayList<>();
    private List<String> phonelist=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle=getIntent().getExtras();
        String s1=bundle.getString("stuff");
        db1 = new DataHelper1(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        List<Registration1> registrationList2 = db1.getAllRegistrations();
        if(registrationList2.size()==0) {
            db1.insertRegistrationEntry("2001", "Major", "Correct", 0);
            db1.insertRegistrationEntry("2002", "Minor", "Correct", 0);
            db1.insertRegistrationEntry("2003", "Minor", "Correct", 0);
            db1.insertRegistrationEntry("2004", "Minor", "Correct", 0);
            db1.insertRegistrationEntry("2005", "Major", "Correct", 0);
        }
        List<Registration1> registrationList = db1.getAllRegistrations();
        for (Iterator<Registration1> iter = registrationList.iterator(); iter.hasNext(); ) {
            Registration1 registration = iter.next();
         //   severitylist.add(registration.getseverity());
          //  failurelist.add(registration.getfailure());
          // phonelist.add(registration.getPhone());
        }
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(0.8*width),(int)(0.8*height));//set percentage of width,height if needed
        l1 = findViewById(R.id.newlistmajor1);
        l2=  findViewById(R.id.end);
        final Custom_Adapter adapter = new Custom_Adapter(this , R.layout.custom_adapter , severitylist);
        final Custom_Adapter adapter1 = new Custom_Adapter(this , R.layout.custom_adapter , failurelist);
       l1.setAdapter(adapter);
       l2.setAdapter(adapter1);
       db1.initial();
        db1.update_bychoice(s1);
        List<Fun> registrationList1 = db1.setAllRegistrations();
        for (Iterator<Fun> iter = registrationList1.iterator(); iter.hasNext(); ) {
                Fun registration = iter.next();
            severitylist.add(registration.getIp());
            failurelist.add(registration.getDs());
        }
        adapter.notifyDataSetChanged();
    }
}
