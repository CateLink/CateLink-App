package id.kharisma.studio.catelink.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.kharisma.studio.catelink.Holder.MenuHolder;
import id.kharisma.studio.catelink.Model.CateMenu;
import id.kharisma.studio.catelink.R;

public class Home_catemenuActivity extends AppCompatActivity {

    // Inisialisasi variabel bottom nav
    BottomNavigationView nav;

    // Inisialisasi variabel Recyclerview
    RecyclerView menuRecycler;

    // Inisialisasi variabel Searchview
    SearchView searchView;

    // Inisialisasi Firebase
    FirebaseRecyclerOptions<CateMenu> options;
    FirebaseRecyclerAdapter<CateMenu, MenuHolder> menuAdapter;
    DatabaseReference menDataRef ;

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

        // Recyclerview Layoutmanager
        menuRecycler = findViewById(R.id.menu_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        menuRecycler.setLayoutManager(layoutManager);
        menuRecycler.setHasFixedSize(true);

        //Database Reference
        menDataRef = FirebaseDatabase.getInstance().getReference().child("CateMenu");

        bottomNav();
        setSearchView();
        LoadData();

    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<CateMenu>().setQuery(menDataRef,CateMenu.class).build();
        menuAdapter = new FirebaseRecyclerAdapter<CateMenu, MenuHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MenuHolder holder, final int position, @NonNull CateMenu model) {
                holder.namaMenu.setText(model.getMenuName());
                holder.namaVendor.setText(model.getVendorName());
                holder.hargaMenu.setText("Rp " + model.getMenuPrice());
                Picasso.get().load(model.getPoster()).into(holder.menuPoster);

                // Recyclerview bisa di klik menuju ke detail menu activity
                holder.vw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Home_catemenuActivity.this, Detailmenu_Activity.class );
                        intent.putExtra("MenuKey", getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_menu_ct,parent,false);

                return new MenuHolder(v);
            }
        };

        menuAdapter.startListening();
        menuRecycler.setAdapter(menuAdapter);


    }

    protected void setSearchView(){
        searchView = findViewById(R.id.search_view_menu);
        searchView.clearFocus();

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