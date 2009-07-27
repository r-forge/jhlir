package jhlir;

public interface RRef<WRAPPED_REF, RESOLVED_TYPE> {
    RESOLVED_TYPE getResolved();
}
