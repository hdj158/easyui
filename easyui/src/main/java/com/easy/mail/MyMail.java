package com.easy.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.easy.vo.User;

@Component  
public class MyMail {  
  
    private JavaMailSenderImpl email;  
      
    private SimpleMailMessage message;  
      
    
      
    //发送邮件  
    public void send(User user,String code){     
        message.setTo("13350780038@qq.com");  
        message.setSubject("WOW 邮箱激活");  
        message.setText("您好"+user.getUserName()+"!  您的邮箱验证码:"+code);  
        email.send(message);  
    }  
}  

