package com.huyy.list;

/**
 *  1. 顺序表
 **/
public class SeqList<Type> {

    private static final int DEFAULT_CAPACITY = 10;//默认长度
    private int size;//当前长度
    private Type[] data;//数组存储

    //构造器
    public SeqList() {
        this.size = 0;
        capScale(DEFAULT_CAPACITY);
    }
    public SeqList(int size) {
        this.size = size;
    }

    //扩容
    private void capScale(int newCapacity) {
        if(newCapacity < size)
            return;
        Type[] old = data;
        data = (Type[])new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            data[i] = old[i];
        }
    }

    //获取元素个数
    public int getSize() {
        return size;
    }

    //获得顺序表的容量
    public int getCapacity() {
        return data.length;
    }

    //查找元素的下标
    public int contain(Type element) {
        for(int i = 0; i < size; i++) {
            if(data[i] == element)
                return i;
        }
        return -1;
    }

    //查询指定下标的元素
    public Type get(int idx) {
        return data[idx];
    }


    //判空
    public boolean isEmpty() {
        return size == 0;
    }

    //判满
    public boolean isFull(){
        return size == data.length;
    }

    //头插
    public void addFirst(Type element) {
        add(0,element);
    }

    //尾插
    public void addLast(Type element) {
        add(size,element);
    }

    //指定下标，插入
    public void add(int idx, Type element) {
        if(size == getCapacity()) {
            capScale(getCapacity() * 2);
        }
        for(int i = size; i > idx; i--) {
            data[i] = data[i-1];
        }
        data[idx] = element;
        size++;
    }

    //头删
    public Type removeFirst() {
        return remove(0);
    }

    //尾删
    public Type removeLast() {
        return remove(size - 1);
    }

    //删除指定下标元素
    public Type remove(int idx) {
        if(isEmpty() || idx >= size)
            throw new IllegalArgumentException("index 不合法");
        Type ret = data[idx];
        if(idx != size - 1) {
            for(int i = idx; i < size; i++) {
                data[i] = data[i+1];
            }
        }
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 != 0) {
            capScale(getCapacity()/2);
        }
        return ret;
    }

    //删除指定元素
    public void delete(Type element) {
        int idx = contain(element);
        if(idx == -1)
            return;
        remove(idx);
    }

}

