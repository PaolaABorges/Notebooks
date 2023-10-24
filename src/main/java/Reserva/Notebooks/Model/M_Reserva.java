package Reserva.Notebooks.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class M_Reserva {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long Id;
    private Long Id_usuario;
    private Time hora_ini;
    private Time hora_fim;
    private Date data_ini;
    private Date data_fim;

    public M_Reserva(Long id, Long id_usuario, Time hora_ini, Time hora_fim, Date data_ini, Date data_fim) {
        Id = id;
        Id_usuario = id_usuario;
        this.hora_ini = hora_ini;
        this.hora_fim = hora_fim;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        Id_usuario = id_usuario;
    }

    public Time getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(Time hora_ini) {
        this.hora_ini = hora_ini;
    }

    public Time getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Time hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
}
