package br.com.raroacademy.product.domain.repository;

import br.com.raroacademy.product.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}