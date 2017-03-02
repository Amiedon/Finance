package com.seu.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件发送的工具类
 * Created by Amie on 2017/3/2.
 */
public class MailUtils {
    /**
     *
     * @param to  给谁发邮件
     * @param code 邮件的激活码
     */
    public static final String HOST = "smtp.163.com";
    public static final String PROTOCOL = "smtp";
    public static final int PORT = 25;
    public static final String FROM = "18816298653@163.com";//发件人的email
    public static final String PWD = "Finance123";//发件人密码

    /**
     * 获取session
     * @return
     */
    public static Session getSession()
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host",HOST);
        properties.put("mail.store.protocol" , PROTOCOL);//设置协议
        properties.put("mail.smtp.port", PORT);//设置端口
        properties.put("mail.smtp.auth" , true);

        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }

        };
        Session session = Session.getDefaultInstance(properties , authenticator);
        return session;
    }
    public static void  sendMail(String to, String code) throws MessagingException {

        Session session = getSession();
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject("来自校园金融的激活邮件");
        message.setContent("<h1>来自校园金融的激活邮件,激活请点击以下链接：</h1><h3><a href='http://localhost:8080/Finance/servlet/ActiveServlet?code="+code+"'>http://localhost:8080/Finance/servlet/ActiveServlet?code="+code+"</a></h3>","text/html;charset=UTF-8");
        Transport.send(message);
        //0.邮箱服务器的用户名 密码
        /*String E_username="";
        String E_password="";
        //1.创建连接对象
        Properties properties = new Properties();
        //properties.setProperty();主机名 本地省略
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(E_username,E_password);
            }
        });
        //2.创建一个邮件对象
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(E_username));//发件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));//收件人
        message.setSubject("来自校园金融的激活邮件");
        message.setContent("<h1>来自校园金融的激活邮件,激活请点击一下链接：</h1><h3><a href='http://localhost:8080/Finance/ActiveServlet?code="+code+"'>http://localhost:8080/Finance/ActiveServlet?code="+code+"</a></h3>","text/html;charset=UTF-8");
        //3.发送一封激活邮件
        Transport.send(message);*/

    }
}
