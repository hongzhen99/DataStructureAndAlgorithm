package suanfa.type2.queue;

import java.util.Scanner;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 23:26
 */
public class Test {
    public static void main(String[] args) {
        MyQueueDemo queue = new MyQueueDemo(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        while (true){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(addQueue):添加");
            System.out.println("o(outQueue):出队列");
            System.out.println("h(headQueue):查看队列头");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    return;
                case 'a':
                    System.out.printf("输入一个数字:");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'o':
                    queue.outQueue();
                    break;
                case 'h':
                    int i = queue.headQueue();
                    System.out.println(i);
                    break;
            }
            System.out.println("======================");

        }
    }
}
