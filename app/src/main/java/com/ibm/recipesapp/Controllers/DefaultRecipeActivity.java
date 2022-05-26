package com.ibm.recipesapp.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ibm.recipesapp.R;
import com.ibm.recipesapp.Recipe.Recipe;
import com.ibm.recipesapp.User.User;
import com.ibm.recipesapp.recipesRecyclerAdapter;

import java.util.ArrayList;

public class DefaultRecipeActivity extends AppCompatActivity {
    private ArrayList<Recipe> recipeList;
    private RecyclerView recyclerView;
    private recipesRecyclerAdapter.RecyclerViewClickListener listener;
    User user;

    private String hamburgerImageURL = "https://firebasestorage.googleapis.com/v0/b/recipeapp-53903.appspot.com/o/hamburger.png?alt=media&token=a249f98e-ca36-4152-9472-76c5ffc2613a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_recipe);

        recyclerView = findViewById(R.id.recyclerView_RecyclerView_DefaultRecipeActivity);
        user = (User) getIntent().getSerializableExtra("user");
        recipeList = new ArrayList<>();
        setRecipeInfo();
        setAdapter();
    }

    private void setAdapter(){
        setOnClickListener();

    }

    private void setOnClickListener(){
        listener = (view, position) ->
        {
            Intent goToAddDefaultRecipeActivity = new Intent(getApplicationContext(),
                    AddDefaultRecipeActivity.class);
            goToAddDefaultRecipeActivity.putExtra("image", recipeList.get(position).getRecipeImage());
            goToAddDefaultRecipeActivity.putExtra("name", recipeList.get(position).getRecipeName());
            goToAddDefaultRecipeActivity.putExtra("user", user);
            startActivity(goToAddDefaultRecipeActivity);
        };
    }

    private void setRecipeInfo(){
        recipeList.add(new Recipe(null, "Hamburger", 0, 0, hamburgerImageURL, null, null));
    }

    public void goToAddRecipeActivity(View view){
        Intent goToAddRecipeActivity = new Intent(this, AddRecipeActivity.class);
        goToAddRecipeActivity.putExtra("user", user);
        startActivity(goToAddRecipeActivity);
    }

    public void backButton(View view){
        Intent goBack = new Intent(this, RecipesActivity.class);
        goBack.putExtra("user", user);
        startActivity(goBack);
    }
}