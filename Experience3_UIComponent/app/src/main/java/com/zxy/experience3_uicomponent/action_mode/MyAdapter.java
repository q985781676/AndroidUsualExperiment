package com.zxy.experience3_uicomponent.action_mode;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxy.experience3_uicomponent.R;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**0
 * 自定义的基于BaseAdapter    的适配器
 */
public class MyAdapter extends BaseAdapter {

    List<Item> list;//item的list对象
    Context context;//上下文对象

    //初始化
    public MyAdapter(List<Item> list, Context context) {
        this.context = context;
        this.list = list;
        //列表同步方法
        notifyDataSetChanged();
    }

    //得到当前列表的选项数量
    @Override
    public int getCount() {
        return list.size();
    }

    //根据下标得到列表项
    @Override
    public Item getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        //如果还没加载
        if(convertView==null){
            //加载布局文件，并将各个选项以及每个选项中的内容一一对应
            convertView=View.inflate(context, R.layout.style_actionmodel, null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.imageView);
            viewHolder.textView=convertView.findViewById(R.id.action_model_data);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        //得到十六进制的颜色的int值
        int green = Color.parseColor("#00FF00");
        int white = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(position).getName());
        //如果被选中，那么改变选中颜色
        if(list.get(position).getBo() == true){
            viewHolder.textView.setBackgroundColor(green);
            viewHolder.imageView.setBackgroundColor(green);
        }
        else {
            viewHolder.textView.setBackgroundColor(white);
            viewHolder.imageView.setBackgroundColor(white);
        }
        return convertView;

    }

    //创建内部类，定义每一个列表项所包含的东西，这里是每个列表项都有一个imageView和textView。
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
