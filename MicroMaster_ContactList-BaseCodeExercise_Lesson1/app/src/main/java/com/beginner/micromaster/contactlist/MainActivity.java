package com.beginner.micromaster.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get EditText references
        nameEditText = (EditText) findViewById(R.id.input_name);
        lastNameEditText = (EditText) findViewById(R.id.input_lastName);
        emailEditText = (EditText) findViewById(R.id.input_email);
        phoneNumberEditText = (EditText) findViewById(R.id.input_phoneNumber);

        Button button = (Button) findViewById(R.id.button_create_contact);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();

                //Get values from EditText and create a new Contact
                Integer phoneNumberInt = parsePhoneNumber(phoneNumber);
                if (phoneNumberInt != null) {
                    createNewContact(name, lastName, email, phoneNumberInt);
                }
            }
        });
    }

    private void createNewContact(String name, String lastName, String email, Integer phoneNumber) {
        Contact contact = new Contact(name, lastName, email, phoneNumber);
        Log.d(TAG, "New contact created: " + contact.toString());
        clearEditText();

        Intent intent = new Intent(this, DetailActivity.class);
        //TODO: send the rest of contact parameters
        intent.putExtra("name", name);
        startActivity(intent);
    }

    private void clearEditText() {
        nameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
    }

    public static Integer parsePhoneNumber(String phoneNumber) {
        try {
            return Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
