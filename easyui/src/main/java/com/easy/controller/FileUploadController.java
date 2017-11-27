package com.easy.controller;

import java.io.File;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.easy.vo.User;

@Controller
@RequestMapping("/files")
public class FileUploadController {
	
	
	/**
	 * 
	 * @param file 就是我上传的临时文件
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@RequestParam("fileName")CommonsMultipartFile file,User user) {
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		
		System.out.println(user);
		//file.getOriginalFilename() 获取文件的原始文件名
		String path = "d://files";
		try {
			File dir = new File(path);
			if(!dir.exists()) {//如果目录不存在，我就创建
				dir.mkdir();
			}
			
			path = path + File.separator + new Date().getTime()+"_"+fileName;
			File f=new File(path);
			file.getFileItem().write(f);//将临时文件，向真实文件写入内容
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping(value="/upload2",method=RequestMethod.POST)
	public String upload(@RequestParam("fileName")CommonsMultipartFile[] files) {
		if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
            	CommonsMultipartFile file = files[i];  
                //保存文件  
                saveFile(file);  
            }  
        }  
		
		return "index";
	}
	
	
	private boolean saveFile(CommonsMultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
            	String fileName = file.getOriginalFilename();
        		
        		//file.getOriginalFilename() 获取文件的原始文件名
        		String path = "d://files";
        		
        			File dir = new File(path);
        			if(!dir.exists()) {//如果目录不存在，我就创建
        				dir.mkdir();
        			}
        			
        			path = path + File.separator + new Date().getTime()+"_"+fileName;
        			File f=new File(path);
        			file.getFileItem().write(f);//将临时文件，向真实文件写入内容
   
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
}
