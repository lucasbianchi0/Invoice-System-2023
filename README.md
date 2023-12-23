<h1>Invoice System 2023</h1>

Project carried out in a group for the Argentine University of Business, using Java 17. The singleton and MVC pattern were used in the project. Assignment:

<h2>Background</h2>

Job-Soft is a company specializing in billing systems. Its Factura 2023 system has a significant presence in the Argentine market, and its customers are highly satisfied.

The system manages products, clients, issuance of receipts and electronic invoices through web service connection with AFIP, collections, customer accounts, and monthly presentation of the IVA sales book.

The company receives constant requests from its customers to incorporate a module to manage suppliers. The management decides to start the development project for the Suppliers module for Factura 2000.

<h2>Suppliers</h2>

When a company decides to acquire products or services, the purchase is formalized by an invoice that includes the supplier's CUIT, responsibility for VAT (registered or simplified taxpayer), business name, trade name, address, phone, email (may be absent), and gross income and start of activities numbers.

When receiving the first invoice from the supplier, all the information in the header of the invoice must be loaded so as not to re-enter the data, and from that moment on, the supplier is identified only by its CUIT.

Suppliers are grouped by categories. Each category represents the types of products and services that the supplier can provide.

Some examples of categories:
• Prepaid Medicine
• Travel and Mobility
• Furniture and Facilities Maintenance
• Stationery and Other Supplies
• Stationery and Printing
• Resale Products

The same supplier can provide products or services for one or more categories.

<h2>Products and Services</h2>

The company acquires various products or services. Each product or service belongs to a unique category.
The same product can be purchased from more than one supplier at a time.
Products are purchased by unit type (unit, weight, hours), have a unit price (agreed with the supplier), and the type of VAT (2.5%, 5%, 10.5%, 21%, or 27%).

<h2>Tax Withholding</h2>

Each supplier is subject to withholding taxes (VAT, IIBB, Profits). When a supplier does not want the company to withhold a certain tax, they can apply for and then submit a non-withholding certificate (for example, for profits) to the company, which, for a period of time (specified by the certificate presented), will not withhold the tax.
At the end of the time specified by the certificate, the company must resume withholding the tax unless the supplier presents a new certificate.
Tax withholding is done by tax type and percentage. Each time a payment is made to a supplier, the established percentage of the tax is deducted as a withholding.
There are taxes like the profit tax where the percentage is not fixed, and minimum non-taxable amounts (amounts below which no withholdings should be made) are included. An AFIP resolution is attached for amounts of profit tax withholding.

<h2>Purchase Orders</h2>

Each purchase made to a supplier is made by preparing a purchase order that includes the requested products and the last agreed price.
Companies may have a policy not to owe more than a certain amount of money to each supplier (established individually according to each one's importance), and the amount of the purchase order plus the money owed for unpaid invoices must not exceed the established limit. Purchase orders where the debt exceeds the limit per supplier can be issued as long as there is supervision involved.

<h2>Receipt of Invoices</h2>

When invoices issued to the company are received, they must be associated with a previously issued purchase order. When entering the invoice, which includes the products, unit prices, and taxes, it must be checked that the invoiced prices match those issued in the purchase order.
Invoices can be received WITHOUT a purchase order and WITHOUT matching prices, but they must undergo prior supervision for the acceptance of the invoice.
A supplier can issue invoices, credit notes, or debit notes that make up the supplier's account.

<h2>Issuance of Payment Orders</h2>

When one or more invoices are paid to a supplier, a payment order is issued, which includes the associated documents (invoice, credit note, or debit note), total to be paid, payment method - cash / check(s) - and total withholdings.
Any payment order can be associated with own or third-party checks (issued by other companies), including the issuance date, due date, signer, and amount.

<h2>General Queries</h2>

• Total invoices received per day and/or supplier
• Supplier's account where you should visualize: debt, received documents, unpaid documents, and payments made.
• Price comparison. You should be able to choose a product from a specific category and view the data of the suppliers who market it along with the last agreed price.
• Issued payment orders
• Total debt per supplier
• Total taxes withheld
• Purchase book query where it must include:
• Supplier's CUIT
• Supplier's name
• Date
• Document type (Invoice / Credit Note / Debit Note)
• VAT 2.5%, 5%, 10.5%, 21%, and 27%
• Total
