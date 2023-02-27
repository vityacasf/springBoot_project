package socialnetwork.springboot.exceptionmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(final Exception exception) {
    final ModelAndView model = new ModelAndView();
    log.warn(exception.getMessage());
    model.addObject("message", "Unexpected error");
    model.setViewName("Error");
    return model;
  }
}
