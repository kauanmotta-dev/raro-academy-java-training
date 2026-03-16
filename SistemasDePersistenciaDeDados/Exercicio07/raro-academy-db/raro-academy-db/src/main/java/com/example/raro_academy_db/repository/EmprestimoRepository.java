package com.example.raro_academy_db.repository;

import com.example.raro_academy_db.domain.Emprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmprestimoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //Emprestimo sem Procedure
    @Transactional
    public void realizarEmprestimoSemProcedure(Emprestimo emprestimo) {
        entityManager.persist(emprestimo);
        System.out.println(String.format(
                "\nEmprestimo realizado com sucesso!!\n" +
                "Data de Empréstimo: %s\n" +
                "Data de Devolucação: %s\n",
                emprestimo.getData_emprestimo().toString(),
                emprestimo.getData_devolucao().toString()));
    }

    //Emprestimo com Procedure
    @Transactional
    public void realizarEmprestimoComProcedure(int codigoAssociado,
                                               int codigoItem,
                                               LocalDate dataEmprestimo,
                                               LocalDate dataDevolucao) {

        entityManager.createNativeQuery("CALL realizar_emprestimo(:codigoAssociado, :codigoItem, :dataEmprestimo, :dataDevolucao)")
                .setParameter("codigoAssociado", codigoAssociado)
                .setParameter("codigoItem", codigoItem)
                .setParameter("dataEmprestimo", dataEmprestimo)
                .setParameter("dataDevolucao", dataDevolucao)
                .executeUpdate();
        System.out.println(String.format(
                "\nEmprestimo realizado com sucesso!!\n" +
                        "Data de Empréstimo: %s\n" +
                        "Data de Devolucação: %s\n",
                dataEmprestimo.toString(),
                dataDevolucao.toString()));
    }

    //Bucas de Emprestimos Ativos usando JPQL por Ordem de Devolução
    public List<Emprestimo> buscarEmprestimosAtivosPorOrdemDeDevolução () {
        List<Emprestimo> emprestimosAtivos = entityManager.createQuery(
                "SELECT e FROM Emprestimo e " +
                   "WHERE e.data_devolucao > CURRENT_DATE " +
                   "ORDER BY e.data_devolucao ASC", Emprestimo.class).getResultList();
        System.out.println("\nEmpréstimos Ativos em Ordem de Devolução:");
        emprestimosAtivos.forEach(System.out::println);
        return emprestimosAtivos;
    }
}