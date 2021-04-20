package com.mamunsproject.awesomecollege_user_app.Ui.Notice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.mamunsproject.awesomecollege_user_app.FullImageView;
import com.mamunsproject.awesomecollege_user_app.R;

import java.util.ArrayList;

public class Notice_Adapter extends RecyclerView.Adapter<Notice_Adapter.NoticeViewAdapter> {

    private Context context;
    private ArrayList<Notice_Data> list;

    public Notice_Adapter(Context context, ArrayList<Notice_Data> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_feed_item_layout, parent, false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        Notice_Data currentItem = list.get(position);

        holder.deleteNotice_Title.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getData());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Glide.with(context).load(currentItem.getImage()).into(holder.deleteNotice_Image);
        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.deleteNotice_Title.setText(currentItem.getTitle());

        holder.deleteNotice_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, FullImageView.class );
                intent.putExtra("image",currentItem.getImage());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView deleteNotice_Title, date, time;
        private ImageView deleteNotice_Image;


        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteNotice_Title = itemView.findViewById(R.id.delete_notice_title);
            deleteNotice_Image = itemView.findViewById(R.id.delete_notice_image);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);


        }
    }
}
