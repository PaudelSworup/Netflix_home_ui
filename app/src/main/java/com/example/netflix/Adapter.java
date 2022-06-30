package com.example.netflix;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
LayoutInflater inflater;
List<Movie> movies;
Context context;
View view;

    public Adapter( Context context ,List<Movie> movies) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.layout_netflix,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie film = movies.get(position);
        String images = film.getPoster_path();
        Picasso.get().load(images).into(holder.rowImage);
        Picasso.get().load(images).into(holder.rowImage1);
        Picasso.get().load(images).into(holder.rowImage2);
        Picasso.get().load(images).into(holder.rowImage3);
//

    }

    @Override
    public int getItemCount() {
      return  movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rowImage, rowImage1, rowImage2, rowImage3;
        TextView txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowImage = itemView.findViewById(R.id.netflixImage);
            rowImage1 = itemView.findViewById(R.id.netflixImage1);
            rowImage2 = itemView.findViewById(R.id.netflixImage2);
            rowImage3 = itemView.findViewById(R.id.netflixImage3);
//
        }
    }
}
