package hu.elte.txtuml.stdlib.net;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import hu.elte.txtuml.api.model.external.ExternalClass;

/**
 * Represents a Uniform Resource Identifier (URI) reference.
 * java.net.URI wrapper for txtUML
 *
 * @author Valeh Hajiyev
 * @see java.net.URI
 */

public interface URI extends ExternalClass {
	
    /**
     * Returns the decoded authority component of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawAuthority() getRawAuthority} method except that all
     * sequences of escaped octets are <a href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded authority component of this URI,
     *          or {@code null} if the authority is undefined
     */
	String	getAuthority();
	
    /**
     * Returns the decoded fragment component of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawFragment() getRawFragment} method except that all
     * sequences of escaped octets are <a href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded fragment component of this URI,
     *          or {@code null} if the fragment is undefined
     */
	String	getFragment();
	
    /**
     * Returns the host component of this URI.
     *
     * <p> The host component of a URI, if defined, will have one of the
     * following forms: </p>
     *
     * <ul>
     *
     *   <li><p> A domain name consisting of one or more <i>labels</i>
     *   separated by period characters ({@code '.'}), optionally followed by
     *   a period character.  Each label consists of <i>alphanum</i> characters
     *   as well as hyphen characters ({@code '-'}), though hyphens never
     *   occur as the first or last characters in a label. The rightmost
     *   label of a domain name consisting of two or more labels, begins
     *   with an <i>alpha</i> character. </li>
     *
     *   <li><p> A dotted-quad IPv4 address of the form
     *   <i>digit</i>{@code +.}<i>digit</i>{@code +.}<i>digit</i>{@code +.}<i>digit</i>{@code +},
     *   where no <i>digit</i> sequence is longer than three characters and no
     *   sequence has a value larger than 255. </p></li>
     *
     *   <li><p> An IPv6 address enclosed in square brackets ({@code '['} and
     *   {@code ']'}) and consisting of hexadecimal digits, colon characters
     *   ({@code ':'}), and possibly an embedded IPv4 address.  The full
     *   syntax of IPv6 addresses is specified in <a
     *   href="http://www.ietf.org/rfc/rfc2373.txt"><i>RFC&nbsp;2373: IPv6
     *   Addressing Architecture</i></a>.  </p></li>
     *
     * </ul>
     *
     * The host component of a URI cannot contain escaped octets, hence this
     * method does not perform any decoding.
     *
     * @return  The host component of this URI,
     *          or {@code null} if the host is undefined
     */
	String	getHost();
	
    /**
     * Returns the decoded path component of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawPath() getRawPath} method except that all sequences of
     * escaped octets are <a href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded path component of this URI,
     *          or {@code null} if the path is undefined
     */
	String	getPath();
	
    /**
     * Returns the port number of this URI.
     *
     * <p> The port component of a URI, if defined, is a non-negative
     * integer. </p>
     *
     * @return  The port component of this URI,
     *          or {@code -1} if the port is undefined
     */
	int	getPort();
	
    /**
     * Returns the decoded query component of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawQuery() getRawQuery} method except that all sequences of
     * escaped octets are <a href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded query component of this URI,
     *          or {@code null} if the query is undefined
     */
	String	getQuery();
	
    /**
     * Returns the raw authority component of this URI.
     *
     * <p> The authority component of a URI, if defined, only contains the
     * commercial-at character ({@code '@'}) and characters in the
     * <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, and <i>other</i>
     * categories.  If the authority is server-based then it is further
     * constrained to have valid user-information, host, and port
     * components. </p>
     *
     * @return  The raw authority component of this URI,
     *          or {@code null} if the authority is undefined
     */
	String	getRawAuthority();
	
    /**
     * Returns the raw fragment component of this URI.
     *
     * <p> The fragment component of a URI, if defined, only contains legal URI
     * characters. </p>
     *
     * @return  The raw fragment component of this URI,
     *          or {@code null} if the fragment is undefined
     */
	String	getRawFragment();
	
    /**
     * Returns the raw path component of this URI.
     *
     * <p> The path component of a URI, if defined, only contains the slash
     * character ({@code '/'}), the commercial-at character ({@code '@'}),
     * and characters in the <i>unreserved</i>, <i>punct</i>, <i>escaped</i>,
     * and <i>other</i> categories. </p>
     *
     * @return  The path component of this URI,
     *          or {@code null} if the path is undefined
     */
	String	getRawPath();
	
    /**
     * Returns the raw query component of this URI.
     *
     * <p> The query component of a URI, if defined, only contains legal URI
     * characters. </p>
     *
     * @return  The raw query component of this URI,
     *          or {@code null} if the query is undefined
     */
	String	getRawQuery();
	
    /**
     * Returns the raw scheme-specific part of this URI.  The scheme-specific
     * part is never undefined, though it may be empty.
     *
     * <p> The scheme-specific part of a URI only contains legal URI
     * characters. </p>
     *
     * @return  The raw scheme-specific part of this URI
     *          (never {@code null})
     */
	String	getRawSchemeSpecificPart();
	
