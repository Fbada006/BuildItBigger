package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.disruption.jokedisplayactivity.JokeActivity;
import com.disruption.killerjokes.KillerJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        RequestConfiguration requestConfiguration
                = new RequestConfiguration.Builder()
                .setTestDeviceIds(new ArrayList<>(Collections.singletonList(AdRequest.DEVICE_ID_EMULATOR)))
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);

        root.findViewById(R.id.tellJoke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String randomKillerJoke = new KillerJokes().getRandomKillerJoke();
                Intent jokeIntent = new Intent(getActivity(), JokeActivity.class);
                jokeIntent.putExtra(JokeActivity.RANDOM_KILLER_JOKE_KEY, randomKillerJoke);
                startActivity(jokeIntent);
            }
        });

        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
