/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author kevyne
 */
public class EditorFrame extends javax.swing.JFrame {
    
    String programName = "EditIt";
    String filename = "";
    String holdText;
    String fn;
    String dir;
    boolean textChanged = false;
    String fileName;
    Clipboard clip = getToolkit().getSystemClipboard();
    
    private String currentFile = null;
    protected UndoManager undoManager = new UndoManager();
    private UndoAction undoAction = new UndoAction();
    private RedoAction redoAction = new RedoAction();
    

    /**
     * Creates new form EditorFrame
     */
    public EditorFrame() {
        initComponents();
        textArea.getDocument().addUndoableEditListener(new UndoListener());
        editMenu.add((Action) undoAction);
        editMenu.add((Action) redoAction);
        undoAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        redoAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
                
    }
    /*public void initialize() {
        textArea.addCaretListener( new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
        boolean isSelected = false;
        int dot = e.getDot();
        int mark = e.getMark();
        if( dot != mark )
        isSelected = true;
        });
        }
        boolean isSelected = false;
        copyMenu.setEnabled(isSelected);
        cutMenu.setEnabled(isSelected);
    }*/
    
    
    public void checkFile() {
        BufferedReader read;
        StringBuffer sb = new StringBuffer();
        try {
            read = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = read.readLine()) != null) {
                sb.append(line + "\n");
                
            }
            textArea.setText(sb.toString());
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogColor = new javax.swing.JDialog();
        colorChooser = new javax.swing.JColorChooser();
        newButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        statusField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        printButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveasMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        colorMenu = new javax.swing.JMenuItem();
        fontMenu = new javax.swing.JMenuItem();
        copyMenu = new javax.swing.JMenuItem();
        pasteMenu = new javax.swing.JMenuItem();
        cutMenu = new javax.swing.JMenuItem();

