package com.example.starwarsapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starwarsapp.R;
import com.example.starwarsapp.model.Planets;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.CelluleJava> {

    private List<Planets> planetsList;
    private final OnItemClickListener listener;
    private Context context;


    public interface OnItemClickListener {
        void onItemClick(Planets planets);
    }

    public class CelluleJava extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imgIcon;

        public CelluleJava(View view) {
            super(view);
            name = view.findViewById(R.id.tile_title);
            imgIcon = view.findViewById(R.id.tile_picture);
        }
    }

    public PlanetsAdapter(List<Planets> listValues, OnItemClickListener listener, Context context) {
        this.planetsList = listValues;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fragment_main_item, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        final Planets planets = planetsList.get(position);
        final String name = planetsList.get(position).getName();
        final String picture = planetsList.get(position).getPicture();

        holder.name.setText(name);

        /*
        Picasso.with(context)
                .load(picture)
                .error(R.drawable.error_icon)
                .into(holder.imgIcon);
        */

        Glide.with(context)
                .load(picture)
                .error(R.drawable.error_icon)
                .fitCenter()
                .into(holder.imgIcon);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(planets);
            }
        });

    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }
}