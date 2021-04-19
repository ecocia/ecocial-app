package com.example.ecocial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Post> {

    private Context mContext;
    private int mResource;

    public PostAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Post> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtPostSubject = convertView.findViewById(R.id.post_subject_text_view);
        TextView txtPostContent = convertView.findViewById(R.id.post_content_text_view);
        TextView txtUserName = convertView.findViewById(R.id.user_name_text_view);
        TextView txtTimeDatePosted = convertView.findViewById(R.id.post_date_time);
        TextView txtNumComments = convertView.findViewById(R.id.num_comments);
        TextView txtNumLikes = convertView.findViewById(R.id.num_likes);

        txtPostSubject.setText(getItem(position).getPostSubject());
        txtPostContent.setText(getItem(position).getPostContent());
        txtUserName.setText(getItem(position).getUserName());
        txtTimeDatePosted.setText(getItem(position).getPostedDateTime());
        txtNumComments.setText(getItem(position).getNumComments());
        txtNumLikes.setText(getItem(position).getNumLikes());



        return convertView;
    }
}


