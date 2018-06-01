package com.dshah.fireb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
EditText editText, editText2;
Button button;

private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
         mAuth = FirebaseAuth.getInstance();
         editText = (EditText) findViewById( R.id.editText );
        editText2 = (EditText) findViewById( R.id.editText2 );
        button = (Button) findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.createUserWithEmailAndPassword( editText.getText().toString(), editText2.getText().toString() )
                        .addOnCompleteListener( MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    startActivity( new Intent(MainActivity.this,Main2Activity.class) );
                                    Log.d( "MainActivity", "createUserWithEmail:success" );
                                    FirebaseUser user = mAuth.getCurrentUser();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w( "MainActivity", "createUserWithEmail:failure", task.getException() );


                                }

                                // ...
                            }
                        } );


            }
        });}}
