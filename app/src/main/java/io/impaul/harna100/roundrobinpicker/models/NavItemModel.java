package io.impaul.harna100.roundrobinpicker.models;

/**
 * Created by Paul on 12/8/2017.
 */

public class NavItemModel {
	private String navName;
	private int navIcon;

	public NavItemModel(String navName, int navIcon) {
		this.navName = navName;
		this.navIcon = navIcon;
	}

	public String getNavName() {
		return navName;
	}

	public int getNavIcon() {
		return navIcon;
	}
}
