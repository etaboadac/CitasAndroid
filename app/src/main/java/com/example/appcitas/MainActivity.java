package com.example.appcitas;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ProfileFragment.OnFragmentInteractionListener,
        PaymentFragment.OnFragmentInteractionListener,
        InterestsFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager frm = getSupportFragmentManager();

        if (id == R.id.nav_home) {
            // Handle the camera action
            frm.beginTransaction().replace(R.id.contenedor, new ProfileFragment()).commit();
            getSupportActionBar().setTitle("Cambiar foto de perfil");
        } else if (id == R.id.nav_gallery) {
            frm.beginTransaction().replace(R.id.contenedor, new InterestsFragment()).commit();
            getSupportActionBar().setTitle("Elegir intereses");
        } else if (id == R.id.nav_slideshow) {
            frm.beginTransaction().replace(R.id.contenedor, new SearchFragment()).commit();
            getSupportActionBar().setTitle("Buscar personas");
        } else if (id == R.id.nav_tools) {
            frm.beginTransaction().replace(R.id.contenedor, new PaymentFragment()).commit();
            getSupportActionBar().setTitle("Membresia");
        } else if (id == R.id.nav_share) {
            //frm.beginTransaction().replace(R.id.contenedor, new PaymentFragment()).commit();
            getSupportActionBar().setTitle("Compartir");
        } else if (id == R.id.nav_send) {
            //frm.beginTransaction().replace(R.id.contenedor, new Fragmento6()).commit();
            getSupportActionBar().setTitle("Iniciar una conversacion");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
