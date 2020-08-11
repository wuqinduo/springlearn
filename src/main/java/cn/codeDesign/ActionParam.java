package cn.codeDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * 多方法---》策略模式---》匿名内部类----》java行为参数化
 */
public class ActionParam {

    public static void main(String[] args) {
        List<Apple> myapple = new ArrayList<>();
        //固定写死
        filterColorApple(myapple);

        //传参多方法
        filterColorApple(myapple,"green");
        filterWeightApple(myapple,70);


        //策略模式（虽然灵活，但是代码量多，冗余代码很多，需要为每个策略预先定义一个实现类型）
        AppleColorPredicate colorPredicate =  new AppleColorPredicate();
        AppleWeightPredicate weightPredicate =  new AppleWeightPredicate();
        filterApples(myapple,colorPredicate);
        filterApples(myapple,weightPredicate);

        //使用匿名内部类升华下策略模式
        filterApples(myapple, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        //再升华下策略模式(行为参数化)
        filterApples(myapple,apple -> "red".equals(apple.getColor()));
    }

    //第一阶段
    public static List<Apple> filterColorApple(List<Apple> list){
        List<Apple> result = new ArrayList<>();
        for (Apple apple :list){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
    public static List<Apple> filterColorApple(List<Apple> list, String color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple :list){
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
    public static List<Apple> filterWeightApple(List<Apple> list,int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple :list){
            if(weight == apple.getWeight()){
                result.add(apple);
            }
        }
        return result;
    }
    //... 各种属性???

    //第二阶段
    public static List<Apple> filterApples(List<Apple> list,  ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: list){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    //第三阶段


}
interface ApplePredicate{//断言
    boolean test(Apple apple);
}
class AppleColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return false;
    }
}

class AppleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return false;
    }
}

class Apple{
    String color;
    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}