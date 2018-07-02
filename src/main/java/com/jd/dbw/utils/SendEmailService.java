package com.jd.dbw.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by wuzhengxuan on 2017/10/20.
 */
public class SendEmailService {

    private final static Logger logger = LoggerFactory.getLogger(SendEmailService.class);

//    @Value("${message.email.url}")
    private String sendEmailUrl = "http://mjdos.jd.local/api/notification/sendemail";

//    @Value("${message.email.sys_idx}")
    private Integer sendEmailSysIdx;

    public void sendMessage(String email,String subject, String context){

        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(email);
        emailMessage.setSubject(subject);
        emailMessage.setText(context);

        Map<String, Object> result = HttpUtils.request(sendEmailUrl, "","post", JSONHelper.toJSON(emailMessage), "");
        if(result.get("code").toString().equals("200")){
            try{
                String content = result.get("content").toString();
            }catch (Exception e){
                logger.error("发邮件发生错误");
                writeLog(sendEmailUrl,"",emailMessage,result);
            }
        }else{
            logger.error("发邮件发生错误");
            writeLog(sendEmailUrl,"",emailMessage,result);
        }

    }

    /**
     * 写日志
     * @param skydnsUrl
     * @param apiUrl
     * @param obj
     * @param result
     */
    private void writeLog(String skydnsUrl,String apiUrl,Object obj,Object result){
        logger.error("请求URL是:"+skydnsUrl+apiUrl);
        if(obj!=null){
            logger.error("参数是:"+ JSONHelper.toJSON(obj));
        }
        logger.error("返回值是:"+JSONHelper.toJSON(result));
    }
}
