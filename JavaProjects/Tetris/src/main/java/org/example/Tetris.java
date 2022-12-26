package org.example;

import org.example.model.Coord;
import org.example.model.Figure;
import org.example.ui.Window;

public class Tetris {
    public static void main(String[] args) {
        Window window = new Window();
        javax.swing.SwingUtilities.invokeLater(window);
        window.addFigure();
    }
}