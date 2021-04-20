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
        list.add(new BranchModel(R.drawable.ic_baseline_computer_24,"Computer Science","Computer Science and Engineearing started in year 2015.At present intake sheet in 1year is 30 student"));
        list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical","Computer Science and Engineearing started in year 2015.At present intake sheet in 1year is 30 student"));

        adapter=new BranchAdapter(getContext(),list);

        viewPager=view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);


        ImageView imageView=view.findViewById(R.id.collegeImage);
        Glide.with(getContext()).load("https://images.unsplash.com/photo-1597688454919-cef3391fa915?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8Y29sbGFnZXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60").into(imageView);


        return view;


    }
}