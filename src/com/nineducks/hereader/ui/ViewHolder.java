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
