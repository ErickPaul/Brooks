package cloudit.brooks;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import cloudit.brooks.Fragment_mainscreen.Homefragment;
import cloudit.brooks.Fragment_mainscreen.Hostfragment;
import cloudit.brooks.Fragment_mainscreen.Searchfragment;
import cloudit.brooks.Fragment_mainscreen.Settingsfragment;
import cloudit.brooks.Fragment_mainscreen.Tripsfragemnt;
import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {
   public static ViewPager pager;
    public  static  MainActivity loggedinactivity;
    public  static  PagerSlidingTabStrip tabs;
    public  static FrameLayout gallery, news, calendar, survey, more;
    public  static  LinearLayout gallerycolor,gallerygrey, newscolor, newsgrey, calendarcolor, calendargrey, surveycolor, surveygrey, morecolor, moregrey;
    public  static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Statusbar.setStatusBarColor(MainActivity.this,R.color.statusbar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loggedinactivity=this;
        fragmentManager=getSupportFragmentManager();
        pager = (ViewPager) findViewById(R.id.pager);
        gallery = (FrameLayout) findViewById(R.id.gallerylayout);
        news = (FrameLayout) findViewById(R.id.newslayout);
        calendar = (FrameLayout) findViewById(R.id.calendarlayout);
        survey = (FrameLayout) findViewById(R.id.surveylayout);
        more = (FrameLayout) findViewById(R.id.morelayout);
        gallerycolor = (LinearLayout) findViewById(R.id.gallery);
        gallerygrey = (LinearLayout) findViewById(R.id.gallery2);
        newscolor = (LinearLayout) findViewById(R.id.news);
        newsgrey = (LinearLayout) findViewById(R.id.news2);
        calendarcolor = (LinearLayout) findViewById(R.id.calendar);
        calendargrey = (LinearLayout) findViewById(R.id.calendar2);
        surveycolor = (LinearLayout) findViewById(R.id.survey);
        surveygrey = (LinearLayout) findViewById(R.id.survey2);
        morecolor = (LinearLayout) findViewById(R.id.more);
        moregrey = (LinearLayout) findViewById(R.id.more2);


        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ////tabs.setTextColor(Color.BLACK);
        tabs.setTabPaddingLeftRight(15);
        tabs.setTextSize(0);
        tabs.setShouldExpand(true);
        tabs.setUnderlineColor(0x7f1101);
        // tabs.setDividerColor(Color.BLACK);
        tabs.setFitsSystemWindows(true);
        tabs.setIndicatorHeight(3);
        tabs.setIndicatorColor(Color.parseColor("#e67e22"));
        tabs.setViewPager(pager);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(0);
                forvisiblecolor(gallerycolor);
                forinvisiblecolor(gallerygrey);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
                forvisiblecolor(newscolor);
                forinvisiblecolor(newsgrey);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
                forvisiblecolor(calendarcolor);
                forinvisiblecolor(calendargrey);
            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(3);
                forvisiblecolor(surveycolor);
                forinvisiblecolor(surveygrey);
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(4);
                forvisiblecolor(morecolor);
                forinvisiblecolor(moregrey);
            }
        });


        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    forvisiblecolor(gallerycolor);
                    forinvisiblecolor(gallerygrey);
                } else if (position == 1) {
                    forvisiblecolor(newscolor);
                    forinvisiblecolor(newsgrey);
                } else if (position == 2) {
                    forvisiblecolor(calendarcolor);
                    forinvisiblecolor(calendargrey);
                } else if (position == 3) {
                    forvisiblecolor(surveycolor);
                    forinvisiblecolor(surveygrey);
                } else {
                    forvisiblecolor(morecolor);
                    forinvisiblecolor(moregrey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static void forvisiblecolor(LinearLayout layoutcolor) {
        gallerycolor.setVisibility(View.INVISIBLE);
        gallerygrey.setVisibility(View.INVISIBLE);
        newscolor.setVisibility(View.INVISIBLE);
        newsgrey.setVisibility(View.INVISIBLE);
        calendarcolor.setVisibility(View.INVISIBLE);
        calendargrey.setVisibility(View.INVISIBLE);
        surveycolor.setVisibility(View.INVISIBLE);
        surveygrey.setVisibility(View.INVISIBLE);
        morecolor.setVisibility(View.INVISIBLE);
        moregrey.setVisibility(View.INVISIBLE);
        layoutcolor.setVisibility(View.VISIBLE);
    }
    public static void forinvisiblecolor(LinearLayout layoutgrey) {
        gallerycolor.setVisibility(View.VISIBLE);
        gallerygrey.setVisibility(View.VISIBLE);
        newscolor.setVisibility(View.VISIBLE);
        newsgrey.setVisibility(View.VISIBLE);
        calendarcolor.setVisibility(View.VISIBLE);
        calendargrey.setVisibility(View.VISIBLE);
        surveycolor.setVisibility(View.VISIBLE);
        surveygrey.setVisibility(View.VISIBLE);
        morecolor.setVisibility(View.VISIBLE);
        moregrey.setVisibility(View.VISIBLE);
        layoutgrey.setVisibility(View.INVISIBLE);
    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"","","","","" };


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:

                    return Homefragment.newInstance("FirstFragment, Instance 1");

                case 1:

                    return Searchfragment.newInstance("SecondFragment, Instance 1");

                case 2:

                  return Hostfragment.newInstance("SecondFragment, Instance 1");

                case 3:

                    return Tripsfragemnt.newInstance("SecondFragment, Instance 1");

                case 4:

                    return Settingsfragment.newInstance("SecondFragment, Instance 1");


                default:
                    return null;

            }

        }


    }

}

