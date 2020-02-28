package org.janine.jian.service;

import org.janine.jian.domain.SysUser;
import org.janine.jian.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
	@Autowired
	private SysUserMapper mapper;
	
	public SysUser login(String userName,String password) {
		return mapper.login(userName, password);
	}
	
	public SysUser queryByUserName(String userName) {
		return mapper.queryByUserName(userName);
	}
	
	public SysUser register(SysUser sysUser) {
		sysUser.setRegister_date(mapper.now());//设置当前时间
		//设置salt
		return mapper.insert(sysUser);
	}
	
	

}
