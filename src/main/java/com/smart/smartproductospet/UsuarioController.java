package  com.smart.smartproductospet;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smartproductospet.dto.LoginRequestDto;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private static final Logger log = LogManager.getLogger(UsuarioController.class);
    
	@GetMapping("/sayHello")
	public String sayHello() throws FileNotFoundException, IOException {
		log.info("hola");
		return "Hello :) VB-1.0.0";
}


	@PostMapping("/crearUsuario3")
	public String crearUsuario(LoginRequestDto loginDto) {
		try {
		//	return Response.ok("").build();
         return "login";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			 return "login";
            //return Response.status(500).entity("Error").build();
		}
	}

}
