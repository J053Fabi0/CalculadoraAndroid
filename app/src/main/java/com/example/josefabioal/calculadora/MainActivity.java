package com.example.josefabioal.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState)/*  */ {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button cero = (Button) findViewById(R.id.button0);
        cero.setOnClickListener(this);
        Button one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this); // calling onClick() method
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(this); // calling onClick() method
        Button point = (Button) findViewById(R.id.buttonPoint);
        point.setOnClickListener(this);
        Button equals = (Button) findViewById(R.id.buttonEquals);
        equals.setOnClickListener(this);
        Button plus = (Button) findViewById(R.id.buttonPlus);
        plus.setOnClickListener(this);
        Button del = (Button) findViewById(R.id.buttonDel);
        del.setOnClickListener(this); // calling onClick() method
        Button divide = (Button) findViewById(R.id.buttonDivide);
        divide.setOnClickListener(this);
        Button c = (Button) findViewById(R.id.buttonC);
        c.setOnClickListener(this);
        Button minus = (Button) findViewById(R.id.buttonMinus);
        minus.setOnClickListener(this);
        Button x = (Button) findViewById(R.id.buttonX);
        x.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // default method for handling onClick Events..
        TextView output = (TextView) findViewById(R.id.textView);
        String str;
        switch (v.getId()) {

            case R.id.button0:
                str = output.getText().toString();
                //because you cant add a 0 to a 0
                //same case with -0
                if (!str.equals("0") && !str.equals("-0")) {
                    output.append("0");
                }
                break;

            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9: {
                Button MyButton = (Button) v;
                String myDigit = MyButton.getText().toString();
                str = output.getText().toString();
                if ("0".equals(str) && str.length() == 1) {
                    output.setText(myDigit);
                } else {
                    output.append(myDigit);
                }
                break;
            }
            case R.id.buttonDel:
                str = output.getText().toString();
                int length = str.length();
                if (length > 1) {
                    str = str.substring(0, str.length() - 1);
                    output.setText(str);
                } else {
                    output.setText("0");
                }
                break;
            case R.id.buttonC:
                output.setText("0");
                break;
            default:
                if(null != mToast){
                    mToast.cancel();
                }
                mToast = Toast.makeText(this, "Unknow Action", Toast.LENGTH_SHORT);
                mToast.show();
                break;
        }
    }
}