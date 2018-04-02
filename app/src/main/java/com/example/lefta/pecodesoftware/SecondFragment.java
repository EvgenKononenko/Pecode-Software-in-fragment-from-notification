package com.example.lefta.pecodesoftware;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.com.goncalves.pugnotification.notification.PugNotification;

public class SecondFragment extends Fragment {
    private ImageButton btnNotif;
    private ImageButton btnPls;
    private ImageButton btnMin;
    private FirstFragment firstFragment;
    private ThirdFragment thirdFragment;
    private FragmentTransaction ft;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_second, container, false);
        btnNotif = v.findViewById(R.id.btnNotifFr2);
        btnPls =  v.findViewById(R.id.btnPlsFr2);
        btnMin =  v.findViewById(R.id.btnMinFr2);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(MainActivity.TAG_FRAGMENT, "fragment2");
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 2, intent, 0);

                PugNotification.with(getActivity())
                        .load ()
                        .identifier(2)
                        .title("You create a notification")
                        .message("Notification 2")
                        .smallIcon(R.mipmap.n)
                        .largeIcon(R.mipmap.n)
                        .flags (Notification.DEFAULT_ALL )
                        .autoCancel(true)
                        .click(pendingIntent)
                        .simple()
                        .build();
            }
        });

        btnPls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdFragment = new ThirdFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameContainer, thirdFragment);
                ft.commit();
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstFragment = new FirstFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameContainer, firstFragment);
                ft.commit();

                PugNotification.with(getActivity())
                        .cancel(2);
            }
        });

        return v;
    }

}
