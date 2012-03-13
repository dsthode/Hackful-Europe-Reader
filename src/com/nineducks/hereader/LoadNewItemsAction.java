package com.nineducks.hereader;

import android.content.Context;
import android.view.View;

import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.actionbar.R;

public class LoadNewItemsAction implements Action {

	private Context context;
	private HackfulItemsController itemsController;

	public LoadNewItemsAction(Context context, HackfulItemsController itemsController) {
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
		return context.getString(R.string.btNewTitle);
	}

	@Override
	public void performAction(View view) {
        itemsController.loadNewItems();
	}

}
