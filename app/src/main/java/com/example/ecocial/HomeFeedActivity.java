package com.example.ecocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFeedActivity extends AppCompatActivity {

    ListView postsList;
//    String[] samplePosts; // Temporary for testing only.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_feed_activity);

        // For "go to account settings" button
        Button accountSettingsButton = (Button) findViewById(R.id.account_settings_button);
        accountSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFeedActivity.this, AccountSettingsActivity.class));
            }
        });

        postsList = findViewById(R.id.posts_list);
//        samplePosts = new String[] {"Today I planted a tree", "Don't use plastic", "Recycle your water bottles",
//                "Buy only what you'll eat", "Donate to non-profits"};
//        ArrayAdapter<String> postsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, samplePosts);
//        postsList.setAdapter(postsAdapter);

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("Today I planted an apple", "To plant a tree you need ABC",
                "UserA", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted a banana", "To plant a tree you need DEF",
                "UserB", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted an orange", "To plant a tree you need HIJ",
                "UserB", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted a melon", "To plant a tree you need KLM",
                "UserC", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted a lemon", "To plant a tree you need NOP",
                "UserD", "23 Nov, 2021. 3.30pm",  "5", "6"));
        posts.add(new Post("Today I planted a tomato", "To plant a tree you need QRS",
                "UserE", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted a carrot", "To plant a tree you need TUV",
                "UserF", "23 Nov, 2021. 3.30pm", "5", "6"));
        posts.add(new Post("Today I planted an onion", "To plant a tree you need WXYZ",
                "UserG", "23 Nov, 2021. 3.30pm", "5", "6"));

        PostAdapter postAdapter = new PostAdapter(this, R.layout.feed_list_item, posts);
        postsList.setAdapter(postAdapter);

    }
}