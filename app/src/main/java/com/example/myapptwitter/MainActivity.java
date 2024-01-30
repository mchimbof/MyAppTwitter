package com.example.myapptwitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements  NavigationView.OnNavigationItemSelectedListener{
DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout_twitter);

        //Activatio Home
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }

    //Evento para los iconos
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        int itemId = item.getItemId();
        if (itemId == R.id.Perfil) {
            fragment = new FragmentPerfil();
            fragmentTransaction = true;
        } else if (itemId == R.id.Listas) {
            fragment = new FragmentLista();
            fragmentTransaction = true;
        } else if (itemId == R.id.Temas) {
            fragment = new FragmentTemas();
            fragmentTransaction = true;
        } else if (itemId == R.id.Elementos){
            fragment = new FragmentElementos();
            fragmentTransaction = true;
        } else if (itemId == R.id.Momentos){
            fragment = new FragmentMomentos();
            fragmentTransaction = true;
        } else if (itemId == R.id.Ads){
            fragment = new FragmentAds();
            fragmentTransaction = true;
        } else if (itemId == R.id.Privacidad){
            fragment = new FragmentConfiguracion();
            fragmentTransaction = true;
        } else if (itemId == R.id.Ayuda){
            fragment = new FragmentAyuda();
            fragmentTransaction = true;
        } else if (itemId == R.id.QR) {
            fragment = new FragmentQr();
            fragmentTransaction = true;
        } else if (itemId == R.id.Bombillo) {
            fragment = new FragmentBombillo();
            fragmentTransaction = true;
        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}