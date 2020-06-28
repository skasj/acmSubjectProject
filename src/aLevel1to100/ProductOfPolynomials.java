package aLevel1to100;

import java.util.*;

public class ProductOfPolynomials {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Double> dataA = getListOfData(scanner);
        Map<Integer, Double> dataB = getListOfData(scanner);
        SortedMap<Integer, Double> dataC = multipartResult(dataA,dataB);
        StringBuffer stringBuffer = new StringBuffer();
        dataC.remove(0);
        int count =0;
        for (SortedMap.Entry<Integer,Double> temp:dataC.entrySet()){
            if (temp.getValue() != 0){
                count++;
                stringBuffer.append(" ").append(temp.getKey()).append(" ").append(String.format("%.1f", temp.getValue()));
            }
        }
        System.out.print(count);
        System.out.print(stringBuffer);
    }

    private static Map<Integer, Double> getListOfData(Scanner scanner) {
        Map<Integer, Double> doubleMap = new HashMap<>();
        int k = scanner.nextInt();
        while (k > 0) {
            k--;
            doubleMap.put(scanner.nextInt(), scanner.nextDouble());
        }
        return doubleMap;
    }

    private static SortedMap<Integer, Double> multipartResult(Map<Integer, Double> dataA, Map<Integer, Double> dataB){
        SortedMap<Integer, Double> dataC = new TreeMap<>(
                Comparator.reverseOrder());
        for (Map.Entry<Integer,Double> a:dataA.entrySet()){
            for (Map.Entry<Integer,Double> b:dataB.entrySet()){
                int key = a.getKey() + b.getKey();
                double value = a.getValue() * b.getValue();
                dataC.merge(key, value, (a1, b1) -> a1 + b1);
            }
        }
        return dataC;
    }
}
