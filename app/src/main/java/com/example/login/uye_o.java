package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login.databinding.ActivityUyeOBinding;

public class uye_o extends AppCompatActivity {

    ActivityUyeOBinding binding;
    DB Mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUyeOBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Mydb =new DB(this);

        binding.KayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.kayitEmail.getText().toString();
                String password = binding.kayitSifre.getText().toString();
                String onaypassword= binding.kayitOnaysifre.getText().toString();

                if(email.equals("")|| password.equals("")|| onaypassword.equals("")){

                    //System.out.print("Bilgileri Doldurduğunuzdan Emin Olun");
                    Toast.makeText(uye_o.this,"Lütfen Tüm Bilgileri Doldurunuz",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(onaypassword)){

                        Boolean kontrolemail= Mydb.kontrolEmail(email);

                       if(kontrolemail==false){
                           Boolean insert =  Mydb.insertData(email,password);

                         if(insert ==true){

                             Toast.makeText(uye_o.this," Kayıt Başarılı",Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplicationContext(),Giris_Login.class);
                             startActivity(intent);



                         } else {
                             Toast.makeText(uye_o.this,"Kayıt Olurken Bir Hata Oluştu",Toast.LENGTH_SHORT).show();
                         }



                       }else{

                           Toast.makeText(uye_o.this,"Kullanıcı Zaten Kayıtlı",Toast.LENGTH_SHORT).show();
                       }

                    }else{

                        Toast.makeText(uye_o.this,"Şifreler Eşleşmiyor",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Giris_Login.class);
                startActivity(intent);
            }
        });
    }
}