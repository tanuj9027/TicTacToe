 package com.example.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
     int activePlayer=0;
     boolean gamesetutin=true;
     int[] player={2,2,2,2,2,2,2,2,2};
     int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void dropin(View view) {
         ImageView counter = (ImageView) view;
         int tagcounter = Integer.parseInt(counter.getTag().toString());
         if (player[tagcounter] == 2 &&  gamesetutin) {
             player[tagcounter]=activePlayer;

             counter.setTranslationY(-1000f);
             if (activePlayer == 0) {
                 counter.setImageResource(R.drawable.xo);
                 activePlayer = 1;
             } else {
                 counter.setImageResource((R.drawable.oo));
                 activePlayer = 0;

             }
             counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
             for (int[] i :winpos)
             {

                 if(player[i[0]]==player[i[1]] && player[i[1]]==player[i[2]] && player[i[0]] !=2)
                 {
                     gamesetutin=false;
                     String winner="o";

                     if(player[i[0]]==0)
                     {
                         winner="x";

                     }
                     TextView winnermassage=(TextView) findViewById(R.id.textview);
                     winnermassage.setText(winner +"  has won!!");

                     LinearLayout layout=(LinearLayout)findViewById(R.id.palyagainlayout);
                     layout.animate().rotation(720).setDuration(300);
                     layout.setVisibility(View.VISIBLE);

                 }
                 else {
                     boolean gameover=true;
                     for (int l:player) {
                         if (l == 2) {
                             gameover = false;
                         }
                     }
                         if (gameover)
                         {
                             TextView winnermassage=(TextView) findViewById(R.id.textview);
                             winnermassage.setText(" It a draw ");

                             LinearLayout layout=(LinearLayout)findViewById(R.id.palyagainlayout);
                             layout.animate().rotation(720).setDuration(300);
                             layout.setVisibility(View.VISIBLE);
                         }

                 }
             }
         }
     }

     public void paly  (View view) {
         gamesetutin=true;
         LinearLayout layout=(LinearLayout)findViewById(R.id.palyagainlayout);
         layout.animate().rotation(720).setDuration(300);
         layout.setVisibility(View.INVISIBLE);
          activePlayer=0;
//          player={2,2,2,2,2,2,2,2,2};
          for (int j=0;j<player.length;j++)
          {
              player[j]=2;
          }
         GridLayout gl=(GridLayout)findViewById(R.id.grid);

          for (int k=0;k<gl.getChildCount();k++)
          {
              ((ImageView)gl.getChildAt(k)).setImageResource(0);
          }


     }
 }
