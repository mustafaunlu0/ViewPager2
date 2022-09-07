package com.mustafaunlu.fitnessmoveintro.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafaunlu.fitnessmoveintro.R;
import com.mustafaunlu.fitnessmoveintro.adapter.PictureAdapter;
import com.mustafaunlu.fitnessmoveintro.databinding.FragmentPicturesBinding;
import com.mustafaunlu.fitnessmoveintro.model.FitnessMove;

import java.util.ArrayList;


public class PicturesFragment extends Fragment {

    private FragmentPicturesBinding binding;
    private PictureAdapter pictureAdapter;
    private ArrayList<FitnessMove> fitnessMoves;



    public static PicturesFragment newInstance() {
        return new PicturesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentPicturesBinding.inflate(inflater,container,false);
        pictureAdapter=new PictureAdapter((AppCompatActivity) getActivity());

        fitnessMoves=pictureAdapter.getFitnessMoves();

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        if(isAdded()){
            binding.recyclerView.setAdapter(pictureAdapter);

        }
        getFitnessMoves(fitnessMoves);



        return binding.getRoot();
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves){
        for (int i= 0; i<16;i++){
            fitnessMoves.add(new FitnessMove(
                    "Fitness Move Name "+i,
                    "https://www.atilsamancioglu.com/wp-content/uploads/2018/06/fitness"+i+".jpg",
                    "Fitness Move Description",
                    100+i
                    ));

        }
        return fitnessMoves;
    }
}