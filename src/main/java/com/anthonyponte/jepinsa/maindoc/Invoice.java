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
import com.anthonyponte.jepinsa.controller.UsuarioController;
import com.anthonyponte.jepinsa.custom.MyDateFormat;
import com.anthonyponte.jepinsa.model.Documento;
import com.anthonyponte.jepinsa.model.Factura;
import com.anthonyponte.jepinsa.model.FacturaDetalle;
import com.anthonyponte.jepinsa.model.FormaPago;
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

    // 6 Tipo de documento. M
    Element tagInvoiceTypeCode =
        new Element("InvoiceTypeCode", cbc)
            .setAttribute("listAgencyName", "PE:SUNAT")
            .setAttribute("listName", "Tipo de Documento")
            .setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01")
            // 58 Tipo de operación. M
            .setAttribute("listID", factura.getTipoOperacion())
            .setText(factura.getTipoDocumento().getCodigo());
    document.getRootElement().addContent(tagInvoiceTypeCode);

    // 60 FISE (Ley 29852) Fondo Inclusión Social Energético. C
    //
    // 61 Restitución Simplificada de Derechos Arancelarios. C
    //
    // 57 Leyendas. C
    if (factura.getLeyendas() != null) {
      for (Leyenda leyenda : factura.getLeyendas()) {
        Element tagNote =
            new Element("Note", cbc)
                .setAttribute("languageLocaleID", leyenda.getCodigo())
                .setText(leyenda.getDescripcion());
        document.getRootElement().addContent(tagNote);
      }
    }

    // 7 Tipo de moneda. M
    Element tagDocumentCurrencyCode =
        new Element("DocumentCurrencyCode", cbc)
            .setAttribute("listID", "ISO 4217 Alpha")
            .setAttribute("listName", "Currency")
            .setAttribute("listAgencyName", "United Nations Economic Commission for Europe")
            .setText(factura.getMoneda().getCodigo());
    document.getRootElement().addContent(tagDocumentCurrencyCode);

    // 59 Número de la orden de compra. C
    if (!factura.getOrdenCompra().equals("")) {
      Element tagOrderReference =
          new Element("OrderReference", cac)
              .addContent(new Element("ID", cbc).setText(factura.getOrdenCompra()));
      document.getRootElement().addContent(tagOrderReference);
    }

    // Documentos de referencia
    // 22 Tipo y número de la guía de remisión relacionada. C
    if (factura.getGuias() != null) {
      for (Documento guia : factura.getGuias()) {
        Element tagDespatchDocumentReference =
            new Element("DespatchDocumentReference", cac)
                .addContent(
                    new Element("ID", cbc).setText(guia.getSerie() + "-" + guia.getCorrelativo()))
                .addContent(
                    new Element("DocumentTypeCode", cbc)
                        .setAttribute("listAgencyName", "PE:SUNAT")
                        .setAttribute("listName", "Tipo de Documento")
                        .setAttribute(
                            "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01")
                        .setText(guia.getTipo()));
        document.getRootElement().addContent(tagDespatchDocumentReference);
      }
    }

    // 23 Tipo y número de otro documento relacionado. C
    if (factura.getDocumentosRelacionados() != null) {
      for (Documento documento : factura.getDocumentosRelacionados()) {
        Element tagAdditionalDocumentReference =
            new Element("AdditionalDocumentReference", cac)
                .addContent(
                    new Element("ID", cbc)
                        .setText(documento.getSerie() + "-" + documento.getCorrelativo()))
                .addContent(
                    new Element("DocumentTypeCode", cbc)
                        .setAttribute("listAgencyName", "PE:SUNAT")
                        .setAttribute("listName", "Documento Relacionado")
                        .setAttribute(
                            "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo12")
                        .setText(documento.getTipo()));
        document.getRootElement().addContent(tagAdditionalDocumentReference);
      }
    }

    // 9 Firma Digital. M
    Element signature =
        new Element("Signature", cac)
            .addContent(
                new Element("ID", cbc)
                    .setText("SIGN-" + PREFS.get(UsuarioController.FIRMA_USUARIO, "")))
            .addContent(
                new Element("SignatoryParty", cac)
                    .addContent(
                        new Element("PartyIdentification", cac)
                            .addContent(
                                new Element("ID", cbc)
                                    .setText(
                                        factura.getEmisor().getDocumentoIdentidad().getNumero())))
                    .addContent(
                        new Element("PartyName", cac)
                            .addContent(
                                new Element("Name", cbc).setText(factura.getEmisor().getNombre()))))
            .addContent(
                new Element("DigitalSignatureAttachment", cac)
                    .addContent(
                        new Element("ExternalReference", cac)
                            .addContent(
                                new Element("URI", cbc)
                                    .setText(
                                        "#SIGN-"
                                            + PREFS.get(UsuarioController.FIRMA_USUARIO, "")))));
    document.getRootElement().addContent(signature);

    // Datos del Emisor
    Element tagAccountingSupplierParty = new Element("AccountingSupplierParty", cac);
    Element tagParty = new Element("Party", cac);
    Element tagPartyLegalEntity = new Element("PartyLegalEntity", cac);
    Element tagRegistrationAddress = new Element("RegistrationAddress", cac);

    // 10 Número de RUC. M
    tagParty.addContent(
        new Element("PartyIdentification", cac)
            .addContent(
                new Element("ID", cbc)
                    .setAttribute(
                        "schemeID",
                        factura.getEmisor().getDocumentoIdentidad().getTipo().getCodigo())
                    .setAttribute("schemeName", "Documento de Identidad")
                    .setAttribute("schemeAgencyName", "PE:SUNAT")
                    .setAttribute("schemeURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
                    .setText(factura.getEmisor().getDocumentoIdentidad().getNumero())));

    // 11 Nombre Comercial. C
    if (factura.getEmisor().getNombreComercial().isEmpty()) {
      tagParty.addContent(
          new Element("PartyName", cac)
              .addContent(
                  new Element("Name", cbc).setText(factura.getEmisor().getNombreComercial())));
    }

    // 12 Apellidos y nombres, denominación o razón social. M
    tagPartyLegalEntity.addContent(
        new Element("RegistrationName", cbc).setText(factura.getEmisor().getNombre()));

    // 16. Código asignado por SUNAT para el establecimiento anexo declarado en el RUC. M
    tagRegistrationAddress.addContent(
        new Element("AddressTypeCode", cbc)
            .setAttribute("listAgencyName", "PE:SUNAT")
            .setAttribute("listName", "Establecimientos anexos")
            .setText(factura.getEmisor().getDomicilioFiscal().getCodigo()));

    // 13 Domicilio Fiscal. C
    if (factura.getEmisor().getDomicilioFiscal() != null) {
      tagRegistrationAddress
          .addContent(
              new Element("ID", cbc)
                  .setAttribute("schemeAgencyName", "PE:INEI")
                  .setAttribute("schemeName", "Ubigeos")
                  .setText(factura.getEmisor().getDomicilioFiscal().getCodigoUbigeo()))
          .addContent(
              new Element("CitySubdivisionName", cbc)
                  .setText(factura.getEmisor().getDomicilioFiscal().getUrbanizacion()))
          .addContent(
              new Element("CityName", cbc)
                  .setText(factura.getEmisor().getDomicilioFiscal().getProvincia()))
          .addContent(
              new Element("CountrySubentity", cbc)
                  .setText(factura.getEmisor().getDomicilioFiscal().getDepartamento()))
          .addContent(
              new Element("District", cbc)
                  .setText(factura.getEmisor().getDomicilioFiscal().getDistrito()))
          .addContent(
              new Element("AddressLine", cac)
                  .addContent(
                      new Element("Line", cbc)
                          .setText(factura.getEmisor().getDomicilioFiscal().getDescripcion())))
          .addContent(
              new Element("Country", cac)
                  .addContent(
                      new Element("IdentificationCode", cbc)
                          .setAttribute("listID", "ISO 3166-1")
                          .setAttribute(
                              "listAgencyName", "United Nations Economic Commission for Europe")
                          .setAttribute("listName", "Country")
                          .setText(factura.getEmisor().getDomicilioFiscal().getCodigoPais())));
    }

    tagPartyLegalEntity.addContent(tagRegistrationAddress);
    tagParty.addContent(tagPartyLegalEntity);
    tagAccountingSupplierParty.addContent(tagParty);
    document.getRootElement().addContent(tagAccountingSupplierParty);

    // 14 Dirección del lugar en el que se entrega el bien. C.
    // 15 Código del pais del uso, explotación o aprovechamiento del servicio. C.
    if (factura.getDireccionEntrega() != null) {
      Element tagDelivery =
          new Element("Delivery", cac)
              .addContent(
                  new Element("DeliveryLocation", cac)
                      .addContent(
                          new Element("Address", cac)
                              .addContent(
                                  new Element("AddressLine", cac)
                                      .addContent(
                                          new Element("Line", cbc)
                                              .setText(
                                                  factura.getDireccionEntrega().getDescripcion())))
                              .addContent(
                                  new Element("CitySubdivisionName", cbc)
                                      .setText(factura.getDireccionEntrega().getUrbanizacion()))
                              .addContent(
                                  new Element("CityName", cbc)
                                      .setText(factura.getDireccionEntrega().getProvincia()))
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeAgencyName", "PE:INEI")
                                      .setAttribute("schemeName", "Ubigeos")
                                      .setText(factura.getDireccionEntrega().getCodigoUbigeo()))
                              .addContent(
                                  new Element("CountrySubentity", cbc)
                                      .setText(factura.getDireccionEntrega().getDepartamento()))
                              .addContent(
                                  new Element("District", cbc)
                                      .setText(factura.getDireccionEntrega().getDistrito()))
                              .addContent(
                                  new Element("Country", cac)
                                      .addContent(
                                          new Element("IdentificationCode", cbc)
                                              .setAttribute("listID", "ISO 3166-1")
                                              .setAttribute(
                                                  "listAgencyName",
                                                  "United Nations Economic Commission for Europe")
                                              .setAttribute("listName", "Country")
                                              .setText(
                                                  factura
                                                      .getDireccionEntrega()
                                                      .getCodigoPais())))));
      document.getRootElement().addContent(tagDelivery);
    }

    // Datos del cliente o receptor
    Element tagAccountingCustomerParty = new Element("AccountingCustomerParty", cac);
    tagParty = new Element("Party", cac);
    tagPartyLegalEntity = new Element("PartyLegalEntity", cac);

    // 17 Tipo y Número de documento de identidad del adquirente o usuario. M
    tagParty.addContent(
        new Element("PartyIdentification", cac)
            .addContent(
                new Element("ID", cbc)
                    .setAttribute(
                        "schemeID",
                        factura.getAdquiriente().getDocumentoIdentidad().getTipo().getCodigo())
                    .setAttribute("schemeName", "Documento de Identidad")
                    .setAttribute("schemeAgencyName", "PE:SUNAT")
                    .setAttribute("schemeURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
                    .setText(factura.getAdquiriente().getDocumentoIdentidad().getNumero())));

    // 18 Apellidos y nombres, denominación o razón social del adquirente o usuario. M
    tagPartyLegalEntity.addContent(
        new Element("RegistrationName", cbc).setText(factura.getAdquiriente().getNombre()));

    // 19 Dirección del adquiriente o usuario. C
    if (factura.getAdquiriente().getDomicilioFiscal() != null) {
      tagPartyLegalEntity.addContent(
          new Element("RegistrationAddress", cac)
              .addContent(
                  new Element("ID", cbc)
                      .setAttribute("schemeAgencyName", "PE:INEI")
                      .setAttribute("schemeName", "Ubigeos")
                      .setText(factura.getAdquiriente().getDomicilioFiscal().getCodigoUbigeo()))
              .addContent(
                  new Element("CitySubdivisionName", cbc)
                      .setText(factura.getAdquiriente().getDomicilioFiscal().getUrbanizacion()))
              .addContent(
                  new Element("CityName", cbc)
                      .setText(factura.getAdquiriente().getDomicilioFiscal().getProvincia()))
              .addContent(
                  new Element("CountrySubentity", cbc)
                      .setText(factura.getAdquiriente().getDomicilioFiscal().getDepartamento()))
              .addContent(
                  new Element("District", cbc)
                      .setText(factura.getAdquiriente().getDomicilioFiscal().getDistrito()))
              .addContent(
                  new Element("AddressLine", cac)
                      .addContent(
                          new Element("Line", cbc)
                              .setText(
                                  factura.getAdquiriente().getDomicilioFiscal().getDescripcion())))
              .addContent(
                  new Element("Country", cac)
                      .addContent(
                          new Element("IdentificationCode", cbc)
                              .setAttribute("listID", "ISO 3166-1")
                              .setAttribute(
                                  "listAgencyName", "United Nations Economic Commission for Europe")
                              .setAttribute("listName", "Country")
                              .setText(
                                  factura.getAdquiriente().getDomicilioFiscal().getCodigoPais()))));
    }

    // 20 Tipo y número de documento de identidad de otros participantes asociados a la transacción
    // Apellidos y nombres, denominación o razón social de otros participantes asociados a la
    // transacción
    // C
    if (factura.getParticipante() != null) {
      Element tagShareholderParty =
          new Element("ShareholderParty", cac)
              .addContent(
                  new Element("Party", cac)
                      .addContent(
                          new Element("PartyIdentification", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute(
                                          "schemeID",
                                          factura
                                              .getParticipante()
                                              .getDocumentoIdentidad()
                                              .getTipo()
                                              .getCodigo())
                                      .setAttribute("schemeName", "Documento de Identidad")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
                                      .setText(
                                          factura
                                              .getParticipante()
                                              .getDocumentoIdentidad()
                                              .getNumero())))
                      .addContent(
                          new Element("PartyLegalEntity", cac)
                              .addContent(
                                  new Element("RegistrationName", cbc)
                                      .setText(factura.getParticipante().getNombre()))));

      tagPartyLegalEntity.addContent(tagShareholderParty);
    }

    tagParty.addContent(tagPartyLegalEntity);
    tagAccountingCustomerParty.addContent(tagParty);
    document.getRootElement().addContent(tagAccountingCustomerParty);

    // Información adicional - Forma de pago al contado
    // 174	Forma de pago
    // Información adicional - Forma de pago al crédito
    // 175	Forma de pago
    // Monto neto pendiente de pago
    // 176 Monto del pago único o de las cuotas
    // 177 Fecha del pago único o de las cuotas
    if (factura.getContado() != null) {
      Element tagPaymentTerms =
          new Element("PaymentTerms", cac)
              .addContent(new Element("ID", cbc).setText("FormaPago"))
              .addContent(
                  new Element("PaymentMeansID", cbc)
                      .setText(factura.getContado().getDescripcion()));
      document.getRootElement().addContent(tagPaymentTerms);
    } else {
      Element tagPaymentTerms =
          new Element("PaymentTerms", cac)
              .addContent(new Element("ID", cbc).setText("FormaPago"))
              .addContent(
                  new Element("PaymentMeansID", cbc)
                      .setText(factura.getContado().getDescripcion()));

      for (FormaPago formaPago : factura.getCredito()) {
        Element tagCuota =
            new Element("PaymentTerms", cac)
                .addContent(new Element("ID", cbc).setText("FormaPago"))
                .addContent(new Element("PaymentMeansID", cbc).setText(formaPago.getNmroCuota()))
                .addContent(
                    new Element("Amount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(formaPago.getMontoPago())))
                .addContent(
                    new Element("PaymentDueDate", cbc)
                        .setText(MyDateFormat.yyyy_MM_dd(formaPago.getFechaPago())));

        tagPaymentTerms.addContent(tagCuota);
      }

      document.getRootElement().addContent(tagPaymentTerms);
    }

    // Datos del comprador
    // 21 Tipo y Número de documento de identidad del comprador. C
    if (factura.getSujeto() != null) {
      Element tagBuyerCustomerParty =
          new Element("BuyerCustomerParty", cac)
              .addContent(
                  new Element("Party", cac)
                      .addContent(
                          new Element("PartyIdentification", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute(
                                          "schemeID", factura.getSujeto().getTipo().getCodigo())
                                      .setAttribute("schemeName", "Documento de Identidad")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06")
                                      .setText(factura.getSujeto().getNumero()))));

      document.getRootElement().addContent(tagBuyerCustomerParty);
    }

    // 50 Cargos y Descuentos Globales. C
    if (factura.getDescuentos() != null) {
      Element tagAllowanceCharge =
          new Element("AllowanceCharge", cbc)
              .addContent(
                  new Element("ChargeIndicator", cbc)
                      .setText(String.valueOf(factura.getDescuentos().isIndicador())))
              .addContent(
                  new Element("AllowanceChargeReasonCode", cbc)
                      .setAttribute("listAgencyName", "PE:SUNAT")
                      .setAttribute("listName", "Cargo/descuento")
                      .setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo53")
                      .setText(factura.getDescuentos().getCodigo()))
              .addContent(
                  new Element("MultiplierFactorNumeric", cbc)
                      .setText(factura.getDescuentos().getPorcentaje()))
              .addContent(
                  new Element("Amount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(factura.getDescuentos().getMonto()))
              .addContent(
                  new Element("BaseAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(factura.getCuota().getMontoBase()));
      document.getRootElement().addContent(tagAllowanceCharge);
    }

    // Totales de la Factura
    // 40 Monto total de impuestos. M
    Element tagTaxTotal =
        new Element("TaxTotal", cac)
            .addContent(
                new Element("TaxAmount", cbc)
                    .setAttribute("currencyID", factura.getMoneda().getCodigo())
                    .setText(String.valueOf(factura.getTotalTributos())));

    // 41 Total valor de venta - exportación
    if (factura.getExportacion() > 0.0) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(factura.getExportacion())))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText("0.00"))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("9995"))
                              .addContent(new Element("Name", cbc).setText("EXP"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    }

    // 42 Total valor de venta - operaciones inafectas. C
    if (factura.getInafectas() > 0.0) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(factura.getInafectas())))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText("0.00"))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("9998"))
                              .addContent(new Element("Name", cbc).setText("INA"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    }

    // 43 Total valor de venta - operaciones exoneradas. C
    if (factura.getExoneradas() != null) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(factura.getExoneradas().getTotal())))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText("0.00"))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("9997"))
                              .addContent(new Element("Name", cbc).setText("EXO"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("VAT")))));
    }

    // 44 Total valor de venta - operaciones gratuitas
    // 45 Sumatoria de tributos de operaciones gratuitas. C
    if (factura.getGratuitas() != null) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(factura.getGratuitas().getTotal())))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(factura.getGratuitas().getTributo())))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("9996"))
                              .addContent(new Element("Name", cbc).setText("GRA"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("FRE")))));
    }

    // 46 Total valor de venta - operaciones gravadas (IGV o IVAP). M
    // 47 Total Importe IGV o IVAP. M
    tagTaxTotal.addContent(
        new Element("TaxSubtotal", cac)
            .addContent(
                new Element("TaxableAmount", cbc)
                    .setAttribute("currencyID", factura.getMoneda().getCodigo())
                    .setText(String.valueOf(factura.getGravadas().getTributo())))
            .addContent(
                new Element("TaxAmount", cbc)
                    .setAttribute("currencyID", factura.getMoneda().getCodigo())
                    .setText(String.valueOf(factura.getGravadas().getTributo())))
            .addContent(
                new Element("TaxCategory", cac)
                    .addContent(
                        new Element("TaxScheme", cac)
                            .addContent(
                                new Element("ID", cbc)
                                    .setAttribute("schemeName", "Codigo de tributos")
                                    .setAttribute("schemeAgencyName", "PE:SUNAT")
                                    .setAttribute(
                                        "schemeURI",
                                        "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                    .setText("1000"))
                            .addContent(new Element("Name", cbc).setText("IGV"))
                            .addContent(new Element("TaxTypeCode", cbc).setText("VAT")))));

    // 48 Sumatoria ISC. C
    if (!total.getIsc().equals("0.00")) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", encabezado.getMoneda())
                      .setText(total.getMontoIsc()))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", encabezado.getMoneda())
                      .setText(total.getIsc()))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("2000"))
                              .addContent(new Element("Name", cbc).setText("ISC"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("EXC")))));
    }

    // 49 Sumatoria Otros Tributos. C
    if (!total.getOtrosTributos().equals("0.00")) {
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", encabezado.getMoneda())
                      .setText(total.getMontoOtrosTributos()))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", encabezado.getMoneda())
                      .setText(total.getOtrosTributos()))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                      .setText("9999"))
                              .addContent(
                                  new Element("Name", cbc).setText("OTROS CONCEPTOS DE PAGO"))
                              .addContent(new Element("TaxTypeCode", cbc).setText("OTH")))));
    }

    document.getRootElement().addContent(tagTaxTotal);

    Element tagLegalMonetaryTotal = new Element("LegalMonetaryTotal", cac);

    // 54 Total Valor de Venta. C
    tagLegalMonetaryTotal.addContent(
        new Element("LineExtensionAmount", cbc)
            .setAttribute("currencyID", encabezado.getMoneda())
            .setText(total.getValorVenta()));

    // 55 Total Precio de Venta. C
    tagLegalMonetaryTotal.addContent(
        new Element("TaxInclusiveAmount", cbc)
            .setAttribute("currencyID", encabezado.getMoneda())
            .setText(total.getPrecioVenta()));

    // 51 Total Descuentos (Que no afectan la base). C
    if (!total.getDescuentos().equals("0.00")) {
      tagLegalMonetaryTotal.addContent(
          new Element("AllowanceTotalAmount", cbc)
              .setAttribute("currencyID", encabezado.getMoneda())
              .setText(total.getDescuentos()));
    }

    // 52 Total otros Cargos (Que no afectan la base). C
    if (!total.getOtrosCargos().equals("0.00")) {
      tagLegalMonetaryTotal.addContent(
          new Element("ChargeTotalAmount", cbc)
              .setAttribute("currencyID", encabezado.getMoneda())
              .setText(total.getOtrosCargos()));
    }

    // 56 Monto para Redondeo del Importe Total. C
    if (!total.getTotalRedondeado().equals("0.00")) {
      tagLegalMonetaryTotal.addContent(
          new Element("PayableRoundingAmount", cbc)
              .setAttribute("currencyID", encabezado.getMoneda())
              .setText(total.getTotalRedondeado()));
    }

    // 53 Importe total de la venta, cesión en uso o del servicio prestado. M
    tagLegalMonetaryTotal.addContent(
        new Element("PayableAmount", cbc)
            .setAttribute("currencyID", encabezado.getMoneda())
            .setText(total.getTotal()));

    document.getRootElement().addContent(tagLegalMonetaryTotal);

    // Información Adicional - Percepciones
    //
    // Información Adicional  - Anticipos
    //
    // Información Adicional - Sustento de traslado de mercaderias
    //
    // Información Adicional  - Transporte terrestre de pasajeros
    //
    // Información Adicional  - Detracciones
    //
    // Detracciones - Recursos Hidrobiológicos
    //
    // Detracciones - Servicio de transporte de Carga
    //
    // Detracciones - Servicio de transporte de Carga - BillLine de tramos (De corresponder)
    //
    // Detracciones - Servicio de transporte de Carga - BillLine del (os) Vehículo (s)
    //
    // Información Adicional  - Beneficio de hospedaje
    //
    // Información Adicional  - Paquete Turístico
    //
    // Ventas Sector Público
    //
    // Gastos intereses hipotecarios (incluye primera vivienda)
    //
    // Migración de documentos autorizados - Carta Porte Aéreo
    //
    // Migración de documentos autorizados - BVME para transporte ferroviario de pasajeros
    //
    // Migración de documentos autorizados - Pago de regalía petrolera
    //
    // Información Adicional a nivel de ítem
    //

    // Datos del detalle o Ítem de la Factura
    for (FacturaDetalle detalle : factura.getFacturaDetalles()) {
      Element tagInvoiceLine = new Element("InvoiceLine", cac);
      // 24 Número de orden del Ítem. M
      tagInvoiceLine.addContent(
          new Element("ID", cbc).setText(String.valueOf(detalle.getNumero())));

      // 25 Unidad de medida por ítem. M
      // 26 Cantidad de unidades por ítem. M
      tagInvoiceLine.addContent(
          new Element("InvoicedQuantity", cbc)
              .setAttribute("unitCode", detalle.getUnidadMedida().getCodigo())
              .setAttribute("unitCodeListID", "UN/ECE rec 20")
              .setAttribute("unitCodeListAgencyID", "United Nations Economic Commission for Europe")
              .setText(String.valueOf(detalle.getCantidad())));

      // 38 Valor de venta por ítem. M
      tagInvoiceLine.addContent(
          new Element("LineExtensionAmount", cbc)
              .setAttribute("currencyID", factura.getMoneda().getCodigo())
              .setText(String.valueOf(detalle.getValorVenta())));

      // 33 Precio de venta unitario por item. M
      if (detalle.getPrecioVentaUnitario() > 0.0) {
        tagInvoiceLine.addContent(
            new Element("PricingReference", cac)
                .addContent(
                    new Element("AlternativeConditionPrice", cac)
                        .addContent(
                            new Element("PriceAmount", cbc)
                                .setAttribute("currencyID", factura.getMoneda().getCodigo())
                                .setText(String.valueOf(detalle.getPrecioVentaUnitario())))
                        .addContent(
                            new Element("PriceTypeCode", cbc)
                                .setAttribute("listName", "Tipo de Precio")
                                .setAttribute("listAgencyName", "PE:SUNAT")
                                .setAttribute(
                                    "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo16")
                                .setText("01"))));
      }

      // 34 Valor referencial unitario por ítem en operaciones no onerosas. C
      if (detalle.getValorReferencialUnitario() > 0.0) {
        tagInvoiceLine.addContent(
            new Element("PricingReference", cac)
                .addContent(
                    new Element("AlternativeConditionPrice", cac)
                        .addContent(
                            new Element("PriceAmount", cbc)
                                .setAttribute("currencyID", factura.getMoneda().getCodigo())
                                .setText(String.valueOf(detalle.getValorReferencialUnitario())))
                        .addContent(
                            new Element("PriceTypeCode", cbc)
                                .setAttribute("listName", "Tipo de Precio")
                                .setAttribute("listAgencyName", "PE:SUNAT")
                                .setAttribute(
                                    "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo16")
                                .setText("02"))));
      }

      // 39 Cargo/descuento por ítem. C
      if (detalle.getDescuento() != null) {
        tagInvoiceLine.addContent(
            new Element("AllowanceCharge", cac)
                .addContent(
                    new Element("ChargeIndicator", cbc)
                        .setText(String.valueOf(detalle.getDescuento().isIndicador())))
                .addContent(
                    new Element("AllowanceChargeReasonCode", cbc)
                        .setText(detalle.getDescuento().getCodigo()))
                .addContent(
                    new Element("MultiplierFactorNumeric", cbc)
                        .setText(String.valueOf(detalle.getDescuento().getFactor())))
                .addContent(
                    new Element("Amount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(detalle.getDescuento().getMonto())))
                .addContent(
                    new Element("BaseAmount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(detalle.getDescuento().getBase()))));
      }

      tagTaxTotal = new Element("TaxTotal", cac);

      // 35 Monto total de impuestos del ítem. M
      tagTaxTotal.addContent(
          new Element("TaxAmount", cbc)
              .setAttribute("currencyID", factura.getMoneda().getCodigo())
              .setText(String.valueOf(detalle.getTotalTributos())));

      // 36 Afectación al IGV por ítem
      // Afectación al IVAP por ítem
      // M            .
      tagTaxTotal.addContent(
          new Element("TaxSubtotal", cac)
              .addContent(
                  new Element("TaxableAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(detalle.getIgv().getBase())))
              .addContent(
                  new Element("TaxAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(detalle.getIgv().getMonto())))
              .addContent(
                  new Element("TaxCategory", cac)
                      .addContent(
                          new Element("Percent", cbc)
                              .setText(String.valueOf(detalle.getIgv().getTasa())))
                      .addContent(
                          new Element("TaxExemptionReasonCode", cbc)
                              .setAttribute("listAgencyName", "PE:SUNAT")
                              .setAttribute("listName", "Afectacion del IGV")
                              .setAttribute(
                                  "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07")
                              .setText(detalle.getIgv().getTipo().getCodigo()))
                      .addContent(
                          new Element("TaxScheme", cac)
                              .addContent(
                                  new Element("ID", cbc)
                                      .setAttribute("schemeName", "Codigo de tributos")
                                      .setAttribute("schemeAgencyName", "PE:SUNAT")
                                      .setAttribute(
                                          "schemeURI",
                                          "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05'")
                                      .setText(detalle.getIgv().getTipoTributo().getCodigo()))
                              .addContent(
                                  new Element("Name", cbc)
                                      .setText(detalle.getIgv().getTipoTributo().getDescripcion()))
                              .addContent(
                                  new Element("TaxTypeCode", cbc)
                                      .setText(
                                          detalle
                                              .getIgv()
                                              .getTipoTributo()
                                              .getCodigoInternacional())))));

      // 37 Afectación del ISC por la línea. C.
      if (detalle.getIsc() != null) {
        tagTaxTotal.addContent(
            new Element("TaxSubtotal", cac)
                .addContent(
                    new Element("TaxableAmount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(detalle.getIsc().getBase())))
                .addContent(
                    new Element("TaxAmount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(detalle.getIsc().getMonto())))
                .addContent(
                    new Element("TaxCategory", cac)
                        .addContent(
                            new Element("Percent", cbc)
                                .setText(String.valueOf(detalle.getIsc().getTasa())))
                        .addContent(
                            new Element("TierRange", cbc)
                                .setText(detalle.getIsc().getTipo().getCodigo()))
                        .addContent(
                            new Element("TaxScheme", cac)
                                .addContent(
                                    new Element("ID", cbc)
                                        .setAttribute("schemeName", "Codigo de tributos")
                                        .setAttribute("schemeAgencyName", "PE:SUNAT")
                                        .setAttribute(
                                            "schemeURI",
                                            "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                        .setText(detalle.getIsc().getTipoTributo().getCodigo()))
                                .addContent(
                                    new Element("Name", cbc)
                                        .setText(
                                            detalle.getIsc().getTipoTributo().getDescripcion()))
                                .addContent(
                                    new Element("TaxTypeCode", cbc)
                                        .setText(
                                            detalle
                                                .getIsc()
                                                .getTipoTributo()
                                                .getCodigoInternacional())))));
      }

      // 37-A Impuesto al consumo de bolsas de plástico por ítem C
      if (detalle.getBolsas() != null) {
        tagTaxTotal.addContent(
            new Element("TaxSubtotal", cac)
                .addContent(
                    new Element("TaxableAmount", cbc)
                        .setAttribute("currencyID", factura.getMoneda().getCodigo())
                        .setText(String.valueOf(detalle.getBolsas().getMonto())))
                .addContent(
                    new Element("BaseUnitMeasure", cbc)
                        .setAttribute("unitCode", "NIU")
                        .setText(String.valueOf(detalle.getBolsas().getCantidad())))
                .addContent(
                    new Element("TaxCategory", cac)
                        .addContent(
                            new Element("PerUnitAmount", cbc)
                                .setText(String.valueOf(detalle.getBolsas().getMontoUnitario())))
                        .addContent(
                            new Element("TaxScheme", cac)
                                .addContent(
                                    new Element("ID", cbc)
                                        .setAttribute("schemeName", "Codigo de tributos")
                                        .setAttribute("schemeAgencyName", "PE:SUNAT")
                                        .setAttribute(
                                            "schemeURI",
                                            "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo05")
                                        .setText(detalle.getBolsas().getTipoTributo().getCodigo()))
                                .addContent(
                                    new Element("Name", cbc)
                                        .setText(
                                            detalle.getBolsas().getTipoTributo().getDescripcion()))
                                .addContent(
                                    new Element("TaxTypeCode", cbc)
                                        .setText(
                                            detalle
                                                .getBolsas()
                                                .getTipoTributo()
                                                .getCodigoInternacional())))));
      }

      tagInvoiceLine.addContent(tagTaxTotal);

      Element tagItem = new Element("Item", cac);
      // 31 Descripción detallada del servicio prestado, bien vendido o cedido en uso, indicando las
      // características. M.
      tagItem.addContent(
          new Element("Description", cbc).setText(detalle.getProducto().getDescripcion()));

      // 27 Código de producto. C.
      if (!detalle.getProducto().getCodigo().isEmpty()) {
        tagItem.addContent(
            new Element("SellersItemIdentification", cac)
                .addContent(new Element("ID", cbc).setText(detalle.getProducto().getCodigo())));
      }

      // 28. Código de producto SUNAT. C.
      if (!detalle.getProducto().getSunat().isEmpty()) {
        tagItem.addContent(
            new Element("CommodityClassification", cac)
                .addContent(
                    new Element("ItemClassificationCode", cbc)
                        .setAttribute("listID", "UNSPSC")
                        .setAttribute("listAgencyName", "GS1 US")
                        .setAttribute("listName", "Item Classification")
                        .setText(detalle.getProducto().getSunat())));
      }

      // 29 Código de producto GTIN. C
      if (detalle.getProducto().getGtin() != null) {
        tagItem.addContent(
            new Element("StandardItemIdentification", cac)
                .addContent(
                    new Element("ID", cbc)
                        .setAttribute("schemeID", detalle.getProducto().getGtin().getTipo())
                        .setText(detalle.getProducto().getGtin().getCodigo())));
      }

      // 30 Número de placa del vehículo automotor. C
      if (detalle.getProducto().getPlaca() != null) {
        tagItem.addContent(
            new Element("AdditionalItemProperty", cac)
                .addContent(
                    new Element("Name", cbc).setText(detalle.getProducto().getPlaca().getNombre()))
                .addContent(
                    new Element("NameCode", cbc)
                        .setAttribute("listName", "Propiedad del item")
                        .setAttribute("listAgencyName", "PE:SUNAT")
                        .setAttribute(
                            "listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo55")
                        .setText(detalle.getProducto().getPlaca().getCodigoNomnre()))
                .addContent(
                    new Element("Value", cbc)
                        .setText(detalle.getProducto().getPlaca().getValor())));
      }

      tagInvoiceLine.addContent(tagItem);

      // 32 Valor unitario por ítem. M
      tagInvoiceLine.addContent(
          new Element("Price", cac)
              .addContent(
                  new Element("PriceAmount", cbc)
                      .setAttribute("currencyID", factura.getMoneda().getCodigo())
                      .setText(String.valueOf(detalle.getValorUnitario()))));

      document.getRootElement().addContent(tagInvoiceLine);
    }

    return document;
  }
}
