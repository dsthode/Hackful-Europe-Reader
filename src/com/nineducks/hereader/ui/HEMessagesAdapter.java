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

package com.nineducks.hereader.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineducks.hereader.R;
import com.nineducks.util.rss.HEMessage;

public class HEMessagesAdapter extends BaseAdapter {

	private List<ListFragmentItem> items;
	private LayoutInflater inflater;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public HEMessagesAdapter(FragmentActivity activity, int item,
			List<ListFragmentItem> items) {
		this.items = items;
		inflater = activity.getLayoutInflater();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public ListFragmentItem getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HEMessage msg = items.get(position).getHEMessage();
		View view = convertView;
		ViewHolder viewHolder = null; 
		if (view == null) {
			view = inflater.inflate(R.layout.item, parent, false);
			viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		}
		if (items.get(position).isSelected()) {
			view.setBackgroundColor(Color.argb(0x20, 0xe0, 0xe0, 0xe0));
		} else {
			view.setBackgroundColor(Color.argb(0xff, 0xff, 0xff, 0xff));
		}
		viewHolder = (ViewHolder) view.getTag();
		viewHolder.pubDate.setText(sdf.format(msg.getPubDate()));
		viewHolder.domain.setText(msg.getLink().getHost());
		viewHolder.title.setText(msg.getTitle());
		viewHolder.comments_count.setText(Integer.toString(msg.getCommentCount()));
		viewHolder.author.setText("by " + msg.getSubmitter());
		viewHolder.points.setText("(" + msg.getPoints() + ( msg.getPoints()==1 ? " point)" : " points)"));
		return view;
	}

	public void add(ListFragmentItem msg) {
		items.add(msg);
	}

	public void clear() {
		items.clear();
	}
}
