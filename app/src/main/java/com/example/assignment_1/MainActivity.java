package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button milk_btn;
    Button sugar_btn;
    //testing commit
    Button flour_btn;
    Button bread_btn;
    int milkItemsPurchased = 0;
    double milkPrice = 70.25d;
    int sugarItemsPurchased = 0;
    double sugarPrice = 183.25d;
    int flourItemsPurchased = 0;
    double flourPrice = 123.25d;
    int breadItemsPurchased = 0;
    double breadPrice = 65.25d;

    double grandTotal = 0.0;
    double discount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milk_btn = findViewById(R.id.milk_button);
        sugar_btn = findViewById(R.id.sugar_button);
        flour_btn = findViewById(R.id.flour_button);
        bread_btn = findViewById(R.id.bread_button);
        milk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milkItemsPurchased++;
                updateCart();
                Milk();
            }
        });
        sugar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sugarItemsPurchased++;
                updateCart();
                Sugar();
            }
        });

        flour_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flourItemsPurchased++;
                updateCart();
                Flour();
            }
        });

        bread_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breadItemsPurchased++;
                updateCart();
                Bread();
            }
        });

    }

    public void updateCart() {
        grandTotal = (milkItemsPurchased * milkPrice) + (sugarItemsPurchased * sugarPrice) + (flourItemsPurchased * flourPrice) + (breadItemsPurchased * breadPrice);

        if (grandTotal > 1000) {
            discount = 0.2 * grandTotal; // 20% discount
        }
        else if (grandTotal > 500) {
            discount = 0.1 * grandTotal; // 10% discount
        }
        else {
            discount = 0.0;
        }

        double netPay = grandTotal - discount;

        EditText grandTotalField = findViewById(R.id.grand_total);
        EditText discountField = findViewById(R.id.discount);
        EditText netPayField = findViewById(R.id.net_pay);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        grandTotalField.setText(decimalFormat.format(grandTotal));
        discountField.setText(decimalFormat.format(discount));
        netPayField.setText(decimalFormat.format(netPay));
    }

    public void Milk () {
        double totalMilkPrice = milkItemsPurchased * milkPrice;
        double vat_amount = totalMilkPrice * 0.16;
        double actual_price_amount = totalMilkPrice - vat_amount;

        EditText price = findViewById(R.id.milk_price);
        EditText vat = findViewById(R.id.milk_vat);
        EditText actual_price = findViewById(R.id.milk_actual_price);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String milk_price = decimalFormat.format(totalMilkPrice);
        String vat_price = decimalFormat.format(vat_amount);
        String actual_price_output = decimalFormat.format(actual_price_amount);

        price.setText(milk_price);
        vat.setText(vat_price);
        actual_price.setText(actual_price_output);

    }

    public void Sugar () {
        double totalSugarPrice = sugarItemsPurchased * sugarPrice;
        double vat_amount = totalSugarPrice * 0.16;
        double actual_price_amount = totalSugarPrice - vat_amount;

        EditText price = findViewById(R.id.sugar_price);
        EditText vat = findViewById(R.id.sugar_vat);
        EditText actual_price = findViewById(R.id.sugar_actual_price);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String sugar_price = decimalFormat.format(totalSugarPrice);
        String vat_price = decimalFormat.format(vat_amount);
        String actual_price_output = decimalFormat.format(actual_price_amount);

        price.setText(sugar_price);
        vat.setText(vat_price);
        actual_price.setText(actual_price_output);

    }

    public void Flour () {
        double totalFlourPrice = flourItemsPurchased * flourPrice;
        double vat_amount = totalFlourPrice * 0.16;
        double actual_price_amount = totalFlourPrice - vat_amount;

        EditText price = findViewById(R.id.flour_price);
        EditText vat = findViewById(R.id.flour_vat);
        EditText actual_price = findViewById(R.id.flour_actual_price);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String flour_price = decimalFormat.format(totalFlourPrice);
        String vat_price = decimalFormat.format(vat_amount);
        String actual_price_output = decimalFormat.format(actual_price_amount);

        price.setText(flour_price);
        vat.setText(vat_price);
        actual_price.setText(actual_price_output);

    }

    public void Bread () {
        double totalBreadPrice = breadItemsPurchased * breadPrice;
        double vat_amount = totalBreadPrice * 0.16;
        double actual_price_amount = totalBreadPrice - vat_amount;

        EditText price = findViewById(R.id.bread_price);
        EditText vat = findViewById(R.id.bread_vat);
        EditText actual_price = findViewById(R.id.bread_actual_price);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String bread_price = decimalFormat.format(totalBreadPrice);
        String vat_price = decimalFormat.format(vat_amount);
        String actual_price_output = decimalFormat.format(actual_price_amount);

        price.setText(bread_price);
        vat.setText(vat_price);
        actual_price.setText(actual_price_output);

    }
}