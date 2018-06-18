package com.example.nichilascarrillo.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.nichilascarrillo.guessinggame.GameActivity.winningNumber;

public class ResultsActivity extends AppCompatActivity {

    private Button playagain;
    private TextView correctNumberTextView;
    private TextView resultsTextView;
    private ImageView resultsImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //TODO get winning number from internet

        playagain = findViewById(R.id.Restart_button);
        correctNumberTextView = findViewById(R.id.NUMBER_UNDERSCORE_TEXTVIEW);
         = findViewById(R.id.resultstextview);
        resultsImageView = findViewById(R.id.winning_imageview);

        setListener();


        intent = getIntent();
        if (Intent.hasExtra(winningNumber)) {
            setLosingData();
        }


    }


    private void setLosingData() {
        int winningNumber = getIntent().getIntExtra(GameActivity.winningNumber, 0);
        resultsTextView.setText("you lost");
        correctNumberTextView.setText(getString(R.string.winning_number, winningNumber));
        correctNumberTextView.setVisibility(View.VISIBLE);

        resultsImageView.setImageResource(R.drawable.losingsadface);
}


    private void setListener() {


    }


    }


}
