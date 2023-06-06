package com.salesianostriana.dam.proyectofinal.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.Materiales;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.repository.IVentaRepository;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaService extends BaseService<Venta, Long, IVentaRepository> {

	private Map<Materiales, Integer> listaLineaVentas = new HashMap<>();

	public void addMateriales(Materiales m) {
		if (listaLineaVentas.containsKey(m)) {
			listaLineaVentas.replace(m, listaLineaVentas.get(m) + 1);
		} else {
			listaLineaVentas.put(m, 1);
		}
	}

	public void removeMateriales(Optional<Materiales> materiales) {
		if (materiales.isPresent() && listaLineaVentas.containsKey(materiales.get())) {
			if (listaLineaVentas.get(materiales.get()) > 1) {
				listaLineaVentas.replace(materiales.get(), listaLineaVentas.get(materiales.get()) - 1);
			} else if (listaLineaVentas.get(materiales.get()) == 1) {
				listaLineaVentas.remove(materiales.get());
			}
		}
	}

	public Map<Materiales, Integer> getMaterialesInCart() {
		return Collections.unmodifiableMap(listaLineaVentas);
	}

	public Double totalCarrito() {
		Map<Materiales, Integer> carrito = getMaterialesInCart();
		double totalCarro = 0.0;
		if (carrito != null) {
			for (Materiales m : carrito.keySet()) {
				totalCarro += m.getPvpMaterial() * carrito.get(m);
			}
			return totalCarro;
		}
		return 0.0;
	}
}
