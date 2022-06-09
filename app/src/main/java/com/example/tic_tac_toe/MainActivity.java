package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    // PLAYER REPRESENTATION
    // 0 -- X(cross)
    // 1 -- O(zero)
    int activePlayer = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, };
   public int count = 0;

    // state meanings
    // 0 -- X
    // 1 -- O
    // 2 -- null

    // WINNING POSITIONS
    int [][] winingPositions =  {{0,1,2},    {3,4,5},    {6,7,8},
                                {0,3,6},    {1,4,7},    {2,5,8},
                                {0,4,8},    {2,4,6}    }   ;

    public void playerTap(View view){
        count+=1;
        ImageView img = (ImageView) view;

            int tappedImage = Integer.parseInt(img.getTag().toString());
            if(!gameActive)
            {
                gameReset(view);
            }

            if(gameState[tappedImage] == 2 )
            {
                gameState[tappedImage] = activePlayer;
                img.setTranslationY(-1000f);
                if(activePlayer == 0)
                {
                    img.setImageResource(R.drawable.cross1_ccexpress_ccexpress);
                    activePlayer = 1;
                    TextView status  = findViewById(R.id.statusBar);
                    status.setText("O's  turn (Tap To Play)");
                }
                else
                {
                    img.setImageResource(R.drawable.zero1_ccexpress);
                    activePlayer = 0;
                    TextView status  = findViewById(R.id.statusBar);
                    status.setText("X's  turn (Tap To Play)");
                }
                img.animate().translationYBy(1000f).setDuration(300);

            }

            // check if any player has won
        for(int[] winPositions : winingPositions){
            // if somebody has won
          if  (gameState[winPositions[0]] == gameState[winPositions[1]] &&  gameState[winPositions[1]] == gameState[winPositions[2] ]  && gameState[winPositions[0]]!=2)
          {
              // find out who has won

              String winnerstr;
              gameActive = false;
              if(gameState[winPositions[0]]==0)
              {
                  winnerstr = "X has won!!";
              }
              else
              {
                  winnerstr = "O has won!!";
              }

              // update the status bar for winner announcement
              TextView status  = findViewById(R.id.statusBar);
              status.setText(winnerstr);

          }
        }
        if(count==9)
        {
            String drawstr = "it's a Draw XD";
            TextView status  = findViewById(R.id.statusBar);
            status.setText(drawstr);

            gameActive = false;

        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        count =0;
        for(int i=0;    i<gameState.length;     i++)
        {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status  = findViewById(R.id.statusBar);
        status.setText("X's  turn (Tap To Play)");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}