package sn.bmbacke.pad.eca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sn.bmbacke.pad.eca.payload.request.FeedbackRequest;
import sn.bmbacke.pad.eca.service.FeedbackService;

@RestController
@RequestMapping("feedbacks")
@RequiredArgsConstructor
@Tag(name = "Feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(
            @Valid @RequestBody FeedbackRequest feedbackRequest,
            Authentication connectedUser) {
        return ResponseEntity.ok(feedbackService.save(feedbackRequest, connectedUser));
    }


    @GetMapping("/book/{book-id}")
    public ResponseEntity<?> findAllFeedbacksByBook(
            @PathVariable("book-id") Integer bookId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Authentication connectedUser) {
        return ResponseEntity.ok(feedbackService.findAllFeedbacksByBook(bookId, page, size, connectedUser));
    }
}
