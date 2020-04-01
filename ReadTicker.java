import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

public class ReadTicker {

    public Double getCurrentStockValue(String ticker) {
        Double stkValue = 0.0;
        try {
            File stkFile = new File("/Users/gkaepernick/Desktop/stkFile.txt");
            BufferedReader buff = new BufferedReader(new FileReader(stkFile));

            HashMap<String, Double> stockMap = new HashMap<String, Double>();
            String st;
            while((st = buff.readLine()) != null) {
                String[] tick;
                tick = st.split("\t", 2);
                Double value = Double.parseDouble(tick[1]);
                stockMap.put(tick[0], value);
            }
            stkValue = stockMap.get(ticker);

            buff.close();
        } catch (FileNotFoundException except) {
            System.out.println("You threw an exception");
        } catch (IOException except) {
            System.out.println("You threw an exception");
        }

        return stkValue;
    }
}