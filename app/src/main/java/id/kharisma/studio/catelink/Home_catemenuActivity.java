package id.kharisma.studio.catelink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import id.kharisma.studio.catelink.Adapter.daftar_menu_Adapter;
import id.kharisma.studio.catelink.Model.daftar_menu_item_model;


public class Home_catemenuActivity extends AppCompatActivity {

    // Inisialisasi variabel bottom nav
    BottomNavigationView nav;

    // Inisialisasi var Recyclerview
    RecyclerView recyclerView;
    daftar_menu_item_model[] mymenu = new daftar_menu_item_model[]{
            new daftar_menu_item_model("Nasi Kotak Rendang Daging","Catering Box", "25000", R.drawable.mccl_nasi_rendang_kotak),
            new daftar_menu_item_model("Menu Diet Ayam","Healthy Catering","40000", R.drawable.mccl_ayam_diet),
            new daftar_menu_item_model("Nasi Kotak Ayam Bumbu","Catering Box", "20000", R.drawable.mccl_nasi_ayam_bumbu),
            new daftar_menu_item_model("Paket Kantoran A","Catering Kantoranku", "25000", R.drawable.mccl_menu_kantoran_a),
            new daftar_menu_item_model("Paket Prasmanan A","Bahagia Catering", "255000",R.drawable.mccl_paket_prasmanan_a),
            new daftar_menu_item_model("Rantang Paket A","Dapur Ibu Sinar", "25000",R.drawable.mccl_rantang_paket_a)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_catemenu);

        // Recycler View
        recyclerView = findViewById(R.id.menu_recycler);

        daftar_menu_Adapter adapter = new daftar_menu_Adapter(mymenu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        // Bottom Nav
        nav = findViewById(R.id.bottom_navigation);


        // Tampilan yg muncul saat dipilih
        nav.setSelectedItemId(R.id.btn_home);

        // Untuk pindah- pindah pada bottom nav bar
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.btn_home:
                        return true;
                    case R.id.btn_recom:
                        startActivity(new Intent(getApplicationContext(),RecommendActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.btn_fav:
                        startActivity(new Intent(getApplicationContext(),FavoriteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.btn_setnprofile:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        // Custom image for action bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_actionbar_image, null);
        actionBar.setCustomView(view);
        // Custom image for action bar
    }
}