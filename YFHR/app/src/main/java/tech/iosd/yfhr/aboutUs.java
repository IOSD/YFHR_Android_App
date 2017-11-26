package tech.iosd.yfhr;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class aboutUs extends Fragment {

    private TextView clickhere;

    public aboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about_us, container, false);
        clickhere=view.findViewById(R.id.click);
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.youthforhumanrights.org/what-are-human-rights/videos/born-free-and-equal.html")));


            }
        });

        return view;
    }

}
