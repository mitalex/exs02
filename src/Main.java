import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AbstractMap.SimpleEntry res = calcFun(10);
        System.out.println("Result:" +res.toString());
        System.out.println("Key:"+res.getKey());
        System.out.println("Value:"+res.getValue());
    }

    public static AbstractMap.SimpleEntry<List<Integer>, List<Double>> calcFun(int _max) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Double> y = new ArrayList<>();
        for(int i=1; i< _max; i++){
            // создаём Х
            int _x = i;
            x.add(_x);
            // расчитываем значение функции У от Х
            double _y = Math.pow(_x, 2);
            y.add(_y);
        }
//        System.out.println(y);
        return new HashMap.SimpleEntry(x,y);
    }
}

