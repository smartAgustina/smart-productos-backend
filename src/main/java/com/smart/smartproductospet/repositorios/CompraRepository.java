package com.smart.smartproductospet.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.smartproductospet.entidades.Compra;
import com.smart.smartproductospet.entidades.Usuario;

@Repository
public interface CompraRepository extends JpaRepository <Compra, Integer>{

}