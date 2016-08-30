package biz;

import entity.User;

/**
 * Created by Administrator on 2016/8/30.
 */
public class UserLoginBizImpl implements UserLoginBiz {
    @Override
    public void login(String username, String pwd, OnLoginListener listener) {
        if(username.equals("lp")&& pwd.equals("123")){
            User user = new User();
            user.setUsername(username);
            user.setPwd(pwd);
            listener.loginsucc(user);
        }else{
            listener.loginFail();
        }
    }
}
