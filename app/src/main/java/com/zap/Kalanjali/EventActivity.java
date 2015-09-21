package com.zap.Kalanjali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class EventActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageButton mFloatingButton;
    RecyclerView mRecyclerView;
    EventAdapter mEventAdapter;
    String mText;
    List<String> mItemList;
    ImageView mImageView;
    LinearLayout mToolbarContainer;
    int mToolbarHeight;

    String TITLES[] = {"Home","Events","Locate us","Contact","Home","Events","Locate us","Contact","Home","Events","Locate us","Contact","Home","Events","Locate us","Contact","Home","Events","Locate us","Contact","Home","Events","Locate us","Contact"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mToolbarContainer = (LinearLayout) findViewById(R.id.event_tool_bar_container);
        intiToolBar();
        initRecycler();
        //mFloatingButton = (ImageButton) findViewById(R.id.floating_Button);
        mImageView = (ImageView) findViewById(R.id.event_page_image);
    }

    private void intiToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void initRecycler() {
        mRecyclerView = (RecyclerView) findViewById(R.id.event_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEventAdapter = new EventAdapter(TITLES);
        mRecyclerView.setAdapter(mEventAdapter);
        mRecyclerView.setOnScrollListener(new EventOnScrollListner(this) {
            @Override
            public void onMoved(int distance) {
                mToolbarContainer.setTranslationY(-distance);
            }

            @Override
            public void onShow() {
                mToolbarContainer.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onHide() {
                mToolbarContainer.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2)).start();
            }
        });
    }


    private void hideViews() {
        int height = mToolbar.getHeight()+mImageView.getHeight();
        mImageView.animate().translationY(-mImageView.getHeight()).setInterpolator(new AccelerateInterpolator(2));
        mToolbar.animate().translationY(-height).setInterpolator(new AccelerateInterpolator(2));

        //FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFloatingButton.getLayoutParams();
        //int floatBottomMargin = lp.bottomMargin;
        //mFloatingButton.animate().translationY(mFloatingButton.getHeight()+floatBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        mImageView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        //mFloatingButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