    /**
     * Returns the raw user-information component of this URI.
     *
     * <p> The user-information component of a URI, if defined, only contains
     * characters in the <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, and
     * <i>other</i> categories. </p>
     *
     * @return  The raw user-information component of this URI,
     *          or {@code null} if the user information is undefined
     */
	String	getRawUserInfo();
	
    /**
     * Returns the scheme component of this URI.
     *
     * <p> The scheme component of a URI, if defined, only contains characters
     * in the <i>alphanum</i> category and in the string {@code "-.+"}.  A
     * scheme always starts with an <i>alpha</i> character. <p>
     *
     * The scheme component of a URI cannot contain escaped octets, hence this
     * method does not perform any decoding.
     *
     * @return  The scheme component of this URI,
     *          or {@code null} if the scheme is undefined
     */
	String	getScheme();
	
    /**
     * Returns the decoded scheme-specific part of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawSchemeSpecificPart() getRawSchemeSpecificPart} method
     * except that all sequences of escaped octets are <a
     * href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded scheme-specific part of this URI
     *          (never {@code null})
     */
	String	getSchemeSpecificPart();
	
    /**
     * Returns the decoded user-information component of this URI.
     *
     * <p> The string returned by this method is equal to that returned by the
     * {@link #getRawUserInfo() getRawUserInfo} method except that all
     * sequences of escaped octets are <a href="#decode">decoded</a>.  </p>
     *
     * @return  The decoded user-information component of this URI,
     *          or {@code null} if the user information is undefined
     */
	String	getUserInfo();

    /**
     * Tells whether or not this URI is absolute.
     *
     * <p> A URI is absolute if, and only if, it has a scheme component. </p>
     *
     * @return  {@code true} if, and only if, this URI is absolute
     */
	boolean	isAbsolute();
	
    /**
     * Tells whether or not this URI is opaque.
     *
     * <p> A URI is opaque if, and only if, it is absolute and its
     * scheme-specific part does not begin with a slash character ('/').
     * An opaque URI has a scheme, a scheme-specific part, and possibly
     * a fragment; all other components are undefined. </p>
     *
     * @return  {@code true} if, and only if, this URI is opaque
     */
	boolean	isOpaque();
	
    /**
     * Normalizes this URI's path.
     *
     * <p> If this URI is opaque, or if its path is already in normal form,
     * then this URI is returned.  Otherwise a new URI is constructed that is
     * identical to this URI except that its path is computed by normalizing
     * this URI's path in a manner consistent with <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;6, sub-steps&nbsp;c through&nbsp;f; that is:
     * </p>
     *
     * <ol>
     *
     *   <li><p> All {@code "."} segments are removed. </p></li>
     *
     *   <li><p> If a {@code ".."} segment is preceded by a non-{@code ".."}
     *   segment then both of these segments are removed.  This step is
     *   repeated until it is no longer applicable. </p></li>
     *
     *   <li><p> If the path is relative, and if its first segment contains a
     *   colon character ({@code ':'}), then a {@code "."} segment is
     *   prepended.  This prevents a relative URI with a path such as
     *   {@code "a:b/c/d"} from later being re-parsed as an opaque URI with a
     *   scheme of {@code "a"} and a scheme-specific part of {@code "b/c/d"}.
     *   <b><i>(Deviation from RFC&nbsp;2396)</i></b> </p></li>
     *
     * </ol>
     *
     * <p> A normalized path will begin with one or more {@code ".."} segments
     * if there were insufficient non-{@code ".."} segments preceding them to
     * allow their removal.  A normalized path will begin with a {@code "."}
     * segment if one was inserted by step 3 above.  Otherwise, a normalized
     * path will not contain any {@code "."} or {@code ".."} segments. </p>
     *
     * @return  A URI equivalent to this URI,
     *          but whose path is in normal form
     */
	URI	normalize();
	
    /**
     * Attempts to parse this URI's authority component, if defined, into
     * user-information, host, and port components.
     *
     * <p> If this URI's authority component has already been recognized as
     * being server-based then it will already have been parsed into
     * user-information, host, and port components.  In this case, or if this
     * URI has no authority component, this method simply returns this URI.
     *
     * <p> Otherwise this method attempts once more to parse the authority
     * component into user-information, host, and port components, and throws
     * an exception describing why the authority component could not be parsed
     * in that way.
     *
     * <p> This method is provided because the generic URI syntax specified in
     * <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>
     * cannot always distinguish a malformed server-based authority from a
     * legitimate registry-based authority.  It must therefore treat some
     * instances of the former as instances of the latter.  The authority
     * component in the URI string {@code "//foo:bar"}, for example, is not a
     * legal server-based authority but it is legal as a registry-based
     * authority.
     *
     * <p> In many common situations, for example when working URIs that are
     * known to be either URNs or URLs, the hierarchical URIs being used will
     * always be server-based.  They therefore must either be parsed as such or
     * treated as an error.  In these cases a statement such as
     *
     * <blockquote>
     * {@code URI }<i>u</i>{@code  = new URI(str).parseServerAuthority();}
     * </blockquote>
     *
     * <p> can be used to ensure that <i>u</i> always refers to a URI that, if
     * it has an authority component, has a server-based authority with proper
     * user-information, host, and port components.  Invoking this method also
     * ensures that if the authority could not be parsed in that way then an
     * appropriate diagnostic message can be issued based upon the exception
     * that is thrown. </p>
     *
     * @return  A URI whose authority field has been parsed
     *          as a server-based authority
     *
     * @throws  URISyntaxException
     *          If the authority component of this URI is defined
     *          but cannot be parsed as a server-based authority
     *          according to RFC&nbsp;2396
     */
	URI	parseServerAuthority() throws URISyntaxException;
	
