package biz;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface UserLoginBiz {
    public void login(String username,String pwd,OnLoginListener listener);
}