        javax.swing.GroupLayout dialogColorLayout = new javax.swing.GroupLayout(dialogColor.getContentPane());
        dialogColor.getContentPane().setLayout(dialogColorLayout);
        dialogColorLayout.setHorizontalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        dialogColorLayout.setVerticalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("EditIt");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        statusField.setEditable(false);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea);

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenu.setText("New");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        saveasMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveasMenu.setText("Save As");
        saveasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveasMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");

        colorMenu.setText("Textcolor");
        colorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorMenuActionPerformed(evt);
            }
        });
        editMenu.add(colorMenu);

        fontMenu.setText("Set Font");
        fontMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontMenuActionPerformed(evt);
            }
        });
        editMenu.add(fontMenu);

        copyMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyMenu.setText("Copy");
        copyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuActionPerformed(evt);
            }
        });
        editMenu.add(copyMenu);

        pasteMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenu.setText("Paste");
        pasteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenu);

        cutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutMenu.setText("Cut");
        cutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuActionPerformed(evt);
            }
        });
        editMenu.add(cutMenu);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusField))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(saveButton)
                    .addComponent(loadButton)
                    .addComponent(quitButton)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        textArea.setText("");
        statusField.setText("New file");
    }//GEN-LAST:event_newButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        //System.exit(0);
        // if the output area is empty just quit, otherwise prompt before leaving
      if (  textArea.getText().trim().equals(""))
       {
         System.exit(0);
       }
  else
  {
      String message = "Do you want to save changes before exiting the program?";
      String title = "Really Quit?";
      // display the JOptionPane showConfirmDialog
      int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) {
                if(filename.equals(""))
                    saveAs();
                else
                    save(filename);
                System.exit(0);
            }
            if (reply == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
  }
    }//GEN-LAST:event_quitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showSaveDialog(this);
        if (chooserValue == JFileChooser.APPROVE_OPTION) {
            try {
                PrintWriter fout = new PrintWriter(chooser.getSelectedFile());
                fout.print(textArea.getText()); 
                fout.close();
                statusField.setText("Saved " + chooser.getSelectedFile().getAbsolutePath()); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EditorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
           JFileChooser chooser = new JFileChooser();
           int chooserValue = chooser.showOpenDialog(this);
           if (chooserValue == JFileChooser.APPROVE_OPTION) {
               try {
                   Scanner fin = new Scanner(chooser.getSelectedFile());
                   String buffer = "";
                   while (fin.hasNext()) {
                       buffer += fin.nextLine() + "\n";
                   }
                   textArea.setText(buffer);
                   //close input buffer
                   fin.close();
                   statusField.setText("Loaded " + chooser.getSelectedFile().getAbsolutePath());
               } catch (FileNotFoundException ex) {
                   JOptionPane.showMessageDialog(this, "File not Found!!!");
               }
           }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            boolean complete = textArea.print();
            if (complete) {
                JOptionPane.showMessageDialog(null, "Done printing","Information",JOptionPane.INFORMATION_MESSAGE);
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Printing!", "Printer",JOptionPane.ERROR_MESSAGE);
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void colorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorMenuActionPerformed
        Color c = colorChooser.showDialog(null, "Color Dialog", textArea.getForeground());
               textArea.setForeground(c);
    }//GEN-LAST:event_colorMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
        if(currentFile != null)
            save(currentFile);
        else
            saveAs();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void saveasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasMenuActionPerformed
        saveAs();
    }//GEN-LAST:event_saveasMenuActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        // TODO add your handling code here:
        newFile();
        statusField.setText("New file");
        currentFile = null;
    }//GEN-LAST:event_newMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        /*if(textArea.getText().length() < 1) {
            FileDialog fd = new FileDialog(this, "Choose File",FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                fileName = fd.getDirectory() + fd.getFile();
                setTitle(fileName);
                checkFile();
            }
            textArea.requestFocus();
        }
        else if(!textChanged) {
            FileDialog fd = new FileDialog(this, "Choose File",FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                fileName = fd.getDirectory() + fd.getFile();
                setTitle(fileName);
                checkFile();
            }
            textArea.requestFocus();
        }
        else {
            int confirm = JOptionPane.showConfirmDialog(null,"Do you want to save before exiting the program","save modifications", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION)
            {
                if("".equals(filename)) {
                    saveAs();
                }
                else {
                    save(filename);
                }
                FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
                fd.show();
                if (fd.getFile() != null ) {
                    fileName = fd.getDirectory() + fd.getFile();
                    setTitle(fileName);
                    checkFile();
                }
                textArea.requestFocus();
            }
            else if(confirm == JOptionPane.NO_OPTION) {
                FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
                fd.show();
                if (fd.getFile() != null) {
                    fileName = fd.getDirectory() + fd.getFile();
                    setTitle(fileName);
                    checkFile();
                }
                textArea.requestFocus();
            }
        } */
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
        if( chooser.showOpenDialog(this) ==
        JFileChooser.APPROVE_OPTION ) {
        if(openFile( chooser.getSelectedFile().toString() ))
            currentFile = chooser.getSelectedFile().toString();
        statusField.setText("Loaded " + chooser.getSelectedFile().getAbsolutePath());
        
        }

    }//GEN-LAST:event_openMenuActionPerformed

    private boolean openFile(String filename) {
try {
    BufferedReader reader = new BufferedReader( new
    FileReader(filename) );
    File file = new File(filename);
    if (!file.exists())
        throw new IOException(filename + "does not exist");
    if (file.length()> Integer.MAX_VALUE)
        throw new IOException(filename + "Oops.. Too large!");
    String bigString = "";
    String littleString = "";
    String eol = System.getProperty( "line.separator" );do {
    littleString = reader.readLine();
    if( littleString != null ) {
    littleString += eol;
    bigString += littleString;
    }
    }
    while( littleString != null );
    reader.close();
    textArea.setText( bigString );
    //statusField.setStatus( "Loaded " + filename );
    return true;
    } catch( IOException e ) {
    JOptionPane.showMessageDialog( this, "Error: " +
    e.getMessage() );
}
//statusField.setStatus( "Failed to read " + filename );
return false;
}
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        //exit program if not input added
      if (  textArea.getText().trim().equals(""))
       {
         System.exit(0);
       }
     else
      {
      String message = "Do you want to save changes before exiting the program?";
      String title = "Really Quit?";
      // display the JOptionPane showConfirmDialog
      int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) {
                if(filename.equals(""))
                    saveAs();
                else
                    save(filename);
                System.exit(0);
            }
            if (reply == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
      }
    }//GEN-LAST:event_exitMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if("".equals(textArea.getText())) {
            System.exit(0);
        }
        else if(!textChanged) {
            System.exit(0);
        }
        else {
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to exit the program without saving","Wanna quit",JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if(filename.equals(""))
                    saveAs();
                else
                    save(filename);
                System.exit(0);
            }
            if (confirm == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void copyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuActionPerformed
        textArea.copy();
        
    }//GEN-LAST:event_copyMenuActionPerformed

    private void pasteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuActionPerformed
        textArea.paste();
    }//GEN-LAST:event_pasteMenuActionPerformed

    private void cutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuActionPerformed
        textArea.cut();
    }//GEN-LAST:event_cutMenuActionPerformed

    private void fontMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontMenuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fontMenuActionPerformed

   
    private void textAreaTextValueChanged(java.awt.event.TextEvent evt) {
        if (TextEvent.TEXT_VALUE_CHANGED != 0) {
            if(!textChanged)
                setTitle("* "+getTitle());
            textChanged = true;
            saveMenu.setEnabled(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JMenuItem colorMenu;
    private javax.swing.JMenuItem copyMenu;
    private javax.swing.JMenuItem cutMenu;
    private javax.swing.JDialog dialogColor;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem fontMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem pasteMenu;
    private javax.swing.JButton printButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JMenuItem saveasMenu;
    private javax.swing.JTextField statusField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    private void saveAs() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        FileDialog fd = new FileDialog(EditorFrame.this, "Save", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() != null) {
            fn = fd.getFile();
            dir = fd.getDirectory();
            filename = dir + fn + ".txt";
            
            setTitle(filename);
            try {
                DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                holdText = textArea.getText();
                BufferedReader br = new BufferedReader(new StringReader(holdText));
                while ((holdText = br.readLine()) != null)
                {
                    d.writeBytes(holdText + "\r\n");
                    d.close();
                }
            }
            catch (Exception e)
            {
                System.out.println("File not found");
            }
            textArea.requestFocus();
            save(filename);
        } 
        
        
    }

    private boolean save(String filename) {
        setTitle(programName+" "+filename);
        /*try {
            FileWriter out;
            out = new FileWriter(fn);
            out.write(textArea.getText());
            out.close();
            
        }
        catch (Exception err) {
            System.out.println("Error: " + err);
        }
        textChanged = false;
        saveMenu.setEnabled(false);*/
        try {
        BufferedWriter writer = new BufferedWriter( new
        FileWriter(filename) );
        writer.write( textArea.getText() );
        writer.close();
        currentFile = filename;
        return true;
        } catch( IOException e ) {
        JOptionPane.showMessageDialog( this, "Error: " +
        e.getMessage() );
        }
        saveMenu.setEnabled(false);
        return false;
 
        
        
    }

    private void newFile() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        if(textArea.getText().length() < 1) {
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged = false;
        }
        else if(!textChanged) {
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged = false;
        }
        else {
            int confirm = JOptionPane.showConfirmDialog(null, textArea);
            if (confirm == JOptionPane.YES_OPTION)
            {
                if("".equals(filename)) {
                    saveAs();
                }
                else {
                    save(filename);
                }
                setTitle(programName);
                filename = "";
                textArea.setText("");
                textChanged = false;
            }
            else if(confirm == JOptionPane.NO_OPTION) {
                setTitle(programName);
                textArea.setText("");
                textChanged = false;
            }
        }
    }

     class UndoAction extends AbstractAction {

        public UndoAction() {
            this.putValue(Action.NAME, undoManager.getUndoPresentationName());
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
            if (this.isEnabled()) {
                undoManager.undo();
                undoAction.update();
                redoAction.update();
                undoAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            }
        }
        public void update() {
          this.putValue(Action.NAME, undoManager.getUndoPresentationName());
          this.setEnabled(undoManager.canUndo());
    }
    }

     class RedoAction extends AbstractAction{

        public RedoAction() {
            this.putValue(Action.NAME, undoManager.getRedoPresentationName());
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //To change body of generated methods, choose Tools | Templates.
            if (this.isEnabled()) {
                undoManager.undo();
                undoAction.update();
                redoAction.update();
            }
            
        }
        public void update() {
       this.putValue(Action.NAME, undoManager.getRedoPresentationName());
       this.setEnabled(undoManager.canRedo());
    }

      
    }

     class UndoListener implements UndoableEditListener {

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
          undoManager.addEdit(e.getEdit());
            undoAction.update();
            redoAction.update();
        }
    }
    
}
