package cn.e3mall.service;

import java.util.List;
import java.util.Map;

public interface ItemCatService {

	List<Map> getItemCatList(long parentId);
}
