package com.android.factcheck.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.factcheck.R;
import com.android.factcheck.model.FeedDataModel;
import com.android.factcheck.ui.adapter.DataListAdapter;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView mFeedListView;
    private LinearLayoutManager manager;
    private ArrayList<FeedDataModel> listOfData = new ArrayList<>();

    private DataListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mFeedListView = (RecyclerView) findViewById(R.id.feedListView);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) getSupportActionBar().setDisplayShowTitleEnabled(false);

        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);
        listOfData.add(null);

        setupDataList();

    }

    private void setupDataList() {

        manager = new LinearLayoutManager(this);
        adapter = new DataListAdapter(listOfData);
        mFeedListView.setLayoutManager(manager);
        mFeedListView.setAdapter(adapter);

    }

    public void createNewFactCheck(View view) {

    }

    public void openProfileActivity(View view) {
        startActivity(new Intent(DashboardActivity.this,ProfileActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_quit:
                finish();
                return true;
            case R.id.action_profile:
                startActivity(new Intent(DashboardActivity.this,ProfileActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
