package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myapplication.R.id.clear;

public class MainActivity extends AppCompatActivity {

    TextView resultTV;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button clear;
    Button divide;
    Button multiply;
    Button minus;
    Button plus;
    Button equal;

    String rawOperand = "";
    Double firstOperand;
    Double secondOperand;
    String operation;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null){
            firstOperand=savedInstanceState.getDouble("firstOperand");
        }

        if (savedInstanceState!=null){
            secondOperand=savedInstanceState.getDouble("secondOperand");
        }

        if (savedInstanceState!=null){
            result=savedInstanceState.getDouble("result");
        }

        if (savedInstanceState!=null){
            operation=savedInstanceState.getString("operation");
        }

        resultTV = findViewById(R.id.result);
        multiply= findViewById(R.id.multiply);
        clear= findViewById(R.id.clear);
        divide= findViewById(R.id.divide);
        clear= findViewById(R.id.clear);
        minus= findViewById(R.id.minus);
        plus= findViewById(R.id.plus);
        clear= findViewById(R.id.clear);
        equal= findViewById(R.id.equal);
        one= findViewById(R.id.one);
        two= findViewById(R.id.two);
        three= findViewById(R.id.three);
        four= findViewById(R.id.four);
        five= findViewById(R.id.five);
        six= findViewById(R.id.six);
        seven= findViewById(R.id.seven);
        eight= findViewById(R.id.eight);
        nine= findViewById(R.id.nine);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putDouble("firstOperand", firstOperand);
        outState.putDouble("secondOperand", secondOperand);
        outState.putDouble("result", result);
        outState.putString("operation", operation);
        outState.putString("clear", String.valueOf(clear));
    }

    public void onNumberClinic(View v) {

        switch (v.getId()) {
            case R.id.one:
              enterNumber("1");
                break;

            case R.id.two:
                enterNumber("2");
                break;

            case R.id.three:
                enterNumber("3");
                break;
            case R.id.four:
                enterNumber("4");
                break;
            case R.id.five:
                enterNumber("5");
                break;
            case R.id.six:
                enterNumber("6");
                break;
            case R.id.seven:
                enterNumber("7");
                break;
            case R.id.eight:
                enterNumber("8");
                break;
            case R.id.nine:
                enterNumber("9");
                break;
        }


    }
    public void enterNumber(String number) {
        resultTV.append(number);
        rawOperand += number;
    }

    public void onOperationClinic(View v) {

        try {
            if (firstOperand == null) {
                firstOperand = Double.parseDouble(rawOperand);
            } else {
                secondOperand = Double.parseDouble(rawOperand);
            }
            rawOperand = "";

        }catch (Exception error){
            error.printStackTrace();
        }


        switch (v.getId()) {
            case R.id.plus:
              enterOperation("+");
                break;
            case R.id.multiply:
                enterOperation("*");
                break;
            case R.id.equal:
                if (operation != null) {
                    switch (operation) {
                        case "+":
                            result = firstOperand + secondOperand;
                            resultTV.append(" = " + result);
                            break;

                        case "*":
                            result = firstOperand * secondOperand;
                            resultTV.append(" = " + result);
                            break;
                        case "/":
                            result = firstOperand / secondOperand;
                            resultTV.append(" / " + result);
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            resultTV.append(" - " + result);
                            break;

                    }
                }
                }


        }



    public void enterOperation(String operation) {
        resultTV.append(operation);
        this.operation = operation;
    }

}
