package com.example.vincent.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button add, sub, mult, divide, equal;
    private Button clear, dec, plusMinus;
    private TextView input, opView,  answer;
    private double x = 0;
    private double y = 0;
    private char operation = '\u0000' ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '0');
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '1');
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '2');
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '3');
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '4');
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '5');
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '6');
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '7');
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '8');
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '9');
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText(input.getText().toString() + '.');
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(operation == '\u0000' || operation == '-' || operation == '*' || operation == '/') {
                    x = Double.parseDouble(input.getText().toString());
                    opView.setText(input.getText().toString() + ' ' + '+');
                    input.setText("");
                    answer.setText("");
                    operation = '+';
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                y = Double.parseDouble(input.getText().toString());
                opView.setText(x + " " + operation + " " + y);
                input.setText("");
                answer.setText(String.valueOf(x + y));
                operation = '\u0000';
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText("");
                opView.setText("");
                answer.setText("0");
                x = 0;
                y = 0;
                operation = '\u0000';
            }
        });

    }

    private void setupUIViews() {
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnAdd);
        sub = (Button)findViewById(R.id.btnSub);
        mult = (Button)findViewById(R.id.btnMult);
        divide = (Button)findViewById(R.id.btnDiv);
        equal = (Button)findViewById(R.id.btnEqual);
        clear = (Button)findViewById(R.id.btnClr);
        dec = (Button)findViewById(R.id.btnDecimal);
        plusMinus = (Button)findViewById(R.id.btnSign);

        input = (TextView)findViewById(R.id.inputText);
        opView = (TextView)findViewById(R.id.operation);
        answer = (TextView)findViewById(R.id.answer);
    }
}
