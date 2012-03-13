package com.nineducks.hereader.ui;

import com.nineducks.hereader.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	ImageView comments_icon;
	TextView author;
	TextView comments_count;
	TextView pubDate;
	TextView domain;
	TextView title;
	TextView points;
	
	public ViewHolder(View base) {
//		comments_icon = (ImageView) base.findViewById(R.id.comments_icon);
		comments_count = (TextView) base.findViewById(R.id.comments_count);
		author = (TextView) base.findViewById(R.id.author);
		pubDate = (TextView) base.findViewById(R.id.pubDate);
		domain = (TextView) base.findViewById(R.id.domain);
		title = (TextView) base.findViewById(R.id.title);
		points = (TextView) base.findViewById(R.id.points);
	}
		
}
