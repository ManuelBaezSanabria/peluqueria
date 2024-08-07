package com.peluqueria.peluqueria.dao;

/**
 *
 * @author AMD
 */
import com.peluqueria.peluqueria.domain.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionDao extends JpaRepository<Promocion,Long>{
    
}