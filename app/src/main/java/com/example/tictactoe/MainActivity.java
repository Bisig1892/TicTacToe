package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticktacktoe.R;

public class MainActivity extends AppCompatActivity {

    /*
        button grid layout for game
        1 2 3
        4 5 6
        7 8 9
    */

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button newGame;

    TextView playerTurn;
    int player;
    String currPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTurn = findViewById(R.id.playerTurnText);
        newGame = findViewById(R.id.newGameButton);

        registerButtons();
        gameSetup();
    }

    public void gameSetup(){
        player = 1;
        currPlayer = currentPlayer((player));

        setButtonText();

        playerTurn.setText("Player " + currPlayer + "'s turn");
        newGame.setText("New game");
    }

    public String currentPlayer(int player) {
        if(player % 2 == 0) {
            return "O";
        } else {
            return "X";
        }
    }

    public void nextTurn(Button buttonClicked) {
        player++;
        currPlayer = currentPlayer(player);
        playerTurn.setText("Player " + currPlayer + "'s turn");
        buttonClicked.setEnabled(false);
    }

    public void onClick(View v) {
        if (v.equals(button1)) {
            button1.setText(currPlayer);
            nextTurn(button1);
        } else if (v.equals(button2)) {
            button2.setText(currPlayer);
            nextTurn(button2);
        } else if (v.equals(button3)) {
            button3.setText(currPlayer);
            nextTurn(button3);
        } else if (v.equals(button4)) {
            button4.setText(currPlayer);
            nextTurn(button4);
        } else if (v.equals(button5)) {
            button5.setText(currPlayer);
            nextTurn(button5);
        } else if (v.equals(button6)) {
            button6.setText(currPlayer);
            nextTurn(button6);
        } else if (v.equals(button7)) {
            button7.setText(currPlayer);
            nextTurn(button7);
        } else if (v.equals(button8)) {
            button8.setText(currPlayer);
            nextTurn(button8);
        } else if (v.equals(button9)) {
            button9.setText(currPlayer);
            nextTurn(button9);
        } else if(v.equals(newGame)) {
            gameSetup();
        }
    }

    private void registerButtons() {
        button1 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button8);
        button3 = findViewById(R.id.button9);
        button4 = findViewById(R.id.button17);
        button5 = findViewById(R.id.button18);
        button6 = findViewById(R.id.button19);
        button7 = findViewById(R.id.button20);
        button8 = findViewById(R.id.button21);
        button9 = findViewById(R.id.button22);
    }

    private void setButtonText() {
        button1.setEnabled(true);
        button1.setText(" ");
        button2.setEnabled(true);
        button2.setText(" ");
        button3.setEnabled(true);
        button3.setText(" ");
        button4.setEnabled(true);
        button4.setText(" ");
        button5.setEnabled(true);
        button5.setText(" ");
        button6.setEnabled(true);
        button6.setText(" ");
        button7.setEnabled(true);
        button7.setText(" ");
        button8.setEnabled(true);
        button8.setText(" ");
        button9.setEnabled(true);
        button9.setText(" ");
    }


}