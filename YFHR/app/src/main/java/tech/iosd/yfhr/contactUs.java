package tech.iosd.yfhr;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class contactUs extends Fragment {
WebView web;
    String myUrl="http://www.youthforhumanrights.org/contact-info.html";
View view;
    public contactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_contact_us, container, false);
        web=(WebView)view.findViewById(R.id.web_View);
        WebSettings webs =web.getSettings();
        webs.setJavaScriptEnabled(true);
        web.loadUrl(myUrl);

        web.setWebViewClient(new myWebViewClient());

        return view;
    }
    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView v, String url) {
            myUrl = url;
            web.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted(WebView v, String url, Bitmap favicon) {
            super.onPageStarted(v, url, favicon);
            view.findViewById(R.id.progress).setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView v, String url)
        {
            view.findViewById(R.id.card).setVisibility(View.VISIBLE);
            view.findViewById(R.id.progress).setVisibility(View.GONE);

        }
    }

}
