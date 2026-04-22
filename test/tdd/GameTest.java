package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	Game game;
	
	@BeforeEach
	void init() {
		game =new Game();
	}
	
	@Test 
	void test_aucune_quille(){
		for(int i=0;i<20;i++) {
			game.roll(0);
		}
		assertEquals(0,game.score());
	}
	
	@Test 
	void test_vingt_zero() {
		for(int i=1;i<20;i++) {
			game.roll(0);
		}
		assertEquals(0,game.score());
	}
	
	@Test 
	void test_vingt_un() {
		for(int i=0;i<20;i++) {
			game.roll(1);
		}
		assertEquals(20,game.score());
	}
	
	@Test
	void test_dix_un_dix_deux() {
		for(int i=0;i<10;i++) {
			game.roll(1);
		}
		for(int i=0;i<10;i++) {
			game.roll(2);
		}
		assertEquals(30,game.score());
	}
	
	@Test
	void test_spare() {
		game.roll(7);
		game.roll(3);
		game.roll(4);
		for(int i=0;i<17;i++) {
			game.roll(0);
		}
		assertEquals(18,game.score());
	}
	
	@Test
	void test_strike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		for(int i=0;i<16;i++) {
			game.roll(0);
		}
		assertEquals(24,game.score());
	}
	
	@Test 
	void test_cas_general() {
		game.roll(1);
		game.roll(2);
		game.roll(10);
		game.roll(0);
		game.roll(10);
		game.roll(4);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(4);
		game.roll(8);
		game.roll(2);
		game.roll(2);
		game.roll(7);
		assertEquals(122,game.score());
	}
	
	@Test 
	void test_extension() {
		game.roll(1);
		game.roll(2);
		game.roll(10);
		game.roll(0);
		game.roll(10);
		game.roll(4);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(2);
		game.roll(0);
		game.roll(10);
		game.roll(6);
		game.roll(4);
		game.roll(8);
		game.roll(2);
		game.roll(2);
		game.roll(8);
		game.roll(8);
		assertEquals(131,game.score());
	}
	
	@Test
	void test_genie() {
		for(int i=0;i<13;i++) {
			game.roll(10);
		}
		System.out.print(game.score());
		assertEquals(300,game.score());
	}
}
