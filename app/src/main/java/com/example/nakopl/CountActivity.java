package com.example.nakopl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {

    TextView tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String[] data = bundle.getStringArray("data");
            System.out.println(Integer.parseInt(data[0]));
            tv2.setText(String.valueOf(Integer.parseInt(data[0])/100/4));
            tv3.setText(String.valueOf(Integer.parseInt(data[0]) +
                    Integer.parseInt(data[0])/100/4 +
                    Integer.parseInt(data[2])*Integer.parseInt(data[1])));
        }
    }
}