package org.kabiri.modernartui;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    View tileYellow;
    View tileWhite;
    View tileBlue;
    View tileRed;
    View tileLime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tileYellow = findViewById(R.id.tile_yellow);
        tileWhite = findViewById(R.id.tile_white);
        tileBlue = findViewById(R.id.tile_blue);
        tileRed = findViewById(R.id.tile_red);
        tileLime = findViewById(R.id.tile_lime);


        AppCompatSeekBar seekBar = (AppCompatSeekBar) findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekBar:", "position:" + i);

                // make a value between 1 and 0 to use as multiplier value.
                float mul = 1 - i/200f;

                tileYellow.setBackgroundColor(alterHue(getResources().getColor(R.color.yellow), mul));
                tileWhite.setBackgroundColor(alterHue(getResources().getColor(R.color.white), mul));
                tileBlue.setBackgroundColor(alterHue(getResources().getColor(R.color.blue), mul));
                tileRed.setBackgroundColor(alterHue(getResources().getColor(R.color.deep_orange), mul));
                tileLime.setBackgroundColor(alterHue(getResources().getColor(R.color.lime), mul));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private int alterHue(int color, float mul) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[0] *= mul; // value component
        return Color.HSVToColor(hsv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate the menu from resources
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // check which menu item was clicked.
        switch (item.getItemId()) {

            case R.id.more_info:
                // open the information dialog fragment
                DialogFragment informationDialogFragment = InformationDialogFragment.newInstance();
                informationDialogFragment.show(getSupportFragmentManager(), InformationDialogFragment.TAG);
                return true;
            default:
                // default operation if the menu item was not recognized
                return super.onOptionsItemSelected(item);
        }
    }
}
