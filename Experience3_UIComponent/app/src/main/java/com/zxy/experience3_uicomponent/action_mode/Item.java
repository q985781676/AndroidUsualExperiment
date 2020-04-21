package com.zxy.experience3_uicomponent.action_mode;

/*
 * 列表的每一个选项
 * */
public class Item {
    //显示的选项名
    private String name;
    //记录是否被选中
    private boolean bo;

    //构造函数
    public Item(){
        super();
    }

    //带两个参数的构造函数
    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    //相应的set、get和toString方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}