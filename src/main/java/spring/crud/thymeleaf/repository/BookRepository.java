package spring.crud.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import spring.crud.thymeleaf.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {


}
