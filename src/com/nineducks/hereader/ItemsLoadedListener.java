package com.nineducks.hereader;

import java.util.List;

import com.nineducks.util.rss.HEMessage;

public interface ItemsLoadedListener {
	void onItemsLoaded(List<HEMessage> items);
}
