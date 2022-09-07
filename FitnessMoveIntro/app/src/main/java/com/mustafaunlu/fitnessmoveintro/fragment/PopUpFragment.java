package com.mustafaunlu.fitnessmoveintro.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafaunlu.fitnessmoveintro.R;
import com.mustafaunlu.fitnessmoveintro.databinding.FragmentPopUpBinding;
import com.mustafaunlu.fitnessmoveintro.model.FitnessMove;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class PopUpFragment extends Fragment {

    private FitnessMove fitnessMove;

    private FragmentPopUpBinding binding;
    public static PopUpFragment newInstance() {
        return new PopUpFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        fitnessMove=getActivity().getIntent().getParcelableExtra("INFO");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPopUpBinding.inflate(inflater,container,false);


        binding.popUpNameTextView.setText(fitnessMove.getFitnessName());
        binding.popUpDescriptionTextView.setText(fitnessMove.getFitnessDescription());
        binding.popUpCaloriesTextView.setText(""+fitnessMove.getFitnessCalorie());

        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(binding.popUpImageView, new Callback() {
            @Override
            public void onSuccess() {
                binding.popUpProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
        return binding.getRoot();
    }
}