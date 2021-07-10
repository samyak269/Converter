package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MoneyConverter extends AppCompatActivity {
    TextView currency, result, convert;
    double curencyValue = 0.0;
    int type;
    String currencyType = "";
    double dollar, rupee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_converter);


        type = getIntent().getIntExtra("type", 0);

        switch (type) {
            case 0:
                curencyValue = 74.19;
                currencyType = "Rupee";
                break;
            case 1:
                curencyValue = 103.18;
                currencyType = "Rupee";

                break;
            case 2:
                curencyValue = 1.39;
                currencyType = "Dollar";

                break;
            default:
                curencyValue = 74.19;
                currencyType = "Rupee";

                break;

        }
        currency = findViewById(R.id.inDollarBox);
        result = findViewById(R.id.inRsBox);
        convert = findViewById(R.id.convertbutton);

        currency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (currency.getText().toString() != null && !currency.getText().toString().equals("")) {
                    dollar = Double.parseDouble(currency.getText().toString());
                    calculate(dollar);

                } else {
                    rupee = 0.0;
                    String ss = "Rs " +String.valueOf(rupee)  ;
                    result.setText( ss );
                }
            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currency.getText().toString() != null && !currency.getText().toString().equals("")) {
                    dollar = Double.parseDouble(currency.getText().toString());
                    calculate(dollar);

                } else {
                    Toast.makeText(MoneyConverter.this, "Enter a Value!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
        private void calculate(double dollar) {
            rupee = dollar * curencyValue;
            result.setText(rupee + currencyType);
        }
    }




