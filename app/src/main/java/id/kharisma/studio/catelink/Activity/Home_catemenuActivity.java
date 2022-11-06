package id.kharisma.studio.catelink.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import id.kharisma.studio.catelink.Adapter.daftar_menu_Adapter;
import id.kharisma.studio.catelink.Model.CateMenu;
import id.kharisma.studio.catelink.R;

public class Home_catemenuActivity extends AppCompatActivity {

    RecyclerView menuRecycler;
    daftar_menu_Adapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_catemenu);

        List<CateMenu> cateMenuList = new ArrayList<>();

        cateMenuList.add(new CateMenu("Nasi Kotak Rendang Daging","Catering Box","25000",R.drawable.mccl_nasi_rendang_kotak));
        cateMenuList.add(new CateMenu("Menu Diet Ayam","Healthy Catering","40000",R.drawable.mccl_ayam_diet));
        cateMenuList.add(new CateMenu("Nasi Kotak Ayam Bumbu","Catering Box","20000",R.drawable.mccl_nasi_ayam_bumbu));
        cateMenuList.add(new CateMenu("Paket Kantoran A","Catering Kantoranku","25000",R.drawable.mccl_menu_kantoran_a));
        cateMenuList.add(new CateMenu("Paket Prasmanan A","Bahagia Catering","45000",R.drawable.mccl_paket_prasmanan_a));
        cateMenuList.add(new CateMenu("Rantang Paket A","Dapur Ibu Sinar","25000",R.drawable.mccl_rantang_paket_a));

        setMenuRecycler(cateMenuList);

    }

    private void setMenuRecycler(List<CateMenu> cateMenuList){

        menuRecycler = findViewById(R.id.menu_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        menuRecycler.setLayoutManager(layoutManager);
        menuAdapter = new daftar_menu_Adapter(this, cateMenuList);
        menuRecycler.setAdapter(menuAdapter);

    }

}