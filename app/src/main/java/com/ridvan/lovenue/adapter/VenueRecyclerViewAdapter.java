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
        Items item = itemsList.get(position);

        TextView companyName = holder.companyName;
        TextView category = holder.category;
        TextView distance = holder.distance;

        if (item != null && item.getVenue() != null) {
            String companyValue = item.getVenue().getName() != null ? item.getVenue().getName() : "Unknown Company";
            String categoryValue = (item.getVenue().getCategories() != null && item.getVenue().getCategories().get(0) != null) ? item.getVenue().getCategories().get(0).getPluralName() : "Unknown Category";
            String distanceValue = (item.getVenue().getLocation() != null && item.getVenue().getLocation().getDistance() != null) ? item.getVenue().getLocation().getDistance().toString() + " meter(s)" : "Unknown distance";

            companyName.setText(companyValue);
            category.setText(categoryValue);
            distance.setText(distanceValue);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList != null ? itemsList.size() : 0;
    }

    public class VenueViewHolder extends RecyclerView.ViewHolder {
        TextView companyName;
        TextView category;
        TextView distance;

        public VenueViewHolder(View view) {
            super(view);
            companyName = view.findViewById(R.id.nameTextViewID);
            category = view.findViewById(R.id.categoryTextViewID);
            distance = view.findViewById(R.id.distanceTextViewID);
        }
    }
}
