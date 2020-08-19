package com.example.votin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AddFriend extends AppCompatActivity{

    private ViewPager view_Pager;
    private TabLayout tab_Layout;

    private MyFriends myFriends;
    private PeopleYouMayKnow peopleYouMayKnow;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        view_Pager = findViewById(R.id.pager);
        tab_Layout = findViewById(R.id.tabLayout);
        back = findViewById(R.id.backButton);

        // Back Option
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intChat = new Intent(AddFriend.this, Home.class);
                startActivity(intChat);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        myFriends = new MyFriends();
        peopleYouMayKnow = new PeopleYouMayKnow();

        tab_Layout.setupWithViewPager(view_Pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(myFriends, "My Friends");
        viewPagerAdapter.addFragment(peopleYouMayKnow, "People you may know");
        view_Pager.setAdapter(viewPagerAdapter);

        tab_Layout.getTabAt(0).setIcon(R.drawable.myfriend);
        tab_Layout.getTabAt(1).setIcon(R.drawable.people);
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
