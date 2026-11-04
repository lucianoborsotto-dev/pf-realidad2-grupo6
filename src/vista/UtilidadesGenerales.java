package vista;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class UtilidadesGenerales {
    /**
     * Permite ocultar la felchita que se encuentra en la barra de la ventana arriba a la izquierda de los JInternalFrames.
     * @param frame 
     */
    static void ocultarMenu(JInternalFrame frame) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
        JComponent barra = ui.getNorthPane();
        ocultarFlechita(barra);
    }
    static void ocultarFlechita(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JButton) {
                componente.setVisible(false);
                return;
            }
            if (componente instanceof Container) {
                ocultarFlechita((Container) componente);
            }
        }
    }
}
