import java.awt.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.*;  
import javax.swing.border.Border;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.*;  
import java.util.*;  
/* 
    -- Desktop Watch V1.0 --
    Created By _ Vijay Mahajan.
    Designed By _ Vijay Mahajan.
    ----------------------------------------------------------------- 
    Follow Me On GitHub:- ("https://github.com/crazyindiandeveloper")
    Subscribe My YouTube Channel:- ("https://bit.ly/3dNveY3")
    Published On " 6.7.2021 "
*/

    public class ScreenMenu extends JFrame implements Runnable{  
    JFrame f;  
    Thread t=null;  
    JPanel jp;
    JPopupMenu pop;
    int hours=0, minutes=0, seconds=0;  
    String timeString = "";  
    JLabel label;
      
    ScreenMenu(){  
        f=new JFrame();  
       
          
        t = new Thread(this);  
            t.start();  
  
            
            
            label = new JLabel();
        label.setBackground(Color.GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 30;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));
       
      
        label.setForeground(Color.white);
            
            f.setUndecorated(true);
          
        f.add(label);
        f.setSize(200,50);  
       
        f.setVisible(true);  
        
        
   
        final JPopupMenu popup = new JPopupMenu();

        JMenuItem menuItem = new JMenuItem("More Tools");
        menuItem.setMnemonic(KeyEvent.VK_M);
        
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
               try {
   
                URI uri= new URI("http://www.github.com/crazyindiandeveloper");
   
                 java.awt.Desktop.getDesktop().browse(uri);
                                        
                }  
            catch (Exception EX) {
               EX.printStackTrace();
                }
               
            }
        });
        popup.add(menuItem);
        
        
        JMenuItem menuItem1 = new JMenuItem("Change Background Color");
        menuItem1.setMnemonic(KeyEvent.VK_B);
        menuItem1.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
          
             Color c=JColorChooser.showDialog(label,"Crazy Indian Developer aka - Vijay Mahajan",Color.CYAN);  
             
    label.setBackground(c);  
               
            }
        });
        popup.add(menuItem1);
        
        
        JMenuItem menuItem2 = new JMenuItem("Change Font Color");
        menuItem2.setMnemonic(KeyEvent.VK_F);
        menuItem2.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
               
             
             Color c=JColorChooser.showDialog(label,"Crazy Indian Developer aka - Vijay Mahajan",Color.CYAN);  
             
      label.setForeground(c);
               
            }
        });
        popup.add(menuItem2);
        
        
         JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Always on Top");  
        caseMenuItem.setMnemonic(KeyEvent.VK_T);  
        caseMenuItem.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
               if (caseMenuItem.isSelected()) {
                 f.setAlwaysOnTop(true);
               }else f.setAlwaysOnTop(false);
               
           
            }
        });
        popup.add(caseMenuItem);
            
        
        
        
        JMenuItem menuItem3 = new JMenuItem("Close");
        menuItem3.setMnemonic(KeyEvent.VK_X);
        menuItem3.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
             
            
            }
        });
        popup.add(menuItem3);
        
        
          
        
        
        
        //Mouse listener
        f.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
        
        
        
        
        
         FrameDragListener frameDragListener = new FrameDragListener(f);
                f.addMouseListener(frameDragListener);
                f.addMouseMotionListener(frameDragListener);
       
    }
   
      
     public void run() {  
          try {  
             while (true) {  
      
                Calendar cal = Calendar.getInstance();  
                hours = cal.get( Calendar.HOUR_OF_DAY );  
                if ( hours > 12 ) hours -= 12;  
                minutes = cal.get( Calendar.MINUTE );  
                seconds = cal.get( Calendar.SECOND );  
      
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
                Date date = cal.getTime();  
                timeString = formatter.format( date );  
      
                printTime();  
      
                t.sleep( 1000 );  // interval given in milliseconds  
             }  
          }  
          catch (Exception e) { }  
     
     }  
      
    public void printTime(){  
   
    label.setText(timeString);
    }  
      
   
    }  