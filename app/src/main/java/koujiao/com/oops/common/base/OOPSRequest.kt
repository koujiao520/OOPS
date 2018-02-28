package koujiao.com.oops.common.base

import cn.bmob.v3.BmobObject

/**
 * @Author: KouJiao
 * @Description:
 * @Date:  2018/2/23 - 17:37
 */
class OOPSRequest {
    interface RequestCallBack<in T : BmobObject> {
        fun succeed(data: T?)
        fun error(statusCode: Int, msg: String?)
    }
}