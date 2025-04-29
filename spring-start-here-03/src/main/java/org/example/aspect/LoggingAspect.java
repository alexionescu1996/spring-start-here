package org.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("execution(* org.example.services.*.*(..))")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//        logger.info("Method " + methodName + " with params " +
//                Arrays.asList(args)
//                + " will execute");
//
//
//        Comment comment = new Comment();
//        comment.setText("test_this_is_updated");
//
//        Object[] newArgs = {comment};
//        Object returnedByMethod = joinPoint.proceed(newArgs);
//        logger.info("Method executed and returned " + returnedByMethod);
//
//        return "FAILED";
//    }

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();

        logger.info("Method " + methodName + " with params " +
                Arrays.asList(args)
                + " will execute");

        return proceedingJoinPoint.proceed();
    }
}
