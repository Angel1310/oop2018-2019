package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNandAndGate {

	private Wire in1;
	private Wire in2;
	private Wire out;

	private Gate andGate;

	@Before
	public void beforeEach() {
		in1 = new Wire();
		in2 = new Wire();

		out = new Wire();

		andGate = NandFactory.makeAndGate(in1, in2, out);
		assertNotNull(andGate);
	}

	@Test
	public void testIn1FalseIn2False() {
		assertFalse(in1.getSignal());
		assertFalse(in2.getSignal());
		assertFalse(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2False() {
		in1.setSignal(true);
		assertFalse(out.getSignal());
	}

	@Test
	public void outIn1FalseIn2True() {
		in2.setSignal(true);
		assertFalse(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2True() {
		in1.setSignal(true);
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

}