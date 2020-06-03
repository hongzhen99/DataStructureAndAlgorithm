package suanfa.type8HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: A_HashTableDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/25 17:15
 */
public class A_HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        hashTable.add(new Emp(1,"zs"));
        hashTable.add(new Emp(8,"zs"));
        hashTable.add(new Emp(2,"ls"));
        hashTable.list();
        hashTable.findById(9);
        Map map = new HashMap();
        map.put("1","1");


    }
}
class HashTable{
    int size;
    private LinkedListEmp[] hashTable;

    public HashTable(int size){
        this.size =size;
        hashTable = new LinkedListEmp[size];
        //这里初始化每一条链表
        for (int i = 0; i< size;i++) {
            hashTable[i] = new LinkedListEmp();
        }
    }
    public void add(Emp emp) {
        //根据员工的id 得到该员工要加入的位置
        int empLinkedNum = hashFun(emp.id);
        //添加
        hashTable[empLinkedNum].add(emp);
    }
    //遍历所有的哈希表  数组+链表
    public void list(){
        for (int i=0; i<size ;i++){
            if (hashTable[i]!= null)
                System.out.print("第"+i+"个");
                hashTable[i].list();
        }
    }
    //
    public void findById(int id){
        //使用散列函数 确定是哪条链表
        int v = hashFun(id);
        Emp byId = hashTable[v].findById(id);
        System.out.println(byId);
    }
    //编写一个散列函数,
    public int hashFun(int id) {
        return id % size;
    }
}

//创建链表
class LinkedListEmp{
    //头指针  指向第一个emp
    private Emp head;

    public void add(Emp emp) {
        //如果是第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是
        Emp cur = head;
        while (true){
            if(cur.next == null)
                break;
            cur = cur.next; //后移
        }
        cur.next = emp;
    }
    //遍历
    public void list(){
        if(head == null){
            System.out.println("空");
            return;
        }
        System.out.print("当前链表信息:");
        Emp cur = head;
        while (true){
            System.out.print(cur);
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }
    //根据id查找
    public Emp findById(int id) {
        if (head == null)
            return null;
        Emp cur = head;
        while (true) {
            if(id == cur.id) {
                break;
            }
            if (cur.next == null){
                cur =  null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}
//表示一个员工
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}