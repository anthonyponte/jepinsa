/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.dao.BillDao;
import com.anthonyponte.jepinsa.idao.IBillDao;
import com.anthonyponte.jepinsa.model.Tipo;
import com.anthonyponte.jepinsa.pojo.Empresa;
import com.anthonyponte.jepinsa.view.FacturaIFrame;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import java.awt.event.ActionEvent;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.anthonyponte.jepinsa.retrofit.EmpresaService;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author AnthonyPonte
 */
public class FacturaController {

  private final FacturaIFrame iFrame;
  private final LoadingDialog dialog;
  private BillDao billDao;

  public FacturaController(FacturaIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.cbxTipo.addItemListener(
        (ItemEvent ie) -> {
          if (ie.getStateChange() == ItemEvent.SELECTED) {
            if (iFrame.cbxTipo.getSelectedIndex() == 0) {
              iFrame.cbxSerie.setModel(
                  new DefaultComboBoxModel(
                      new String[] {"FEP1", "FEP2", "FEF1", "FEF2", "FEX1", "FEX2"}));

            } else if (iFrame.cbxTipo.getSelectedIndex() == 1) {
              iFrame.cbxSerie.setModel(
                  new DefaultComboBoxModel(new String[] {"BEP1", "BEP2", "BEF1", "BEF2"}));
            }
          }
        });

    iFrame.cbxSerie.addItemListener(
        (ItemEvent ie) -> {
          if (ie.getStateChange() == ItemEvent.SELECTED) {
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(iFrame);

            SwingWorker worker =
                new SwingWorker<Integer, Void>() {
                  @Override
                  protected Integer doInBackground() throws Exception {
                    int count = 0;
                    try {
                      Tipo tipo = (Tipo) iFrame.cbxTipo.getSelectedItem();

                      String serie = (String) iFrame.cbxSerie.getSelectedItem();

                      count = billDao.count(serie, tipo);
                    } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(
                          null,
                          ex.getMessage(),
                          ComunicacionController.class.getSimpleName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                    return count;
                  }

                  @Override
                  protected void done() {
                    try {
                      dialog.dispose();

                      int count = get();
                      iFrame.tfCorrelativo.setText(String.valueOf(count));
                    } catch (InterruptedException | ExecutionException ex) {
                      JOptionPane.showMessageDialog(
                          null,
                          ex.getMessage(),
                          FacturaController.class.getSimpleName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                  }
                };
            worker.execute();
          }
        });

    iFrame.btnNuevo.addActionListener(
        (ActionEvent e) -> {
          iFrame.cbxTipo.setEnabled(true);
          iFrame.cbxTipo.setSelectedIndex(0);
          iFrame.cbxTipo.requestFocus();

          iFrame.cbxSerie.setEnabled(true);
          iFrame.cbxSerie.setSelectedIndex(0);

          iFrame.cbxAdquirienteTipoDocumentoIdentidad.setEnabled(true);
          iFrame.cbxAdquirienteTipoDocumentoIdentidad.setSelectedIndex(0);
          iFrame.btnAdquirienteDocumentoIdentidad.setEnabled(true);
          iFrame.tfAdquirienteDocumentoIdentidad.setEnabled(true);
        });

    iFrame.btnAdquirienteDocumentoIdentidad.addActionListener(
        (ActionEvent e) -> {
          OkHttpClient client =
              new OkHttpClient.Builder()
                  .addInterceptor(
                      (Interceptor.Chain chain) -> {
                        Request newRequest =
                            chain
                                .request()
                                .newBuilder()
                                .addHeader(
                                    "Authorization",
                                    "Bearer "
                                        + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFudGhvbnlycG9udGVAZ21haWwuY29tIn0.CMrf_PdACMFU7ddyiXEyDCRB52jxGeJM_c1hnd6E2aI")
                                .build();
                        return chain.proceed(newRequest);
                      })
                  .build();

          Retrofit retrofit =
              new Retrofit.Builder()
                  .client(client)
                  .baseUrl("https://dniruc.apisperu.com")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

          EmpresaService service = retrofit.create(EmpresaService.class);

          String ruc = iFrame.tfAdquirienteDocumentoIdentidad.getText();
          Call<Empresa> call = service.getEmpresa(ruc);
          call.enqueue(
              new Callback<Empresa>() {
                @Override
                public void onResponse(Call<Empresa> call, Response<Empresa> rspns) {
                  Empresa empresa = rspns.body();

                  iFrame.tfAdquirienteNombre.setText(empresa.getRazonSocial());
                }

                @Override
                public void onFailure(Call<Empresa> call, Throwable thrwbl) {
                  JOptionPane.showMessageDialog(
                      null,
                      thrwbl.getMessage(),
                      FacturaController.class.getSimpleName(),
                      JOptionPane.ERROR_MESSAGE);
                }
              });
        });
  }

  private void initComponents() {
    billDao = new IBillDao();

    iFrame.show();
  }
}
