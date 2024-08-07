package com.peluqueria.peluqueria.service;

/**
 *
 * @author alex
 */

import com.peluqueria.peluqueria.domain.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

public interface UsuarioService {
            //Se enuncia un método que recupera los registros de la tabla bicicleta dentro de un ArrayList
    public List<Usuario> getUsuarios();
    
    //Se obtiene un registro de la tabla bicicleta en un objeto bicicleta si el idBicicleta existe sino pasa un null
    public Usuario getUsuario(Usuario usuario);
    
    //Se crea un nuevo registro en bicicleta si el objeto Bicicleta  NO tiene idBicicleta
    //se actualiza el registro en la tabla bicicleta si el objeto bicicleta tiene un idBicicleta
    public void save(Usuario usuario);
    
    //Se elimina el registro por idBicicleta
    public void delete(Usuario usuario);
}
