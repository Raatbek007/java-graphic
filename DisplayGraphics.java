import java.awt.*;
import javax.swing.*;




public class DisplayGraphics extends Canvas {
	float a,b,c,accuracy,xStart,xEnd;
	int id;
    Calculate cal;
    int scaleX,scaleY;
    float y1,y;
    float x;

    int posX,posY ;

    boolean ishteyinbi;
         
    DisplayGraphics(){

    }
    public void setInit(Func ob){



    	this.a = ob.a;
    	this.b = ob.b;
    	this.c = ob.c;
    	this.accuracy = ob.accuracy;
    	this.id =ob.fid;
    	this.xStart = ob.xStart;
    	this.xEnd = ob.xEnd;
    	this.ishteyinbi = ob.bl;

    	cal = new Calculate(ob);
		scaleX = (int) Math.floor((double)getWidth()/Math.ceil(cal.rangeX()+2));



    	if(cal.rangeY()!=0)scaleY =(int)Math.ceil((double)getHeight()/Math.ceil(cal.rangeY()+2));

    	else scaleY = scaleX;


        


    	 posX = getWidth()/2;
    	 posY = getHeight()*0.01/2+1;

    	System.out.println(scaleX + "  dd  " +scaleY+ " w : h  "+ getWidth()+" : "+getHeight()+
    		               "  range Y:X  "+ cal.rangeY()+" "+ cal.rangeX());



    }



	private void drawScaleBack(Graphics g){
		
		g.setColor(Color.GREEN);

		for(int j = 0; j<= posY;j+=scaleY){

			//float yt = (posY-j)/scaleY;
			g.drawLine(0,j+posY,getWidth(),j+posY);
			g.drawLine(0,posY-j,getWidth(),posY-j);
			//g.drawString(String.format("%.2f",yt),posX,(int)j);

		}
		for( int j = 0;j<=posX;j+=scaleX){

   			g.drawLine(j+posX,0,j+posX,getHeight());
   			g.drawLine(posX-j,0,posX-j,getHeight());
		}

		g.setColor(Color.RED);
		g.drawLine(posX,0,posX,getHeight());
		g.drawLine(0,posY,getWidth(),posY);

	}

    public void paint(Graphics g) {

        //draw back
		if(id!=0){
			//draw back with scale
			drawScaleBack(g);
		}

		// draw function
		if(id != 0)
		{
			g.setColor(Color.BLACK);

            float v = (float)1/scaleX;

			for (x = Math.round( xStart*scaleX ); x <= Math.ceil(xEnd*scaleX); x++) {

				y1 = (cal.calculateY( (x/scaleX) ));
				y  = (cal.calculateY( (x/scaleX)+v) );
				g.drawLine(Math.round(x)+ posX,   getHeight() - (Math.round(y1*scaleY) + posY),  
					       Math.round(x)+1 + posX, getHeight() - (Math.round(y*scaleY) + posY));

			      }
           //find root click
           if(ishteyinbi) {

			   if (cal.calculateY(xStart) * cal.calculateY(xEnd) > 0) {

       
                   if(Math.abs(cal.calculateY(xStart)) <= accuracy ){

                   	 g.drawOval(Math.round(xStart * scaleX) + posX - 4, posY - 4 - Math.round(cal.calculateY(xStart) * scaleY), 8, 8);

				   g.drawString(Float.toString(xStart),Math.round(xStart * scaleX) + posX - 4,
				   	            posY - 10 - Math.round(cal.calculateY(xStart) * scaleY));

                    

                   }
                   else if(Math.abs(cal.calculateY(xEnd)) <= accuracy){

                   	 g.drawOval(Math.round(xEnd * scaleX) + posX - 4, posY - 4 - Math.round(cal.calculateY(xEnd) * scaleY), 8, 8);

				   g.drawString(Float.toString(xEnd),Math.round(xEnd * scaleX) + posX - 4,
				   	            posY - 10 - Math.round(cal.calculateY(xEnd) * scaleY));


                   }
                   else{


				   System.out.println("You have not assumed"
						   + " right a and b");
				      }



			   }
			   else {
				   float ans = cal.findRoot();

				   g.drawOval(Math.round(ans * scaleX) + posX - 4, posY - 4 - Math.round(cal.calculateY(ans) * scaleY), 8, 8);

				   g.drawString(Float.toString(ans),Math.round(ans * scaleX) + posX - 4,
				   	            posY - 10 - Math.round(cal.calculateY(ans) * scaleY));
			   }
		   }

		}

    }
}