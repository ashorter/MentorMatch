package com.example.ashley.mentormatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Ashley on 7/7/2017.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("Welcome to the Result Activity");
    }
}
