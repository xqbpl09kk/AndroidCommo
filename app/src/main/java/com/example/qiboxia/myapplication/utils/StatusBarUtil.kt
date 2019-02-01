package com.example.qiboxia.myapplication.utils

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.FloatRange
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import java.util.regex.Pattern

/**
 * 状态栏透明
 */

object StatusBarUtil {


        private var DEFAULT_COLOR = 0
        private var DEFAULT_ALPHA = 0f//Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 0.2f : 0.3f;
        private val MIN_API = 19

        /** 判断是否Flyme4以上  */
        private val isFlyme4Later: Boolean
            get() = (Build.FINGERPRINT.contains("Flyme_OS_4")
                    || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4")
                    || Pattern.compile("Flyme OS [4|5]", Pattern.CASE_INSENSITIVE).matcher(Build.DISPLAY).find())

        /** 判断是否为MIUI6以上  */
        private val isMIUI6Later: Boolean
            @SuppressLint("PrivateApi")
            get() {
                return try {
                    val clz = Class.forName("android.os.SystemProperties")
                    val mtd = clz.getMethod("get", String::class.java)
                    var `val` = mtd.invoke(null, "ro.miui.ui.version.name") as String
                    `val` = `val`.replace("[vV]".toRegex(), "")
                    val version = Integer.parseInt(`val`)
                    version >= 6
                } catch (e: Exception) {
                    false
                }

            }

        @JvmOverloads
        fun immersive(activity: Activity, color: Int = DEFAULT_COLOR, @FloatRange(from = 0.0, to = 1.0) alpha: Float = DEFAULT_ALPHA) {
            immersive(activity.window, color, alpha)
        }

        fun immersive(window: Window) {
            immersive(window, DEFAULT_COLOR, DEFAULT_ALPHA)
        }

        @JvmOverloads
        fun immersive(window: Window, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1f) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = mixtureColor(color, alpha)

                var systemUiVisibility = window.decorView.systemUiVisibility
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.decorView.systemUiVisibility = systemUiVisibility
            } else if (Build.VERSION.SDK_INT >= 19) {
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                setTranslucentView(window.decorView as ViewGroup, color, alpha)
            } else if (Build.VERSION.SDK_INT >= MIN_API && Build.VERSION.SDK_INT > 19) {
                var systemUiVisibility = window.decorView.systemUiVisibility
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.decorView.systemUiVisibility = systemUiVisibility
            }
        }
        //</editor-fold>

        @TargetApi(Build.VERSION_CODES.M)
