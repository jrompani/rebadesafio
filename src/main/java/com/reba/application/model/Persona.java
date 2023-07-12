	package com.reba.application.model;

	import com.fasterxml.jackson.annotation.JsonIgnore;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	import javax.persistence.*;
	import javax.validation.constraints.*;
	import java.util.List;

	@Entity
	@Data
	@Table(name = "personas")
	@NoArgsConstructor
	public class Persona {

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private Long id;
		@Column(nullable = false)
		private String nombre;
		@Column(nullable = false)
		private String apellido;
		@Column(nullable = false)
		@Min(value = 18, message = "La edad debe ser mayor o igual a 18")
		private Integer edad;
		@Column(name = "tipoDocumento", nullable = false)
		private String tipoDocumento;
		@Column(name = "numeroDocumento", nullable = false)
		@NotBlank(message = "El campo 'NumeroDocumento' es obligatorio")
		private String numeroDocumento;
		@Column(nullable = false)
		private String pais;
		@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
		@Column(name = "datosContacto", nullable = false)
		@NotNull(message = "Debe ingresar al menos un dato de contacto.")
		@JsonIgnore
		private List<DatosContacto> datosContacto;
		@Column(name = "nacionalidad_id")
		private Long nacionalidadId;
		@ManyToOne
		@JoinColumn(name = "padre_id")
		@JsonIgnore
		private Persona padre;


		public Persona(String nombre, String apellido, Integer edad, String tipoDocumento, String numeroDocumento, String pais, List<DatosContacto> datosContacto, Long nacionalidad, Persona padre) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
			this.tipoDocumento = tipoDocumento;
			this.numeroDocumento = numeroDocumento;
			this.pais = pais;
			this.datosContacto = datosContacto;
			this.nacionalidadId = nacionalidad;
			this.padre = padre;
		}

		@Override
		public String toString() {
			return "Persona{" +
					"id=" + id +
					", nombre='" + nombre + '\'' +
					", apellido='" + apellido + '\'' +
					", edad=" + edad +
					", tipoDocumento='" + tipoDocumento + '\'' +
					", numeroDocumento='" + numeroDocumento + '\'' +
					", pais='" + pais + '\'' +
					", nacionalidadId=" + nacionalidadId +
					'}';
		}
	}
