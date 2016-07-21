package com.underplex.infowrap;

/**
 * Implementing classes are wrapped by <code>T</code>.
 * <p>
 * This interface is designed in particular for the purposes of providing wrapper classes in 
 * simulations. Frequently, simulated agents need access to information 
 * about an aspect of the simulation but should not be able to change the state of the simulation. Wrappers
 * can provide information from the wrapped object without allowing any change of state for the underlying wrapped object.
 * <p>
 * Unless otherwise stated in the class description of an implementing, the following 
 * are true of the implementing class and <code>T</code>:
 * <ul>
 * <li>The implementing class represents some aspect of the simulation.</li>
 * <li>The wrapper class <code>T</code> is immutable and has no methods that mutate itself or other objects.</li>
 * <li>The wrapper class <code>T</code> provides information on the wrapped object that is freely available to all agents in the simulation.</li>
 * <li>The wrapper class <code>T</code> provides information via appropriate delegate methods, not by statically copying
 * the wrapped class.</li>
 * <li>No methods of the wrapper class <code>T</code> may themselves return a type with any methods that are not immutable or mutate
 * any object.</li>
 * </ul>
 * For example, a simulation of the economy might have workers
 * represented by instances of <code>Worker</code>, 
 * whose member field of type <code>DecisionMaker</code> actually makes decisions for 
 * the <code>Worker</code>.
 * <p>
 * The <code>DecisionMaker</code> class is suspect code that might seek to 
 * change the state of any object passed to one of its methods.
 * <p> 
 * <pre>
 * <code>  
 * \\ A worker is created and assigned a strategy.  
 * Worker worker = new Worker();
 * \\ The decision-making aspect of the worker is created.
 * \\ NOTE: It doesn't have direct access to change the fields of worker.
 * worker.setDecisionMaker(new DecisionMaker(worker.info());
 * 
 * \\ A job is created that pays $30 an hour.
 * Job job = new Job();
 * job.setWage(30);
 * job.setBoss(new Boss());
 * 
 * \\ A jobs report is created using information on the economy.
 * JobsReport jobsReport = Report.createJobsReport(economy);
 * 
 * \\ We change the internal state of the worker, improving his skill rating.
 * worker.improveSkill();
 * 
 * \\ The decision-maker part of the worker can learn about the worker's state, 
 * \\ the job and jobs report, but the decision-maker cannot change the state of any of these.
 * 
 * DecisionMaker dm = worker.getDecisionMaker();
 * 
 * \\ The <code>DecisionMaker</code> already has a reference to the worker.
 * \\ job.info().getBoss() should return an immutable wrapper of Boss, not Boss itself. 
 * boolean accept = dm.acceptJob(job.info(), jobsReport.info());
 * 
 * if (accept){
 * 	  worker.takeJob(job);
 * }
 * </code>
 * </pre>
 * 
 * This interface can be used in conjunction with <code>InfoWrapper</code> to quickly wrap and unwrap collections of elements.
 * @author Brandon Irvine
 *
 * @param <T>	class that is immutable and provides information
 */
public interface InfoSource<T> {

	/**
	 * Returns immutable wrapper of the implementing class.
	 */
	T info();
	
}
