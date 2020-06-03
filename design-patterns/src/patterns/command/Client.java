package patterns.command;

import patterns.command.light.LightOffCommand;
import patterns.command.light.LightOnCommand;
import patterns.command.light.LightReceiver;
import patterns.command.tv.TVOffCommand;
import patterns.command.tv.TVOnCommand;
import patterns.command.tv.TVReceiver;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 14:02
 */
public class Client {
    public static void main(String[] args) {
        //创建电灯对象
        LightReceiver light = new LightReceiver();
        //创建电灯的开关的命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        //创建电视对象
        TVReceiver tv = new TVReceiver();
        //创建电视的开关的命令
        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        //遥控器
        RemoteController rem = new RemoteController();

        //设置命令 no = 0 为电灯 开关操作
        rem.setCommand(0,lightOnCommand,lightOffCommand);
        rem.setCommand(1,tvOnCommand,tvOffCommand);

        System.out.println("=========灯开按钮=========");
        rem.onButtonWasPushed(0);
        System.out.println("=========灯关按钮=========");
        rem.offButtonWasPushed(0);
        System.out.println("=========撤销按钮=========");
        rem.undoButtonWasPushed();

        System.out.println("=========tv开按钮=========");
        rem.onButtonWasPushed(1);
        System.out.println("=========tv关按钮=========");
        rem.offButtonWasPushed(1);
        System.out.println("=========撤销按钮=========");
        rem.undoButtonWasPushed();
    }
}
