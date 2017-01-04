package hu.elte.txtuml.stdlib.net;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


/**
 * Represents a Uniform Resource Identifier (URI) implementation.
 * java.net.URI wrapper for txtUML
 *
 * @author Valeh Hajiyev
 * @see java.net.URI
 */
public class URIImpl implements URI, Comparable<URI>, Serializable {

	private static final long serialVersionUID = -6323872838756598863L;
	
	private java.net.URI instance;
	
	  /**
     * Creates a {@code URI} object from the {@code java.net.URI}
     * representation.
     *
     * @param      a {@code java.net.URI} instance.
     */
	public URIImpl(java.net.URI uri) {
		this.instance = uri;
	}
	
    /**
     * Constructs a URI by parsing the given string.
     *
     * <p> This constructor parses the given string exactly as specified by the
     * grammar in <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * Appendix&nbsp;A, <b><i>except for the following deviations:</i></b> </p>
     *
     * <ul>
     *
     *   <li><p> An empty authority component is permitted as long as it is
     *   followed by a non-empty path, a query component, or a fragment
     *   component.  This allows the parsing of URIs such as
     *   {@code "file:///foo/bar"}, which seems to be the intent of
     *   RFC&nbsp;2396 although the grammar does not permit it.  If the
     *   authority component is empty then the user-information, host, and port
     *   components are undefined. </p></li>
     *
     *   <li><p> Empty relative paths are permitted; this seems to be the
     *   intent of RFC&nbsp;2396 although the grammar does not permit it.  The
     *   primary consequence of this deviation is that a standalone fragment
     *   such as {@code "#foo"} parses as a relative URI with an empty path
     *   and the given fragment, and can be usefully <a
     *   href="#resolve-frag">resolved</a> against a base URI.
     *
     *   <li><p> IPv4 addresses in host components are parsed rigorously, as
     *   specified by <a
     *   href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>: Each
     *   element of a dotted-quad address must contain no more than three
     *   decimal digits.  Each element is further constrained to have a value
     *   no greater than 255. </p></li>
     *
     *   <li> <p> Hostnames in host components that comprise only a single
     *   domain label are permitted to start with an <i>alphanum</i>
     *   character. This seems to be the intent of <a
     *   href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>
     *   section&nbsp;3.2.2 although the grammar does not permit it. The
     *   consequence of this deviation is that the authority component of a
     *   hierarchical URI such as {@code s://123}, will parse as a server-based
     *   authority. </p></li>
     *
     *   <li><p> IPv6 addresses are permitted for the host component.  An IPv6
     *   address must be enclosed in square brackets ({@code '['} and
     *   {@code ']'}) as specified by <a
     *   href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>.  The
     *   IPv6 address itself must parse according to <a
     *   href="http://www.ietf.org/rfc/rfc2373.txt">RFC&nbsp;2373</a>.  IPv6
     *   addresses are further constrained to describe no more than sixteen
     *   bytes of address information, a constraint implicit in RFC&nbsp;2373
     *   but not expressible in the grammar. </p></li>
     *
     *   <li><p> Characters in the <i>other</i> category are permitted wherever
     *   RFC&nbsp;2396 permits <i>escaped</i> octets, that is, in the
     *   user-information, path, query, and fragment components, as well as in
     *   the authority component if the authority is registry-based.  This
     *   allows URIs to contain Unicode characters beyond those in the US-ASCII
     *   character set. </p></li>
     *
     * </ul>
     *
     * @param  str   The string to be parsed into a URI
     *
     * @throws  NullPointerException
     *          If {@code str} is {@code null}
     *
     * @throws  URISyntaxException
     *          If the given string violates RFC&nbsp;2396, as augmented
     *          by the above deviations
     */
	public URIImpl(String str) throws URISyntaxException {
		this.instance = new java.net.URI(str);
	}
	
	
    /**
     * Constructs a URI from the given components.
     *
     * <p> A component may be left undefined by passing {@code null}.
     *
     * <p> This constructor first builds a URI in string form using the given
     * components as follows:  </p>
     *
     * <ol>
     *
     *   <li><p> Initially, the result string is empty.  </p></li>
     *
     *   <li><p> If a scheme is given then it is appended to the result,
     *   followed by a colon character ({@code ':'}).  </p></li>
     *
     *   <li><p> If a scheme-specific part is given then it is appended.  Any
     *   character that is not a <a href="#legal-chars">legal URI character</a>
     *   is <a href="#quote">quoted</a>.  </p></li>
     *
     *   <li><p> Finally, if a fragment is given then a hash character
     *   ({@code '#'}) is appended to the string, followed by the fragment.
     *   Any character that is not a legal URI character is quoted.  </p></li>
     *
     * </ol>
     *
     * <p> The resulting URI string is then parsed in order to create the new
     * URI instance as if by invoking the {@link #URI(String)} constructor;
     * this may cause a {@link URISyntaxException} to be thrown.  </p>
     *
     * @param   scheme    Scheme name
     * @param   ssp       Scheme-specific part
     * @param   fragment  Fragment
     *
     * @throws  URISyntaxException
     *          If the URI string constructed from the given components
     *          violates RFC&nbsp;2396
     */
	public URIImpl(String scheme, String ssp, String fragment) throws URISyntaxException {
		this.instance = new java.net.URI(scheme, ssp, fragment);
	}
	
