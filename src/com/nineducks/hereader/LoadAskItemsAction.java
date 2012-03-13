package com.nineducks.hereader;

import android.content.Context;
import android.view.View;

import com.markupartist.android.widget.ActionBar.Action;

import com.nineducks.hereader.R;
public class LoadAskItemsAction implements Action {

	private Context context;
	private HackfulItemsController itemsController;
	
	public LoadAskItemsAction(Context context, HackfulItemsController itemsController) {
		super();
		this.context = context;
		this.itemsController = itemsController;
	}
	
	@Override
	public int getDrawable() {
		return 0;
	}

	@Override
	public CharSequence getText() {
		return context.getString(R.string.btAskTitle);
	}

	@Override
	public void performAction(View view) {
		itemsController.loadAskItems();
	}

}
