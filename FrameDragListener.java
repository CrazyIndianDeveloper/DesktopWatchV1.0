import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;

import javax.swing.*;

import java.io.File;
import java.io.IOException;

import java.net.URI;
/* 
    -- Desktop Watch V1.0 --
    Created By _ Vijay Mahajan.
    Designed By _ Vijay Mahajan.
    ----------------------------------------------------------------- 
    Follow Me On GitHub:- ("https://github.com/crazyindiandeveloper")
    Subscribe My YouTube Channel:- ("https://bit.ly/3dNveY3")
    Published On " 6.7.2021 "
*/

public class FrameDragListener extends MouseAdapter {

    private final JFrame frame;
    private Point mouseDownCompCoords =null;
    static int i=0;
    
    
    
    
    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    
    
    public void mouseReleased(MouseEvent e) {
        
        mouseDownCompCoords = null;
        
    }


    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
     i=1;
    
    } else if (e.getButton() == MouseEvent.BUTTON2) {
     i=2;
     
    }  else if (e.getButton() == MouseEvent.BUTTON3) {
     i=3;
     
    }  
       
        
        
        if(i==1){
        mouseDownCompCoords = e.getPoint();
        i=0;
        }else if(i==2){
        
        try {

            URI uri= new URI("http://www.github.com/crazyindiandeveloper");

             java.awt.Desktop.getDesktop().browse(uri);
            }  
        catch (Exception EX) {
           EX.printStackTrace();
            }
        }
    }

   
    public void mouseDragged(MouseEvent e) {
         Point currCoords = e.getLocationOnScreen();
        try {
        
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    } 
        catch(Exception unfix){unfix.printStackTrace();}
    }
}