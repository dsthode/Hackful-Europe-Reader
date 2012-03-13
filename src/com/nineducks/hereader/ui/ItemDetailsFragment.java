package com.nineducks.hereader.ui;

import java.net.URL;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class ItemDetailsFragment extends Fragment {
	
	URL currentUrl = null;
	
	protected static ItemDetailsFragment newInstance(URL itemUrl){
		Log.d("hereader", "entering ItemDetailsFragment.newInstance");
		ItemDetailsFragment details = new ItemDetailsFragment();
		Bundle args = new Bundle();
		args.putString("url", itemUrl.toString());
		details.setArguments(args);
		Log.d("hereader", "leaving ItemDetailsFragment.newInstance");
		return details;
	}
	
	protected URL getShownUrl() {
		return currentUrl;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("hereader", "entering ItemDetailsFragment.onCreateView");
		if (container == null) {
			Log.d("hereader", "leaving ItemDetailsFragment.onCreateView");
			return null;
		}
		String url = getArguments().getString("url");
		WebView webView = new WebView(getActivity().getApplicationContext());
		webView.loadUrl(url);
		Log.d("hereader", "leaving ItemDetailsFragment.onCreateView");
		return webView;
	}
	
}
