package br.salaoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import br.salaoeveris.app.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

	Optional<Cliente> findById(Long id);

}
