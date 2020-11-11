package br.salaoeveris.app.request;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AgendamentoRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "clienteId")
	private ClienteRequest idCliente;

	@ManyToOne
	@JoinColumn(name = "servicoId")
	private ServicoRequest idServico;

	private LocalDateTime dataHora;

	public ClienteRequest getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteRequest idCliente) {
		this.idCliente = idCliente;
	}

	public ServicoRequest getIdServico() {
		return idServico;
	}

	public void setIdServico(ServicoRequest idServico) {
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
