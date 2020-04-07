package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.disruption.jokedisplayactivity.JokeActivity;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        root.findViewById(R.id.tellJoke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointAsyncTask().execute(new OnJokeLoaded() {
                    @Override
                    public void jokeLoaded(String randomKillerJoke) {
                        Intent jokeIntent = new Intent(getActivity(), JokeActivity.class);
                        jokeIntent.putExtra(JokeActivity.RANDOM_KILLER_JOKE_KEY, randomKillerJoke);
                        startActivity(jokeIntent);
                    }
                });
            }
        });
        return root;
    }
}
