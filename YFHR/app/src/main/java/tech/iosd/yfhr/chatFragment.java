package tech.iosd.yfhr;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;


import java.util.ArrayList;
import java.util.List;

public class chatFragment extends Fragment {
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private DatabaseReference mUserRef;
    private TabLayout mTabLayout;
View view;
    public chatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        mAuth = FirebaseAuth.getInstance();

        mToolbar = (Toolbar) view.findViewById(R.id.main_page_toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setTitle("Lapit Chat");
        if (mAuth.getCurrentUser() != null) {
            mUserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());

        }
        //Tabs
        mViewPager = (ViewPager) view.findViewById(R.id.main_tabPager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        //etSupportFragmentManager()

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabLayout = (TabLayout) view.findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        BoomMenuButton bmb;
        bmb = (BoomMenuButton) view.findViewById(R.id.bmb);
        HamButton.Builder builder1 = new HamButton.Builder()
                .normalImageRes(R.drawable.ic_people_black_24dp)
                .normalTextRes(R.string.menu_option1)
                .subNormalTextRes(R.string.opt1_detail).normalColorRes(R.color.colorAccent).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent settingsIntent = new Intent(getContext(), UsersActivity.class);
                        startActivity(settingsIntent);

                    }
                });
        bmb.addBuilder(builder1);
        HamButton.Builder builder2 = new HamButton.Builder()
                .normalImageRes(R.drawable.ic_settings)
                .normalTextRes(R.string.menu_option2)
                .subNormalTextRes(R.string.opt2_detail).normalColorRes(R.color.colorPrimary).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent settingsIntent = new Intent(getContext(), SettingsActivity.class);
                        startActivity(settingsIntent);

                    }
                });
        bmb.addBuilder(builder2);
        HamButton.Builder builder3 = new HamButton.Builder()
                .normalImageRes(R.drawable.ic_exit)
                .normalTextRes(R.string.menu_option3)
                .subNormalTextRes(R.string.opt3_detail).normalColorRes(R.color.colorPrimaryDark).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        mUserRef.child("online").setValue(ServerValue.TIMESTAMP);

                        FirebaseAuth.getInstance().signOut();
                        sendToStart();
                    }
                });

        bmb.addBuilder(builder3);
    return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null){

            sendToStart();

        } else {

            mUserRef.child("online").setValue("true");

        }

    }


    @Override
    public void onStop() {
        super.onStop();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {

            mUserRef.child("online").setValue(ServerValue.TIMESTAMP);

        }

    }

    private void sendToStart() {

        Intent startIntent = new Intent(getContext(), StartActivity.class);
        startActivity(startIntent);
//        finish();

    }

}
