package cn.shycoder.commonadapter.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.CheckBox
import android.widget.RadioButton
import cn.shycoder.commonadapterlib.CommonAdapter
import cn.shycoder.commonadapterlib.CommonRecyclerViewAdapter
import cn.shycoder.commonadapterlib.CommonViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Person>()
        (1..100).forEach {
            list.add(Person("LD$it", "Signature$it"))
        }

//      lvTemp.adapter = object :CommonAdapter<Person>(this,list,R.layout.listview_item_temp){
//          override fun bindData(holder: CommonViewHolder, each: Person) {
//              holder.setText(R.id.tvName,each.name)
//                      .setText(R.id.tvSignature,each.signature)
//                      .setBitmapRes(R.id.ivHead,R.drawable.head)
//          }
//      }

        rvTemp.layoutManager = LinearLayoutManager(this)
        rvTemp.adapter = object : CommonRecyclerViewAdapter<Person>(this, list, R.layout.listview_item_temp) {
            override fun bindData(holder: CommonViewHolder, each: Person) {
                holder.setText(R.id.tvName, each.name)
                        .setText(R.id.tvSignature, each.signature)
                        .setBitmapRes(R.id.ivHead, R.drawable.head)
                        .setBackgroundColor(R.id.tvName, "#0c0c0c")
            }
        }
    }
}
