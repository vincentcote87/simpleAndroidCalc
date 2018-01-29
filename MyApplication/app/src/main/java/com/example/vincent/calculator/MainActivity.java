package com.example.vincent.calculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button add, sub, mult, divide, equal;
    private Button clear, dec, plusMinus;
    private TextView input, answer;
    private double x = 0;
    private double y = Double.NaN;
    private String operand = null;
    private String inputVal;
    private Switch themeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        themeSwitch = (Switch)findViewById(R.id.themeSwitch);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            themeSwitch.setChecked(true);
        }
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonVie, boolean isChecked) {
                if(isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("0");
                answer.setText(inputVal);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("1");
                answer.setText(inputVal);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("2");
                answer.setText(inputVal);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("3");
                answer.setText(inputVal);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("4");
                answer.setText(inputVal);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("5");
                answer.setText(inputVal);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("6");
                answer.setText(inputVal);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("7");
                answer.setText(inputVal);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("8");
                answer.setText(inputVal);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue("9");
                answer.setText(inputVal);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setValue(".");
                answer.setText(inputVal);
            }
        });

        plusMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputVal != null) {
                    double tmp = Double.parseDouble(inputVal);
                    tmp = tmp - 2*tmp;
                    inputVal = Double.toString(tmp);
                    answer.setText(inputVal);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputVal != null) {
                    opClicked("+");
                    input.setText(operand);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputVal != null) {
                    opClicked("-");
                    input.setText(operand);
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputVal != null) {
                    opClicked("*");
                    input.setText(operand);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputVal != null) {
                    opClicked("/");
                    input.setText(operand);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(operand != null && inputVal != null) {
                    y = Double.parseDouble(inputVal);
                    if(operand == "/" && y == 0.0) {
                        answer.setText("Cannot divide by 0");
                    }
                    else
                        answer.setText(getAnsw());
                    x = 0;
                    y = 0;
                    inputVal = null;
                    operand = null;
                    input.setText("");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setText("");
                answer.setText("0");
                x = 0;
                y = 0;
                inputVal = null;
                operand = null;
            }
        });

    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
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

        input = (TextView)findViewById(R.id.operandText);
//        opView = (TextView)findViewById(R.id.operation);
        answer = (TextView)findViewById(R.id.answer);
    }

    private void setValue(String ch) {
        if(inputVal == null) {
            inputVal = ch;
        }
        else if(inputVal.length() <= 12) {
            inputVal += ch;
        }
    }

    private void opClicked(String op) {
        if(x == 0) {
            x = Double.parseDouble(inputVal);
            inputVal = null;
        }
        operand = op;
    }

    private String getAnsw() {
        double ans;
        int checkInt;
        switch (operand) {
            case "+" : ans = x + y; break;
            case "-" : ans = x - y; break;
            case "*" : ans = x * y; break;
            case "/" : ans = x / y; break;
            default: ans = 0.0;
        }
        operand = null;
        checkInt = (int)ans;
        if((double)checkInt - ans != 0) {
            return Double.toString(ans);
        }
        else
            return Integer.toString((int)ans);
    }
}
