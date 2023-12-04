import controller.FacturacionController;
import controller.ProveedorController;
import dto.CuentaCorrienteProveedorResponseDTO;
import mapper.DocumentMapper;
import model.*;
import view.MainFrame;
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
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
//        FacturacionController controlador = new FacturacionController();
        FacturacionController controlador = FacturacionController.getInstancia();
        ProveedorController proveedorControlador = ProveedorController.getInstancia();
        Scanner scanner = new Scanner(System.in);

        String numeroOrden = obtenerNumeroOrdenDelUsuario(scanner);
        ArrayList<Documento> documentos1 = obtenerDocumentosDelUsuario(scanner);
        FormaDePago formaDePago = obtenerFormaDePagoDelUsuario(scanner);
        double monto = obtenerMontoDelUsuario(scanner);

        // Llamar al método del controlador para agregar la Orden de Pago
        controlador.agregarOrdenDePago(numeroOrden, documentos1, formaDePago, monto);


//        // ABRO DISEÑO
//        JFrame frame = new JFrame("Sistema proveedores");
//        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//// Crear un JPanel principal con CardLayout
//        JPanel panelPrincipal = new JPanel(new CardLayout());
//        frame.add(panelPrincipal);
//
//// Crear el menú de proveedores
//        MenuProveedores menuProveedores = new MenuProveedores(panelPrincipal);
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.add(menuProveedores.getMenu());
//
//// Crear el menú de documentos
//        MenuDocumentos menuDocumentos = new MenuDocumentos(panelPrincipal);
//        menuBar.add(menuDocumentos.getMenu());
//
//        MenuProductos menuProductos = new MenuProductos(panelPrincipal);
//        menuBar.add(menuProductos.getMenu());
//
//        frame.setJMenuBar(menuBar);
//
//// Mostrar el JFrame
//        frame.setVisible(true);
//
////        CIERRO DISENO
        MainFrame frame = new MainFrame();


//        var controlador = FacturacionController.getInstancia();
//        var proveedorControlador = ProveedorController.getInstancia();


////        SE OBTIENE FACTURAS - PROVEEDORES CREADOS - PRODUCTOS
//        proveedorControlador.getProveedores();
        controlador.getFacturas();
        controlador.getProductos();



