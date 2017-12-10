package io.impaul.harna100.roundrobinpicker.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.adapters.NavListAdapter;
import io.impaul.harna100.roundrobinpicker.fragments.HomeFragment;
import io.impaul.harna100.roundrobinpicker.interfaces.NavContainerInterface;

public class MainActivity extends NavContainer implements NavContainerInterface {

	private static final String TAG = "MainActivity";
	private FrameLayout fl_mainContainer;
	private NavigationView nv_navBar;
	private DrawerLayout dl_drawer;
	private RecyclerView rv_navList;
	private Toolbar tb_mainToolbar;

	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getReferences();
		setSupportActionBar(tb_mainToolbar);

		setListeners();
		setUpRecyclerView();
		setUpNavigationDrawer();

		setFragment(HomeFragment.NewInstance(), false);

		dl_drawer.openDrawer(Gravity.START);
	}



	private void getReferences() {
		fl_mainContainer = findViewById(R.id.fl_mainContainer);
		nv_navBar = findViewById(R.id.nv_navBar);
		dl_drawer = findViewById(R.id.dl_drawer);
		rv_navList = findViewById(R.id.rv_navList);
		tb_mainToolbar = findViewById(R.id.tb_mainToolbar);
	}

	private void setListeners() {

	}


	private void setUpRecyclerView() {
		rv_navList.setLayoutManager(new LinearLayoutManager(this));
		rv_navList.setAdapter(new NavListAdapter());
		rv_navList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
	}

	private void setUpNavigationDrawer(){
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
		drawerToggle = new ActionBarDrawerToggle(this,
				dl_drawer,
				R.string.drawer_open,
				R.string.drawer_close){
			public void onDrawerClosed(View view){
				super.onDrawerClosed(view);
				getSupportActionBar().setTitle(R.string.app_name);
				getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
			}
			public void onDrawerOpened(View drawerView){
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
			}
		};

		dl_drawer.addDrawerListener(drawerToggle);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(drawerToggle.onOptionsItemSelected(item)){
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
