package com.example.huzaifi.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity {
    String RunningNumber="";
    Operation currentOperation;
    TextView resultView;

    String leftValue="";
    String rightValue="";

    int result=0;

    public enum Operation{
        ADD,SUBTRACT ,MULTIPLY,DIVIDE,EQUAL
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button btn1 =(Button)findViewById(R.id.btn1);
        Button btn2 =(Button)findViewById(R.id.btn2);
        Button btn3 =(Button)findViewById(R.id.btn3);
        Button btn4 =(Button)findViewById(R.id.btn4);
        Button btn5 =(Button)findViewById(R.id.btn5);
        Button btn6 =(Button)findViewById(R.id.btn6);
        Button btn7 =(Button)findViewById(R.id.btn7);
        Button btn8 =(Button)findViewById(R.id.btn8);
        Button btn9 =(Button)findViewById(R.id.btn9);
        Button btn0 =(Button)findViewById(R.id.btn0);
        Button plus_btn =(Button)findViewById(R.id.plus_btn);
        Button minus_btn =(Button)findViewById(R.id.minus_btn);
        Button multiply_btn =(Button)findViewById(R.id.multiply_btn);
        Button divide_btn =(Button)findViewById(R.id.divide_btn);
        Button equal_btn =(Button)findViewById(R.id.equal_btn);
        Button clear_btn=(Button)findViewById(R.id.clear_btn) ;

         resultView=(TextView)findViewById(R.id.resultView);
        resultView.setText("");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });
        divide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });
        multiply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });
        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });
        equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValue="";
                rightValue="";
                RunningNumber="";
                result=0;
                currentOperation=null;
                resultView.setText("0");
            }
        });

    }

    void processOperation(Operation operation){
        if (currentOperation!=null)
        {
            if ( RunningNumber!=""){
                rightValue=RunningNumber;
                RunningNumber="";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                }
               leftValue=String.valueOf(result);
                resultView.setText(leftValue);
            }
        }
        else {
            leftValue=RunningNumber;
            RunningNumber="";
        }
        currentOperation=operation;
    }

    void numberPressed(int number){
        RunningNumber +=String.valueOf(number);
        resultView.setText(RunningNumber);
    }
}
