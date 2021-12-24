package com.demo.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// Setup Logger
	private Logger mLogger = Logger.getLogger(getClass().getName());
	
	// Setup pointcut declarations
	@Pointcut("execution(* com.demo.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.demo.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.demo.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint iJoinPoint) {
		String lMethodSignature = iJoinPoint.getSignature().toShortString();
		mLogger.info("======>>> in @Before: calling method: " + lMethodSignature);
	}
	
	// Add @AfterRetuning advice
	
}
