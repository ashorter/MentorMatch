package com.example.ashley.mentormatch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ashley on 5/14/2017.
 */


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;

    // Save UserInfo
    private EditText editTextName;
    private EditText editTextUniversity;
    private Button buttonSave;

    // Save location data
    //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("path/to/geofire");
    //GeoFire geoFire = new GeoFire(reference);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Save UserInfo
        Firebase.setAndroidContext(this);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUniversity = (EditText) findViewById(R.id.editTextUniversity);

        //Click Listener for button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                Firebase ref = new Firebase(Config.FIREBASE_URL);

                //Getting values to store
                String name = editTextName.getText().toString().trim();
                String university = editTextUniversity.getText().toString().trim();

                ref.setValue(editTextName.getText().toString());
                ref.setValue(editTextUniversity.getText().toString());

                //Creating user object
                final UserInformation userInformation = new UserInformation();

                //Adding values
                userInformation.setName(name);
                userInformation.setUniversity(university);

                // Storing values to firebase
                Firebase newRef = ref.child("Users").push();
                newRef.setValue(userInformation);

                // Save location
                //geoFire.setLocation("firebase-hq", new GeoLocation(37.7853889, -122.4056973));

                // Displaying notification that data has been saved
                Context context = getApplicationContext();
                CharSequence text = "Saved";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
                });

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome "+ user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
       // switch (view.getId()) {
       //     case R.id.action_profile:
       //         startActivity(new Intent(this, ProfileActivity.class));
       //         break;
       //     case R.id.action_nearby:
       //         startActivity(new Intent(this, MapsActivity.class));
       //         break;
       //     case R.id.action_messaging:
       //         startActivity(new Intent(this, MainMsgActivity.class));
       //         break;
       // }
    }
}