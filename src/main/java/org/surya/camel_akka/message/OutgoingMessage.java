package org.surya.camel_akka.message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OutgoingMessage {

	private final MessageType msgType;
	private final String msg;
	private final String[] recipients;
	private Map<String, Object> headers;

	public OutgoingMessage(MessageType msgType, String msg,
			String... recipients) {
		super();
		this.msgType = msgType;
		this.msg = msg;
		this.recipients = recipients;
	}

	public MessageType getMsgType() {
		return msgType;
	}

	public String getMsg() {
		return msg;
	}

	public String[] getRecipients() {
		return recipients;
	}

	public Object getHeader(String name) {
		if (hasHeaders()) {
			return getHeaders().get(name);
		} else {
			return null;
		}
	}

	public Object getHeader(String name, Object defaultValue) {
		Object answer = getHeaders().get(name);
		return answer != null ? answer : defaultValue;
	}

	public void setHeader(String name, Object value) {
		if (headers == null) {
			headers = createHeaders();
		}
		headers.put(name, value);
	}

	public void setHeaders(Map<String, Object> headers) {
		if (headers instanceof HashMap) {
			this.headers = headers;
		} else {
			this.headers = new HashMap(headers);
		}
	}

	public Map<String, Object> getHeaders() {
		if (headers == null) {
			headers = createHeaders();
		}
		return headers;
	}

	public boolean hasHeaders() {
		if (!hasPopulatedHeaders()) {
			// force creating headers
			getHeaders();
		}
		return headers != null && !headers.isEmpty();
	}

	protected Map<String, Object> createHeaders() {
		Map<String, Object> map = new HashMap();
		return map;
	}

	/**
	 * Returns true if the headers have been mutated in some way
	 */
	protected boolean hasPopulatedHeaders() {
		return headers != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result + Arrays.hashCode(recipients);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutgoingMessage other = (OutgoingMessage) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (msgType != other.msgType)
			return false;
		if (!Arrays.equals(recipients, other.recipients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OutgoingMessage [msgType=" + msgType + ", msg=" + msg
				+ ", recipients=" + Arrays.toString(recipients) + "]";
	}

}
