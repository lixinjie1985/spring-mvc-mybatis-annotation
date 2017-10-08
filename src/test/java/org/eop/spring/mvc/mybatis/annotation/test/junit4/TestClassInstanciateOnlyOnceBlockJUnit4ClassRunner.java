package org.eop.spring.mvc.mybatis.annotation.test.junit4;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner extends BlockJUnit4ClassRunner {

	protected Object testClassInstance;
	
	public TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}
	
	@Override
	protected Object createTest() throws Exception {
		if (testClassInstance == null) {
			testClassInstance = super.createTest();
		}
		return testClassInstance;
	}
}
