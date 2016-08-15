package banco.devicelab.com.br.banco.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import banco.devicelab.com.br.banco.MenuActivity;
import banco.devicelab.com.br.banco.R;
import banco.devicelab.com.br.banco.adapter.PagerAdapter;

public class ContaFragment extends Fragment { private MenuActivity menuActivity;

    public ContaFragment(MenuActivity menuActivity)
    {
        this.menuActivity = menuActivity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conta, container, false);

//        setupToolbar(view);
//
//            private void createTabs() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout2);
        if (tabLayout != null) {
            tabLayout.addTab(tabLayout.newTab().setText("Saldo"));
            tabLayout.addTab(tabLayout.newTab().setText("Extrato"));
//            tabLayout.addTab(tabLayout.newTab().setText("Cartões"));

            tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        }

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        final PagerAdapter adapter;
        if (tabLayout != null) {

            adapter = new PagerAdapter(menuActivity.getSupportFragmentManager(), tabLayout.getTabCount());
            if (viewPager != null) {
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        }
        return view;
    }
}

//    private void setupToolbar(View view)
//    {
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setSupportActionBar(toolbar);
//
//        final ActionBar bar = activity.getSupportActionBar();
//        if (bar != null)
//        {
//            bar.setDisplayHomeAsUpEnabled(true);
//            bar.setShowHideAnimationEnabled(true);
//            bar.setHomeAsUpIndicator(R.mipmap.ic_menu);
//            bar.setTitle("TituloBar");
//        }
//    }
//}