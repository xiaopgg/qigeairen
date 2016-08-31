package biz;

import entity.User;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface OnLoginListener {
    public void loginsucc(User user);
    public  void loginFail();

}

