package com.beng.stack;

public class MyStack {

    private String[] stack; // 栈
    private int count; // 当前栈
    private int size; // 栈的大小

    public MyStack(int size) {
        super();
        this.stack = new String[size];
        this.count = 0;
        this.size = size;
    }

    public boolean push(String data) {
        if (count >= size)
            return false;
        stack[count] = data;
        ++count;
        return true;
    }

    public String pop() {

        if (count == 0) {
            return null;
        }
        String data = stack[count - 1];
        --count;
        return data;
    }

}
