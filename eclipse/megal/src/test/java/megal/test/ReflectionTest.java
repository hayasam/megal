package megal.test;

import static org.junit.Assert.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import megal.Relationship;
import megal.model.RDecl;

import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

public class ReflectionTest {
	
	List<megal.Runtime.Relationship> coreRels;
	List<megal.Runtime.Relationship> customRels;
	
	@Before
	public void setUp() throws Exception {
		megal.Runtime runtime = new megal.Runtime();
		
		coreRels = runtime.getCoreRels();
		customRels = runtime.getCustomRels();
	}
	
	@Test
	public void findAllRuntimeRelationships(){
		assertSame(3, coreRels.size());
		assertSame(1, customRels.size());
		
		assertSame(false, customRels.get(0).isCore());
	}	
	
	@Test
	public void getCoreForCustomRelationship(){
		megal.Runtime.Relationship rel = customRels.get(0);
		megal.Runtime.Relationship core = rel.getCore();
		assertSame(true, core.isCore());
	}
	
	@Test
	public void getRDeclForCustomRelationship(){
		megal.Runtime.Relationship rel = customRels.get(0);
		RDecl rDecl = rel.toRDecl();
		
		String name = rDecl.getRel().getName();
		assertEquals("elementOf", name);
		
		String left = rDecl.getLeft().getName();
		assertEquals("File", left);
		
		String right = rDecl.getRight().getName();
		assertEquals("Language", right);
		
		assertEquals(false, rDecl.isCore());
	}
}
