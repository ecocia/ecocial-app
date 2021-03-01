package com.example.ecocial;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecocial.data.UserDBHelper;

import java.util.ArrayList;

public class DisplayUsersActivity extends AppCompatActivity {

    UserDBHelper mUserDBHelper;

    private ListView mListView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_users);
    }

    public void AddData(String name, String password) {
        boolean insertedData = mUserDBHelper.addData(name, password);

        if (insertedData) {
            System.out.println("Successfully added data to DB");
        }
        else {
            System.out.println("Data not added to DB");
        }
    }

    public void populateListView() {
        Cursor data = mUserDBHelper.getData();

        ArrayList<String> listData = new ArrayList<String>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

}
