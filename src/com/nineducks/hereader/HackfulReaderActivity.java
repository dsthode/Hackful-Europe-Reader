package com.nineducks.hereader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

public class HackfulReaderActivity extends FragmentActivity {
	
	private static Context context;
	private HackfulItemsController itemsController;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("hereader", "entering HackfulEuropeReaderActivity.onCreate");
        this.context = getApplicationContext();
        setContentView(R.layout.main);
        itemsController = (HackfulItemsController) getSupportFragmentManager().findFragmentById(R.id.news_items_frag);
        Log.d("hereader", "leaving HackfulEuropeReaderActivity.onCreate");
    }
    
    public static Context getContext() {
    	return context;
    }

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog result = null;
		AlertDialog.Builder builder = null;
		switch(id) {
		case R.id.open_dialog:
			builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.open_dialog_title);
			builder.setItems(R.array.open_dialog_options, (OnClickListener) itemsController);
			builder.setCancelable(true);
			result = builder.create();
			break;
		case R.id.about_dialog:
			builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.about_dialog_title);
			ScrollView scroll = new ScrollView(this); 
			TextView msg = new TextView(this);
			SpannableString s = new SpannableString(getString(R.string.about_dialog_text));
			Linkify.addLinks(s, Linkify.WEB_URLS);
			msg.setText(s);
			msg.setMovementMethod(LinkMovementMethod.getInstance());
			msg.setTextSize(16);
			msg.setPadding(15, 15, 15, 15);
			scroll.addView(msg);
			builder.setView(scroll);
			builder.setInverseBackgroundForced(true);
			result = builder.create();
			break;
		}
		return result;
	}

}
