package banco.devicelab.com.br.banco.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import banco.devicelab.com.br.banco.fragment.SaldoFragment;
import banco.devicelab.com.br.banco.fragment.ExtratoFragment;
import banco.devicelab.com.br.banco.fragment.TabFragment3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SaldoFragment tab1 = new SaldoFragment();
                return tab1;
            case 1:
                ExtratoFragment tab2 = new ExtratoFragment();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}