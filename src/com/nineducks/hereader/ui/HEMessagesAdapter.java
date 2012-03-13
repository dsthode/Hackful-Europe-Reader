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
