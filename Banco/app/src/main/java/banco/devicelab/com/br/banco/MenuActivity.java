package banco.devicelab.com.br.banco;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import banco.devicelab.com.br.banco.fragment.CartoesFragment;
import banco.devicelab.com.br.banco.fragment.ContaFragment;
import banco.devicelab.com.br.banco.fragment.PagamentosFragment;
import banco.devicelab.com.br.banco.fragment.TransferenciaFragment;


public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private TextView username;
    private NavigationView navigationView;
    private TextView email;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initNavigationDrawer();
        initNavigationDrawerHeader();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        createFragment("Conta", new ContaFragment(this));

        Button exit = (Button) findViewById(R.id.saida);
        if (exit != null) {
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuActivity.this.finish();
                }
            });
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void initNavigationDrawer()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (navigationView != null)
        {
            navigationView.setNavigationItemSelectedListener(this);
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);

    }

    private void initNavigationDrawerHeader()
    {
        View header = navigationView.getHeaderView(0);
        username = (TextView) header.findViewById(R.id.username);
        email = (TextView) header.findViewById(R.id.email);

        setupUserInformations();
    }

    private void setupUserInformations()
    {
        username.setText("usuario");
        email.setText("email");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        item.setChecked(true);
        drawerLayout.closeDrawers();
        selectDrawerItem(item);

        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    public void selectDrawerItem(MenuItem menuItem)
    {
        Fragment fragment = null;

        switch (menuItem.getItemId())
        {
            case R.id.menu_cartoes:
                fragment = new CartoesFragment();
                break;

            case R.id.menu_conta:
                fragment = new ContaFragment(this);
                break;
            case R.id.menu_pagamento:
                fragment = new PagamentosFragment();
                break;
            case R.id.menu_transferencia:
                fragment = new TransferenciaFragment();
                break;

            default:
                break;
        }

        createFragment(menuItem.getTitle(), fragment);
    }

    private void createFragment(CharSequence title, Fragment fragment) {
        if(fragment != null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.drawer_content, fragment).commit();
            setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}