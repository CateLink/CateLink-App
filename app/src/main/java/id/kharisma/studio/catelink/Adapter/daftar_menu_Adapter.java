package id.kharisma.studio.catelink.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.kharisma.studio.catelink.Activity.Detailmenu_Activity;
import id.kharisma.studio.catelink.Model.CateMenu;
import id.kharisma.studio.catelink.R;

public class daftar_menu_Adapter extends RecyclerView.Adapter<daftar_menu_Adapter.menuHolder> {

    Context context;
    List<CateMenu> cateMenuList;

    public daftar_menu_Adapter(Context context, List<CateMenu> cateMenuList) {
        this.context = context;
        this.cateMenuList = cateMenuList;
    }

    @NonNull
    @Override
    public menuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_menu_ct, parent,false);

        return new menuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menuHolder holder, int position) {

        holder.menuPoster.setImageResource(cateMenuList.get(position).getPoster());
        holder.hargaMenu.setText("Rp " + cateMenuList.get(position).getMenuPrice());
        holder.namaVendor.setText(cateMenuList.get(position).getVendorName());
        holder.namaMenu.setText(cateMenuList.get(position).getMenuName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Detailmenu_Activity.class);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return cateMenuList.size();
    }

    public static final class menuHolder extends RecyclerView.ViewHolder{

        ImageView menuPoster;
        TextView hargaMenu;
        TextView namaVendor;
        TextView namaMenu;


        public menuHolder(@NonNull View itemView) {
            super(itemView);

            menuPoster = itemView.findViewById(R.id.clmenu_poster);
            hargaMenu = itemView.findViewById(R.id.text_hargamenu);
            namaVendor = itemView.findViewById(R.id.text_namavendor);
            namaMenu = itemView.findViewById(R.id.text_namamenu);

        }
    }
}
