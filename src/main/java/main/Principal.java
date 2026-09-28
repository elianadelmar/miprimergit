package main;

import vista.VistaEstudiant;
import controlador.ControladorEstudiante;
import vista.VistaEstudiant;

public class Principal {

    public static void main(String[] args) {
        VistaEstudiant vista = new VistaEstudiant();
        ControladorEstudiante controlador = new ControladorEstudiante(vista);
        controlador.iniciar();
    }
}
