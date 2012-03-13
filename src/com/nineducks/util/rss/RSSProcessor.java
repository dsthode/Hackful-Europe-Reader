package com.nineducks.util.rss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

public class RSSProcessor {

	static final String ITEM = "item";
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String PUBDATE = "pubDate";
	static final String LINK = "link";
	static final String GUID = "guid";
	static final String SUBMITTER = "submitter";
	static final String POINTS = "points";
	static final String COMMENTCOUNT = "commentcount";
	
	private URL feedURL;
	private List<HEMessage> messages;
	private String heNamespace;
	
	public RSSProcessor(String feedURL, String heNamespace) {
		messages = new ArrayList<HEMessage>();
		this.heNamespace = heNamespace;
		try {
			this.feedURL = new URL(feedURL);
		} catch (MalformedURLException murle) {
			this.feedURL = null;
			throw new RSSException(murle);
		}
	}
	
	public List<HEMessage> parse() {
		final HEMessage current = new HEMessage();
		RootElement root = new RootElement("rss");
		Element channel = root.getChild("channel");
		Element item = channel.getChild(ITEM);
		item.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
				current.clear();
			}
		});
		item.getChild(TITLE).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setTitle(body);
			}
		});
		item.getChild(DESCRIPTION).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setDescription(body);
			}
		});
		item.getChild(PUBDATE).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setPubDate(body);
			}
		});
		item.getChild(LINK).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setLink(body);
			}
		});
		item.getChild(GUID).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setGuid(body);
			}
		});
		item.getChild(heNamespace, SUBMITTER).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setSubmitter(body);
			}
		});
		item.getChild(heNamespace, POINTS).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setPoints(body);
			}
		});
		item.getChild(heNamespace, COMMENTCOUNT).setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				current.setCommentCount(body);
			}
		});
		item.setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				messages.add(current.copy());
			}
		});
		try {
			Xml.parse(feedURL.openStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RSSException(e);
		}
		return messages;
	}
}
