package com.example.user.customtextview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView namestr,timestr,titlestr;
    ListView meeting;
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> time=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meeting=findViewById(R.id.mplan);
        title.add("Birthday Party");
        title.add("Hospital");

        name.add("Nabin's Birthday");
        name.add("Checkup for Jude");

        time.add("1:00pm to 2:00pm");
        time.add("3:00pm to 4:00pm");

        adapt adpt=new adapt();
        meeting.setAdapter(adpt);

        meeting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+title.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        }
        class adapt extends BaseAdapter {
            @Override
            public int getCount() {
                return title.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater infl=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=infl.inflate(R.layout.example,null);
                titlestr=convertView.findViewById(R.id.title);
                namestr=convertView.findViewById(R.id.name);
                timestr=convertView.findViewById(R.id.time);
                titlestr.setText(title.get(position));
                namestr.setText(name.get(position));
                timestr.setText(time.get(position));

                return convertView;
            }
        }
}
