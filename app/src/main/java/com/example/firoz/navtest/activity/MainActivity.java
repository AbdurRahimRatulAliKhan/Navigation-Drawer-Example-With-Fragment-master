package com.example.firoz.navtest.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.firoz.navtest.R;
import com.example.firoz.navtest.fragment.LogIn;
import com.example.firoz.navtest.fragment.SignUp;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // ---- create the navigation drawer ------
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    /*
      --   When back button is clicked , this method is called
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // super.onBackPressed();
            // -- do nothing here -----
        }
    }


    /*
       --- This method is used to create the menu option on the actionbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /*
        ----- This method is called, when any menu option is clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.homeBtnId) {

            // -- home button click from actionbar
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.aboutUsId) {
            // --- about us button click from actionbar
            return true;
        }

        if (id == R.id.logOutId) {
            // ---- log out button click from actionbar

            return true;
        }

        if (id == R.id.exitId) {

            // ---- exit button click from actionbar
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    /*
       ----- This method is called, when any navigation bar item is clicked
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sign_in) {

            // --- when sign in button is clicked

            // --- go sign in page
            addFragment(new LogIn());


        } else if (id == R.id.nav_sign_up) {

            // ---- when sign up button is clicked

            // -- go sign up page
            addFragment(new SignUp());

        } else if (id == R.id.nav_profile) {

            // --- when profile button is clicked

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    private void addFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        transaction.replace(R.id.fragment_place, fragment);
        transaction.commit();


        // if we want to make sure that, fragment is not null, then
        /*
        if (fragment != null) {
            transaction.replace(R.id.fragment_place, fragment);
            transaction.commit();
        }
        */

    }


}
