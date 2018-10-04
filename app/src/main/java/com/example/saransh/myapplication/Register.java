package com.example.saransh.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.zip.Inflater;

public class Register extends Fragment  {


  /*  Spinner spinner1,spinner2;
  Button btnRegistration;


    SQLiteDatabase mydb;
    String DBNAME = "PERSONS.db";
    String TABLE = "MY_TABLE";


    @Nullable
    @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_register, container, false);
            super.onCreate(savedInstanceState);
           // v.setContentView(R.layout.fragment_register);
            createTable();
            insertIntoTable();
            ArrayList<String> my_array = new ArrayList<String>();
            my_array = getTableValues();
            Spinner My_spinner = (Spinner) v.findViewById(R.id.spinner);
            ArrayAdapter my_Adapter = new ArrayAdapter(this.getActivity(), R.layout.spinner_row,
                    my_array);

            My_spinner.setAdapter(my_Adapter);
            return v;
        }
    public void createTable() {
        try {
            mydb=SQLiteDatabase.openOrCreateDatabase(DBNAME,this.getActivity().MODE_PRIVATE, null);

            mydb.execSQL("CREATE TABLE IF  NOT EXISTS " + TABLE
                    + " (IPPhone Varchar(25), DSLAM TEXT, CHOICE NUMBER);");
            mydb.close();
        } catch (Exception e) {
            Toast.makeText(this.getActivity(), "Error in creating table",
                    Toast.LENGTH_LONG);
        }
    }
    public void insertIntoTable() {
        try {
            mydb = SQLiteDatabase.openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2001','DM1','0')");
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2002','DM2','0')");
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2003','DM3','0')");
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2004','DM4','0')");
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2005','DM5','0')");
            mydb.execSQL("INSERT INTO " + TABLE
                    + "(IPPhone, DSLAM,CHOICE) VALUES('2006','DM6','0')");
            mydb.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Error in inserting into table", Toast.LENGTH_LONG);
        }
    }
    // THIS FUNCTION SHOWS DATA FROM THE DATABASE
    public ArrayList<String> getTableValues() {
    ArrayList<String> my_array = new ArrayList<String>();
        try{
        mydb = SQLiteDatabase.openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        Cursor allrows = mydb.rawQuery("SELECT * FROM " + TABLE, null);
        System.out.println("COUNT : " + allrows.getCount());

        if (allrows.moveToFirst()) {
            do {

                String IPPhone = allrows.getString(0);
                String DSLAM = allrows.getString(1);
                String CHOICE = allrows.getString(2);
                my_array.add(IPPhone);

            } while (allrows.moveToNext());
        }
        allrows.close();
        mydb.close();
    } catch (Exception e) {
        Toast.makeText(getApplicationContext(), "Error encountered.",
                Toast.LENGTH_LONG);
    }
        return my_array;
}



      /*  spinner2= v.findViewById(R.id.spinner2);
        String [] values =
                {"D1","D2","D3","D4",};
       // Spinner spinner = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
       // ArrayAdapter <String> ad= new ArrayAdapter<>()
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(LTRadapter);

        return v;/*
       // return inflater.inflate(R.layout.manual, container, false);

        //addIteamsOnspinner2();
        //addListenerOnButton();
        //addListenerOnSpinnerItemSelection();

       // return super.onCreateView(inflater, container, savedInstanceState);
    }

//  //  public void onCreate(Bundle savedInstanceState, View view){
//  //  super.onCreate(savedInstanceState);
// //   setContentView(R.layout.fragment_register);
//
//    addIteamsOnspinner2();
//   //  addListenerOnButton();
//     addListenerOnSpinnerItemSelection();
// }
/*
public void addIteamsOnspinner2(){
     spinner2=(Spinner) v.findViewById(R.id.spinner2);
     List<String> list=new ArrayList<String>();
     list.add("D1");
     list.add("D2");
     list.add("D3");
    ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner2.setAdapter(dataAdapter);
}
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnRegistration = (Button) findViewById(R.id.btnregistration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               Toast toast= Toast.makeText(Register.this, "OnClickListener : " + "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) + "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

        });
    }
*/
  TextView t1;
  pop p1=new pop();
    Spinner spinner1, spinner2;
    ListView l1,l2;
    Button btnRegistration,btndeRegistration;
    private DataHelper db;
    private List<String> IPPhoneslist = new ArrayList<>();
    private List<String> Dslamlist = new ArrayList<>();
    public static List<String> IPPhoneslist1 = new ArrayList<>();
    public static List<String> Dslamlist1 = new ArrayList<>();
    public int count=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        db = new DataHelper(this.getActivity());
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        db.insertRegistrationEntry("CHOOSE AN OPTION", "CHOOSE AN OPTION", 0);
        db.insertRegistrationEntry("2001", "d1", 0);
        db.insertRegistrationEntry("2002", "d2", 0);
        db.insertRegistrationEntry("2003", "d3", 0);
        db.insertRegistrationEntry("2004", "d4", 0);
        db.insertRegistrationEntry("2005", "d5", 0);
        List<Registration> registrationList = db.getAllRegistrations();
       for (Iterator<Registration> iter = registrationList.iterator(); iter.hasNext(); ) {
            Registration registration = iter.next();
            IPPhoneslist.add(registration.getPhone());
            Dslamlist.add(registration.getDslam());

        }
        spinner1 = v.findViewById(R.id.spinner1);
        // spinner1.setPrompt("Choose an IP");
      //  String[] spinner1Values = {"2001", "2002", "2003", "2004"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, IPPhoneslist);
      //  spinner1.setPrompt("Choose an IPPhone");
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);
        spinner2 = v.findViewById(R.id.spinner2);
     //   String[] values = {"D1", "D2", "D3", "D4",};
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, Dslamlist);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
      //  spinner2.setPrompt("Choose");

        spinner2.setAdapter(LTRadapter);
        l1 = v.findViewById(R.id.qert);
        l2=v.findViewById(R.id.qert1);
       // final ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, IPPhoneslist1);
       //final Custom_Adapter adapter= new Custom_Adapter(v.getContext(),IPPhoneslist1);
       final Custom_Adapter adapter = new Custom_Adapter(this.getActivity() , R.layout.custom_adapter , IPPhoneslist1);
        //final ArrayAdapter<String> adapter2=new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,Dslamlist1);
        final Custom_Adapter adapter2 = new Custom_Adapter(this.getActivity() , R.layout.custom_adapter , Dslamlist1);
        l1.setAdapter(adapter);
        l2.setAdapter(adapter2);
        btnRegistration = v.findViewById(R.id.btnregistration);

            btnRegistration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    IPPhoneslist1.clear();
                    Dslamlist1.clear();
                String text = spinner1.getSelectedItem().toString();
                   if (!text.equals("CHOOSE AN OPTION")) {
                        db.update_byphone(text);

                        List<Fun> registrationList1 = db.setAllRegistrations();
                        for (Iterator<Fun> iter = registrationList1.iterator(); iter.hasNext(); ) {
                            Fun registration = iter.next();
                            IPPhoneslist1.add(registration.getIp());
                            Dslamlist1.add(registration.getDs());
                            count++;
                        }
                        adapter.notifyDataSetChanged();
                   }

                  /*  String text1 = spinner2.getSelectedItem().toString();
                    if (!text1.equals("null")) {
                        db.update_bydslam(text1);
                        List<Registration> registrationList1 = db.setAllRegistrations();
                    }*/
                }

            });
        btndeRegistration = v.findViewById(R.id.btnderegistration);
        btndeRegistration.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String text = spinner1.getSelectedItem().toString();
                if (!text.equals("CHOOSE AN OPTION")) {
                    db.initial(text);
                   IPPhoneslist1.clear();
                    Dslamlist1.clear();
                    List<Fun> registrationList1 =   db.setAllRegistrations();
                    for (Iterator<Fun> iter = registrationList1.iterator(); iter.hasNext(); ) {
                        Fun registration = iter.next();
                        IPPhoneslist1.add(registration.getIp());
                        Dslamlist1.add(registration.getDs());
                    }
                    adapter.notifyDataSetChanged();
                }
                }
        });

            return v;
            // db.deleteRegistrationEntry(registration);
        }


    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
            getActivity().setTitle("Register");



    }


    }

