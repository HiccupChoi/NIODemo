package com.email;

import com.aes.AESUtil;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendEamil {

    public static void main(String[] args) throws Exception {
 
        String verifyCode="验证码";
        String toEmailAddress="328674758@qq.com";
        //邮件主题
        String emailTitle = "【xxx】邮箱验证";
        //邮件内容
        String emailContent = "您正在【xxx】进行邮箱验证，您的验证码为：" + verifyCode + "，请于2分钟内完成验证！";
        //发送邮件
        sendEmail(toEmailAddress, emailTitle, emailContent);
}
 
    private static void sendEmail(String toEmailAddress, String emailTitle, String emailContent) throws Exception {
 
        Properties props = new Properties();
 
        // 开启debug调试
        props.setProperty("mail.debug", "true");
 
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
 
        // 端口号465/587
        props.put("mail.smtp.port", 465);
 
        // 设置邮件服务器主机名
        // 邮件服务器主机名
        // QQ邮箱的 SMTP 服务器地址为: smtp.qq.com
        String myEmailSMTPHost = "smtp.qq.com";
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
 
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
 
        //SSL认证，腾讯邮箱是基于SSL加密的，所以需要开启才可以使用
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
 
        //设置是否使用ssl安全连接（一般都使用）
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
 
        //创建会话
        Session session = Session.getInstance(props);
 
        //获取邮件对象
        //发送的消息，基于观察者模式进行设计的
        Message msg = new MimeMessage(session);
 
        //设置邮件标题
        msg.setSubject(emailTitle);

        //设置显示的发件时间
        msg.setSentDate(new Date());
 
        //设置邮件内容
        msg.setText(getContent(emailContent));
 
        //设置发件人邮箱
        // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //发件人邮箱
        String myEmailAccount = "1078903711@qq.com";
        msg.setFrom(new InternetAddress(myEmailAccount, "Hiccup", "UTF-8"));
 
        //得到邮差对象
        Transport transport = session.getTransport();
 
        //连接自己的邮箱账户
        //密码不是自己QQ邮箱的密码，而是在开启SMTP服务时所获取到的授权码
        //connect(host, user, password)
        //发件人邮箱密码（授权码）
        //在开启SMTP服务时会获取到一个授权码，把授权码填在这里
        String myEmailPassword = AESUtil.encrypt("I/ZGPjkvAQnSNam0cz0Ju2swz07EwZCllraHekZPb94=", "UTF-8", "AES/CBC/PKCS5Padding", "businessinfo1119", "businessinfo1119") ;
        transport.connect(myEmailSMTPHost, myEmailAccount, myEmailPassword);
 
        //发送邮件
        transport.sendMessage(msg, new Address[]{new InternetAddress(toEmailAddress)});
 
        //将该邮件保存到本地
//        OutputStream out = new FileOutputStream("MyEmail.eml");
//        msg.writeTo(out);
//        out.flush();
//        out.close();
 
        transport.close();
    }

    //设置邮件内容
    private static String getContent(String emailContent){
        //使用StringBuilder，因为StringBuilder加载速度会比String快，而且线程安全性也不错
        StringBuilder builder = new StringBuilder();

        //定义要输出日期字符串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //写入内容
        //在内容后加入邮件发送的时间
        builder.append("\n").append(emailContent).append("\n时间：").append(sdf.format(new Date()));

        return builder.toString();
    }
 
}