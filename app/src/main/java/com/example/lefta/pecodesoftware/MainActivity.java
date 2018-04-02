package com.example.lefta.pecodesoftware;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FragmentTransaction ft;
    public static final String TAG_FRAGMENT = "fragment to launch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra(TAG_FRAGMENT)) {
            switch (getIntent().getStringExtra(TAG_FRAGMENT)) {
                case "fragment1":
                    firstFragment = new FirstFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameContainer, firstFragment);
                    ft.commit();
                    break;
                case "fragment2":
                    secondFragment = new SecondFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameContainer, secondFragment);
                    ft.commit();
                    break;
                case "fragment3":
                    thirdFragment = new ThirdFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameContainer, thirdFragment);
                    ft.commit();
                    break;
                default:
                    break;
            }
        }else{
            firstFragment = new FirstFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frameContainer, firstFragment);
            ft.commit();
        }
    }
}
