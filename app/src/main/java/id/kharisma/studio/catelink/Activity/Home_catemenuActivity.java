package id.kharisma.studio.catelink.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

import id.kharisma.studio.catelink.Adapter.daftar_menu_Adapter;
import id.kharisma.studio.catelink.Model.CateMenu;
import id.kharisma.studio.catelink.R;

public class Home_catemenuActivity extends AppCompatActivity {

    // Inisialisasi variabel bottom nav
    BottomNavigationView nav;

    // Inisialisasi variabel Recyclerview
    RecyclerView menuRecycler;
    daftar_menu_Adapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_catemenu);

        // Custom image for action bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_actionbar_image, null);
        actionBar.setCustomView(view);
        // Custom image for action bar

        List<CateMenu> cateMenuList = new ArrayList<>();

        cateMenuList.add(new CateMenu("Nasi Kotak Rendang Daging","Catering Box",25000,R.drawable.mccl_nasi_rendang_kotak));
        cateMenuList.add(new CateMenu("Menu Diet Ayam","Healthy Catering",35000,R.drawable.mccl_ayam_diet));
        cateMenuList.add(new CateMenu("Nasi Kotak Ayam Bumbu","Catering Box",20000,R.drawable.mccl_nasi_ayam_bumbu));
        cateMenuList.add(new CateMenu("Paket Kantoran A","Catering Kantoranku",25000,R.drawable.mccl_menu_kantoran_a));
        cateMenuList.add(new CateMenu("Paket Prasmanan A","Bahagia Catering",45000,R.drawable.mccl_paket_prasmanan_a));
        cateMenuList.add(new CateMenu("Rantang Paket A","Dapur Ibu Sinar",25000,R.drawable.mccl_rantang_paket_a));

        setMenuRecycler(cateMenuList);

        bottomNav();

    }

    private void setMenuRecycler(List<CateMenu> cateMenuList){

        menuRecycler = findViewById(R.id.menu_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        menuRecycler.setLayoutManager(layoutManager);
        menuAdapter = new daftar_menu_Adapter(this, cateMenuList);
        menuRecycler.setAdapter(menuAdapter);

    }

    // Bottom Navigation View
    public void bottomNav(){
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
                    case R.id.btn_cart:
                        startActivity(new Intent(getApplicationContext(),KeranjangActivity.class));
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
    }
}