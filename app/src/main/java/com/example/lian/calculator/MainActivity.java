package com.example.lian.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private boolean operatorOnDisplay = false;

    public String getDisplayText() {
        EditText disp = (EditText) findViewById(R.id.resultDisplay);
        return disp.getText().toString();
    }

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
        if (operatorOnDisplay) return;
        whenButtonClicked(V);
        operatorOnDisplay = true;

    }

    public void whenClearClicked(View V) {
        EditText disp;
        disp = (EditText) findViewById(R.id.resultDisplay);
        disp.setText("");
        operatorOnDisplay = false;
    }

    public void whenEqualsClicked(View V) {
        String displayText = getDisplayText();
        long result = 0;
        if (displayText.contains("+")) {
            String[] parts = displayText.split("\\+");
            result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
            if (result==20)
                Log.i("Sum:","20");
        }
        if (displayText.contains("-")) {
            String[] parts = displayText.split("-");
            result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
            if (result==17)
                Log.i("Subtract:","17");
        }
        EditText disp = (EditText) findViewById(R.id.resultDisplay);
        disp.setText(Long.toString(result));
        operatorOnDisplay = false;
    }

    public void whenImageClicked(View V) {
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
        btn.setImageResource(R.drawable.cat);
        Log.i("Cats Rule", "image has changed");
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
