package tech.iosd.yfhr;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class aboutUs extends Fragment {

    private TextView clickhere;
    private ImageView backbuttn;
    public aboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_about_us, container, false);
        backbuttn = (ImageView) view.findViewById(R.id.back);
        clickhere=view.findViewById(R.id.click);
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
view.findViewById(R.id.ll).setVisibility(View.GONE);
                view.findViewById(R.id.back).setVisibility(View.VISIBLE);
                view.findViewById(R.id.webviewfragment).setVisibility(View.VISIBLE);
                getChildFragmentManager().beginTransaction().add(R.id.webviewfragment,new aboutUsWebView()).commit();

            }
        });
    backbuttn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            view.findViewById(R.id.ll).setVisibility(View.VISIBLE);
            view.findViewById(R.id.webviewfragment).setVisibility(View.GONE);
            view.findViewById(R.id.back).setVisibility(View.GONE);

        }
    });

        return view;
    }


}
