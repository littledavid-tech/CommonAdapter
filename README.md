# CommonAdapter

### Introduction

一个通用的Android ListView和RecyclerView的是配置，学习自hongyang大神，Kotlin语言描述。

这是一个自用的类库，会不断地向里面添加方法。

如果你有任何需要欢迎大家pr或者反馈

### Attribute

通过这个类能够简化ListView和RecyclerView的Adapter的创建.

ListView:

```kotlin
val list = mutableListOf<Person>()
(1..100).forEach {
    list.add(Person("LD$it","Signature$it"))
}

lvTemp.adapter = object :CommonAdapter<Person>(this,list,R.layout.listview_item_temp){
    override fun bindData(holder: CommonViewHolder, each: Person) {
        holder.setText(R.id.tvName,each.name)
                .setText(R.id.tvSignature,each.signature)
                .setBitmapRes(R.id.ivHead,R.drawable.head)
    }
}
```



RecyclerView

```kotlin
val list = mutableListOf<Person>()
(1..100).forEach {
    list.add(Person("LD$it","Signature$it"))
}

rvTemp.layoutManager = LinearLayoutManager(this)
rvTemp.adapter = object :  CommonRecyclerViewAdapter<Person>(this,list,R.layout.listview_item_temp){
    override fun bindData(holder: CommonViewHolder, each: Person) {
        holder.setText(R.id.tvName,each.name)
                .setText(R.id.tvSignature,each.signature)
                .setBitmapRes(R.id.ivHead,R.drawable.head)
    }
}
```



### Method

| Method Name                              | Description                              |
| ---------------------------------------- | ---------------------------------------- |
| setText(viewId: Int, text: String)       | 设置文本                                     |
| setTextColor(viewId: Int, colorString: String) | 设置文字颜色(colorString 颜色值 比如: #0c0c0c)      |
| setTextColor(viewId: Int, color: Int     | 设置文字颜色(colorString 颜色值 比如: 0xffffff)     |
| setTextColorRes(viewId: Int, colorResId: Int) | 设置文字颜色(colorString 颜色值 比如: R.color.colorPrimary |
| setBackgroundColor(viewId: Int, colorString: String) | 设置背景颜色(参数解释同 setTextColor方法)             |
| setBackgroundColor(viewId: Int, color: Int) | 设置背景颜色(参数解释同 setTextColor方法)             |
| setBackgroundColorRes(viewId: Int, colorResId: Int) | 设置背景颜色(参数解释同 setTextColor方法)             |
| setBitmapRes(viewId: Int, bitmapResId: Int) | 为ImageView设置bitmap (bitmapResId: 资源ID)   |
| setBitmap(viewId: Int, bitmap: Bitmap)   | 为ImageView设置bitmap                       |
| setBackground(viewId: Int, drawable: Drawable) | 设置背景                                     |
| setBackground(viewId: Int, drawableResId: Int) | 设置背景                                     |
| setChecked(viewId: Int, checked: Boolean) | 设置 RadioButton或者CheckBox的Checked         |
| setOnClickListener(viewId: Int, onClickListener: View.OnClickListener) | 设置点击事件                                   |
| setOnLongClickListener(viewId: Int, onLongClickListener: View.OnLongClickListener) | 设置长点击事件                                  |
| setOnCheckedChanged(viewId: Int, onCheckedChangeListener: CompoundButton.OnCheckedChangeListener) | 设置Checked改变事件                            |

### Thanks

非常感谢hongyang大神的无私教学:

* https://blog.csdn.net/lmj623565791/ hongyang大神的博客
* https://www.imooc.com/learn/372 hongyang大神慕课网视频