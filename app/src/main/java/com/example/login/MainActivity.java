package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navmenu;

    private ArrayList<photo> photostarih;
    RecyclerView sayfa2akis;
    private adaptor adaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navmenu=findViewById(R.id.navmenu);
        sayfa2akis=findViewById(R.id.sayfa2akis);
        photostarih = new ArrayList<>();
        adaptor= new adaptor(photostarih);
        sayfa2akis.setAdapter(adaptor);
        sayfa2akis.setLayoutManager(new LinearLayoutManager(this));
        diziolustur();
        adaptor.notifyDataSetChanged();

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

    private void diziolustur() {

        photostarih.add(new photo(R.drawable.ayasofya,"Topkapı Sarayı"," İstanbulda bulunan tarihi yer"));
        photostarih.add(new photo(R.drawable.kiz,"Kız Kulesi","İstanbulda bulunan tarihi yer"));
        photostarih.add(new photo(R.drawable.kolezyum,"Kolezyum","Romada bulunan tarihi yer"));
        photostarih.add(new photo(R.drawable.trevi,"Trevi Çeşmesi","Romada bulunan tarihi yer"));
    }
}