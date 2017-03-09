package barketplace.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import barketplace.exception.MessageException;
import barketplace.exception.NotExistException;
import barketplace.model.ProbonoService;
import barketplace.model.dto.ActivistDTO;

@Controller
public class ProbonoSubController {

	
	public String check(HttpServletRequest req){
		System.out.println("loginCheck.do ��û ó�� �޼ҵ� ����");
		req.setAttribute("msg", "Controller���� ������ ������");
		return "forward:/success.jsp";//forward������� page�̵� !123123
	}
	
    //��� ProbonoProject �˻� �޼ҵ�
	@RequestMapping(value="probonoProjectAll",  method=RequestMethod.GET)
	public ModelAndView probonoProjectAll( ) throws SQLException, NotExistException {
		System.out.println("probonoProjectAll");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("probonoProjectList");
		mv.addObject("probonoProjectAll",ProbonoService.getAllProbonoProjects() );
		return mv;
	}
	
	//???
	//��� ��� ����� �˻� - �˻��� ������ ��� ȭ��[activistList.jsp]
	@RequestMapping(value="activistAll",  method=RequestMethod.GET)
	public ModelAndView activistAll() throws SQLException, NotExistException {
		System.out.println("activistAll");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("activistList");
		mv.addObject("activistAll", ProbonoService.getAllActivists());
		return mv;
	
	}
	
	//��� ����� �˻� 
	@RequestMapping(value="activist")
	public ModelAndView activist(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activist");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("activistDetail");
		mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
		return mv;
	}
	

	//��� ����� ���� �޼ҵ�
	@RequestMapping(value="activistInsert")
	protected ModelAndView activistInsert(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activistInsert");
		ModelAndView mv = new ModelAndView();
		boolean result = ProbonoService.addActivist(activist);
		if(result){
			mv.addObject("activist", activist);
			mv.addObject("successMsg", "���� �Ϸ�");
			mv.setViewName("activistDetail");
		}else{
			mv.addObject("errorMsg", "�ٽ� �õ��ϼ���");
		}
		return mv;
	}
	
	//��� ����� ���� �䱸
	@RequestMapping(value="activistUpdateReq")
	public ModelAndView activistUpdateReq(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activistUpdateReq");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("activistUpdate");
			mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
			return mv;
	}

	//???
	//��� ����� ���� - ������ Ȯ�� jsp[activistDetail.jsp]
	@RequestMapping(value="activistUpdate")
	public ModelAndView activistUpdate(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		
		System.out.println("activistUpdate");
		ModelAndView mv = new ModelAndView();
		boolean result = ProbonoService.updateActivist(activist.getId(), activist.getMajor());
		if(result){
			mv.addObject("successMsg", "���� �Ϸ�");
			mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
			mv.setViewName("activistDetail");
		}else{
			mv.addObject("errorMsg", "�ٽ� �õ��ϼ���");
		}
		return mv;
	}
	
	//???
	//��� ����� ����[activistList.jsp]
	@RequestMapping(value="activistDelete")
	public ModelAndView activistDelete(@ModelAttribute("activist") ActivistDTO activist) throws Exception {

		System.out.println("activistDelete");
		ModelAndView mv = new ModelAndView();
		boolean result =  ProbonoService.deleteActivist(activist.getId());
		
		if(result){
			mv.addObject("successMsg", "���� �Ϸ�");
			mv.addObject("activistAll", ProbonoService.getAllActivists());
			mv.setViewName("activistList");
		}else{
			mv.addObject("successMsg", "�ٽ� �õ��ϼ���");
		}
		return mv;
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionProcess(Exception e){
		return "redirect:/showError.jsp?errorMsg=" + e.getMessage();
	}
	
}
