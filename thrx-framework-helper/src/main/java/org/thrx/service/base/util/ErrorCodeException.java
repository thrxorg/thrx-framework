package org.thrx.service.base.util;

public class ErrorCodeException extends RuntimeException {
   private static final long serialVersionUID = 3482127579562849163L;

   private String code;

   public ErrorCodeException(String code, String message) {
      super(message);
      this.code = code;
   }

   public ErrorCodeException(String code, String message, Throwable t) {
      super(message, t);
      this.code = code;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }
}
