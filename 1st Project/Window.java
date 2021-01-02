import java.awt.*;

public class Window {

    Point Point;
    String Name;
    String Color;
    double Height;
    double Width;

       public Window(String name){
        this.Name= name;
           this.Color = "";
           this.Height = 0;
           this.Width = 0;
           this.Point = new Point(0,0);
    }

    public Window(String name, double height, double width, String color, Point point) {
        this.Name = name;
        this.Color = color;
        this.Height = height;
        this.Width = width;
        this.Point = point;
    }


    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public double getHeight() {
        return Height;
    }

    public double getWidth() {
        return Width;
    }

    public void resize(double height, double width){
           this.Width =  width;
           this.Height = height;
    }
    public void move(Point p){
        this.Point = p;

    }

    public double isSquare(){
           if (this.Height==this.Width){
               return this.Height * Math.sqrt(2);
           }else{
               return -1;
           }
    }

    public void printWindow(){
           System.out.println("************************ \n"
                   +"Name: "+this.Name +"\n"
                   +"Height and Width: " +this.Height+" and "+ this.Width + " respectively \n"
                   + "Color: "+this.Color +"\n"
                   + "Point: " +"("+String.format("%.0f", this.Point.getX())+","+String.format("%.0f", this.Point.getY())+")  \n************************ \n " );
    }
}
