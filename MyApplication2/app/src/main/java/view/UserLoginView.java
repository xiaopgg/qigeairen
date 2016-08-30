package view;

import entity.User;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface UserLoginView {
    String getUsername();
    String getPwd();
    void showFailMsg();
    void toMain(User user);
}
