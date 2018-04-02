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

public class FirstFragment extends Fragment {
    private ImageButton btnNotif;
    private ImageButton btnPls;
    private SecondFragment secondFragment;
    private FragmentTransaction ft;
    private Notification.Builder nBuilder;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_first, container, false);
        btnNotif = v.findViewById(R.id.btnNotifFr1);
        btnPls = v.findViewById(R.id.btnPlsFr1);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//          OLD SCHOOL
//                nBuilder = new Notification.Builder(getContext());
//                nBuilder.setSmallIcon(R.drawable.n);
//                nBuilder.setContentTitle("You create a notification");
//                nBuilder.setContentText("Notification 1");
//                nBuilder.setAutoCancel(true);
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                intent.putExtra(MainActivity.TAG_FRAGMENT, "fragment1");
//                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 1, intent, 0);
//                nBuilder.setContentIntent(pendingIntent);
//                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
//                notificationManager.notify(1, nBuilder.build());

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(MainActivity.TAG_FRAGMENT, "fragment1");
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 1, intent, 0);
                PugNotification.with(getActivity())
                        .load ()
                        .identifier(1)
                        .title("You create a notification")
                        .message("Notification 1")
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
                secondFragment = new SecondFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameContainer, secondFragment);
                ft.commit();
            }
        });
        return v;
    }

}
