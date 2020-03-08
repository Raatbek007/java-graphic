
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Func extends Front implements ActionListener {

    float a,b,c,accuracy,xStart,xEnd;
    int fid = 0;
    boolean bl=false;

    public Func() {
    }

    void makeFunc() {
        this.calculate.addActionListener(this);
        this.findR.addActionListener(this);
    }

    public void actionPerformed(ActionEvent var1) {



         g.setBounds(200,20,getWidth()-220,getHeight()-50);

         accuracy = Float.parseFloat(stepf.getText());
         a = Float.parseFloat(af.getText());
         b = Float.parseFloat(bf.getText());
         c = Float.parseFloat(cf.getText());

         xStart = Float.parseFloat(xStartField.getText());
         xEnd = Float.parseFloat(xEndField.getText());


        fid=y1.isSelected()?1:y2.isSelected()?2:y3.isSelected()?3:0;
        bl=(var1.getSource()==this.findR)?true:false;



       g.setInit(this);

       g.repaint();

        // xArea.setText(cal.getAnsX());
        // yArea.setText(cal.getAnsY());

        }

    }

