package koujiao.com.oops.common.base

import android.app.Activity
import java.util.*

/**
 * @Author: KouJiao
 * @Description: Activity的控制器
 * @Date:  2017/11/10 - 14:02
 */
class ActivityController {
    companion object {
        //存放activity的数组
        var activities = ArrayList<Activity>()
    }


    /**
     * @Author: koujiao
     * @Description: 添加activity到activities中
     * @Date: 2017/11/10 - 14:07
     * @param:  * @activity 需要添加的activity
     */
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    /**
     * @Author: koujiao
     * @Description: 删除activities中的activitiy
     * @Date: 2017/11/10 - 14:10
     * @param:  * @activity
     */
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    /**
     * @Author: koujiao
     * @Description: 循环杀死activities中未被杀死的activity 然后清空activities
     * @Date: 2017/11/10 - 14:14
     * @param:  * @param null
     */
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) activity.finish()
        }
        activities.clear()
    }
}