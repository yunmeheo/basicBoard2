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
	        return "page4.jsp";
	    }
	     
	    @RequestMapping(value = "/fileUpload.do")
	    public String fileUp(MultipartHttpServletRequest multi) {
	         
	    	System.out.println("file up 들어옴");
	        // 저장 경로 설정
	        String root = multi.getSession().getServletContext().getRealPath("/");
	        String path = root+"";
	         
	        String newFileName = ""; // 업로드 되는 파일명
	         
	        File dir = new File(path);
	        if(!dir.isDirectory()){
	            dir.mkdir();
	        }
	         
	        Iterator<String> files = multi.getFileNames();
	        while(files.hasNext()){
	            String uploadFile = files.next();
	                         
	            MultipartFile mFile = multi.getFile(uploadFile);
	            String fileName = mFile.getOriginalFilename();
	            System.out.println("실제 파일 이름 : " +fileName);
	            newFileName = System.currentTimeMillis()+"."
	                    +fileName.substring(fileName.lastIndexOf(".")+1);
	             
	            try {
	                mFile.transferTo(new File(path+newFileName));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	         
	        return "ajaxUpload.do";
	    }

	    @RequestMapping("/insert.do")
	   public String insert(Model model,
			   String korName,
			   String engName,
			   String chnName,
			   String juminNo1,
			   String juminNo2,
			   String year,
			   String month,
			   String day,
			   String radiobutton,
			   String workDate,
			   String salarytype,
			   String workFlag,
			   String jointype,
			   String address1,
			   String address2,
			   String phone1,
			   String phone2,
			   String phone3,
			   String email,
			   String techLev,
			   String drinkingCapacity){
	    	
	    	String juminNo= juminNo1+"-"+juminNo2;
	    	String bir = year+"/"+month+"/"+day;
	    	String address = address1 +address2;
	    	String phone = phone1+"-"+phone2+"-"+phone3;
	    	
	    	System.out.println("workFlag :"+workFlag);
	    	
	    	
	    	IsMater im = new IsMater(korName,juminNo,engName,"w",chnName,bir,"Y","Y",salarytype,jointype,
	    			drinkingCapacity,techLev,address,workDate,"Y","Y",workFlag,phone,email);
//	    		public IsMater(String korName, String juminNo, String engName, String sex, String lastSchool(chnName),
//	    				String major(bir), String graduDate(marital_status 결혼여부), String comLag, String licence1, String licence2, String licence3,
//	    				String techLev, String address, String workDate, String state, String image, String workFlag, String phone,
//	    				String email)	
	    	
	    	
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
