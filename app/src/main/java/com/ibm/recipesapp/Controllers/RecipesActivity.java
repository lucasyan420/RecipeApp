package com.ibm.recipesapp.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ibm.recipesapp.R;
import com.ibm.recipesapp.Recipe.Recipe;
import com.ibm.recipesapp.Rewards.Pet;
import com.ibm.recipesapp.User.User;
import com.ibm.recipesapp.recipesRecyclerAdapter;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {
    private ArrayList<Recipe> recipeList;
    private RecyclerView recyclerView;
    private TextView noRecipes;
    private ImageView noRecipesImage;

    private recipesRecyclerAdapter.RecyclerViewClickListener listener;
    recipesRecyclerAdapter adapter;

    Pet userPet;
    FirebaseAuth mAuth;
    FirebaseFirestore firestore;
    FirebaseUser mUser;
    User user;
    String intentTime;
    ImageView goPetActivityButton;
    boolean hasRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipeList = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        
        recyclerView = findViewById(R.id.recyclerView_RecyclerView_RecipesActivity);
        goPetActivityButton = findViewById(R.id.goToPetActivity_ImageView_RecipesActivity);
        noRecipes = findViewById(R.id.noRecipes_TextView_RecipesActivity);
        noRecipesImage = findViewById(R.id.cooking_ImageView_RecipesActivity);
        noRecipesImage.setVisibility(View.INVISIBLE);
        
        intentTime = (String) getIntent().getSerializableExtra("Time");
        
        getUser();
    }

    private void getUser() {
        try
        {
            firestore.collection("users").document(mUser.getUid()).get()
                    .addOnCompleteListener(task ->
                    {
                        DocumentSnapshot ds = task.getResult();
                        if (task.isSuccessful())
                        {
                            user = ds.toObject(User.class);
                            userPet = user.getUserPet();
                            Log.d("USER OBJECT", "user name: " + user.getUserName());
                            recipeList = user.getUserRecipes();

                            if (recipeList.size() == 0)
                            {
                                hasRecipes = false;
                                showNoRecipes();
                                noRecipesImage.setVisibility(View.VISIBLE);
                            } else
                            {
                                hasRecipes = true;
                            }
                            setAdapter();
                            setPetImage(user);
                        }
                    });
        } catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "error getting user", Toast.LENGTH_SHORT).show();
        }
    }

    public void showNoRecipes() {
        if (hasRecipes == false)
        {
            noRecipes.setText("Start Creating Recipes");
        } else
        {
            noRecipes.setText(null);
        }
    }

    private void setAdapter(){
        setOnClickListener();
        adapter = new recipesRecyclerAdapter(recipeList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener(){

    }

    private void setPetImage(User user) {
    }

    public void goToDefaultRecipeActivity(View view){
        Intent goToDefaultRecipeActivity = new Intent(this, DefaultRecipeActivity.class);
        goToDefaultRecipeActivity.putExtra("user", user);
        startActivity(goToDefaultRecipeActivity);
    }

    public void signOut(View view){
        mAuth.signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}