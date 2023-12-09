package com.drive.drive.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "numero_telefonico")
    private String numeroTelefonico;

    @Column(name = "pais")
    private String pais;

    @Column(name = "id_genero")
    private int idgenero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    private Genero genero;

    @JsonIgnore
    @OneToMany(mappedBy = "propietario")
    private List<Archivo> archivos;

   // @JsonIgnore
    //@OneToMany(mappedBy = "propietario")
    //private List<Compartido> archivosCompartidos;

    //@JsonIgnore
    //@OneToMany(mappedBy = "usuarioModificador")
    //private List<ModificacionArchivo> modificaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioDueno")
    private List<Tarjeta> tarjetas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<FacturacionPlanes> facturaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<CopiaDeSeguridad> copiaDeSeguridad;
}
