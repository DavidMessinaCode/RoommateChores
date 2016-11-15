package com.example.david.chores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    //public final static String EXTRA_MESSAGE = "com.example.chores.MESSAGE";
    Toolbar toolbar_menu;
    Toolbar tab1;
    Toolbar tab2;
    Toolbar tab3;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getSupportActionBar().setDisplayShowTitleEnabled(true);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        //toolbar_menu = (Toolbar) findViewById(R.id.toolbar_menu);
        //tab1 = (Toolbar) findViewById(R.id.chore);
        //tab2 = (Toolbar) findViewById(R.id.reciept);
        //tab3 = (Toolbar) findViewById(R.id.other);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void moveTab(View view) {
        //TODO: Make touching the home redirect to some sort of page with account details
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data


        listDataHeader.add("David");
        listDataHeader.add("Devaraj");
        listDataHeader.add("Litian");
        listDataHeader.add("Kate");
        listDataHeader.add("Caiwei");
        listDataHeader.add("All");

        // Adding child data
        List<String> all = new ArrayList<String>();

        List<String> david = new ArrayList<String>();
        david.add("Dishes");
        david.add("Wash the countertops");
        all.add("Dishes");
        all.add("Wash the countertops");

        List<String> dev = new ArrayList<String>();
        dev.add("Vacuuum");
        all.add("Vacuuum");

        List<String> lit = new ArrayList<String>();
        lit.add("Take out the trash");
        lit.add("Take out the recycling");
        all.add("Take out the trash");
        all.add("Take out the recycling");

        List<String> kate = new ArrayList<String>();
        kate.add("Walk the dog");
        all.add("Walk the dog");

        List<String> cai = new ArrayList<String>();
        cai.add("Clean the bathroom");
        all.add("Clean the bathroom");


        listDataChild.put(listDataHeader.get(0), david); // Header, Child data
        listDataChild.put(listDataHeader.get(1), dev);
        listDataChild.put(listDataHeader.get(2), lit);
        listDataChild.put(listDataHeader.get(3), kate);
        listDataChild.put(listDataHeader.get(4), cai);
        listDataChild.put(listDataHeader.get(5), all);



    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
