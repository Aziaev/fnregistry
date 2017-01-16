
package unisoft.ws.innfiodr.query.rs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="»д«апрос‘">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name=" одќбр">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="2"/>
 *               &lt;enumeration value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="¬ерс‘орм" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="5"/>
 *             &lt;enumeration value="4.01"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "\u0438\u0434\u0417\u0430\u043f\u0440\u043e\u0441\u0424",
    "\u043a\u043e\u0434\u041e\u0431\u0440"
})
@XmlRootElement(name = "\u0414\u043e\u043a\u0443\u043c\u0435\u043d\u0442")
public class ƒокумент {

    @XmlElement(name = "\u0418\u0434\u0417\u0430\u043f\u0440\u043e\u0441\u0424")
    protected BigInteger ид«апрос‘;
    @XmlElement(name = "\u041a\u043e\u0434\u041e\u0431\u0440")
    protected String кодќбр;
    @XmlAttribute(name = "\u0412\u0435\u0440\u0441\u0424\u043e\u0440\u043c", required = true)
    protected String верс‘орм;

    /**
     * Gets the value of the ид«апрос‘ property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger get»д«апрос‘() {
        return ид«апрос‘;
    }

    /**
     * Sets the value of the ид«апрос‘ property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void set»д«апрос‘(BigInteger value) {
        this.ид«апрос‘ = value;
    }

    /**
     * Gets the value of the кодќбр property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get одќбр() {
        return кодќбр;
    }

    /**
     * Sets the value of the кодќбр property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set одќбр(String value) {
        this.кодќбр = value;
    }

    /**
     * Gets the value of the верс‘орм property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get¬ерс‘орм() {
        return верс‘орм;
    }

    /**
     * Sets the value of the верс‘орм property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set¬ерс‘орм(String value) {
        this.верс‘орм = value;
    }

}
