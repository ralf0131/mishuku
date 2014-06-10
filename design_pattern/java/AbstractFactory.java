interface PCFactory {
  public CPU produceCPU();
  public Memory produceMemory();
}

class LenovoFactory implements PCFactory {
  public CPU produceCPU() {
    return new IntelCPU();
  }
  public Memory produceMemory() {
    return new TrancendMemory();
  }
}

class AcerFactory implements PCFactory {
  public CPU produceCPU() {
    return new AmdCPU();
  }
  public Memory produceMemory() {
    return new KingstonMemory();
  }
}

interface CPU {}

class IntelCPU implements CPU {}

class AmdCPU implements CPU {}

interface Memory {}

class KingstonMemory implements Memory {}
class TrancendMemory implements Memory {}

public class AbstractFactory {
  public static void main(String []args){
    PCFactory f = getFactory("lenovo");
    f.produceCPU();
    f.produceMemory();
  }

  public static PCFactory getFactory(String name) {
    if (name.equals("lenovo")) {
      return new LenovoFactory();
    } else if (name.equals("acer")) {
      return new AcerFactory();
    }
    return null;
  }
}
