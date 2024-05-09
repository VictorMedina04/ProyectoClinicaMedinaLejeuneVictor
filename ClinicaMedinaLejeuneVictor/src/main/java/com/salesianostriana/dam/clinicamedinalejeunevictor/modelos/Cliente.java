package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente_seguro"))
	private Seguro seguro;

	public void addToSeguro(Seguro seguro) {
		this.seguro = seguro;
		seguro.getClientes().add(this);
	}

	public void removeFromSeguro(Seguro seguro) {
		seguro.getClientes().remove(this);
		this.seguro = null;
	}

}
