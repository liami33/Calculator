package com.example.lian.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    public void whenButtonClicked(View V) {
        // V is a reference for the widget that was clicked
        EditText disp;
        disp = (EditText) findViewById(R.id.resultDisplay);
        Button b = (Button) V;
        CharSequence buttonText = b.getText();
        String oldText = disp.getText().toString();
        String newText = oldText + buttonText.toString();
        disp.setText(newText);
        Log.i("Button clicked: ", buttonText.toString());

    }

    public void whenClearClicked(View V) {
        EditText disp;
        disp = (EditText) findViewById(R.id.resultDisplay);
        disp.setText("0");
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
