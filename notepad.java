/*
    Step 1 Starts from here
*/

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
    Step 2 Starts from here
*/

public class notepad extends KeyAdapter implements ActionListener, KeyListener 
{
   static int act = 0;
   static int fs = 17;

   JFrame f1;
   JMenuBar nMenuBar;
   JMenu taskfile, taskedit, taskformat, taskview;
   JMenuItem ndoc, odoc, nexit, sdoc, sadoc, cdoc, pdoc, rdoc, fontfam, fontsty, fontsz, fstatus,exit;
   JTextArea maintxt;
   JTextField mytitle;
   Font ft1;
   JPanel btm;
   JLabel detail, pcdoc;
   JList famlist, stylist, szlist;
   JScrollPane sbb;

   String familyval[] = { "Agency  FB", "Antiqua", "Architect", "Arial", "Calibri", "Comic Sans", "Courier", "Cursive", "Impact", "Serif" };
   String sizeval[] = { "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70" };
   int[] styleval = { Font.PLAIN, Font.BOLD, Font.ITALIC };
   String[] stylevals = { "PLAIN", "BOLD", "ITALIC" };
   String ffamily, fsstr, fstylestr;
   int fstyle;
   int cl;
   int linecount;
   String tle;
   String topicstitle = "";
   JScrollPane sp;

   void Main() 
   {
      f1 = new JFrame("Coding Ninjas Notepad");

      ft1 = new Font("Arial", Font.PLAIN, 17);

      btm = new JPanel();
      detail = new JLabel();
      pcdoc = new JLabel();

      famlist = new JList(familyval);
      stylist = new JList(stylevals);
      szlist = new JList(sizeval);

      famlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      szlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      stylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      btm.add(detail);

      maintxt = new JTextArea();

      sp = new JScrollPane(maintxt);
      mytitle = new JTextField(100);

      sbb = new JScrollPane(maintxt);

      maintxt.setMargin(new Insets(5, 5, 5, 5));

      maintxt.setFont(ft1);
      f1.add(maintxt);

      nMenuBar = new JMenuBar();

      taskfile = new JMenu("File");
      taskedit = new JMenu("Edit");
      taskformat = new JMenu("Format");
      taskview = new JMenu("View");

      ndoc = new JMenuItem("New Document");
      odoc = new JMenuItem("Open Document");
      sdoc = new JMenuItem("Save Document");
      sadoc = new JMenuItem("Save As Document");
      exit = new JMenuItem("Exit");

      cdoc = new JMenuItem("Copy Document");
      rdoc = new JMenuItem("Remove Document");
      pdoc = new JMenuItem("Paste Document");

      fontfam = new JMenuItem("Set Font Family");
      fontsty = new JMenuItem("Set Font Style");
      fontsz = new JMenuItem("Set Font Size");
      fstatus = new JMenuItem("Status");

      taskfile.add(ndoc);
      taskfile.add(odoc);
      taskfile.add(sdoc);
      taskfile.add(sadoc);
      taskfile.add(nexit);

      taskedit.add(cdoc);
      taskedit.add(pdoc);
      taskedit.add(rdoc);

      taskformat.add(fontfam);
      taskformat.add(fontsty);
      taskformat.add(fontsz);

      taskview.add(fstatus);

      nMenuBar.add(taskfile);
      nMenuBar.add(taskedit);
      nMenuBar.add(taskformat);
      nMenuBar.add(taskview);

      f1.setJMenuBar(nMenuBar);
      f1.add(btm, BorderLayout.SOUTH);

      ndoc.addActionListener(this);
      cdoc.addActionListener(this);
      pdoc.addActionListener(this);
      rdoc.addActionListener(this);
      fstatus.addActionListener(this);
      sdoc.addActionListener(this);
      sadoc.addActionListener(this);

      fontfam.addActionListener(this);
      fontsz.addActionListener(this);
      fontsty.addActionListener(this);

      nexit.addActionListener(this);

      maintxt.addKeyListener(this);

      f1.setSize(600, 600);
      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f1.setLocationRelativeTo(null);
      f1.setVisible(true);
   }

   /* 
   		Step 3 Starts from here 
   */

   public void actionPerformed(ActionEvent ae) 
   {
      if (ae.getSource() == ndoc) 
      {
         f1.setTitle("New Document.txt");
         maintxt.setText("");
      } 
      else if (ae.getSource() == cdoc) 
      {
         String texts = maintxt.getText();
         pcdoc.setText(texts);
         JOptionPane.showMessageDialog(null, "Copy Text " + texts);
      } 
      else if (ae.getSource() == rdoc) 
      {
         maintxt.setText("");
         JOptionPane.showMessageDialog(null, "Removed");
      } 
      else if (ae.getSource() == pdoc) 
      {
         if (maintxt.getText().length() != 0) {
            maintxt.setText(maintxt.getText());
         } 
         else 
         {
            maintxt.setText(pcdoc.getText());
         }
      } 
      else if (ae.getSource() == fstatus) {
         try {
            if (act == 0) {
               File f = new File(tle + ".txt");
               detail.setText("Size: " + f.length());
            }
         } 
         catch (Exception e) {
         }
      } 
      else if (ae.getSource() == fontfam) 
      {
         JOptionPane.showConfirmDialog(null, famlist, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         ffamily = String.valueOf(famlist.getSelectedValue());
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == fontsty) 
      {

         JOptionPane.showConfirmDialog(null, stylist, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         fstyle = styleval[stylist.getSelectedIndex()];
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == fontsz) 
      {
         JOptionPane.showConfirmDialog(null, szlist, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         fsstr = String.valueOf(szlist.getSelectedValue());
         fs = Integer.parseInt(fsstr);
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == nexit) 
      {
         f1.dispose();
      }
   }

   /* 
   		Step 4 Starts from here 
   */

   public void keyTyped(KeyEvent ke) 
   {
      cl = maintxt.getText().length();
      linecount = maintxt.getLineCount();
      detail.setText("Length: " + cl + "  "  + " Line: " + linecount);
   }

   /* 
   		Step 5 Starts from here 
   */

   public static void main(String ar[]) 
   {
      notepad c= new notepad();
      c.Main();
   }
}