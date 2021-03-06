/*
Copyright 2012 Damián Serrano Thode (@dsthode)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
