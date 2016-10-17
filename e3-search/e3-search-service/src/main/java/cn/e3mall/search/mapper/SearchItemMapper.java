package cn.e3mall.search.mapper;

import java.util.List;

import cn.e3mall.common.pojo.SearchItem;

public interface SearchItemMapper {
	List<SearchItem> getSearchItemList();
	SearchItem getItemById(long itemId);
}
