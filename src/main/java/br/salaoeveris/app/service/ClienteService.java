package br.salaoeveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;



@Service
public class ClienteService {

	
	final private ClienteRepository _repository;
	@Autowired
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		ClienteResponse base = new ClienteResponse();
		base.statusCode = 400;
		
		if(clienteRequest.getNome() == "" || clienteRequest.getNome() == null) {
			base.message = "Nome do cliente não foi informado!";
			return base;
		}
		if(clienteRequest.getTelefone() == "" || clienteRequest.getTelefone() == null) {
			base.message = "Telefone do cliente não foi informado!";
			return base;
		}
		if(clienteRequest.getEndereco() == "" || clienteRequest.getEndereco() == null) {
			base.message = "Endereço do cliente não foi informado!";
			return base;
		}
		if(clienteRequest.getCpf() == "" || clienteRequest.getCpf() == null) {
			base.message = "CPF do cliente não foi informado!";
		return base;
		}
	
		cliente.setNome(clienteRequest.getNome());
		base.statusCode = 201;
		base.message = "Cliente inserido com sucesso!";
		return base;
	}
	
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);		
		ClienteResponse response = new ClienteResponse();

		if (cliente == null) {
			response.message = "Cliente não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setTelefone(cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());

		response.message = "Cliente obtido com sucesso";
		response.statusCode = 200;
		return response;
	}
	
}