package navdrawer.navdrawer.com.mynavdrawerapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import navdrawer.navdrawer.com.mynavdrawerapp.PresenterFactory;
import navdrawer.navdrawer.com.mynavdrawerapp.R;
import navdrawer.navdrawer.com.mynavdrawerapp.contract.PopularArticlesContract;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.ui.adapter.PopularArticlesAdapter;
import navdrawer.navdrawer.com.mynavdrawerapp.ui.presenter.impl.PopularArticlePresenterImpl;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PopularArticlesContract.PopularArticlesView {
    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    PopularArticlePresenterImpl presenter;
    @BindView(R.id.rvPopularArticles)
    RecyclerView rvPopularArticles;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButterKnife.bind(this);

        initializePresenter();
        setupViews();
        getPopularArticlesList();
    }

    private void initializePresenter() {
        presenter = PresenterFactory.createMainPresenter();
        presenter.setView(this);
    }

    private void setupViews() {
        rvPopularArticles.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getPopularArticlesList() {
        presenter.getPopularArticles();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayPopularArticles(PopularArticlesResponse articleResponse) {
        if (articleResponse != null) {
            Log.d(TAG, articleResponse.getResults().get(1).getTitle());
            adapter = new PopularArticlesAdapter(articleResponse.getResults(), MainActivity.this);
            rvPopularArticles.setAdapter(adapter);
        } else {
            Log.d(TAG, "Popular article response null");
        }
    }

    @Override
    public void displayError(String s) {
        hideProgressBar();
        showToast(s);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }
        if (id == R.id.search) {
            Intent i = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
