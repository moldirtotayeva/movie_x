import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("main").createEntityManager();
        if (em.isOpen()) {
            System.out.println("Подключение к базе данных установлено");
        }
    }

}
