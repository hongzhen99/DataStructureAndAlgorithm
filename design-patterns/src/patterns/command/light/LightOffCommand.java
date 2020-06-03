package patterns.command.light;

import patterns.command.Command;

/**
 * @ClassName: LightOffCommand
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:50
 */
public class LightOffCommand implements Command {
    //聚合LightReceiver
    LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver){
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}
