package peresenter;



import android.os.Handler;

import biz.OnLoginListener;
import biz.UserLoginBiz;
import biz.UserLoginBizImpl;
import entity.User;
import view.UserLoginView;

/**
 * Created by Administrator on 2016/8/30.
 */
public class UserLoginPeresenter extends BasePesenter<UserLoginView>{
    private UserLoginBiz mUserLoginBiz;
  //  private UserLoginView mLoginView;
    private Handler mHandler = new Handler();


    public UserLoginPeresenter(UserLoginView mUserLoginView){
        this.mUserLoginBiz= new UserLoginBizImpl();
    }
    public void login(){
        mUserLoginBiz.login(mViewRef.get().getUsername(),mViewRef.get().getPwd(), new OnLoginListener() {
            @Override
            public void loginsucc(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mViewRef.get().toMain(user);
                    }
                });
            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mViewRef.get().showFailMsg();
                    }
                });
            }
        });
    }

}
