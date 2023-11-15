<h1> Sistema Proveedores </h1>

Trabajo Práctico realizado en grupo para la Universidad Argentina de la Empresa, utilizando Java 17. En el mismo se utilizó el patrón singleton y MVC. Consigna:

<h2>Antecedentes</h2>

Job-Soft es una empresa experta en sistemas de facturación. Su sistema Factura 2023 tiene una amplia penetración en el mercado argentino y el grado de satisfacción de sus clientes es alto.
 
El sistema se encarga de la administración de productos, clientes, emisión de remitos y facturas electrónica mediante la conexión por webservice con AFIP, cobros, cuenta corriente de clientes y presentación mensual del libro IVA ventas.
 
La empresa recibe constantes solicitudes de sus clientes para incorporar un módulo para administrar proveedores. La gerencia decide iniciar el proyecto de desarrollo del mmódulo de proveedores para Factura 2000.

<h2>Proveedores</h2>

Cuando una empresa decide adquirir productos o servicios, la compra es formalizada por una factura donde consta el CUIT de la empresa proveedora, responsabilidad frente al IVA (responsable inscripto o monotributo), razón social, nombre de fantasía, dirección, teléfono, correo electrónico (puede no estar) y número de ingresos brutos e inicio de actividades.

Cuando se recibe la primera factura del proveedor se deben poder cargar toda la información que consta en la cabecera de la factura para no volver a cargar los datos y, a partir de ese momento, identificar al proveedor sólo por su CUIT.

Los proveedores son agrupados por rubros. Cada rubro representa los tipos de productos y servicios que puede proveer el proveedor.

Algunos ejemplos de rubros:
• Medicina Prepaga
• Viáticos y movilidad
• Mantenimiento de muebles e instalaciones
• Librería y otros insumos
• Papelería e impresiones
• Productos de reventa

Un mismo proveedor puede brindar productos o servicios para uno o más rubros.

<h2>Productos y servicios</h2>

La empresa adquiere distintos productos o servicios. Cada producto o servicio pertenece a un único rubro.
Un mismo producto puede adquirirse de más de un proveedor a la vez. 
Los productos se compran por tipo de unidad (unidad, peso, horas), tienen un precio por unidad (acordado con el proveedor) y el tipo de IVA (2,5%, 5%, 10,5%, 21% o 27%)

<h2>Retención de impuestos</h2>

Cada proveedor es susceptible a recibir retenciones de impuestos (IVA, IIBB, Ganancias). Cuando un proveedor no desea que la empresa le retenga un impuesto determinado puede tramitar y luego presentar un certificado de no retención (por ejemplo, de ganancias) a la empresa la cual, por un período de tiempo (determinado por el certificado presentado) no se retendrá el impuesto.
Al finalizar el tiempo determinado por el certificado, la empresa debe volver a retener el impuesto a menos que el proveedor presente un nuevo certificado.
La retención de los impuestos se realiza por tipo de impuesto y porcentaje. Cada vez que se le realiza un pago a un proveedor, se le descuenta el % establecido en el impuesto a modo de retención.
Hay impuestos como el impuesto a la ganancia donde el porcentaje no es fijo y se incluyen mínimos no imponibles (montos por debajo de los cuales no deben hacerse retenciones). Se adjunta resolución de AFIP por montos de retención de impuestos a las ganancias.

<h2>Órdenes de compra</h2>

Cada compra que se hace a un proveedor se hace mediante la confección de una orden de compra donde constan los productos solicitados y el último precio acordado.
Las empresas pueden tener por política no deber más de cierta cantidad de dinero a cada proveedor (se establece de manera particular según la importancia de cada uno) y el monto de la orden de compra más el dinero adeudado por facturas impagas no debe superar el importe establecido como tope. Se pueden emitir órdenes de compras donde la deuda supere el tope por proveedor siempre y cuando haya una supervisión de por medio.

<h2>Recepción de facturas</h2>

Cuando se reciben facturas emitidas a nombre de la empresa deben estar asociadas a una orden de compra previamente emitida. Al cargar la factura donde constan los productos, precios unitarios e impuestos se deben controlar que los precios facturados coincidan con los emitidos en la orden de compra.
Se pueden recibir facturas SIN orden de compra y SIN que los precios recibidos coincidan, pero se debe pasar por una supervisión previa para la aceptación de la factura.
Un proveedor puede emitir facturas, notas de crédito o notas de débito que conforman la cuenta corriente del proveedor.

<h2>Emisión de órdenes de pago</h2>

Cuando se le paga a un proveedor una o más facturas se emite una orden de pago en la que constan los documentos asociados (factura, nota de crédito o nota de débito), total a cancelar, forma de pago -efectivo / cheque(s)-  y total de retenciones.
A cualquier orden de pago se le pueden asociar cheques propios o de terceros (emitidos por otras empresas) donde consta la fecha de emisión, fecha de vencimiento, firmante e importe.

<h2>Consultas generales</h2>

• Total de facturas recibidas por día y/o proveedor
• Cuenta corriente de proveedores donde se debe visualizar: deuda, documentos recibidos, documentos impagos y pagos realizados.
• Compulsa de precios. Se debe poder elegir un producto de un rubro en particular y visualizar los datos de los proveedores que lo comercializan junto con el último precio acordado.
• Ordenes de pagos emitidas
• Total de deuda por proveedor
• Total de impuestos retenidos
• Consulta de libro IVA compras donde debe constar:
• CUIT del proveedor
• Nombre del proveedor
• Fecha
• Tipo de documento (Factura / NC / ND)
• IVA 2,5%, 5%, 10.5%, 21% y 27%
• Total