//<editor-fold desc="DarkMode">
        fun darkMode(activity: Activity, dark: Boolean) {
            when {
                isFlyme4Later -> darkModeForFlyme4(activity.window, dark)
                isMIUI6Later -> darkModeForMIUI6(activity.window, dark)
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> darkModeForM(activity.window, dark)
            }
        }

        fun lightMode(activity: Activity) {
            lightMode(activity.window, DEFAULT_COLOR, DEFAULT_ALPHA)
        }

        /** 设置状态栏darkMode,字体颜色及icon变黑(目前支持MIUI6以上,Flyme4以上,Android M以上)  */
        fun darkMode(activity: Activity) {
            darkMode(activity.window, DEFAULT_COLOR, DEFAULT_ALPHA)
        }

        fun darkMode(activity: Activity, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
            darkMode(activity.window, color, alpha)
        }

        /** 设置状态栏darkMode,字体颜色及icon变黑(目前支持MIUI6以上,Flyme4以上,Android M以上)  */
        @TargetApi(Build.VERSION_CODES.M)
        fun darkMode(window: Window, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
            when {
                isFlyme4Later -> {
                    darkModeForFlyme4(window, true)
                    immersive(window, color, alpha)
                }
                isMIUI6Later -> {
                    darkModeForMIUI6(window, true)
                    immersive(window, color, alpha)
                }
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                    darkModeForM(window, true)
                    immersive(window, color, alpha)
                }
                Build.VERSION.SDK_INT >= 19 -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    setTranslucentView(window.decorView as ViewGroup, color, alpha)
                }
                else -> immersive(window, color, alpha)
            }
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun lightMode(window: Window, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
            when {
                isFlyme4Later -> {
                    darkModeForFlyme4(window, false)
                    immersive(window, color, alpha)
                }
                isMIUI6Later -> {
                    darkModeForMIUI6(window, false)
                    immersive(window, color, alpha)
                }
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                    darkModeForM(window, false)
                    immersive(window, color, alpha)
                }
                Build.VERSION.SDK_INT >= 19 -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    setTranslucentView(window.decorView as ViewGroup, color, alpha)
                }
                else -> immersive(window, color, alpha)
            }
        }

        //------------------------->

        /** android 6.0设置字体颜色  */
        @RequiresApi(Build.VERSION_CODES.M)
        fun darkModeForM(window: Window, dark: Boolean) {

            var systemUiVisibility = window.decorView.systemUiVisibility
            systemUiVisibility = if (dark) {
                systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            window.decorView.systemUiVisibility = systemUiVisibility

        }

        /**
         * 设置Flyme4+的darkMode,darkMode时候字体颜色及icon变黑
         * http://open-wiki.flyme.cn/index.php?title=Flyme%E7%B3%BB%E7%BB%9FAPI
         */
        fun darkModeForFlyme4(window: Window?, dark: Boolean): Boolean {
            var result = false
            if (window != null) {
                try {
                    val e = window.attributes
                    val darkFlag = WindowManager.LayoutParams::class.java.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                    val meizuFlags = WindowManager.LayoutParams::class.java.getDeclaredField("meizuFlags")
                    darkFlag.isAccessible = true
                    meizuFlags.isAccessible = true
                    val bit = darkFlag.getInt(null)
                    var value = meizuFlags.getInt(e)
                    if (dark) {
                        value = value or bit
                    } else {
                        value = value and bit.inv()
                    }

                    meizuFlags.setInt(e, value)
                    window.attributes = e
                    result = true
                } catch (var8: Exception) {
                    Log.e("StatusBar", "darkIcon: failed")
                }

            }

            return result
        }

        /**
         * 设置MIUI6+的状态栏是否为darkMode,darkMode时候字体颜色及icon变黑
         * http://dev.xiaomi.com/doc/p=4769/
         */
        fun darkModeForMIUI6(window: Window, darkmode: Boolean): Boolean {
            val clazz = window.javaClass
            return try {
                val darkModeFlag: Int
                val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                darkModeFlag = field.getInt(layoutParams)
                val extraFlagField = clazz.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
                extraFlagField.invoke(window, if (darkmode) darkModeFlag else 0, darkModeFlag)
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }

        }
        //</editor-fold>


        /** 增加View的paddingTop,增加的值为状态栏高度  */
        fun setPadding(context: Context, view: View) {
            if (Build.VERSION.SDK_INT >= MIN_API) {
                view.setPadding(view.paddingLeft, view.paddingTop + getStatusBarHeight(context),
                        view.paddingRight, view.paddingBottom)
            }
        }

        /** 增加View的paddingTop,增加的值为状态栏高度 (智能判断，并设置高度) */
        fun setPaddingSmart(context: Context, view: View) {
            if (Build.VERSION.SDK_INT >= MIN_API) {
                val lp = view.layoutParams
                if (lp != null && lp.height > 0) {
                    lp.height += getStatusBarHeight(context)//增高
                }
                view.setPadding(view.paddingLeft, view.paddingTop + getStatusBarHeight(context),
                        view.paddingRight, view.paddingBottom)
            }
        }

        /** 增加View的高度以及paddingTop,增加的值为状态栏高度.一般是在沉浸式全屏给ToolBar用的  */
        fun setHeightAndPadding(context: Context, view: View) {
            if (Build.VERSION.SDK_INT >= MIN_API) {
                val lp = view.layoutParams
                lp.height += getStatusBarHeight(context)//增高
                view.setPadding(view.paddingLeft, view.paddingTop + getStatusBarHeight(context),
                        view.paddingRight, view.paddingBottom)
            }
        }

        /** 增加View上边距（MarginTop）一般是给高度为 WARP_CONTENT 的小控件用的 */
        fun setMargin(context: Context, view: View) {
            if (Build.VERSION.SDK_INT >= MIN_API) {
                val lp = view.layoutParams
                if (lp is ViewGroup.MarginLayoutParams) {
                    lp.topMargin += getStatusBarHeight(context)//增高
                }
                view.layoutParams = lp
            }
        }

        /**
         * 创建假的透明栏
         */
        fun setTranslucentView(container: ViewGroup, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
            if (Build.VERSION.SDK_INT >= 19) {
                val mixtureColor = mixtureColor(color, alpha)
                var translucentView: View? = container.findViewById(android.R.id.custom)
                if (translucentView == null && mixtureColor != 0) {
                    translucentView = View(container.context)
                    translucentView.id = android.R.id.custom
                    val lp = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(container.context))
                    container.addView(translucentView, lp)
                }
                if (translucentView != null) {
                    translucentView.setBackgroundColor(mixtureColor)
                }
            }
        }

        fun mixtureColor(color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float): Int {
            val a = if (color and -0x1000000 == 0) 0xff else color.ushr(24)
            return color and 0x00ffffff or ((a * alpha).toInt() shl 24)
        }

        /** 获取状态栏高度  */
        fun getStatusBarHeight(context: Context): Int {
            var result = 24
            val resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            result = if (resId > 0) {
                context.resources.getDimensionPixelSize(resId)
            } else {
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        result.toFloat(), Resources.getSystem().displayMetrics).toInt()
            }
            return result
        }


        fun setColor(activity: Activity, @ColorInt color: Int, statusBarAlpha: Int) {
            //先设置的全屏模式
            setFullScreen(activity)
            //在透明状态栏的垂直下方放置一个和状态栏同样高宽的view
            addStatusBarBehind(activity, color, statusBarAlpha)
        }

        fun setColor(activity: Activity, @DrawableRes background: Int) {
            //先设置的全屏模式
            setFullScreen(activity)
            //在透明状态栏的垂直下方放置一个和状态栏同样高宽的view
            addStatusBarBehind(activity, background)
        }

        /**
         * 添加了一个状态栏(实际上是个view)，放在了状态栏的垂直下方
         */
        fun addStatusBarBehind(activity: Activity, @ColorInt color: Int, statusBarAlpha: Int) {
            //获取windowphone下的decorView
            val decorView = activity.window.decorView as ViewGroup
            val count = decorView.childCount
            //判断是否已经添加了statusBarView
            if (count > 0 && decorView.getChildAt(count - 1) is StatusBarView) {
                decorView.getChildAt(count - 1).setBackgroundColor(calculateStatusColor(color, statusBarAlpha))
            } else {
                //新建一个和状态栏高宽的view
                val statusView = createStatusBarView(activity, color, statusBarAlpha)
                decorView.addView(statusView)
            }
            setRootView(activity)
        }

        fun addStatusBarBehind(activity: Activity, @DrawableRes background: Int) {
            //获取windowphone下的decorView
            val decorView = activity.window.decorView as ViewGroup
            val count = decorView.childCount
            //判断是否已经添加了statusBarView
            if (count > 0 && decorView.getChildAt(count - 1) is StatusBarView) {
                decorView.getChildAt(count - 1).setBackgroundResource(background)
            } else {
                //新建一个和状态栏高宽的view
                val statusView = createStatusBarView(activity, background)
                decorView.addView(statusView)
            }
            setRootView(activity)
        }

        fun setTranslucentImageHeader(activity: Activity, alpha: Int, needOffsetView: View?) {
            setFullScreen(activity)
            //获取windowphone下的decorView
            val decorView = activity.window.decorView as ViewGroup
            val count = decorView.childCount
            //判断是否已经添加了statusBarView
            if (count > 0 && decorView.getChildAt(count - 1) is StatusBarView) {
                decorView.getChildAt(count - 1).setBackgroundColor(Color.argb(alpha, 0, 0, 0))
            } else {
                //新建一个和状态栏高宽的view
                val statusView = createTranslucentStatusBarView(activity, alpha)
                decorView.addView(statusView)
            }

            if (needOffsetView != null) {
                val layoutParams = needOffsetView.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(0, getStatusBarHeight(activity), 0, 0)
            }

        }


        private fun createTranslucentStatusBarView(activity: Activity, alpha: Int): StatusBarView {
            // 绘制一个和状态栏一样高的矩形
            val statusBarView = StatusBarView(activity)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity))
            statusBarView.layoutParams = params
            statusBarView.setBackgroundColor(Color.argb(alpha, 0, 0, 0))
            return statusBarView
        }

        /**
         * 设置根布局参数
         */
        private fun setRootView(activity: Activity) {
            val rootView = (activity.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
            //rootview不会为状态栏流出状态栏空间
            ViewCompat.setFitsSystemWindows(rootView, true)
            rootView.clipToPadding = true
        }

        private fun createStatusBarView(activity: Activity, color: Int, alpha: Int): StatusBarView {
            // 绘制一个和状态栏一样高的矩形
            val statusBarView = StatusBarView(activity)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity))
            statusBarView.layoutParams = params
            statusBarView.setBackgroundColor(calculateStatusColor(color, alpha))
            return statusBarView
        }

        private fun createStatusBarView(activity: Activity, background: Int): StatusBarView {
            // 绘制一个和状态栏一样高的矩形
            val statusBarView = StatusBarView(activity)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity))
            statusBarView.layoutParams = params
            statusBarView.setBackgroundResource(background)
            return statusBarView
        }

        /**
         * 计算状态栏颜色
         *
         * @param color color值
         * @param alpha alpha值
         * @return 最终的状态栏颜色
         */
        private fun calculateStatusColor(color: Int, alpha: Int): Int {
            val a = 1 - alpha / 255f
            var red = color shr 16 and 0xff
            var green = color shr 8 and 0xff
            var blue = color and 0xff
            red = (red * a + 0.5).toInt()
            green = (green * a + 0.5).toInt()
            blue = (blue * a + 0.5).toInt()
            return 0xff shl 24 or (red shl 16) or (green shl 8) or blue
        }

        fun setFullScreen(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = activity.window
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // 设置透明状态栏,这样才能让 ContentView 向上
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
        }

        class StatusBarView : View {

            constructor(context: Context) : super(context) {}

            constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

            constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}
        }

}