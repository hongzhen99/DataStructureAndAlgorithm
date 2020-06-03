package patterns.decorator.type1;

import patterns.decorator.type1.coffee.LongBlack;
import patterns.decorator.type1.drink.Drink;
import patterns.decorator.type1.peiliao.Milk;

import java.io.*;
import java.util.Arrays;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 0:25
 */
public class Client implements Serializable{
    private int id = 10;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //点一份
        Drink longBlack = new LongBlack();
        System.out.println("longBlack价格"+longBlack.cost());
        //加一份牛奶
        longBlack = new Milk(longBlack);
        System.out.println(""+longBlack.getDes());
        System.out.println("加入牛奶后的价格"+longBlack.cost());

        new Client().aaa();
    }
    public void aaa() throws IOException, ClassNotFoundException {
        //被装饰者
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        //装饰者
        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
        //序列化
        objectOut.writeObject(this);
        System.out.println(Arrays.toString(byteArrayOut.toByteArray()));
        //反序列化
        ByteArrayInputStream byteArrayIn  =  new ByteArrayInputStream(byteArrayOut.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayIn);
        Client object = (Client) objectInputStream.readObject();
        System.out.println(object.id);

        objectOut.close();
        byteArrayOut.close();
        byteArrayIn.close();
        objectInputStream.close();
    }
}
