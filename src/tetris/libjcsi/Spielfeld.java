/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.libjcsi;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author rajar
 */
public class Spielfeld {

    private final WSwingConsoleInterface csi;

    public Spielfeld() {
        csi = new WSwingConsoleInterface("Tetris");
        System.out.println("X-Dimension: " + csi.getXdim());
        System.out.println("Y-Dimension: " + csi.getYdim());
    }

    public void Figuren() {
        // Figur 1 instantion
        int figurX = 0;
        int figurNextX = 0;
        int figurY = 0;
        int figurNextY = 0;
        // Figur 2 instantion
        int figur2X = 8;
        int figurNext2X = 8;
        int figur2Y = 0;
        int figurNext2Y = 0;
        // Figur 3 instantion
        int figur3X = 15;
        int figurNext3X = 15;
        int figur3Y = 0;
        int figurNext3Y = 0;
        // Figur 4 instantion
        int figur4X = 25;
        int figurNext4X = 25;
        int figur4Y = 0;
        int figurNext4Y = 0;
        int zahl = 3;
        setupGameBoard();
        boolean exit = false;
        //Versucht konstante Bewegung nach unten
        boolean exit1 = false;
        while (exit1 = false) {
            csi.restore();
            // Draw dynamic part
            csi.print(figurX, figurY, "###", CSIColor.ATOMIC_TANGERINE);
            // Push to screen
            figurY++;
            figurNextY = figurY - 1;
            if(csi.peekChar(figurNextX, figurNextY) == '='){
                exit1 = true;
            }
            csi.refresh();
        }
        while (!exit) {
            // Draw game board
            csi.restore();
            // Draw dynamic part
            // Figur 1
            csi.print(figurX, figurY, "###", CSIColor.YELLOW_GREEN);
            csi.print(figurX + 2, figurY + 1, "#", CSIColor.YELLOW_GREEN);
            // Figur 2
            csi.print(figur2X, figur2Y, "*", CSIColor.YELLOW_GREEN);
            csi.print(figur2X, figur2Y + 1, "**", CSIColor.YELLOW_GREEN);
            csi.print(figur2X + 1, figur2Y + 2, "*", CSIColor.YELLOW_GREEN);
            // Figur 3
            csi.print(figur3X, figur3Y, "%%", CSIColor.YELLOW_GREEN);
            csi.print(figur3X, figur3Y + 1, "%%", CSIColor.YELLOW_GREEN);
            // Figur 4
            csi.print(figur4X, figur4Y, "|", CSIColor.YELLOW_GREEN);
            csi.print(figur4X, figur4Y + 1, "|", CSIColor.YELLOW_GREEN);
            csi.print(figur4X, figur4Y + 2, "|", CSIColor.YELLOW_GREEN);
            csi.print(figur4X, figur4Y + 3, "|", CSIColor.YELLOW_GREEN);
            // Push to screen
            csi.refresh();

            // Figur 1 Steuerung
            int key = csi.inkey().code;
            switch (key) {
                case CharKey.UARROW:
                    figurNextY = figurY - 1;
                    break;
                case CharKey.DARROW:
                    figurNextY = figurY + 1;
                    break;
                case CharKey.LARROW:
                    figurNextX = figurX - 1;
                    break;
                case CharKey.RARROW:
                    figurNextX = figurX + 1;
                    break;
                case CharKey.o:
                    csi.refresh();
                    break;
                case CharKey.Q:
                case CharKey.q:
                    exit = true;
            }
            // Figur 2 Steuerung
            switch (key) {
                case CharKey.w:
                    figurNext2Y = figur2Y - 1;
                    break;
                case CharKey.s:
                    figurNext2Y = figur2Y + 1;
                    break;
                case CharKey.a:
                    figurNext2X = figur2X - 1;
                    break;
                case CharKey.d:
                    figurNext2X = figur2X + 1;
                    break;
            }
            // Figur 3 Steuerung
            switch (key) {
                case CharKey.i:
                    figurNext3Y = figur3Y - 1;
                    break;
                case CharKey.k:
                    figurNext3Y = figur3Y + 1;
                    break;
                case CharKey.j:
                    figurNext3X = figur3X - 1;
                    break;
                case CharKey.l:
                    figurNext3X = figur3X + 1;
                    break;
            }
            // Figur 4 Steuerung
            switch (key) {
                case CharKey.t:
                    figurNext4Y = figur4Y - 1;
                    break;
                case CharKey.g:
                    figurNext4Y = figur4Y + 1;
                    break;
                case CharKey.f:
                    figurNext4X = figur4X - 1;
                    break;
                case CharKey.h:
                    figurNext4X = figur4X + 1;
                    break;
            }
            //prüfen ob Figur am Rand ist
            // Figur 1 Rand
            if (figurNextX > 79) {
                figurNextX = 79;
            } else if (figurNextX < 0) {
                figurNextX = 0;
            } else if (figurNextY < 0) {
                figurNextY = 0;
            } else if (figurNextY > 24) {
                figurNextY = 24;
            }
            // Figur 2 Rand
            if (figurNext2X > 79) {
                figurNext2X = 79;
            } else if (figurNext2X < 0) {
                figurNext2X = 0;
            } else if (figurNext2Y < 0) {
                figurNext2Y = 0;
            } else if (figurNext2Y > 24) {
                figurNext2Y = 24;
            }
            // Figur 3 Rand
            if (figurNext3X > 79) {
                figurNext3X = 79;
            } else if (figurNext3X < 0) {
                figurNext3X = 0;
            } else if (figurNext3Y < 0) {
                figurNext3Y = 0;
            } else if (figurNext3Y > 24) {
                figurNext3Y = 24;
            }
            // Figur 4 Rand
            if (figurNext4X > 79) {
                figurNext4X = 79;
            } else if (figurNext4X < 0) {
                figurNext4X = 0;
            } else if (figurNext4Y < 0) {
                figurNext4Y = 0;
            } else if (figurNext4Y > 24) {
                figurNext4Y = 24;
            }
            //prüft ob ein char im weg ist
            // Figur 1
            if (csi.peekChar(figurNextX, figurNextY) == '*') {
                figurNextX = figurX;
                figurNextY = figurY;
            } else if (csi.peekChar(figurNextX, figurNextY) == '=') {
                figurNextX = figurX;
                figurNextY = figurY;
            } else if (csi.peekChar(figurNextX, figurNextY) == '%') {
                figurNextX = figurX;
                figurNextY = figurY;
            } // Figur 2
            else if (csi.peekChar(figurNext2X, figurNext2Y) == '#') {
                figurNext2X = figur2X;
                figurNext2Y = figur2Y;
            } else if (csi.peekChar(figurNext2X, figurNext2Y) == '%') {
                figurNext2X = figur2X;
                figurNext2Y = figur2Y;
            } else if (csi.peekChar(figurNext2X, figurNext2Y) == '=') {
                figurNext2X = figur2X;
                figurNext2Y = figur2Y;
            } // Figur 3
            else if (csi.peekChar(figurNext3X, figurNext3Y) == '#') {
                figurNext3X = figur3X;
                figurNext3Y = figur3Y;
            } else if (csi.peekChar(figurNext3X, figurNext3Y) == '*') {
                figurNext3X = figur3X;
                figurNext3Y = figur3Y;
            } else if (csi.peekChar(figurNext3X, figurNext3Y) == '=') {
                figurNext3X = figur3X;
                figurNext3Y = figur3Y;
            } // Figur 4
            else if (csi.peekChar(figurNext3X, figurNext3Y) == '#') {
                figurNext4X = figur4X;
                figurNext4Y = figur4Y;
            } else if (csi.peekChar(figurNext3X, figurNext3Y) == '*') {
                figurNext4X = figur4X;
                figurNext4Y = figur4Y;
            } else if (csi.peekChar(figurNext3X, figurNext3Y) == '=') {
                figurNext4X = figur4X;
                figurNext4Y = figur4Y;
            }
            // Figur 1 Movement
            figurX = figurNextX;
            figurY = figurNextY;
            // Figur 2 Movement
            figur2X = figurNext2X;
            figur2Y = figurNext2Y;
            // Figur 3 Movement
            figur3X = figurNext3X;
            figur3Y = figurNext3Y;
            // Figur 4 Movement
            figur4X = figurNext4X;
            figur4Y = figurNext4Y;
        }

        csi.print(1, 20, "Press space to exit");
        csi.refresh();
        csi.waitKey(CharKey.SPACE);
        System.exit(0);
    }

