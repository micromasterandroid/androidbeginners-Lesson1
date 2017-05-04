package com.example.bhlr.clickscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.textView4);
        quantityTextView.setText("" + number);
    }

    public void submitCount(View view) {
        count = count + 1;
        display(count);
    }
    public void resetCount(View view) {
        count = 0;
        display(count);
    }
}