//      LOGICA FACTURAS POR FECHA Y PROVEEDOR


        Date fecha = null;

        try {
            fecha = sdf.parse("01/01/2023");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String cuitProveedor = "22-78222222-2";
//        ArrayList<Factura> facturasFiltradas = controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);
        controlador.facturaPorFechaYProveedor(fecha, cuitProveedor);


        //    LOGICA OBTENER ORDENES DE PAGO
        controlador.getOrdenesDePagoPorProveedor("12-34567844-9");
        controlador.getOrdenesDePagoPorProveedor("98-51765432-1");
        controlador.getOrdenesDePagoPorProveedor("33-33613333-3");
        controlador.getOrdenesDePagoPorProveedor("22-78222222-2");


        //    LOGICA OBTENER RECIBOS DE PAGO
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
        var factura10 = new Factura("12-34567844-9", fecha, ResponsabilidadIVA.MONOTRIBUTO, "Empresa A", "Empresa A", productosDeFactura);
        var factura11 = new Factura("12-34567844-9", fecha, ResponsabilidadIVA.RESPONSABLE_INSCRIPTO, "Empresa B", "Empresa b",productosDeFactura);
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

        var deuda3 = controlador.calcularDeudaPorProveedor("22-78222222-2");
        System.out.println("---------------------");
        System.out.println("Deuda por Proveedor con CUIT: 22-78222222-2 " + "$" + deuda3);

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

////        LOGICA CC PROVEEDORES
        proveedorControlador.getCuentaCorrienteProveedores();
        var cuentaCorrienteDTO=new CuentaCorrienteProveedorResponseDTO();
        cuentaCorrienteDTO.setDeuda(BigDecimal.valueOf(controlador.calcularDeudaPorProveedor(cuitProveedor)));
        cuentaCorrienteDTO.setDocumentosImpagos(DocumentMapper.toResponseDTOS(documentosImpagos,DocumentoEstado.IMPAGO));
        cuentaCorrienteDTO.setDocumentosRecibidos(documentos);
        cuentaCorrienteDTO.setPagosRealizados(DocumentMapper.toResponseDTOS(documentosPagos,DocumentoEstado.PAGO));
        System.out.println(cuentaCorrienteDTO.toString());

    }

    ///////////////////////////////////////
    private static String obtenerNumeroOrdenDelUsuario(Scanner scanner) {
        System.out.print("Ingrese el número de la orden de pago: ");
        return scanner.nextLine();
    }

    private static ArrayList<Documento> obtenerDocumentosDelUsuario(Scanner scanner) {
        ArrayList<Documento> documentos = new ArrayList<>();

        System.out.print("¿Cuántos documentos desea ingresar?: ");
        int cantidadDocumentos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidadDocumentos; i++) {
            System.out.println("Ingresando datos para el documento " + (i + 1));

            System.out.print("Ingrese el tipo de documento (Factura, NotaDeDebito, NotaDeCredito, etc.): ");
            String tipoDocumento = scanner.nextLine();

            // Implementa la lógica para cada tipo de documento según tus necesidades
            Documento documento = obtenerDocumentoSegunTipo(tipoDocumento, scanner);

            documentos.add(documento);
        }

        return documentos;
    }

    private static Documento obtenerDocumentoSegunTipo(String tipoDocumento, Scanner scanner) {
        switch (tipoDocumento.toUpperCase()) {
            case "FACTURA":
                // Lógica para obtener datos de una factura
                return obtenerDatosFactura(scanner);

            case "NOTADEDÉBITO":
                // Lógica para obtener datos de una nota de débito
                return obtenerDatosNotaDeDebito(scanner);

            case "NOTADECREDITO":
                // Lógica para obtener datos de una nota de crédito
                return obtenerDatosNotaDeCredito(scanner);

            // Puedes agregar más casos según los tipos de documentos que manejes

            default:
                System.out.println("Tipo de documento no reconocido. Se creará un documento genérico.");
                return null; // Devuelve null o lanza una excepción según tus necesidades
        }
    }

    private static Factura obtenerDatosFactura(Scanner scanner) {
        System.out.println("Ingresando datos para la Factura:");

        System.out.print("Ingrese el CUIT del proveedor: ");
        String cuitProveedor = scanner.nextLine();

        Date fechaEmision = null;
        try {
            System.out.print("Ingrese la fecha de emisión de la factura (formato dd/MM/yyyy): ");
            fechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return null;
        }

        System.out.print("Ingrese la responsabilidad IVA (MONOTRIBUTO o RESPONSABLE_INSCRIPTO): ");
        ResponsabilidadIVA responsabilidadIVA = ResponsabilidadIVA.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Ingrese la razón social: ");
        String razonSocial = scanner.nextLine();

        System.out.print("Ingrese el número de orden de compra (opcional, presiona Enter si no hay): ");
        String ordenDeCompraID = scanner.nextLine();

        // Lógica para obtener datos adicionales si es necesario

        // Lógica para obtener los productos asociados a la factura
        ArrayList<ProductoOServicio> productosFactura = obtenerProductosOServiciosDelUsuario(scanner);

        return new Factura(cuitProveedor, fechaEmision, responsabilidadIVA, razonSocial, ordenDeCompraID, productosFactura);
    }

    private static NotaDeDebito obtenerDatosNotaDeDebito(Scanner scanner) {
        System.out.println("Ingresando datos para la Nota de Débito:");

        System.out.print("Ingrese el CUIT del proveedor: ");
        String cuitProveedor = scanner.nextLine();

        Date fechaEmision = null;
        try {
            System.out.print("Ingrese la fecha de emisión de la nota de débito (formato dd/MM/yyyy): ");
            fechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return null;
        }

        System.out.print("Ingrese el monto de la nota de débito: ");
        double monto = Double.parseDouble(scanner.nextLine());

        // Lógica para obtener datos adicionales si es necesario

        return new NotaDeDebito(cuitProveedor, fechaEmision, monto);
    }

    private static NotaDeCredito obtenerDatosNotaDeCredito(Scanner scanner) {
        System.out.println("Ingresando datos para la Nota de Crédito:");

        System.out.print("Ingrese el CUIT del proveedor: ");
        String cuitProveedor = scanner.nextLine();

        Date fechaEmision = null;
        try {
            System.out.print("Ingrese la fecha de emisión de la nota de crédito (formato dd/MM/yyyy): ");
            fechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return null;
        }

        System.out.print("Ingrese el monto de la nota de crédito: ");
        double monto = Double.parseDouble(scanner.nextLine());

        // Lógica para obtener datos adicionales si es necesario

        return new NotaDeCredito(cuitProveedor, fechaEmision, monto);
    }



    private static ArrayList<ProductoOServicio> obtenerProductosOServiciosDelUsuario(Scanner scanner) {
        // Implementa la lógica para obtener la lista de productos o servicios según tus necesidades
        // Puedes pedir al usuario que ingrese datos para cada producto en el bucle
        return new ArrayList<>();  // Devuelve una lista vacía por ahora
    }


    private static FormaDePago obtenerFormaDePagoDelUsuario(Scanner scanner) {
        System.out.print("Ingrese la forma de pago (Efectivo, Cheque, etc.): ");
        String formaDePago = scanner.nextLine();

        switch (formaDePago.toUpperCase()) {
            case "EFECTIVO":
                System.out.print("Ingrese el importe en efectivo: ");
                int importeEfectivo = Integer.parseInt(scanner.nextLine());
                return new Efectivo(importeEfectivo);

            case "CHEQUE":
                System.out.print("Ingrese el importe del cheque: ");
                int importeCheque = Integer.parseInt(scanner.nextLine());

                // Obtener información adicional para un cheque
                System.out.print("Ingrese la fecha de emisión del cheque (formato dd/MM/yyyy): ");
                Date fechaEmision = obtenerFechaDelUsuario(scanner);

                System.out.print("Ingrese la fecha de vencimiento del cheque (formato dd/MM/yyyy): ");
                Date fechaVencimiento = obtenerFechaDelUsuario(scanner);

                System.out.print("Ingrese la firma del cheque: ");
                String firma = scanner.nextLine();

                return new Cheque(importeCheque, fechaEmision, fechaVencimiento, firma);

            default:
                System.out.println("Forma de pago no reconocida. Se utilizará Efectivo por defecto.");
                System.out.print("Ingrese el importe en efectivo: ");
                int importeDefault = Integer.parseInt(scanner.nextLine());
                return new Efectivo(importeDefault);
        }
    }

    private static Date obtenerFechaDelUsuario(Scanner scanner) {
        while (true) {
            try {
                String fechaString = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.parse(fechaString);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Ingrese la fecha nuevamente (formato dd/MM/yyyy): ");
            }
        }
    }

    private static double obtenerMontoDelUsuario(Scanner scanner) {
        System.out.print("Ingrese el monto de la orden de pago: ");
        return scanner.nextDouble();
    }

}