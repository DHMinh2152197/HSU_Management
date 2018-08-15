package com.example.minhd.hsumanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NotificationAdapter extends ArrayAdapter<DataNotification> {

    public NotificationAdapter(Context context, int resource, List<DataNotification> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.item_notification, null);
        }
        DataNotification p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txtNotificationTitle = (TextView) view.findViewById(R.id.txt_notificationTitle);
            ImageView imgNotificationImage=(ImageView)view.findViewById(R.id.img_notificationImage);

            txtNotificationTitle.setText(p.mTitle);
            Picasso.with(getContext()).load(p.mImage).into(imgNotificationImage);

        }
        return view;
    }

}