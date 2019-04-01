package br.com.andrade.vpd.tarefas.service;

import java.util.List;

import br.com.andrade.vpd.tarefas.exception.RegistroNaoEncontradoException;
import br.com.andrade.vpd.tarefas.model.Tarefa;

public interface TarefaService {
	

	Tarefa find(Integer id) throws RegistroNaoEncontradoException;

	void save(Tarefa tarefa);

	void update(Tarefa tarefa);

	void remove(Tarefa tarefa);

	List<Tarefa> listAll();

	
}
