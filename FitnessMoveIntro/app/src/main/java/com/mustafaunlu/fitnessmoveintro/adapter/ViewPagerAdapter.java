package com.mustafaunlu.fitnessmoveintro.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mustafaunlu.fitnessmoveintro.fragment.DetailsFragment;
import com.mustafaunlu.fitnessmoveintro.fragment.PicturesFragment;

public class ViewPagerAdapter  extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment selectedFragment;

        switch (position){
            case 0:
                selectedFragment= PicturesFragment.newInstance();
                break;
            case 1:
                selectedFragment= DetailsFragment.newInstance();
                break;
            default:
                return null;

        }
        return  selectedFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

