import controller.FacturacionController;
import controller.ProveedorController;
import dto.CuentaCorrienteProveedorResponseDTO;
import mapper.DocumentMapper;
import model.*;
import view.documentos.MenuDocumentos;
import view.productos.MenuProductos;
import view.proveedores.MenuProveedores;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
//        FacturacionController controlador = new FacturacionController();
        FacturacionController controlador = FacturacionController.getInstancia();
        ProveedorController proveedorControlador = ProveedorController.getInstancia();


        // ABRO DISEÑO
        JFrame frame = new JFrame("Tu Aplicación");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Crear un JPanel principal con CardLayout
        JPanel panelPrincipal = new JPanel(new CardLayout());
        frame.add(panelPrincipal);

// Crear el menú de proveedores
        MenuProveedores menuProveedores = new MenuProveedores(panelPrincipal);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuProveedores.getMenu());

// Crear el menú de documentos
        MenuDocumentos menuDocumentos = new MenuDocumentos(panelPrincipal);
        menuBar.add(menuDocumentos.getMenu());

        MenuProductos menuProductos = new MenuProductos(panelPrincipal);
        menuBar.add(menuProductos.getMenu());

        frame.setJMenuBar(menuBar);

// Mostrar el JFrame
        frame.setVisible(true);

//        CIERRO DISENO



//        var controlador = FacturacionController.getInstancia();
//        var proveedorControlador = ProveedorController.getInstancia();


////        SE OBTIENE FACTURAS - PROVEEDORES CREADOS - PRODUCTOS
        proveedorControlador.getProveedores();
        controlador.getFacturas();
        controlador.getProductos();


//      LOGICA FACTURAS POR FECHA Y PROVEEDOR


        Date fecha = null;

        try {
            fecha = sdf.parse("01/01/2023");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String cuitProveedor = "12-34567844-9";
//        ArrayList<Factura> facturasFiltradas = controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);
        controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);


        //    LOGICA OBTENER ORDENES DE PAGO
        controlador.getOrdenesDePagoPorProveedor("12-34567844-9");
        controlador.getOrdenesDePagoPorProveedor("98-51765432-1");
        controlador.getOrdenesDePagoPorProveedor("33-33613333-3");

        System.out.println("Prueba");

        //    LOGICA OBTENER RECIBOS DE PAGO
        controlador.getRecibosDePago("12-34567844-9");
        controlador.imprimirRecibos();


//        TRAER ORDENES DE COMPRA
        controlador.obtenerOrdenesDeCompra();
//        controlador.obtenerOrdenDeCompra("JUANITA");

        controlador.getCompulsaPreciosPorProducto("Producto 1");

        var productosDeFactura = new ArrayList<ProductoOServicio>();
        var producto1 = new ProductoOServicio(1, "Producto 1", "Unidades", 10.0f, ResponsabilidadIVA.MONOTRIBUTO, "123456789", TipoRubro.MEDICINA_PREPAGA);
        var producto2 = new ProductoOServicio(2, "Producto 2", "Unidades", 15.0f, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "987654321",TipoRubro.PRODUCTOS_DE_REVENTA);
        productosDeFactura.add(producto2);
        productosDeFactura.add(producto1);

        var facturasAEnviar = new ArrayList<Factura>();
        var factura10 = new Factura("12-34567844-9", fecha, ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "1", productosDeFactura,2000);
        var factura11 = new Factura("12-34567844-9", fecha, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "2",productosDeFactura,3000);
        facturasAEnviar.add(factura10);
        facturasAEnviar.add((factura11));

        controlador.recepcionDeFacturas(facturasAEnviar);

//      LLAMADO CALCULO DEUDA DE PROVEEDOR
        var deuda = controlador.calcularDeudaPorProveedor("12-34567844-9");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 12-34567844-9 " +  "$" + deuda);

        var deuda1 = controlador.calcularDeudaPorProveedor("98-51765432-1");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 98-51765432-1 " + "$" +deuda1);

        var deuda2 = controlador.calcularDeudaPorProveedor("33-33613333-3");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 33-33613333-3 " + "$" +deuda2);

        var proveedores = proveedorControlador.getProveedores();
        var proveedor = proveedores.get(cuitProveedor);

        // Filtra las facturas en base al cuit del proveedor
        var facturasByProveedor = facturasAEnviar.stream()
                .filter(factura -> factura.getCuitProveedor().equals(proveedor.getCUIT()))
                .toList();

        var documentos = new ArrayList<Documento>();
        var ordenesDePago=new ArrayList<OrdenDePago>();
        // Busca los recibos por proveedor
        var recibosDePago=controlador.getRecibosDePago(cuitProveedor);
        // Extrae los IDS de las órdenes de pago en base a los recibos de pago (todos los que estén acá son órdenes ya pagas)
        var ordenesDePagoIDS=recibosDePago.stream().map(ReciboPago::getOrdenDePagoID).toList();

        var documentosPagos=new ArrayList<Documento>();
        var documentosImpagos=new ArrayList<Documento>();
        /*
        *Itera sobre las órdenes de pago y persiste los siguientes datos:
        * -Documentos pagos
        * -Documentos impagos
        * -Documentos recibidos (documentos)
         */
        controlador.obtenerOrdenesDePago().forEach(
                ordenDePago ->{
                    AtomicReference<Boolean> ownedByProveedor= new AtomicReference<>(false);
                    ordenDePago.getDocumentosAsociados().forEach(
                            documento -> {
                                if (documento.getCuitProveedor().equals(cuitProveedor)){
                                    documentos.add(documento);
                                    ownedByProveedor.set(true);
                                    if (ordenesDePagoIDS.contains(ordenDePago.getID())){
                                        documentosPagos.add(documento);
                                    }else {
                                        documentosImpagos.add(documento);
                                    }
                                }
                            }
                    );
                    if (ownedByProveedor.get()){
                        ordenesDePago.add(ordenDePago);
                    }
                }
        );

//        LOGICA CC PROVEEDORES
        proveedorControlador.getCuentaCorrienteProveedores();
        var cuentaCorrienteDTO=new CuentaCorrienteProveedorResponseDTO();
        cuentaCorrienteDTO.setDeuda(BigDecimal.valueOf(controlador.calcularDeudaPorProveedor(cuitProveedor)));
        cuentaCorrienteDTO.setDocumentosImpagos(DocumentMapper.toResponseDTOS(documentosImpagos,DocumentoEstado.IMPAGO));
        cuentaCorrienteDTO.setDocumentosRecibidos(documentos);
        cuentaCorrienteDTO.setPagosRealizados(DocumentMapper.toResponseDTOS(documentosPagos,DocumentoEstado.PAGO));
        System.out.println(cuentaCorrienteDTO.toString());
    }

}