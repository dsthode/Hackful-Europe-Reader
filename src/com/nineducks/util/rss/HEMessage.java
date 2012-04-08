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

package com.nineducks.util.rss;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

import android.util.Log;

public class HEMessage implements Serializable {
	
	private static final long serialVersionUID = 42L;
	
	private String title;
	private String description;
	private URL link;
	private URL guid;
	private Date pubDate;
	private String submitter;
	private int points;
	private int commentCount;
	
	public HEMessage() {
		clear();
	}
	
	public HEMessage copy() {
		HEMessage dup = new HEMessage();
		dup.commentCount = this.commentCount;
		dup.description = this.description;
		dup.guid = this.guid;
		dup.link = this.link;
		dup.points = this.points;
		dup.pubDate = this.pubDate;
		dup.submitter = this.submitter;
		dup.title = this.title;
		return dup;
	}

	public void clear() {
		commentCount = 0;
		description = null;
		guid = null;
		link = null;
		points = 0;
		pubDate = null;
		submitter = null;
		title = null;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public URL getLink() {
		URL result = link;
		if (result == null) {
			result = guid;
		}
		return result;
	}
	
	public URL getGuid() {
		return guid;
	}
	
	public Date getPubDate() {
		return pubDate;
	}
	
	public String getSubmitter() {
		return submitter;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getCommentCount() {
		return commentCount;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLink(String link) {
		try {
			this.link = new URL(link.trim());
		} catch(MalformedURLException murle) {
			this.link = null;
		}
	}
	
	public void setGuid(String guid) {
		try {
			this.guid = new URL(guid.trim());
		} catch (MalformedURLException murle) {
			this.guid = null;
		}
	}
	
	public void setPubDate(String date) {
		try {
			this.pubDate = DateFormatter.FORMATTER.parse(date.trim());
		} catch (ParseException pe) {
			Log.d("hereader", "Failed parsing post date", pe);
			this.pubDate = new Date();
		}
	}
	
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	
	public void setPoints(String points) {
		try {
			this.points = Integer.parseInt(points);
		} catch (NumberFormatException nfe) {
			this.points = 0;
		}
	}
	
	public void setCommentCount(String commentsCount) {
		try {
			this.commentCount = Integer.parseInt(commentsCount);
		} catch (NumberFormatException nfe) {
			this.commentCount = 0;
		}
	}
}
