package co.borucki.d_pa.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.d_pa.R;
import co.borucki.d_pa.model.DpaMenuItem;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.view.fragments.MessageFragment;
import co.borucki.d_pa.view.fragments.ProductionFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    @BindView(R.id.navigationToolBar)
    Toolbar navigationToolBar;
    @BindView(R.id.navigationView)
    NavigationView navigationMenu;
    @BindView(R.id.main_activity_drawer)
    DrawerLayout drawerLayout;
    private List<DpaMenuItem> menuItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        menuItemList.add(new DpaMenuItem(1, 100, getString(R.string.MainActivityMenuItemProduction), ProductionFragment.class, R.drawable.production));
        menuItemList.add(new DpaMenuItem(2, 200, getString(R.string.MainActivityMenuItemMessage), MessageFragment.class, R.drawable.ic_message_black_24dp));

        navigationMenu.setNavigationItemSelectedListener(this);
        final Menu menu = navigationMenu.getMenu();

        for (DpaMenuItem dpaMenuItem : menuItemList) {
            MenuItem item = menu.add(dpaMenuItem.getGroupId(), dpaMenuItem.getMenuItemId(), dpaMenuItem.getMenuItemId(), dpaMenuItem.getItemName());
            item.setIcon(dpaMenuItem.getIcon()); // add icon
        }

        MenuItem item1 = menu.findItem(menuItemList.get(0).getMenuItemId());
        navigationMenu.setCheckedItem(item1.getItemId());
        navigationMenu.getMenu().performIdentifierAction(item1.getItemId(), 0);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, navigationToolBar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        View header = navigationMenu.getHeaderView(0);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDpaRepository.setSignedUserPassword(null);
        mDpaRepository.setSignedUser(null);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.START);

        uncheckedMenuItem();
        navigationToolBar.setTitle(item.getTitle());
        item.setChecked(true);

        Object fragment = null;
        for (DpaMenuItem dpaMenuItem : menuItemList) {
            if (dpaMenuItem.getGroupId() == item.getGroupId()) {

                try {
                    fragment = dpaMenuItem.getFragment().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityContainer, (Fragment) fragment)
                .commit();
        return false;
    }

    private void uncheckedMenuItem() {
        for (int i = 0; i < navigationMenu.getMenu().size(); i++) {
            if (navigationMenu.getMenu().getItem(i).isChecked()) {
                navigationMenu.getMenu().getItem(i).setChecked(false);
            }
        }
    }


}
