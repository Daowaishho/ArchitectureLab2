package question12;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Component resources1 = new Video("数学");
        Component resources2 = new Powerpoint("英语");
        Component resources3 = new EBook("日本語");
        Teacher teacher = new Teacher();
        Component group1 = teacher.createGroup("分组1");
        Component group2 = teacher.createGroup("分组2");
        teacher.addComponent(resources3, group1);
        teacher.addComponent(resources2, group1);
        teacher.addComponent(resources1, group2);

        Component group3 = teacher.createGroup("分组3");
        teacher.addComponent(group2, group3);
        teacher.addComponent(group1, group3);

        teacher.deleteComponent(resources1);
        teacher.moveComponent(resources2,group2);
        teacher.publishResources(group3);
    }
}

class Teacher {
    public void addComponent(Component sourceComponent, Component desComponent) {
        desComponent.add(sourceComponent);
    }

    public Group createGroup(String groupName) {
        return new Group(groupName);
    }

    public void publishResources(Component component) {
        component.publish();
    }

    public void deleteComponent(Component component) {
        component.delete();
    }

    public void moveComponent(Component sourceComponent, Component desComponent) {
        sourceComponent.moveTo(desComponent);
    }
}

abstract class Component {
    private String name;

    private Component fatherComponent;

    public Component(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setFatherComponent(Component component) {
        this.fatherComponent = component;
    }

    public Component getFatherComponent() {
        return this.fatherComponent;
    }

    public abstract void publish();

    public abstract void add(Component component);

    public abstract void removeChild(Component component);

    public abstract void delete();

    public abstract void moveTo(Component component);

    public abstract Component getChild(int i);
}

abstract class Resources extends Component{

    public Resources(String name){
        super(name);
    }

    public abstract void publish();

    public void add(Component component) {
        System.out.println("学习资源不支持add方法");
    }

    public  void removeChild(Component component) {
        System.out.println("学习资源不支持removeChild方法");
    }

    public void delete() {
        this.getFatherComponent().removeChild(this);
        this.setFatherComponent(null);
    }

    public void moveTo(Component component) {
//        移动的目的地只能是组
        if (component.getClass().getSimpleName().equals("Group")) {
            this.getFatherComponent().removeChild(this);
            this.setFatherComponent(component);
            component.add(this);
            System.out.println("成功将名为"+this.getName()+"的Resource移动到名为"+component.getName()+"的Group");

        }
        else {
            System.out.println("移动失败，移动的目的地只能是组");
        }
    }

    public Component getChild(int i) {
        System.out.println("学习资源不支持add方法");
        return null;
    }
}

class Video extends Resources{
    public Video(String name) {
        super(name);
    }

    public void publish() {
        System.out.println("发布了Video类型的名为"+ this.getName() + "的学习资源");
    }
}

class Powerpoint extends Resources{
    public Powerpoint(String name) {
        super(name);
    }

    public void publish() {
        System.out.println("发布了Powerpoint类型的名为"+ this.getName() + "的学习资源");
    }
}

class EBook extends Resources{
    public EBook(String name) {
        super(name);
    }

    public void publish() {
        System.out.println("发布了EBook类型的名为"+ this.getName() + "的学习资源");
    }
}

class Group extends Component{
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    public Group(String name) {
        super(name);
    }

    public void publish() {
        System.out.println("正在分发名为"+this.getName()+"分组下的资源");
        for (Component component : componentArrayList) {
            component.publish();
        }
    }

    public void add(Component component) {
        component.setFatherComponent(this);
        this.componentArrayList.add(component);
    }

    public void removeChild(Component component) {
        this.componentArrayList.remove(component);
    }

    public void delete() {
        this.setFatherComponent(null);
        Component fatherComponent = this.getFatherComponent();
        fatherComponent.removeChild(this);
        for (Component component : componentArrayList) {
            component.delete();
        }
    }

    public void moveTo(Component component) {
//        移动的目的地只能是组
        if (component.getClass().getSimpleName().equals("Group")) {
            Component fatherComponent = this.getFatherComponent();
            fatherComponent.removeChild(this);
            this.setFatherComponent(null);
            fatherComponent.removeChild(this);
            this.setFatherComponent(component);
            component.add(this);
            System.out.println("成功将名为"+this.getName()+"的Group移动到名为"+component.getName()+"的Group");
        }
        else {
            System.out.println("移动失败，移动的目的地只能是组");
        }
    }

    public Component getChild(int i) {
        return componentArrayList.get(i);
    }
}
