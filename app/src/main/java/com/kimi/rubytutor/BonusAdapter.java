package com.kimi.rubytutor;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Kimi.Peng on 2020/7/6.
 */
public class BonusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Bonus> bonusArrayList;

    private BonusItemClick itemClick;

    public void setItemClick(BonusItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public BonusAdapter(ArrayList<Bonus> bonusArrayList) {
        this.bonusArrayList = bonusArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case 1:
                 view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bouns_manager, parent, false);
                return new ManagerViewHolder(view);

            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bouns, parent, false);
                return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                ((ItemViewHolder)holder).bindData(bonusArrayList.get(position), position);
                break;
            case 1:
                ((ManagerViewHolder)holder).bindManagerData(position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return bonusArrayList.get(position).getViewType();
    }

    // RecyclerView 數量
    @Override
    public int getItemCount() {
        return bonusArrayList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvDescription;
        View lineTop, lineBottom;

         public ItemViewHolder(@NonNull View itemView) {
             super(itemView);
             tvName = itemView.findViewById(R.id.tv_name);
             tvDescription = itemView.findViewById(R.id.tv_description);
             lineTop = itemView.findViewById(R.id.line_top);
             lineBottom = itemView.findViewById(R.id.line_bottom);
         }

        void bindData(final Bonus bonus, int position) {
             tvName.setText(bonus.getName());
             tvDescription.setText(bonus.getDescription());

             // 控制Line的顯示
            lineTop.setVisibility(View.VISIBLE);
            lineBottom.setVisibility(View.VISIBLE);
            if (position == 0) {
                lineTop.setVisibility(View.INVISIBLE);
            } else if (position == bonusArrayList.size() - 1){
                lineBottom.setVisibility(View.INVISIBLE);
            }


            switch (bonus.getIconType()) {
                case Black:
                    break;
                case Purple:
                    break;
                case Red:
                    break;
                case Pink:
                    break;
                default:
                    break;
            }

           // itemClick.onClick();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("kimi", "onClick: kimi");
                    if (itemClick != null) {
                        itemClick.onClick(bonus);
                    }
                }
            });


        }

     }


    class ManagerViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;
        View lineTop, lineBottom;

        public ManagerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            lineTop = itemView.findViewById(R.id.line_top);
            lineBottom = itemView.findViewById(R.id.line_bottom);
        }


        void bindManagerData(int position) {
            tvName.setText("Manager");

            // 控制Line的顯示
            lineTop.setVisibility(View.VISIBLE);
            lineBottom.setVisibility(View.VISIBLE);
            if (position == 0) {
                lineTop.setVisibility(View.INVISIBLE);
            } else if (position == bonusArrayList.size() - 1){
                lineBottom.setVisibility(View.INVISIBLE);
            }
        }

    }
}

interface BonusItemClick {
    void onClick(Bonus bonus);
}
