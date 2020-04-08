package com.example.myapplication;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Spinner;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = findViewById(R.id.spinner);
                String checkLang = spinner.getSelectedItem().toString();
                System.out.println(checkLang);
                if ((checkLang).equals("Russian")){
                    setLanguage("ru");
                } else {
                    if ((checkLang).equals("Английский")){
                        setLanguage("en");
                    }
                }
                Spinner spinnerMarg = findViewById(R.id.spinnerMargin);
                @Margin int checkTheme = spinnerMarg.getSelectedItemPosition();
                System.out.println(checkTheme);

                switch (checkTheme) {
                    case Margin.LARGE:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGINLARGE);
                        break;
                    case Margin.MIDDLE:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGINSMIDDLE);
                        break;
                    case Margin.SMALL:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGINSMALL);
                        break;
                }

            }


        });


    }


    @IntDef({Margin.LARGE, Margin.MIDDLE, Margin.SMALL})
    @interface Margin {
        int LARGE = 0;
        int MIDDLE = 1;
        int SMALL = 2;
    }

    private void setLanguage(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();



    }


}
