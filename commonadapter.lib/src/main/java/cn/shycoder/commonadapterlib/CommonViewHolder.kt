package cn.shycoder.commonadapterlib

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

/**
 * Created by ShyCoder on 9/28/2018.
 */
class CommonViewHolder
private
constructor(
        private val context: Context,
        val layoutId: Int,
        position: Int,
        itemView: View) : RecyclerView.ViewHolder(itemView) {

    //存放所有View的容器
    private var mViews: SparseArray<View> = SparseArray()

    /**当前的位置*/
    var currentPosition: Int = -1

    init {
        this.currentPosition = position
        itemView.tag = this
    }

    private fun <T : View> getView(viewId: Int): T {
        if (this.mViews[viewId] == null) {
            mViews.append(viewId, itemView.findViewById(viewId))
        }
        return mViews[viewId] as T
    }

    /**************************************************************
     * Holder的操作方法开始
     * ************************************************************/

    fun setText(viewId: Int, text: String): CommonViewHolder {
        getView<TextView>(viewId).text = text
        return this
    }


    //颜色相关的方法
    /*设置文字颜色*/
    /**
     * 设置文字的颜色
     * @param View ID
     * @param colorString 颜色值 比如: #0c0c0c
     * */
    fun setTextColor(viewId: Int, colorString: String): CommonViewHolder {
        this.getView<TextView>(viewId).setTextColor(Color.parseColor(colorString))
        return this
    }

    /**
     * 设置文字的颜色
     * @param View ID
     * @param colorString 颜色值 比如: 0xffffff
     * */
    fun setTextColor(viewId: Int, color: Int): CommonViewHolder {
        this.getView<TextView>(viewId).setTextColor(color)
        return this
    }

    /**
     * 设置文字的颜色
     * @param View ID
     * @param colorString 颜色值 比如: R.color.colorPrimary
     * */
    fun setTextColorRes(viewId: Int, colorResId: Int): CommonViewHolder {
        this.getView<TextView>(viewId).setTextColor(context.resources.getColor(colorResId))
        return this
    }

    /*设置文字颜色结束*/

    /*设置背景颜色开始*/
    /**
     * 设置背景色
     * @param View ID
     * @param colorString 颜色值 比如: #0c0c0c
     * */
    fun setBackgroundColor(viewId: Int, colorString: String): CommonViewHolder {
        this.getView<View>(viewId).setBackgroundColor(Color.parseColor(colorString))
        return this
    }

    /**
     * 设置背景颜色
     * @param View ID
     * @param colorString 颜色值 比如: 0xffffff
     * */
    fun setBackgroundColor(viewId: Int, color: Int): CommonViewHolder {
        this.getView<View>(viewId).setBackgroundColor(color)
        return this
    }

    /**
     * 设置背景颜色
     * @param View ID
     * @param colorString 颜色值 比如: R.color.colorPrimary
     * */
    fun setBackgroundColorRes(viewId: Int, colorResId: Int): CommonViewHolder {
        this.getView<View>(viewId).setBackgroundColor(context.resources.getColor(colorResId))
        return this
    }

    /*设置背景颜色结束*/


    /*设置bitmap*/

    fun setBitmapRes(viewId: Int, bitmapResId: Int): CommonViewHolder {
        getView<ImageView>(viewId).setImageResource(bitmapResId)
        return this
    }

    fun setBitmap(viewId: Int, bitmap: Bitmap): CommonViewHolder {
        getView<ImageView>(viewId).setImageBitmap(bitmap)
        return this
    }

    /*设置bitmap结束*/

    /*设置背景drawable开始*/

    fun setBackground(viewId: Int, drawable: Drawable): CommonViewHolder {
        this.getView<View>(viewId).background = drawable
        return this
    }

    fun setBackground(viewId: Int, drawableResId: Int): CommonViewHolder {
        this.getView<View>(viewId).setBackgroundResource(drawableResId)
        return this
    }


    /*设置背景drawable结束*/

    fun setChecked(viewId: Int, checked: Boolean): CommonViewHolder {
        this.getView<CompoundButton>(viewId).isChecked = checked
        return this
    }

    /**************************************************************
     * Holder的操作方法结束
     * ************************************************************/


    /**************************************************************
     * Holder为View注册事件方法开始
     * ************************************************************/

    fun setOnClickListener(viewId: Int, onClickListener: View.OnClickListener): CommonViewHolder {
        this.getView<View>(viewId).setOnClickListener(onClickListener)
        return this
    }

    fun setOnLongClickListener(viewId: Int, onLongClickListener: View.OnLongClickListener): CommonViewHolder {
        this.getView<View>(viewId).setOnLongClickListener(onLongClickListener)
        return this
    }

    fun setOnCheckedChanged(viewId: Int, onCheckedChangeListener: CompoundButton.OnCheckedChangeListener): CommonViewHolder {
        this.getView<CompoundButton>(viewId).setOnCheckedChangeListener(onCheckedChangeListener)
        return this
    }

    /**************************************************************
     * Holder为View注册事件方法结束
     * ************************************************************/
    companion object {
        fun createInstance(_content: Context,
                           _convertView: View?,
                           _parent: ViewGroup?,
                           _layoutResId: Int,
                           _position: Int
        ): CommonViewHolder {
            return if (_convertView == null) {
                val view = LayoutInflater.from(_content).inflate(_layoutResId, _parent, false)
                val holder = CommonViewHolder(_content, _layoutResId, _position, view)

                holder
            } else {
                val holder = _convertView.tag as CommonViewHolder
                holder.currentPosition = _position
                holder
            }
        }
    }
}