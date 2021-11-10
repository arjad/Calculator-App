package com.dataflair.scientificcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView input_var, operator_var;
    Double num1, num2, answer;
    String sign, val_1, val_2;
    boolean Dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_var = (TextView) findViewById(R.id.inputs_id);
        operator_var = (TextView) findViewById(R.id.operator_id);

        Dot = false;

    }
    //numbers
    public void btn_0(View view) {
        input_var.setText(input_var.getText() + "0");
    }
    public void btn_1(View view) {
        input_var.setText(input_var.getText() + "1");
    }
    public void btn_2(View view) {
        input_var.setText(input_var.getText() + "2");
    }
    public void btn_3(View view) {
        input_var.setText(input_var.getText() + "3");
    }
    public void btn_4(View view) {
        input_var.setText(input_var.getText() + "4");
    }
    public void btn_5(View view) {
        input_var.setText(input_var.getText() + "5");
    }
    public void btn_6(View view) {
        input_var.setText(input_var.getText() + "6");
    }
    public void btn_7(View view) {
        input_var.setText(input_var.getText() + "7");
    }
    public void btn_8(View view) {
        input_var.setText(input_var.getText() + "8");
    }
    public void btn_9(View view) {
        input_var.setText(input_var.getText() + "9");
    }

    // dot
    public void btn_dot(View view) {
        if (!Dot) //it has dot
        {
            //empty input value
            if (input_var.getText().equals(""))
            {
                input_var.setText("0.");
            }
            //non empty input will get dot in between
            else
            {
                input_var.setText(input_var.getText() + ".");
            }
            Dot = true;
        }

    }

    //basic operators
    public void btn_add(View view) {
        sign = "+";
        val_1 = input_var.getText().toString();
        input_var.setText(null);
        operator_var.setText("+");
        Dot = false;
    }
    public void btn_subtract(View view) {
        sign = "-";
        val_1 = input_var.getText().toString();
        input_var.setText(null);
        operator_var.setText("-");
        Dot = false;
    }
    public void btn_multiply(View view) {
        sign = "*";
        val_1 = input_var.getText().toString();
        input_var.setText(null);
        operator_var.setText("X");
        Dot = false;
    }
    public void btn_divide(View view) {
        sign = "/";
        val_1 = input_var.getText().toString();
        input_var.setText(null);
        operator_var.setText("/");
        Dot = false;
    }

    //More operators
    public void btn_log(View view) {
        sign = "log";
        input_var.setText(null);
        operator_var.setText("log");
        Dot = false;
    }
    public void btn_ln(View view) {
        sign = "ln";
        input_var.setText(null);
        operator_var.setText("ln");
        Dot = false;
    }
    public void btn_power(View view) {
        sign = "power";
        val_1 = input_var.getText().toString();
        input_var.setText(null);
        Dot = false;
        operator_var.setText("xⁿ");
    }
    public void btn_factorial(View view) {
        sign = "factoral";
        input_var.setText(null);
        Dot = false;
        operator_var.setText("!");
    }
    public void btn_sin(View view) {
        sign = "sin";
        input_var.setText(null);
        Dot = false;
        operator_var.setText("sin (");
    }

    //trignometric functions
    public void btn_cos(View view) {
        sign = "cos";
        input_var.setText(null);
        Dot = false;
        operator_var.setText("cos (");
    }
    public void btn_tan(View view) {
        sign = "tan";
        input_var.setText(null);
        Dot = false;
        operator_var.setText("tan (");
    }

    public void btn_root(View view) {
        sign = "root";
        input_var.setText(null);
        Dot = false;
        operator_var.setText("√");
    }
    //clear
    public void btn_clear(View view)
    {
        input_var.setText(null);
        operator_var.setText(null);
        val_1 = null;
        val_2 = null;
        sign = null;
        Dot = false;

        Toast.makeText(getApplicationContext(), "Reset " , Toast.LENGTH_SHORT).show();

    }
    //delete last num
    public void btn_delete(View view) {
        if (input_var.getText().equals(""))
        {
            input_var.setText(null);
            Toast.makeText(getApplicationContext(), "Already empty " , Toast.LENGTH_SHORT).show();
        }
        else
        {
            int len = input_var.getText().length();
            String s = input_var.getText().toString();
            if (s.charAt(len - 1) == '.')
            {
                Dot = false;
                input_var.setText(input_var.getText().subSequence(0, input_var.getText().length() - 1));

            }
            else
            {
                input_var.setText(input_var.getText().subSequence(0, input_var.getText().length() - 1));
            }
        }
    }
    ///////// results /////////
    public void btn_equal(View view)
    {
        if (input_var.getText().equals(""))
        {
            operator_var.setText("ERROR ! No input");
            Toast.makeText(getApplicationContext(), "Please Enter Input " , Toast.LENGTH_LONG).show();
        }
        else if (sign == null)  //no sign selected
        {
            operator_var.setText(" Error ! No Operator ");
            Toast.makeText(getApplicationContext(), "Please Select Operator " , Toast.LENGTH_LONG).show();
        }

        // no error case here
        else {
            switch (sign)
            {
                default:
                    break;
                    //basic operator
                case "+":
                    val_2 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 + num2;
                    sign = null;
                    operator_var.setText(num1 + " + " + num2 + " = " + answer );
                    break;
                case "-":
                    val_2 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 - num2;
                    sign = null;
                    operator_var.setText(num1 + " - " + num2 + " = "  + answer);
                    break;
                case "*":
                    val_2 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 * num2;
                    sign = null;
                    operator_var.setText(num1 + " X " + num2 + " = " + answer);
                    break;
                case "/":
                    val_2 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 / num2;
                    sign = null;
                    operator_var.setText(num1 + " / " + num2 + " = " + answer);
                    break;

                    //extra operator
                case "log":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    input_var.setText(Math.log(num1) + "");
                    sign = null;
                    operator_var.setText(null);
                    break;
                case "ln":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    input_var.setText(Math.log(num1) + "");
                    sign = null;
                    operator_var.setText(null);
                    break;
                case "power":
                    num1 = Double.parseDouble((val_1));
                    val_2 = input_var.getText().toString();
                    num2 = Double.parseDouble(val_2);
                    sign = null;
                    operator_var.setText(num1 +" ^ " + num2 + " = " + Math.pow(num1, num2));
                    break;
                case "root":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble((val_1));
                    sign = null;
                    operator_var.setText("SQ root( " + num1 + " ) = " + Math.sqrt(num1));
                    break;
                case "factoral":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble((val_1));
                    int i = Integer.parseInt(val_1) - 1;
                    while (i > 0) {
                        num1 = num1 * i;
                        i--;
                    }
                    sign = null;
                    operator_var.setText("Factorial is = " + num1);
                    break;

                    //trignometric function
                case "sin":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble((val_1));
                    sign = null;
                    operator_var.setText("sin = "+ Math.sin(num1)+"");
                    break;
                case "cos":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble((val_1));
                    sign = null;
                    operator_var.setText("cos = " + Math.cos(num1) + "");
                    break;
                case "tan":
                    val_1 = input_var.getText().toString();
                    num1 = Double.parseDouble((val_1));
                    sign = null;
                    operator_var.setText("tan = " + Math.tan(num1) + "");
                    break;
            }
        }
    }
}
