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
