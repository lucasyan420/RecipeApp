package com.ibm.recipesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibm.recipesapp.Recipe.Recipe;

import java.util.ArrayList;

public class recipesRecyclerAdapter extends RecyclerView.Adapter<recipesRecyclerAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeList;
    private RecyclerViewClickListener listener;

    public recipesRecyclerAdapter(ArrayList<Recipe> recipeList, RecyclerViewClickListener listener){
        this.recipeList = recipeList;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView recipeName;


        public ViewHolder(final View view){
            super(view);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface RecyclerViewClickListener
    {
        void onClick(View v, int position);
    }
}
