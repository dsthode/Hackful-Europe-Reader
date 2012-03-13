package com.nineducks.hereader;

import android.content.Context;
import android.view.View;
import android.support.v4.app.Fragment;

import com.markupartist.android.widget.ActionBar.Action;

public class AboutAction implements Action {
	
	private Context context;
	private HackfulItemsController itemsController;

	public AboutAction(Context context, HackfulItemsController itemsController) {
		this.context = context;
		this.itemsController = itemsController;
	}

	@Override
	public int getDrawable() {
		return 0;
	}

	@Override
	public CharSequence getText() {
		return context.getString(R.string.btAbout);
	}

	@Override
	public void performAction(View view) {
		((Fragment) itemsController).getActivity().showDialog(R.id.about_dialog);
	}

}
