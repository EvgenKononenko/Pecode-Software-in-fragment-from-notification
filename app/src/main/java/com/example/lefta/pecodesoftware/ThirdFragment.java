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

public class ThirdFragment extends Fragment {
    private ImageButton btnNotif;
    private ImageButton btnMin;
    private SecondFragment secondFragment;
    private FragmentTransaction ft;

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_third, container, false);
        btnNotif = v.findViewById(R.id.btnNotifFr3);
        btnMin = v.findViewById(R.id.btnMinFr3);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(MainActivity.TAG_FRAGMENT, "fragment3");
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 3, intent, 0);

                PugNotification.with(getActivity())
                        .load ()
                        .identifier(3)
                        .title("You create a notification")
                        .message("Notification 3")
                        .smallIcon(R.mipmap.n)
                        .largeIcon(R.mipmap.n)
                        .flags (Notification.DEFAULT_ALL )
                        .autoCancel(true)
                        .click(pendingIntent)
                        .simple()
                        .build();
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondFragment = new SecondFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameContainer, secondFragment);
                ft.commit();

                PugNotification.with(getActivity())
                        .cancel(3);
            }
        });
        return v;
    }

}
