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

    private static double firstNumber;
    private static double secondNumber;
    private static int operacion;
    private static double totalInt;
    private static String totalString;
    private static boolean hasNegative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button numero;
        for(int i=0;i<myIDArray.length;i++) {
            numero = (Button) findViewById(myIDArray[i]);
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

        if(str2.equals("-")){
            hasNegative = true;
        }else{
            hasNegative = false;
        }

        switch (view.getId()) {

            case R.id.button0: {
                str = output.getText().toString();
                //because you cant add a 0 to a 0
                //same case with -0
                if (!str.equals("0") && !str.equals("-0")) {
                    output.append("0");
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
                Button MyButton = (Button) view; //El boton en tipo boton
                String myDigit = MyButton.getText().toString(); //MyButton en texto
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
                break;

            case R.id.buttonPoint:
                output.append(".");
                break;

            case R.id.buttonNegPos:
             //   str = output.getText().toString();
           //     str2 = str.substring(0, 1);
                if(hasNegative == true){
                    output.setText(str.substring(1));
                }else{
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
                    output.setText(totalString);

                }else if(operacion == 2){

                    totalInt = firstNumber * secondNumber;
                    totalString = String.valueOf(totalInt);
                    output.setText(totalString);

                }else if(operacion == 3){

                    totalInt = firstNumber - secondNumber;
                    totalString = String.valueOf(totalInt);
                    output.setText(totalString);

                }else if(operacion == 4){

                    totalInt = firstNumber + secondNumber;
                    totalString = String.valueOf(totalInt);
                    output.setText(totalString);

                }else{
                    mToast = Toast.makeText(this, "Unknown error. Please restart application.", Toast.LENGTH_SHORT);
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