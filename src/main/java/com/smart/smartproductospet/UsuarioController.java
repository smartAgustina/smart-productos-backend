package  com.smart.smartproductospet;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.ValidationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smartproductospet.dto.LoginRequestDto;
import com.smart.smartproductospet.dto.LoginResponseDto;
import com.smart.smartproductospet.servicios.UsuarioService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private static final Logger log = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;
    
	@GetMapping("/sayHello")
	public String sayHello() throws FileNotFoundException, IOException {
		log.info("hola");
		return "Hello :) VB-1.0.0";
}

	@PostMapping("/login2")
	public String login(LoginRequestDto loginDto) {
		try {
			LoginResponseDto dto = this.usuarioService.validarLogin(loginDto);
			//return Response.ok(dto).build();
            return "login";
		} catch (ValidationException e) {
			log.error(e.getMessage(), e);
             return "login";
			//return Response.status(500).entity("Usuario o contraseña incorrectos.").build();
		} catch (Exception e) {
            
			log.error(e.getMessage(), e);
             return "login";
			//return Response.status(500).entity("Hubo un error en la autenticación.").build();
		}
	}

	@PostMapping("/crearUsuario3")
	public String crearUsuario(LoginRequestDto loginDto) {
		try {
			this.usuarioService.crearUsuario(loginDto);
		//	return Response.ok("").build();
         return "login";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			 return "login";
            //return Response.status(500).entity("Error").build();
		}
	}

}
