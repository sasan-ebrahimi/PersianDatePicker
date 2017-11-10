# PersianDatePicker

A Persian date picker that is completely customizable ...

# ScreenShot

![](http://s9.picofile.com/file/8311417518/SEPersianDatePicker.png)

# Usage

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```gradle
	dependencies {
		compile 'com.github.sasan-ebrahimi:PersianDatePicker:1.0.0'
	}
```

Step 3. Use as XML

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

