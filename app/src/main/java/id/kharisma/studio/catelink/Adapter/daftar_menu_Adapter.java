package id.kharisma.studio.catelink.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.kharisma.studio.catelink.R;
import id.kharisma.studio.catelink.Model.daftar_menu_item_model;

public class daftar_menu_Adapter extends RecyclerView.Adapter<daftar_menu_Adapter.menuHolder> {
    public daftar_menu_item_model[] menulist;

    public daftar_menu_Adapter(daftar_menu_item_model[] menulist) {
        this.menulist = menulist;
    }

    @NonNull
    @Override
    public menuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View menuview = inflater.inflate(R.layout.grid_item_menu_ct, parent, false);
        return new menuHolder(menuview) ;
    }

    @Override
    public void onBindViewHolder(@NonNull menuHolder holder, int position) {
        holder.namaMenu.setText(menulist[position].getMenuName());
        holder.namaVendor.setText(menulist[position].getVendorName());
        holder.hargaMenu.setText("Rp "+menulist[position].getMenuPrice());
        holder.menuPoster.setImageResource(menulist[position].getPoster());

    }

    @Override
    public int getItemCount() {

        return menulist.length;
    }

    public static class menuHolder extends RecyclerView.ViewHolder {
        private ImageView menuPoster;
        private TextView hargaMenu;
        private TextView namaVendor;
        private TextView namaMenu;



        public menuHolder(@NonNull View itemView) {
            super(itemView);
            menuPoster = itemView.findViewById(R.id.clmenu_poster);
            hargaMenu = itemView.findViewById(R.id.text_hargamenu);
            namaVendor = itemView.findViewById(R.id.text_namavendor);
            namaMenu = itemView.findViewById(R.id.text_namamenu);


        }
    }
}
