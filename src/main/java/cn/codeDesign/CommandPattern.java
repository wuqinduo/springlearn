package cn.codeDesign;

/**
 * 命令模式： 本质都是解耦
 *
 *  各司其职，是这个社会追求。人类追求的高效工作方式。
 *
 *  解耦与关联相互并存。
 *
 *  一个餐厅里的设计模式：（但凡是一个小型的社会。就蕴含很多的知识）
 *  一个大学里的设计模式？？？
 *
 *  框架：Hystrix  典型的熔断器模式
 */
public class CommandPattern {

    /**
     * 命令模式：
     *          热菜厨师：做热菜，做凉菜
     *
     *
     *          服务员脑子里记住了。什么菜让谁做。
     *
     *          客户点菜：
     */

    //一处逻辑就好比一个微型的餐馆. 有哪些角色。是你设计分析的方向
    public static void main(String[] args) {
        Receiver receiver = new Receiver();//厨师

        Invoker invoker = new Invoker();//客服

        Command hotCommand  = new HotCommand(receiver);//
        Command coolCommand = new CoolCommand(receiver);//

        invoker.execute(hotCommand);
        invoker.execute(coolCommand);
    }
}

interface Command{
    public void execute();
}

//具体的命令映射到具体某一个人
class HotCommand implements Command{
    private Receiver cook;

    public HotCommand(Receiver cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.cookHot();
    }
}

class CoolCommand implements Command{
    private Receiver receiver;

    public CoolCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.cookCool();
    }
}

//命令的接受者，
class Receiver{
    public void cookHot(){
        System.out.println("做热菜");
    }

    public void cookCool(){
        System.out.println("做凉菜");
    }
}
//命令的调用
class Invoker{
    public void execute(Command command){
        command.execute();
    }
}