package tech.iosd.yfhr;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class educator extends Fragment {
    WebView web;
    public educator() {
        // Required empty public constructor
    }

    //
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
    String myUrl="http://yhrisouthasia.ning.com/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_educator, container, false);
        web=(WebView)view.findViewById(R.id.web_View);
        WebSettings webs =web.getSettings();
        webs.setJavaScriptEnabled(true);
        web.loadUrl(myUrl);
        web.setWebViewClient(new myWebViewClient());
        return view;
    }
    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            myUrl = url;
            web.loadUrl(url);
            return true;
        }
    }

}
