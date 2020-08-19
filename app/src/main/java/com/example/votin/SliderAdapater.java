package com.example.votin;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapater extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapater (Context context) {

        this.context = context;
    }

    // Arrays
    public int [] slideImages = {R.drawable.welcome_background, R.drawable.library_background, R.drawable.online_storage_background};
    public String [] textTopHeading = {"How it Works", "How it Works", ""};
    public String [] textHeading = {"Welcome", "Library", "Online Storage"};
    public String [] textLabel = {"Make it easier to connect you\nand your colleagues and not only\nthat, new friends of in common.",
                                    "Have easy access to textbooks\nand also resources that can\nbe useful to you.",
                                    "Get to have store to keep some\nof your resources so as to\nnot loose them."};


    @Override
    public int getCount() {
        return textHeading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_welcome, container, false);

        ImageView imageBg = (ImageView) view.findViewById(R.id.imageBackground);
        TextView topHeading = (TextView) view.findViewById(R.id.textHowItWorks);
        TextView heading = (TextView) view.findViewById(R.id.welcomeText);
        TextView label = (TextView) view.findViewById(R.id.welcomeLabel);

        imageBg.setImageResource(slideImages[position]);
        topHeading.setText(textTopHeading[position]);
        heading.setText(textHeading[position]);
        label.setText(textLabel[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
    }
}
