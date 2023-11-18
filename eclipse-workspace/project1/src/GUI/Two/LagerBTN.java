package GUI.Two;

import java.awt.Dimension;

import javax.swing.JButton;

class LargeBTN extends JButton{

    public LargeBTN(String str) {

        super(str);
    }
   

    public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+100, super.getPreferredSize().height+100);
        return largeBtnSz;
    }
}