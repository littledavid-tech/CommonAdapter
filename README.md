# CommonAdapter

### Introduction

一个通用的Android ListView和RecyclerView的是配置，学习自hongyang大神，Kotlin语言描述。

这是一个自用的类库，会不断地向里面添加方法。

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

### Thanks

非常感谢hongyang大神的无私教学:

* https://blog.csdn.net/lmj623565791/ hongyang大神的博客
* https://www.imooc.com/learn/372 hongyang大神慕课网视频