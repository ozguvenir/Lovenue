package com.ridvan.lovenue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.listener.RecyclerViewClickListener;
import com.ridvan.lovenue.models.model.Items;

import java.util.List;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueRecyclerViewAdapter extends RecyclerView.Adapter<VenueRecyclerViewAdapter.VenueViewHolder> {
    private List<Items> itemsList;
    private RecyclerViewClickListener listener;

    public VenueRecyclerViewAdapter(List<Items> itemsList, RecyclerViewClickListener listener) {
        this.itemsList = itemsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View venueView = inflater.inflate(R.layout.view_venue_item, parent, false);
        final VenueViewHolder viewHolder = new VenueViewHolder(venueView);
        venueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VenueViewHolder holder, int position) {
        Items venue = itemsList.get(position);

        TextView companyName = holder.companyName;
        TextView category = holder.category;
        TextView distance = holder.distance;
        TextView summary = holder.summary;
        //TODO
        companyName.setText(venue.getVenue().getName());
        category.setText(venue.getVenue().getCategories().get(0).getPluralName());
        distance.setText("20m");
        summary.setText("sumsumsum");
    }

    @Override
    public int getItemCount() {
        return itemsList != null ? itemsList.size() : 0;
    }

    public class VenueViewHolder extends RecyclerView.ViewHolder {
        TextView companyName;
        TextView category;
        TextView distance;
        TextView summary;

        public VenueViewHolder(View view) {
            super(view);
        }
    }
}
