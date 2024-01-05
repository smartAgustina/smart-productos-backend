package com.smart.smartproductospet.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.smartproductospet.entidades.DetalleCompras;

@Repository
public interface DetalleComprasRepository extends JpaRepository <DetalleCompras, Integer>{

}
