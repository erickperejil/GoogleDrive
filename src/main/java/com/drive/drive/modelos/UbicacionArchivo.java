package com.drive.drive.modelos;

import java.util.List;

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
@Table(name = "tbl_ubicaciones_archivos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionArchivo {
    
    @Id
    @Column(name = "id_ubicacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;

    @Column(name = "nombre_ubicacion")
    private String nombreUbicacionArchivo;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_padre", referencedColumnName = "id_ubicacion")
    private UbicacionArchivo ubicacionPadre;

    //agregar el usuario de la ubicacion
    @ManyToOne 
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "ubicacionPadre")
    private List<UbicacionArchivo> ubicacionesHijas;

    @OneToMany(mappedBy = "ubicacionArchivo")
    private List<Archivo> archivos;
}
