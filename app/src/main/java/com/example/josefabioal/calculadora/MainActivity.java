package com.example.josefabioal.calculadora;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

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

        switch (v.getId()){

            case R.id.button0:
                TextView output = (TextView) findViewById(R.id.textView);
                String str = output.getText().toString();
                System.out.println(str);
                if(str.equals("0")) {
                    //do nothing, because you cant add a 0 to a 0
                }else{
                    output.append("0");
                }
                break;

            case R.id.button1:
                output = (TextView) findViewById(R.id.textView);
                output.append("1");
                break;

            case R.id.button2:
                output = (TextView) findViewById(R.id.textView);
                output.append("2");
                break;

            case R.id.button3:
                output = (TextView) findViewById(R.id.textView);
                output.append("3");
                break;

            case R.id.button4:
                output = (TextView) findViewById(R.id.textView);
                output.append("4");
                break;

            case R.id.button5:
                output = (TextView) findViewById(R.id.textView);
                output.append("5");
                break;

            case R.id.button6:
                output = (TextView) findViewById(R.id.textView);
                output.append("6");
                break;

            case R.id.button7:
                output = (TextView) findViewById(R.id.textView);
                output.append("7");
                break;

            case R.id.button8:
                output = (TextView) findViewById(R.id.textView);
                output.append("8");
                break;

            case R.id.button9:
                output = (TextView) findViewById(R.id.textView);
                output.append("9");
                break;

            case R.id.buttonDel:

                output = (TextView) findViewById(R.id.textView);

                str = output.getText().toString();
                int length = str.length();
                if (length >= 2 ) {
                    str = str.substring(0, str.length() - 1);
                    output.setText(str);
                } else if (length <= 2 ) {
                    output.setText("0");
                }
                break;

            case R.id.buttonC:
                output = (TextView) findViewById(R.id.textView);
                output.setText("0");

            default:
/*                output = (TextView) findViewById(R.id.textView);

                str = output.getText().toString();

                if(str == "0"){
                }else if(str == "" || str == null){
                    output.setText("0");
                }*/
                break;

        }
    }
}
