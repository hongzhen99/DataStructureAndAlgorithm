package patterns.command.tv;

import patterns.command.Command;

/**
 * @ClassName: LightOnCommand
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:47
 */
public class TVOnCommand implements Command {
    //聚合LightReceiver
    TVReceiver tvReceiver;

    public TVOnCommand(TVReceiver tvReceiver){
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        tvReceiver.on();
    }

    @Override
    public void undo() {
        tvReceiver.off();
    }
}
