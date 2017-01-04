package hu.elte.txtuml.stdlib.net;


import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Class {@code URLImpl} represents a {@code URL} Uniform Resource
 * Locator implementation, a pointer to a "resource" on the World
 * Wide Web. A resource can be something as simple as a file or a
 * directory, or it can be a reference to a more complicated object,
 * such as a query to a database or to a search engine. More
 * information on the types of URLs and their formats can be found at:
 * <a href=
 * "http://web.archive.org/web/20051219043731/http://archive.ncsa.uiuc.edu/SDG/Software/Mosaic/Demo/url-primer.html">
 * 
 * @author Valeh Hajiyev
 * @see java.net.URL
 */
public class URLImpl implements URL, Serializable {

	private static final long serialVersionUID = -3877493174942135520L;
	
	private java.net.URL instance;
	
    /**
     * Creates a {@code URL} object from the {@code java.net.URL}
     * representation.
     *
     * @param      a {@code java.net.URL} instance.
     */
	public URLImpl(java.net.URL url) {
		this.instance = url;
	}
	
    /**
     * Creates a {@code URL} object from the {@code String}
     * representation.
     * <p>
     * This constructor is equivalent to a call to the two-argument
     * constructor with a {@code null} first argument.
     *
     * @param      spec   the {@code String} to parse as a URL.
     * @exception  MalformedURLException  if no protocol is specified, or an
     *               unknown protocol is found, or {@code spec} is {@code null}.
     * @see        java.net.URL#URL(java.net.URL, java.lang.String)
     */
	public URLImpl(String spec) throws MalformedURLException {
		this.instance = new java.net.URL(spec);
	}
	
    /**
     * Creates a {@code URL} object from the specified
     * {@code protocol}, {@code host}, {@code port}
     * number, and {@code file}.<p>
     *
     * {@code host} can be expressed as a host name or a literal
     * IP address. If IPv6 literal address is used, it should be
     * enclosed in square brackets ({@code '['} and {@code ']'}), as
     * specified by <a
     * href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>;
     * However, the literal IPv6 address format defined in <a
     * href="http://www.ietf.org/rfc/rfc2373.txt"><i>RFC&nbsp;2373: IP
     * Version 6 Addressing Architecture</i></a> is also accepted.<p>
     *
     * Specifying a {@code port} number of {@code -1}
     * indicates that the URL should use the default port for the
     * protocol.<p>
     *
     * If this is the first URL object being created with the specified
     * protocol, a <i>stream protocol handler</i> object, an instance of
     * class {@code URLStreamHandler}, is created for that protocol:
     * <ol>
     * <li>If the application has previously set up an instance of
     *     {@code URLStreamHandlerFactory} as the stream handler factory,
     *     then the {@code createURLStreamHandler} method of that instance
     *     is called with the protocol string as an argument to create the
     *     stream protocol handler.
     * <li>If no {@code URLStreamHandlerFactory} has yet been set up,
     *     or if the factory's {@code createURLStreamHandler} method
     *     returns {@code null}, then the constructor finds the
     *     value of the system property:
     *     <blockquote><pre>
     *         java.protocol.handler.pkgs
     *     </pre></blockquote>
     *     If the value of that system property is not {@code null},
     *     it is interpreted as a list of packages separated by a vertical
     *     slash character '{@code |}'. The constructor tries to load
     *     the class named:
     *     <blockquote><pre>
     *         &lt;<i>package</i>&gt;.&lt;<i>protocol</i>&gt;.Handler
     *     </pre></blockquote>
     *     where &lt;<i>package</i>&gt; is replaced by the name of the package
     *     and &lt;<i>protocol</i>&gt; is replaced by the name of the protocol.
     *     If this class does not exist, or if the class exists but it is not
     *     a subclass of {@code URLStreamHandler}, then the next package
     *     in the list is tried.
     * <li>If the previous step fails to find a protocol handler, then the
     *     constructor tries to load from a system default package.
     *     <blockquote><pre>
     *         &lt;<i>system default package</i>&gt;.&lt;<i>protocol</i>&gt;.Handler
     *     </pre></blockquote>
     *     If this class does not exist, or if the class exists but it is not a
     *     subclass of {@code URLStreamHandler}, then a
     *     {@code MalformedURLException} is thrown.
     * </ol>
     *
     * <p>Protocol handlers for the following protocols are guaranteed
     * to exist on the search path :-
     * <blockquote><pre>
     *     http, https, file, and jar
     * </pre></blockquote>
     * Protocol handlers for additional protocols may also be
     * available.
     *
     * <p>No validation of the inputs is performed by this constructor.
     *
     * @param      protocol   the name of the protocol to use.
     * @param      host       the name of the host.
     * @param      port       the port number on the host.
     * @param      file       the file on the host
     * @exception  MalformedURLException  if an unknown protocol is specified.
     * @see        java.lang.System#getProperty(java.lang.String)
     * @see        java.net.URL#setURLStreamHandlerFactory(
     *                  java.net.URLStreamHandlerFactory)
     * @see        java.net.URLStreamHandler
     * @see        java.net.URLStreamHandlerFactory#createURLStreamHandler(
     *                  java.lang.String)
     */
	public URLImpl(String protocol, String host, int port, String file) throws MalformedURLException {
		this.instance = new java.net.URL(protocol, host, port, file);
	}
	
