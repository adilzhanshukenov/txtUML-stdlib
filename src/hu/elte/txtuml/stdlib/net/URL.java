package hu.elte.txtuml.stdlib.net;

import java.io.IOException;
import java.net.URISyntaxException;

import hu.elte.txtuml.api.model.external.ExternalClass;

/**
 * Interface {@code URL} represents a Uniform Resource
 * Locator, a pointer to a "resource" on the World
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
public interface URL extends ExternalClass {
	
    /**
     * Gets the authority part of this {@code URL}.
     *
     * @return  the authority part of this {@code URL}
     */
	String getAuthority();
	
    /**
     * Gets the contents of this URL. This method is a shorthand for:
     * <blockquote><pre>
     *     openConnection().getContent()
     * </pre></blockquote>
     *
     * @return     the contents of this URL.
     * @exception  IOException  if an I/O exception occurs.
     * @see        java.net.URLConnection#getContent()
     */
	Object getContent() throws IOException;
	
    /**
     * Gets the default port number of the protocol associated
     * with this {@code URL}. If the URL scheme or the URLStreamHandler
     * for the URL do not define a default port number,
     * then -1 is returned.
     *
     * @return  the port number
     */
	int	getDefaultPort();
	
    /**
     * Gets the file name of this {@code URL}.
     * The returned file portion will be
     * the same as <CODE>getPath()</CODE>, plus the concatenation of
     * the value of <CODE>getQuery()</CODE>, if any. If there is
     * no query portion, this method and <CODE>getPath()</CODE> will
     * return identical results.
     *
     * @return  the file name of this {@code URL},
     * or an empty string if one does not exist
     */
	String getFile();
	
    /**
     * Gets the host name of this {@code URL}, if applicable.
     * The format of the host conforms to RFC 2732, i.e. for a
     * literal IPv6 address, this method will return the IPv6 address
     * enclosed in square brackets ({@code '['} and {@code ']'}).
     *
     * @return  the host name of this {@code URL}.
     */
	String getHost();
	
    /**
     * Gets the path part of this {@code URL}.
     *
     * @return  the path part of this {@code URL}, or an
     * empty string if one does not exist
     */
	String getPath();
	
    /**
     * Gets the port number of this {@code URL}.
     *
     * @return  the port number, or -1 if the port is not set
     */
	int getPort();
	
    /**
     * Gets the protocol name of this {@code URL}.
     *
     * @return  the protocol of this {@code URL}.
     */
	String getProtocol();
	
    /**
     * Gets the query part of this {@code URL}.
     *
     * @return  the query part of this {@code URL},
     * or <CODE>null</CODE> if one does not exist
     */
	String getQuery();
	
    /**
     * Gets the anchor (also known as the "reference") of this
     * {@code URL}.
     *
     * @return  the anchor (also known as the "reference") of this
     *          {@code URL}, or <CODE>null</CODE> if one does not exist
     */
	String getRef();
	
    /**
     * Gets the userInfo part of this {@code URL}.
     *
     * @return  the userInfo part of this {@code URL}, or
     * <CODE>null</CODE> if one does not exist
     */
	String getUserInfo();
	
    /**
     * Compares two URLs, excluding the fragment component.<p>
     *
     * Returns {@code true} if this {@code URL} and the
     * {@code other} argument are equal without taking the
     * fragment component into consideration.
     *
     * @param   other   the {@code URL} to compare against.
     * @return  {@code true} if they reference the same remote object;
     *          {@code false} otherwise.
     */
	boolean sameFile(URL other);
	
    /**
     * Constructs a string representation of this {@code URL}. The
     * string is created by calling the {@code toExternalForm}
     * method of the stream protocol handler for this object.
     *
     * @return  a string representation of this object.
     * @see     java.net.URL#URL(java.lang.String, java.lang.String,
     *                  int, java.lang.String)
     * @see     java.net.URLStreamHandler#toExternalForm(java.net.URL)
     */
	String toExternalForm();
	
    /**
     * Returns a {@link URI} equivalent to this URL.
     * This method functions in the same way as {@code new URI (this.toString())}.
     * <p>Note, any URL instance that complies with RFC 2396 can be converted
     * to a URI. However, some URLs that are not strictly in compliance
     * can not be converted to a URI.
     *
     * @exception URISyntaxException if this URL is not formatted strictly according to
     *            to RFC2396 and cannot be converted to a URI.
     *
     * @return    a URI instance equivalent to this URL.
     */
	URI	toURI() throws URISyntaxException;
	
    /**
     * Returns a {@link java.net.URL} equivalent to this URL.
     *
     * @return    a java.net.URL instance equivalent to this URL.
     */
	java.net.URL toURL();
	
    /**
     * Compares this URL for equality with another URL object.<p>
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
     * @param   url   the URL to compare against.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    public boolean equals(URL url);
	
}
