package OtherDS;

import java.util.Hashtable;

public class HashTables {
    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(105,"Value1");
        table.put(123,"Value2");
        table.put(320,"Value3");
        table.put(550,"Value4");
        table.put(775,"Value5");


        for (Integer key : table.keySet()) {
            System.out.println(key.hashCode() % 10 + "\t" +"key: " + key + "\tvalue: " + table.get(key));
        }



    }
}
