package megal.analysis;

import megal.logging.Log;
import megal.model.EDecl;
import megal.model.Model;
import megal.model.Visitor;

public class Resolution extends Visitor {
	
	private boolean allResolved = true;
	
	public Resolution(Model model, Log log){
		super(model, log);
	}
	
	@Override
	public void visit(EDecl edecl) { 
		boolean isResolved = edecl.getEntity().tryResolve();
		System.out.println(isResolved);
		if (!isResolved){
			this.allResolved = false;
		}
	}

	public boolean isAllResolved() {
		return allResolved;
	}
}
