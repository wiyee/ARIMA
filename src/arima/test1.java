package arima;

import java.io.*;
import java.util.*;

public class test1 {

    public static void main(String args[]) {
        Scanner ino = null;
        Map<String,Integer> map = new LinkedHashMap<>();
        try {

//            FileInputStream inputstream = new FileInputStream("C:\\Users\\wiyee\\Desktop\\huawei\\huawei\\data_2015_12.txt");
//            StringBuffer buffer = new StringBuffer();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream,"utf-8"));
//            String line = reader.readLine();
//            while(line!=null){
//                String[] tmp = line.split("\t");
//                String date = tmp[2].substring(0,10);
//                if (tmp[1].equals("flavor8")){
//                    if (map.containsKey(date)){
//                        int count = map.get(date);
//                        map.put(date,count+1);
//                    }
//                    else
//                        map.put(date,1);
//                }
//                line = reader.readLine();
//            }
            ArrayList<Double> arraylist = new ArrayList<Double>();
            ino = new Scanner(new File(System.getProperty("user.dir") + "/data/test.txt"));
            while (ino.hasNext()) {
                arraylist.add(Double.parseDouble(ino.next()));
            }
            double[] dataArray = new double[arraylist.size() - 1];
            for (int i = 0; i < arraylist.size() - 1; i++)
                dataArray[i] = arraylist.get(i);

            //System.out.println(arraylist.size());

            ARIMA arima = new ARIMA(dataArray);

            int[] model = arima.getARIMAmodel();
            System.out.println("Best model is [p,q]=" + "[" + model[0] + " " + model[1] + "]");
            System.out.println("Predict value=" + arima.aftDeal(arima.predictValue(model[0], model[1])));
            System.out.println("Predict error=" + (arima.aftDeal(arima.predictValue(model[0], model[1])) - arraylist.get(arraylist.size() - 1)) / arraylist.get(arraylist.size() - 1) * 100 + "%");

            //	String[] str = (String[])list1.toArray(new String[0]);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ino.close();
        }
    }


}
