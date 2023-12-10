package com.smart.smartproductospet.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smart.smartproductospet.entidades.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

    Optional<Usuario> findByMail(String mail);

}
