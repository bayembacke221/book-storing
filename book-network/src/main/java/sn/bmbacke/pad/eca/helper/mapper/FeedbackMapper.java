package sn.bmbacke.pad.eca.helper.mapper;

import org.springframework.stereotype.Service;
import sn.bmbacke.pad.eca.entity.book.Book;
import sn.bmbacke.pad.eca.entity.feedback.Feedback;
import sn.bmbacke.pad.eca.payload.request.FeedbackRequest;
import sn.bmbacke.pad.eca.payload.response.FeedbackResponse;

import java.util.Objects;

@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .shareable(false)
                        .archived(false)
                        .build()
                )
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getBook().getOwner().getId(), id))
                .build();
    }
}
