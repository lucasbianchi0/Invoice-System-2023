package controller;

import model.Factura;
import model.OrdenDeCompra;
import model.ResponsabilidadIVA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class FacturacionController {

    ArrayList<OrdenDeCompra> ordenesDeCompra = new ArrayList<>();
    ArrayList totalFacturasPorDiaYProveedor = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public void crearYAgregarFacturas() {
        try {
            Factura factura1 = new Factura(123456789, 1, sdf.parse("01/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "OC123");
            facturas.add(factura1);

            Factura factura2 = new Factura(987654321, 2, sdf.parse("02/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "OC456");
            facturas.add(factura2);

            Factura factura3 = new Factura(111111111, 3, sdf.parse("03/01/2023"), ResponsabilidadIVA.MONOTRIBUTO, "Empresa C", "OC789");
            facturas.add(factura3);

            Factura factura4 = new Factura(222222222, 4, sdf.parse("04/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa D", "OC012");
            facturas.add(factura4);

            Factura factura5 = new Factura(333333333, 5, sdf.parse("05/01/2023"), ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa E", "OC345");
            facturas.add(factura5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    // Otros métodos de tu controlador..

}
