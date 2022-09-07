package com.mustafaunlu.fitnessmoveintro.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafaunlu.fitnessmoveintro.R;
import com.mustafaunlu.fitnessmoveintro.activity.PopUpActivity;
import com.mustafaunlu.fitnessmoveintro.model.FitnessMove;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureVieHolder> {

    private ArrayList<FitnessMove> fitnessMoves;
    private LayoutInflater inflater;
    private AppCompatActivity appCompatActivity;

    public PictureAdapter(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        inflater=appCompatActivity.getLayoutInflater();
        fitnessMoves=new ArrayList<>();
    }

    public ArrayList<FitnessMove> getFitnessMoves() {
        return fitnessMoves;
    }

    @NonNull
    @Override
    public PictureVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.picture_row,parent,false);
        return new PictureVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureVieHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getPictures(holder.itemView.getContext(),fitnessMoves.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= PopUpActivity.newIntent(holder.itemView.getContext(),fitnessMoves.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }

    public static class PictureVieHolder extends RecyclerView.ViewHolder {

        ImageView image;
        ProgressBar progressBar;
        public PictureVieHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.recyclerViewImage);
            progressBar=itemView.findViewById(R.id.recyclerViewProgressBar);

        }

        public void getPictures(Context context, FitnessMove fitnessMove){
            itemView.setTag(fitnessMove);

            Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(image, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
