package id.kharisma.studio.catelink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class daftar_menu_Adapter extends RecyclerView.Adapter<daftar_menu_Adapter.ViewHolder> {

    ArrayList<daftar_menu_item_model> dataItem;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textNamamenu;
        TextView textNamavendor;
        TextView textAlamatvendor;
        TextView textHargamenu;
        TextView textRatingvalue;
        ImageView posterMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNamamenu = itemView.findViewById(R.id.text_namamenu);
            textNamavendor = itemView.findViewById(R.id.text_namavendor);
            textAlamatvendor = itemView.findViewById(R.id.text_alamatvendor);
            textHargamenu = itemView.findViewById(R.id.text_hargamenu);
            textRatingvalue = itemView.findViewById(R.id.rating_value);
            posterMenu = itemView.findViewById(R.id.clmenu_poster);

        }
    }

    daftar_menu_Adapter(ArrayList<daftar_menu_item_model> data) {
        this.dataItem = data;

    }

    @NonNull
    @Override
    public daftar_menu_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_menu_ct, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull daftar_menu_Adapter.ViewHolder holder, int position) {

        TextView text_namamenu = holder.textNamamenu;
        TextView text_namavendor = holder.textNamavendor;
        TextView text_alamatvendor = holder.textAlamatvendor;
        TextView text_hargamenu = holder.textHargamenu;
        TextView rating_value = holder.textRatingvalue;
        ImageView clmenu_poster = holder.posterMenu;

        text_namamenu.setText(dataItem.get(position).getMenuName());
        text_namavendor.setText(dataItem.get(position).getVendorName());
        text_alamatvendor.setText(dataItem.get(position).getVendorAddress());
        text_hargamenu.setText(dataItem.get(position).getMenuPrice());
        rating_value.setText(dataItem.get(position).getRateValue());
        clmenu_poster.setImageResource(dataItem.get(position).getPoster());


    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }


}
