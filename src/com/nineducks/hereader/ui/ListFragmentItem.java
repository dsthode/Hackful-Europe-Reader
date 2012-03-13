package com.nineducks.hereader.ui;

import java.io.Serializable;

import com.nineducks.util.rss.HEMessage;

public class ListFragmentItem implements Serializable {
	
	private static final long serialVersionUID = 42L;
	private HEMessage msg;
	private boolean selected;
	
	public ListFragmentItem(HEMessage msg, boolean selected) {
		this.msg = msg;
		this.selected = selected;
	}
	
	public HEMessage getHEMessage() {
		return msg;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
