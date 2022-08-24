package com.anthonyponte.jepinsa.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.annotation.Generated;

@Generated("jsonschema2pojo")
public class Empresa {

  @SerializedName("dni")
  @Expose
  private String dni;

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("first_name")
  @Expose
  private String firstName;

  @SerializedName("last_name")
  @Expose
  private String lastName;

  @SerializedName("cui")
  @Expose
  private String cui;

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCui() {
    return cui;
  }

  public void setCui(String cui) {
    this.cui = cui;
  }

  @Override
  public String toString() {
    return "Empresa{"
        + "dni="
        + dni
        + ", name="
        + name
        + ", firstName="
        + firstName
        + ", lastName="
        + lastName
        + ", cui="
        + cui
        + '}';
  }
}