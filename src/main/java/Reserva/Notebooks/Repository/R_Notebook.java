package Reserva.Notebooks.Repository;

import Reserva.Notebooks.Model.M_notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Notebook extends JpaRepository<M_notebook, Long> {


    }

