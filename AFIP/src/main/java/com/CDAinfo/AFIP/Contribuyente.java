 package com.CDAinfo.AFIP;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



	@Entity
public class Contribuyente {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//		private Long id;
		private Long claveFiscal;
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "apellido")
		private String apellido;
		
		@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		@JoinTable(name="Cont_Imp")
		public List<Impuesto>impuesto;
		
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
		
		public Contribuyente(Long claveFiscal, String nombre, String apellido) {
			super();
			this.claveFiscal = claveFiscal;
			this.nombre = nombre;
			this.apellido = apellido;
		}


		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public Long getClaveFiscal() {
			return claveFiscal;
		}

		public void setClaveFiscal(Long claveFiscal) {
			this.claveFiscal = claveFiscal;
		}

		
		@Override
		public String toString() {
			return "Contribuyente [claveFiscal=" + claveFiscal + ", nombre=" + nombre + ", apellido=" + apellido + "]";
		}


		


	}
