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
@Table(name = "tbl_lugares")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lugar {

    @Id
    @Column(name = "id_lugar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;

    @Column(name = "nombre_lugar")
    private String nombreLugar;

    @ManyToOne
    @JoinColumn(name = "id_tipo_lugar", referencedColumnName = "id_tipo_lugar")
    private TipoLugar tipoLugar;

    @ManyToOne
    @JoinColumn(name = "id_lugar_padre", referencedColumnName = "id_lugar")
    private Lugar lugarPadre;

    @OneToMany(mappedBy = "lugarPadre")
    private List<Lugar> lugaresHijos;


}
