package com.example.minhd.hsumanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder> {

    ArrayList<DataFunction> dataFunctions;
    Context context;

    public FunctionAdapter(ArrayList<DataFunction> dataFunctions, Context context) {
        this.dataFunctions = dataFunctions;
        this.context = context;
    }

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_function, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtFunctionName.setText(dataFunctions.get(position).getMfunctionName());
        holder.imgFunctionImage.setImageResource(dataFunctions.get(position).getMfunctionImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = null;
                if (isLongClick) {
                    Toast.makeText(context, " " + dataFunctions.get(position).getMfunctionName() + " id: " + dataFunctions.get(position).getMfunctionImage(), Toast.LENGTH_SHORT).show();
                } else {
                    switch (dataFunctions.get(position).getMfunctionName()) {
                        case "Thời khóa biểu": //id hình ảnh chức năng TKB
                            intent = new Intent(context, ScheduleActivity.class);
                            break;
                        case "Xem điểm": //id hình ảnh chức năng Xem điểm
                            intent = new Intent(context, ScoreActivity.class);
                            break;
                        case "Chuyên cần": //id hình ảnh chức năng Chuyên cần
                            intent = new Intent(context, AttendanceActivity.class);
                            break;
                        case "Lịch thi": //id hình ảnh chức năng Lịch thi
                            intent = new Intent(context, ExamDateActivity.class);
                            break;
                        case "Điểm danh": //id hình ảnh chức năng Điểm danh
                            intent = new Intent(context, CheckAttendanceActivity.class);
                            break;
                        case "Học phí": //id hình ảnh chức năng Học phí
                            intent = new Intent(context, TuitionActivity.class);
                            break;
                        case "Thông báo": //id hình ảnh chức năng Thông báo
                            intent = new Intent(context, NotificationActivity.class);
                            break;
                        case "Tài khoản photo": //id hình ảnh chức năng Tài khoản photo
                            intent = new Intent(context, PhotoAccountActivity.class);
                            break;
                        case "Khảo sát": //id hình ảnh chức năng Khảo sát
                            intent = new Intent(context, FeedbackActivity.class);
                            break;
                        case "Liên hệ": //id hình ảnh chức năng Liên hệ
                            intent = new Intent(context, ContactActivity.class);
                            break;
                        case "Giới thiệu": //id hình ảnh chức năng Giới thiệu
                            intent = new Intent(context, AboutUsActivity.class);
                            break;
                        case "Thoát": //id hình ảnh chức năng Thoát
                            intent = new Intent(context, MainActivity.class);
                            break;
                        default:
                            intent = new Intent(context, ControlActivity.class);
                    }
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataFunctions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView txtFunctionName;
        ImageView imgFunctionImage;
        private ItemClickListener itemClickListener;

        public ViewHolder(final View itemView) {
            super(itemView);

            //context=itemView.getContext();

            txtFunctionName = (TextView) itemView.findViewById(R.id.txt_functionName);
            imgFunctionImage = (ImageView) itemView.findViewById(R.id.img_functionImage);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
