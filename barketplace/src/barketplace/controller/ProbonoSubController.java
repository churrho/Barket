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
		System.out.println("loginCheck.do 요청 처리 메소드 실행");
		req.setAttribute("msg", "Controller에서 저장한 데이터");
		return "forward:/success.jsp";//forward방식으로 page이동 !123123
	}
	
    //모두 ProbonoProject 검색 메소드
	@RequestMapping(value="probonoProjectAll",  method=RequestMethod.GET)
	public ModelAndView probonoProjectAll( ) throws SQLException, NotExistException {
		System.out.println("probonoProjectAll");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("probonoProjectList");
		mv.addObject("probonoProjectAll",ProbonoService.getAllProbonoProjects() );
		return mv;
	}
	
	//???
	//모든 재능 기부자 검색 - 검색된 데이터 출력 화면[activistList.jsp]
	@RequestMapping(value="activistAll",  method=RequestMethod.GET)
	public ModelAndView activistAll() throws SQLException, NotExistException {
		System.out.println("activistAll");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("activistList");
		mv.addObject("activistAll", ProbonoService.getAllActivists());
		return mv;
	
	}
	
	//재능 기부자 검색 
	@RequestMapping(value="activist")
	public ModelAndView activist(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activist");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("activistDetail");
		mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
		return mv;
	}
	

	//재능 기부자 가입 메소드
	@RequestMapping(value="activistInsert")
	protected ModelAndView activistInsert(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activistInsert");
		ModelAndView mv = new ModelAndView();
		boolean result = ProbonoService.addActivist(activist);
		if(result){
			mv.addObject("activist", activist);
			mv.addObject("successMsg", "가입 완료");
			mv.setViewName("activistDetail");
		}else{
			mv.addObject("errorMsg", "다시 시도하세요");
		}
		return mv;
	}
	
	//재능 기부자 수정 요구
	@RequestMapping(value="activistUpdateReq")
	public ModelAndView activistUpdateReq(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		System.out.println("activistUpdateReq");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("activistUpdate");
			mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
			return mv;
	}

	//???
	//재능 기부자 수정 - 상세정보 확인 jsp[activistDetail.jsp]
	@RequestMapping(value="activistUpdate")
	public ModelAndView activistUpdate(@ModelAttribute("activist") ActivistDTO activist) throws Exception {
		
		System.out.println("activistUpdate");
		ModelAndView mv = new ModelAndView();
		boolean result = ProbonoService.updateActivist(activist.getId(), activist.getMajor());
		if(result){
			mv.addObject("successMsg", "수정 완료");
			mv.addObject("activist", ProbonoService.getActivist(activist.getId()));
			mv.setViewName("activistDetail");
		}else{
			mv.addObject("errorMsg", "다시 시도하세요");
		}
		return mv;
	}
	
	//???
	//재능 기부자 삭제[activistList.jsp]
	@RequestMapping(value="activistDelete")
	public ModelAndView activistDelete(@ModelAttribute("activist") ActivistDTO activist) throws Exception {

		System.out.println("activistDelete");
		ModelAndView mv = new ModelAndView();
		boolean result =  ProbonoService.deleteActivist(activist.getId());
		
		if(result){
			mv.addObject("successMsg", "삭제 완료");
			mv.addObject("activistAll", ProbonoService.getAllActivists());
			mv.setViewName("activistList");
		}else{
			mv.addObject("successMsg", "다시 시도하세요");
		}
		return mv;
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionProcess(Exception e){
		return "redirect:/showError.jsp?errorMsg=" + e.getMessage();
	}
	
}
