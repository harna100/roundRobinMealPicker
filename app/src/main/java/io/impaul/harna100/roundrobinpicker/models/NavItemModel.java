package io.impaul.harna100.roundrobinpicker.models;

public class NavItemModel {
	private String navName;
	private int navIcon;
	private FragmentTypes fragType;

	public NavItemModel(String navName, int navIcon, FragmentTypes fragType) {
		this.navName = navName;
		this.navIcon = navIcon;
		this.fragType = fragType;
	}

	public String getNavName() {
		return navName;
	}

	public int getNavIcon() {
		return navIcon;
	}

	public FragmentTypes getFragType() {
		return fragType;
	}

}
