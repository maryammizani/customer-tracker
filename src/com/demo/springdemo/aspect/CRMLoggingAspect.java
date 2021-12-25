package com.demo.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		
		// Display Method args
		Object[] lArgs = iJoinPoint.getArgs();
		for(Object lArg: lArgs) {
			mLogger.info("======>>> args: " + lArg);
		}
	}
	
	// Add @AfterRetuning advice
	@AfterReturning(pointcut="forAppFlow()",
			returning="iResult"
			)
	public void afterReturning(JoinPoint iJoinPoint, Object iResult) {
		
		String lMethodSignature = iJoinPoint.getSignature().toShortString();
		mLogger.info("======>>> in @AfterReturning: calling method: " + lMethodSignature);
		
		// Display Data returned
		mLogger.info("======>>> result: " + iResult);
	}
	
}
