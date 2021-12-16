package roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import files.FileInfoReader;

class ProfessorTest {
	
	//declare a Professor for testing
	Professor professor; 

	//run before each unit test method
	@BeforeEach
	void setUp() throws Exception {
		//load the professor to the arrayList
		FileInfoReader.setProfessorInfo();
	}

	@Test
	void test() {
		fail("Not yet implemented"); // TODO
	}

}
