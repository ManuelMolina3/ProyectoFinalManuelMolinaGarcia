package com.salesianostriana.dam.proyectofinal.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.concesionario.model.Cliente;
import com.salesianostriana.dam.concesionario.model.LineaVenta;
import com.salesianostriana.dam.concesionario.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Materiales;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.repository.IVentaRepository;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaService extends BaseService<Venta, Long, IVentaRepository> {

	private Map<Materiales, Integer> lineaVentas = new HashMap<>();

	public void addMateriales(Optional<Materiales> material) {
		if (material.isPresent()) {
			Materiales m = material.get();
			if (lineaVentas.containsKey(m)) {
				lineaVentas.replace(m, lineaVentas.get(m) + 1);
			} else {
				lineaVentas.put(m, 1);
			}
		}
	}

	public void removeMateriales(Optional <Materiales> material) {
		if (material.isPresent() && lineaVentas.containsKey(material.get())) {
	        if (lineaVentas.get(material.get()) > 1) {
	            lineaVentas.replace(material.get(), lineaVentas.get(material.get()) - 1);
	        } else if (lineaVentas.get(material.get()) == 1) {
	            lineaVentas.remove(material.get());
	        }
	    }
	}

	public Map<Materiales, Integer> getMaterialesInCart() {
		return Collections.unmodifiableMap(lineaVentas);
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
	public void crearVenta(@AuthenticationPrincipal Reforma reforma) {
	    Venta v = new Venta();
	    for (Materiales m : lineaVentas.keySet()) {
	        v.addLineaVenta(
	        	LineaVenta.builder()
	        		.producto(p)
	        		.cantidad(listaLineaVentas.get(p))
	        		.build()
	        );
	    }
	    v.setFecha(LocalDate.now());
	    v.setTotal(totalCarrito());
	    v.setCliente(cliente);
	    v.setTrabajador(null);
	    save(v);
	    
	    listaLineaVentas.clear();
	}
}
