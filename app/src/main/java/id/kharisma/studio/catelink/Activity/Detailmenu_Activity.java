package id.kharisma.studio.catelink.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import id.kharisma.studio.catelink.R;

public class Detailmenu_Activity extends AppCompatActivity {

    // Inisialisasi variabel bottom nav
    private BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmenu);


        //Tombol back pada Nav Bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Custom image for action bar
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_actionbar_image, null);
        actionBar.setCustomView(view);
        // Custom image for action bar
    }

    //Kembali ke halaman home cate menu
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        startActivity(new Intent(Detailmenu_Activity.this, Home_catemenuActivity.class));
        finish(); // menutup hal detail menu
        return true;
    }

    //Mengaktifkan tombol back
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    // Bottom Navigation View
    protected void bottomNav(){
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