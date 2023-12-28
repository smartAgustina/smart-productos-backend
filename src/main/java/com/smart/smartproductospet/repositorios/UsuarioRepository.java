package com.smart.smartproductospet.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.smart.smartproductospet.entidades.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

    Optional<Usuario> findByMail(String mail);

    @Modifying()
    @Query("update Usuario u set u.nombre=:nombre, u.apellido=:apellido, u.dni=:dni, u.mail=:mail, u.telefono=:telefono , u.password=:password where u.id = :id")
    void actualizarUsuario(@Param(value = "id") Integer id,   @Param(value = "mail") String mail, @Param(value = "nombre") String nombre , @Param(value = "apellido") String apellido , @Param(value = "dni") String dni, @Param(value = "telefono") String telefono , @Param(value = "password") String password);

}
