package org.example.services;

import org.example.aspect.ToLog;
import org.example.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CommentService {

    Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    @ToLog
    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }

}
