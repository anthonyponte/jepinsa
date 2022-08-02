/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jepinsa.model;

/**
 * @author AnthonyPonte
 */
public class StatusResponse {

  private byte[] content;
  private String contentMessage;
  private String statusCode;

  public StatusResponse() {}

  public StatusResponse(byte[] content, String contentMessage, String statusCode) {
    this.content = content;
    this.contentMessage = contentMessage;
    this.statusCode = statusCode;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getContentMessage() {
    return contentMessage;
  }

  public void setContentMessage(String contentMessage) {
    this.contentMessage = contentMessage;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    return "StatusResponse{"
        + "content="
        + content
        + ", contentMessage="
        + contentMessage
        + ", statusCode="
        + statusCode
        + '}';
  }
}
