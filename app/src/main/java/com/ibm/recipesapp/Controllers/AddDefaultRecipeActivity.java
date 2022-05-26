package com.ibm.recipesapp.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ibm.recipesapp.R;
import com.ibm.recipesapp.User.User;

public class AddDefaultRecipeActivity extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_default_recipe);

        user = (User) getIntent().getSerializableExtra("user");
    }


    public void backButton(View view){
        Intent goBack = new Intent(this, DefaultRecipeActivity.class);
        goBack.putExtra("user", user);
        startActivity(goBack);
    }
}