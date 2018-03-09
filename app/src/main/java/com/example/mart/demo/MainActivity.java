package com.example.mart.demo;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double d = Math.random();
    int guessNumber = (int) (d * 101);
    int life = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button re = findViewById(R.id.again);
        re.setVisibility(View.INVISIBLE);
    }

    public void buttonClick(View view) {
        EditText input = findViewById(R.id.inputNumber);
        TextView showLifeCurrent = findViewById(R.id.showLife);
        TextView hint = findViewById(R.id.hints);
        Integer number;
        try {
            number = Integer.parseInt(input.getText().toString());
            if (--life > 0) {
                if (number > guessNumber && number <= 100) {
                    hint.setText("Wrong! Less than " + number);
                    //life--;
                    showLifeCurrent.setText("Life : " + life + "/5");
                } else if (number < guessNumber && number >= 0) {
                    hint.setText("Wrong! More than " + number);
                    //life--;
                    showLifeCurrent.setText("Life : " + life + "/5");
                } else if (number == guessNumber) {
                    hint.setText("Correct!!");
                } else {
                    hint.setText("Input only number 0-100");
                    //life--;
                    showLifeCurrent.setText("Life : " + life + "/5");
                    if (life < 1) {
                        life = 0;
                    }
                    Button re = findViewById(R.id.again);
                    re.setVisibility(View.INVISIBLE);
                }
            } else if (life == 0) {
                hint.setText("Game Over! Answer = " + guessNumber);
                showLifeCurrent.setText("Life : " + life + "/5");
                Button re = findViewById(R.id.again);
                re.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            hint.setText("Input only number 0-100");
            showLifeCurrent.setText("Life : " + life + "/5");
            Button re = findViewById(R.id.again);
            re.setVisibility(View.INVISIBLE);
        }
    }

    public void restart(View view) {
        d = Math.random();
        guessNumber = (int) (d * 101);
        life = 5;
        TextView hint = findViewById(R.id.hints);
        hint.setText("");
        EditText input = findViewById(R.id.inputNumber);
        input.setText("");
        TextView showLifeCurrent = findViewById(R.id.showLife);
        showLifeCurrent.setText("Life : " + life + "/5");
        Button re = findViewById(R.id.again);
        re.setVisibility(View.INVISIBLE);
    }
}
