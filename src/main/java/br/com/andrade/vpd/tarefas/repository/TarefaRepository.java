package br.com.andrade.vpd.tarefas.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.andrade.vpd.tarefas.model.Tarefa;

@Transactional
@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
	

}
