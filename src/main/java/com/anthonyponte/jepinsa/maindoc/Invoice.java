/*
 * Copyright (C) 2022 AnthonyPonte
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.anthonyponte.jepinsa.maindoc;

import com.anthonyponte.jepinsa.controller.MainController;
import com.anthonyponte.jepinsa.custom.MyDateFormat;
import com.anthonyponte.jepinsa.model.Factura;
import com.anthonyponte.jepinsa.model.FacturaDetalle;
import com.anthonyponte.jepinsa.model.Leyenda;
import java.util.prefs.Preferences;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

/**
 * @author AnthonyPonte
 */
public class Invoice {
  private static final Preferences PREFS =
      Preferences.userRoot().node(MainController.class.getPackageName());
  private Document document;

  public Document getStructure(Factura factura) {
    document = new Document();

    Namespace urn =
        Namespace.getNamespace("urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");

    Namespace cac =
        Namespace.getNamespace(
            "cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");

    Namespace cbc =
        Namespace.getNamespace(
            "cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");

    Namespace ccts = Namespace.getNamespace("ccts", "urn:un:unece:uncefact:documentation:2");

    Namespace ds = Namespace.getNamespace("ds", "http://www.w3.org/2000/09/xmldsig#");

    Namespace ext =
        Namespace.getNamespace(
            "ext", "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");

    Namespace qdt =
        Namespace.getNamespace(
            "qdt", "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");

    Namespace udt =
        Namespace.getNamespace(
            "udt", "urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2");

    Namespace xsd = Namespace.getNamespace("xsd", "http://www.w3.org/2001/XMLSchema");

    Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

    document.setRootElement(new Element("Invoice", urn));
    document.getRootElement().addNamespaceDeclaration(urn);
    document.getRootElement().addNamespaceDeclaration(cac);
    document.getRootElement().addNamespaceDeclaration(cbc);
    document.getRootElement().addNamespaceDeclaration(ccts);
    document.getRootElement().addNamespaceDeclaration(ds);
    document.getRootElement().addNamespaceDeclaration(ext);
    document.getRootElement().addNamespaceDeclaration(qdt);
    document.getRootElement().addNamespaceDeclaration(udt);
    document.getRootElement().addNamespaceDeclaration(xsd);
    document.getRootElement().addNamespaceDeclaration(xsi);

    Element tagUBLExtensions =
        new Element("UBLExtensions", ext)
            .addContent(
                new Element("UBLExtension", ext).addContent(new Element("ExtensionContent", ext)));
    document.getRootElement().addContent(tagUBLExtensions);

    // Datos de la Factura electrónica
    // 1. Versión del UBL. M
    Element tagUBLVersionID = new Element("UBLVersionID", cbc).setText(factura.getUbl());
    document.getRootElement().addContent(tagUBLVersionID);

    // 2. Versión de la estructura del documento. M
    Element tagCustomizationID =
        new Element("CustomizationID", cbc)
            // C
            .setAttribute("schemeAgencyName", "PE:SUNAT")
            .setText(factura.getVersion());
    document.getRootElement().addContent(tagCustomizationID);

    // 3 Numeración, conformada por serie y número correlativo. M
    Element tagID =
        new Element("ID", cbc).setText(factura.getSerie() + "-" + factura.getCorrelativo());
    document.getRootElement().addContent(tagID);

    // 4 Fecha de emisión. M
    Element tagIssueDate =
        new Element("IssueDate", cbc).setText(MyDateFormat.yyyy_MM_dd(factura.getFechaEmision()));
    document.getRootElement().addContent(tagIssueDate);

    // 5 Hora de emisión. C
    if (factura.getHoraEmision() != null) {
      Element tagIssueTime =
          new Element("IssueTime", cbc).setText(MyDateFormat.yyyy_MM_dd(factura.getHoraEmision()));
      document.getRootElement().addContent(tagIssueTime);
    }

    // 8 Fecha de Vencimiento. C
    if (factura.getFechaVencimiento() != null) {
      Element tagDueDate =
          new Element("DueDate", cbc)
              .setText(MyDateFormat.yyyy_MM_dd(factura.getFechaVencimiento()));
      document.getRootElement().addContent(tagDueDate);
    }

    //    // 6 Tipo de documento. M
    //    Element tagInvoiceTypeCode =
    //        new Element("InvoiceTypeCode", cbc)
    //            .setAttribute("listAgencyName", "PE:SUNAT")
    //            .setAttribute("listName", "Tipo de Documento")
    //            .setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01")
    //            // 58 Tipo de operación. M
    //            .setAttribute("listID", factura.getTipoOperacion())
    //            .setText(encabezado.getTipoDocumento());
    //    document.getRootElement().addContent(tagInvoiceTypeCode);
    //
    //    // 60 FISE (Ley 29852) Fondo Inclusión Social Energético. C
    //    //
    //    // 61 Restitución Simplificada de Derechos Arancelarios. C
    //    //
    //    // 57 Leyendas. C
    //    if (factura.getLeyendas() != null) {
    //      for (Leyenda leyenda : factura.getLeyendas()) {
    //        Element tagNote =
    //            new Element("Note", cbc)
    //                .setAttribute("languageLocaleID", leyenda.getCodigo())
    //                .setText(leyenda.getDescripcion());
    //        document.getRootElement().addContent(tagNote);
    //      }
    //    }
    //
    //    // 7 Tipo de moneda. M
    //    Element tagDocumentCurrencyCode =
    //        new Element("DocumentCurrencyCode", cbc)
    //            .setAttribute("listID", "ISO 4217 Alpha")
    //            .setAttribute("listName", "Currency")
    //            .setAttribute("listAgencyName", "United Nations Economic Commission for Europe")
    //            .setText(factura.getMoneda().getCodigo());
    //    document.getRootElement().addContent(tagDocumentCurrencyCode);
    //
    //    // 59 Número de la orden de compra. C
    //    if (!adicional.getOrdenCompra().equals("")) {
    //
    //      Element tagOrderReference =
    //          new Element("OrderReference", cac)
    //              .addContent(new Element("ID", cbc).setText(adicional.getOrdenCompra()));
    //      document.getRootElement().addContent(tagOrderReference);
    //    }
    //
    //    // Documentos de referencia
    //    // 22 Tipo y número de la guía de remisión relacionada. C
    //    for (Documento guia : referencias.getGuiaRemision()) {
    //      if (!guia.getNumeracion().equals("")) {
    //        Element tagDespatchDocumentReference =
    //            new Element("DespatchDocumentReference", cac)
    //                .addContent(new Element("ID", cbc).setText(guia.getNumeracion()))
    //                .addContent(
    //                    new Element("DocumentTypeCode", cbc)
    //                        .setAttribute("listAgencyName", "PE:SUNAT")
    //                        .setAttribute("listName", "Tipo de Documento")
    //                        .setAttribute(
    //                            "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01")
    //                        .setText(guia.getTipo()));
    //        document.getRootElement().addContent(tagDespatchDocumentReference);
    //      }
    //    }
    //
    //    // 23 Tipo y número de otro documento relacionado. C
    //    for (Documento referencia : referencias.getDocumentosrelacionados()) {
    //
    //      if (!referencia.getNumeracion().equals("")) {
    //
    //        Element tagAdditionalDocumentReference =
    //            new Element("AdditionalDocumentReference", cac)
    //                .addContent(new Element("ID", cbc).setText(referencia.getNumeracion()))
    //                .addContent(
    //                    new Element("DocumentTypeCode", cbc)
    //                        .setAttribute("listAgencyName", "PE:SUNAT")
    //                        .setAttribute("listName", "Documento Relacionado")
    //                        .setAttribute(
    //                            "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo12")
    //                        .setText(referencia.getTipo()));
    //        document.getRootElement().addContent(tagAdditionalDocumentReference);
    //      }
    //    }
    //
    //    // 9 Firma Digital. M
    //    Element tagSignature =
    //        new Element("Signature", cac)
    //            .addContent(new Element("ID", cbc).setText(firma.getId()))
    //            .addContent(
    //                new Element("SignatoryParty", cac)
    //                    .addContent(
    //                        new Element("PartyIdentification", cac)
    //                            .addContent(new Element("ID", cbc).setText(emisor.getNumero())))
    //                    .addContent(
    //                        new Element("PartyName", cac)
    //                            .addContent(new Element("Name",
    // cbc).setText(emisor.getNombre()))))
    //            .addContent(
    //                new Element("DigitalSignatureAttachment", cac)
    //                    .addContent(
    //                        new Element("ExternalReference", cac)
    //                            .addContent(new Element("URI", cbc).setText(firma.getUri()))));
    //    document.getRootElement().addContent(tagSignature);
    //
    //    // Datos del Emisor
    //    Element tagAccountingSupplierParty = new Element("AccountingSupplierParty", cac);
    //    Element tagParty = new Element("Party", cac);
    //    Element tagPartyLegalEntity = new Element("PartyLegalEntity", cac);
    //    Element tagRegistrationAddress = new Element("RegistrationAddress", cac);
    //
    //    // 10 Número de RUC. M
    //    tagParty.addContent(
    //        new Element("PartyIdentification", cac)
    //            .addContent(
    //                new Element("ID", cbc)
    //                    .setAttribute("schemeID", emisor.getTipo())
    //                    .setAttribute("schemeName", "Documento de Identidad")
    //                    .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                    .setAttribute("schemeURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
    //                    .setText(emisor.getNumero())));
    //
    //    // 11 Nombre Comercial. C
    //    if (!emisor.getNombreComercial().equals("")) {
    //
    //      tagParty.addContent(
    //          new Element("PartyName", cac)
    //              .addContent(new Element("Name", cbc).setText(emisor.getNombreComercial())));
    //    }
    //
    //    // 12 Apellidos y nombres, denominación o razón social. M
    //    tagPartyLegalEntity.addContent(
    //        new Element("RegistrationName", cbc).setText(emisor.getNombre()));
    //
    //    // 13 Domicilio Fiscal. C
    //    if (!emisor.getUbigeo().equals("")) {
    //
    //      tagRegistrationAddress.addContent(
    //          new Element("ID", cbc)
    //              .setAttribute("schemeAgencyName", "PE:INEI")
    //              .setAttribute("schemeName", "Ubigeos")
    //              .setText(emisor.getUbigeo()));
    //    }
    //
    //    // 16. Código asignado por SUNAT para el establecimiento anexo declarado en el RUC. M
    //    tagRegistrationAddress.addContent(
    //        new Element("AddressTypeCode", cbc)
    //            .setAttribute("listAgencyName", "PE:SUNAT")
    //            .setAttribute("listName", "Establecimientos anexos")
    //            .setText(emisor.getCodigoDomicilioFizcal()));
    //
    //    // 13 Domicilio Fiscal. C
    //    if (!emisor.getDireccion().equals("")) {
    //
    //      tagRegistrationAddress
    //          .addContent(new Element("CitySubdivisionName",
    // cbc).setText(emisor.getUrbanizacion()))
    //          .addContent(new Element("CityName", cbc).setText(emisor.getProvincia()))
    //          .addContent(new Element("CountrySubentity", cbc).setText(emisor.getDepartamento()))
    //          .addContent(new Element("District", cbc).setText(emisor.getDistrito()))
    //          .addContent(
    //              new Element("AddressLine", cac)
    //                  .addContent(new Element("Line", cbc).setText(emisor.getDireccion())))
    //          .addContent(
    //              new Element("Country", cac)
    //                  .addContent(
    //                      new Element("IdentificationCode", cbc)
    //                          .setAttribute("listID", "ISO 3166-1")
    //                          .setAttribute(
    //                              "listAgencyName", "United Nations Economic Commission for
    // Europe")
    //                          .setAttribute("listName", "Country")
    //                          .setText(emisor.getCodigoPais())));
    //    }
    //
    //    tagPartyLegalEntity.addContent(tagRegistrationAddress);
    //    tagParty.addContent(tagPartyLegalEntity);
    //    tagAccountingSupplierParty.addContent(tagParty);
    //    document.getRootElement().addContent(tagAccountingSupplierParty);
    //
    //    if (!emisor.getDireccionEntrega().getDireccion().equals("")) {
    //
    //      Element tagDeliveryTerms =
    //          new Element("DeliveryTerms", cac)
    //              // 62 Incoterm. C
    //              .addContent(new Element("ID",
    // cbc).setText(emisor.getDireccionEntrega().getUbigeo()))
    //              // 14 Dirección del lugar en el que se entrega el bien. C.
    //              .addContent(
    //                  new Element("DeliveryLocation", cac)
    //                      .addContent(
    //                          new Element("Address", cac)
    //                              .addContent(
    //                                  new Element("StreetName", cbc)
    //                                      .setText(emisor.getDireccionEntrega().getDireccion()))
    //                              .addContent(
    //                                  new Element("CitySubdivisionName", cbc)
    //
    // .setText(emisor.getDireccionEntrega().getUrbanizacion()))
    //                              .addContent(
    //                                  new Element("CityName", cbc)
    //                                      .setText(emisor.getDireccionEntrega().getUbigeo()))
    //                              .addContent(
    //                                  new Element("CountrySubentity", cbc)
    //                                      .setText(emisor.getDireccionEntrega().getProvincia()))
    //                              .addContent(
    //                                  new Element("District", cbc)
    //                                      .setText(emisor.getDireccionEntrega().getDistrito()))
    //                              // 15. Pais del uso, explotación o aprovechamiento del servicio.
    // -
    //                              // Código de país. C
    //                              .addContent(
    //                                  new Element("Country", cac)
    //                                      .addContent(
    //                                          new Element("IdentificationCode", cac)
    //                                              .setAttribute("listID", "ISO 3166-1")
    //                                              .setAttribute(
    //                                                  "listAgencyName",
    //                                                  "United Nations Economic Commission for
    // Europe")
    //                                              .setAttribute("listName", "Country")
    //                                              .setText(
    //
    // emisor.getDireccionEntrega().getCodigoPais())))));
    //      document.getRootElement().addContent(tagDeliveryTerms);
    //    }
    //
    //    // Datos del cliente o receptor
    //    Element tagAccountingCustomerParty = new Element("AccountingCustomerParty", cac);
    //    Element tagParty2 = new Element("Party", cac);
    //    Element tagPartyLegalEntity2 = new Element("PartyLegalEntity", cac);
    //
    //    // 17 Tipo y Número de documento de identidad del adquirente o usuario. M
    //    tagParty2.addContent(
    //        new Element("PartyIdentification", cac)
    //            .addContent(
    //                new Element("ID", cbc)
    //                    .setAttribute("schemeID", cliente.getTipo())
    //                    .setAttribute("schemeName", "Documento de Identidad")
    //                    .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                    .setAttribute("schemeURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
    //                    .setText(cliente.getNumero())));
    //
    //    // 18 Apellidos y nombres, denominación o razón social del adquirente o usuario. M
    //    tagPartyLegalEntity2.addContent(
    //        new Element("RegistrationName", cbc).setText(cliente.getNombre()));
    //
    //    // 19 Dirección del adquiriente o usuario. C
    //    if (!cliente.getDireccion().equals("")) {
    //      tagPartyLegalEntity2.addContent(
    //          new Element("RegistrationAddress", cac)
    //              .addContent(
    //                  new Element("ID", cbc)
    //                      .setAttribute("schemeAgencyName", "PE:INEI")
    //                      .setAttribute("schemeName", "Ubigeos")
    //                      .setText(cliente.getUbigeo()))
    //              .addContent(
    //                  new Element("CitySubdivisionName", cbc).setText(cliente.getUrbanizacion()))
    //              .addContent(new Element("CityName", cbc).setText(cliente.getProvincia()))
    //              .addContent(new Element("CountrySubentity",
    // cbc).setText(cliente.getDepartamento()))
    //              .addContent(new Element("District", cbc).setText(cliente.getDistrito()))
    //              .addContent(
    //                  new Element("AddressLine", cac)
    //                      .addContent(new Element("Line", cbc).setText(cliente.getDireccion())))
    //              .addContent(
    //                  new Element("Country", cac)
    //                      .addContent(
    //                          new Element("IdentificationCode", cbc)
    //                              .setAttribute("listID", "ISO 3166-1")
    //                              .setAttribute(
    //                                  "listAgencyName", "United Nations Economic Commission for
    // Europe")
    //                              .setAttribute("listName", "Country")
    //                              .setText(cliente.getCodigoPais()))));
    //    }
    //    // 20 Tipo y Número de documento de identidad de otros participantes asociados a la
    // transacción.
    //    // C
    //    //
    //    tagParty2.addContent(tagPartyLegalEntity2);
    //    tagAccountingCustomerParty.addContent(tagParty2);
    //    document.getRootElement().addContent(tagAccountingCustomerParty);
    //
    //    // 174 Forma de pago
    //    Element tagPaymentTerms =
    //        new Element("PaymentTerms", cac).addContent(new Element("ID",
    // cbc).setText("FormaPago"));
    //
    //    Element tagPaymentMeansID = new Element("PaymentMeansID", cbc);
    //    if (condicion.getTipo().equals("CONTADO")
    //        || condicion.getTipo().equals("TRANSFERENCIA GRATUITA")) {
    //      tagPaymentMeansID.setText("Contado");
    //      tagPaymentTerms.addContent(tagPaymentMeansID);
    //    } else {
    //      tagPaymentMeansID.setText("Credito");
    //      tagPaymentTerms.addContent(tagPaymentMeansID);
    //
    //      tagPaymentTerms.addContent(
    //          new Element("Amount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(condicion.getMonto()));
    //    }
    //    document.getRootElement().addContent(tagPaymentTerms);
    //
    //    if (!condicion.getTipo().equals("CONTADO")) {
    //      if (!condicion.getTipo().equals("TRANSFERENCIA GRATUITA")) {
    //        Element tagPaymentTerms1 =
    //            new Element("PaymentTerms", cac)
    //                .addContent(new Element("ID", cbc).setText("FormaPago"))
    //                .addContent(new Element("PaymentMeansID", cbc).setText("Cuota001"))
    //                .addContent(
    //                    new Element("Amount", cbc)
    //                        .setAttribute("currencyID", encabezado.getMoneda())
    //                        .setText(condicion.getMonto()))
    //                .addContent(new Element("PaymentDueDate", cbc).setText(condicion.getFecha()));
    //        document.getRootElement().addContent(tagPaymentTerms1);
    //      }
    //    }
    //
    //    // Datos del comprador
    //    // 21 Tipo y Número de documento de identidad del comprador. C
    //    //
    //    // 50 Cargos y Descuentos Globales. C
    //    if (!total.getCuota().getMonto().equals("0.00")) {
    //      Element tagAllowanceCharge =
    //          new Element("AllowanceCharge", cbc)
    //              .addContent(
    //                  new Element("ChargeIndicator",
    // cbc).setText(total.getCuota().getIndicador()))
    //              .addContent(
    //                  new Element("AllowanceChargeReasonCode", cbc)
    //                      .setAttribute("listAgencyName", "PE:SUNAT")
    //                      .setAttribute("listName", "Cargo/descuento")
    //                      .setAttribute("listURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo53")
    //                      .setText(total.getCuota().getCodigo()))
    //              .addContent(
    //                  new Element("MultiplierFactorNumeric", cbc)
    //                      .setText(total.getCuota().getPorcentaje()))
    //              .addContent(
    //                  new Element("Amount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getCuota().getMonto()))
    //              .addContent(
    //                  new Element("BaseAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getCuota().getMontoBase()));
    //      document.getRootElement().addContent(tagAllowanceCharge);
    //    }
    //
    //    // Totales de la Factura
    //    // 40 Monto total de impuestos. M
    //    Element tagTaxTotal =
    //        new Element("TaxTotal", cac)
    //            .addContent(
    //                new Element("TaxAmount", cbc)
    //                    .setAttribute("currencyID", encabezado.getMoneda())
    //                    .setText(total.getImpuesto()));
    //
    //    // 41 Total Valor de Venta - Exportación. C
    //    if (!total.getExportacion().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getExportacion()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText("0.00"))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("9995"))
    //                              .addContent(new Element("Name", cbc).setText("EXP"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    //    }
    //
    //    // 42 Total valor de venta - operaciones inafectas. C
    //    if (!total.getInafectas().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getInafectas()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText("0.00"))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("9998"))
    //                              .addContent(new Element("Name", cbc).setText("INA"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    //    }
    //
    //    // 43 Total valor de venta - operaciones exoneradas. C
    //    if (!total.getExoneradas().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getExoneradas()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText("0.00"))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("9997"))
    //                              .addContent(new Element("Name", cbc).setText("EXO"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("VAT")))));
    //    }
    //
    //    // 44 Total valor de venta - operaciones gratuitas
    //    // 45 Sumatoria de tributos de operaciones gratuitas. C
    //    if (!total.getGratuitas().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getGratuitas()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getIgvGratuitas()))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("9996"))
    //                              .addContent(new Element("Name", cbc).setText("GRA"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    //    }
    //
    //    // 46 Total valor de venta - operaciones gravadas (IGV o IVAP). M
    //    // 47 Total Importe IGV o IVAP. M
    //    if (!total.getGravadas().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getGravadas()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getIgv()))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("1000"))
    //                              .addContent(new Element("Name", cbc).setText("IGV"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("VAT")))));
    //    }
    //
    //    // 48 Sumatoria ISC. C
    //    if (!total.getIsc().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getMontoIsc()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getIsc()))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("2000"))
    //                              .addContent(new Element("Name", cbc).setText("ISC"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("EXC")))));
    //    }
    //
    //    // 49 Sumatoria Otros Tributos. C
    //    if (!total.getOtrosTributos().equals("0.00")) {
    //      tagTaxTotal.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getMontoOtrosTributos()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(total.getOtrosTributos()))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute(
    //                                          "schemeURI",
    //                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
    //                                      .setText("9999"))
    //                              .addContent(
    //                                  new Element("Name", cbc).setText("OTROS CONCEPTOS DE PAGO"))
    //                              .addContent(new Element("TaxTypeCode", cbc).setText("OTH")))));
    //    }
    //
    //    document.getRootElement().addContent(tagTaxTotal);
    //
    //    Element tagLegalMonetaryTotal = new Element("LegalMonetaryTotal", cac);
    //
    //    // 54 Total Valor de Venta. C
    //    tagLegalMonetaryTotal.addContent(
    //        new Element("LineExtensionAmount", cbc)
    //            .setAttribute("currencyID", encabezado.getMoneda())
    //            .setText(total.getValorVenta()));
    //
    //    // 55 Total Precio de Venta. C
    //    tagLegalMonetaryTotal.addContent(
    //        new Element("TaxInclusiveAmount", cbc)
    //            .setAttribute("currencyID", encabezado.getMoneda())
    //            .setText(total.getPrecioVenta()));
    //
    //    // 51 Total Descuentos (Que no afectan la base). C
    //    if (!total.getDescuentos().equals("0.00")) {
    //      tagLegalMonetaryTotal.addContent(
    //          new Element("AllowanceTotalAmount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(total.getDescuentos()));
    //    }
    //
    //    // 52 Total otros Cargos (Que no afectan la base). C
    //    if (!total.getOtrosCargos().equals("0.00")) {
    //      tagLegalMonetaryTotal.addContent(
    //          new Element("ChargeTotalAmount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(total.getOtrosCargos()));
    //    }
    //
    //    // 56 Monto para Redondeo del Importe Total. C
    //    if (!total.getTotalRedondeado().equals("0.00")) {
    //      tagLegalMonetaryTotal.addContent(
    //          new Element("PayableRoundingAmount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(total.getTotalRedondeado()));
    //    }
    //
    //    // 53 Importe total de la venta, cesión en uso o del servicio prestado. M
    //    tagLegalMonetaryTotal.addContent(
    //        new Element("PayableAmount", cbc)
    //            .setAttribute("currencyID", encabezado.getMoneda())
    //            .setText(total.getTotal()));
    //
    //    document.getRootElement().addContent(tagLegalMonetaryTotal);
    //
    //    // Información Adicional - Percepciones
    //    //
    //    // Información Adicional  - Anticipos
    //    //
    //    // Información Adicional - Sustento de traslado de mercaderias
    //    //
    //    // Información Adicional  - Transporte terrestre de pasajeros
    //    //
    //    // Información Adicional  - Detracciones
    //    //
    //    // Detracciones - Recursos Hidrobiológicos
    //    //
    //    // Detracciones - Servicio de transporte de Carga
    //    //
    //    // Detracciones - Servicio de transporte de Carga - BillLine de tramos (De corresponder)
    //    //
    //    // Detracciones - Servicio de transporte de Carga - BillLine del (os) Vehículo (s)
    //    //
    //    // Información Adicional  - Beneficio de hospedaje
    //    //
    //    // Información Adicional  - Paquete Turístico
    //    //
    //    // Ventas Sector Público
    //    //
    //    // Gastos intereses hipotecarios (incluye primera vivienda)
    //    //
    //    // Migración de documentos autorizados - Carta Porte Aéreo
    //    //
    //    // Migración de documentos autorizados - BVME para transporte ferroviario de pasajeros
    //    //
    //    // Migración de documentos autorizados - Pago de regalía petrolera
    //    //
    //    // Información Adicional a nivel de ítem
    //    //
    //    // Datos del detalle o Ítem de la Factura
    //    for (FacturaDetalle detalle : factura.getFacturaDetalles()) {
    //
    //      Element tagInvoiceLine = new Element("InvoiceLine", cac);
    //
    //      // 24 Número de orden del Ítem. M
    //      tagInvoiceLine.addContent(new Element("ID", cbc).setText(detalle.getNumero()));
    //
    //      // 25 Unidad de medida por ítem. M
    //      // 26 Cantidad de unidades por ítem. M
    //      tagInvoiceLine.addContent(
    //          new Element("InvoicedQuantity", cbc)
    //              .setAttribute("unitCode", detalle.getUm())
    //              .setAttribute("unitCodeListID", "UN/ECE rec 20")
    //              .setAttribute("unitCodeListAgencyID", "United Nations Economic Commission for
    // Europe")
    //              .setText(detalle.getCantidad()));
    //
    //      // 38 Valor de venta por ítem. M
    //      tagInvoiceLine.addContent(
    //          new Element("LineExtensionAmount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(detalle.getValorVenta()));
    //
    //      // 33 Precio de venta unitario por item. M
    //      if (!detalle.getPrecioVentaUnitario().equals("0.00")) {
    //        tagInvoiceLine.addContent(
    //            new Element("PricingReference", cac)
    //                .addContent(
    //                    new Element("AlternativeConditionPrice", cac)
    //                        .addContent(
    //                            new Element("PriceAmount", cbc)
    //                                .setAttribute("currencyID", encabezado.getMoneda())
    //                                .setText(detalle.getPrecioVentaUnitario()))
    //                        .addContent(
    //                            new Element("PriceTypeCode", cbc)
    //                                .setAttribute("listName", "Tipo de Precio")
    //                                .setAttribute("listAgencyName", "PE:SUNAT")
    //                                .setAttribute(
    //                                    "listURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo16")
    //                                .setText("01"))));
    //      }
    //
    //      // 34 Valor referencial unitario por ítem en operaciones no onerosas. C
    //      if (detalle.getPrecioVentaUnitario().equals("0.00")) {
    //        tagInvoiceLine.addContent(
    //            new Element("PricingReference", cac)
    //                .addContent(
    //                    new Element("AlternativeConditionPrice", cac)
    //                        .addContent(
    //                            new Element("PriceAmount", cbc)
    //                                .setAttribute("currencyID", encabezado.getMoneda())
    //                                .setText(detalle.getValorReferencialUnitario()))
    //                        .addContent(
    //                            new Element("PriceTypeCode", cbc)
    //                                .setAttribute("listName", "Tipo de Precio")
    //                                .setAttribute("listAgencyName", "PE:SUNAT")
    //                                .setAttribute(
    //                                    "listURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo16")
    //                                .setText("02"))));
    //      }
    //
    //      // 39 Cargo/descuento por ítem. C
    //      if (!detalle.getCuota().getMonto().equals("0.00")) {
    //        tagInvoiceLine.addContent(
    //            new Element("AllowanceCharge", cac)
    //                .addContent(
    //                    new Element("ChargeIndicator",
    // cbc).setText(detalle.getCuota().getIndicador()))
    //                .addContent(
    //                    new Element("AllowanceChargeReasonCode", cbc)
    //                        .setText(detalle.getCuota().getCodigo()))
    //                .addContent(
    //                    new Element("MultiplierFactorNumeric", cbc)
    //                        .setText(detalle.getCuota().getPorcentaje()))
    //                .addContent(
    //                    new Element("Amount", cbc)
    //                        .setAttribute("currencyID", encabezado.getMoneda())
    //                        .setText(detalle.getCuota().getMonto()))
    //                .addContent(
    //                    new Element("BaseAmount", cbc)
    //                        .setAttribute("currencyID", encabezado.getMoneda())
    //                        .setText(detalle.getCuota().getMontoBase())));
    //      }
    //
    //      Element tagTaxTotalLine = new Element("TaxTotal", cac);
    //      // 35 Monto total de impuestos del ítem. M
    //      tagTaxTotalLine.addContent(
    //          new Element("TaxAmount", cbc)
    //              .setAttribute("currencyID", encabezado.getMoneda())
    //              .setText(detalle.getImpuesto()));
    //
    //      // 36 Afectación al IGV por la línea/Afectación IVAP por la línea. M            .
    //      tagTaxTotalLine.addContent(
    //          new Element("TaxSubtotal", cac)
    //              .addContent(
    //                  new Element("TaxableAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(detalle.getIgv().getBase()))
    //              .addContent(
    //                  new Element("TaxAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(detalle.getIgv().getValor()))
    //              .addContent(
    //                  new Element("TaxCategory", cac)
    //                      .addContent(
    //                          new Element("ID", cbc)
    //                              .setAttribute("schemeID", "UN/ECE 5305")
    //                              .setAttribute("schemeName", "Tax Category Identifier")
    //                              .setAttribute(
    //                                  "schemeAgencyName",
    //                                  "United Nations Economic Commission for Europe")
    //                              .setText("S"))
    //                      .addContent(
    //                          new Element("Percent",
    // cbc).setText(detalle.getIgv().getPorcentaje()))
    //                      .addContent(
    //                          new Element("TaxExemptionReasonCode", cbc)
    //                              .setAttribute("listAgencyName", "PE:SUNAT")
    //                              .setAttribute("listName", "Afectacion del IGV")
    //                              .setAttribute(
    //                                  "listURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07")
    //                              .setText(detalle.getIgv().getTipo()))
    //                      .addContent(
    //                          new Element("TaxScheme", cac)
    //                              .addContent(
    //                                  new Element("ID", cbc)
    //                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
    //                                      .setAttribute("schemeID", "UN/ECE 5153")
    //                                      .setAttribute("schemeName", "Codigo de tributos")
    //                                      .setText(detalle.getIgv().getId()))
    //                              .addContent(
    //                                  new Element("Name",
    // cbc).setText(detalle.getIgv().getNombre()))
    //                              .addContent(
    //                                  new Element("TaxTypeCode", cbc)
    //                                      .setText(detalle.getIgv().getCodigo())))));
    //
    //      // 37 Afectación del ISC por la línea. C.
    //      if (!detalle.getIsc().getValor().equals("0.00")) {
    //        tagTaxTotalLine.addContent(
    //            new Element("TaxSubtotal", cac)
    //                .addContent(
    //                    new Element("TaxableAmount", cbc)
    //                        .setAttribute("currencyID", encabezado.getMoneda())
    //                        .setText(detalle.getValorVenta()))
    //                .addContent(
    //                    new Element("TaxAmount", cbc)
    //                        .setAttribute("currencyID", encabezado.getMoneda())
    //                        .setText(detalle.getIsc().getValor()))
    //                .addContent(
    //                    new Element("TaxCategory", cac)
    //                        .addContent(
    //                            new Element("ID", cbc)
    //                                .setAttribute("schemeID", "UN/ECE 5305")
    //                                .setAttribute("schemeName", "Tax Category Identifier")
    //                                .setAttribute(
    //                                    "schemeAgencyName",
    //                                    "United Nations Economic Commission for Europe")
    //                                .setText("S"))
    //                        .addContent(new Element("Percent", cbc).setText("20.00"))
    //                        .addContent(
    //                            new Element("TaxExemptionReasonCode", cbc)
    //                                .setAttribute("listAgencyName", "PE:SUNAT")
    //                                .setAttribute(
    //                                    "listName", "SUNAT:Codigo de Tipo de Afectación del IGV")
    //                                .setAttribute(
    //                                    "listURI",
    // "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07")
    //                                .setText(detalle.getIsc().getTipo()))
    //                        .addContent(new Element("TierRange", cbc).setText(""))
    //                        .addContent(
    //                            new Element("TaxScheme", cac)
    //                                .addContent(
    //                                    new Element("ID", cbc)
    //                                        .setAttribute(
    //                                            "schemeAgencyName",
    //                                            "United Nations Economic Commission for Europe")
    //                                        .setAttribute("schemeID", "UN/ECE 5153")
    //                                        .setAttribute("schemeName", "Tax Scheme Identifier")
    //                                        .setText("2000"))
    //                                .addContent(new Element("Name", cbc).setText("ISC"))
    //                                .addContent(new Element("TaxTypeCode",
    // cbc).setText("EXC")))));
    //      }
    //      tagInvoiceLine.addContent(tagTaxTotalLine);
    //
    //      Element tagItem = new Element("Item", cac);
    //      // 31 Descripción detallada del servicio prestado, bien vendido o cedido en uso,
    // indicando las
    //      // características.. M.
    //      tagItem.addContent(new Element("Description", cbc).setText(detalle.getDescripcion()));
    //
    //      // 27 Código de producto. C.
    //      if (!detalle.getCodigo().equals("")) {
    //        tagItem.addContent(
    //            new Element("SellersItemIdentification", cac)
    //                .addContent(new Element("ID", cbc).setText(detalle.getCodigo())));
    //      }
    //
    //      // 28. Código de producto SUNAT. C.
    //      if (!detalle.getCodigoSUNAT().equals("")) {
    //        tagItem.addContent(
    //            new Element("CommodityClassification", cac)
    //                .addContent(
    //                    new Element("ItemClassificationCode", cbc)
    //                        .setAttribute("listID", "UNSPSC")
    //                        .setAttribute("listAgencyName", "GS1 US")
    //                        .setAttribute("listName", "Item Classification")
    //                        .setText(detalle.getCodigoSUNAT())));
    //      }
    //      tagInvoiceLine.addContent(tagItem);
    //
    //      // 29 Código de producto GS1 . C
    //      //
    //      // 30 Número de placa del vehículo (Información Adicional - Gastos art.37° Renta). C
    //      //
    //      // 32 Valor unitario por ítem. M
    //      tagInvoiceLine.addContent(
    //          new Element("Price", cac)
    //              .addContent(
    //                  new Element("PriceAmount", cbc)
    //                      .setAttribute("currencyID", encabezado.getMoneda())
    //                      .setText(detalle.getValorUnitario())));
    //
    //      document.getRootElement().addContent(tagInvoiceLine);
    //    }

    return document;
  }
}
