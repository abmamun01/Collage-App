package com.mamunsproject.awesomecollege_user_app.Ui.About;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mamunsproject.awesomecollege_user_app.R;

import java.util.ArrayList;
import java.util.List;

public class About_Fragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about_, container, false);


        list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_baseline_computer_24,"গোপালদি শাঁখা",""));
       // list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical","Computer Science and Engineearing started in year 2015.At present intake sheet in 1year is 30 student"));

        adapter=new BranchAdapter(getContext(),list);

        viewPager=view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);



        return view;


    }
}