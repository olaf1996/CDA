package com.CDAinfo.AFIP;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//import com.CDAinfo.AFIP.Repository;


@RestController
public class AfipController {
	@Autowired
	ContribuyenteRepository Crepo;
	@Autowired
	ImpuestosRepository Irepo;
	//todos los contribuyentes 
	@GetMapping("/contribuyente")
    public List<Contribuyente> getAllContribuyentes() {
        return Crepo.findAll();
    }

//		Metodo para traer todos los impuestos
	
		@RequestMapping(value="/impuestos", method=RequestMethod.GET)
		public List<Impuesto> getAllImpuestos(){
			return Irepo.findAll();
		}
		
		
		
//		Metodo para traer impuestos por clave fiscal
		
		@RequestMapping(value="/impuesto/{claveFiscal}", method=RequestMethod.GET)
		public Optional<Impuesto> getImpuestos(@PathVariable("claveFiscal") Long claveFiscal){
			return Irepo.findById(claveFiscal);
		}
		
		
		
//		Metodo para traer imouestos por tipo de impuesto
		
		@RequestMapping(value="/buscar/impuestoTipo/{tipo}", method=RequestMethod.GET)
		public Impuesto getTipo(@PathVariable("tipo") String tipo){
			return Irepo.findByTipo(tipo);
		}
		
		@RequestMapping(value="/buscar/impuestoID/{idImpuesto}", method=RequestMethod.GET)
		public Impuesto getImpuestoId(@PathVariable("idImpuesto") Long idImpuesto){
			return Irepo.findByIdImpuesto(idImpuesto);
		}
		
		
		//Metodo para traer usuario por clave fiscal
		
		@RequestMapping(value="/Contribuyente/{claveFiscal}", method=RequestMethod.GET)
		public Contribuyente getUsuarioClave(@PathVariable("claveFiscal") Long claveFiscal){
			
			return Crepo.findById(claveFiscal).get();	
		}
		
		//Metodo para crear las fechas de liquidacion pasando parametros 
		
		@RequestMapping(value = "/impuestos/{tipo}/{fechaLiquidacion}", method = RequestMethod.PUT)
		@ResponseBody
		public ResponseEntity<Impuesto> updateFechaLiquidacion(@PathVariable String tipo, @PathVariable Date fechaLiquidacion){
		    try {
		        Impuesto imp = this.getTipo(tipo);
		        imp.setFechaLiquidacion(fechaLiquidacion);
		        return new ResponseEntity<>(Irepo.save(imp),HttpStatus.OK);
		    }catch (Exception e ){
		        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		    }
		
		//METODO PARA VINCULAR CLAVE CON IMPUESTO
		@RequestMapping(value="/Contribuyente/vincular/{claveFiscal}/{idImpuesto}", method=RequestMethod.PUT)
		public Contribuyente vincularClaveImp(@PathVariable("claveFiscal") Long claveFiscal,
				@PathVariable("idImpuesto") Long idImpuesto) {
			Contribuyente u=this.getUsuarioClave(claveFiscal);
			Impuesto i=this.getImpuestoId(idImpuesto);
			
			u.impuesto.add(i);
			return Crepo.save(u);
		}
		
		
		
		//Metodo para listar impuestos por numero fiscal
			@RequestMapping(value="/Contribuyente/lista/{claveFiscal}", method=RequestMethod.GET)
			public List<Impuesto> getUsuarioClaveTipo(@PathVariable("claveFiscal") Long claveFiscal){
				Contribuyente us=this.getUsuarioClave(claveFiscal);
				return us.impuesto;
				
				
			}
		
		
		@RequestMapping(value="/Contribuyente/add", method=RequestMethod.POST)
		public Contribuyente createUser(@RequestBody Contribuyente body) {
			return Crepo.save(body);
			
		}
		
		@RequestMapping(value="/impuesto/add", method=RequestMethod.POST)
		public Impuesto createImp(@RequestBody Impuesto body) {
			return Irepo.save(body);
			
		}
	
	
	
	
	
	
	
	
	
}
