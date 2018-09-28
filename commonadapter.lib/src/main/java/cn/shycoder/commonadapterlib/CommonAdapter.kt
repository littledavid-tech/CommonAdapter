package cn.shycoder.commonadapterlib

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by ShyCoder on 9/28/2018.
 */
abstract class CommonAdapter<T>(
        private val context: Context,
        private val dataSource: MutableList<T>,
        private val layoutResId: Int) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder = CommonViewHolder.createInstance(context, convertView, parent, layoutResId, position)
        bindData(holder, dataSource[position])
        return holder.itemView
    }

    override fun getItem(position: Int): T {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.dataSource.size
    }

    protected abstract fun bindData(holder: CommonViewHolder, each: T)

}