package koujiao.com.oops.common.entity.bmob
import cn.bmob.v3.BmobObject
import com.google.gson.annotations.SerializedName


/**
 * @Author: KouJiao
 * @Description: 用户类
 * @Date:  2017/11/28 - 14:49
 */
data class Lover(
		//对方的objectId
		@SerializedName("Signature") var signature: String?,
		//用户的校验密码
		@SerializedName("legal") var legal: String?,
		//用户的昵称
		@SerializedName("nickName") var nickName: String?,
		//用户手机
		@SerializedName("phone") var phone: String?,
		//备用手机
		@SerializedName("readyPhone") var readyPhone: String?,
		//性别
		@SerializedName("sex") var sex: String?,
		//头像地址
		@SerializedName("headUrl") var headUrl: String?
):BmobObject()