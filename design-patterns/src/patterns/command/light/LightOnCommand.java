package patterns.command.light;

import patterns.command.Command;

/**
 * @ClassName: LightOnCommand
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:47
 */
public class LightOnCommand implements Command {
    //聚合LightReceiver
    LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver){
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}
