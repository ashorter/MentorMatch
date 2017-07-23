package com.example.ashley.mentormatch;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.button2;

/**
 * Created by Ashley on 5/9/2017.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.main);

            Button button = (Button) findViewById(R.id.buttonSignIN);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            });
        }
    public void signUp(View view)
    {
        Intent intent = new Intent(HomeActivity.this, MainMsgActivity.class);
        startActivity(intent);
    }
}
