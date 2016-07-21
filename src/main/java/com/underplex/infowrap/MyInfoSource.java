package com.underplex.infowrap;

/**
 * Implementing classes are wrapped by <code>T</code>.
 * <p>
 * Implementing classes and <code>T</code> should work almost identically to the functionality of <code>InfoSource</code> interface, with
 * one key exception: Classes implementing <code>MyInfoSource</code> will provide secret 
 * information via instances of <code>T</code>.
 * <p>
 * This interface can differentiate information only available to a specific agent in a simulation from 
 * information available to every agent, which might be provided by classes implementing <code>InfoSource</code>.
 * 
 * <pre>
 * <code>  
 * \\ A worker is created and assigned a strategy.  
 * Worker worker = new Worker();
 * \\ The decision-making aspect of the worker is created.
 * \\ NOTE: It doesn't have direct access to change the fields of worker.
 * worker.setDecisionMaker(new DecisionMaker(worker.myInfo());
 * 
 * \\ Worker's desired wage can be set...
 * worker.setDesiredWage(35);
 * 
 * DecisionMaker dm = worker.getDecisionMaker();
 * 
 * \\ Company X only sees the freely available info on worker, which may not include the worker's desired wage.
 * if (companyX.giveOffer(worker.info()){
 * 		Job job = new Job(30);
 * 		
 * 		\\ The decision-maker has access to worker.myInfo() via constructor, so it can see the worker's desired wage.
 * 		boolean accept = dm.considerJob(job.info(); 
 * 		if (accept){
 * 			worker.takeJob(job);
 * 		}
 * }
 *

 * @author Brandon Irvine
 * @param <T>	class that is immutable and provides exclusive information
 */
public interface MyInfoSource<T> {

	/**
	 * Returns immutable wrapper of the implementing class, with exclusive information for a particular agent.
	 */
	T myInfo();
	
}
