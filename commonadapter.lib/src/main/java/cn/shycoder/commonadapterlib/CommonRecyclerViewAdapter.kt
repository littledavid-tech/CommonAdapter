package cn.shycoder.commonadapterlib

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import javax.sql.DataSource

/**
 * Created by ShyCoder on 9/28/2018.
 */
abstract class CommonRecyclerViewAdapter<T>(val context:Context,val dataSource: MutableList<T> , val layoutResId:Int): RecyclerView.Adapter<CommonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommonViewHolder {
        return CommonViewHolder.createInstance(context,null,parent,layoutResId,0)
    }

    override fun getItemCount(): Int {
        return this.dataSource.size
    }

    override fun onBindViewHolder(holder: CommonViewHolder?, position: Int) {
        holder!!.currentPosition= position
        bindData(holder,this.dataSource[position])
    }

    abstract  fun bindData(holder: CommonViewHolder,each:T)

}