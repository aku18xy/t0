package com.a9be.annuar.mylibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Rows.Row> rows;
    private float deviceWidth;
    private Context context;

    public ItemAdapter(Context context, List<Rows.Row> rows, float deviceWidth) {
        this.context = context;
        this.rows = rows;
        this.deviceWidth = deviceWidth;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        List<String> row = rows.get(i).getInRow();
        String a = row.get(0);
        View v;
        switch (a) {
            case "0":
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kosong,viewGroup,false);
                break;
            case "1":
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);
                break;
            default:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kosong,viewGroup,false);
        }

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        List<String> row = rows.get(i).getInRow();
        String a,b,w1,p1,label,w2,p2,value;
        a = row.get(0);
        b = row.get(1);
        w1 = row.get(2);
        p1 = row.get(3);
        label = row.get(4);


        switch (a) {
            case "0":
                RelativeLayout.LayoutParams paramsKosong = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                switch (p1) {
                    case "0":
                        paramsKosong.addRule(RelativeLayout.ALIGN_PARENT_START);
                        break;
                    case "1":
                        paramsKosong.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        break;
                    case "2":
                        paramsKosong.addRule(RelativeLayout.ALIGN_PARENT_END);
                        break;
                }
                holder.tvKosong.setLayoutParams(paramsKosong);
                holder.tvKosong.setText(label);
                break;
            case "1":

                p2 = row.get(5);
                value = row.get(6);

                switch (b) {
                    case "0":

                        break;
                    case "1":

                        float width1 = Float.parseFloat(w1);

                        if (width1<=1) {
                            width1 = deviceWidth * width1;
                            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams((int) width1, ViewGroup.LayoutParams.WRAP_CONTENT);
                            holder.tvRow.setLayoutParams(params1);
                        }else {
                            MyUtil myUtil = new MyUtil();
                            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams((int) myUtil.convertDpToPixel(width1), ViewGroup.LayoutParams.WRAP_CONTENT);
                            holder.tvRow.setLayoutParams(params1);
                        }

                        switch (p1) {
                            case "0":
                                holder.tvRow.setGravity(Gravity.START);
                                break;
                            case "1":
                                holder.tvRow.setGravity(Gravity.CENTER);
                                break;
                            case "2":
                                holder.tvRow.setGravity(Gravity.END);
                                break;
                        }

                        switch (p2) {
                            case "0":
                                holder.etRow.setGravity(Gravity.START);
                                break;
                            case "1":
                                holder.etRow.setGravity(Gravity.CENTER);
                                break;
                            case "2":
                                holder.etRow.setGravity(Gravity.END);
                                break;
                        }

                        holder.tvRow.setText(label);
                        holder.etRow.setText(value);


                        break;
                }

                break;
        }

    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvRow, tvKosong;
        EditText etRow;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRow = itemView.findViewById(R.id.tvRow);
            etRow = itemView.findViewById(R.id.etRow);
            tvKosong = itemView.findViewById(R.id.tvKosong);
        }
    }
}
