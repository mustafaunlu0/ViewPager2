package com.mustafaunlu.fitnessmoveintro.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.mustafaunlu.fitnessmoveintro.R;
import com.mustafaunlu.fitnessmoveintro.fragment.PopUpFragment;
import com.mustafaunlu.fitnessmoveintro.model.FitnessMove;

public class PopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.frameLayout);

        if(fragment == null){
            fragment= PopUpFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.frameLayout,fragment).commit();
        }

    }


    public static Intent newIntent(Context context, FitnessMove fitnessMove){
        Intent intent=new Intent(context,PopUpActivity.class);
        intent.putExtra("INFO",fitnessMove);
        return intent;
    }


}