    /**
     * Creates a URL from the specified {@code protocol}
     * name, {@code host} name, and {@code file} name. The
     * default port for the specified protocol is used.
     * <p>
     * This method is equivalent to calling the four-argument
     * constructor with the arguments being {@code protocol},
     * {@code host}, {@code -1}, and {@code file}.
     *
     * No validation of the inputs is performed by this constructor.
     *
     * @param      protocol   the name of the protocol to use.
     * @param      host       the name of the host.
     * @param      file       the file on the host.
     * @exception  MalformedURLException  if an unknown protocol is specified.
     * @see        java.net.URL#URL(java.lang.String, java.lang.String,
     *                  int, java.lang.String)
     */
	public URLImpl(String protocol, String host, String file) throws MalformedURLException {
		this.instance = new java.net.URL(protocol, host, file);
	}
	
    /**
     * Creates a URL by parsing the given spec within a specified context.
     *
     * The new URL is created from the given context URL and the spec
     * argument as described in
     * RFC2396 &quot;Uniform Resource Identifiers : Generic * Syntax&quot; :
     * <blockquote><pre>
     *          &lt;scheme&gt;://&lt;authority&gt;&lt;path&gt;?&lt;query&gt;#&lt;fragment&gt;
     * </pre></blockquote>
     * The reference is parsed into the scheme, authority, path, query and
     * fragment parts. If the path component is empty and the scheme,
     * authority, and query components are undefined, then the new URL is a
     * reference to the current document. Otherwise, the fragment and query
     * parts present in the spec are used in the new URL.
     * <p>
     * If the scheme component is defined in the given spec and does not match
     * the scheme of the context, then the new URL is created as an absolute
     * URL based on the spec alone. Otherwise the scheme component is inherited
     * from the context URL.
     * <p>
     * If the authority component is present in the spec then the spec is
     * treated as absolute and the spec authority and path will replace the
     * context authority and path. If the authority component is absent in the
     * spec then the authority of the new URL will be inherited from the
     * context.
     * <p>
     * If the spec's path component begins with a slash character
     * &quot;/&quot; then the
     * path is treated as absolute and the spec path replaces the context path.
     * <p>
     * Otherwise, the path is treated as a relative path and is appended to the
     * context path, as described in RFC2396. Also, in this case,
     * the path is canonicalized through the removal of directory
     * changes made by occurrences of &quot;..&quot; and &quot;.&quot;.
     * <p>
     * For a more detailed description of URL parsing, refer to RFC2396.
     *
     * @param      context   the context in which to parse the specification.
     * @param      spec      the {@code String} to parse as a URL.
     * @exception  MalformedURLException  if no protocol is specified, or an
     *               unknown protocol is found, or {@code spec} is {@code null}.
     * @see        java.net.URL#URL(java.lang.String, java.lang.String,
     *                  int, java.lang.String)
     * @see        java.net.URLStreamHandler
     * @see        java.net.URLStreamHandler#parseURL(java.net.URL,
     *                  java.lang.String, int, int)
     */
	public URLImpl(hu.elte.txtuml.stdlib.net.URL context, String spec) throws MalformedURLException {
		this.instance = new java.net.URL(context.toURL(), spec);
	}
	
    /**
     * Compares this URL for equality with another object.<p>
     *
     * If the given object is not a URL then this method immediately returns
     * {@code false}.<p>
     *
     * Two URL objects are equal if they have the same protocol, reference
     * equivalent hosts, have the same port number on the host, and the same
     * file and fragment of the file.<p>
     *
     * Two hosts are considered equivalent if both host names can be resolved
     * into the same IP addresses; else if either host name can't be
     * resolved, the host names must be equal without regard to case; or both
     * host names equal to null.<p>
     *
     * Since hosts comparison requires name resolution, this operation is a
     * blocking operation. <p>
     *
     * Note: The defined behavior for {@code equals} is known to
     * be inconsistent with virtual hosting in HTTP.
     *
     * @param   obj   the URL to compare against.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    public boolean equals(Object obj) {
    	return instance.equals(obj);
    }
    
    /**
     * Creates an integer suitable for hash table indexing.<p>
     *
     * The hash code is based upon all the URL components relevant for URL
     * comparison. As such, this operation is a blocking operation.<p>
     *
     * @return  a hash code for this {@code URL}.
     */
    public synchronized int hashCode() {
    	return instance.hashCode();
    }
    
    /**
     * Constructs a string representation of this {@code URL}. The
     * string is created by calling the {@code toExternalForm}
     * method of the stream protocol handler for this object.
     *
     * @return  a string representation of this object.
     * @see     java.net.URL#URL(java.lang.String, java.lang.String, int,
     *                  java.lang.String)
     * @see     java.net.URLStreamHandler#toExternalForm(java.net.URL)
     */
    public String toString() {
        return instance.toString();
    }

	@Override
	public String getAuthority() {
		return instance.getAuthority();
	}

	@Override
	public Object getContent() throws IOException {
		return instance.getContent();
	}

	@Override
	public int getDefaultPort() {
		return instance.getDefaultPort();
	}

	@Override
	public String getFile() {
		return instance.getFile();
	}

	@Override
	public String getHost() {
		return instance.getHost();
	}

	@Override
	public String getPath() {
		return instance.getHost();
	}

	@Override
	public int getPort() {
		return instance.getPort();
	}

	@Override
	public String getProtocol() {
		return instance.getProtocol();
	}

	@Override
	public String getQuery() {
		return instance.getQuery();
	}

	@Override
	public String getRef() {
		return instance.getRef();
	}

	@Override
	public String getUserInfo() {
		return instance.getUserInfo();
	}

	@Override
	public boolean sameFile(hu.elte.txtuml.stdlib.net.URL other) {
		return instance.sameFile(other.toURL());
	}

	@Override
	public String toExternalForm() {
		return instance.toExternalForm();
	}

	@Override
	public hu.elte.txtuml.stdlib.net.URI toURI() throws URISyntaxException {
		return new URIImpl(instance.toURI());
	}

	@Override
	public java.net.URL toURL() {
		return instance;
	}

}
