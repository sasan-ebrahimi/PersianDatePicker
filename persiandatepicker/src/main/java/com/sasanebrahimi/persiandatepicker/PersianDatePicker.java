package com.sasanebrahimi.persiandatepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.shawnlin.numberpicker.NumberPicker;

/**
 * Created by Sasan Ebrahimi on 11/10/17  10:48 AM.
 */

public class PersianDatePicker extends RelativeLayout{


    LayoutInflater inflater;
    View view;
    NumberPicker npYear, npMonth, npDay;
    int textColor , dividerColor;
    int textSize = 24;
    int minYear = 1300 , maxYear = 1450;
    int year = 1397 , month = 1 , day = 24 ;

    //EditText etYear , etMonth , etDay;

    public PersianDatePicker(Context context) {
        super(context);
        init(context);
        initViews(context);
    }

    public PersianDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    public PersianDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PersianDatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttributes(context, attrs);
    }

    // ------------------- inits -------------------
    private void init(Context context) {
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.view, this, true);
        npYear = (com.shawnlin.numberpicker.NumberPicker) view.findViewById(R.id.np_year);
        npYear.setFormatter(new com.shawnlin.numberpicker.NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return convertLatinNumberToPersian("" + value);
            }
        });
        npMonth = (NumberPicker) view.findViewById(R.id.np_month);
        npMonth.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                switch (value){
                    case 1:
                        return "فروردین";
                    case 2:
                        return "اردیبهشت";
                    case 3:
                        return "خرداد";
                    case 4:
                        return "تیر";
                    case 5:
                        return "مرداد";
                    case 6:
                        return "شهریور";
                    case 7:
                        return "مهر";
                    case 8:
                        return "آبان";
                    case 9:
                        return "آذر";
                    case 10:
                        return "دی";
                    case 11:
                        return "بهمن";
                    case 12:
                        return "اسفند";

                }
                return convertLatinNumberToPersian("" + value);
            }
        });
        npDay = (NumberPicker) view.findViewById(R.id.np_day);
        npDay.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return convertLatinNumberToPersian("" + value);
            }
        });
    }

    private void initAttributes(Context context , AttributeSet attrs){

        init(context);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PersianDatePicker);
        day = a.getInt(R.styleable.PersianDatePicker_se_pdp_day , day);
        month = a.getInt(R.styleable.PersianDatePicker_se_pdp_month , month);
        year = a.getInt(R.styleable.PersianDatePicker_se_pdp_year , year);
        maxYear = a.getInt(R.styleable.PersianDatePicker_se_pdp_max_year , maxYear);
        minYear = a.getInt(R.styleable.PersianDatePicker_se_pdp_min_year , minYear);
        textColor = a.getColor(R.styleable.PersianDatePicker_se_pdp_text_color , Color.BLACK);
        dividerColor = a.getColor(R.styleable.PersianDatePicker_se_pdp_divider_color , Color.BLACK);
        initViews(context);

    }

    private void initViews(Context context){
        npYear.setMinValue(minYear);
        npYear.setMaxValue(maxYear);

        npMonth.setMinValue(1);
        npMonth.setMaxValue(12);

        npDay.setMinValue(1);
        npDay.setMaxValue(31);

        npYear.setValue(year);
        npMonth.setValue(month);
        npDay.setValue(day);

        npYear.setTextColor(textColor);
        npMonth.setTextColor(textColor);
        npDay.setTextColor(textColor);

        npYear.setDividerColor(dividerColor);
        npMonth.setDividerColor(dividerColor);
        npDay.setDividerColor(dividerColor);

        textSize = dpToPixel(context , textSize);

        setTypeFace("");
    }

    // ----------------------- setTypeFace ------------------
    private void setTypeFace(String assetFontPath) {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/IRANYekanMobileRegular.ttf");
        npYear.setTypeface(tf);
        npMonth.setTypeface(tf);
        npDay.setTypeface(tf);


    }

    // ----------------------- setTypeFace ------------------
    private void setTextSize(float textSize) {
        npYear.setTextSize(textSize);
        npMonth.setTextSize(textSize);
        npDay.setTextSize(textSize);
    }

    // ----------------------- getDate ------------------
    public String getDateString(String seperator) {
        if(seperator == null)
            seperator = "/";
        String result = npYear.getValue() + seperator;
        if (npMonth.getValue() < 10) {
            result += "0" + npMonth.getValue() + seperator;
        } else {
            result += npMonth.getValue() + seperator;
        }
        if (npDay.getValue() < 10) {
            result += "0" + npDay.getValue();
        } else {
            result += npDay.getValue();
        }
        return result;

    }

    public int getYear(){
        return npYear.getValue();
    }
    public int getMonth(){
        return npMonth.getValue();
    }
    public int getDay(){
        return npDay.getValue();
    }
    // ----------------------- setDate ------------------
    public void setDate(int year , int month , int day) {
        npYear.setValue(year);
        npMonth.setValue(month);
        npDay.setValue(day);
    }


    private String convertLatinNumberToPersian(String feed) {

        return feed.replaceAll("1", "۱")
                .replaceAll("2", "۲")
                .replaceAll("3", "۳")
                .replaceAll("4", "۴")
                .replaceAll("5", "۵")
                .replaceAll("6", "۶")
                .replaceAll("7", "۷")
                .replaceAll("8", "۸")
                .replaceAll("9", "۹")
                .replaceAll("0", "۰");
    }

    private String convertPersianNumberToLatin(String feed) {

        return feed.replaceAll("۱", "1")
                .replaceAll("۲", "2")
                .replaceAll("۳", "3")
                .replaceAll("۴", "4")
                .replaceAll("۵", "5")
                .replaceAll("۶", "6")
                .replaceAll("۷", "7")
                .replaceAll("۸", "8")
                .replaceAll("۹", "9")
                .replaceAll("۰", "0");
    }

    // ------------------- dpToPixel --------------------
    private int dpToPixel(Context context , int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
