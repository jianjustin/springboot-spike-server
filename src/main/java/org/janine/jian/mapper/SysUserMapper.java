package org.janine.jian.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.janine.jian.domain.SysUser;

@Mapper
public interface SysUserMapper {
	@Select("select * from sys_user where user_name = #{userName} and user_password = #{password}")
	public SysUser login(String userName, String password);
	
	@Select("select * from sys_user where user_name = #{userName}")
	public SysUser queryByUserName(String userName);
	
	@Insert("insert into sys_user(user_name,user_password,salt,register_date) values(#{user_name},#{user_password},#{salt},#{register_date})")
	public SysUser insert(SysUser sysUser);
	
	@Select("select now()")
	public Date now();

}
