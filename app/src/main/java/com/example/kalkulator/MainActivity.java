package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    ImageButton tambah, kurang, kali, bagi;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1=(EditText) findViewById(R.id.input1);
        angka2=(EditText) findViewById(R.id.input2);
        tvHasil=(TextView) findViewById(R.id.viewHasil);
        tambah = (ImageButton) findViewById(R.id.buttonPenjumlahan);
        kurang=(ImageButton) findViewById(R.id.buttonPengurangan);
        kali=(ImageButton) findViewById(R.id.buttonPerkalian);
        bagi=(ImageButton) findViewById(R.id.buttonPembagian);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, Hasil;
                bil1=Double.valueOf(angka1.getText().toString(). trim());
                bil2=Double.valueOf(angka2.getText().toString(). trim());
                Hasil =bil1+bil2;
                String hasil=String.valueOf(Hasil);
                tvHasil.setText(hasil);
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, Hasil;
                bil1=Double.valueOf(angka1.getText().toString(). trim());
                bil2=Double.valueOf(angka2.getText().toString(). trim());
                Hasil =bil1-bil2;
                String hasil=String.valueOf(Hasil);
                tvHasil.setText(hasil);
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1, bil2, Hasil;
                bil1=Double.valueOf(angka1.getText().toString(). trim());
                bil2=Double.valueOf(angka2.getText().toString(). trim());
                Hasil =bil1*bil2;
                String hasil=String.valueOf(Hasil);
                tvHasil.setText(hasil);
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, Hasil;
                bil1=Double.valueOf(angka1.getText().toString(). trim());
                bil2=Double.valueOf(angka2.getText().toString(). trim());
                Hasil =bil1/bil2;
                String hasil=String.valueOf(Hasil);
                tvHasil.setText(hasil);
            }
        });

    }
}