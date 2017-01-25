package org.thrx.service.example.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * Class to acess the current version
 */
public class Version {

   private static final Log log = LogFactory.getLog(Version.class);
   private static Version version;
   
   public static Version getinstance(){
      if (null == version){
         version = new Version();
      }
      return version;
   }
   
   /**
    * getVersion
    * @return the maven pom version e.g. 2.00.01-SNAPSHOT
    */
   public String getVersion() {
      return getValueFromBuildVersion("VERSION");
   }

   public String getPomName() {
      return getValueFromBuildVersion("POMNAME");
   }

   /**
    * getBuildDate
    * @return unformatted ISo date without separator e.g 20090724
    */
   public String getBuildDate() {
      return getValueFromBuildVersion("BUILDDATE");
   }

   /**
    * getBuildTime
    * @return Unformatted Hour and minute e.g. 1312
    */
   public String getBuildTime() {
      return getValueFromBuildVersion("BUILDTIME");
   }

   /**
    * getBuildDay
    * @return e.g 01-Juli-2009
    */
   public String getBuildDay() {
      return getValueFromBuildVersion("BUILDDAY");
   }

   /**
    * getBuildUser
    * @return
    */
   public String getBuildUser() {
      return getValueFromBuildVersion("BUILDUSER");
   }

   /**
    * getValueFromBuildVersion
    * @param param
    * @return
    */
   private String getValueFromBuildVersion(String param) {
      Object result = null;
      try {
         Class<?> classtoinvoke = Class.forName(getPackageName()+".BuildVersion");
         Class<?> params[] = new Class[1];
         params[0] = String.class;
         java.lang.reflect.Method m = classtoinvoke.getMethod("getValue", params);
         result = m.invoke(null, new Object[]{param});
      } catch (Exception e) {
         log.warn("WARNING: BuildVersion.class not found: "+e);
      }
      if (result == null) {
         return "";
      } else {
         return result.toString();
      }
   }

   private String getPackageName() {
      return Version.class.getPackage().getName();
   }

}
