package com.example.raro_academy_db;

import com.example.raro_academy_db.domain.Emprestimo;
import com.example.raro_academy_db.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RaroAcademyDbApplication implements CommandLineRunner {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RaroAcademyDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//emprestimo com Procedure
		//adicionei o codigoItem 1 e o CodigoAssociado 1 no banco para realizar o teste
		emprestimoRepository.realizarEmprestimoComProcedure(1,
				1,
				LocalDate.now(),
				LocalDate.now().plusDays(5));

		//Emprestimo sem Procedure
		Emprestimo emprestimo = new Emprestimo(1, 1,LocalDate.now(),LocalDate.now().plusDays(2) );
		emprestimoRepository.realizarEmprestimoSemProcedure(emprestimo);

		//Bucas de Emprestimos Ativos em Ordem de Devolução
		emprestimoRepository.buscarEmprestimosAtivosPorOrdemDeDevolução();
	}
}