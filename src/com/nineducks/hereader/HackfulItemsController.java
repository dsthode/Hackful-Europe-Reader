package com.nineducks.hereader;

import java.util.List;

import com.nineducks.hereader.ui.ListFragmentItem;

public interface HackfulItemsController {
	public void loadFrontpageItems();
	public void loadNewItems();
	public void loadAskItems();
	public void loadMoreItems();
	public HEReaderState getCurrentState();
	public void setCurrentState(HEReaderState state);
	public List<ListFragmentItem> getItems();
	public int getItemsSource();
	public void putItems(List<ListFragmentItem> items, int itemsSource);
}
