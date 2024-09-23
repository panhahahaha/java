package Generics;

public class example
{
    public static void main(String [] args){}
}
class GenericsVarable<T>{
    private T item;
    public void setItem(T item){
        this.item = item;
    }
    public T getItem(){
        return this.item;
    }
    public static void main(String[] args) {
        // 创建存储字符串的 Box 实例
        GenericsVarable<String> stringBox = new GenericsVarable<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());

        // 创建存储整数的 Box 实例
        GenericsVarable<Integer> intBox = new GenericsVarable<>();
        intBox.setItem(123);
        System.out.println(intBox.getItem());
    }
}
