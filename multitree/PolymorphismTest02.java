// 抽象一个人类作为父类
class Person {
    String name;

    public void classes() {}
    public void doWork() {}
}
// 学生类
class Students extends Person {
    Students(String myName) {
        this.name = myName;
    }
    // 子类重写父类方法，覆盖了父类方法
    public void classes() {
        System.out.println(this.name + "在听课");
    }
    // 子类重写父类方法，覆盖了父类方法
    public void doWork() {
        System.out.println(this.name + "在写作业");
    }
    // 子类独有方法
    public void playing() {
        System.out.println(this.name + "在玩游戏");
    }
}
// 老师类
class Teachers extends Person {
    Teachers(String myName) {
        this.name = myName;
    }
    // 子类重写父类方法，覆盖了父类方法
    public void classes() {
        System.out.println(this.name + "在上课");
    }
    // 子类重写父类方法，覆盖了父类方法
    public void doWork() {
        System.out.println(this.name + "在改作业");
    }
    // 子类独有方法
    public void shopping() {
        System.out.println(this.name + "在逛街");
    }
}
public class PolymorphismTest02 {
    public static void main(String[] args) {
        //此处发生多态
        Person s = new Students("张三");
        Person t = new Teachers("李四");
        s.classes();
        s.doWork();
        //s.playing();
        // 无法调用students特有的方法，这时需要向下转型
        //s.playing();
        trans(s);

        // 同理Teachers
        t.classes();
        t.doWork();
        trans(t);
    }
    // 这个函数能很好的体现出为什么需要用instancof，
    // 因为你不能确定传入函数的参数到底是Teachers还是Students
    public static void trans(Person p) {
        if (p instanceof Students) {
            Students s2 = (Students)p;
            // 通过向下转型便可以调用Students特有方法了
            s2.playing();
        }
        else if (p instanceof Teachers) {
            Teachers t2 = (Teachers)p;
            t2.shopping();
        }
    }
}
