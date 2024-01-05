package com.smart.smartproductospet.repositorios;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smart.smartproductospet.entidades.CarritoCompra;

@Repository
public interface CarritoComprasRepository  extends JpaRepository<CarritoCompra, Integer> {

}
