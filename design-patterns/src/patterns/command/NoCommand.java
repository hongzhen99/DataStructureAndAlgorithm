package patterns.command;

/**
 * @ClassName: NoCommand
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/31 13:51
 */
//空命令
public class NoCommand implements Command{
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
