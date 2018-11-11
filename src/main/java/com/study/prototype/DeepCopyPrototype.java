/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.prototype;

import java.io.*;

/**
 * 这是一个深度复制的例子
 *
 * @author Cll
 * @date 2018/10/16 10:27
 * @since 1.0.0
 */

public class DeepCopyPrototype implements Cloneable, Serializable {
    private static final long serialVersionUID  = 1L;
    private String string;

    private SerializableObject obj;

    public Object clones() throws CloneNotSupportedException{
        DeepCopyPrototype prototype = (DeepCopyPrototype) super.clone();
        return prototype;
    }

    public Object deepClone() throws IOException,ClassNotFoundException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(oos);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString(){
        return string;
    }
    public void setString(String string){
        this.string = string;
    }
    public SerializableObject getObj(){
        return obj;
    }
    public void setObj(SerializableObject obj){
        this.obj = obj;
    }

//要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}