package com.drive.drive.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_facturacion_planes")
public class FacturacionPlanes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facturacion_planes")
    private int idFacturacionPlanes;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "id_plan")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    private Tarjeta tarjeta;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
}
