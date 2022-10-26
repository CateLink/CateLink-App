package id.kharisma.studio.catelink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class Home_catemenuActivity extends AppCompatActivity {

    // Inisialisasi variabel
    BottomNavigationView nav;
    RecyclerView recyclerView;
    daftar_menu_Adapter daftarMenuAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<daftar_menu_item_model> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_catemenu);

        // Recycler View
        recyclerView = findViewById(R.id.menu_recycler);
        recyclerView.setHasFixedSize(true);

        // Recycler View model Grid dan jumlah ke samping
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i = 0; i < daftar_menu_item.namaMenu.length; i++){
            data.add(new daftar_menu_item_model(
                    daftar_menu_item.namaMenu[i],
                    daftar_menu_item.namaVendor[i],
                    daftar_menu_item.alamatVendor[i],
                    daftar_menu_item.hargaMenu[i],
                    daftar_menu_item.rateValue[i],
                    daftar_menu_item.menuposter[i]
            ));
        }

        // membuat adapter
        daftarMenuAdapter = new daftar_menu_Adapter(data);
        recyclerView.setAdapter(daftarMenuAdapter);

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