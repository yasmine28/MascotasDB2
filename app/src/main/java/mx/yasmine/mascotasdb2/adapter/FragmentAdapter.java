package mx.yasmine.mascotasdb2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Yasmine on 08/11/2016.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {

        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}


