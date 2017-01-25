package org.thrx.service.base.api;

import java.util.ArrayList;
import java.util.List;

public abstract class ResultBase {
   private List<String> error = new ArrayList<String>();

   public List<String> getError() {
      return error;
   }

   public void setError(List<String> error) {
      this.error = error;
   }
   public void addError(String string, Exception e) {
      this.error.add(string +" -- "+e.getMessage());
   }
   public void addError(String string) {
      this.error.add(string);
   }
   
   public void addError(Exception e) {
      this.error.add(" -- "+e.getMessage());
   }

}
