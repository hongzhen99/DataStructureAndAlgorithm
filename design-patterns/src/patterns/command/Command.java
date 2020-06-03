package patterns.command;

/**
 * @ClassName: Command
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:46
 */
//创建命令接口
public interface Command {
    public void execute();
    public void undo();
}
