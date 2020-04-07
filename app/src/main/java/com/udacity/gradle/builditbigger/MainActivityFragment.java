package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.disruption.jokedisplayactivity.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivityFragment extends Fragment {
    private static final String TAG = "MainActivityFragment";

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
                new EndpointAsyncTask().execute(new OnJokeLoaded() {
                    @Override
                    public void jokeLoaded(String randomKillerJoke) {
                        Log.e(TAG, "jokeLoaded: ==================== " + randomKillerJoke);
                        Intent jokeIntent = new Intent(getActivity(), JokeActivity.class);
                        jokeIntent.putExtra(JokeActivity.RANDOM_KILLER_JOKE_KEY, randomKillerJoke);
                        startActivity(jokeIntent);
                    }
                });
            }
        });

        AdView mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
