package co.vietnguyen.debuglog;



public class CustomMultilineRecursiveToStringStyle extends MultilineRecursiveToStringStyle {

    /**
     * Required for serialization support.
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 1L;



    /**
     * Constructor.
     */
    public CustomMultilineRecursiveToStringStyle() {
        super();
        setUseShortClassName(true);
        setUseIdentityHashCode(false);
    }



    @Override
    protected String getShortClassName(Class<?> cls) {
        String str = super.getShortClassName(cls);
        if (str.lastIndexOf(".") > 0) {
            str = str.substring(str.lastIndexOf(".") + 1);
        }
        return str;
    }
}