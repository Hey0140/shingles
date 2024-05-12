package com.example.shingles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fmanager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fmanager.beginTransaction();

        transaction.replace(R.id.mainFragmentLayout, homeFragment).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.mainBottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ftransaction = fmanager.beginTransaction();

            if (item.getItemId() == R.id.homeIcon){
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("userData", userData);
//                bundle.putSerializable("petDataList", petDataList);
//                homeFragment.setArguments(bundle);
                ftransaction.replace(R.id.mainFragmentLayout, homeFragment).commitAllowingStateLoss();
            }
            if(item.getItemId() ==  R.id.searchIcon) {
                ftransaction.replace(R.id.mainFragmentLayout, searchFragment).commitAllowingStateLoss();
            }
//            if(item.getItemId() == R.id.reserveIcon) {
//                ftransaction.replace(R.id.mainFragmentLayout, communityFragment).commitAllowingStateLoss();
//            }
//            if(item.getItemId() == R.id.groupIcon) {
//                ftransaction.replace(R.id.mainFragmentLayout, mypageFragment).commitAllowingStateLoss();
//            }
//            if(item.getItemId() == R.id.mypageIcon) {
//                ftransaction.replace(R.id.mainFragmentLayout, mypageFragment).commitAllowingStateLoss();
//            }
            return true;
        }
    }

//    public void onChangeToPetStatusFragment(){
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("userData", userData);
//        bundle.putSerializable("petDataList", petDataList);
//        petStatusFragment.setArguments(bundle);
//        FragmentTransaction ftransaction = fmanager.beginTransaction();
//        ftransaction.replace(R.id.mainFragmentLayout, petStatusFragment).commitAllowingStateLoss();
//    }

    public void onChangeToSearchFragment(){
        FragmentTransaction ftransaction = fmanager.beginTransaction();
        ftransaction.replace(R.id.mainFragmentLayout, searchFragment).commitAllowingStateLoss();
    }
    public void onChangeToHomeFragment(){
        FragmentTransaction ftransaction = fmanager.beginTransaction();
        ftransaction.replace(R.id.mainFragmentLayout, homeFragment).commitAllowingStateLoss();
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Intent intent = new Intent(this.getIntent());
//        userData = (UserMedia) intent.getSerializableExtra("userData");
//        petDataList = (ArrayList<PetMedia>) intent.getSerializableExtra("petDataList");
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
