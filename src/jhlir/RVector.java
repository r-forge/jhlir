package jhlir;

/**
 * Common interface for RVector Objects.
 * @param <WRAPPED_TYPE> underlying type of the used backend. @see RObj
 * @param <ARR_TYPE> used Java array to store the data.
 * @param <EL_TYPE> Boxed type of an element of ARR_TYPE.
 * Example: For RInteger {@code ARR_TYPE} equals {@code int[]} and 
 * @code EL_TYPE} equals {@code Integer}.
 */
public interface RVector<WRAPPED_TYPE, ARR_TYPE, EL_TYPE>
        extends RVectorFactor<WRAPPED_TYPE, ARR_TYPE, EL_TYPE> {

}
