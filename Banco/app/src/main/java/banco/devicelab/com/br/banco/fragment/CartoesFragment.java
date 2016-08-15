package banco.devicelab.com.br.banco.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import banco.devicelab.com.br.banco.R;

public class CartoesFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cartoes, container, false);

//        setupToolbar(view);
        return view;
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
}