package patterns.prototype.type1;

import java.io.*;

/**
 * @ClassName: Prototype
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 10:53
 * 原型类
 */

public class Prototype implements Cloneable ,Serializable{
    private String name;
    private int age;
    private String color;
    public Per per;


    public String getName() {
        return name;
    }

    public Prototype setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Prototype setAge(int age) {
        this.age = age;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Prototype setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype)super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return prototype;
    }

    public Object copy(){
        ByteArrayOutputStream bos ;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Prototype copy = (Prototype) ois.readObject();
            ois.close();
            bis.close();
            oos.close();
            bos.close();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
