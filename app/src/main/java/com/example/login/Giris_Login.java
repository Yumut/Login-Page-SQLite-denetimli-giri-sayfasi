package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login.databinding.ActivityGirisLoginBinding;

public class Giris_Login extends AppCompatActivity {

    ActivityGirisLoginBinding binding;
    DB Mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityGirisLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        Mydb = new DB(this);
        binding.GirisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= binding.girisEmail.getText().toString();
                String password = binding.girisSifre.getText().toString();

                if(email.equals("")||password.equals("")){
                    Toast.makeText(Giris_Login.this,"Lütfen Tüm Bilgileri Doldurunuz",Toast.LENGTH_SHORT).show();
                }else{

                    Boolean kontrol = Mydb.kontrolsifreemail(email,password);
                    if(kontrol == true){



                        Toast.makeText(Giris_Login.this,"Başarılı Giriş",Toast.LENGTH_SHORT).show();

                        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                        Intent intent2 = new Intent(Giris_Login.this, sayfa2.class);
                        intent2.putExtra("veri", binding.girisEmail.getText().toString());
                        startActivity(intent2);
                        startActivity(intent);
                    }else{

                        Toast.makeText(Giris_Login.this,"Başarız Giriş, Bilgilerinizi Kontrol Ediniz",Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });





        binding.KayitOlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),uye_o.class);
                startActivity(intent);
            }
        });

    }




}