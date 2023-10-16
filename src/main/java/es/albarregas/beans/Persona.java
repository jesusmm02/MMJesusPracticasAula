/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albarregas.beans;
import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String apellidos;
    private Byte numHijos;
    private Double salario;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, Byte numHijos, Double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numHijos = numHijos;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Byte getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(Byte numHijos) {
        this.numHijos = numHijos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    
}
