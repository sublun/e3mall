package cn.e3mall.sso.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbUser;

public interface UserService {

	E3Result checkUserData(String data, int type);
	E3Result addUser(TbUser user);
	E3Result userLogin(String username, String password);
	E3Result getUserByToken(String token);
}
