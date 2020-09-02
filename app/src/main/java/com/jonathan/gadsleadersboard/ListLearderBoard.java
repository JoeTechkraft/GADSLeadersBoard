package com.jonathan.gadsleadersboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.nabase1.gadsleaderboard.adapters.PageAdapter;

public class ListLearderBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_learder_board);

        androidx.appcompat.widget.Toolbar toolbar1 = findViewById(R.id.mtoolbar);
        setSupportActionBar(toolbar1);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabItem learner_item = findViewById(R.id.tab_learning_learders);
        TabItem iq_item = findViewById(R.id.tab_skill_iq);
        ViewPager2 viewPager = findViewById(R.id.view_pager);



        PageAdapter pageAdapter = new PageAdapter(this);
        viewPager.setAdapter(pageAdapter);

//        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//
//
//
//            }
//        });

       // tabLayoutMediator.attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }

    public void initialize(RecyclerView recyclerView){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.item_submit){
//            startActivity(new Intent(this, SubmitProject.class));
//        }

        return super.onOptionsItemSelected(item);
    }

    public void submitForm(View view){
        startActivity(new Intent(this, SubmitProject.class));
    }
}