package koujiao.com.oops.common.base

import android.util.Log
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.QueryListener
import koujiao.com.oops.common.base.OOPSRequest.RequestCallBack
import koujiao.com.oops.common.entity.bmob.Lover

/**
 * @Author: KouJiao
 * @Description: 网络请求的接口
 * @Date:  2017/11/27 - 11:19
 */
class ApiManage {
    companion object {
        val TAG = "ApiManage"
        val instance = ApiManage()
    }

    /**
     * @Author: koujiao
     * @Description: 校验登录
     * @Date: 2017/11/28 - 16:01
     * @param:  * @legal 密码
     */
    fun checkLogin(legal: String,callBack: RequestCallBack<Lover>){
        try {
            val query = BmobQuery<Lover>()
            query.addWhereEqualTo(Common.Params.LEGAL, legal)
            query.findObjects(object : FindListener<Lover>() {
                override fun done(p0: MutableList<Lover>?, p1: BmobException?) {
                    if (p1 == null) {
                        if (p0?.size == 0) throw OOPSException(Common.MsgCode.ERROR_1001) //用户不存在
                        //用户只有一个
                        callBack.succeed(p0?.get(0))
                    } else {
                        Log.e(TAG, "${Common.Method.CHECK_LOGIN}异常 status:${p1.errorCode} - msg:${p1.message}")
                        throw OOPSException(Common.MsgCode.ERROR_1001) //用户不存在
                    }
                }
            })
        } catch (e: Exception) {
            callBack.error(Common.MsgCode.ERROR_1001.statusCode,Common.MsgCode.ERROR_1001.msg)
        }
    }

    /**
     * @Author: koujiao
     * @Description: 获取另一个用户的数据
     * @Date: 2018/2/23 - 15:38
     * @param:  * @objectId
     */
    fun queryLoverBySignature(signature: String?,callBack: RequestCallBack<Lover>){
        try {
            signature?:throw OOPSException(Common.MsgCode.ERROR_1002)
            val query = BmobQuery<Lover>()
            query.getObject(signature, object : QueryListener<Lover>() {
                override fun done(p0: Lover, p1: BmobException?) {
                    if (p1 == null) callBack.succeed(p0)
                    else {
                        Log.e(TAG, "${Common.Method.CHECK_LOGIN}异常 status:${p1.errorCode} - msg:${p1.message}")
                        throw OOPSException(Common.MsgCode.ERROR_1000)
                    }
                }
            })
        } catch (e: Exception) {
            callBack.error(Common.MsgCode.ERROR_1000.statusCode,Common.MsgCode.ERROR_1000.msg)
        }
    }
}


