package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class sayfa11 extends AppCompatActivity {
    private RecyclerView sayfa1akis;
    private ArrayList<photo> photos;
    private adaptor adaptor;
    BottomNavigationView navmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa11);
        sayfa1akis= findViewById(R.id.sayfa1akis);
        navmenu=findViewById(R.id.navmenu);
        photos = new ArrayList<>();
        adaptor= new adaptor(photos);
        sayfa1akis.setAdapter(adaptor);
        sayfa1akis.setLayoutManager(new LinearLayoutManager(this));
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

        photos.add(new photo(R.drawable.hogwarts,"Hogwarts"," Haryy Potter Evrenindeki Büyücülük okulu"));
        photos.add(new photo(R.drawable.kasaba,"Bikini Kasabası","Süngerbob evreninde bulunan mekan"));
        photos.add(new photo(R.drawable.charlie,"Çikolata Fabrikası","Charlie'nin Çikolata Fabrikası evrenindeki çikolatadan oluşan fabrika"));
        photos.add(new photo(R.drawable.gameof,"Kralın Şehri"," Game of Thrones evrenindeki bir şehir "));


    }
}