package com.example.nichilascarrillo.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private Button guessButton;
    private TextView clue;
    private EditText guess;

    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;
    public static final String winningNumber = "WINNING_NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guessButton = findViewById(R.id.submit_guess_button);
        clue = findViewById(R.id.clue_underscore_textview);
        guess = findViewById(R.id.guess_edit_text);


        generatedNumber = (int) Math.ceil(Math.random() * 100);

//   Toast.makeText(this, Integer.toString(generatedNumber), Toast.LENGTH_SHORT).show();

        setListener();
    }

    private void setListener() {
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                validateGuess();
            }
        });
    }

    private void validateGuess() {

        try {
            int userGuess = Integer.parseInt(guess.getText().toString());
            if (userGuess > 100 || userGuess <= 0) {
                clue.setText("Enter a number between 1 and 100");
                clue.setVisibility(View.VISIBLE);
                guess.setText("");
            } else {
                checkGuess(userGuess);
            }
        } catch (
                NumberFormatException nfe) {
            clue.setText("Enter a number");
            clue.setVisibility(View.VISIBLE);
        }
    }

    private void checkGuess(int userGuess) {

        if (userGuess == generatedNumber) {
            //Goes to ResultsActivity.  User has guessed correctly
            Intent winner = new Intent(this, ResultsActivity.class);

        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            // Go to ResultsActivity, user has ran out of chances
            Intent loser = new Intent(this, ResultsActivity.class);
            loser.putExtra(winningNumber, generatedNumber);
            startActivity(loser);
        } else if (userGuess < generatedNumber) {
            //TODO, Update clue TextView to say higher, set visibility to Visibile, set guess EditText to "" and increment numberOfGuesses by 1
            clue.setText(R.String.higher);
            clue.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;

        } else if (userGuess > generatedNumber) {
            //TODO, Update clue TextView to say lower, set visibility to Visible, set guess EditText to "" and increment numberOfGuesses by 1
            clue.setText("Lower");
            clue.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        }

    }

    @Override
    public void onBackPressed() {
//        removed super.onBackPress(); to make sure if the back button is pressed nothing will happen
    }


}






