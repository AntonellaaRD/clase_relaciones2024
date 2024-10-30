package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

//aplicar la arquitectura rest
//representational state transfer

//solicitudes sin almacenamiento de estado
@RestController
@RequestMapping("/api")
//afecta a todos los metodos de la clase
public class SuscritoController{
	
	 @Autowired
	private SuscritoRepository suscritoRepository;

	// api
	@GetMapping("/suscritos")

	public ResponseEntity<List<Suscrito>> getSuscritos() {
		List<Suscrito> suscritos = new ArrayList<>();
		// buscar todos
		suscritos = suscritoRepository.findAll();

		return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);
	}
	//post se utiliza para crear un elemento
	@PostMapping("/suscrito")
	public ResponseEntity<Suscrito>
	guardarSuscrito(@RequestBody Suscrito suscrito){
		suscritoRepository.save(suscrito);
		return new ResponseEntity
				//devolver el objeto nuevo creado
				//id nuevo
				<Suscrito>(suscrito, HttpStatus.OK);
	}
	
	
	
	//Consulta api/suscrito/{codigo}
	//buscar un suscrito por codigo
	@GetMapping("/suscrito/{codigo}")
	public 	ResponseEntity<Suscrito>
					//recibir por parametro el valor
	getOneSuscrito( @PathVariable Long codigo){
		Optional <Suscrito> suscrito=suscritoRepository.findById(codigo) ;
		//COMPARAR SI SE ENCONTRO
		if(suscrito.isPresent()) {
			return new ResponseEntity<Suscrito>(suscrito.get(), HttpStatus.OK);
				
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
		//api/suscrito/codigo
		//eliminar un suscrito por codigo_Delete
		@DeleteMapping("/suscrito/{codigo}")
		public ResponseEntity<Suscrito> eliminarOneSuscrito( @PathVariable Long codigo){
			Optional <Suscrito> suscrito=suscritoRepository.findById(codigo) ;
			//COMPARAR SI SE ENCONTRO
			if(suscrito.isPresent()) {
				//elimina un suscrito 
				suscritoRepository.deleteById(codigo);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		
		
	}
	
	
}
