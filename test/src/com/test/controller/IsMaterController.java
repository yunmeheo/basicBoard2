package com.test.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.dao.IsMaterDAOOracle;
import com.test.vo.IsMater;


@Controller
public class IsMaterController {
	
	
	@Autowired
	IsMaterDAOOracle dao;
	
	
	 @RequestMapping(value = "/ajaxUpload.do")
	    public String ajaxUpload() {
	        return "insert.jsp";
	    }
	     
	    @RequestMapping(value = "/fileUpload.do")
	    public String fileUp(MultipartHttpServletRequest multi) {
	         
	    	System.out.println("file up 들어옴");
	    	
	        // 저장 경로 설정
	        String root = multi.getSession().getServletContext().getRealPath("/");
	        String path = root+"upload";
	        
	        System.out.println("실제 저장경로 : " +path);
	         
	        String newFileName = ""; // 업로드 되는 파일명
	         
	        //path에 폴더가 없을경우 생성한다.
	        File dir = new File(path);
	        System.out.println("dir  ??  : " +dir);
	        if(!dir.isDirectory()){
	        	dir.mkdir();
	        }
	         
	        //파일이름 가져오기
	        Iterator<String> files = multi.getFileNames();
	        while(files.hasNext()){
	        	
	            String uploadFile = files.next();
	            MultipartFile mFile = multi.getFile(uploadFile);
	            String fileName = mFile.getOriginalFilename();
	            System.out.println("실제 파일 이름 : " +fileName);
	            
	            newFileName = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
	            //System.out.println("저장되는 파일 이름 : " +newFileName);
	            try {
	                mFile.transferTo(new File(path+newFileName));
	                System.out.println("try 들어옴");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	         
	        return "ajaxUpload.do";
	    }

	    @RequestMapping("/insert.do")
	   public String insert(Model model,
			   String kor_name,
			   String eng_name,
			   String chn_name,
			   String jumin_no1,
			   String jumin_no2,
			   String image_name,
			   String year,
			   String month,
			   String day,
			   String sex,
			   String marital_status,
			   String work_date,
			   String pay_type,
			   String work_flag,
			   String join_type,
			   String address1,
			   String address2,
			   String phone1,
			   String phone2,
			   String phone3,
			   String email,
			   String tech_lev,
			   String drinkingCapacity){
	    	
	    	String jumin_no= jumin_no1+"-"+jumin_no2;
	    	String bir = year+"/"+month+"/"+day;
	    	String address = address1 +address2;
	    	String phone = phone1+"-"+phone2+"-"+phone3;
	    	
	    	System.out.println("pay_type :"+pay_type);
	    	
	    	
	    	IsMater im = new IsMater(kor_name,eng_name, chn_name,jumin_no, image_name,
	    			bir, "w", "y", work_date, pay_type, work_flag,
	    			join_type, address, phone, email, tech_lev, drinkingCapacity);
	    	
	    	System.out.println(im);

	    	dao.insert(im);
	    	return null;
	    }
	    
	    
	    int listSize;
	    @RequestMapping("selectAll.do")
	    public String selectAll(Model model, 
	    						int pageno
	    						){
	    	
	    	//총사이즈 한번만 구하기
	    	int cnt=0;
	    	if(cnt == 0){
	    		cnt ++;
	    		listSize= dao.selectAll().size();
	    	}
	    	
	    	//리스트 10개씩 불러오기
	    	List <IsMater> list = new ArrayList<>();
	    	int startPage = pageno*10-9;
	    	int endPage = pageno*10;
	    	list = dao.selectAll(startPage,endPage);
	    	
	    	System.out.println("listSize : "+listSize);
	    	model.addAttribute("list",list);
	    	model.addAttribute("listSize",listSize);

	    	return "/list.jsp";
	    }


   
}
