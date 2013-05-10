package megal.events;

import megal.model.EDecl;


/*
 * Represents an event when the entity for a given entity declaration is not found.
 */
public class EntityNotFound {
	/*
	 * Raw exception was raised while the framework was trying to find the entity.
	 */
	private Exception ex;
	
	/*
	 * An accocicated entity declaration which was used to get a "typed" entity.
	 */
	private EDecl eDecl;
	
	public EntityNotFound(Exception ex, EDecl eDecl){
		this.ex    = ex;
		this.eDecl = eDecl;
	}
	
	public Exception getException(){
		return this.ex;
	}
	
	public EDecl getEdecl(){
		return this.eDecl;
	}
}
