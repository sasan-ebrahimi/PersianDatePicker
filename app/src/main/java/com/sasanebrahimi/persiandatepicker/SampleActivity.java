package com.sasanebrahimi.persiandatepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sasanebrahimi.persiandatepicker.PersianDatePicker;

public class SampleActivity extends AppCompatActivity {


    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        final PersianDatePicker pdp = (PersianDatePicker) findViewById(R.id.pdp);
        pdp.setDate(1390 , 5 , 27);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "getDateString(\"/\") : " + pdp.getDateString("/");
                str += "\ngetYear() : " + pdp.getYear();
                str += "\ngetMonth() : " + pdp.getMonth();
                str += "\ngetDay() : " + pdp.getDay();
                tv.setText(str);
            }
        });
    }
}
