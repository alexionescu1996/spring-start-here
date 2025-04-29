package org.example;


import org.example.aspect.LoggingAspect;
import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
//    aspect -   what code to execute
//    advice -   when
//    pointcut - which methods to intercept

    private static Logger logger = Logger.getLogger(App.class.getName());


    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Alex");
        comment.setText("Chapter AOP");

        service.publishComment(comment);
        comment.setText("Edited ___");
        service.editComment(comment);
        service.deleteComment(comment);
    }
}
