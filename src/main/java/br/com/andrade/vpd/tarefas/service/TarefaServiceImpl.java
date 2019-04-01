package br.com.andrade.vpd.tarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrade.vpd.tarefas.exception.RegistroNaoEncontradoException;
import br.com.andrade.vpd.tarefas.model.Tarefa;
import br.com.andrade.vpd.tarefas.repository.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaRepository repositorio;

	@Override
	public Tarefa find(Integer id) throws RegistroNaoEncontradoException {
		Optional<Tarefa> op = repositorio.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		throw new RegistroNaoEncontradoException("Não foi possivel recuperar a Tarefa.");
	}

	@Override
	public void save(Tarefa tarefa) {
		repositorio.save(tarefa);
	}
	@Override
	public void update(Tarefa tarefa) {
		repositorio.save(tarefa);
	}

	@Override
	public void remove(Tarefa tarefa) {
		Optional<Tarefa> objDelete = repositorio.findById(tarefa.getId());
		repositorio.delete(objDelete.get());
	}

	@Override
	public List<Tarefa> listAll() {
	return (List<Tarefa>) repositorio.findAll();
	}


}