    /**
     * Relativizes the given URI against this URI.
     *
     * <p> The relativization of the given URI against this URI is computed as
     * follows: </p>
     *
     * <ol>
     *
     *   <li><p> If either this URI or the given URI are opaque, or if the
     *   scheme and authority components of the two URIs are not identical, or
     *   if the path of this URI is not a prefix of the path of the given URI,
     *   then the given URI is returned. </p></li>
     *
     *   <li><p> Otherwise a new relative hierarchical URI is constructed with
     *   query and fragment components taken from the given URI and with a path
     *   component computed by removing this URI's path from the beginning of
     *   the given URI's path. </p></li>
     *
     * </ol>
     *
     * @param  uri  The URI to be relativized against this URI
     * @return The resulting URI
     *
     * @throws  NullPointerException
     *          If {@code uri} is {@code null}
     */
	URI	relativize(URI uri);
	
    /**
     * Constructs a new URI by parsing the given string and then resolving it
     * against this URI.
     *
     * <p> This convenience method works as if invoking it were equivalent to
     * evaluating the expression {@link #resolve(java.net.URI)
     * resolve}{@code (URI.}{@link #create(String) create}{@code (str))}. </p>
     *
     * @param  str   The string to be parsed into a URI
     * @return The resulting URI
     *
     * @throws  NullPointerException
     *          If {@code str} is {@code null}
     *
     * @throws  IllegalArgumentException
     *          If the given string violates RFC&nbsp;2396
     */
	URI	resolve(String str);
	
    /**
     * Resolves the given URI against this URI.
     *
     * <p> If the given URI is already absolute, or if this URI is opaque, then
     * the given URI is returned.
     *
     * <p><a name="resolve-frag"></a> If the given URI's fragment component is
     * defined, its path component is empty, and its scheme, authority, and
     * query components are undefined, then a URI with the given fragment but
     * with all other components equal to those of this URI is returned.  This
     * allows a URI representing a standalone fragment reference, such as
     * {@code "#foo"}, to be usefully resolved against a base URI.
     *
     * <p> Otherwise this method constructs a new hierarchical URI in a manner
     * consistent with <a
     * href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2; that is: </p>
     *
     * <ol>
     *
     *   <li><p> A new URI is constructed with this URI's scheme and the given
     *   URI's query and fragment components. </p></li>
     *
     *   <li><p> If the given URI has an authority component then the new URI's
     *   authority and path are taken from the given URI. </p></li>
     *
     *   <li><p> Otherwise the new URI's authority component is copied from
     *   this URI, and its path is computed as follows: </p>
     *
     *   <ol>
     *
     *     <li><p> If the given URI's path is absolute then the new URI's path
     *     is taken from the given URI. </p></li>
     *
     *     <li><p> Otherwise the given URI's path is relative, and so the new
     *     URI's path is computed by resolving the path of the given URI
     *     against the path of this URI.  This is done by concatenating all but
     *     the last segment of this URI's path, if any, with the given URI's
     *     path and then normalizing the result as if by invoking the {@link
     *     #normalize() normalize} method. </p></li>
     *
     *   </ol></li>
     *
     * </ol>
     *
     * <p> The result of this method is absolute if, and only if, either this
     * URI is absolute or the given URI is absolute.  </p>
     *
     * @param  uri  The URI to be resolved against this URI
     * @return The resulting URI
     *
     * @throws  NullPointerException
     *          If {@code uri} is {@code null}
     */
	URI	resolve(URI uri);
	
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
	String toASCIIString();
	
    /**
     * Constructs a URL from this URI.
     *
     * <p> This convenience method works as if invoking it were equivalent to
     * evaluating the expression {@code new URL(this.toString())} after
     * first checking that this URI is absolute. </p>
     *
     * @return  A URL constructed from this URI
     *
     * @throws  IllegalArgumentException
     *          If this URL is not absolute
     *
     * @throws  MalformedURLException
     *          If a protocol handler for the URL could not be found,
     *          or if some other error occurred while constructing the URL
     */
	URL	toURL() throws MalformedURLException;
	
    /**
     * Returns a java.net.URL instance.
     *
     * @return  a java.net.URL instance.
     */
	java.net.URI toURI();
	
    /**
     * Tests this URI for equality with URI object.
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
     * @param   uri   The URI object to which this object is to be compared
     *
     * @return  {@code true} if, and only if, the given object is a URI that
     *          is identical to this URI
     */
	boolean equals(URI uri);

}
