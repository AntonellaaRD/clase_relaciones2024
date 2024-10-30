package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Anotacion @ provee informacion adicional a una clase,atributo o metodo
//un elemento que atienda peticiones y envie respuestas necesitamos indicar @Controller
//peticiones_request lo que viene del cliente
//respuestas_response lo que sale del servidor
@Controller
public class HomeController {
	//pueden existir varios metodos para atender derminadas peticiones..
	
	//Get _ se visualiza la escritura en el navegador 
	@GetMapping("/home")//request
	public String home() {
		
		System.out.println("Llegue hasta el controlador");
		//static   /archivo/   index       .html
		//defecto  ap.proper   controller  ap.proper
		
		return "index";
		//return "/archivo/index.html";//response
	}

}
