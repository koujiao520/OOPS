package koujiao.com.oops.common.base

/**
 * @Author: KouJiao
 * @Description: OOPS的异常类
 * @Date:  2017/11/28 - 16:54
 */
class OOPSException: Exception {
    var statusCode: Int = 0
    var msg: String = ""
    constructor(msgCode: Common.MsgCode){
        this.statusCode = msgCode.statusCode
        this.msg = msgCode.msg
    }
}