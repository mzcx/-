package com.lxj.JComPz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lxj.Dao.BookInfoDao;
import com.lxj.model.BookType;

public class MapPz {
	static Map map = new HashMap();

	public static Map getMap() {
		List list = BookInfoDao.selectBookCategory();
		for (int i = 0; i < list.size(); i++) {
			BookType booktype = (BookType) list.get(i);

			Item item = new Item();
			item.setId(booktype.getId());
			item.setName(booktype.getTypeName());
			map.put(item.getId(), item);

		}
		return map;
	}
}