    /**
     * Constructs a hierarchical URI from the given components.
     *
     * <p> If a scheme is given then the path, if also given, must either be
     * empty or begin with a slash character ({@code '/'}).  Otherwise a
     * component of the new URI may be left undefined by passing {@code null}
     * for the corresponding parameter or, in the case of the {@code port}
     * parameter, by passing {@code -1}.
     *
     * <p> This constructor first builds a URI string from the given components
     * according to the rules specified in <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;7: </p>
     *
     * <ol>
     *
     *   <li><p> Initially, the result string is empty. </p></li>
     *
     *   <li><p> If a scheme is given then it is appended to the result,
     *   followed by a colon character ({@code ':'}).  </p></li>
     *
     *   <li><p> If user information, a host, or a port are given then the
     *   string {@code "//"} is appended.  </p></li>
     *
     *   <li><p> If user information is given then it is appended, followed by
     *   a commercial-at character ({@code '@'}).  Any character not in the
     *   <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, or <i>other</i>
     *   categories is <a href="#quote">quoted</a>.  </p></li>
     *
     *   <li><p> If a host is given then it is appended.  If the host is a
     *   literal IPv6 address but is not enclosed in square brackets
     *   ({@code '['} and {@code ']'}) then the square brackets are added.
     *   </p></li>
     *
     *   <li><p> If a port number is given then a colon character
     *   ({@code ':'}) is appended, followed by the port number in decimal.
     *   </p></li>
     *
     *   <li><p> If a path is given then it is appended.  Any character not in
     *   the <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, or <i>other</i>
     *   categories, and not equal to the slash character ({@code '/'}) or the
     *   commercial-at character ({@code '@'}), is quoted.  </p></li>
     *
     *   <li><p> If a query is given then a question-mark character
     *   ({@code '?'}) is appended, followed by the query.  Any character that
     *   is not a <a href="#legal-chars">legal URI character</a> is quoted.
     *   </p></li>
     *
     *   <li><p> Finally, if a fragment is given then a hash character
     *   ({@code '#'}) is appended, followed by the fragment.  Any character
     *   that is not a legal URI character is quoted.  </p></li>
     *
     * </ol>
     *
     * <p> The resulting URI string is then parsed as if by invoking the {@link
     * #URI(String)} constructor and then invoking the {@link
     * #parseServerAuthority()} method upon the result; this may cause a {@link
     * URISyntaxException} to be thrown.  </p>
     *
     * @param   scheme    Scheme name
     * @param   userInfo  User name and authorization information
     * @param   host      Host name
     * @param   port      Port number
     * @param   path      Path
     * @param   query     Query
     * @param   fragment  Fragment
     *
     * @throws URISyntaxException
     *         If both a scheme and a path are given but the path is relative,
     *         if the URI string constructed from the given components violates
     *         RFC&nbsp;2396, or if the authority component of the string is
     *         present but cannot be parsed as a server-based authority
     */
	public URIImpl(String scheme, String userInfo, String host, int port, String path, String query, String fragment) throws URISyntaxException {
		this.instance = new java.net.URI(scheme, userInfo, host, port, path, query, fragment);
	}
	
