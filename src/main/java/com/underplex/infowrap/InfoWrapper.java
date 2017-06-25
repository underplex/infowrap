package com.underplex.infowrap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility class that wraps and unwraps in bulk instances of classes implementing <code>InfoSource</code> or <code>MyInfoSource</code>.
 *   
 * @author Brandon Irvine
 *
 */
public class InfoWrapper {

	private InfoWrapper(){
		// don't instantiate
	}
	
	/**
	 * Returns instance of <code>U</code>, an element of <code>sourceCollection</code> which when wrapped is equal to <code>wrapped</code>.
	 * <p>
	 * Returns <code>null</code> if no corresponding element of <code>sourceCollection</code> represents <code>wrapped</code>.
	 */
	public static <T, U extends InfoSource<T>> U unwrap(Collection<U> sourceCollection, T wrapped){
		U ut = null;
		for ( U source : sourceCollection ){
			if ( source.info().equals(wrapped) )
				ut = source;
		}
		return ut;
	}

	/**
	 * Returns List of immutable, wrapped versions of each element in <code>sourceCollection</code>.
	 */
	public static <T> List<T> wrapToList(Collection<? extends InfoSource<T>> sourceCollection){
		List<T> rList = new ArrayList<T>();
		for ( InfoSource<T> source : sourceCollection ){
			rList.add( source.info() );
		}
		return rList;
	}

	/**
	 * Returns Set of immutable, wrapped versions of each element in <code>sourceCollection</code>.
	 */
	public static <T> Set<T> wrapToSet(Collection<? extends InfoSource<T>> sourceCollection){
		Set<T> rSet = new HashSet<T>();
		for ( InfoSource<T> source : sourceCollection ){
			rSet.add( source.info() );
		}
		return rSet;
	}
	
	/**
	 * Returns Set of <code>U</code> composed of elements of <code>sourceCollection</code> that correspond to elements of <code>wrappedCollection</code>.
	 * <p>
	 * Elements of <code>wrappedCollection</code> that have no unwrapped equivalent in <code>sourceCollection</code> won't be in the returned Set. 
	 */
	public static <T, U extends InfoSource<T>> Set<U> unwrapToSet(Collection<U> sourceCollection, Collection<T> wrappedCollection){
		Set<U> rSet = new HashSet<U>();
		U checker = null;
		for ( T wt : wrappedCollection ){
			checker = unwrap( sourceCollection, wt );
			if ( checker != null ){
				rSet.add( checker );
			}
		}
		
		return rSet;
	}
	
	/**
	 * Returns List of immutable, wrapped versions of each element in <code>sourceCollection</code>.
	 */
	public static <T> List<T> wrapToMyList(Collection<? extends MyInfoSource<T>> sourceCollection){
		List<T> rList = new ArrayList<T>();
		for ( MyInfoSource<T> source : sourceCollection ){
			rList.add( source.myInfo() );
		}
		return rList;
	}
}
