package com.example.entmobile.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.entmobile.R;
import com.example.entmobile.mails.MailViewerActivity;
import com.example.entmobile.notes.NotesActivity;
import com.example.entmobile.results.ResultsActivity;
import com.example.entmobile.schedule.Schedule;

public class TutoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private PrefManager prefManager;

    Boolean launchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);


        Intent intent = getIntent();
        String nameOfActivity = intent.getStringExtra("Name");
        launchActivity = intent.getBooleanExtra("Launch", false);

        /**
         * Regarde les SharedPreferences et lance le tuto s'il n'a jamais été lancé. Sinon va sur l'activité des Notes
         */
        if (!prefManager.isNotesFirstTimeLaunch() && nameOfActivity.equals("Notes")) {
            launchNotesActivityOrNot();
            finish();
        }
        if (prefManager.isNotesFirstTimeLaunch() && nameOfActivity.equals("Notes")) {

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_tuto);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.tuto_note_slide1,
                    R.layout.tuto_note_slide2,
                    R.layout.tuto_note_slide3,
                    R.layout.tuto_note_slide4};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchNotesActivityOrNot();
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        launchNotesActivityOrNot();
                    }
                }
            });

        }

        /**
         * Regarde les SharedPreferences et lance le tuto s'il n'a jamais été lancé. Sinon va sur l'activité de l'Emploi du temps
         */
        if (!prefManager.isScheduleFirstTimeLaunch() && nameOfActivity.equals("Schedule")) {
            launchScheduleActivityOrNot();
            finish();
        }
        if (prefManager.isScheduleFirstTimeLaunch() && nameOfActivity.equals("Schedule")) {

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_tuto);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.tuto_schedule_slide1,
                    R.layout.tuto_schedule_slide2};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchScheduleActivityOrNot();
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        launchScheduleActivityOrNot();
                    }
                }
            });

        }


        /**
         * Regarde les SharedPreferences et lance le tuto s'il n'a jamais été lancé. Sinon va sur l'activité des Mails
         */
        if (!prefManager.isMailsFirstTimeLaunch() && nameOfActivity.equals("Mails")) {
            launchMailsActivityOrNot();
            finish();
        }
        if (prefManager.isMailsFirstTimeLaunch() && nameOfActivity.equals("Mails")) {

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_tuto);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.tuto_mails_slide1,
                    R.layout.tuto_mails_slide2};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchMailsActivityOrNot();
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        launchMailsActivityOrNot();
                    }
                }
            });

        }


        /**
         * Regarde les SharedPreferences et lance le tuto s'il n'a jamais été lancé. Sinon va sur l'activité des Resultats
         */
        if (!prefManager.isResultsFirstTimeLaunch() && nameOfActivity.equals("Results")) {
            launchResultsActivityOrNot();
            finish();
        }
        if (prefManager.isResultsFirstTimeLaunch() && nameOfActivity.equals("Results")) {

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_tuto);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.tuto_result_slide1,
                    R.layout.tuto_result_slide2,
                    R.layout.tuto_result_slide3};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchResultsActivityOrNot();
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        launchResultsActivityOrNot();
                    }
                }
            });

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        //supprime la barre de notification
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    /**
     * Lance l'activité qui lui correspond s'il en est autorisé
     */
    public void launchResultsActivityOrNot() {
        prefManager.setResultsFirstTimeLaunch(false);
        if (launchActivity) startActivity(new Intent(TutoActivity.this, ResultsActivity.class));
        finish();
    }

    public void launchScheduleActivityOrNot() {
        prefManager.setScheduleFirstTimeLaunch(false);
        if (launchActivity) startActivity(new Intent(TutoActivity.this, Schedule.class));
        finish();
    }

    public void launchMailsActivityOrNot() {
        prefManager.setMailsFirstTimeLaunch(false);
        if (launchActivity) startActivity(new Intent(TutoActivity.this, MailViewerActivity.class));
        finish();
    }

    public void launchNotesActivityOrNot() {
        prefManager.setNotesFirstTimeLaunch(false);
        if (launchActivity) startActivity(new Intent(TutoActivity.this, NotesActivity.class));
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}