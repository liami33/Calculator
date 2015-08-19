package com.example.lian.calculator;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    //private boolean operatorOnDisplay = false;
    //private boolean imageOnDisplay = false;

    public void whenButtonClicked(View V) {
        // V is a reference for the object that was clicked
        EditText disp;
        disp = (EditText) findViewById(R.id.resultDisplay);
        Button b = (Button) V;
        CharSequence buttonText = b.getText();
        if (buttonText.toString().equals(("3")))
            Log.i("Button clicked:", "3");
        String oldText = disp.getText().toString();
        String newText = oldText + buttonText.toString();
        disp.setText(newText);
        //Log.i("Button clicked: ", buttonText.toString());

    }

    public void whenOperatorClicked(View V) {
        //   if (operatorOnDisplay) return;
        whenButtonClicked(V);
        //  operatorOnDisplay = true;

    }

    public void whenClearClicked(View V) {
        EditText disp;
        disp = (EditText) findViewById(R.id.resultDisplay);
        disp.setText("");
        //   operatorOnDisplay = false;
    }

//    public void whenEqualsClicked(View V) {
//        EditText disp = (EditText) findViewById(R.id.resultDisplay);
//        String displayText = disp.getText().toString();
//        long result = 0;
//        if (displayText.contains("+")) {
//            String[] parts = displayText.split("\\+");
//            result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
//            if (result == 20)
//                Log.i("Sum:", "20");
//        }
//        if (displayText.contains("-")) {
//            String[] parts = displayText.split("-");
//            result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
//            if (result == 17)
//                Log.i("Subtract:", "17");
//        }
//
//        if (displayText.contains("*")) {
//            String[] parts = displayText.split("\\*");
//            result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
//        }
//
//        if (displayText.contains("/")) {
//            String[] parts = displayText.split("/");
//            result = Integer.parseInt(parts[0]) / Integer.parseInt(parts[1]);
//
//        }
//        disp.setText(Long.toString(result));
//        //  operatorOnDisplay = false;
//    }

    public void whenImageClicked(View V) {
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
        if (btn.getDrawable().getConstantState().equals(ContextCompat.getDrawable(this, R.drawable.dog).getConstantState()))
            btn.setImageResource(R.drawable.cat);
        else
            btn.setImageResource(R.drawable.dog);

//        if (imageOnDisplay == false) {
//            btn.setImageResource(R.drawable.cat);
//            imageOnDisplay = true;
//        } else {
//            btn.setImageResource(R.drawable.dog);
//            imageOnDisplay = false;
//        }

        // Log.i("Cats Rule", "image has changed");
    }

    public void whenLogClicked(View V) {
        for (int counter = 1; counter <= 15; counter++)
            Log.i("Line: ", Integer.toString(counter));
    }

    public void onEvalClick(View V) {
        double midResult = 0;
        EditText editText = (EditText) findViewById(R.id.resultDisplay);
        String input = editText.getText().toString();
        // crawl to find * or / and replace with mid-results

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*' || input.charAt(i) == '/') {
                int j = 0;
                // j is offset from i to the left (i = index of * or /)
                // crawl left to find as much digits as possible
                while (((i - j - 1) >= 0)) {
                    if (!(Character.isDigit(input.charAt(i - j - 1)) || input.charAt(i - j - 1) == '.'))
                        break;
                    else j++;
                }
                String leftNumber = input.substring(i - j, i);

                int q = 0;
                // q is offset from i to the right
                // crawl right to find as much digits as possible
                while ((i + q + 1) < input.length()) {
                    if (!(Character.isDigit(input.charAt(i + q + 1)) || input.charAt(i + q + 1) == '.'))
                        break;
                    else q++;
                }
                String rightNumber = input.substring(i + 1, i + q + 1);

                if (input.charAt(i) == '*')
                    midResult = Double.parseDouble(leftNumber) * Double.parseDouble(rightNumber);
                if (input.charAt(i) == '/')
                    midResult = Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);

//                switch (input.charAt(i)) {
//                    case '*':
//                        midResult=Double.parseDouble(leftNumber) * Double.parseDouble(rightNumber);
//                        break;
//                    case '/':
//                        midResult=Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);
//                        break;
//                }
                input = input.substring(0, i - j) + Double.toString(midResult) + input.substring(i + q + 1);
                i = -1;
            }
        }

        // crawl to find + or - and replace with mid-results
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                int j = 0;
                // j is offset from i to the left (i = index of * or /)
                // crawl left to find as much digits as possible
                while (((i - j - 1) >= 0)) {
                    if (!(Character.isDigit(input.charAt(i - j - 1)) || input.charAt(i - j - 1) == '.'))
                        break;
                    else j++;
                }
                String leftNumber = input.substring(i - j, i);

                int q = 0;
                // q is offset from i to the right
                // crawl right to find as much digits as possible
                while ((i + q + 1) < input.length()) {
                    if (!(Character.isDigit(input.charAt(i + q + 1)) || input.charAt(i + q + 1) == '.'))
                        break;
                    else q++;
                }
                String rightNumber = input.substring(i + 1, i + q + 1);

                if (input.charAt(i) == '+')
                    midResult = Double.parseDouble(leftNumber) + Double.parseDouble(rightNumber);
                if (input.charAt(i) == '-')
                    midResult = Double.parseDouble(leftNumber) - Double.parseDouble(rightNumber);

                input = input.substring(0, i - j) + Double.toString(midResult) + input.substring(i + q + 1);
                i = -1;
            }
        }


        editText.setText(input);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
