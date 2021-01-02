import java.awt.*;

public class WindowApp {

    public static void main(String[] args){

        Window w1 = new Window("w1");
        Point point  = new Point(2,2);
        Window w2 = new Window("w2",15,10,"blue",point);

        w1.printWindow();
        w2.printWindow();

        w1.move(point);
        w1.printWindow();

        w2.resize(30,20);
        w2.printWindow();
    }
}
