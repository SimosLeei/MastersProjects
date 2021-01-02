import java.io.*;

public class SupermarketSalesToFile extends SupermarketSales {

    static String supermarketname ;
    private String poli;
    public SupermarketSalesToFile(double[][] sales) {
        super(sales);
    }

    public static void setSupermarketname(String Supermarketname){
       supermarketname = Supermarketname;


    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getPoli() {
        return poli;
    }

    @Override
    public void getKatastimataSales() {
        File StoreLog = null;
        FileWriter StoreLogWriter =null;
        StoreLog = new File("B:\\EAP Masters\\PLS50\\IntelijIDEA\\SecondProjectB\\" + getPoli() + ".txt");

        try {
            StoreLogWriter = new FileWriter(StoreLog.getName());
            StoreLogWriter.write("Supermarket: " + supermarketname +"\n"+"City: " + getPoli()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0; i<sales.length; i++){


            double sum = 0;
            for(int j=0; j<sales[0].length;j++) {
                sum = sum +sales[i][j];
             }
            try {
                StoreLogWriter.write("Store no: " + i + "\n Total income is: "+Double.toString(sum) +"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try {
                StoreLogWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



