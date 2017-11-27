package tech.iosd.yfhr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class KnowYourThirty extends Fragment {

    private TextView clickhere;
    private ImageView backbuttn;

    public KnowYourThirty() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     final   View view=inflater.inflate(R.layout.fragment_know_your_thirty, container, false);
clickhere=view.findViewById(R.id.click);
        backbuttn = (ImageView) view.findViewById(R.id.back);
            clickhere.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.findViewById(R.id.cardviewcontent).setVisibility(View.GONE);
                    view.findViewById(R.id.textOutsideCV).setVisibility(View.GONE);
                    view.findViewById(R.id.click).setVisibility(View.GONE);

                    view.findViewById(R.id.webviewfragment).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.back).setVisibility(View.VISIBLE);
                    getChildFragmentManager().beginTransaction().add(R.id.webviewfragment,new Knowyour30_webview()).commit();

                }
            });

        backbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.cardviewcontent).setVisibility(View.VISIBLE);
                view.findViewById(R.id.textOutsideCV).setVisibility(View.VISIBLE);
                view.findViewById(R.id.click).setVisibility(View.VISIBLE);

                view.findViewById(R.id.webviewfragment).setVisibility(View.GONE);
                view.findViewById(R.id.back).setVisibility(View.GONE);

            }
        });

       return view;
    }


}
