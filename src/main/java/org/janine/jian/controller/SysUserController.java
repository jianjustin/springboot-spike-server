package org.janine.jian.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.janine.jian.domain.LoginVo;
import org.janine.jian.domain.SysUser;
import org.janine.jian.service.SysUserService;
import org.janine.jian.utils.JsonResult;
import org.janine.jian.utils.MD5Utils;
import org.janine.jian.utils.ResponseUtils;
import org.janine.jian.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/signin")
	@ResponseBody
    public JsonResult<SysUser> signin(
    		@RequestBody LoginVo loginVo, HttpSession session){
		SysUser sysUser = sysUserService.queryByUserName(loginVo.getUsername());
		if (null == sysUser)
			return ResponseUtils.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, "用户不存在", null, null, null);
		else {
			String password = MD5Utils.encode(loginVo.getPassword(), MD5Utils.toByteArray(sysUser.getSalt()));
			if (password.equals(sysUser.getUser_password())) {
				SessionUtils.sessions.put(session.getId(),sysUser);//TODO 可以生成Token信息
				return ResponseUtils.getResponse(HttpStatus.OK, "用户登录成功", null, null, null);
			}else 
				return ResponseUtils.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误，请重新输入", null, null, null);
		}
    }
	
	
	@RequestMapping("/signout")
	@ResponseBody
    public JsonResult<SysUser> signout(HttpSession session){
		SessionUtils.sessions.remove(session.getId());
		session.invalidate();
		Map<String, Object> res = new HashMap<>();
    	return ResponseUtils.getResponse(HttpStatus.OK, "用户已成功注销", null, null, null);
        
    }

}
