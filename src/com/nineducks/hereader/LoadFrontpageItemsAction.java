package com.nineducks.hereader;

import android.content.Context;
import android.view.View;

import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.actionbar.R;

public class LoadFrontpageItemsAction implements Action {

	private Context context;
	HackfulItemsController itemsController;
	
	public LoadFrontpageItemsAction(Context context, HackfulItemsController itemsController) {
		super();
		this.context = context;
		this.itemsController = itemsController;
	}
	
	@Override
	public int getDrawable() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence getText() {
		// TODO Auto-generated method stub
		return context.getString(R.string.btFrontpageTitle);
	}

	@Override
	public void performAction(View view) {
        itemsController.loadFrontpageItems();
	}

}
