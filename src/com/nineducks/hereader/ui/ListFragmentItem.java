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
