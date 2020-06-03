package patterns.command.tv;

import patterns.command.Command;

/**
 * @ClassName: LightOffCommand
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:50
 */
public class TVOffCommand implements Command {
    //聚合LightReceiver
    TVReceiver tvReceiver;

    public TVOffCommand(TVReceiver tvReceiver){
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        tvReceiver.off();
    }

    @Override
    public void undo() {
        tvReceiver.on();
    }
}
