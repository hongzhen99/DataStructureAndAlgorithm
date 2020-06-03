package patterns.state;

/**
 * ״̬������
 * @author Administrator
 *
 */
public abstract class State {

	
	// 扣除积分- 50
    public abstract void deductMoney();

    //抽奖
    public abstract boolean raffle();

    // 发奖品
    public abstract  void dispensePrize();

}
