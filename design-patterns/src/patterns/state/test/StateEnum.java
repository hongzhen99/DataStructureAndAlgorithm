package patterns.state.test;

/**
 * @ClassName: StateEnum
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/2 23:17
 */
public enum StateEnum {
    BEGIN(1,"BEGIN"),

    SHENHE(2,"SHENHE"),

    FABU(3,"FABU"),

    END(4,"END");

    private int key;
    private String value;

    StateEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
