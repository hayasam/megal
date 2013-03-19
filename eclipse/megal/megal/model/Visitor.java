package megal.model;

import megal.logging.Log;
import megal.model.*;

/**
 * Reusable walker over MegaL model
 */
public class Visitor {
	protected Log log;
	public Visitor(Model model, Log log) {
		this.log = log;
		for (Decl decl : model.getDecls()) {
			if (decl instanceof EDecl) {
				EDecl edecl = (EDecl)decl;
				visit(edecl);
			} else if (decl instanceof RDecl) {
				RDecl rdecl = (RDecl)decl;
				visit(rdecl);
			}  else if (decl instanceof ETDecl) {
				ETDecl etdecl = (ETDecl)decl;
				visit(etdecl);
			}  else if (decl instanceof RTDecl) {
				RTDecl rtdecl = (RTDecl)decl;
				visit(rtdecl);
			}
		}
	}
	public void visit(EDecl edecl) { }
	public void visit(RDecl rdecl) { }
	public void visit(ETDecl etdecl) { }
	public void visit(RTDecl rtdecl) { }	
}