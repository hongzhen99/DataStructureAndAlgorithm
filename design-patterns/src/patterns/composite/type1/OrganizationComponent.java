package patterns.composite.type1;

/**
 * @ClassName: OrganizationComponent
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/18 14:39
 */
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    protected void add(OrganizationComponent organizationComponent){

    }
    protected void remove(OrganizationComponent organizationComponent){

    }

    protected abstract void print();

}
