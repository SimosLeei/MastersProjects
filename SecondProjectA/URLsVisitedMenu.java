

import java.io.File;
import java.util.Scanner;

public class URLsVisitedMenu {
    public static void main(String[] args) {

        menu();

    }

    public static int menu(){
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("1. Input the name of the file containing URLs you want to analyze\n" +
                    "2. Input the path of the directory containing the files you to want to analyze for URLs\n" +
                    "3. Exit\n" +
                    "Which is your choice?");
            try{

                choice = Integer.parseInt(keyboard.next());
                if(choice!=1&&choice!=2&&choice!=3) {
                    throw new MenuException("");
                }
                switch (choice) {
                    case 1:
                        System.out.print("Type the name of the file you want to analyze: \n");
                        String file = keyboard.next();
                        URLsVisitedApp.FileAnalyzer(file);
                        break;
                    case 2:

                        System.out.print("Type the path of the directory: \n");

                        String[] FileArray;
                        String FolderPath = keyboard.next();
                        File folder;
                        folder = new File(FolderPath);
                        if(!folder.isDirectory()){
                            if(!folder.exists()){
                                System.out.print("Folder doesn't exist.\n");
                            }else{
                                System.out.print("Is not a folder.  \n");
                            }
                        }else{
                            FileArray = folder.list();
                            for(int i = 0; i<FileArray.length; i++) {
                                URLsVisitedApp.FileAnalyzer(folder.getAbsolutePath()+"/" + FileArray[i]);

                            }
                        }

                        break;
                    case 3:
                        System.exit(10);
                }

            } catch(MenuException e) {
                System.out.print(e.toString() + "\n");
                System.out.print("Please enter an Integer number from 1 to 3. \n ");
            }catch (NumberFormatException e){
                System.out.print(e.toString()+"\n" );
                System.out.print("Wrong format, please enter an Integer number from 1 to 3."+"\n" );

            }

        }while(choice!=3 );

        return choice;
    }
}
