package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

public class ArithmeticTest {
	
	private Arithmetic arithmetic;
	private static int ZERO;
	
	@Nested
	public class DivisionTest{
		
		private Arithmetic arithmetic;
		
		@Test
		public void testDivByZero(){
			arithmetic = new ArithmeticImp();
			assertThrows(ArithmeticException.class,()->{arithmetic.div(2, ZERO);});
		}
	}
	
	
	
	@Nested
	@DisplayName("This is for testing Sub Method of the Arithmetic")
	public  class SubtractionTest{
		
		private Arithmetic arithmetic;
		
		
		@ParameterizedTest
		@CsvSource({
			"'Subtraction 2 Positive Nos',2,3,-1",
			"'Subtraction 2 Negative Nos',-2,-3,1",
			"'Subtraction 1 Positive 1 Negative No',-2,3,-5",
		})
		
		@Test
		public void testSub(String name,int a,int b,int res){
			assertEquals(res, arithmetic.sub(a, b));
		}
	}
	
	
	
	
	@DisplayName("{index} {0} {1} + {2} = {3}")
	@ParameterizedTest
	@CsvSource({
		"'Adding 2 Positive Nos',2,3,5",
		"'Adding 2 Negative Nos',-2,-3,-5",
		"'Adding 1 Positive 1 Negative No',-2,3,-1",
	})
	public void testAdd(String name,int a,int b,int res){
		assertEquals(res,arithmetic.add(a, b));
	}
	
	
	public static Stream<Arguments> argumentsForAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	
	@DisplayName("{index}) Testing for add with {0} and {1} should be equals{2}")
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a,int b,int res){
		
	}
	
	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,-2})
	@DisplayName(value="{index}) Testing for add with {0} and 0")
	public void testAdd(int a){
		assertEquals(a,arithmetic.add(a, ZERO));
		
	}
	
	
//	@Test
//	@DisplayName("Generic Test Cases for Add..")
//	public void testAdd(){
//		assertEquals(5,arithmetic.add(2, 3));
//		assertEquals(10,arithmetic.add(5, 5));
//	}
	
	@BeforeAll
	public static void executeMeFirst(){
		System.out.println("Before all -executed first");
		ZERO=0;
	}
	
	@AfterAll
	public static void executeMeJustBeforeProgramExits(){
		System.out.println("Last method to be executed");
	}
	
    @BeforeEach
    public void runBeforeTest() {
        arithmetic = new ArithmeticImp();
        System.out.println("Run before......");
    }
    
    
    @AfterEach
    public void afterTest() {
      arithmetic = new ArithmeticImp();
        System.out.println("After Each Method");
    }
    
    @Test
    public void testHi() {
        System.out.println("Hii......");;
    }
        
    @Test
    public void testHello() {
        System.out.println("Hello....");
    }
}
