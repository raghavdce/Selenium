package testNG;

import org.testng.annotations.Test;

public class TestGrouping {
  @Test(groups = "A")
  public void A() {
  }
  
  @Test (groups = "B", invocationCount=3)
  public void B() {
  }
  
  @Test (groups = {"A","C"}, priority=9, enabled = false)
  public void AC() {
  }
  
  @Test (groups = {"A","B"})
  public void AB() {
  }
  
  @Test(groups = "C")
  public void C1() {
  }
}
