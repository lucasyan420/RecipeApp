package com.ibm.recipesapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibm.recipesapp.Recipe.Recipe;

import java.util.ArrayList;

public class defaultRecipesRecyclerAdapter extends RecyclerView.Adapter<defaultRecipesRecyclerAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeList;
    private defaultRecipesRecyclerAdapter.RecyclerViewClickListener listener;

    public defaultRecipesRecyclerAdapter(ArrayList<Recipe> recipeList, RecyclerViewClickListener listener){
        this.recipeList = recipeList;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView recipeName;
        private ImageView recipeImage;

        public ViewHolder(final View view){
            super(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }
}
