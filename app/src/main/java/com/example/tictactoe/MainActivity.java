package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticktacktoe.R;

public class MainActivity extends AppCompatActivity {

    /* game button layout
        1 2 3
        4 5 6
        7 8 9
     */

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button NewGameBtn;

    // X and O
    private final String player1 = "X";
    private final String player2 = "O";

    // game turns
    private String currentTurn;
    private TextView playerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning the game buttons
        assignButtons();

        // assigning the currentTurn to player
        currentTurn = player1;

        // assigning the playerTurn and setting the text
        playerTurn = findViewById(R.id.PlayerTurnTxt);
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }

    private void assignButtons() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        NewGameBtn = findViewById(R.id.NewGameBtn);
    }

    // onClick method
    public void onClick(View view)
    {
        // game buttons
        Button[] buttons = {button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9};
        // when a button is clicked
        Button clickedButton = buttonClicked(view, buttons);
        // if the button was clicked and the text is blank
        if (clickedButton != null && ( clickedButton.getText().equals("") )){
            buttonSetText(clickedButton);
            // check for a win or a tie, if no win is detected then swap players
            if ( winningConditions(buttons)){
                playerTurn.setText("Player " + currentTurn + " has won");
                disableButtons(buttons);
            }
            else if (tieCondition(buttons)) {
                playerTurn.setText("It's a tie!");
                disableButtons(buttons);
            }
            else {
                setPlayerTurn();
            }
        }

    }

    // returns the button that was clicked (returns null if no button clicked)
    private Button buttonClicked(View v, Button[] buttons){
        for ( Button button : buttons ){
            if ( v == button ){
                return button;
            }
        }
        return null;
    }

    // marks either an X or O on a button that was clicked
    private void buttonSetText(Button button){
        button.setText(currentTurn);
    }

    // swaps the currentTurn and the playerTurn text
    private void setPlayerTurn(){
        if ( currentTurn.equals(player1)){
            currentTurn = player2;
        }
        else{
            currentTurn = player1;
        }
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }

    // when the new game button is clicked
    public void gameReset(View view) {
        Button[] buttons = {button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9};
        // for each loop that clears text off game buttons
        for(Button b :buttons){
            b.setText("");
        }
        // enable the buttons
        enableButtons(buttons);
        // reset turn
        if(currentTurn.equals(player2)) {
            setPlayerTurn();
        }
        // reset player text
        resetText();
    }

    // returns true if a win is detected for the current player
    private boolean winningConditions(Button[] buttons){
        // row win
        // top row is boxes 1, 2, 3
        if ( button1.getText().equals(currentTurn) &&
                button2.getText().equals(currentTurn) &&
                button3.getText().equals(currentTurn) ){
            return true;
        }
        // middle row is boxes 4, 5, 6
        else if ( button4.getText().equals(currentTurn) &&
                button5.getText().equals(currentTurn) &&
                button6.getText().equals(currentTurn)){
            return true;
        }
        // bottom row is boxes 7, 8, 0
        else if ( button7.getText().equals(currentTurn) &&
                button8.getText().equals(currentTurn) &&
                button9.getText().equals(currentTurn)){
            return true;
        }

        // column win
        //left col is boxes 1, 4, 7
        if ( button1.getText().equals(currentTurn) &&
                button4.getText().equals(currentTurn) &&
                button7.getText().equals(currentTurn)){
            return true;
        }
        //center col is boxes 2, 5, 8
        else if ( button2.getText().equals(currentTurn) &&
                button5.getText().equals(currentTurn) &&
                button8.getText().equals(currentTurn)){
            return true;
        }
        //right col is boxes 3, 6, 9
        else if ( button3.getText().equals(currentTurn) &&
                button6.getText().equals(currentTurn) &&
                button9.getText().equals(currentTurn)){
            return true;
        }

        //diagonal win
        // all boxes 1, 5, and 9 OR boxes 7, 5, and 3 need to be marked with the same symbol
        if ( button1.getText().equals(currentTurn) && // box 1
                button5.getText().equals(currentTurn) && // box 5
                button9.getText().equals(currentTurn)){ // box 9
            return true;
        }
        if ( button7.getText().equals(currentTurn) && //box 7
                button5.getText().equals(currentTurn) && // box 5
                button3.getText().equals(currentTurn)){ // box 3
            return true;
        }
        // no win detected
        return false;
    }


    // return true if a tie is detected (no more boxes to play)
    private boolean tieCondition(Button[] buttons){
        // a tie is when all boxes are filled and neither players got three boxes in a row
        for (Button b: buttons){
            if (b.getText()==""){
                return false;
            }
        }
        return true;
    }

    // no buttons can be played until a new game is started
    private void disableButtons(Button[] buttons){
        for (Button b: buttons){
            b.setClickable(false);
        }
    }

    // buttons can be played
    private void enableButtons(Button[] buttons){
        for( Button b: buttons){
            b.setClickable(true);
        }
    }

    private void resetText(){
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }
}
