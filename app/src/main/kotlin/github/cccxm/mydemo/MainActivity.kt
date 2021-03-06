package github.cccxm.mydemo

import android.os.Bundle
import android.view.View
import com.squareup.leakcanary.LeakCanary
import com.squareup.picasso.Picasso
import github.cccxm.mydemo.android.adapter.screen.ScreenAdapterActivity
import github.cccxm.mydemo.android.data.app.SaveInstanceActivity
import github.cccxm.mydemo.android.data.net.NetRequestActivity
import github.cccxm.mydemo.android.data.sp.SpActivity
import github.cccxm.mydemo.android.effect.animation.AnimationListActivity
import github.cccxm.mydemo.android.effect.drag.DragListActivity
import github.cccxm.mydemo.android.effect.linkage.LinkageListActivity
import github.cccxm.mydemo.android.extension.mapbox.MapBoxActivity
import github.cccxm.mydemo.android.layout.barrage.BarrageListActivity
import github.cccxm.mydemo.android.layout.flow.FlowListActivity
import github.cccxm.mydemo.android.layout.im.IMLayoutActivity
import github.cccxm.mydemo.android.layout.recycler.RecyclerListActivity
import github.cccxm.mydemo.android.material.bar.AppBarListActivity
import github.cccxm.mydemo.android.ndk.bitmap.NDKBitmapActivity
import github.cccxm.mydemo.android.view.circle.CircleListActivity
import github.cccxm.mydemo.android.view.feature.ViewFeatureActivity
import github.cccxm.mydemo.android.view.image.ImageListActivity
import github.cccxm.mydemo.utils.BaseActivity
import github.cccxm.mydemo.utils.group
import github.cccxm.mydemo.utils.item
import github.cccxm.mydemo.utils.simpleStringGroupAdapter
import org.jetbrains.anko.*

class MainActivity : BaseActivity() {
    private val ui = MainUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.setContentView(this))
        title = "Android"

        if (!LeakCanary.isInAnalyzerProcess(this)) { //打包上线前应该注释
            LeakCanary.install(application)
        }
    }
}

private class MainUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        linearLayout {
            lparams(matchParent, matchParent)
            expandableListView {
                lparams(matchParent, matchParent)
                simpleStringGroupAdapter {
                    group("Material Design") {
                        item("App Bar") { startActivity<AppBarListActivity>() }
                        item("Settings")
                    }
                    group("特效") {
                        item("动画") { startActivity<AnimationListActivity>() }
                        item("联动") { startActivity<LinkageListActivity>() }
                        item("拖动") { startActivity<DragListActivity>() }
                    }
                    group("View") {
                        item("特性") { startActivity<ViewFeatureActivity>() }
                        item("圆形控件") { startActivity<CircleListActivity>() }
                        item("图片显示") { startActivity<ImageListActivity>() }
                        item("对话框")
                    }
                    group("Layout") {
                        item("FlowLayout") { startActivity<FlowListActivity>() }
                        item("RecyclerView") { startActivity<RecyclerListActivity>() }
                        item("IMLayout") { startActivity<IMLayoutActivity>() }
                        item("弹幕实现") { startActivity<BarrageListActivity>() }
                    }
                    group("数据操作") {
                        item("Activity数据保存") { startActivity<SaveInstanceActivity>() }
                        item("SharedPreferences") { startActivity<SpActivity>() }
                        item("网络请求") { startActivity<NetRequestActivity>() }
                        item("数据库")
                        item("联系人")
                    }
                    group("Android通信机制") {
                        item("进程内通信")
                        item("AIDL通信")
                        item("Remote View")
                    }
                    group("NDK") {
                        item("OpenGL ES")
                        item("图片处理") { startActivity<NDKBitmapActivity>() }
                    }
                    group("系统组件") {
                        item("打电话")
                        item("发短信")
                        item("打开浏览器")
                        item("系统分享")
                        item("发送邮件")
                    }
                    group("适配") {
                        item("屏幕适配") { startActivity<ScreenAdapterActivity>() }
                        item("系统适配") {}
                    }
                    group("地图"){
                        item("MapBox") { startActivity<MapBoxActivity>() }
                        item("Google"){}
                    }
                    group("我的扩展") {
                        item("自定义弹幕") { startActivity<BarrageListActivity>() }
                        item("CrazyPlatte")
                    }
                }
            }
        }
    }
}