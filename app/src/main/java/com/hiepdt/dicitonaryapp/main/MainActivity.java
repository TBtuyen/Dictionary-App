package com.hiepdt.dicitonaryapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hiepdt.dicitonaryapp.R;
import com.hiepdt.dicitonaryapp.bookmark.BookmarkActivity;
import com.hiepdt.dicitonaryapp.history.HistoryActivity;
import com.hiepdt.dicitonaryapp.models.APP;
import com.hiepdt.dicitonaryapp.search.SearchActivity;
import com.hiepdt.dicitonaryapp.translate.TranslateActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnSearch;

    private NavigationView navigationView;
    private ImageView btnMenu;
    private DrawerLayout drawer;

    private LinearLayout btnEng, btnVie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        action();
    }

    private void init() {
        btnSearch = findViewById(R.id.btnSearch);

        btnMenu = findViewById(R.id.btnMenu);
        navigationView = findViewById(R.id.navigationView);
        drawer = findViewById(R.id.drawer);

        btnEng = findViewById(R.id.btnEng);
        btnVie = findViewById(R.id.btnVie);

    }

    private void action() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent intent;
                switch (id) {
                    case R.id.diction:
                        intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.translate:
                        intent = new Intent(MainActivity.this, TranslateActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.history:
                        intent = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.bookmark:
                        intent = new Intent(MainActivity.this, BookmarkActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        btnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEng.setBackgroundResource(R.drawable.corner_search_edittext_select);
                btnVie.setBackgroundResource(R.drawable.corner_search_edittext_unselect);
                APP.LANG_DICTION = "en";
                Toast.makeText(MainActivity.this, "Eng-Vie selected!", Toast.LENGTH_SHORT).show();
            }
        });
        btnVie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnVie.setBackgroundResource(R.drawable.corner_search_edittext_select);
                btnEng.setBackgroundResource(R.drawable.corner_search_edittext_unselect);
                APP.LANG_DICTION = "vi";
                Toast.makeText(MainActivity.this, "Vie-Eng selected!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
