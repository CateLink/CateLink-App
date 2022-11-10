package id.kharisma.studio.catelink.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.kharisma.studio.catelink.R;

public class MenuHolder extends RecyclerView.ViewHolder {
    public ImageView menuPoster;
    public TextView hargaMenu;
    public TextView namaVendor;
    public TextView namaMenu;
    public View vw;

    public MenuHolder(@NonNull View itemView) {
        super(itemView);
        menuPoster = itemView.findViewById(R.id.clmenu_poster);
        hargaMenu = itemView.findViewById(R.id.text_hargamenu);
        namaVendor = itemView.findViewById(R.id.text_namavendor);
        namaMenu = itemView.findViewById(R.id.text_namamenu);
        vw = itemView;
    }
}
