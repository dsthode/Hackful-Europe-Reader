package com.nineducks.hereader;

import java.util.List;

import com.nineducks.hereader.ui.ListFragmentItem;

public class HEReaderState {
	
	private int currentSource;
	private List<ListFragmentItem> items;
	private int currentPage;
	
	public HEReaderState(int currentSource, List<ListFragmentItem> items, int currentPage) {
		this.currentSource = currentSource;
		this.items = items;
		this.currentPage = currentPage;
	}
	
	public int getCurrentSource() {
		return currentSource;
	}
	
	public List<ListFragmentItem> getItems() {
		return items;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
}
