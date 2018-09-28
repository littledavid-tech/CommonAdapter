package cn.shycoder.commonadapterlib

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

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

    fun setText(viewId: Int, text: String): CommonViewHolder {
        getView<TextView>(viewId).text = text
        return this
    }

    fun setBitmapRes(viewId: Int, bitmapResId: Int): CommonViewHolder {
        getView<ImageView>(viewId).setImageResource(bitmapResId)
        return this
    }

    fun setBitmap(viewId: Int, bitmap: Bitmap): CommonViewHolder {
        getView<ImageView>(viewId).setImageBitmap(bitmap)
        return this
    }

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