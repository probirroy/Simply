package bd.com.simply.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import bd.com.simply.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {
    private WebView myWebView1;
    public WishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        myWebView1 = (WebView) view.findViewById(R.id.webview);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView1.setWebViewClient(new android.webkit.WebViewClient());
        myWebView1.loadUrl("https://simply.com.bd/wishlist/");
        myWebView1.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView1.getSettings().setAppCacheEnabled(true);
        myWebView1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        myWebView1.getSettings().setBuiltInZoomControls(false);
        myWebView1.getSettings().setSupportZoom(false);
        myWebView1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView1.getSettings().setAllowFileAccess(true);
        myWebView1.getSettings().setDomStorageEnabled(true);
        myWebView1.getSettings().setLoadsImagesAutomatically(true);
        myWebView1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView1.canGoBack();
        myWebView1.goBack();
        myWebView1.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && myWebView1.canGoBack()) {
                    myWebView1.goBack();
                    return true;
                }
                return false;
            }
        });
        return view;
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
