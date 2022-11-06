package id.kharisma.studio.catelink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import id.kharisma.studio.catelink.R;

public class Detailmenu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmenu);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();

        //Tombol back pada Nav Bar
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
}