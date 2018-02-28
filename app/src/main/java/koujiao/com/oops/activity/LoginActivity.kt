package koujiao.com.oops.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import koujiao.com.oops.R
import koujiao.com.oops.common.base.*
import koujiao.com.oops.common.entity.bmob.Lover

/**
 * @Author: KouJiao
 * @Description:验证登录的界面
 * @Date:  2017/11/10 - 14:39
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    /**
     * @Author: koujiao
     * @Description: 登录按钮的点击事件
     * @Date: 2017/11/29 - 9:53
     */
    fun login(view: View) {
        if (!isLegal()) return // 验证必填项
        val legal = edit_login.text.toString()
        //将用户存入缓存
        this.let {
            ApiManage.instance.checkLogin(legal, object : OOPSRequest.RequestCallBack<Lover> {
                override fun succeed(data: Lover?) {
                    OOPSApplication.instance.currentLover = data
                    ApiManage.instance.queryLoverBySignature(OOPSApplication.instance.currentLover!!.signature, object : OOPSRequest.RequestCallBack<Lover> {
                        override fun succeed(data: Lover?) {
                            OOPSApplication.instance.anotherLover = data
                            startActivity(Intent(it, MainActivity::class.java)) //进入主界面
                        }

                        override fun error(statusCode: Int, msg: String?) {
                            showToast("Error-- code:$statusCode msg:$msg --")
                        }
                    })
                }

                override fun error(statusCode: Int, msg: String?) {
                    showToast("Error-- code:$statusCode msg:$msg --")
                }
            })
        }
    }


    override fun isLegal(): Boolean {
        when ("") {
            edit_login.text.toString() -> {
                showToast(Common.Legal.LEGAL_1000)
            }
            else -> {
                return true
            }
        }
        return false
    }


}