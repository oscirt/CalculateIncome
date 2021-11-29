package com.example.nakopl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Button button;
    private TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        final SeekBar seekBar1 = findViewById(R.id.seekBar2);
        seekBar1.setOnSeekBarChangeListener(this);
        final SeekBar seekBar2 = findViewById(R.id.seekBar3);
        seekBar2.setOnSeekBarChangeListener(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        tv1 = findViewById(R.id.open);
        tv2 = findViewById(R.id.time);
        tv3 = findViewById(R.id.month);
    }

    @Override
    public void onClick(View view) {
        String[] data = new String[3];
        data[0] = tv1.getText().toString();
        data[1] = tv2.getText().toString();
        data[2] = tv3.getText().toString();
        for (int i = 0; i < 3; i++) {
            System.out.println(data[i]);
        }

        Intent intent = new Intent(this, CountActivity.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar) {
            tv1.setText(String.valueOf(seekBar.getProgress()*1000));
        } else if (seekBar.getId() == R.id.seekBar2) {
            tv2.setText(String.valueOf(seekBar.getProgress()));
        } else {
            tv3.setText(String.valueOf(seekBar.getProgress()*1000));
        }
    }
}