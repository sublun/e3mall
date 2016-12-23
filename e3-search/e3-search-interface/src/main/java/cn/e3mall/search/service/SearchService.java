package cn.e3mall.search.service;

import cn.e3mall.common.pojo.SearchInfo;
import cn.e3mall.common.pojo.SearchResult;

public interface SearchService {

	SearchResult query(SearchInfo searchInfo) throws Exception;
}
