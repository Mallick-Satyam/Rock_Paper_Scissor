package com.example.game_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivity" ;

    TextView User_Selection, Comp_Selection, WonLost, Score;

    int user_score = 0, comp_score = 0 ;
    Random rand ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       User_Selection = findViewById(R.id.User_Selection);
       Comp_Selection = findViewById(R.id.Comp_Slection) ;
       WonLost = findViewById(R.id.WonLost) ;
       Score = findViewById(R.id.Score) ;

       User_Selection.setText("") ;
       Comp_Selection.setText("") ;
       WonLost.setText("") ;

       rand = new Random() ;




    }

    public void resetButton(View view) {

        WonLost.setText("LETS START AGAIN") ;
        User_Selection.setText("") ;
        Comp_Selection.setText("") ;
        user_score = 0;
        comp_score = 0;
        setScoew(user_score,comp_score);
    }

    public void rpsButtonSelected(View view) {



        int selection = Integer.parseInt(view.getTag().toString()) ;
        matchgame(selection);
    }
    private void matchgame(int User_select)
    {
        int low = 1 ;
        int high = 3 ;

        int comp_select = rand.nextInt(high) + low ;

        if(User_select == comp_select)
        {
            //TIE
            WonLost.setText("Its A Tie") ;


        }
        else if((User_select - comp_select) % 3 == 1 || (User_select - comp_select) % 3 == -2)
        {
            //User Wins
            user_score ++ ;
            WonLost.setText(" CONGRATS, YOU WON") ;
        }
        else
        {
            //Comp WINS
            comp_score ++ ;
            WonLost.setText("OOPS, YOU LOST") ;
        }
        switch (User_select)
        {
            case 1:
                User_Selection.setText("ROCK") ;
                break;
            case 2:
                User_Selection.setText("PAPER") ;
                break;
            case 3:
                User_Selection.setText("SCISSOR") ;
                break;
        }
        switch (comp_select)
        {
            case 1:
                Comp_Selection.setText("ROCK") ;
                break;
            case 2:
                Comp_Selection.setText("PAPER") ;
                break;
            case 3:
                Comp_Selection.setText("SCISSOR") ;
                break;
        }

        setScoew(user_score,comp_score);

    }

    private void setScoew(int user_score, int comp_score)
    {
        Score.setText(String.valueOf(user_score) + " : " + String.valueOf(comp_score)) ;
    }
}