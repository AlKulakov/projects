package org.example.aspects_aop.change_params_and_return_type;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    //Охватывает все выполняемые методы в классах папки service
    @Around("execution(* org.example.aspects_aop.change_params_and_return_type.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        //Имя выполняемого метода
        String methodName = joinPoint.getSignature().getName();
        //Аргументы метода
        Object[] arguments = joinPoint.getArgs();
        //Вывод информации в логах
        logger.info("Method" + methodName +
                " with params " + Arrays.asList(arguments) +
                " will execute"
                );
        Comment comment = new Comment();
        comment.setAuthor("Natasha");
        comment.setText("Some other text");
        Object[] newArgs = {comment};

        //Возвращаемое значение
        Object returnedByMethod = joinPoint.proceed(newArgs);
        //вывод информации возвращаемого значения
        logger.info("Method executed and returned " + returnedByMethod);
        //возвращаемое значение
        return "FAILED";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
