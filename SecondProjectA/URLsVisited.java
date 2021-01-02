import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class URLsVisited {

    private ArrayList<String> myURLs = new ArrayList<String>();
    public String FileName = "";
    public String site = null ;
    private boolean isSorted = false;


    public URLsVisited(String fileName){
            this.FileName = fileName;
        try {
            FileInputStream myFile = new FileInputStream(this.FileName);

            DataInputStream in = new DataInputStream(myFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));



            while ((site = br.readLine())!=null){
                String[] urlPartition = site.split("/");
                if(urlPartition[0].matches("https:")){
                     site = urlPartition[2];
                }else {
                     site = urlPartition[0];
                }
                myURLs.add(site);


            }
            System.out.print("\nThe File analysed is: \n" + FileName + "\n");


            in.close();

        } catch (FileNotFoundException e) {
            System.out.print(e.toString()+"\n");
            System.out.print("Cannot find the file: " +fileName + " Please enter a valid path and file name.\n");

        } catch (IOException ignored) {

        }
    }

    public void removeDuplicates(){
        if (myURLs.isEmpty()) {

        } else {

            System.out.print("\nThe unique visited websites are : " + "\n");
            Set<String> set = new HashSet<>(myURLs);
            myURLs.clear();
            myURLs.addAll(set);
            myURLs.sort(null);
            isSorted = true;
        }
    }

    public void printAll() {
            if (myURLs.isEmpty()) {

            } else if(!isSorted){
                System.out.print("\nThe visited websites are : " + "\n");

                for (String Url : myURLs) {
                    System.out.print(Url + "\n");
                }
            }else if(isSorted) {
                for (String Url : myURLs) {
                    System.out.print(Url + "\n");
                }
            }

    }
}

