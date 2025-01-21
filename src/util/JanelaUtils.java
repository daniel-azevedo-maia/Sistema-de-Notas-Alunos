package util;

import java.awt.*;

import javax.swing.*;

public class JanelaUtils {

    // Centraliza um JInternalFrame em relação ao componente pai
    public static void centralizarJanela(Component parent, JInternalFrame child) {
        Dimension parentSize = parent.getSize();
        Dimension childSize = child.getSize();

        int x = (parentSize.width - childSize.width) / 2;
        int y = (parentSize.height - childSize.height) / 2;

        child.setLocation(x, y);
    }

    // Centraliza um JFrame na tela
    public static void centralizarJanelaNaTela(Window frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        frame.setLocation(x, y);
    }
}
