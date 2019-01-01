package org.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(".......");
		// TODO Auto-generated method stub
		// �����ص�ִ��ǰ���أ��������true��ִ�����ص��Ĳ��������سɹ���
				// ����false��ִ������
				HttpSession session = request.getSession();
				//String uri = request.getRequestURI(); // ��ȡ��¼��uri������ǲ��������ص�
				//if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// ˵����¼�ɹ� ���� ִ�е�¼����			
				if(session.getAttribute("user")!=null) {
					// ��¼�ɹ�������
					return true;
				}else {
					// ���غ�����¼ҳ��
					response.sendRedirect(request.getContextPath()+"/tologin.do");
					return false;
				}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�ڴ��������У�ִ�����ء�������");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ִ����ϣ�����ǰ���ء�����" );
	}

}