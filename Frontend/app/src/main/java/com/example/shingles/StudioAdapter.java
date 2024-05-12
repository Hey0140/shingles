package com.example.shingles;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<StudioData> itemList = new ArrayList<>();

    StudioAdapter(ArrayList<StudioData> list) {
        this.itemList = list;
    }

    private StudioAdapter.OnListItemSelected mListener;
    private StudioAdapter.OnListHeartSelected heartListener;

    public interface OnListItemSelected {
        void onItemSelected(View v, int position);
    }
    public interface OnListHeartSelected {
        void onHeartSelected(View v, int position);
    }


    public void setOnItemClickListener(StudioAdapter.OnListItemSelected listener) {
        this.mListener = listener;
    }
    public void setOnHeartClickListener(StudioAdapter.OnListHeartSelected listener) {
        this.heartListener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.studio_item_layout, parent, false);
        return new StudioAdapter.StduioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudioData item = itemList.get(position);

        if(item.isHeart()){
            ((StduioViewHolder) holder).heart.setBackgroundResource(R.drawable.filled_heart_icon);
        }
        else{
            ((StduioViewHolder) holder).heart.setBackgroundResource(R.drawable.empty_heart_icon);
        }
        ((StduioViewHolder) holder).onediscount.setText(item.getOne_discount());
        ((StduioViewHolder) holder).twodiscount.setText(item.getTwo_discount());
        ((StduioViewHolder) holder).oneaccount.setText(item.getOne_account());
        ((StduioViewHolder) holder).twoaccount.setText(item.getTwo_account());
        ((StduioViewHolder) holder).oneorigin.setText(item.getOne_origin());
        ((StduioViewHolder) holder).twoorigin.setText(item.getTwo_origin());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class StduioViewHolder extends RecyclerView.ViewHolder {
        TextView onediscount, twodiscount;
        TextView oneaccount, twoaccount;
        TextView oneorigin, twoorigin;
        ImageView heart;

        public StduioViewHolder(View itemView) {
            super(itemView);

            onediscount = itemView.findViewById(R.id.studio_item_discount);
            twodiscount = itemView.findViewById(R.id.studio_item_discount2);
            oneaccount = itemView.findViewById(R.id.studio_item_account);
            twoaccount = itemView.findViewById(R.id.studio_item_account2);
            oneorigin = itemView.findViewById(R.id.studio_item_origin);
            twoorigin = itemView.findViewById(R.id.studio_item_origin2);
            heart = itemView.findViewById(R.id.studio_heart_icon);

            oneorigin.setPaintFlags(oneorigin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            twoorigin.setPaintFlags(twoorigin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


            heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (heartListener != null) {
                            heartListener.onHeartSelected(view, position);
                        }
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemSelected(view, position);
                        }
                    }
                }
            });
        }
    }
}
