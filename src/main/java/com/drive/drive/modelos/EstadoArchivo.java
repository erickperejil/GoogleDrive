package com.drive.drive.modelos;

import jakarta.persistence.Id;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_estados_archivo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoArchivo {
    @Id
    @Column(name = "id_estado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    @Column(name = "tipo_estado")
    private String tipoEstado;
    
    @JsonIgnore
    @OneToMany(mappedBy = "estadoArchivo")
    private List<Archivo> archivos;

}
