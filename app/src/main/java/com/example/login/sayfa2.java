package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.databinding.ActivityGirisLoginBinding;
import com.example.login.databinding.ActivitySayfa2Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class sayfa2 extends AppCompatActivity{
    BottomNavigationView navmenu;
    Button kapa;
    TextView usertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sayfa2);
        navmenu=findViewById(R.id.navmenu);
        usertext=findViewById(R.id.user);
        kapa= (Button)findViewById(R.id.cikisButton);
        String gelenYazi=getIntent().getExtras().getString("veri");
        usertext.setText("Merhaba"+" "+gelenYazi+" " +"Profil Sayfanıza Hoşgeldiniz");



        kapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        navmenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){

                    case R.id.tarihisayfa:
                        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                        break;
                    case R.id.kurgusayfa:
                        Intent intent2 =new Intent(getApplicationContext(),sayfa11.class);
                        startActivity(intent2);


                        break;
                    case R.id.profilsayfa:
                        Intent intent3 =new Intent(getApplicationContext(),sayfa2.class);
                        startActivity(intent3);


                        break;
                }
                return true;
            }
        });
    }
}