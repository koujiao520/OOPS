package koujiao.com.oops.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_head.view.*
import koujiao.com.oops.R
import koujiao.com.oops.common.base.BaseActivity
import koujiao.com.oops.common.base.OOPSApplication

/**
 * @Author: KouJiao
 * @Description: 主界面
 * @Date:  2017/11/10 - 13:00
 */
class MainActivity : BaseActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initData() {
        //获得子布局的View
        val leftHead = View.inflate(this@MainActivity,R.layout.user_head,nav_main_left)
        val rightHead = View.inflate(this@MainActivity,R.layout.user_head,nav_main_right)
        //填充头像 为空时使用默认头像
        Glide.with(this).load(OOPSApplication.instance.currentLover!!.headUrl.run { if (this.isNullOrEmpty()) R.drawable.img_user else this }).into(img_main_left)
        Glide.with(this).load(OOPSApplication.instance.currentLover!!.headUrl.run { if (this.isNullOrEmpty()) R.drawable.img_user else this }).into(leftHead.user_head_img)
        Glide.with(this).load(OOPSApplication.instance.anotherLover!!.headUrl.run { if (this.isNullOrEmpty()) R.drawable.img_user else this }).into(img_main_right)
        Glide.with(this).load(OOPSApplication.instance.anotherLover!!.headUrl.run { if (this.isNullOrEmpty()) R.drawable.img_user else this }).into(rightHead.user_head_img)
        //填充用户名称
        leftHead.user_head_name.text = OOPSApplication.instance.currentLover!!.nickName
        rightHead.user_head_name.text = OOPSApplication.instance.anotherLover!!.nickName
        //选择默认的菜单
        nav_main_right.setCheckedItem(R.id.user_call)
    }

    override fun initListener() {
        super.initListener()
        img_main_left.setOnClickListener(this@MainActivity)
        img_main_right.setOnClickListener(this@MainActivity)
    }
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.img_main_left -> dl_main.openDrawer(GravityCompat.START)
            R.id.img_main_right -> dl_main.openDrawer(GravityCompat.END)
        }
    }
}
