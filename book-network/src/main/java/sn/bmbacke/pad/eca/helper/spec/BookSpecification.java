package sn.bmbacke.pad.eca.helper.spec;

import org.springframework.data.jpa.domain.Specification;
import sn.bmbacke.pad.eca.entity.book.Book;

public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
