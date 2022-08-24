/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.controller;

import com.anthonyponte.jepinsa.pojo.Empresa;
import com.anthonyponte.jepinsa.view.FacturaIFrame;
import com.anthonyponte.jepinsa.view.LoadingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.anthonyponte.jepinsa.retrofit.EmpresaService;
import java.io.IOException;
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

  public FacturaController(FacturaIFrame iFrame, LoadingDialog dialog) {
    this.iFrame = iFrame;
    this.dialog = dialog;
    initComponents();
  }

  public void init() {
    iFrame.btnAdquirienteRuc.addActionListener(
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
                                    "Bearer " + "k4d2956bd531ab61d44f4fa07304b20e13913815")
                                .build();
                        return chain.proceed(newRequest);
                      })
                  .build();

          Retrofit retrofit =
              new Retrofit.Builder()
                  .client(client)
                  .baseUrl("https://dni.optimizeperu.com/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

          EmpresaService service = retrofit.create(EmpresaService.class);

          String ruc = iFrame.tfAdquirienteRuc.getText();
          Call<Empresa> call = service.getEmpresa(ruc);
          call.enqueue(
              new Callback<Empresa>() {
                @Override
                public void onResponse(Call<Empresa> call, Response<Empresa> rspns) {
                  System.out.println(".onResponse() " + rspns.message());
                  System.out.println(".onResponse() " + rspns.body());
                  System.out.println(".onResponse() " + rspns.code());
                  System.out.println(".onResponse() " + rspns.errorBody());
                  System.out.println(".onResponse() " + rspns.isSuccessful());
                }

                @Override
                public void onFailure(Call<Empresa> call, Throwable thrwbl) {
                  System.out.println(".onFailure()");
                }
              });
        });
  }

  private void initComponents() {
    iFrame.show();
  }
}
