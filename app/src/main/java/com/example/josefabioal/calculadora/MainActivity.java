package com.example.josefabioal.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends Activity implements View.OnClickListener {
    private Toast mToast;

    private static int[] myIDArray = {
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
    };

    private static double firstNumber = 0;
    private static double secondNumber;
    private static int operacion;
    private static double totalInt;
    private static String totalString;
    private static boolean hasNegative;
    private static boolean needRestart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button numero;
        for(int aMyIDArray : myIDArray) {
            numero = (Button) findViewById(aMyIDArray);
            numero.setOnClickListener(this);
        }
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
        Button x = (Button) findViewById(R.id.buttonMultiplication);
        x.setOnClickListener(this);
        Button negPos = (Button) findViewById(R.id.buttonNegPos);
        negPos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // default method for handling onClick Events..
        TextView output = (TextView) findViewById(R.id.textView);
        String str;
        String str2;

        str = output.getText().toString();
        str2 = str.substring(0, 1);


        hasNegative = str2.equals("-");

        switch (view.getId()) {

            case R.id.button0: {

                if(needRestart){
                    output.setText("0");
                    needRestart = false;
                }

                str = output.getText().toString();
                //because you cant add a 0 to a 0
                //same case with -0
                if (!str.equals("0") && !str.equals("-0")) {
                    output.append("0");
                } else if(str.length() >= 3) {

                    if (str.substring(str.length()-2, str.length()).equals(".0")) {
                        //str = str.substring(0, str.length()-1);
                        output.setText(str+"0");
                    }
                }
                break;
            }


            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9: {
                if(needRestart){
                    output.setText("0");
                    needRestart = false;
                }

                Button MyButton = (Button) view;
                String myDigit = MyButton.getText().toString(); //Text of the button you click in String. Example = 1
                str = output.getText().toString();

                if(str.length() >= 3) {

                    if (str.substring(str.length()-2, str.length()).equals(".0")) {
                        str = str.substring(0, str.length()-1);
                        output.setText(str);
                    }
                }

                if ("0".equals(str) && str.length() == 1) {
                    output.setText(myDigit);
                }else if("-0".equals(str) && str.length() == 2){
                    output.setText("-" + myDigit);
                } else {
                    output.append(myDigit);
                }

                break;
            }
            case R.id.buttonDel:
                if(needRestart){
                    output.setText("0");
                    needRestart = false;
                }
                str = output.getText().toString();
                int length = str.length();
                if(str.length() >= 3 && str.substring(str.length()-2, str.length()-1).equals(".")){
                    if(! str.substring(str.length()-1, str.length()).equals("0")){
                        output.setText(str.substring(0, str.length()-1) + "0");
                    }else if(str.substring(str.length()-1, str.length()).equals("0")){
                        output.setText(str.substring(0, str.length()-2));
                    }
                }else if (length > 1) {
                    if(length == 2 && hasNegative && str.substring(1).equals("0")){
                        output.setText("-0");
                    }else if(length == 2 && hasNegative && ! str.substring(1).equals("0")){
                        output.setText("-0");
                    }else{
                        str = str.substring(0, str.length() - 1);
                        output.setText(str);
                    }
                } else {

                    output.setText("0");
                }
                break;

            case R.id.buttonC:
                output.setText("0");
                firstNumber = 0;
                secondNumber = 0;
                break;



            case R.id.buttonPoint:
                if(needRestart){
                    output.setText("0.0");
                    needRestart = false;
                }
                str = output.getText().toString();

                if(str.length() >= 3) { //Do not try to simplify this to one if, it will not work

                    if (str.substring(str.length()-2, str.length()).equals(".0")) {
                        str = str.substring(0, str.length()-1);
                        output.setText(str);
                    }
                }

                output.append(".0");
                break;

            case R.id.buttonNegPos:
                if(hasNegative){
                    if(needRestart){
                        output.append("0");
                        output.setText("0");
                        needRestart = false;
                    }
                    output.setText(str.substring(1));
                }else{
                    if(needRestart){
                        output.append("0");
                        output.setText("0");
                        needRestart = false;
                    }
                    output.setText("-" + str);
                }
                break;

            /*
            Divide = 1
            Multiplication = 2
            Rest = 3
            Addition = 4
             */
            case R.id.buttonDivide:
                str = output.getText().toString();
                firstNumber = Double.parseDouble(str);
                operacion = 1;
                output.setText("0");
                break;

            case R.id.buttonMultiplication:
                str = output.getText().toString();
                firstNumber = Double.parseDouble(str);
                operacion = 2;
                output.setText("0");
                break;

            case R.id.buttonMinus:
                str = output.getText().toString();
                firstNumber = Double.parseDouble(str);
                operacion = 3;
                output.setText("0");
                break;

            case R.id.buttonPlus:
                str = output.getText().toString();
                firstNumber = Double.parseDouble(str);
                operacion = 4;
                output.setText("0");
                break;

            case R.id.buttonEquals:
                str2 = output.getText().toString();
                secondNumber = Double.parseDouble(str2);

                if(operacion == 1){

                    totalInt = firstNumber / secondNumber;
                    totalString = String.valueOf(totalInt);

                    if(totalString.substring(totalString.length() - 2, totalString.length()).equals(".0")){
                        totalString = totalString.substring(0, totalString.length() - 2);
                    }
                    output.setText(totalString);
                    needRestart = true;

                }else if(operacion == 2){

                    totalInt = firstNumber * secondNumber;
                    totalString = String.valueOf(totalInt);

                    if(totalString.substring(totalString.length() - 2, totalString.length()).equals(".0")){
                        totalString = totalString.substring(0, totalString.length() - 2);
                    }
                    output.setText(totalString);
                    needRestart = true;

                }else if(operacion == 3){

                    totalInt = firstNumber - secondNumber;
                    totalString = String.valueOf(totalInt);

                    if(totalString.substring(totalString.length() - 2, totalString.length()).equals(".0")){
                        totalString = totalString.substring(0, totalString.length() - 2);
                    }
                    output.setText(totalString);
                    needRestart = true;

                }else if(operacion == 4){

                    totalInt = firstNumber + secondNumber;
                    totalString = String.valueOf(totalInt);

                    if(totalString.substring(totalString.length() - 2, totalString.length()).equals(".0")){
                        totalString = totalString.substring(0, totalString.length() - 2);
                    }
                    output.setText(totalString);
                    needRestart = true;

                }else{
                    mToast = Toast.makeText(this, "Unknown error", Toast.LENGTH_SHORT);
                    mToast.show();
                }
                break;

            default:
                if(null != mToast){
                    mToast.cancel();
                }
                mToast = Toast.makeText(this, "Unknown Action", Toast.LENGTH_SHORT);
                mToast.show();
                break;
        }
    }
}