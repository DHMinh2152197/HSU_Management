package com.example.minhd.hsumanagement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder> {

    ArrayList<DataFunction> dataFunctions;
    Context context;

    public FunctionAdapter(ArrayList<DataFunction> dataFunctions, Context context) {
        this.dataFunctions = dataFunctions;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View itemView=layoutInflater.inflate(R.layout.item_function,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtFunctionName.setText(dataFunctions.get(position).getMfunctionName());
        holder.imgFunctionImage.setImageResource(dataFunctions.get(position).getMfunctionImage());
    }

    @Override
    public int getItemCount() {
        return dataFunctions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtFunctionName;
        ImageView imgFunctionImage;

        public ViewHolder(final View itemView) {
            super(itemView);

            txtFunctionName=(TextView)itemView.findViewById(R.id.txt_functionName);
            imgFunctionImage=(ImageView)itemView.findViewById(R.id.img_functionImage);
        }
    }
}