    private void setupGameBoard() {

        csi.cls();
        csi.print(5, 9, "=            =", CSIColor.EGYPTIAN_BLUE);
        csi.print(5, 10, "=            =", CSIColor.CAROLINA_BLUE);
        csi.print(5, 11, "=            =", CSIColor.EGYPTIAN_BLUE);
        csi.print(5, 12, "=            =", CSIColor.CAROLINA_BLUE);
        csi.print(5, 13, "=            =", CSIColor.EGYPTIAN_BLUE);
        csi.print(5, 14, "=            =", CSIColor.CAROLINA_BLUE);
        csi.print(5, 15, "=            =", CSIColor.EGYPTIAN_BLUE);
        csi.print(5, 16, "==============", CSIColor.CAROLINA_BLUE);
        // Textanzeige "Tetris"
        //T
        csi.print(25, 17, "---------", CSIColor.CYAN);
        csi.print(25, 18, "    -    ", CSIColor.CYAN);
        csi.print(25, 19, "    -    ", CSIColor.CYAN);
        csi.print(25, 20, "    -    ", CSIColor.CYAN);
        csi.print(25, 21, "    -    ", CSIColor.CYAN);
        //E
        csi.print(35, 17, "---------", CSIColor.CYAN);
        csi.print(35, 18, "--       ", CSIColor.CYAN);
        csi.print(35, 19, "---------", CSIColor.CYAN);
        csi.print(35, 20, "--       ", CSIColor.CYAN);
        csi.print(35, 21, "---------", CSIColor.CYAN);
        //T
        csi.print(45, 17, "---------", CSIColor.CYAN);
        csi.print(45, 18, "    -    ", CSIColor.CYAN);
        csi.print(45, 19, "    -    ", CSIColor.CYAN);
        csi.print(45, 20, "    -    ", CSIColor.CYAN);
        csi.print(45, 21, "    -    ", CSIColor.CYAN);
        //R
        csi.print(55, 17, "--------", CSIColor.CYAN);
        csi.print(55, 18, "--     -", CSIColor.CYAN);
        csi.print(55, 19, "----   -", CSIColor.CYAN);
        csi.print(55, 20, "--  -- ", CSIColor.CYAN);
        csi.print(55, 21, "--    --", CSIColor.CYAN);
        //I
        csi.print(62, 17, "    -    ", CSIColor.CYAN);
        csi.print(62, 18, "    -    ", CSIColor.CYAN);
        csi.print(62, 19, "    -    ", CSIColor.CYAN);
        csi.print(62, 20, "    -    ", CSIColor.CYAN);
        csi.print(62, 21, "    -    ", CSIColor.CYAN);
        //S
        csi.print(70, 17, "  -----  ", CSIColor.CYAN);
        csi.print(70, 18, "--     --", CSIColor.CYAN);
        csi.print(70, 19, "   ---   ", CSIColor.CYAN);
        csi.print(70, 20, "--     --", CSIColor.CYAN);
        csi.print(70, 21, "  -----  ", CSIColor.CYAN);

        //Steuerungs Tipp Anzeige
        // Figur 1
        csi.print(30, 0, "Steuerung:", CSIColor.ORANGE);
        csi.print(30, 2, "###   :   UARROW, DARROW, LARROW, RARROW", CSIColor.LEMON);
        csi.print(30, 3, "#", CSIColor.LEMON);
        // Figur 2
        csi.print(30, 5, "*     :   w, s, a, d", CSIColor.LEMON);
        csi.print(30, 6, "**", CSIColor.LEMON);
        csi.print(31, 7, "*", CSIColor.LEMON);
        // Figur 3
        csi.print(30, 9, "%%    :   i, k, j, l", CSIColor.LEMON);
        csi.print(30, 10, "%%", CSIColor.LEMON);
        // Figur 4
        csi.print(30, 12, "|     :   t, g, f, h", CSIColor.LEMON);
        csi.print(30, 13, "|", CSIColor.LEMON);
        csi.print(30, 14, "|", CSIColor.LEMON);
        csi.print(30, 15, "|", CSIColor.LEMON);
        csi.saveBuffer();
    }
}
