package com.ibm.recipesapp.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ibm.recipesapp.R;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firestore = FirebaseFirestore.getInstance();
    }

//    public void Test(){
//        User user1 = new User("Bob");
//        User user2 = new User("Sara");
//        User user3 = new User("Harry");
//        firestore.collection("test").document("test1").set(user1);
//        firestore.collection("test").document("test2").set(user2);
//        firestore.collection("test").document("practice").set(user3);
//    }
}