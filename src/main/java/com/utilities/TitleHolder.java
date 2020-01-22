package com.utilities;

import java.util.ArrayList;
import java.util.List;

public class TitleHolder {

	private static TitleHolder holder = null;

	public static TitleHolder getInstance() {
		if (holder == null) {
			holder = new TitleHolder();
		}
		return holder;
	}

	private List<String> TITLE_LIST = new ArrayList<String>();

	public List<String> getTitles() {
		return TITLE_LIST;
	}

	public void add(String title) {
		TITLE_LIST.add(title);
	}

	public void replace(List<String> list) {
		TITLE_LIST.clear();
		TITLE_LIST.addAll(list);
	}

	public void clear() {
		TITLE_LIST.clear();
	}

}
