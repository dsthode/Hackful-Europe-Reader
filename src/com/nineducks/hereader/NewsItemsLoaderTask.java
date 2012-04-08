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

import java.util.ArrayList;
import java.util.List;

import com.nineducks.util.rss.HEMessage;
import com.nineducks.util.rss.RSSProcessor;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class NewsItemsLoaderTask extends AsyncTask<String, Void, List<HEMessage>> {
	
	private ItemsLoadedListener listener = null;
	private Context context = null;
	
	@Override
	protected List<HEMessage> doInBackground(String... params) {
		Log.d("hereader", "entering NewsItemsLoaderTask.doInBackground");
		List<HEMessage> result = null;
		RSSProcessor proc = null;
		try {
			if (params != null && params[0] != null && params[1] != null) {
				proc = new RSSProcessor(params[0], params[1]);
				result = proc.parse();
			}
		} catch (Exception e) {
		}
		Log.d("hereader", "leaving NewsItemsLoaderTask.doInBackground");
		return result;
	}
	
	public void addNewsItemsLoadedListener(ItemsLoadedListener listener) {
		this.listener = listener;
	}

	@Override
	protected void onPostExecute(List<HEMessage> result) {
		Log.d("hereader", "entering NewsItemsLoaderTask.onPostExecute");
		if (listener != null) {
			Log.d("hereader", "notifying NewsItemsLoadedListener");
			listener.onItemsLoaded(result);
			Log.d("hereader", "notified NewsItemsLoadedListener");
		}
		Log.d("hereader", "leaving NewsItemsLoaderTask.onPostExecute");
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

}
