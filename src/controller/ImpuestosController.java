package controller;

import model.Impuestos;

import java.util.ArrayList;

public class ImpuestosController {
    private static ImpuestosController instancia;
    private ArrayList<Impuestos> impuestos;

    private ImpuestosController(){
        impuestos = new ArrayList<>();
    }

    public static ImpuestosController getInstancia() {
        if (instancia == null) {
            instancia = new ImpuestosController();
        }
        return instancia;
    }


}
