package com.kimi.rubytutor;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.BoolRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Kimi.Peng on 2020/7/6.
 */
public class BonusAdapter extends RecyclerView.Adapter<BonusAdapter.BaseViewHolder> {

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
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case 0:
                ((ItemViewHolder)holder).bindData(bonusArrayList.get(position));
                break;
            case 1:
                ((ManagerViewHolder)holder).bindManager();
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


    class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    class ItemViewHolder extends BaseViewHolder{

        TextView tvName, tvDescription;

         public ItemViewHolder(@NonNull View itemView) {
             super(itemView);
             tvName = itemView.findViewById(R.id.tv_name);
             tvDescription = itemView.findViewById(R.id.tv_description);
         }

        void bindData(final Bonus bonus) {
             tvName.setText(bonus.getName());
             tvDescription.setText(bonus.getDescription());

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


    class ManagerViewHolder extends BaseViewHolder {

        TextView tvName, tvDescription;

        public ManagerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }


        void bindManager() {
            tvName.setText("Manager");
        }

    }
}

interface BonusItemClick {
    void onClick(Bonus bonus);
}
