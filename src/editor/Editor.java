/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import javax.swing.JFrame;

/**
 *
 * @author kevyne
 */
public class Editor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create new instance of EditorFrame
        EditorFrame frame= new EditorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}
