//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.12 at 01:58:46 PM CEST 
//

package dk.sa.xmlns.diark._1_0.fileindex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Index for all files in the information package
 * 
 * <p>
 * Java class for fileIndexType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="fileIndexType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded"&gt;
 *         &lt;element name="f"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="foN" type="{http://www.sa.dk/xmlns/diark/1.0}folderNameType"/&gt;
 *                   &lt;element name="fiN" type="{http://www.sa.dk/xmlns/diark/1.0}fileNameType"/&gt;
 *                   &lt;element name="md5" type="{http://www.sa.dk/xmlns/diark/1.0}checkSumType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileIndexType", propOrder = {"f"})
@XmlRootElement(name = "fileIndex")
public class FileIndexType {

  @XmlElement(required = true)
  protected List<FileIndexType.F> f;

  /**
   * Gets the value of the f property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the f property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getF().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link FileIndexType.F }
   * 
   * 
   */
  public List<FileIndexType.F> getF() {
    if (f == null) {
      f = new ArrayList<FileIndexType.F>();
    }
    return this.f;
  }

  /**
   * <p>
   * Java class for anonymous complex type.
   * 
   * <p>
   * The following schema fragment specifies the expected content contained
   * within this class.
   * 
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="foN" type="{http://www.sa.dk/xmlns/diark/1.0}folderNameType"/&gt;
   *         &lt;element name="fiN" type="{http://www.sa.dk/xmlns/diark/1.0}fileNameType"/&gt;
   *         &lt;element name="md5" type="{http://www.sa.dk/xmlns/diark/1.0}checkSumType"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   * 
   * 
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {"foN", "fiN", "md5"})
  public static class F {

    @XmlElement(required = true)
    protected String foN;
    @XmlElement(required = true)
    protected String fiN;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] md5;

    /**
     * Gets the value of the foN property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFoN() {
      return foN;
    }

    /**
     * Sets the value of the foN property.
     * 
     * @param value
     *          allowed object is {@link String }
     * 
     */
    public void setFoN(String value) {
      this.foN = value;
    }

    /**
     * Gets the value of the fiN property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFiN() {
      return fiN;
    }

    /**
     * Sets the value of the fiN property.
     * 
     * @param value
     *          allowed object is {@link String }
     * 
     */
    public void setFiN(String value) {
      this.fiN = value;
    }

    /**
     * Gets the value of the md5 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public byte[] getMd5() {
      return md5;
    }

    /**
     * Sets the value of the md5 property.
     * 
     * @param value
     *          allowed object is {@link String }
     * 
     */
    public void setMd5(byte[] value) {
      this.md5 = value;
    }

  }

}
