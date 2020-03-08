import  javax.swing.*;
import  java.awt.*;

class Front extends JFrame {



    JButton calculate = new JButton("calculate");
    JRadioButton y1 = new JRadioButton("y=ax+b+c");
    JRadioButton y2 = new JRadioButton("y=ax^2+bx-c");
    JRadioButton y3 = new JRadioButton("y=ax^3+bx^2+c");



    JTextField xStartField = new JTextField("0");
    JTextField xEndField = new JTextField("5");



    JTextField af = new JTextField("1");
    JTextField bf = new JTextField("2");
    JTextField cf = new JTextField("-2");
    JTextField stepf = new JTextField("0.0001");
    DisplayGraphics g = new DisplayGraphics() ;
    JButton findR = new JButton("Find root");







    Front() {
    }

    void makeFront() {

        JLabel var1 = new JLabel("X start: ");
        JLabel var2 = new JLabel("X end: ");

        var1.setBounds(15, 15, 70, 30);
        var2.setBounds(15, 55, 70, 30);

        this.add(var1);
        this.add(var2);

        this.xStartField.setBounds(90, 15, 70, 30);
        this.xEndField.setBounds(90, 55, 70, 30);

        this.add(this.xStartField);
        this.add(this.xEndField);

        JLabel var3 = new JLabel("a :");
        JLabel var4 = new JLabel("b :");
        JLabel var5 = new JLabel("c :");
        JLabel var6 = new JLabel("accuracy :");

        this.y1.setBounds(20, 100, 150, 30);
        this.y2.setBounds(20, 140, 150, 30);
        this.y3.setBounds(20, 180, 150, 30);

        var3.setBounds(20, 230, 30, 20);
        var4.setBounds(20, 260, 30, 20);
        var5.setBounds(20, 290, 30, 20);
        var6.setBounds(5, 320, 65, 30);

        this.g.setBounds(340,10,545,750);

        this.af.setBounds(50, 230, 90, 30);
        this.bf.setBounds(50, 260, 90, 30);
        this.cf.setBounds(50, 290, 90, 30);
        this.stepf.setBounds(70, 320, 90, 30);
        this.calculate.setBounds(50, 400, 100, 30);
        this.findR.setBounds(50,440,100,30);

        this.add(this.findR);
        this.add(this.calculate);

        ButtonGroup var7 = new ButtonGroup();
        var7.add(this.y1);
        var7.add(this.y2);
        var7.add(this.y3);

        this.add(this.y1);
        this.add(this.y2);
        this.add(this.y3);

        this.add(var3);
        this.add(var4);
        this.add(var5);
        this.add(var6);

        this.add(this.af);
        this.add(this.bf);
        this.add(this.cf);
        this.add(this.stepf);    


        this.add(g);

        // xArea.setBounds(180, 15, 70, 320);
        // yArea.setBounds(250, 15, 70, 320);
        // this.add(xArea);
        // this.add(yArea);
        this.setSize(1000, 760);

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       // this.setDefaultCloseOperation(3);
    }
}

