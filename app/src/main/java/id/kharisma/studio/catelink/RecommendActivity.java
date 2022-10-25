package id.kharisma.studio.catelink;

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

public class RecommendActivity extends AppCompatActivity {

    // Inisialisasi variabel
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        nav = findViewById(R.id.bottom_navigation);

        // Tampilan yg muncul saat dipilih
        nav.setSelectedItemId(R.id.btn_recom);

        // Untuk pindah- pindah pada bottom nav bar
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.btn_home:
                        startActivity(new Intent(getApplicationContext(),Home_catemenuActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.btn_recom:
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