package banco.devicelab.com.br.banco;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

import banco.devicelab.com.br.banco.R;
import banco.devicelab.com.br.banco.dao.CorrentistaDAO;
import banco.devicelab.com.br.banco.fragment.CartoesFragment;
import banco.devicelab.com.br.banco.fragment.ContaFragment;
import banco.devicelab.com.br.banco.fragment.PagamentosFragment;
import banco.devicelab.com.br.banco.fragment.TransferenciaFragment;
import banco.devicelab.com.br.banco.modelo.Correntista;


public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private TextView username;
    private NavigationView navigationView;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



//        initNavigationDrawer();
//        initNavigationDrawerHeader();
//        initDrawerListener(savedInstanceState);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initNavigationDrawer();
        initNavigationDrawerHeader();

//        createTabs();
    }



//    private void createTabs() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        if (tabLayout != null) {
//            tabLayout.addTab(tabLayout.newTab().setText("Inicio"));
//            tabLayout.addTab(tabLayout.newTab().setText("Extrato"));
//            tabLayout.addTab(tabLayout.newTab().setText("Cartões"));
//
//            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        }
//
//        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        final PagerAdapter adapter;
//        if (tabLayout != null) {
//            adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
//            if (viewPager != null) {
//                viewPager.setAdapter(adapter);
//                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                    @Override
//                    public void onTabSelected(TabLayout.Tab tab) {
//                        viewPager.setCurrentItem(tab.getPosition());
//                    }
//
//                    @Override
//                    public void onTabUnselected(TabLayout.Tab tab) {
//
//                    }
//
//                    @Override
//                    public void onTabReselected(TabLayout.Tab tab) {
//
//                    }
//                });
//            }
//        }
//    }


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

        if(fragment != null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.drawer_content, fragment).commit();

            setTitle(menuItem.getTitle());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_menu:


                break;
        }

        return super.onOptionsItemSelected(item);
    }

}