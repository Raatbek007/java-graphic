import javax.swing.*;
import  java.awt.*;

public class Calculate {

    float a, b, c,y,xStart,xEnd,accuracy;

    int fid;

    Calculate(Func ob) {
        
        this.a = ob.a;
        this.b = ob.b;
        this.c = ob.c;
        this.fid = ob.fid;
        this.xStart = ob.xStart;
        this.xEnd = ob.xEnd;
        this.accuracy = ob.accuracy;



    }

    public float rangeY(){

        float y_min = calculateY(xStart), y_max = calculateY(xStart),y;

        for(float x=xStart;x<=xEnd;x+=(float)(xEnd-xStart)/100000) {
            y = calculateY(x);

            if (y > y_max){
                y_max = y;
            }
            else if(y < y_min){

                y_min = y;
            }

        }
       return  2*( (Math.abs(y_min) < Math.abs(y_max))? Math.abs(y_max): Math.abs(y_min));
    }

    public float rangeX(){
        return 2*( (Math.abs(xStart) < Math.abs(xEnd))? Math.abs(xEnd): Math.abs(xStart));
    }
   
    public float calculateY(float x)
    {
        if (fid==1) {


            y = a * x +   b + c;

            return y;
        }
        else if (fid==2) {

            y = a * x*x + b*x - c;

           return y;

        }
        else if (fid==3) {

            y = a * x*x*x +  b*x*x + c;

            return y;
        }

        return  0;

    }




    public float findRoot()
    {
        float ans = xStart;



            while (true)
            {
                // Find middle point
                ans = (xStart+xEnd)/2;

                // Check if middle point is root
                if (Math.abs(calculateY(ans)) <= accuracy)
                    break;

                    // Decide the side to repeat the steps
                else if (calculateY(ans)*calculateY(xStart) <= 0)
                    xEnd = ans;
                else
                    xStart = ans;


                System.out.println("there is infinii cycly\n");
            }
            //prints value of c upto 4 decimal places
            return ans;
    }





}
