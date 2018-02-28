package koujiao.com.oops.common.base

/**
 * @Author: KouJiao
 * @Description: 常量接口
 * @Date: 2017/11/28 - 10:59
 */
interface Common {
    /**
    * @Author: koujiao
    * @Description: 云逻辑方法名
    * @Date: 2017/11/28 - 11:03
    */
    interface Method{
        companion object{
            val CHECK_LOGIN = "checkLogin"
        }
    }
    /**
    * @Author: koujiao
    * @Description: 参数名
    * @Date: 2017/11/28 - 11:04
    */
    interface Params{
        companion object {
            val LEGAL = "legal" //验证登录的验证密码
        }
    }

    interface Legal{
        companion object {
            val LEGAL_1000 = "请输入登录密码"
        }
    }

    enum class MsgCode(val msg: String, val statusCode: Int){
        ERROR_1000("服务器异常",1000),
        ERROR_1001("验证失败，验证密码不存在",1001),
        ERROR_1002("参数为空",1002)
    }
}
