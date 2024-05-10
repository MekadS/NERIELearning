package in.nic.NERIELearning.helper;

import cn.apiclub.captcha.Captcha;
import in.nic.NERIELearning.config.CaptchaUtil;
import in.nic.NERIELearning.model.Userlogin;

public class CaptchaHelper {
    
      public static void getCaptcha(Userlogin userlogin) {
        try {
            Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
            userlogin.setHiddenCaptcha(captcha.getAnswer());
            userlogin.setCaptcha(""); // value entered by the User
            userlogin.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));
        } catch (Exception e) {
            throw new RuntimeException("Captcha cannot be generated!");
        }

    }
}
