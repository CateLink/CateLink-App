package id.kharisma.studio.catelink.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import id.kharisma.studio.catelink.R;

public class Detailmenu_Activity extends AppCompatActivity {

    // Inisialisasi variabel bottom nav
    private BottomNavigationView nav;

    private ImageView dtlImageView;
    TextView dtlNamaMenu;
    TextView dtlNamaVendor;
    TextView alamatVendor;
    TextView dtlHargaMenu;
    TextView deskripMenu;
    TextView jmlhPesanDtl;
    Button addCart;
    ImageView btnMinDtl;
    ImageView btnAddDtl;

    // Utk database reference
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmenu);

        dtlImageView = findViewById(R.id.detail_mknfoto);
        dtlNamaMenu = findViewById(R.id.txt_namamenu);
        dtlNamaVendor = findViewById(R.id.txt_namavendor);
        alamatVendor = findViewById(R.id.txt_alvendor);
        dtlHargaMenu = findViewById(R.id.txt_hargamenu);
        deskripMenu = findViewById(R.id.txt_detailmenudesk);
        jmlhPesanDtl = findViewById(R.id.txt_jmlhdtl);
        addCart = findViewById(R.id.btn_tmbhcart);
        btnMinDtl = findViewById(R.id.btn_mindtl);
        btnAddDtl = findViewById(R.id.btn_plusdtl);

        // Database Reference
        ref = FirebaseDatabase.getInstance().getReference().child("CateMenu");

        String MenuKey = getIntent().getStringExtra("MenuKey");

        ref.child(MenuKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String Menuname = snapshot.child("menuName").getValue().toString();
                    String Vendorname = snapshot.child("vendorName").getValue().toString();
                    String Vendoraddress = snapshot.child("vendorAddress").getValue().toString();
                    String Menuprice = snapshot.child("menuPrice").getValue().toString();
                    String Descmenu = snapshot.child("descMenu").getValue().toString();
                    String Poster = snapshot.child("poster").getValue().toString();

                    Picasso.get().load(Poster).into(dtlImageView);
                    dtlNamaMenu.setText(Menuname);
                    dtlNamaVendor.setText(Vendorname);
                    alamatVendor.setText(Vendoraddress);
                    dtlHargaMenu.setText("Rp " + Menuprice);
                    deskripMenu.setText(Descmenu);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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