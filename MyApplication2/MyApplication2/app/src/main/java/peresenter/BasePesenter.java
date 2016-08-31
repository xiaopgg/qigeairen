package peresenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/8/30.
 */
public abstract class BasePesenter <T>{
    protected Reference<T> mViewRef;

    public void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }
    protected T get(){
        return mViewRef.get();
    }

    public boolean isAttached(){
        return mViewRef!=null && mViewRef.get()!=null;
    }
    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef=null;
        }
    }
}
