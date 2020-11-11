package br.salaoeveris.app.repository;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AgendamentoRepository {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "clienteId")
	private ClienteRepository idCliente;

	@ManyToOne
	@JoinColumn(name = "servicoId")
	private ServicoRepository idServico;

	private LocalDateTime dataHora;

	public ClienteRepository getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteRepository idCliente) {
		this.idCliente = idCliente;
	}

	public ServicoRepository getIdServico() {
		return idServico;
	}

	public void setIdServico(ServicoRepository idServico) {
		this.idServico = idServico;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
