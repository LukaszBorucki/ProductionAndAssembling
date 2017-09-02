package co.borucki.d_pa.model;


import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

public class DpaMenuItem {
    private int groupId;
    private int menuItemId;
    private String itemName;
    private Class fragment;
    private
    @DrawableRes
    int icon;

    public DpaMenuItem(int groupId, int menuItemId, String itemName, Class fragment, @DrawableRes int icon) {
        this.groupId = groupId;
        this.menuItemId = menuItemId;
        this.itemName = itemName;
        this.fragment = fragment;
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
