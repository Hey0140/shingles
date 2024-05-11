package com.example.shingles;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<RoomData> itemList = new ArrayList<>();

    RoomAdapter(ArrayList<RoomData> list) {
        this.itemList = list;
    }

    private RoomAdapter.OnListItemSelected mListener;

    public interface OnListItemSelected {
        void onItemSelected(View v, int position);
    }



    public void setOnItemClickListener(RoomAdapter.OnListItemSelected listener) {
        this.mListener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.room_item_layout, parent, false);
        return new RoomAdapter.StduioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RoomData item = itemList.get(position);


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

        public StduioViewHolder(View itemView) {
            super(itemView);

            onediscount = itemView.findViewById(R.id.room_item_discount);
            twodiscount = itemView.findViewById(R.id.room_item_discount2);
            oneaccount = itemView.findViewById(R.id.room_item_account);
            twoaccount = itemView.findViewById(R.id.room_item_account2);
            oneorigin = itemView.findViewById(R.id.room_item_origin);
            twoorigin = itemView.findViewById(R.id.room_item_origin2);

            oneorigin.setPaintFlags(oneorigin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            twoorigin.setPaintFlags(twoorigin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


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
