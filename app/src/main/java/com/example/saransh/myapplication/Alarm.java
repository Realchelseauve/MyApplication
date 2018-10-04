package com.example.saransh.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Alarm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Alarm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Alarm extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Alarm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Alarm.
     */
    // TODO: Rename and change types and number of parameters
    public static Alarm newInstance(String param1, String param2) {
        Alarm fragment = new Alarm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private List<String> severitylist = new ArrayList<>();
    private List<String> failurelist = new ArrayList<>();
    private List<String> phonelist=new ArrayList<>();
    private DataHelper db;
    private DataHelper1 db1;
    ListView l1,l2,l3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = new DataHelper(this.getActivity());
        db1=new DataHelper1(this.getActivity());
        View v= inflater.inflate(R.layout.fragment_alarm, container, false);
        getActivity().setTitle("ALARM");
        l1=v.findViewById(R.id.thelast);
        l2=v.findViewById(R.id.ram);
        l3=v.findViewById(R.id.comp);
        final Custom_Adapter adapter = new Custom_Adapter(this.getActivity() , R.layout.custom_adapter , severitylist);
        final Custom_Adapter adapter1 = new Custom_Adapter(this.getActivity() , R.layout.custom_adapter , failurelist);
        final Custom_Adapter adapter2 = new Custom_Adapter(this.getActivity() , R.layout.custom_adapter , phonelist);
        l1.setAdapter(adapter2);
        l2.setAdapter(adapter);
        l3.setAdapter(adapter1);
        List<Fun> registrationList1 = db.setAllRegistrations();
        for (Iterator<Fun> iter = registrationList1.iterator(); iter.hasNext(); ) {
            Fun registration = iter.next();
            String ip1 = registration.getIp();
            List<Fun> registrationList2 = db1.finalfunction(ip1);
            Iterator<Fun> iter1 = registrationList2.iterator();
                Fun registration1 = iter1.next();
                severitylist.add(registration1.getIp());
                failurelist.add(registration1.getDs());
                phonelist.add(registration1.getPh());


        }
        adapter.notifyDataSetChanged();
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
