package com.example.minhd.hsumanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationActivity extends AppCompatActivity {

    ListView lstNotification;
    NotificationAdapter notificationAdapter;
    ArrayList<DataNotification> dataNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        lstNotification = (ListView) findViewById(R.id.lst_notification);
        dataNotifications = new ArrayList<>();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readData().execute("https://vnexpress.net/rss/so-hoa.rss");
            }
        });

        lstNotification.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NotificationActivity.this,WebActivity.class);
                intent.putExtra("link",dataNotifications.get(position).mLink);
                startActivity(intent);
            }
        });

    }

    class readData extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return readContentFromURL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListImage = document.getElementsByTagName("description");

            String image = "";
            String title = "";
            String link = "";
            String date = "";

            for (int i = 0; i < nodeList.getLength(); i++) {

                String cData = nodeListImage.item(i+1).getTextContent(); // i+1 boi vi trong rss co 1 the description dau tien khong dung toi

                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cData);

                if (matcher.find()) {
                    image = matcher.group(1);
                }
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                date = parser.getValue(element, "pubDate");

                dataNotifications.add(new DataNotification(title, link, image, date));
                notificationAdapter = new NotificationAdapter(NotificationActivity.this, android.R.layout.simple_list_item_1, dataNotifications);
                lstNotification.setAdapter(notificationAdapter);
            }
            super.onPostExecute(s);
        }
    }

    private String readContentFromURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
