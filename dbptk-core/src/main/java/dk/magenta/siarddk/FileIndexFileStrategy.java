/**
 * The methods should be called in this order from the SIARDDKMetadataExportStrategy
 * 1) getWriter
 * 2) generateXML 
 * 3) addFile (should not be called until writer obtained from getWriter is closed) 
 */
package dk.magenta.siarddk;

import java.io.OutputStream;
import java.nio.file.Path;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.databasepreservation.model.exception.ModuleException;
import com.databasepreservation.model.structure.DatabaseStructure;
import com.databasepreservation.modules.siard.common.SIARDArchiveContainer;
import com.databasepreservation.modules.siard.out.write.WriteStrategy;
import dk.magenta.siarddk.fileindex.FileIndexType;

/**
 * @author Andreas Kring <andreas@magenta.dk>
 *
 */
public class FileIndexFileStrategy implements IndexFileStrategy {

  // This is determined by the fileIndex schema
  private static final String SIARDDK_FILE_SEPERATOR = "\\";

  private MessageDigest messageDigest;
  private Map<String, byte[]> md5sums;
  private SIARDArchiveContainer outputContainer;

  public FileIndexFileStrategy(SIARDDKExportModule siarddkExportModule) {
    md5sums = new HashMap<String, byte[]>();
    outputContainer = null;
  }

  @Override
  public Object generateXML(DatabaseStructure dbStructure) throws ModuleException {

    Path baseContainer = outputContainer.getPath();
    int count = baseContainer.getNameCount();
    String foNbase = baseContainer.getName(count - 1).toString(); // e.g.
                                                                  // AVID.SA.19000.1

    FileIndexType fileIndexType = new FileIndexType();
    List<FileIndexType.F> fList = fileIndexType.getF();

    for (Map.Entry<String, byte[]> entry : md5sums.entrySet()) {

      // System.out.println(entry.getKey() + " " + entry.getValue());

      String path = entry.getKey();
      String[] splitPath = path.split(Constants.FILE_SEPARATOR);
      String fiN = splitPath[splitPath.length - 1];
      // System.out.println(fiN);

      StringBuilder pathBuilder = new StringBuilder();
      pathBuilder.append(foNbase).append(SIARDDK_FILE_SEPERATOR);
      for (int i = 0; i < splitPath.length - 2; i++) {
        pathBuilder.append(splitPath[i]).append(SIARDDK_FILE_SEPERATOR);
      }
      pathBuilder.append(splitPath[splitPath.length - 2]);
      String foN = pathBuilder.toString();
      // System.out.println(foN);

      FileIndexType.F f = new FileIndexType.F();
      f.setFoN(foN);
      f.setFiN(fiN);
      f.setMd5(entry.getValue());

      fList.add(f);
    }

    return fileIndexType;
  }

  public OutputStream getWriter(SIARDArchiveContainer outputContainer, String path, WriteStrategy writeStrategy)
    throws ModuleException {

    if (this.outputContainer == null) {
      this.outputContainer = outputContainer;
    }

    OutputStream writerFromWriteStrategy = writeStrategy.createOutputStream(outputContainer, path);
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return new DigestOutputStream(writerFromWriteStrategy, messageDigest);
  }

  /**
   * Adds file to archive.
   * 
   * @param path
   *          The path in the outputContainer (already has the correct format,
   *          since this method gets it from the MetadataPathStrategy)
   * @return md5sum of file Pre-condition: writer to calculate md5sum from
   *         should be finished and closed.
   */
  public void addFile(String path) {
    // Calculate md5sum
    byte[] digest = messageDigest.digest();
    // String md5sum = DatatypeConverter.printHexBinary(digest).toLowerCase();

    // Add file to map
    md5sums.put(path, digest);

    // return md5sum;
  }
}
