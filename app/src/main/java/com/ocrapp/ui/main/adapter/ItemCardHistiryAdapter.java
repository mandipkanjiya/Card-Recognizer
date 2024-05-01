package com.ocrapp.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import com.ocrapp.R;
import com.ocrapp.databinding.ItemCardHistoryAdapterBinding;
import com.ocrapp.ui.main.model.CardHistoryModel;

public class ItemCardHistiryAdapter extends RecyclerView.Adapter<ItemCardHistiryAdapter.ViewHolder> {
    Context context; //declare variable of context/Required activity
    int selectedPosition = 0; //declare variable for position
    List<CardHistoryModel> bandListModels = new ArrayList<>(); //declare variable of Response/model class
    OnLoadMoreListener loadMoreListener;  //declare variable of interface loadMoreListener
    OnItemClickListener onItemClickListener; //declare variable of interface onItemClickListener

    //Create Item click interface
    public interface OnItemClickListener {
        void onItemClick(CardHistoryModel band, int pos);
    }

    //Create method of onItemClick interface
    public void setOnItemCLickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //Create Load more listener interface
    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    //Constructor of adapter class
    public ItemCardHistiryAdapter(Context context, List<CardHistoryModel> bandListModels) {
        this.context = context;
        this.bandListModels = bandListModels;
    }

    //Create method of onLoadMoreListener interface
    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }


    //method of clear data from adapter
    public void clearData() {
        //this.busRoutes.clear();
        notifyDataSetChanged();
    }

    public void setColor(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    //Method of bind layout file
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Bind layout/xml file
        ItemCardHistoryAdapterBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_card_history_adapter, parent, false);
        return new ViewHolder(binding);
    }

    //Method of bind data to view holders of layout file
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //check position and checked unchecked checkBox
        holder.binding.tvName.setText(bandListModels.get(position).getName());
        holder.binding.tvEffectiveDate.setText(bandListModels.get(position).getEffectiveDate());
        holder.binding.tvExpiryDate.setText(bandListModels.get(position).getExpiryDate());
        holder.binding.tvLicenseNumber.setText(bandListModels.get(position).getLicenceNumber());
        /*holder.binding.tvQuesNo.setText(bandListModels.get(position).getBandScore());

        holder.binding.linMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                onItemClickListener.onItemClick(bandListModels.get(position), position);
                notifyDataSetChanged();

            }
        });*/

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return bandListModels.size();
    }  //return data

    //ViewHolder class of  Adapter
    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCardHistoryAdapterBinding binding;

        //Constructor of ViewHolder Class
        public ViewHolder(@NonNull ItemCardHistoryAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

