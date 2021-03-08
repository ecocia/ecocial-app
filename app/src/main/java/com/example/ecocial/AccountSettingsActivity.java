package com.example.ecocial;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecocial.data.UserDBHelper;

public class AccountSettingsActivity extends AppCompatActivity {
    // UI code + data editing code

    UserDBHelper mDBHelper;
    Button btnAddData, btnShowData, btnUpdateData, btnDelete;
    EditText etName, etPassword, etID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_settings_activity);

        mDBHelper = new UserDBHelper(this);

        etName = (EditText) findViewById(R.id.edit_text_name);
        etPassword = (EditText) findViewById(R.id.edit_text_password);
        btnAddData = (Button) findViewById(R.id.button_add_data);
        btnShowData = (Button) findViewById(R.id.button_view_data);
        btnUpdateData = (Button) findViewById(R.id.button_update_data);
        etID = (EditText) findViewById(R.id.edit_text_id);
        btnDelete = (Button) findViewById(R.id.button_delete);

        addData();
        viewData();
        updateData();
        deleteData();
    }


    public void addData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();

                boolean insertedData = mDBHelper.addData(name, password);
                if (insertedData) {
                    Toast.makeText(AccountSettingsActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AccountSettingsActivity.this, "Data could not be inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void viewData() {
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = mDBHelper.showData();

                if (data.getCount() == 0) {
                    // Alert message
                    display("Error", "No data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(data.moveToNext()) {
                    buffer.append("ID " + data.getString(0) + "\n");
                    buffer.append("Name: " + data.getString(1) + "\n");
                    buffer.append("Password: " + data.getString(2) + "\n");
                }
                //display message
                display("All Stored Data: ", buffer.toString());
            }
        });
    }

    public void display(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void updateData() {
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = etID.getText().toString().length();
                if (temp > 0) {
                    boolean update = mDBHelper.updateData(etID.getText().toString(), etName.getText().toString(),
                            etPassword.getText().toString());
                    if (update) {
                        Toast.makeText(AccountSettingsActivity.this, "Successfully updated data", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AccountSettingsActivity.this, "Could not update date", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(AccountSettingsActivity.this, "You must enter an ID to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = etID.getText().toString().length();
                if (temp > 0) {
                    Integer deleteRow = mDBHelper.deleteData(etID.getText().toString());
                    if (deleteRow > 0) {
                        Toast.makeText(AccountSettingsActivity.this, "Row successfully deleted", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AccountSettingsActivity.this, "Could not delete row", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(AccountSettingsActivity.this, "You must enter an ID to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
