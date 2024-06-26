package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente_seguro"))
	private Seguro seguro;

	// Helper seguro
	public void addToSeguro(Seguro seguro) {
		this.seguro = seguro;
		seguro.getClientes().add(this);
	}

	public void removeFromSeguro(Seguro seguro) {
		seguro.getClientes().remove(this);
		this.seguro = null;
	}

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ToString.Exclude
	private List<Cita> citas = new ArrayList<>();
}