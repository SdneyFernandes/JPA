import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fsdney.domain.Acessorio;
import br.com.fsdney.domain.Carro;
import br.com.fsdney.domain.Marca;

import java.util.ArrayList;
import java.util.List;

public class TesteRelacionamento {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("JPA");
        em = emf.createEntityManager();
    }

    @AfterAll
    public static void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testRelacionamento() {
        em.getTransaction().begin();

        // Criar uma nova Marca
        Marca marca = new Marca("Toyota");

        // Criar novos Acessórios
        Acessorio acessorio1 = new Acessorio("Rodas de Liga Leve");
        Acessorio acessorio2 = new Acessorio("Faróis de LED");

        // Criar um novo Carro
        Carro carro = new Carro("Corolla", marca);

        // Adicionar acessórios ao carro
        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(acessorio1);
        acessorios.add(acessorio2);
        carro.setAcessorio(acessorios);

        // Persistir a Marca, Acessórios e Carro
        em.persist(marca);
        em.persist(acessorio1);
        em.persist(acessorio2);
        em.persist(carro);

        em.getTransaction().commit();
    }
}