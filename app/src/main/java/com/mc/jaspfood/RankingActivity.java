package com.mc.jaspfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    ListView listView ;
    private ArrayList < Food > al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        al = new ArrayList< >();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("food");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List< ParseObject > objects, ParseException e) {
                if (e == null) {
                    for (ParseObject product : objects) {
                        al.add(new Food((String) product.get("imagePath"), (String) product.get("description"),(String) product.get("votes")));
                    }
                } else {
                    Log.d("ERROR", "Failed to retrieve Parse objects");
                }
            }
        });
        CustomListAdapter adapter = new CustomListAdapter(this, al);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ranking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
