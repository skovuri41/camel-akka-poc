package org.surya.camel_akka.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "customerId", "refNo", "partId", "amount","validated" })
@XmlRootElement(name = "inputOrder")
public class InputOrder implements Serializable {

	@XmlElement(required = true)
	protected String customerId;
	@XmlElement(required = true)
	protected String refNo;
	@XmlElement(required = true)
	protected String partId;
	@XmlElement(required = true)
	protected String amount;
	@XmlElement
	protected boolean validated;

	/**
	 * Gets the value of the customerId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the value of the customerId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerId(String value) {
		this.customerId = value;
	}

	/**
	 * Gets the value of the refNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the value of the refNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefNo(String value) {
		this.refNo = value;
	}

	/**
	 * Gets the value of the partId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * Sets the value of the partId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartId(String value) {
		this.partId = value;
	}

	/**
	 * Gets the value of the amount property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAmount(String value) {
		this.amount = value;
	}
	
	
	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputOrder [customerId=").append(customerId)
				.append(", refNo=").append(refNo).append(", partId=")
				.append(partId).append(", amount=").append(amount)
				.append(", validated=").append(validated).append("]");
		return builder.toString();
	}


}
