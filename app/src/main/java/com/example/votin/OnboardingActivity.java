package com.example.votin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private Button skip, next, continueBtn;

    LinearLayout mDotsLayout;

    private TextView [] mDots;

    private SliderAdapater sliderAdapater;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        slideViewPager = findViewById(R.id.onboardingPager);

        skip = findViewById(R.id.skipButton);
        next = findViewById(R.id.nextButton);
        continueBtn = findViewById(R.id.continueButton);
        mDotsLayout = (LinearLayout) findViewById(R.id.mDotsLayout);

        // Swipe
        sliderAdapater = new SliderAdapater(this);

        slideViewPager.setAdapter(sliderAdapater);


        addDotsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListener);


        // On ClickListener
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slideViewPager.setCurrentItem(mCurrentPage +1);

            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intLogin = new Intent(OnboardingActivity.this, Login.class);
                startActivity(intLogin);
                overridePendingTransition(0, 0);
                finish();
            }
        });

    }



    // Swipe Indicators
    public void addDotsIndicator(int position ) {
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView (this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(45);
            mDots[i].setTextColor(getResources().getColor(R.color.colorGrey));

            mDotsLayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    // Page Changes View
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            mCurrentPage = position;

            if (position == 0) {
                next.setEnabled(true);
                continueBtn.setEnabled(false);
                continueBtn.setVisibility(View.INVISIBLE);
            }
            else if (position == mDots.length -1) {
                next.setEnabled(true);
            }

            else {
                next.setEnabled(true);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
