package com.mamunsproject.awesomecollege_user_app.Ui.Notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mamunsproject.awesomecollege_user_app.R;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {


    private RecyclerView deleteNoticeRecyclerView;
    private ProgressBar progressBar;
    private ArrayList<Notice_Data> list;
    private Notice_Adapter adapter;

    private DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notice, container, false);



        deleteNoticeRecyclerView=view.findViewById(R.id.deleteNoticeRecyclerviewid);
        progressBar=view.findViewById(R.id.progressbar_id);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");
        setRecyclerview();
        getNotice();

        return view;

    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Notice_Data data=dataSnapshot.getValue(Notice_Data.class);
                    list.add(0,data);
                }

                adapter=new Notice_Adapter(getContext(),list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

                //Mane Recycclervewi theke jegula katbe jevabe katbe thik sei recyclerview ta k e aikhane pass kore dilam jate
                //delete gula o delete thaka
                deleteNoticeRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerview(){


        deleteNoticeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticeRecyclerView.setHasFixedSize(true);



    }


}
