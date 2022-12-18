package question10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Component member1 = new Member();
        Component member2 = new Member();
        Component member3 = new Member();
        Component member4 = new Member();
        Component group1 = new Group();
        group1.add(member1);
        group1.add(member2);
        Component group2 = new Group();
        group2.add(group1);
        group2.add(member3);
        group2.add(member4);
        group2.share();
    }
}

abstract class Component {
    public abstract void share();

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract Component getChild(int i);
}

class Member extends Component{

    @Override
    public void share() {
        System.out.println("收到了信息");
    }

    @Override
    public void add(Component component) {
        System.out.println("不支持该方法");
    }

    @Override
    public void remove(Component component) {
        System.out.println("不支持该方法");
    }

    @Override
    public Component getChild(int i) {
        System.out.println("不支持该方法");
        return null;
    }
}

class Group extends Component{
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    @Override
    public void share() {
        for (Component component : componentArrayList) {
            component.share();
        }
    }

    @Override
    public void add(Component component) {
        this.componentArrayList.add(component);
    }

    @Override
    public void remove(Component component) {
        this.componentArrayList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return this.componentArrayList.get(i);
    }
}