    /**
     * Constructs a hierarchical URI from the given components.
     *
     * <p> A component may be left undefined by passing {@code null}.
     *
     * <p> This convenience constructor works as if by invoking the
     * seven-argument constructor as follows:
     *
     * <blockquote>
     * {@code new} {@link #URI(String, String, String, int, String, String, String)
     * URI}{@code (scheme, null, host, -1, path, null, fragment);}
     * </blockquote>
     *
     * @param   scheme    Scheme name
     * @param   host      Host name
     * @param   path      Path
     * @param   fragment  Fragment
     *
     * @throws  URISyntaxException
     *          If the URI string constructed from the given components
     *          violates RFC&nbsp;2396
     */
	public URIImpl(String scheme, String host, String path, String fragment) throws URISyntaxException {
		this.instance = new java.net.URI(scheme, host, path, fragment);
	}
	
    /**
     * Constructs a hierarchical URI from the given components.
     *
     * <p> If a scheme is given then the path, if also given, must either be
     * empty or begin with a slash character ({@code '/'}).  Otherwise a
     * component of the new URI may be left undefined by passing {@code null}
     * for the corresponding parameter.
     *
     * <p> This constructor first builds a URI string from the given components
     * according to the rules specified in <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;7: </p>
     *
     * <ol>
     *
     *   <li><p> Initially, the result string is empty.  </p></li>
     *
     *   <li><p> If a scheme is given then it is appended to the result,
     *   followed by a colon character ({@code ':'}).  </p></li>
     *
     *   <li><p> If an authority is given then the string {@code "//"} is
     *   appended, followed by the authority.  If the authority contains a
     *   literal IPv6 address then the address must be enclosed in square
     *   brackets ({@code '['} and {@code ']'}).  Any character not in the
     *   <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, or <i>other</i>
     *   categories, and not equal to the commercial-at character
     *   ({@code '@'}), is <a href="#quote">quoted</a>.  </p></li>
     *
     *   <li><p> If a path is given then it is appended.  Any character not in
     *   the <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, or <i>other</i>
     *   categories, and not equal to the slash character ({@code '/'}) or the
     *   commercial-at character ({@code '@'}), is quoted.  </p></li>
     *
     *   <li><p> If a query is given then a question-mark character
     *   ({@code '?'}) is appended, followed by the query.  Any character that
     *   is not a <a href="#legal-chars">legal URI character</a> is quoted.
     *   </p></li>
     *
     *   <li><p> Finally, if a fragment is given then a hash character
     *   ({@code '#'}) is appended, followed by the fragment.  Any character
     *   that is not a legal URI character is quoted.  </p></li>
     *
     * </ol>
     *
     * <p> The resulting URI string is then parsed as if by invoking the {@link
     * #URI(String)} constructor and then invoking the {@link
     * #parseServerAuthority()} method upon the result; this may cause a {@link
     * URISyntaxException} to be thrown.  </p>
     *
     * @param   scheme     Scheme name
     * @param   authority  Authority
     * @param   path       Path
     * @param   query      Query
     * @param   fragment   Fragment
     *
     * @throws URISyntaxException
     *         If both a scheme and a path are given but the path is relative,
     *         if the URI string constructed from the given components violates
     *         RFC&nbsp;2396, or if the authority component of the string is
     *         present but cannot be parsed as a server-based authority
     */
	public URIImpl(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException {
		this.instance = new java.net.URI(scheme, authority, path, query, fragment);
	}
	
    /**
     * Creates a URI by parsing the given string.
     *
     * <p> This convenience factory method works as if by invoking the {@link
     * #URI(String)} constructor; any {@link URISyntaxException} thrown by the
     * constructor is caught and wrapped in a new {@link
     * IllegalArgumentException} object, which is then thrown.
     *
     * <p> This method is provided for use in situations where it is known that
     * the given string is a legal URI, for example for URI constants declared
     * within in a program, and so it would be considered a programming error
     * for the string not to parse as such.  The constructors, which throw
     * {@link URISyntaxException} directly, should be used situations where a
     * URI is being constructed from user input or from some other source that
     * may be prone to errors.  </p>
     *
     * @param  str   The string to be parsed into a URI
     * @return The new URI
     *
     * @throws  NullPointerException
     *          If {@code str} is {@code null}
     *
     * @throws  IllegalArgumentException
     *          If the given string violates RFC&nbsp;2396
     */
    public static URI create(String str) {
        try {
            return new URIImpl(str);
        } catch (URISyntaxException x) {
            throw new IllegalArgumentException(x.getMessage(), x);
        }
    }
    
    /**
     * Tests this URI for equality with another object.
     *
     * <p> If the given object is not a URI then this method immediately
     * returns {@code false}.
     *
     * <p> For two URIs to be considered equal requires that either both are
     * opaque or both are hierarchical.  Their schemes must either both be
     * undefined or else be equal without regard to case. Their fragments
     * must either both be undefined or else be equal.
     *
     * <p> For two opaque URIs to be considered equal, their scheme-specific
     * parts must be equal.
     *
     * <p> For two hierarchical URIs to be considered equal, their paths must
     * be equal and their queries must either both be undefined or else be
     * equal.  Their authorities must either both be undefined, or both be
     * registry-based, or both be server-based.  If their authorities are
     * defined and are registry-based, then they must be equal.  If their
     * authorities are defined and are server-based, then their hosts must be
     * equal without regard to case, their port numbers must be equal, and
     * their user-information components must be equal.
     *
     * <p> When testing the user-information, path, query, fragment, authority,
     * or scheme-specific parts of two URIs for equality, the raw forms rather
     * than the encoded forms of these components are compared and the
     * hexadecimal digits of escaped octets are compared without regard to
     * case.
     *
     * <p> This method satisfies the general contract of the {@link
     * java.lang.Object#equals(Object) Object.equals} method. </p>
     *
     * @param   ob   The object to which this object is to be compared
     *
     * @return  {@code true} if, and only if, the given object is a URI that
     *          is identical to this URI
     */
    public boolean equals(Object ob) {
    	return instance.equals(ob);
    }
    
    /**
     * Returns a hash-code value for this URI.  The hash code is based upon all
     * of the URI's components, and satisfies the general contract of the
     * {@link java.lang.Object#hashCode() Object.hashCode} method.
     *
     * @return  A hash-code value for this URI
     */
    public int hashCode() {
    	return instance.hashCode();
    }
    
    /**
     * Compares this URI to another object, which must be a URI.
     *
     * <p> When comparing corresponding components of two URIs, if one
     * component is undefined but the other is defined then the first is
     * considered to be less than the second.  Unless otherwise noted, string
     * components are ordered according to their natural, case-sensitive
     * ordering as defined by the {@link java.lang.String#compareTo(Object)
     * String.compareTo} method.  String components that are subject to
     * encoding are compared by comparing their raw forms rather than their
     * encoded forms.
     *
     * <p> The ordering of URIs is defined as follows: </p>
     *
     * <ul>
     *
     *   <li><p> Two URIs with different schemes are ordered according the
     *   ordering of their schemes, without regard to case. </p></li>
     *
     *   <li><p> A hierarchical URI is considered to be less than an opaque URI
     *   with an identical scheme. </p></li>
     *
     *   <li><p> Two opaque URIs with identical schemes are ordered according
     *   to the ordering of their scheme-specific parts. </p></li>
     *
     *   <li><p> Two opaque URIs with identical schemes and scheme-specific
     *   parts are ordered according to the ordering of their
     *   fragments. </p></li>
     *
     *   <li><p> Two hierarchical URIs with identical schemes are ordered
     *   according to the ordering of their authority components: </p>
     *
     *   <ul>
     *
     *     <li><p> If both authority components are server-based then the URIs
     *     are ordered according to their user-information components; if these
     *     components are identical then the URIs are ordered according to the
     *     ordering of their hosts, without regard to case; if the hosts are
     *     identical then the URIs are ordered according to the ordering of
     *     their ports. </p></li>
     *
     *     <li><p> If one or both authority components are registry-based then
     *     the URIs are ordered according to the ordering of their authority
     *     components. </p></li>
     *
     *   </ul></li>
     *
     *   <li><p> Finally, two hierarchical URIs with identical schemes and
     *   authority components are ordered according to the ordering of their
     *   paths; if their paths are identical then they are ordered according to
     *   the ordering of their queries; if the queries are identical then they
     *   are ordered according to the order of their fragments. </p></li>
     *
     * </ul>
     *
     * <p> This method satisfies the general contract of the {@link
     * java.lang.Comparable#compareTo(Object) Comparable.compareTo}
     * method. </p>
     *
     * @param   that
     *          The object to which this URI is to be compared
     *
     * @return  A negative integer, zero, or a positive integer as this URI is
     *          less than, equal to, or greater than the given URI
     *
     * @throws  ClassCastException
     *          If the given object is not a URI
     */
	public int compareTo(URI that) {
		return instance.compareTo(that.toURI());
	}
	
    /**
     * Returns the content of this URI as a string.
     *
     * <p> If this URI was created by invoking one of the constructors in this
     * class then a string equivalent to the original input string, or to the
     * string computed from the originally-given components, as appropriate, is
     * returned.  Otherwise this URI was created by normalization, resolution,
     * or relativization, and so a string is constructed from this URI's
     * components according to the rules specified in <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;7. </p>
     *
     * @return  The string form of this URI
     */
    public String toString() {
        return instance.toString();
    }
    
    /**
     * Returns the content of this URI as a US-ASCII string.
     *
     * <p> If this URI does not contain any characters in the <i>other</i>
     * category then an invocation of this method will return the same value as
     * an invocation of the {@link #toString() toString} method.  Otherwise
     * this method works as if by invoking that method and then <a
     * href="#encode">encoding</a> the result.  </p>
     *
     * @return  The string form of this URI, encoded as needed
     *          so that it only contains characters in the US-ASCII
     *          charset
     */
    public String toASCIIString() {
    	return instance.toASCIIString();
    }

	@Override
	public String getAuthority() {
		return instance.getAuthority();
	}

	@Override
	public String getFragment() {
		return instance.getFragment();
	}

	@Override
	public String getHost() {
		return instance.getHost();
	}

	@Override
	public String getPath() {
		return instance.getPath();
	}

	@Override
	public int getPort() {
		return instance.getPort();
	}

	@Override
	public String getQuery() {
		return instance.getQuery();
	}

	@Override
	public String getRawAuthority() {
		return instance.getRawAuthority();
	}

	@Override
	public String getRawFragment() {
		return instance.getRawFragment();
	}

	@Override
	public String getRawPath() {
		return instance.getRawPath();
	}

	@Override
	public String getRawQuery() {
		return instance.getRawQuery();
	}

	@Override
	public String getRawSchemeSpecificPart() {
		return instance.getRawSchemeSpecificPart();
	}

	@Override
	public String getRawUserInfo() {
		return instance.getRawUserInfo();
	}

	@Override
	public String getScheme() {
		return instance.getScheme();
	}

	@Override
	public String getSchemeSpecificPart() {
		return instance.getSchemeSpecificPart();
	}

	@Override
	public String getUserInfo() {
		return instance.getUserInfo();
	}

	@Override
	public boolean isAbsolute() {
		return instance.isAbsolute();
	}

	@Override
	public boolean isOpaque() {
		return instance.isOpaque();
	}

	@Override
	public URI normalize() {
		return new URIImpl(instance.normalize());
	}

	@Override
	public URI parseServerAuthority() throws URISyntaxException {
		return new URIImpl(instance.parseServerAuthority());
	}

	@Override
	public URI relativize(URI uri) {
		return new URIImpl(instance.relativize(uri.toURI()));
	}

	@Override
	public URI resolve(String str) {
		return new URIImpl(instance.resolve(str));
	}

	@Override
	public URI resolve(URI uri) {
		return new URIImpl(instance.resolve(uri.toURI()));
	}

	@Override
	public URL toURL() throws MalformedURLException {
		return new URLImpl(instance.toURL());
	}

	@Override
	public java.net.URI toURI() {
		return instance;
	}
}
