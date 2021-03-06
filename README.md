# PersianDatePicker

A Persian date picker that is completely customizable ...

# ScreenShot

![](http://s9.picofile.com/file/8311417518/SEPersianDatePicker.png)

# Usage

## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
## Step 2. Add the dependency

```gradle
	dependencies {
		compile 'com.github.sasan-ebrahimi:PersianDatePicker:1.0.2'
	}
```

## Step 3. Use as XML

```xml
<com.sasanebrahimi.persiandatepicker.PersianDatePicker
                android:id="@+id/pdp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center">
</com.sasanebrahimi.persiandatepicker.PersianDatePicker>
```

Custom Attributes

```xml
<com.sasanebrahimi.persiandatepicker.PersianDatePicker
                android:id="@+id/pdp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                app:se_pdp_day="24"
                app:se_pdp_month="1"
                app:se_pdp_year="1397"
                app:se_pdp_divider_color="@color/colorPrimary"
                app:se_pdp_text_color="@color/colorPrimary"
                app:se_pdp_max_year="1398"
                app:se_pdp_min_year="1380">
</com.sasanebrahimi.persiandatepicker.PersianDatePicker>
```

## Attributes

|attribute name|attribute description|
|:-:|:-:|
|se_pdp_day|The selected day of datepicker|
|se_pdp_month|The selected month of datepicker|
|se_pdp_year|The selected year of datepicker|
|se_pdp_divider_color|Color of divider line between row of each column|
|se_pdp_text_color|Color of datepicker texts|
|se_pdp_max_year|Maximum value for year|
|se_pdp_min_year|Minimum value for year|

## Methods

|Method name|Method description|
|:-:|:-:|
|getDateString(String seperator)|String - Returns complete date in string with given seperator like 1397-01-24 or 1397/01/24|
|getDay()|int - Returns selected day of datepicker in int|
|getMonth()|int - Returns selected month of datepicker in int|
|getYear()|int - Returns selected year of datepicker in int|
