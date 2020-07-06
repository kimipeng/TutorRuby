package com.kimi.rubytutor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kimi.Peng on 2020/7/6.
 */
public class BonusAdapter extends RecyclerView.Adapter<BonusAdapter.ItemViewHolder> {


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bouns, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(position);
    }


    // RecyclerView 數量
    @Override
    public int getItemCount() {
        return 6;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvDescription;

         public ItemViewHolder(@NonNull View itemView) {
             super(itemView);
             tvName = itemView.findViewById(R.id.tv_name);
             tvDescription = itemView.findViewById(R.id.tv_description);
         }

        void bindData(int position) {
             tvName.setText("黑晶條件: "+ position);
             tvDescription.setText("556885568855688556885568855688");
        }


     }
}
