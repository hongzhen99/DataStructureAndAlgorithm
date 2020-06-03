package suanfa.type2.ringqueue;


import java.util.Scanner;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/14 0:30
 */
public class Run {
    public static void main(String[] args) {
        RingQueue queue = new RingQueue(4);
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
                    try {
                        queue.showQueue();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    return;
                case 'a':
                    try {
                        System.out.printf("输入一个数字:");
                        int num = scanner.nextInt();
                        queue.addQueue(num);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'o':
                    try {
                        queue.outQueue();
                    }catch (Exception e){
                        e.getMessage();
                    }
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
