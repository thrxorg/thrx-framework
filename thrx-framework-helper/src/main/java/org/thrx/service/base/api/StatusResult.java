package org.thrx.service.base.api;

public class StatusResult {
   private String status;
   private String version;
   private boolean snapshot;
   private String buildTime;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   public boolean isSnapshot() {
      return snapshot;
   }

   public void setSnapshot(boolean snapshot) {
      this.snapshot = snapshot;
   }

   public String getBuildTime() {
      return buildTime;
   }

   public void setBuildTime(String buildTime) {
      this.buildTime = buildTime;
   }

}
