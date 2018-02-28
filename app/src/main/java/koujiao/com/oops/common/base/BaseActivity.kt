package koujiao.com.oops.common.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

/**
 * @Author: KouJiao
 * @Description: activity基类
 * @Date:  2017/11/10 - 13:35
 */
abstract class BaseActivity : AppCompatActivity() {
    companion object {
        /**
         * @Author: koujiao
         * @Description: 退出app
         * @Date: 2017/11/10 - 14:20
         */
        fun quitApp() {
            ActivityController().finishAll()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //日志输出当前的Activity
        d("BaseActivity")
        ActivityController().addActivity(this)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        //初始化数据 初始化监听
        initData()
        initListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityController().removeActivity(this)
    }

    /**
    * @Author: koujiao
    * @Description: 填充数据
    * @Date: 2018/2/23 - 16:17
    */
    open fun initData() {
        d("initData")
    }
    /**
    * @Author: koujiao
    * @Description: 初始化监听
    * @Date: 2018/2/24 - 11:42
    */
    open fun initListener(){
        d("initListener")
    }


    /**
     * @Author: koujiao
     * @Description: 日志输入的方法
     * @Date: 2017/11/10 - 13:38
     * @param:  * @msg 需要输入的消息
     */
    fun i(msg: String) {
        Log.d(this::class.java.simpleName, msg)
    }

    fun d(msg: String) {
        Log.d(this::class.java.simpleName, msg)
    }

    fun w(msg: String) {
        Log.d(this::class.java.simpleName, msg)
    }

    fun e(msg: String) {
        Log.d(this::class.java.simpleName, msg)
    }

    /**
     * @Author: koujiao
     * @Description: Toast提示的
     * @Date: 2017/11/10 - 13:52
     * @param:  * @msg 需要提示的消息
     */
    fun Context.showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    /**
     * @Author: koujiao
     * @Description: 验证必填方法
     * @Date: 2017/11/28 - 11:16
     */
    open fun isLegal(): Boolean{
        return false
    }


}