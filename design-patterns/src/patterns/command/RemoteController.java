package patterns.command;

/**
 * @ClassName: RemoteController
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:53
 */
public class RemoteController {
    //开按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    //撤销命令
    Command undoCommand;

    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }
    public void setCommand(int no , Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    };
    //开启
    public void onButtonWasPushed(int no){
        //找到按下的
        onCommands[no].execute();
        //记录操作
        undoCommand = onCommands[no];
    }
    //关闭
    public void offButtonWasPushed(int no){
        //找到按下的
        offCommands[no].execute();
        //记录操作
        undoCommand = offCommands[no];
    }
    //撤销
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
