package io.impaul.harna100.roundrobinpicker.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.FrameLayout;

import io.impaul.harna100.roundrobinpicker.R;
import io.impaul.harna100.roundrobinpicker.adapters.NavListAdapter;
import io.impaul.harna100.roundrobinpicker.fragments.HomeFragment;
import io.impaul.harna100.roundrobinpicker.fragments.MyFragment;

public class MainActivity extends AppCompatActivity {

	private FrameLayout fl_mainContainer;
	private NavigationView nv_navBar;
	private DrawerLayout dl_drawer;
	private RecyclerView rv_navList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getReferences();
		setListeners();
		setUpRecyclerView();
		setFragment(HomeFragment.NewInstance());

		dl_drawer.openDrawer(Gravity.START);
		setUpRecyclerView();
	}


	private void setFragment(MyFragment fragToSet) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fl_mainContainer, fragToSet)
				.addToBackStack(fragToSet.getName())
				.commit();
	}

	private void getReferences() {
		fl_mainContainer = findViewById(R.id.fl_mainContainer);
		nv_navBar = findViewById(R.id.nv_navBar);
		dl_drawer = findViewById(R.id.dl_drawer);
		rv_navList = findViewById(R.id.rv_navList);
	}

	private void setListeners() {

	}


	private void setUpRecyclerView() {
		rv_navList.setLayoutManager(new LinearLayoutManager(this));
		rv_navList.setAdapter(new NavListAdapter());
	}
}
