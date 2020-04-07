package com.disruption.jokedisplayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {

    public static final String RANDOM_KILLER_JOKE_KEY = "random killer jokekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        setTitle(getString(R.string.label_joke_activity));

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JokeActivity.RANDOM_KILLER_JOKE_KEY);

        TextView jokeTextView = findViewById(R.id.jokeText);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}
