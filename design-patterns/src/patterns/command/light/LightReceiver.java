package patterns.command.light;

import patterns.command.Command;

/**
 * @ClassName: LightReceiver
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:48
 */
//台灯的控制
public class LightReceiver {
    public void on(){

        class Aaa implements Command{

            @Override
            public void execute() {
                System.out.println("开");
            }

            @Override
            public void undo() {
                System.out.println("关");
            }
        }
        executes(new Aaa());
    }

    public void off(){
        System.out.println("点灯关闭了。。。");
    }

    public void executes(Command command){
        command.execute();
    }
}
