package com.example.android.braintrainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.android.braintrainer.R.*;

public class MainActivity extends AppCompatActivity {
TextView textView;
TextView textView2;
TextView textView3;
TextView resultTextView;
Button button0;
Button button1;
Button button2;
Button button3;
Button button;


TextView finalResult;
int score=0;
    int locationOfCorrectAnswer;
Button goButton;
    int h=0;
    int a;
    int b;
public void generate(int s,int count)
{

    textView3.setText( s+" / "+count);
}
public void finalresult()
{
    resultTextView.setVisibility(View.INVISIBLE);
    finalResult.setVisibility(View.VISIBLE);
    finalResult.setText("Result = "+score+" out of"+h);
}

      public void onClick (View view){
          ArrayList<Integer>answer=new ArrayList<Integer>();
          resultTextView.setVisibility(View.INVISIBLE);
          Random r1=new Random();
          a=r1.nextInt(20)+1;
          b=r1.nextInt(40-21)+21;
          textView.setText(a+" + "+b);
          h++;
         generate(score,h);

          int correctanswer=a+b;
           locationOfCorrectAnswer=r1.nextInt(4);
          for(int i=0;i<4;i++)
          {
              if(i==locationOfCorrectAnswer)
              {
                  answer.add(a+b);
              }else
              {
                  int k=r1.nextInt(60);
                  while(k==correctanswer)
                      k=r1.nextInt(60);

                  answer.add(k);
              }
          }
          button0.setText(Integer.toString(answer.get(0)));
          button1.setText(Integer.toString(answer.get(1)));
          button2.setText(Integer.toString(answer.get(2)));
          button3.setText(Integer.toString(answer.get(3)));
          button0.setEnabled(true);
          button1.setEnabled(true);
          button2.setEnabled(true);
          button3.setEnabled(true);
      }

    public void buttonPressed(View view){
          if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
          {

              score++;
              generate(score,h);
              resultTextView.setVisibility(View.VISIBLE);
              resultTextView.setText("CORRECT!");


          }
        else
          {
              resultTextView.setVisibility(View.VISIBLE);
              resultTextView.setText("WRONG!");

          }
          button0.setEnabled(false);
          button1.setEnabled(false);
          button2.setEnabled(false);
          button3.setEnabled(false);
    }



public void goOnClick(View view) {

finalResult.setVisibility(View.INVISIBLE);
resultTextView.setVisibility(View.VISIBLE);

resultTextView.setText(" ");

    button.setVisibility(View.VISIBLE);

    goButton.setVisibility(View.INVISIBLE);
    ArrayList<Integer>answer=new ArrayList<Integer>();
    resultTextView.setVisibility(View.INVISIBLE);
    Random r1=new Random();
    a=r1.nextInt(20)+1;
    b=r1.nextInt(40-21)+21;
    textView.setText(a+" + "+b);
    h++;
    generate(score,h);

    int correctanswer=a+b;
    locationOfCorrectAnswer=r1.nextInt(4);
    for(int i=0;i<4;i++)
    {
        if(i==locationOfCorrectAnswer)
        {
            answer.add(a+b);
        }else
        {
            int k=r1.nextInt(60);
            while(k==correctanswer)
                k=r1.nextInt(60);

            answer.add(k);
        }
    }
    button0.setText(Integer.toString(answer.get(0)));
    button1.setText(Integer.toString(answer.get(1)));
    button2.setText(Integer.toString(answer.get(2)));
    button3.setText(Integer.toString(answer.get(3)));
    button0.setEnabled(true);
    button1.setEnabled(true);
    button2.setEnabled(true);
    button3.setEnabled(true);

    CountDownTimer countDownTimer = new CountDownTimer(30 * 1000 + 100, 1000) {

        @Override
        public void onTick(long l) {
            textView2.setText(Long.toString(l / 1000));
        }

        @Override
        public void onFinish() {
            button.setVisibility(View.INVISIBLE);
            goButton.setVisibility(View.VISIBLE);

            finalresult();
            textView2.setText("0");
            score=0;
            h=0;
            generate(0,0);
            MediaPlayer mPlayer=MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
            mPlayer.start();
        }
    }.start();

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        textView=(TextView)findViewById(id.textView);
        textView2=(TextView)findViewById(id.textView2);
textView3=(TextView)findViewById(id.textView3);
goButton=(Button)findViewById(id.gobutton);
button0=(Button)findViewById(id.button0);
        button1=(Button)findViewById(id.button1);
        button2=(Button)findViewById(id.button2);
        button3=(Button)findViewById(id.button3);
        button=(Button)findViewById(id.button);
        resultTextView=(TextView)findViewById(id.resultTextView);
        finalResult=(TextView)findViewById(id.finalResult);

    }
}
