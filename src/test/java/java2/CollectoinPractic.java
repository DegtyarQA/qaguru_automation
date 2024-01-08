package java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectoinPractic {

    public static void main(String[] args) {

        List<String> listStr = new ArrayList<>(10);
        listStr.add(0,"k");
        System.out.println(listStr);


        ArrayList<Double> dobList = new ArrayList<>();
        dobList.add(2.2);
        dobList.add(5.5);
        System.out.println(dobList);

        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("RE", 55);
        stringMap.put("TY", 66);
        System.out.println(stringMap);

    }
}
