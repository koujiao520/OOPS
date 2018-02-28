package koujiao.com.oops.common.base

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobConfig
import koujiao.com.oops.common.entity.bmob.Lover

/**
 * @Author: KouJiao
 * @Description:应用的application类
 * @Date:  2017/11/10 - 14:37
 */
class OOPSApplication : Application() {
    companion object {
        //静态实例 充当缓存
        val instance: OOPSApplication = OOPSApplication()
    }
    //当前用户
    var currentLover: Lover? = null
    //另一个用户
    var anotherLover: Lover? = null
    override fun onCreate() {
        super.onCreate()
        //设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        val config =BmobConfig.Builder(this)
        .setApplicationId("8aecd01114529b912db0ceea9cf8e4bf")//设置appkey
        .setConnectTimeout(30) //请求超时时间（单位为秒）：默认15s
        .setUploadBlockSize(1024*1024) //文件分片上传时每片的大小（单位字节），默认512*1024
        .setFileExpiration(2500)//文件的过期时间(单位为秒)：默认1800s
        .build()
        //初始化Bmob
        Bmob.initialize(config)
        //初始化异常处理
        OOPSCrashHandler(this@OOPSApplication)
    }
    /**
     * @Author: koujiao
     * @Description: 异常处理
     * @Date: 2018/2/24 - 17:46
     */
    class OOPSCrashHandler(private val mContext: Context):Thread.UncaughtExceptionHandler{
        companion object {
            val TAG = "OOPSCrashHandler"
        }
        var mDefaultHandler: Thread.UncaughtExceptionHandler? = null
        init {
            //获取系统默认的UncaughtException处理器
            mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
            //设置该CrashHandler为程序的默认处理器
            Thread.setDefaultUncaughtExceptionHandler(this@OOPSCrashHandler)
        }
        override fun uncaughtException(p0: Thread?, p1: Throwable?) {
            if(p1 is OOPSException){
                Toast.makeText(mContext,"Error-- code:${p1.statusCode} msg:${p1.msg} --",Toast.LENGTH_SHORT).show()
            }else{
                Log.e(TAG,p1.toString())
                Toast.makeText(mContext,"很抱歉,程序出现异常,即将退出.",Toast.LENGTH_LONG).show()
                //如果用户没有处理则让系统默认的异常处理器来处
//                mDefaultHandler!!.uncaughtException(p0,p1)
                //退出企业
//                BaseActivity.quitApp()
            }
        }
    }
}