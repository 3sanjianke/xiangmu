package org.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shop.pojo.User;
import org.shop.service.UserService;
import org.shop.utils.Msg;
import org.shop.utils.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/login.do")
	public Msg login(User user,String yanzen,HttpServletRequest request) {
		/*System.out.println(user);    OK
		System.out.println(yanzen);*/
		Msg msg = new Msg();
		HttpSession session = request.getSession();
		String str = (String)session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
		if(!yanzen.equals(str)) {
		    
			return msg.yanZhenFile();
		}
		int dept = userService.selectLogin(user);
		if(dept==1) {
			session.setAttribute("user", user);
			return msg.success();
		}else {
			
			return msg.UnPsFile();
		}
	}
	
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/top.do")
	public String top() {
		return "fenlei/top";
	}
	
	@RequestMapping("/type.do")
	public String type() {
		return "type";
	}
	
	@RequestMapping("/updatePwd.do")
	public String updatePwd() {
		return "updatePwd";
	}
	
	@RequestMapping("/user.do")
	public String user() {
		return "user";
	}
	
	
	/**
	 * 获取生成验证码显示到 UI 界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/checkCode.do")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
            HttpSession session = request.getSession();
            String str = (String)session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
            System.out.println("--------------------------->:"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public Msg update(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println("------------------------->:"+user);
		int dept = userService.update(user);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
}
