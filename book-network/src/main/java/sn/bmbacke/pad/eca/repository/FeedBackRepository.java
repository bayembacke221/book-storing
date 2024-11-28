package sn.bmbacke.pad.eca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.bmbacke.pad.eca.entity.feedback.Feedback;

public interface FeedBackRepository extends JpaRepository<Feedback, Integer> {

    @Query("""
            SELECT feedback
            FROM Feedback  feedback
            WHERE feedback.book.id = :bookId
""")
    Page<Feedback> findAllByBookId(@Param("bookId") Integer bookId, Pageable pageable);
}
